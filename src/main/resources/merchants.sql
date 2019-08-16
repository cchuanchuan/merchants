CREATE TABLE merchants(
  id int unsigned not NULL AUTO_Increment,
  name VARCHAR(64) COLLATE utf8_bin NOT NULL  COMMENT '商户名称',
  logo_url VARCHAR(256) COLLATE utf8_bin NOT NULL  COMMENT '商户 logo',
  business_license_url VARCHAR(256) COLLATE utf8_bin NOT NULL  COMMENT '商户营业执照',
  phone VARCHAR(64) COLLATE utf8_bin NOT NULL  COMMENT '商户联系电话',
  address VARCHAR (64) COLLATE utf8_bin NOT NULL  COMMENT '商户地址',
  is_audit boolean not null NOT NULL  COMMENT '是否通过审核',
  PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT  CHARSET = utf8;