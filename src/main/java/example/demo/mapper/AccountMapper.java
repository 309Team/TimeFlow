package example.demo.mapper;

import com.springboot.pojo.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AccountMapper {
    Account Login(Account account);

}
