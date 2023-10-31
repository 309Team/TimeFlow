package TimeFlow.controller.event;


import TimeFlow.config.GetUserId;
import TimeFlow.pojo.MomentEvent;
import TimeFlow.pojo.interact.Grouping;
import TimeFlow.pojo.interact.Result;
import TimeFlow.service.interf.event.MomentEventService;
import TimeFlow.util.TableNameUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/event/me")
@CrossOrigin
public class MomentEventController {

	@Autowired
	private MomentEventService MEService;


	@GetMapping()
	public Result list(@GetUserId Integer uid, @RequestBody HashMap<String, String> D ) {
//		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		LocalDate date = LocalDate.parse(D.get("dateSTR"), fmt);
		List<MomentEvent> MEList = MEService.list(TableNameUtil.getMEName(uid), D.get("dateSTR"));
		return Result.success(MEList);
	}

	@PostMapping()
	public Result add(@GetUserId Integer uid, @RequestBody MomentEvent newME){
		MEService.add(TableNameUtil.getMEName(uid) ,newME);
		return Result.success();
	}

	@DeleteMapping()
	public Result delete(@GetUserId Integer uid, @RequestBody HashMap<String,Integer> D){
		MEService.delete(TableNameUtil.getMEName(uid), D.get("id"));
		return Result.success();
	}

	@PatchMapping()
	public Result update(@GetUserId Integer uid, @RequestBody MomentEvent newME){
		MEService.update(TableNameUtil.getMEName(uid) ,newME);
		return Result.success();
	}



}

