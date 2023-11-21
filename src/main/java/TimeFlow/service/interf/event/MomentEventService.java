package TimeFlow.service.interf.event;


import TimeFlow.pojo.MomentEvent;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public interface MomentEventService {

	//根据日期查找时段事项
	List<MomentEvent> list(String tableName, String date);

	//添加事项
	void add(String tableName,MomentEvent newME);

	//删除事项
	void delete(String tableName, Integer id);

	void update(String tableName, MomentEvent newME);

	HashMap<String, Integer> countMomentEventByMonth(Integer uid, LocalDate date);

	HashMap<String, Integer> countMomentEventByYear(Integer uid, LocalDate date);
}
