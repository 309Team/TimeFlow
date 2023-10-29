package TimeFlow;

import TimeFlow.mapper.classification.ClassCategoryMapper;
import TimeFlow.pojo.ClassCategory;
import TimeFlow.service.interf.classification.ClassCategoryService;
import TimeFlow.util.TableNameUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MiddleTableTest {
    @Autowired
    ClassCategoryMapper classCategoryMapper;

    @Autowired
    ClassCategoryService classCategoryService;

    @Test
    void createTest() {
        classCategoryMapper.createTable(TableNameUtil.getTEMiddleName(5));
    }

    //@Test
    void dropTest() {
        classCategoryMapper.dropTable(TableNameUtil.getTEMiddleName(5));
    }

    @Test
    void addTest() {

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        classCategoryService.addTEToCategory(5, 1, integers);
    }

    @Test
    void delTest() {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        classCategoryService.deleteTEFromCategory(5, 1, integers);
    }


}
