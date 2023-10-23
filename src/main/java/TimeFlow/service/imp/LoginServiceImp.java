package TimeFlow.service.imp;


import TimeFlow.pojo.User;
import TimeFlow.mapper.LoginMapper;
import TimeFlow.service.LoginService;
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
