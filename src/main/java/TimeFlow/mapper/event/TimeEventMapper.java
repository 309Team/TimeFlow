package TimeFlow.mapper.event;

import TimeFlow.pojo.TimeEvent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TimeEventMapper {

	List<TimeEvent> list(String tableName, String date);

	void add(String tableName,TimeEvent newTE);

	void delete(String tableName, Integer id);

    void update(String tableName, TimeEvent newTE);

    List<TimeEvent> listById(@Param("tableName") String tableName, @Param("eid") List<Integer> eid);
}
