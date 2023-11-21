package TimeFlow.mapper.event;

import TimeFlow.pojo.MomentEvent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface MomentEventMapper {
//	@Select("select * from `0001momentevent`")
	List<MomentEvent> list(String tableName, String date);

	void add(String tableName,MomentEvent newME);

	void delete(String tableName, Integer id);

	void update(String tableName, MomentEvent newME);

	List<MomentEvent> countMomentEventByMonth(@Param("date") LocalDate date, @Param("tableName") String tableName);

	List<MomentEvent> countMomentEventByYear(@Param("date") LocalDate date, @Param("tableName") String tableName);

}
