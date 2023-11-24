package TimeFlow.service.impl.event;


import TimeFlow.mapper.classification.ClassCategoryMapper;
import TimeFlow.mapper.event.TimeEventMapper;
import TimeFlow.pojo.TimeEvent;
import TimeFlow.service.interf.event.TimeEventService;
import TimeFlow.util.TableNameUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

@Service
public class TimeEventServiceImp implements TimeEventService {

	private final TimeEventMapper TEMapper;
	private final ClassCategoryMapper classCategoryMapper;

	public TimeEventServiceImp(TimeEventMapper TEMapper, ClassCategoryMapper classCategoryMapper) {
		this.TEMapper = TEMapper;
		this.classCategoryMapper = classCategoryMapper;
	}

	@Override
    public List<TimeEvent> list(String tableName, String dateSTR) {
        return TEMapper.list(tableName, dateSTR + " 23:59:59");
	}

	@Override
    public void add(String tableName, TimeEvent newTE) {
        TEMapper.add(tableName, newTE);
	}

	@Override
	@Transactional
	public void delete(Integer uid, Integer eid) {
		TEMapper.delete(TableNameUtil.getTEName(uid), eid);
		classCategoryMapper.deleteByEventId(TableNameUtil.getMidTabName(uid), eid);
	}

	@Override
	public void update(String tableName, TimeEvent newTE) {
		TEMapper.update(tableName, newTE);
	}

	@Override
	public List<TimeEvent> listByClass(Integer uid, List<Integer> cid) {
		return TEMapper.listById(TableNameUtil.getTEName(uid), cid);
	}

	private Integer getDayNumberByMonth(String dateSTR) {
		int[] monthDate = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String[] split = dateSTR.split("-");
		int year = Integer.parseInt(split[0]);
		if ((year % 100 == 0 && year % 400 == 0) || (year % 100 != 0 && year % 4 == 0))
			monthDate[1] = 29;

		return monthDate[Integer.parseInt(split[1]) - 1];
	}

	@Override
	public HashMap<String, Integer> getDayNum(String tableName, String dateSTR) {

		List<TimeEvent> events = TEMapper.getDayNum(tableName, dateSTR);
		HashMap<String, Integer> result = new HashMap<>();

		String[] split = dateSTR.split("-");
		Integer dayNumberByMonth = getDayNumberByMonth(dateSTR);
		for (int i = 1; i <= dayNumberByMonth; ++i) {
			String s = split[0] + '-' + split[1] + '-' + (i < 10 ? "0" + Integer.toString(i) : Integer.toString(i));
			LocalDate nowDate = LocalDate.parse(s);
			for (TimeEvent event : events) {
				LocalDate startTime = event.getStartTime().toLocalDate();
				LocalDate overTime = event.getOverTime().toLocalDate();

				if (!nowDate.isBefore(startTime) && !nowDate.isAfter(overTime)) {

					if (result.containsKey(s)) {
						result.put(s, result.get(s) + 1);
					} else {
						result.put(s, 1);
					}
				}
			}
		}
		return result;
	}

	@Override
	public HashMap<String, Integer> getMonthNum(String tableName, String dateSTR) {
		List<TimeEvent> events = TEMapper.getMonthNum(tableName, dateSTR);
		HashMap<String, Integer> result = new HashMap<>();
		String[] split = dateSTR.split("-");
		for (int i = 1; i <= 12; ++i) {
			String s = (i < 10 ? "0" + Integer.toString(i) : Integer.toString(i));
			for (TimeEvent event : events) {
				LocalDate startTime = event.getStartTime().toLocalDate();
				LocalDate overTime = event.getOverTime().toLocalDate();
				LocalDate firstOfMonth = LocalDate.parse(split[0] + '-' + s + '-' + "01");
				LocalDate lastOfMonth = LocalDate.parse(split[0] + '-' + s + '-' + getDayNumberByMonth(split[0] + '-' + s + '-' + "01").toString());
				if (!lastOfMonth.isBefore(startTime) && !firstOfMonth.isAfter(overTime)) {

					if (result.containsKey(Integer.toString(i))) {
						result.put(Integer.toString(i), result.get(Integer.toString(i)) + 1);
					} else {
						result.put(Integer.toString(i), 1);
					}
				}
			}
		}
		return result;
	}

	@Override
	public List<TimeEvent> getday(String tableName, String dateSTR) {
		return TEMapper.getday(tableName, dateSTR);
	}

}
