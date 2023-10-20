package example.demo.controller;

import com.springboot.pojo.Result;
import com.springboot.pojo.User;
import com.springboot.services.UserServices;
import com.springboot.util.JWTToken;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    final
    UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @RequestMapping("/findAll")
    @ResponseBody
    Result FindAll(HttpServletRequest request) {

        String token = request.getHeader("token");
        if (JWTToken.Verify(token)) {
            List<User> resultList = userServices.FindAll();
            return new Result(0, resultList);
        }

        return new Result(1, "NOT_LOGIN");
    }

}
