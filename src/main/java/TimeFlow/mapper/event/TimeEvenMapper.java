package TimeFlow.mapper.event;

import TimeFlow.pojo.MomentEvent;
import TimeFlow.pojo.TimeEvent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TimeEvenMapper {

	List<TimeEvent> list(String tableName, String date);

	void add(String tableName,TimeEvent newTE);

	void delete(String tableName, Integer id);


}
