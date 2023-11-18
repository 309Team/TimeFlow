package TimeFlow.service.interf.user;


import TimeFlow.pojo.User;

public interface UserService {
    // 注销用户服务
    Boolean userDelete(Integer uid);

    // 更新信息服务
    Boolean userUpdate(User user);

    User getUserInfo(Integer uid);
}
