package com.feng.service;

import com.feng.entity.BookInfoEntity;
import com.feng.entity.UploadimgFileEntity;

public interface UploadimgFileService {
    //存储上传记录信息
    int inUploadimgFileService(UploadimgFileEntity uploadimgFileEntity);

    //新增商品信息
    int inbookInfoService(BookInfoEntity bookInfoEntity);
}
