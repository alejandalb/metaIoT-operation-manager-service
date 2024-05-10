# metaIoT-operation-manager-service

DB SETUP

docker run -it --network metaIoT-network --rm --name metaIoT-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=meta -d mysql:latest

mysql> create database metaIoT; -- Creates the new database
mysql> create user 'op_manager'@'%' identified by 'meta'; -- Creates the user
mysql> grant all on metaIoT.* to 'op_manager'@'%'; -- Gives all privileges to the new user on the newly created database
