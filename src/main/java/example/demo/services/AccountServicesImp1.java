package example.demo.services;

import com.springboot.mapper.AccountMapper;
import com.springboot.pojo.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountServicesImp1 implements AccountServices{

    final
    AccountMapper accountMapper;

    public AccountServicesImp1(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    public Account Login(Account account) {
        return accountMapper.Login(account);
    }
}

