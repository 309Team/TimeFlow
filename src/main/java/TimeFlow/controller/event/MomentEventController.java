package TimeFlow.controller.event;



import TimeFlow.config.GetUserId;
import TimeFlow.pojo.MomentEvent;
import TimeFlow.pojo.Result;
import TimeFlow.service.interf.event.MomentEventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
public class MomentEventController {

//	@Qualifier("momentEventService")
	@Autowired
	private MomentEventService MEService;

	@PostMapping("/me")
	public Result list(@RequestBody HashMap<String,String> D, @GetUserId Integer id) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		LocalDate date = LocalDate.parse(D.get("dateSTR"), fmt);
//		log.info(date.toString());

		List<MomentEvent> MEList = MEService.list(id, D.get("dateSTR"));
		return Result.success(MEList);
	}



}

