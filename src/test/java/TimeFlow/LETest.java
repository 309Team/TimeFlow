package TimeFlow;

import TimeFlow.mapper.event.LabelEventMapper;
import TimeFlow.pojo.LabelEvent;
import TimeFlow.service.interf.event.LabelEventService;
import TimeFlow.util.TableNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootTest
public class LETest {

    @Autowired
    LabelEventService labelEventService;

    @Autowired
    LabelEventMapper labelEventMapper;

    //@Test
    public void getDateLETest() {

        String date = "2023-10-26";

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, fmt);
        List<LabelEvent> date1 = labelEventService.findDate(5, localDate);

        List<LabelEvent> byDate = labelEventMapper.findByDate(localDate, TableNameUtil.getLEName(5));
    }

    //@Test
    public void insertLETest() {
        LabelEvent labelEvent = new LabelEvent();
        labelEvent.setAttachDate(LocalDate.now());
        labelEvent.setName("帮哈哈找npy");
        labelEvent.setCompleted(false);
        labelEvent.setSetInViewPage(true);

        labelEventService.labelEventInsert(5, labelEvent);
    }

    //    @Test
    public void deleteTest() {
        long l = labelEventService.labelEventDelete(5, 2);
        //System.out.println(l);
    }

    //    @Test
    public void updateTest() {

        LabelEvent labelEvent = new LabelEvent();
        labelEvent.setAttachDate(LocalDate.now());
        labelEvent.setName("帮哈哈找npy");
        labelEvent.setCompleted(false);
        labelEvent.setSetInViewPage(true);

        long l = labelEventService.labelEventUpdate(5, labelEvent);
        System.out.println(l);
    }
}
