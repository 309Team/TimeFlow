package TimeFlow.service.interf.event;


import TimeFlow.pojo.MomentEvent;

import java.time.LocalDate;
import java.util.List;

public interface MomentEventService {

//	根据日期查找时段事项
	List<MomentEvent> list(Integer id, String date);
}
