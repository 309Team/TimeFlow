package TimeFlow.mapper.event;

import TimeFlow.pojo.LabelEvent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LabelEventMapper {
    List<LabelEvent> findAll(@Param("tableName") String tableName);
}
