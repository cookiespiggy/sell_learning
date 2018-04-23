create table product_category (
  category_id int(11) not null auto_increment,
  category_name varchar(64) not null comment '类目名称',
  category_type int(11) not null comment '类目编号',
  create_time timestamp not null default current_timestamp comment '创建时间',
  update_time timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (category_id),
  unique key uqe_category_type (category_type)
) engine = InnoDB default charset = utf8mb4 comment = '类目表'

CREATE TABLE `product_info` (
	`product_id` VARCHAR(32) NOT NULL,
	`product_name` VARCHAR(64) NOT NULL COMMENT '商品名称',
	`product_price` DECIMAL(8,2) NOT NULL COMMENT '商品价格',
	`product_stock` INT(11) NOT NULL COMMENT '库存',
	`product_description` VARCHAR(64) DEFAULT NULL COMMENT '描述',
	`product_icon` VARCHAR(512) DEFAULT NULL COMMENT '小图',
	`product_status` TINYINT(3) DEFAULT '0' COMMENT '商品状态,0正常1下架',
	`category_type` INT(11) NOT NULL COMMENT '类目编号',
	create_time timestamp not null default current_timestamp comment '创建时间',
  update_time timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
	PRIMARY KEY (`product_id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4