package TimeFlow.service.interf.event;


import TimeFlow.pojo.TimeEvent;

import java.util.List;

public interface TimeEventService {

    List<TimeEvent> list(String tableName, String dateSTR);

    void add(String tableName, TimeEvent newTE);

    void delete(String tableName, Integer id);

	void update(String tableName, TimeEvent newTE);
}
