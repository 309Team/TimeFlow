package TimeFlow;

import TimeFlow.mapper.user.UserMapper;
import TimeFlow.pojo.User;
import TimeFlow.service.interf.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 用户操作测试类
 */
@SpringBootTest
public class UserTest {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;


    //@Test
    void deleteUserTest() {
        userService.userDelete(4);
    }


    void updateUserTest() {
        User user = new User();
        user.setUid(8);
        user.setName("哈哈");
        user.setPassword("hasnotnpy");
        if (userService.userUpdate(user))
            System.out.println("OK");
        else
            System.out.println("error");
    }
}
