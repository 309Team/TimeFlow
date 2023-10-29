package TimeFlow.service.impl.event;

import TimeFlow.mapper.event.MomentEventMapper;
import TimeFlow.pojo.MomentEvent;
import TimeFlow.pojo.interact.Grouping;
import TimeFlow.service.interf.event.MomentEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Service
public class MomentEventServiceImp implements MomentEventService {

	@Autowired
	private MomentEventMapper MEMapper;

	@Override
	public List<MomentEvent> list(String tableName, String date) {
		return MEMapper.list(tableName, date);
	}

	@Override
	public void add(String tableName,MomentEvent newME) {
		MEMapper.add(tableName ,newME);
		return;
	}

	@Override
	public void delete(String tableName, Integer id) {
		MEMapper.delete(tableName, id);
	}

	@Override
	public void update(String tableName, MomentEvent newME) {
		MEMapper.update(tableName, newME);
	}




}
