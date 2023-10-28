package TimeFlow.mapper.event;

import TimeFlow.pojo.TEClassification;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassificationMapper {

	List<TEClassification> list(String tableName);


	void add(String tableName, TEClassification newCL);

	void delete(String tableName, Integer id);
}
