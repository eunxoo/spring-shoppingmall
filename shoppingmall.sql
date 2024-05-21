SELECT * From member;

CREATE TABLE Member (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    user_id VARCHAR(50) UNIQUE NOT NULL COMMENT 'User ID',
    pw VARCHAR(50) NOT NULL COMMENT 'Password',
    name VARCHAR(50) NOT NULL COMMENT 'Name',
    email VARCHAR(50) NOT NULL COMMENT 'Email',
    contact VARCHAR(13) NOT NULL COMMENT 'Contact'
);


/*
   private String userId;
    private String pw;
    private String name;
    private String email;
    private String contact;
 */