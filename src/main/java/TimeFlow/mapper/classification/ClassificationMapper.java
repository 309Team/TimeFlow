package TimeFlow.mapper.classification;

import TimeFlow.pojo.TEClassification;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClassificationMapper {

	void createTable(@Param("tableName") String tableName);

	void dropTable(@Param("tableName") String tableName);
	List<TEClassification> list(String tableName);

	void add(String tableName, TEClassification newCL);

	void delete(String tableName, Integer id);
}
