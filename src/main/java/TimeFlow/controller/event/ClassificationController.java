package TimeFlow.controller.event;


import TimeFlow.config.GetUserId;
import TimeFlow.pojo.Classification;
import TimeFlow.pojo.MomentEvent;
import TimeFlow.pojo.Result;
import TimeFlow.service.interf.event.ClassificationService;
import TimeFlow.service.interf.event.MomentEventService;
import TimeFlow.util.TableNameUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Slf4j
@RestController
@RequestMapping("/cls")
public class ClassificationController {

	@Autowired
	private ClassificationService CService;

	@GetMapping()
	public Result list(@GetUserId Integer uid){
		return Result.success(CService.list(TableNameUtil.getCLName(uid)));
	}

	@PostMapping()
	public Result add(@GetUserId Integer uid, @RequestBody Classification newCL){
		CService.add(TableNameUtil.getCLName(uid) ,newCL);
		return Result.success();
	}

	@DeleteMapping
	public Result delete(@GetUserId Integer uid, @RequestBody HashMap<String,Integer> D){
		CService.delete(TableNameUtil.getCLName(uid), D.get("id"));
		return Result.success();
	}



}
