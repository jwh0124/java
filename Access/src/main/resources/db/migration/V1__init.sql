CREATE TABLE tbl_access_history (
	id INT auto_increment NOT NULL PRIMARY KEY,
	device_id varchar(100) NULL,
	user_id varchar(100) NULL,
	access_type varchar(100) NULL,
	auth_type varchar(100) NULL,
	access_time varchar(100) NULL
);