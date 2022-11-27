package com.feng.utils;


import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/*
 * 上传图片工具类
 * */
public class UploadUtils {
    //定义上传图片的位置
    private static final String BASE_PATH="E:\\Demo\\毕业设计\\SSM_book\\src\\main\\webapp\\images\\";
    //定义访问图片的路径
    private static final String SERVER_PATH="http://localhost:8080/ssm_books/images/";

    public static String upload(MultipartFile file) {
        //获取上传文件的名称
        String filename = file.getOriginalFilename();
        //获取上传文件的文件名后缀
        String suffix = filename.substring(filename.lastIndexOf("."));
        //为了图片的唯一性用uuid对filename进行改写
        String uuid = UUID.randomUUID().toString().replace("-","");
        //将生成的uuid和filename进行拼接
        String newFilename = uuid+"-"+filename;

        //判断路径是否存在，不存在则创建
        File files = new File(BASE_PATH);
        if (!files.exists()) {
            files.mkdirs();
        }

        //创建一个文件实例对象
        File image = new File(BASE_PATH,newFilename);
        //对这个文件进行上传操作
        try {
            file.transferTo(image);
        } catch (IOException e) {
            return null;
        }


        return SERVER_PATH+newFilename;
    }

}
