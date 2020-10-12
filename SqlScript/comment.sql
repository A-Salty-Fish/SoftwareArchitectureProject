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
