--DROP TABLE IF EXISTS TB_USER;

--CREATE TABLE TB_USER (
	--id INTEGER PRIMARY KEY AUTO_INCREMENT,
	--name VARCHAR(255) NOT NULL,
	--password VARCHAR(MAX) NOT NULL
--);

--INSERT INTO TB_USER (id, name, password) VALUES
	--(1, 'user', 'mpce12345'),
	--(2, 'default', 'mpce12345'),
	--(3, 'mpce', 'mpce12345');
	


--DROP TABLE IF EXISTS TB_FILE;

--CREATE TABLE TB_FILE (
	--id bigint  primary key auto_increment,
	--user_id bigint not null,
	--url varchar(max) not null,
	--createdAt timestamp not null
--);

	
--ALTER TABLE TB_FILE ADD CONSTRAINT fk_file_user FOREIGN KEY (user_id) REFERENCES tb_user(id);