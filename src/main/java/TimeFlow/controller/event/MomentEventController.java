package TimeFlow.controller.event;


import TimeFlow.config.GetUserId;
import TimeFlow.pojo.MomentEvent;
import TimeFlow.pojo.interact.Result;
import TimeFlow.service.interf.event.MomentEventService;
import TimeFlow.util.TableNameUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/event/me")
@CrossOrigin
public class MomentEventController {

	@Autowired
	private MomentEventService MEService;


	@GetMapping("/{dateSTR}")
	public Result list(@GetUserId Integer uid, @PathVariable("dateSTR") String dateSTR) {
//		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		LocalDate date = LocalDate.parse(D.get("dateSTR"), fmt);
		List<MomentEvent> MEList = MEService.list(TableNameUtil.getMEName(uid), dateSTR);
		MEList.sort(new Comparator<MomentEvent>() {
			@Override
			public int compare(MomentEvent o1, MomentEvent o2) {
				return o1.getDeadline().compareTo(o2.getDeadline());
			}
		});
		return Result.success(MEList);
	}

	@PostMapping()
	public Result add(@GetUserId Integer uid, @RequestBody MomentEvent newME){
		MEService.add(TableNameUtil.getMEName(uid) ,newME);
		return Result.success();
	}

	@DeleteMapping("/{eid}")
	public Result delete(@GetUserId Integer uid, @PathVariable Integer eid){
		MEService.delete(TableNameUtil.getMEName(uid),eid);
		return Result.success();
	}

	@PatchMapping()
	public Result update(@GetUserId Integer uid, @RequestBody MomentEvent newME){
		MEService.update(TableNameUtil.getMEName(uid) ,newME);
		return Result.success();
	}

	@GetMapping("/month/{date}")
	public Result getMonthMomentEvent(@GetUserId Integer uid, @PathVariable String date) {
		// 对前端日期进行转换为LocalDate
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(date, fmt);

		HashMap<String, Integer> result = MEService.countMomentEventByMonth(uid, localDate);
		return Result.success(result);
	}

	@GetMapping("/year/{date}")
	public Result getYearMomentEvent(@GetUserId Integer uid, @PathVariable String date) {
		// 对前端日期进行转换为LocalDate
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(date, fmt);

		HashMap<String, Integer> result = MEService.countMomentEventByYear(uid, localDate);
		return Result.success(result);
	}
}

