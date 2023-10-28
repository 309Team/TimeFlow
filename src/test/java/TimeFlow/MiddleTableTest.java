package TimeFlow;

import TimeFlow.mapper.classification.ClassCategoryMapper;
import TimeFlow.pojo.ClassCategory;
import TimeFlow.util.TableNameUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MiddleTableTest {
    @Autowired
    ClassCategoryMapper classCategoryMapper;

    @Test
    void createTest() {
        classCategoryMapper.createTable(TableNameUtil.getTECLName(5));
    }

    //@Test
    void dropTest() {
        classCategoryMapper.dropTable(TableNameUtil.getTECLName(5));
    }

    @Test
    void addTest() {
        classCategoryMapper.add(TableNameUtil.getTECLName(5), 1, 2);
    }

    @Test
    void delTest() {
        classCategoryMapper.deleteByEventId(TableNameUtil.getTECLName(5), 1);
    }
}
