package TimeFlow.service.interf.event;


import TimeFlow.pojo.TimeEvent;

import java.util.HashMap;
import java.util.List;

public interface TimeEventService {

    List<TimeEvent> list(String tableName, String dateSTR);

    void add(String tableName, TimeEvent newTE);

    void delete(Integer uid, Integer eid);

	void update(String tableName, TimeEvent newTE);

    List<TimeEvent> listByClass(Integer uid, List<Integer> cid);

    HashMap<String, Integer> getDayNum(String tableName, String dateSTR);

    HashMap<String, Integer> getMonthNum(String teName, String dateSTR);

}
