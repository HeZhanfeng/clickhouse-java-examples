CREATE TABLE mgbench.user
(

    `id` UInt64,

    `username` String,

    `password` String,

    `create_time` DateTime64(3),

    `update_time` DateTime64(3)
)
ENGINE = MergeTree
PRIMARY KEY id
ORDER BY id
SETTINGS index_granularity = 8192



INSERT INTO mgbench.`user` (id,username,password,create_time,update_time) VALUES
	 (1583009488414208002,'zhangsan','123456',2022-10-20 16:17:27.589,2022-10-20 16:17:27.589),
	 (1583009511122169858,'lisi','123456',2022-10-20 16:17:33.003,2022-10-20 16:17:33.003),
	 (1583009533335203842,'wangwu','123456',2022-10-20 16:17:38.299,2022-10-20 16:17:38.299);