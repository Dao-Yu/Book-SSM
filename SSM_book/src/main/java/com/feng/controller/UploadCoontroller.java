package com.feng.controller;

import com.feng.common.DataJson;
import com.feng.utils.UploadUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

/*
*
* 用与上传用的！
* */
@Controller
public class UploadCoontroller {

    @RequestMapping(value = "user/upload")
    @ResponseBody
    public DataJson upload( MultipartFile file ) throws IOException {
        //调用写好的上传工具类
        String imgPath =  UploadUtils.upload(file);

        DataJson dataJson = new DataJson();

        if(imgPath!=null){
            dataJson.setCode(1);
            dataJson.setMsg("上传成功");
            HashMap<String,String>map = new HashMap<>();
            map.put("src",imgPath);
            dataJson.setData(map);
        }else{
            dataJson.setCode(0);
            dataJson.setMsg("上传失败");
        }


        return dataJson;
    }

}
