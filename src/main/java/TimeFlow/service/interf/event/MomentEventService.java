package TimeFlow.service.interf.event;


import TimeFlow.pojo.MomentEvent;

import java.time.LocalDate;
import java.util.List;

public interface MomentEventService {

	//根据日期查找时段事项
	List<MomentEvent> list(Integer uid, String date);

	//添加事项
	void add(Integer uid,MomentEvent newME);

	//删除事项
	void delete(Integer uid, Integer id);
}
