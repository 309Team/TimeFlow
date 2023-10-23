package example.demo.service.imp;


import example.demo.mapper.LoginMapper;
import example.demo.pojo.User;
import example.demo.service.LoginService;
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
