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

create table order_master (
  order_id varchar(32) not null,
  buyer_name varchar(32) not null comment '买家名字',
  buyer_phone varchar(32) not null comment '买家电话',
  buyer_address varchar(128) not null comment '买家地址',
  buyer_openid varchar(64) not null comment '买家微信openid',
  order_amount decimal(8,2) not null comment '订单总金额',
  order_status tinyint(3) not null default '0' comment '订单状态,默认为新下单',
  pay_status tinyint(3) not null default '0' comment '支付状态,默认未支付',
  create_time timestamp not null default current_timestamp comment '创建时间',
  update_time timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (order_id),
  key idx_buyer_openid (buyer_openid)
) engine = InnoDB default charset = utf8mb4 comment = '订单主表'