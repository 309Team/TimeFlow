package example.demo.controller;

import com.springboot.pojo.Result;
import com.springboot.util.QCloud;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UpLoadController {

    @PostMapping("/upLoad")
    @ResponseBody
    public Result UpLoadTest(String name, MultipartFile image) throws IOException {
        String originalFilename = image.getOriginalFilename();

        File file = new File("C:\\Users\\Polister\\Desktop\\tmp");
        if (!file.exists())
            file.mkdir();

        image.transferTo(new File(file, image.getOriginalFilename()));

        return new Result();
    }


    @PostMapping("/upLoadPic")
    @ResponseBody
    public Result UpLoadPic(MultipartFile image) throws IOException {

        String dest = "C:\\Users\\Polister\\Desktop\\tmp";

        File file = new File(dest);
        if (!file.exists())
            file.mkdir();
        image.transferTo(new File(file, image.getOriginalFilename()));

        QCloud cos = new QCloud();
        String url = cos.UpLoadFile(file, image.getOriginalFilename());

        return new Result(0,"成功", url);
    }
}
