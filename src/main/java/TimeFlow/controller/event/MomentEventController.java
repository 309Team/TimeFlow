package TimeFlow.controller.event;


import TimeFlow.config.GetUserId;
import TimeFlow.mapper.event.MomentEventMapper;
import TimeFlow.pojo.MomentEvent;
import TimeFlow.pojo.Result;
import TimeFlow.service.interf.event.MomentEventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/me")
public class MomentEventController {

	//	@Qualifier("momentEventService")
	@Autowired
	private MomentEventService MEService;

	@GetMapping()
	public Result list(@GetUserId Integer uid, @RequestBody HashMap<String, String> D ) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		LocalDate date = LocalDate.parse(D.get("dateSTR"), fmt);
//		log.info(date.toString());
		List<MomentEvent> MEList = MEService.list(uid, D.get("dateSTR"));
		return Result.success(MEList);
	}

	@PostMapping()
	public Result add(@GetUserId Integer uid, @RequestBody MomentEvent newME){
		MEService.add(uid ,newME);
		return Result.success();
	}

	@DeleteMapping
	public Result delete(@GetUserId Integer uid, @RequestBody HashMap<String,Integer> D){
		MEService.delete(uid, D.get("id"));
		return Result.success();
	}
}

