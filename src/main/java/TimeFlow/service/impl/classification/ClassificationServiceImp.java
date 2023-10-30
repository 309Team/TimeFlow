package TimeFlow.service.impl.classification;


import TimeFlow.mapper.classification.ClassCategoryMapper;
import TimeFlow.mapper.classification.ClassificationMapper;
import TimeFlow.pojo.TEClassification;
import TimeFlow.service.interf.classification.ClassificationService;
import TimeFlow.util.TableNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public void delete(Integer uid, Integer cid) {
		CMapper.delete(TableNameUtil.getTECLName(uid), cid);

		// 把中间表的关系删除
		classCategoryMapper.deleteByClassId(TableNameUtil.getMidTabName(uid), cid);
	}
}
