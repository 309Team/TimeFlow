package example.demo.service.imp;


import example.demo.mapper.UserMapper;
import example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserMapper userMapper;

}
