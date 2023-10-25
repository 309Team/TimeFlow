package TimeFlow;

import TimeFlow.mapper.user.RegisterMapper;
import TimeFlow.pojo.User;
import TimeFlow.service.interf.user.RegisterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    RegisterMapper registerMapper;

    @Autowired
    RegisterService registerService;

    void registerTest() {
        User user = new User();
        user.setUid(100);
    }

}
