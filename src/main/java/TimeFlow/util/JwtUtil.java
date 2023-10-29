package TimeFlow.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import TimeFlow.exception.LoginException;


import java.util.Date;

/**
 * JWT工具类
 */
public class JwtUtil {

    //有效期为
    public static final Long JWT_TTL = 60 * 60 * 1000L;// 60 * 60 *1000  一个小时
    //设置秘钥明文
    public static String JWT_KEY = "TimeFlow";

    /**
     * 创建token
     *
     * @param uid        要验证的id
     * @param ttlMillis token有效时长
     * @return token串
     */
    public static String createJWT(String uid, Long ttlMillis) {

        Date date = new Date();
        if (ttlMillis == null)
            ttlMillis = JWT_TTL;

        date.setTime(date.getTime() + ttlMillis);

        return JWT.create()
                .withClaim("userId", uid)//payload  //自定义用户名
                .withExpiresAt(date) //指定令牌过期时间
                .sign(Algorithm.HMAC256(JWT_KEY));
    }

    /**
     * 验证token
     * @param token 需要验证的token
     */
    public static void verify(String token) throws LoginException {
        try {
            JWT.require(Algorithm.HMAC256(JWT_KEY)).build().verify(token);
        } catch (SignatureVerificationException e) {
            // 解密失败
            throw new LoginException("无效token！");
        } catch (TokenExpiredException e) {
            throw new LoginException("登录过期！");
        } catch (AlgorithmMismatchException e) {
            throw new LoginException("token算法错误！");
        } catch (Exception e) {
            throw new LoginException("token已失效！");
        }
    }

    /**
     * 解码JWT数据
     * @param token 待解码的数据
     * @return DecodedJWT解码包
     */
    public static DecodedJWT getToken(String token) throws LoginException {
        DecodedJWT decodedJWT = null;
        try {
            decodedJWT = JWT.require(Algorithm.HMAC256(JWT_KEY)).build().verify(token);
        } catch (Exception e) {
            throw new LoginException("token解析失败！");
        }
        return decodedJWT;
    }
}