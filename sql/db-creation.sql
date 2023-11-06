create database metaIoT;
create user 'op_manager'@'%' identified by 'meta';
grant all on metaIoT.* to 'op_manager'@'%';