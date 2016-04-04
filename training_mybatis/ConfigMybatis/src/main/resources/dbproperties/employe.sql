CREATE TABLE Employers (

  id            INT UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '员工工号',

  qtalk_id      VARCHAR(20)  NOT NULL DEFAULT ''
  COMMENT 'qtalkID',

  employer_name VARCHAR(30)  NOT NULL DEFAULT ''
  COMMENT '员工姓名',

  tell          VARCHAR(20)  NOT NULL DEFAULT ''
  COMMENT '电话号码',

  work_address  VARCHAR(20)  NOT NULL DEFAULT ''
  COMMENT '工作地点',

  sex           ENUM ('男', '女')       DEFAULT '男'
  COMMENT '性别',

  status        VARCHAR(22)  NOT NULL DEFAULT '在职'
  COMMENT '在职与否',
  PRIMARY KEY (id)

)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT = '员工信息表';
