package example.demo.controller;

import com.springboot.pojo.Account;
import com.springboot.pojo.Result;
import com.springboot.services.AccountServices;
import com.springboot.util.JWTToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AccountController {
    final
    AccountServices accountServices;

    public AccountController(AccountServices accountServices) {
        this.accountServices = accountServices;
    }

    @PostMapping("/Login")
    @ResponseBody
    Result Login(@RequestBody Account account) {

        Account login = accountServices.Login(account);
        if (login == null)
            return new Result(1);

        Map<String, String> payload = new HashMap<>();
        payload.put("name", login.getName());
        payload.put("id", login.getId().toString());



        return new Result(0, "成功", JWTToken.CreateToken(payload));
    }
}
