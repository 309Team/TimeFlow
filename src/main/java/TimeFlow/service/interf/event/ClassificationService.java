package TimeFlow.service.interf.event;


import TimeFlow.pojo.Classification;

import java.util.List;

public interface ClassificationService {

	List<Classification> list(String tableName);

	void add(String tableName, Classification newCL);


	void delete(String tableName, Integer id);
}
