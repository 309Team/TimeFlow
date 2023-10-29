package TimeFlow.controller.classification;

import TimeFlow.config.GetUserId;
import TimeFlow.pojo.interact.ClassAddEvents;
import TimeFlow.pojo.interact.Result;
import TimeFlow.service.interf.classification.ClassCategoryService;
import org.springframework.web.bind.annotation.*;

/**
 * 中间表操作实体类
 * 根路径 ”/middle“
 * 对类操作请求路径 ”/class“
 * 对事项操作请求路径 "/event"
 */
@RestController
@RequestMapping("/middle")
public class ClassCategoryController {
    //TODO

    final
    ClassCategoryService classCategoryService;

    public ClassCategoryController(ClassCategoryService classCategoryService) {
        this.classCategoryService = classCategoryService;
    }


    /**
     * 从类中添加事项
     *
     * @param uid            用户id
     * @param classAddEvents 添加类的id以及事项id列表
     * @return 是否成功
     */
    @PostMapping("/class")
    Result addEventsToClass(@GetUserId Integer uid, @RequestBody ClassAddEvents classAddEvents) {
        long code = classCategoryService.addTEToCategory(uid, classAddEvents.getId(), classAddEvents.getAddList());
        return code == 0 ? Result.error("添加失败") : Result.success();
    }

    /**
     * 从类中删除事项
     *
     * @param uid            用户id
     * @param classAddEvents 删除类的id以及事项id列表
     * @return 是否成功
     */
    @DeleteMapping("/class")
    Result deleteEventsToClass(@GetUserId Integer uid, @RequestBody ClassAddEvents classAddEvents) {
        long code = classCategoryService.deleteTEFromCategory(uid, classAddEvents.getId(), classAddEvents.getAddList());
        return code == 0 ? Result.error("删除失败") : Result.success();
    }

    @GetMapping("/class")
    Result listClassEvent(@GetUserId Integer uid) {

        // TODO 实现信息获取联查
        return Result.success();
    }
}
