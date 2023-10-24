package TimeFlow.mapper.event;

import TimeFlow.pojo.MomentEvent;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface MomentEventMapper {
//	@Select("select * from `0001momentevent`")
	List<MomentEvent> list(Integer id, String date);
}
