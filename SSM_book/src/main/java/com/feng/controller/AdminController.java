package com.feng.controller;

import com.feng.common.LayuiPageVo;
import com.feng.common.R;
import com.feng.entity.*;
import com.feng.service.Admin_userService;
import com.feng.service.UploadimgFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class AdminController {
    @Autowired
    UploadimgFileService uploadimgFileService;

    @Autowired
    Admin_userService admin_userService;

    //上传图片到数据库

    @RequestMapping(value = "admin/uploadimg")
    public @ResponseBody
    UploadimgEntity imgupload(MultipartFile photo, MultipartFile photo2, HttpServletRequest request) throws IOException {
        //获取上传的文件名
        String oldname = photo.getOriginalFilename();
        String oldname2 = photo2.getOriginalFilename();
        //获取上传文件的文件名后缀
        String suffix = oldname.substring(oldname.lastIndexOf("."));
        String suffix2 = oldname2.substring(oldname2.lastIndexOf("."));
        //生成随机的文件存储名
        String newName = UUID.randomUUID() + "" + System.currentTimeMillis() + "" + suffix;
        String newName2 = UUID.randomUUID() + "" + System.currentTimeMillis() + "" + suffix2;
        //获取项目的资源路径
        //获取ServlectContext对象
        ServletContext servletContext = request.getServletContext();
        //获取项目根目录下的资源路径
        String path = servletContext.getRealPath("/images/");
        //判断路径是否存在，不存在则创建
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //将上传的数据存储到服务器硬盘中
        photo.transferTo(new File(file, newName));
        photo2.transferTo(new File(file, newName2));
        //获取文件类型
        String contentType = photo.getContentType();
        //创建实体类对象存储上传记录
        UploadimgFileEntity uploadimgFileEntity = new UploadimgFileEntity();
        uploadimgFileEntity.setOldNmae(oldname);
        uploadimgFileEntity.setNewName(newName);
        uploadimgFileEntity.setContentType(contentType);
        //获取当前项目的访问路径
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
        String url = basePath + "images/" + newName;
        String url2 = basePath + "images/" + newName2;

        uploadimgFileEntity.setImgurl(url);
        uploadimgFileEntity.setImgurl2(url2);
        //调用业务层上传记录信息到数据库中
        int i = uploadimgFileService.inUploadimgFileService(uploadimgFileEntity);


        //响应结果
        return new UploadimgEntity(true, "成功", url, url2);

    }


    //用户管理
    @RequestMapping(value = "admin/user")
    @ResponseBody
    public LayuiPageVo<UserEntity> admin_user(){
        List<UserEntity> userEntityList = admin_userService.userlist();
        LayuiPageVo<UserEntity> userEntityLayuiPageVo = new LayuiPageVo<>();
        userEntityLayuiPageVo.setCode(0);
        userEntityLayuiPageVo.setMsg("success");
        userEntityLayuiPageVo.setCount(100);
        userEntityLayuiPageVo.setData(userEntityList);
        return userEntityLayuiPageVo;
    }

    //用户分页管理
//    @RequestMapping(value = "admin/user")
//    @ResponseBody
//    public LayuiPageVo<UserEntity> admin_user(Integer page,Integer limit) {
//        int pages = (page-1)*limit;
//        return admin_userService.admin_user(pages,limit);
//    }

    //商品管理
    @RequestMapping(value = "admin/commodity")
    @ResponseBody
    public LayuiPageVo<BookInfoEntity> admin_commodity(HttpSession session) {
//        System.out.println("进入了");
//        List<BookInfoEntity> bookInfoEntityList = admin_userService.commoditylist();
//        session.setAttribute("AdminCommodity", bookInfoEntityList);
        List<BookInfoEntity> bookInfoEntityList = admin_userService.commoditylist();
        LayuiPageVo<BookInfoEntity> bookInfoEntityLayuiPageVo = new LayuiPageVo<>();
        bookInfoEntityLayuiPageVo.setCode(0);
        bookInfoEntityLayuiPageVo.setMsg("success");
        bookInfoEntityLayuiPageVo.setCount(100);
        bookInfoEntityLayuiPageVo.setData(bookInfoEntityList);
        return bookInfoEntityLayuiPageVo;
    }


    //发布页商品类别信息
    @RequestMapping(value = "admin/Goodsreleased_type")
    public void admin_Goodsreleased_type(HttpSession session) {
        List<BookTypeEntity> bookTypeEntityList = admin_userService.selecttype();
        session.setAttribute("booktypes", bookTypeEntityList);
//        System.out.println(bookTypeEntityList);
    }


    //新增商品信息
    @RequestMapping(value = "admin/Goodsreleased")
    public String admin_Goodsreleased(BookInfoEntity bookInfoEntity) {
        //新增商品
        uploadimgFileService.inbookInfoService(bookInfoEntity);
        return "Administrator_Goodsreleased";
    }

    //获取要修改的商品的id
//    @RequestMapping(value = "admin/updatecommodity_bookid")
//    public @ResponseBody
//    int admin_updatecommodity_id(@RequestParam int bookid, HttpSession session) {
//        BookInfoEntity bookInfoEntity = admin_userService.selectOneBook(bookid);
//        session.setAttribute("adminupdatethisbook", bookInfoEntity);
//        return bookid;
//    }



    //删除商品信息
    @RequestMapping(value = "admin/deletecommodity")
    public @ResponseBody
    R admin_deletecommodity_id(@RequestParam int bookid) {
        int i = admin_userService.deletecommodity(bookid);

        if(i==1){
            return R.ok();
        }else{
            return R.error();
        }
    }

    //删除用户信息
    @RequestMapping(value = "admin/deleteuser")
    public @ResponseBody
    R admin_deleteuser_id(@RequestParam int userid) {
        int i= admin_userService.deleteuser(userid);
        if(i==1){
            return R.ok();
        }else{
            return R.error();
        }
    }

    //修改用户信息
    //1.先获取要修改用户的id
//    @RequestMapping(value = "admin/updateuser_userid")
//    public @ResponseBody
//    int admin_updateuser_id(@RequestParam int userid, HttpSession session) {
//        session.setAttribute("adminupdateuser_id", userid);
//        return userid;
//    }

    //2.通过获取的id修改相对应的用户数据
    @RequestMapping(value = "admin/updateuser")
    @ResponseBody
    public R admin_updateuser(UserEntity userEntity) {

        admin_userService.updateuser(userEntity.getUserjurisdiction(), userEntity.getId());
        return R.ok();
    }

    //修改商品信息
    @RequestMapping(value = "admin/updatecommodity")
    @ResponseBody
    public R admin_updatecommodity(BookInfoEntity bookInfoEntity) {
        admin_userService.updatcommodity(bookInfoEntity.getBookname(),bookInfoEntity.getBookauthor(),
                bookInfoEntity.getBookstate(),bookInfoEntity.getBookCollection(),bookInfoEntity.getId());
//        System.out.println(bookInfoEntity);
        return R.ok();

    }


    //点击添加类别先查询所有类别
    @RequestMapping(value = "admin/addbooktype")
    public void addbooktype(HttpSession session) {
        List<BookTypeEntity> bookTypeEntityList = admin_userService.selecttype();
        session.setAttribute("Allbooktype", bookTypeEntityList);
    }

    //添加类别
    @RequestMapping(value = "admin/addtype")
    public @ResponseBody
    String addtype(@RequestParam("type") String type, HttpSession session) {
        admin_userService.inbooktype(type);
        //更新数据
        List<BookTypeEntity> bookTypeEntityList = admin_userService.selecttype();
        session.setAttribute("Allbooktype", bookTypeEntityList);
        return "true";
    }

    //删除类别
    @RequestMapping(value = "admin/deletetype")
    public @ResponseBody
    String deletetype(@RequestParam("id") int id, HttpSession session) {
        admin_userService.deletebooktype(id);
        //更新数据
        List<BookTypeEntity> bookTypeEntityList = admin_userService.selecttype();
        session.setAttribute("Allbooktype", bookTypeEntityList);
        return "true";
    }


}
