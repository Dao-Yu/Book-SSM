package com.feng.service;

import com.feng.common.LayuiPageVo;
import com.feng.dao.Admin_userMapper;
import com.feng.entity.BookInfoEntity;
import com.feng.entity.BookTypeEntity;
import com.feng.entity.UserEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Admin_userServiceImpl implements Admin_userService {
    @Autowired
    Admin_userMapper admin_userMapper;

    //用户信息管理
    @Override
    public List<UserEntity> userlist() {
        List<UserEntity> userlist = admin_userMapper.userlist();
        return userlist;
    }

    //分页查询
//    @Override
//    public LayuiPageVo<UserEntity> admin_user(Integer page, Integer limit) {
//
//        PageHelper.startPage(page,limit);
//        List<UserEntity> userEntityList = admin_userMapper.userList(page,limit);
//        PageInfo<UserEntity> userEntityPageInfo = new PageInfo<>(userEntityList);
//        LayuiPageVo<UserEntity> userEntityLayuiPageVo = new LayuiPageVo<>();
//        userEntityLayuiPageVo.setCode(0);
//        userEntityLayuiPageVo.setMsg("分页列表数据");
//        userEntityLayuiPageVo.setCount(userEntityPageInfo.getTotal());
//        userEntityLayuiPageVo.setData(userEntityPageInfo.getList());
//
//        return userEntityLayuiPageVo;
//    }





    //删除用户信息
    @Override
    public int deleteuser(int userid) {
        int i = admin_userMapper.deleteuser(userid);
        return i;
    }

    //修改用户信息
    @Override
    public int updateuser(int userjurisdiction, int userid) {
        int i = admin_userMapper.updateuser(userjurisdiction, userid);
        return i;
    }

    //商品信息管理
    @Override
    public List<BookInfoEntity> commoditylist() {
        List<BookInfoEntity> bookInfoEntityList = admin_userMapper.commoditylist();
        return bookInfoEntityList;
    }

    //商品类别
    @Override
    public List<BookTypeEntity> selecttype() {
        List<BookTypeEntity> bookTypeList = admin_userMapper.selecttype();
        return bookTypeList;
    }

    //商品修改
    @Override
    public int updatcommodity(String bookname, String bookauthor, int bookstate, int bookCollection, int id) {
        int i = admin_userMapper.updatcommodity(bookname, bookauthor, bookstate, bookCollection, id);
        return i;
    }


    //获取一个商品的全部信息
    @Override
    public BookInfoEntity selectOneBook(int id) {
        BookInfoEntity bookInfoEntity = admin_userMapper.selectOneBook(id);
        return bookInfoEntity;
    }

    //删除商品信息
    @Override
    public int deletecommodity(int bookid) {
        int i = admin_userMapper.deletecommodity(bookid);
        return i;
    }

    //查询所有类别
    @Override
    public List<BookTypeEntity> SelectbookType() {
        List<BookTypeEntity> bookTypeEntityList = admin_userMapper.SelectbookType();
        return bookTypeEntityList;
    }

    //新增类别
    @Override
    public int inbooktype(String type) {
        int i = admin_userMapper.inbooktype(type);
        return i;
    }

    //删除类别
    @Override
    public int deletebooktype(int id) {
        int i = admin_userMapper.deletebooktype(id);
        return i;
    }
}
