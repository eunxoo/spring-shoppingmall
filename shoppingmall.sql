SELECT * From member;

CREATE TABLE Member (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    user_id VARCHAR(50) UNIQUE NOT NULL COMMENT 'User ID',
    pw VARCHAR(50) NOT NULL COMMENT 'Password',
    name VARCHAR(50) NOT NULL COMMENT 'Name',
    email VARCHAR(50) NOT NULL COMMENT 'Email',
    contact VARCHAR(13) NOT NULL COMMENT 'Contact'
);

CREATE TABLE Product (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    price INT,
    description VARCHAR(500),
    img VARCHAR(255),
    category_id INT DEFAULT 0
);

/*
   public class Product {
    private int id;
    private String name;
    private int price;
    private String description;
    private String img;
    private int categoryId;
}
 */