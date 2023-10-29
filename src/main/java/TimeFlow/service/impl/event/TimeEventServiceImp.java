package TimeFlow.service.impl.event;


import TimeFlow.mapper.event.TimeEventMapper;
import TimeFlow.pojo.TimeEvent;
import TimeFlow.service.interf.event.TimeEventService;
import TimeFlow.util.TableNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeEventServiceImp implements TimeEventService {

	@Autowired
	private TimeEventMapper TEMapper;

	@Override
    public List<TimeEvent> list(String tableName, String dateSTR) {
        return TEMapper.list(tableName, dateSTR);
	}

	@Override
    public void add(String tableName, TimeEvent newTE) {
        TEMapper.add(tableName, newTE);
	}

	@Override
    public void delete(String tableName, Integer id) {
        TEMapper.delete(tableName, id);
	}

	@Override
	public void update(String tableName, TimeEvent newTE) {
		TEMapper.update(tableName, newTE);
	}

	@Override
	public List<TimeEvent> listByClass(Integer uid, List<Integer> cid) {
		return TEMapper.listById(TableNameUtil.getTEName(uid), cid);
	}

}
