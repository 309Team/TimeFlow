package TimeFlow.service.impl.classification;


import TimeFlow.mapper.classification.ClassCategoryMapper;
import TimeFlow.mapper.classification.ClassificationMapper;
import TimeFlow.pojo.TEClassification;
import TimeFlow.service.interf.classification.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassificationServiceImp implements ClassificationService {

	private final ClassificationMapper CMapper;

	private final ClassCategoryMapper classCategoryMapper;

	public ClassificationServiceImp(ClassificationMapper CMapper, ClassCategoryMapper classCategoryMapper) {
		this.CMapper = CMapper;
		this.classCategoryMapper = classCategoryMapper;
	}


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
