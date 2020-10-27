-- auto-generated definition
create table comment
(
    id        int auto_increment comment '评论id'
        primary key,
    content   varchar(1023) not null comment '评论内容',
    user_id   int           not null comment '用户id',
    food_name varchar(255)  not null comment '菜品名',
    canteen   varchar(255)  not null comment '所属食堂',
    stars     int           not null comment '评分星级'
);

INSERT INTO `comment`(`id`, `content`, `user_id`, `food_name`, `canteen`, `stars`) VALUES (1, '鸡排饭好评', 1, '鸡排饭', '信息学部三食堂', 5);
INSERT INTO `comment`(`id`, `content`, `user_id`, `food_name`, `canteen`, `stars`) VALUES (2, '牛肉面一般', 1, '牛肉面', '信息学部三食堂', 3);
INSERT INTO `comment`(`id`, `content`, `user_id`, `food_name`, `canteen`, `stars`) VALUES (3,'重庆辣子鸡
一般',1,'重庆辣子鸡
','信息学部三食堂',3);

INSERT INTO `comment`(`id`, `content`, `user_id`, `food_name`, `canteen`, `stars`) VALUES (4,'红烧排骨
一般',1,'红烧排骨
','信息学部三食堂',3);

INSERT INTO `comment`(`id`, `content`, `user_id`, `food_name`, `canteen`, `stars`) VALUES (5,'香辣鸡柳
好评',1,'香辣鸡柳
','信息学部三食堂',5);

INSERT INTO `comment`(`id`, `content`, `user_id`, `food_name`, `canteen`, `stars`) VALUES (6,'粉蒸肉 
好评',1,'粉蒸肉 
','信息学部三食堂',5);

INSERT INTO `comment`(`id`, `content`, `user_id`, `food_name`, `canteen`, `stars`) VALUES (7,'爆炒香肠 
好评',1,'爆炒香肠 
','信息学部三食堂',5);

INSERT INTO `comment`(`id`, `content`, `user_id`, `food_name`, `canteen`, `stars`) VALUES (8,'清炒肉丝 
好评',1,'清炒肉丝 
','信息学部三食堂',5);

INSERT INTO `comment`(`id`, `content`, `user_id`, `food_name`, `canteen`, `stars`) VALUES (9,'牛肉丸子 
一般',1,'牛肉丸子 
','信息学部三食堂',3);

INSERT INTO `comment`(`id`, `content`, `user_id`, `food_name`, `canteen`, `stars`) VALUES (10,'原味鸡腿 
好评',1,'原味鸡腿 
','信息学部三食堂',5);

INSERT INTO `comment`(`id`, `content`, `user_id`, `food_name`, `canteen`, `stars`) VALUES (11,'糖醋里脊
一般',1,'糖醋里脊
','信息学部三食堂',3);

INSERT INTO `comment`(`id`, `content`, `user_id`, `food_name`, `canteen`, `stars`) VALUES (12,'红烧鸡块
一般',1,'红烧鸡块
','信息学部三食堂',3);

INSERT INTO `comment`(`id`, `content`, `user_id`, `food_name`, `canteen`, `stars`) VALUES (13,'农家红烧肉
好评',1,'农家红烧肉
','信息学部三食堂',5);

INSERT INTO `comment`(`id`, `content`, `user_id`, `food_name`, `canteen`, `stars`) VALUES (14,'干烧糍粑鱼
好评',1,'干烧糍粑鱼
','信息学部三食堂',5);

INSERT INTO `comment`(`id`, `content`, `user_id`, `food_name`, `canteen`, `stars`) VALUES (15,'手工肉丸汤E
好评',1,'手工肉丸汤E
','信息学部三食堂',5);

INSERT INTO `comment`(`id`, `content`, `user_id`, `food_name`, `canteen`, `stars`) VALUES (16,'黄瓜肉片
一般',1,'黄瓜肉片
','信息学部三食堂',3);

INSERT INTO `comment`(`id`, `content`, `user_id`, `food_name`, `canteen`, `stars`) VALUES (17,'香味卤鸭
好评',1,'香味卤鸭
','信息学部三食堂',5);

INSERT INTO `comment`(`id`, `content`, `user_id`, `food_name`, `canteen`, `stars`) VALUES (18,'红烧鲫鱼
好评',1,'红烧鲫鱼
','信息学部三食堂',5);

INSERT INTO `comment`(`id`, `content`, `user_id`, `food_name`, `canteen`, `stars`) VALUES (19,'蒙古牛柳
一般',1,'蒙古牛柳
','信息学部三食堂',3);

INSERT INTO `comment`(`id`, `content`, `user_id`, `food_name`, `canteen`, `stars`) VALUES (20,'红烧鸡丁
一般',1,'红烧鸡丁
','信息学部三食堂',3);

INSERT INTO `comment`(`id`, `content`, `user_id`, `food_name`, `canteen`, `stars`) VALUES (21,'湘味牛肉
好评',1,'湘味牛肉
','信息学部三食堂',5);

INSERT INTO `comment`(`id`, `content`, `user_id`, `food_name`, `canteen`, `stars`) VALUES (22,'香菇鸡块
好评',1,'香菇鸡块
','信息学部三食堂',5);

INSERT INTO `comment`(`id`, `content`, `user_id`, `food_name`, `canteen`, `stars`) VALUES (23,'辣子鸡丁好评',1,'辣子鸡丁','信息学部三食堂',5);

