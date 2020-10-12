alter table cabinet add  id int not null auto_increment primary key;
ALTER TABLE cabinet ADD dept_id BIGINT COMMENT '部门id';
update cabinet set dept_id=25;