package TimeFlow.mapper.classification;

import TimeFlow.pojo.ClassCategory;
import TimeFlow.pojo.TimeEvent;
import TimeFlow.pojo.interact.Grouping;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClassCategoryMapper {

    // 中间表建表
    void createTable(@Param("tableName") String tableName);

    // 中间表删表
    void dropTable(@Param("tableName") String tableName);

    // 往中间表添加数据
    void add(@Param("tableName") String tableName, @Param("eid") Integer eid, @Param("cid") Integer cid);

    // 根据两个关联数据删除记录
    long deleteByBoth(@Param("tableName") String tableName, @Param("eid") Integer eid, @Param("cid") Integer cid);

    // 删除一个事项的所有分类（一般用于事项的删除）
    long deleteByEventId(@Param("tableName") String tableName, @Param("eid") Integer eid);

    // 删除一个分类的所有事项（一般用于分类的删除）
    long deleteByClassId(@Param("tableName") String tableName, @Param("cid") Integer cid);

    // 通过分类查找所有事项
    List<Integer> findAllEventsByCid(@Param("tableName") String tableName, @Param("cid") Integer cid);

    // 通过事项查找所有分类
    List<Integer> findAllClassByEid(@Param("tableName") String tableName, @Param("cid") Integer eid);


    //-------------------------------------------------------------------------------
    void addToClass(String tableName, Integer id_event, Integer id_class);

    void deleteFromClass(String tableName, Integer id_event, Integer id_class);

    List<ClassCategory> listCLass(String tableName, Integer id);
}
