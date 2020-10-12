create table canteen
(
    id       int auto_increment comment '食堂id'
        primary key,
    name     varchar(255) not null comment '食堂名',
    position varchar(255) not null comment '食堂所在地'
);
INSERT INTO `canteen`(`id`, `name`, `position`) VALUES (1, '信息学部一食堂', '信息学部');
INSERT INTO `canteen`(`id`, `name`, `position`) VALUES (2, '信息学部二食堂', '信息学部');
INSERT INTO `canteen`(`id`, `name`, `position`) VALUES (3, '信息学部三食堂', '信息学部');
INSERT INTO `canteen`(`id`, `name`, `position`) VALUES (4, '星湖园食堂', '信息学部');
