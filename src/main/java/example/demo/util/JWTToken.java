package example.demo.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
@ToString
public class JWTToken {
    static String secretKey = "Polister";

    public JWTToken() {
    }

    public static String CreateToken(Map<String, String> map) {

        Map<String, Object> header = new HashMap<>();
        header.put("alg", "HS256");
        header.put("typ", "JWT");


        String token;
        var builder = JWT.create()
                .withHeader(header);
        map.forEach(builder::withClaim);


        Date date = new Date();
        date.setTime(date.getTime() + 360000000);

        builder.withExpiresAt(date);

        token = builder.sign(Algorithm.HMAC256(secretKey));

        return token;
    }

    public static boolean Verify(String token) {
        JWT.require(Algorithm.HMAC256(secretKey)).build().verify(token);
        return true;
    }
}
