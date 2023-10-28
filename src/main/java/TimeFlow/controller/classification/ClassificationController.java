package TimeFlow.controller.classification;


import TimeFlow.config.GetUserId;
import TimeFlow.pojo.interact.Result;
import TimeFlow.pojo.TEClassification;
import TimeFlow.service.interf.classification.ClassificationService;
import TimeFlow.util.TableNameUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Slf4j
@RestController
@RequestMapping("/cls")
public class ClassificationController {

    private final ClassificationService CService;

    public ClassificationController(ClassificationService CService) {
        this.CService = CService;
    }

    @GetMapping()
    public Result list(@GetUserId Integer uid) {
        return Result.success(CService.list(TableNameUtil.getTECLName(uid)));
    }

    @PostMapping()
    public Result add(@GetUserId Integer uid, @RequestBody TEClassification newCL) {
        CService.add(TableNameUtil.getTECLName(uid), newCL);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(@GetUserId Integer uid, @RequestBody HashMap<String, Integer> D) {
        CService.delete(TableNameUtil.getTECLName(uid), D.get("id"));
        return Result.success();
    }

}


