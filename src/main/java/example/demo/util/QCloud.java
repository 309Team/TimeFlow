package example.demo.util;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;

import java.io.File;
import java.util.UUID;

public class QCloud {

    private COSClient cosClient;
    Region region;
    public QCloud() {
// 1 初始化用户身份信息（secretId, secretKey）。
// SECRETID 和 SECRETKEY 请登录访问管理控制台 https://console.cloud.tencent.com/cam/capi 进行查看和管理
        String secretId = "AKIDpZCuCKK6g5IPTM2mQuJfu576A5xjDTix";//用户的 SecretId，建议使用子账号密钥，授权遵循最小权限指引，降低使用风险。子账号密钥获取可参见 https://cloud.tencent.com/document/product/598/37140
        String secretKey = "HPNCyjMtHZjojgU7axBEGDzhKrIZemzC";//用户的 SecretKey，建议使用子账号密钥，授权遵循最小权限指引，降低使用风险。子账号密钥获取可参见 https://cloud.tencent.com/document/product/598/37140
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
// 2 设置 bucket 的地域, COS 地域的简称请参见 https://cloud.tencent.com/document/product/436/6224
// clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        region = new Region("cos.ap-guangzhou");
        ClientConfig clientConfig = new ClientConfig(region);
// 这里建议设置使用 https 协议
// 从 5.6.54 版本开始，默认使用了 https
        clientConfig.setHttpProtocol(HttpProtocol.https);
// 3 生成 cos 客户端。
        cosClient = new COSClient(cred, clientConfig);
    }

    public String UpLoadFile(File path, String filename) {
        // 指定文件将要存放的存储桶
        String bucketName = "polister-test-1304154650";
        // 指定文件上传到 COS 上的路径，即对象键。例如对象键为 folder/picture.jpg，则表示将文件 picture.jpg 上传到 folder 路径下

        UUID uuid = UUID.randomUUID();
        String name = uuid + "." + filename.substring(filename.lastIndexOf(".") + 1);

        String key = "folder/" + name;
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, new File(path, filename));
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);

        String url = "https://" + bucketName + "." + region.getRegionName() + ".myqcloud.com/" + key;
        return url;
    }

}
