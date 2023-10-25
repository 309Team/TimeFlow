package TimeFlow.service.interf.event;


import TimeFlow.pojo.TimeEvent;

import java.util.List;

public interface TimeEventService {

	List<TimeEvent> list(String tebleName, String dateSTR);

	void add(String tebleName, TimeEvent newTE);

	void delete(String tebleName, Integer id);
}
