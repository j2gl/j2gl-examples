drop database if exists mybatis;

create database mybatis
  default character set 'UTF8'
  default collate 'utf8_general_ci';

use mybatis;

drop user if exists mybatisusr@'127.0.0.1';
drop user if exists mybatisusr@'%';

create user mybatisusr@'127.0.0.1' IDENTIFIED BY 'mybatispwd';
create user mybatisusr@'%' IDENTIFIED BY 'mybatispwd';

GRANT ALL PRIVILEGES ON mybatis.* to mybatisusr@'127.0.0.1';
GRANT ALL PRIVILEGES ON mybatis.* to mybatisusr@'%';

CREATE TABLE user(
  id int NOT NULL PRIMARY KEY,
  user varchar(30) NOT NULL,
  email varchar(100)
);
