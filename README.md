# metaIoT-operation-manager-service

DB SETUP

docker run -it --network metaIoT-network --rm --name metaIoT-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=meta -d mysql:latest

mysql> create database metaIoT; -- Creates the new database
mysql> create user 'op_manager'@'%' identified by 'meta'; -- Creates the user
mysql> grant all on metaIoT.* to 'op_manager'@'%'; -- Gives all privileges to the new user on the newly created database


I need help with designing my data model. I'm going to describe you the use case and you provide me the full data model design: I have an application that launches operations on an undefined amount of devices with mqtt. Every time a rest endpoint receives a message with the parameters of operation it publishes it in a mqtt topic where the target devices are suscribed. When the message is received the device sends with mqtt a message that informs of the reception of the operation. The same process applies when a operation is denied and where It's completed. The application receives this messages because It's suscribed to all the topics. Every time a operation is received to be published it should be stored in the database and the same goes for the messages from the devices