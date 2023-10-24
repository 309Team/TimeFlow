package TimeFlow.service.impl.event;

import TimeFlow.mapper.event.MomentEventMapper;
import TimeFlow.pojo.MomentEvent;
import TimeFlow.service.interf.event.MomentEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MomentEventServiceImp implements MomentEventService {

	@Autowired
	private MomentEventMapper MEMapper;

	@Override
	public List<MomentEvent> list(Integer id, String date) {
		return MEMapper.list(id, date);
	}


}
