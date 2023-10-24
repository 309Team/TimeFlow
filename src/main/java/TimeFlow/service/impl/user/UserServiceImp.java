package TimeFlow.service.impl.user;


import TimeFlow.mapper.user.UserMapper;
import TimeFlow.service.interf.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
	UserMapper userMapper;

}
