-- 用户建表 并插入测试数据
create table user(
	name varchar(10) not null unique comment '用户名',
	uid int unsigned primary key auto_increment comment '用户ID',
	password varchar(10) default '1234' not null comment '用户密码'
) comment '用户表';


-- 时段事项建表 并插入测试数据
create table 1_time_event (
	id int unsigned primary key auto_increment comment '事项ID',
	name varchar(10) not null unique comment '事项名',
	startTime datetime not null comment '开始时间',
	overTime datetime not null comment '结束时间',
	setInViewPage tinyint not null comment '是否纳入日视图统计（无痕事件）',
	text varchar(400) comment '文本内容（事项注释）',
	isCompleted tinyint not null comment '事件是否完成'
) comment '时段事项表';


-- 时刻事项建表 并插入测试数据
create table 1_moment_event (
	id int unsigned primary key auto_increment comment '事项ID',
	name varchar(10) not null unique comment '事项名',
	deadline datetime not null comment '截截止时间',
	setInViewPage tinyint not null comment '是否纳入日视图统计（无痕事件）',
	text varchar(400) comment '文本内容（事项注释）',
	isCompleted tinyint not null comment '事件是否完成'
) comment '时刻事项表';


-- 标签事项建表 并插入测试数据
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

