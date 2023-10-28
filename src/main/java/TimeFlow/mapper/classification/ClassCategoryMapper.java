package TimeFlow.mapper.classification;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ClassCategoryMapper {

    void createTable(@Param("tableName") String tableName);

    void dropTable(@Param("tableName") String tableName);

    void add(@Param("tableName") String tableName, @Param("eid") Integer eid, @Param("cid") Integer cid);

    long deleteByBoth(@Param("tableName") String tableName, @Param("eid") Integer eid, @Param("cid") Integer cid);

    long deleteByEventId(@Param("tableName") String tableName, @Param("eid") Integer eid);

    long deleteByClassId(@Param("tableName") String tableName, @Param("cid") Integer cid);
}
