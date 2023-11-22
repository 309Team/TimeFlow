package TimeFlow.service.interf.event;


import TimeFlow.pojo.TimeEvent;

import java.util.List;

public interface TimeEventService {

    List<TimeEvent> list(String tableName, String dateSTR);

    void add(String tableName, TimeEvent newTE);

    void delete(Integer uid, Integer eid);

	void update(String tableName, TimeEvent newTE);

    List<TimeEvent> listByClass(Integer uid, List<Integer> cid);

	List<TimeEvent> getdaynum(String tableName, String dateSTR);

	List<TimeEvent> getmouthnum(String teName, String dateSTR);

}
