-- 建立用户表
create table user(
    name varchar(10) not null unique comment '用户名',
    uid int unsigned primary key auto_increment comment '用户ID',
    password varchar(10) default '1234' not null comment '用户密码'
) comment '用户表';

-- 添加用户
insert into
    user (name, uid, password)
values
    ('张一', 1, 1),
    ('张二', 2, 2),
    ('张三', 3, 3),
    ('张四', 4, 4),
    ('张五', 5, 5),
    ('张六', 6, 6);

-- 用户注册时建表
create table 1_time_event (
    id int unsigned primary key auto_increment comment '事项ID',
    name varchar(10) not null unique comment '事项名',
    startTime datetime not null comment '开始时间',
    overTime datetime not null comment '结束时间',
    setInViewPage tinyint not null comment '是否纳入日视图统计（无痕事件）',
    text varchar(400) comment '文本内容（事项注释）',
    isCompleted tinyint not null comment '事件是否完成'
) comment '时段事项表';

create table 1_moment_event (
    id int unsigned primary key auto_increment comment '事项ID',
    name varchar(10) not null unique comment '事项名',
    deadline datetime not null comment '截截止时间',
    setInViewPage tinyint not null comment '是否纳入日视图统计（无痕事件）',
    text varchar(400) comment '文本内容（事项注释）',
    isCompleted tinyint not null comment '事件是否完成'
) comment '时刻事项表';

create table 1_label_event (
    id int unsigned primary key auto_increment comment '事项ID',
    name varchar(10) not null unique comment '事项名',
    attachdate date not null comment '附着时间',
    setInViewPage tinyint not null comment '是否纳入日视图统计（无痕事件）',
    text varchar(400) comment '文本内容（事项注释）',
    isCompleted tinyint not null comment '事件是否完成'
) comment '标签事项表';

create table 1_te_classification(
    id int unsigned primary key auto_increment comment '分类ID',
    name varchar(10) not null unique comment '分类名',
    text varchar(400) comment '分类注释'
) comment '分类表';

create table 1_te_class_category(
    id int unsigned primary key auto_increment comment '关联表下的ID',
    id_event int unsigned not null comment '事件的ID',
    id_class int unsigned not null comment '类别的ID'
) comment '关联表';

-- 添加用户1的时段事项TE
INSERT INTO
    1_time_event (
        id,
        name,
        startTime,
        overTime,
        setInViewPage,
        text,
        isCompleted
    )
VALUES
    (
        1,
        'TE_1',
        '2023-10-21 08:00:00',
        '2023-10-21 08:30:00',
        1,
        null,
        0
    ),
    (
        2,
        'TE_2',
        '2023-10-21 09:30:00',
        '2023-10-21 11:30:00',
        1,
        null,
        0
    ),
    (
        3,
        'TE_3',
        '2023-10-21 14:30:00',
        '2023-10-21 16:00:00',
        1,
        null,
        0
    ),
    (
        4,
        'TE_4',
        '2023-10-22 09:30:00',
        '2023-10-22 12:00:00',
        1,
        null,
        0
    ),
    (
        5,
        'TE_5',
        '2023-10-23 10:30:00',
        '2023-10-23 14:30:00',
        1,
        null,
        0
    );

-- 添加用户1的时刻事项ME
INSERT INTO
    1_moment_event (
        id,
        name,
        deadline,
        setInViewPage,
        text,
        isCompleted
    )
VALUES
    (
        1,
        'ME_1',
        '2023-10-21 08:30:00',
        1,
        null,
        0
    ),
    (
        2,
        'ME_2',
        '2023-10-22 11:30:00',
        1,
        null,
        0
    ),
    (
        3,
        'ME_3',
        '2023-10-22 16:30:00',
        1,
        null,
        0
    ),
    (
        4,
        'ME_4',
        '2023-10-23 10:30:00',
        1,
        null,
        0
    ),
    (
        5,
        'ME_5',
        '2023-10-22 21:30:00',
        1,
        null,
        0
    );

-- 添加用户1的标签事项LE
INSERT INTO
    1_label_event (
        id,
        name,
        attachdate,
        setInViewPage,
        text,
        isCompleted
    )
VALUES
    (
        1,
        'LE_1',
        '2023-10-21',
        1,
        null,
        0
    ),
    (
        2,
        'LE_2',
        '2023-10-22',
        1,
        null,
        0
    ),
    (
        3,
        'LE_3',
        '2023-10-23',
        1,
        null,
        0
    );

-- 添加用户1的类别事项CL
insert into
    1_te_classification (id, name, text)
values
    (1, 'CL_A', null),
    (2, 'CL_B', null),
    (3, 'CL_C', null),
    (4, 'CL_D', null);

-- 为用户1的事项分类
insert into
    1_te_class_category(id, id_event, id_class)
values
    (1, 1, 1),
    (2, 1, 2),
    (3, 1, 3),
    (4, 2, 1),
    (5, 2, 2),
    (6, 3, 1);