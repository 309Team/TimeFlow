package TimeFlow.service.interf.classification;


import TimeFlow.pojo.Classification;

import java.util.List;

public interface ClassificationService {

    List<Classification> list(String tableName);

    void add(String tableName, Classification newCL);

    void delete(Integer uid, Integer cid);

	void update(String tableName, Classification newCL);

}
