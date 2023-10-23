package TimeFlow.service.imp;


import TimeFlow.mapper.UserMapper;
import TimeFlow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
	UserMapper userMapper;

}
