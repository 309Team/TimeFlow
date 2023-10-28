package TimeFlow.mapper.event;

import TimeFlow.pojo.MomentEvent;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Mapper
public interface MomentEventMapper {
//	@Select("select * from `0001momentevent`")
	List<MomentEvent> list(String tableName, String date);

	void add(String tableName,MomentEvent newME);

	void delete(String tableName, Integer id);

	void update(String tableName, MomentEvent newME);
}
