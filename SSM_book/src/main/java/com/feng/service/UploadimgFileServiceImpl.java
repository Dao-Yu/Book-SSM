package com.feng.service;

import com.feng.dao.UploadimgFileEntityMapper;
import com.feng.entity.BookInfoEntity;
import com.feng.entity.UploadimgFileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadimgFileServiceImpl implements UploadimgFileService {
    @Autowired
    UploadimgFileEntityMapper uploadimgFileEntityMapper;

    //存储上传记录信息
    @Override
    public int inUploadimgFileService(UploadimgFileEntity uploadimgFileEntity) {
        int i = uploadimgFileEntityMapper.inUploadimgFileEntityMapper(uploadimgFileEntity);
        return i;
    }

    //新增商品信息
    @Override
    public int inbookInfoService(BookInfoEntity bookInfoEntity) {
        int i = uploadimgFileEntityMapper.inbookInfoService(bookInfoEntity);
        return i;
    }
}
