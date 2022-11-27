CREATE DATABASE IF NOT EXISTS book_store DEFAULT CHARSET utf8;
USE book_store;



#用户表
CREATE TABLE USER(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '用户表id',
	username VARCHAR(40) NOT NULL COMMENT '用户名',
	userimg VARCHAR(400) DEFAULT'http://localhost:8080/ssm_books/images/01.jpeg' COMMENT'用户头像',
	USER VARCHAR(20) NOT NULL COMMENT '账号',
	PASSWORD VARCHAR(20) NOT NULL COMMENT '密码',
	email VARCHAR(40) NOT NULL COMMENT '邮箱',
	creationtime DATETIME NOT NULL COMMENT '账号创建时间',
	userjurisdiction INT(4) DEFAULT '1' NOT NULL COMMENT '用户权限，0：管理员，1：普通用户，2：可发布商品的用户'
);

INSERT INTO USER(username,USER,PASSWORD,email,creationtime,userjurisdiction)
VALUES('云边有个小酒馆','123456','a12345','2714596503@qq.com','2022-07-08',0);

INSERT INTO USER(username,USER,PASSWORD,email,creationtime,userjurisdiction)
VALUES('小酒馆','271459','a12345','2714596503@qq.com','2022-07-08',1);

INSERT INTO USER(username,USER,PASSWORD,email,creationtime,userjurisdiction)
VALUES('测试','111111','a12345','2714596503@qq.com','2022-07-08',1);




#类别表
CREATE TABLE book_type(
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT '类别id',
	TYPE VARCHAR(100) NOT NULL COMMENT '类别分类'
);


INSERT INTO book_type(TYPE)
VALUES
('哲学类'),
('经济类'),
('文学类'),
('历史类'),
('小说类');




#商品图片存储信息表
CREATE TABLE imgupload(
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	oldName VARCHAR(200) NOT NULL,
	newName VARCHAR(200) NOT NULL,
	contentType VARCHAR(50) NOT NULL,
	imgurl VARCHAR(400) NOT NULL,
	imgurl2 VARCHAR(400)NOT NULL,
	uploadTime DATETIME
);




#商品表
CREATE TABLE bookInfo(
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT '商品id',
	bookname VARCHAR(100) NOT NULL COMMENT'商品名称',
	bookauthor VARCHAR(200) NOT NULL COMMENT'作者',
	imgurl VARCHAR(255) NOT NULL COMMENT'商品图片',
	imgurl2 VARCHAR(255) NOT NULL,
	bookprice DOUBLE NOT NULL COMMENT'商品价格',
	booktype VARCHAR(100) NOT NULL COMMENT'商品类别',
	bookamount INT NOT NULL COMMENT'库存',
	booksynopsis VARCHAR(500) NULL DEFAULT'暂无' COMMENT'商品简介',
	booktime VARCHAR(100) NOT NULL COMMENT'商品上架日期',
	bookstate INT NOT NULL DEFAULT '1' COMMENT'商品发布的状态，0：未发布，1：发布',
	`usersignature` INT DEFAULT'0' NULL COMMENT'被收藏数'
);

 SELECT * FROM  bookInfo

#收藏表
CREATE TABLE usercollect(
	id  INT PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT'收藏id',
	userid INT NOT NULL COMMENT'用户id',
	bookid INT NOT NULL COMMENT'商品id'
);
SELECT * FROM usercollect;


#查询用户收藏类
SELECT * FROM bookInfo WHERE id IN(
	SELECT bookid FROM usercollect WHERE userid=(
		SELECT id FROM USER WHERE USER='271459'
	)
)

#评论表
CREATE TABLE bookcomment(
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT'评论表id',
	userid INT NOT NULL COMMENT'用户id',
	bookid INT NOT NULL COMMENT'书本id',
	COMMENT VARCHAR(500) NULL COMMENT'评论',
	commenttime DATETIME NOT NULL COMMENT'评论发布时间'
);

#用户加入购物车表
CREATE TABLE bookshooping(
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT'购物车表id',
	userid INT NOT NULL COMMENT'用户id',
	bookid INT NOT NULL COMMENT'商品id'
);
SELECT * FROM bookshooping;

#查询用户购物车类
SELECT * FROM bookInfo WHERE id IN(
	SELECT bookid FROM bookshooping WHERE userid=(
		SELECT id FROM USER WHERE USER='271459'
	)
)


#用户收货地址表
CREATE TABLE useraddress(
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT'收货地址id',
	userid INT NOT NULL COMMENT'用户id',
	address VARCHAR(1000) NULL COMMENT'用户收货地址'
);




#用户个性签名表
CREATE TABLE usersignature(
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT'id',
	userid INT NOT NULL COMMENT'用户id',
	signature VARCHAR(400) NULL COMMENT'用户个性签名'
);



#用户动态表
CREATE TABLE dynamicissue(
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT'id',
	userid INT NOT NULL COMMENT'用户id',
	dynamictime DATETIME NOT NULL COMMENT'动态发布时间',
	dynamictype VARCHAR(1000) NOT NULL COMMENT'动态内容',
	dynamicimage VARCHAR(400) NULL COMMENT'附加的图片',
	tags INT DEFAULT'0' NOT NULL COMMENT'点赞数',
	transmit INT DEFAULT'0' NOT NULL COMMENT'转发数'
);







