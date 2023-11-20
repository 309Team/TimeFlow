package TimeFlow.mapper.event;

import TimeFlow.pojo.LabelEvent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface LabelEventMapper {
    List<LabelEvent> findAll(@Param("tableName") String tableName);

    List<LabelEvent> findByDate(@Param("date") LocalDate date, @Param("tableName") String tableName);

    long insert(@Param("tableName") String tableName, @Param("event") LabelEvent labelEvent);

    long delete(@Param("tableName") String tableName, @Param("eid") Integer eid);

    long update(@Param("tableName") String tableName, @Param("event") LabelEvent labelEvent);

    List<LabelEvent> CountLabelEventByMonth(@Param("date") LocalDate date, @Param("tableName") String tableName);
}
