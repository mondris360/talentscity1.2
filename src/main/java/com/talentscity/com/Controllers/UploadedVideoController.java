package com.talentscity.com.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

@RequestMapping("/uploadedVideos")
@Controller
public class UploadedVideoController {

    @RequestMapping(method = RequestMethod.GET)
    // display upload video page
    public String showUploadVideoPage(HttpServletResponse response) throws IOException {
        response.setHeader("Content-Type", "video/mp4");
//        String mainDir = System.getProperty("user.dir");
//        String subDir = "/src/main/resources/static/uploadedVideos";
//        // get  the file extension from the original file name
//        String storageLocation =  mainDir + subDir + "/76af28a2-f2df-4fa0-a5be-4d256f74ce0d.mp4";
//        Path fileLocation = Paths.get(storageLocation);
//        byte[] video = Files.readAllBytes(fileLocation);
//        System.out.println("============================");
//        System.out.println(Arrays.toString(video));
//        System.out.println("============================");
//
//        System.out.println(System.getProperty("user.dir"));
        return "video";
    }


}
