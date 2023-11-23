package TimeFlow.controller.classification;


import TimeFlow.config.GetUserId;
import TimeFlow.pojo.TimeEvent;
import TimeFlow.pojo.interact.Result;
import TimeFlow.pojo.Classification;
import TimeFlow.service.interf.classification.ClassificationService;
import TimeFlow.util.TableNameUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Slf4j
@RestController
@RequestMapping("/cls")
@CrossOrigin
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
	public Result add(@GetUserId Integer uid, @RequestBody Classification newCL) {
		CService.add(TableNameUtil.getTECLName(uid), newCL);
		return Result.success();
	}

	@DeleteMapping("/{id}")
	public Result delete(@GetUserId Integer uid, @PathVariable Integer id) {
		CService.delete(uid, id);
		return Result.success();
	}

	@PatchMapping()
	public Result update(@GetUserId Integer uid, @RequestBody Classification newCL) {
		CService.update(TableNameUtil.getTECLName(uid), newCL);
		return Result.success();
	}
}
