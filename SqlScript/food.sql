-- auto-generated definition
create table food
(
    id      int auto_increment comment '菜品id'
        primary key,
    name    varchar(255) not null comment '菜品名',
    img_url varchar(255) null comment '菜品图片链接',
    canteen varchar(255) not null comment '菜品所属食堂'
);

INSERT INTO `food`(`id`, `name`, `img_url`, `canteen`) VALUES (1, '鸡排饭', NULL, '信息学部三食堂');
INSERT INTO `food`(`id`, `name`, `img_url`, `canteen`) VALUES (2, '鸡腿饭', NULL, '信息学部三食堂');
INSERT INTO `food`(`id`, `name`, `img_url`, `canteen`) VALUES (3, '烤肉拌饭', NULL, '信息学部三食堂');
INSERT INTO `food`(`id`, `name`, `img_url`, `canteen`) VALUES (4, '牛肉面', NULL, '信息学部三食堂');
