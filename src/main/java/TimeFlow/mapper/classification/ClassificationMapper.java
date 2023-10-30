package TimeFlow.mapper.classification;

import TimeFlow.pojo.Classification;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClassificationMapper {

	void createTable(@Param("tableName") String tableName);

	void dropTable(@Param("tableName") String tableName);

	List<Classification> list(String tableName);

	void add(String tableName, Classification newCL);

	void delete(String tableName, Integer id);
}
