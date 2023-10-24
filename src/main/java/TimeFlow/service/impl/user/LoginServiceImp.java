package TimeFlow.service.impl.user;


import TimeFlow.pojo.User;
import TimeFlow.mapper.user.LoginMapper;
import TimeFlow.service.interf.user.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImp implements LoginService {

    final LoginMapper loginMapper;
    public LoginServiceImp(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    @Override
    public User login(User user) {
        return loginMapper.login(user);
    }
}
