package TimeFlow.service.impl.event;


import TimeFlow.mapper.event.MomentEventMapper;
import TimeFlow.mapper.event.TimeEvenMapper;
import TimeFlow.pojo.TimeEvent;
import TimeFlow.service.interf.event.TimeEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeEventServiceImp implements TimeEventService {

	@Autowired
	private TimeEvenMapper TEMapper;

	@Override
	public List<TimeEvent> list(String tebleName, String dateSTR) {
		return TEMapper.list(tebleName, dateSTR);
	}

	@Override
	public void add(String tebleName, TimeEvent newTE) {
		TEMapper.add(tebleName, newTE);
	}

	@Override
	public void delete(String tebleName, Integer id) {
		TEMapper.delete(tebleName, id);
	}

	@Override
	public void update(String tableName, TimeEvent newTE) {
		TEMapper.updata(tableName, newTE);
	}
}
