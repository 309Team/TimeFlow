package TimeFlow.service.impl.statistic;

import TimeFlow.mapper.statistic.StatisticMapper;
import TimeFlow.pojo.Classification;
import TimeFlow.pojo.TimeEvent;
import TimeFlow.pojo.interact.ClassStatistic;
import TimeFlow.pojo.interact.EventStatistic;
import TimeFlow.service.interf.statistic.StatisticService;
import TimeFlow.util.TableNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class StatisticServiceImp implements StatisticService {

	@Autowired
	private StatisticMapper STAMapper;

	@Override
	public List<ClassStatistic> getClsStatistic(Integer uid, String startTime, String overTime) {
		String TECLName = TableNameUtil.getTECLName(uid);
		String TEName = TableNameUtil.getTEName(uid);
		String MidTabName = TableNameUtil.getMidTabName(uid);
		List<ClassStatistic> CSlist = new ArrayList<>();

		List<Classification> clslist = STAMapper.listclass(TECLName);
		for (Classification cls : clslist) {
			int duration = 0;
			List<TimeEvent> telist = STAMapper.listevent(TEName, MidTabName, startTime, overTime, cls.getId());
			for (TimeEvent evnt : telist) {
				if (STAMapper.findClass(MidTabName, evnt.getId(), cls.getId()) != null) {
					Duration e_d = Duration.between(evnt.getStartTime(), evnt.getOverTime());
					duration += (int) e_d.toMinutes();
				}
			}
			CSlist.add(new ClassStatistic(duration, cls));

//			List<TimeEvent> telist =  STAMapper.listevent(TableNameUtil.getTEName(uid), D.get("startTime"), D.get("overTime"));
//			for (TimeEvent te : telist) {
//				Duration te_duration = Duration.between(te.getStartTime(),te.getOverTime());
//				duration.plus(te_duration);
//			}
		}

		return CSlist;
	}

	@Override
	public List<EventStatistic> getEvtStatistic(Integer uid, String startTime, String overTime) {
		String TEName = TableNameUtil.getTEName(uid);

		List<TimeEvent> EVTlist = new ArrayList<>();
		EVTlist = STAMapper.findEvent(TEName,startTime,overTime);

		List<EventStatistic> EVTStalist = new ArrayList<>();

		for (TimeEvent te : EVTlist) {
			int dr = (int)Duration.between(te.getStartTime(), te.getOverTime()).toMinutes();
			EVTStalist.add(new EventStatistic(dr,te));
			}

		return EVTStalist;
	}
}
