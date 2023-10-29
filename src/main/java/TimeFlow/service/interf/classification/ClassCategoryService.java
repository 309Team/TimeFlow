package TimeFlow.service.interf.classification;

import java.util.List;

public interface ClassCategoryService {

    /**
     * 给分类添加时段事项
     *
     * @param uid 用户id
     * @param cid 分类id
     * @param eid 事项id列表
     * @return 成功条数
     */
    long addTEToCategory(Integer uid, Integer cid, List<Integer> eid);

    /**
     * 从分类删除时段事项
     *
     * @param uid 用户id
     * @param cid 分类id
     * @param eid 事项id列表
     * @return 删除成功条数
     */
    long deleteTEFromCategory(Integer uid, Integer cid, List<Integer> eid);


}
