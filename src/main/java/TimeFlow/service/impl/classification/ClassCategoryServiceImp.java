package TimeFlow.service.impl.classification;

import TimeFlow.mapper.classification.ClassCategoryMapper;
import TimeFlow.pojo.interact.Grouping;
import TimeFlow.service.interf.classification.ClassCategoryService;
import TimeFlow.util.TableNameUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClassCategoryServiceImp implements ClassCategoryService {

	private final ClassCategoryMapper classCategoryMapper;

	public ClassCategoryServiceImp(ClassCategoryMapper classCategoryMapper) {
		this.classCategoryMapper = classCategoryMapper;
	}

	/**
	 * 从分类中添加时段事项
	 *
	 * @param uid 用户id
	 * @param cid 分类id
	 * @param eid 事项id列表
	 * @return 成功的条数
	 */
	@Transactional
	@Override
	public long addTEToCategory(Integer uid, Integer cid, List<Integer> eid) {

		// 添加计数
		long cnt = 0;
		for (Integer e : eid) {
			classCategoryMapper.add(TableNameUtil.getMidTabName(uid), e, cid);
			cnt += 1;
		}

		return cnt;
	}

	/**
	 * 从分类中删除事项
	 *
	 * @param uid 用户id
	 * @param cid 分类id
	 * @param eid 事项id列表
	 * @return 成功的条数
	 */
	@Transactional
	@Override
	public long deleteTEFromCategory(Integer uid, Integer cid, List<Integer> eid) {

		long cnt = 0;
		for (var e : eid) {
			classCategoryMapper.deleteByBoth(TableNameUtil.getMidTabName(uid), e, cid);
			cnt += 1;
		}

		return cnt;
	}


	//-----------------------------------------------------------------------
	@Override
	public void addToClass(String tableName, Grouping group) {
		for (Integer id_class : group.getList()) {
			classCategoryMapper.addToClass(tableName, group.getId(), id_class);
		}
	}

	@Override
	public void deleteFromClass(String tableName, Grouping group) {
		for (Integer id_class : group.getList()) {
			classCategoryMapper.deleteFromClass(tableName, group.getId(), id_class);
		}
	}

	@Override
	public void listCLass(String midTabName, Object list) {
//		for (Integer:
//			 ) {
//
//		}
		;
	}


}
