package example.demo.service;



import example.demo.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    User login(User user);
}
