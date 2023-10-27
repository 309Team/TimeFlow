package TimeFlow.mapper.event;

import TimeFlow.pojo.Classification;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassificationMapper {

	List<Classification> list(String tableName);


	void add(String tableName, Classification newCL);

	void delete(String tableName, Integer id);
}
