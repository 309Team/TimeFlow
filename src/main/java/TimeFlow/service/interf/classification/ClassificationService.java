package TimeFlow.service.interf.classification;


import TimeFlow.pojo.TEClassification;

import java.util.List;

public interface ClassificationService {

    List<TEClassification> list(String tableName);

    void add(String tableName, TEClassification newCL);

    void delete(Integer uid, Integer cid);
}
