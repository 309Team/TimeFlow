package TimeFlow.service.interf.event.classification;


import TimeFlow.pojo.TEClassification;

import java.util.List;

public interface ClassificationService {

    List<TEClassification> list(String tableName);

    void add(String tableName, TEClassification newCL);


	void delete(String tableName, Integer id);
}
