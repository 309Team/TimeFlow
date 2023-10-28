package TimeFlow.service.impl.event;


import TimeFlow.mapper.event.ClassificationMapper;
import TimeFlow.pojo.TEClassification;
import TimeFlow.service.interf.event.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassificationServiceImp implements ClassificationService {

	@Autowired
	private ClassificationMapper CMapper;

	@Override
    public List<TEClassification> list(String tableName) {
		return CMapper.list(tableName);
	}

	@Override
    public void add(String tableName, TEClassification newCL) {
		CMapper.add(tableName, newCL);
	}

	@Override
	public void delete(String tableName, Integer id) {
		CMapper.delete(tableName, id);
	}
}
