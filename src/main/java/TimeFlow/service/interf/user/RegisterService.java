package TimeFlow.service.interf.user;

import TimeFlow.pojo.User;

public interface RegisterService {
    Integer userRegister(User user);

    User findUser(User user);

    void createTable(User user);
}
