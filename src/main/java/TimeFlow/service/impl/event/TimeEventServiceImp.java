package TimeFlow.service.impl.event;


import TimeFlow.mapper.classification.ClassCategoryMapper;
import TimeFlow.mapper.event.TimeEventMapper;
import TimeFlow.pojo.TimeEvent;
import TimeFlow.service.interf.event.TimeEventService;
import TimeFlow.util.TableNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return TEMapper.list(tableName, dateSTR);
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

	@Override
	public List<TimeEvent> getdaynum(String tableName, String dateSTR) {
		return TEMapper.getdaynum(tableName, dateSTR);
	}

	@Override
	public List<TimeEvent> getmouthnum(String tableName, String dateSTR) {
		return TEMapper.getmouthnum(tableName, dateSTR);
	}

}
