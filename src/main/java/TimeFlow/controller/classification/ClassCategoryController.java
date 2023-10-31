package TimeFlow.controller.classification;

import TimeFlow.config.GetUserId;
import TimeFlow.pojo.interact.Grouping;
import TimeFlow.pojo.interact.Result;
import TimeFlow.service.interf.classification.ClassCategoryService;
import TimeFlow.util.TableNameUtil;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * 中间表操作实体类
 * 根路径 ”/middle“
 * 对类操作请求路径 ”/class“
 * 对事项操作请求路径 "/event"
 */
@RestController
@RequestMapping("/grouping")
@CrossOrigin
public class ClassCategoryController {

    final
    ClassCategoryService classCategoryService;

    public ClassCategoryController(ClassCategoryService classCategoryService) {
        this.classCategoryService = classCategoryService;
    }

    /**
     * 从类中添加事项
     *
     * @param uid      用户id
     * @param grouping 添加类的id以及事项id列表
     * @return 是否成功
     */
    @PostMapping("/class")
    Result addEventsToClass(@GetUserId Integer uid, @RequestBody Grouping grouping) {
        long code = classCategoryService.addTEToCategory(uid, grouping.getId(), grouping.getList());
        return code == 0 ? Result.error("添加失败") : Result.success();
    }

    /**
     * 从类中删除事项
     *
     * @param uid      用户id
     * @param grouping 删除类的id以及事项id列表
     * @return 是否成功
     */
    @DeleteMapping("/class")
    Result deleteEventsToClass(@GetUserId Integer uid, @RequestBody Grouping grouping) {
        long code = classCategoryService.deleteTEFromCategory(uid, grouping.getId(), grouping.getList());
        return code == 0 ? Result.error("删除失败") : Result.success();
    }


//-----------------------------------------------------------------------------------------------------

    @PostMapping("/event")
    public Result addToClass(@GetUserId Integer uid, @RequestBody Grouping group) {
        classCategoryService.addToClass(TableNameUtil.getMidTabName(uid), group);
        return Result.success();
    }

    @DeleteMapping("/event")
    public Result deleteFromClass(@GetUserId Integer uid, @RequestBody Grouping group) {
        classCategoryService.deleteFromClass(TableNameUtil.getMidTabName(uid), group);
        return Result.success();
    }

    @GetMapping("/event")
    public Result listCLass(@GetUserId Integer uid, @RequestBody HashMap<String, Integer> m) {
        return Result.success(classCategoryService.listCLass(TableNameUtil.getMidTabName(uid), TableNameUtil.getTECLName(uid), m.get("id")));
    }


}
