package TimeFlow;

import TimeFlow.mapper.classification.ClassCategoryMapper;
import TimeFlow.mapper.user.RegisterMapper;
import TimeFlow.pojo.User;
import TimeFlow.service.interf.user.RegisterService;
import TimeFlow.util.TableNameUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    RegisterMapper registerMapper;

    @Autowired
    RegisterService registerService;

    @Autowired
    ClassCategoryMapper classCategoryMapper;
    void registerTest() {
        User user = new User();
        user.setUid(100);
    }

    @Test
    void classTest() {
        classCategoryMapper.createTable(TableNameUtil.getTECLName(6));
        System.out.println();
        classCategoryMapper.dropTable(TableNameUtil.getTECLName(6));
    }

}
