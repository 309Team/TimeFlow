package TimeFlow;

import TimeFlow.mapper.event.TimeEventMapper;
import TimeFlow.pojo.TimeEvent;
import TimeFlow.util.TableNameUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TETest {

    @Autowired
    TimeEventMapper timeEventMapper;

    @Test
    void test() {
        timeEventMapper.add(TableNameUtil.getTEName(33), new TimeEvent());
    }
}
