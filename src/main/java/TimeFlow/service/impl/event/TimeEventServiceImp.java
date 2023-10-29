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
		TEMapper.updata(tableName, newTE);
	}
}
