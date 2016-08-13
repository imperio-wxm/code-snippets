package com.wxmimperio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * Created by wxmimperio on 2016/8/12.
 */

@Controller
public class FileUploadController {
    @RequestMapping("upload")
    public String fileUpload(@RequestParam("file") CommonsMultipartFile commonsMultipartFile,
                             HttpServletRequest httpServletRequest) {
        //获取文件名
        //commonsMultipartFile.getOriginalFilename();

        //获取上传文件的路径
        String path = httpServletRequest.getRealPath("/fileupload");

        //获取文件流

        InputStream is = null;
        OutputStream os = null;
        try {
            is = commonsMultipartFile.getInputStream();
            os = new FileOutputStream(new File(path, commonsMultipartFile.getOriginalFilename()));

            int len;
            byte[] buffer = new byte[1024];

            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "fileupload";
    }
}
