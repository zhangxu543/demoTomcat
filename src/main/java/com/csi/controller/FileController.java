package com.csi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


/**
 * @author 张旭
 * @version 1.0
 * @date 2021/5/4 18:03
 */
@Controller
@RequestMapping("/file")
public class FileController {

    @RequestMapping("/student")
    public String downloadFile(HttpServletRequest request,
                             HttpServletResponse response)  {
        String fileName = "student.xlsx";
        return download(request, response, fileName);

    }

    @RequestMapping("/grade")
    public String downloadFileGrade(HttpServletRequest request,
                               HttpServletResponse response) {
        String fileName = "grades.xlsx";
        return download(request, response, fileName);

    }

    private String download(HttpServletRequest request,
                            HttpServletResponse response,String fileName){
        if (fileName != null) {//设置文件路径
            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
            String filePath = path + "asserts/file";
            File file = new File(filePath, fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName="+fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }

}