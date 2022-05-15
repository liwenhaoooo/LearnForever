drop table if exists `chapter`;
create table `chapter`(
    `id` char(8) not null comment 'id',
    `course_id` char(8) comment 'course_id',
    `name` varchar(50) comment 'course_name',
    primary key (`id`)
) engine = innodb default  charset=utf8mb4 comment ='chapter';

insert into  `chapter` (`id`, `course_id`,`name`) value (000000,'000000','chapter0');
insert into  `chapter` (`id`, `course_id`,`name`) value (000001,'000001','chapter1');

-- -------------------------------- test

drop table if exists `test`;
create table `test` (
    `id` char(8) not null default '' comment 'id',
    `name` varchar(50) comment '名称',
    primary key (`id`)
)engine = innodb default  charset=utf8mb4 comment ='测试';

insert into  `test` (`id`, `name`) value (1,'测试');
insert into  `test` (`id`, `name`) value (2,'测试');
insert into  `test` (`id`, `name`) value (3,'测试');