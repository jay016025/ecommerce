DROP TABLE IF EXISTS Commodities;

--MySQL 整數數據類型:
--  1. BIGINT: 儲存大小為 8 bytes
--  2. INT:  儲存大小為 4 bytes
--  3. SMALLINT: 儲存大小為 2 bytes
--  4. TYNIINT: 儲存大小為 1 bytes

--AUTO_INCREMENT: 資料限制的指令，意思是自動累加，
--  生成規則是第一筆是0，第二筆是1，一直累加上去。
CREATE TABLE Commodities(

    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(48),
    description VARCHAR(48),
    qty INT,
    price INT,
    PRIMARY KEY (id)
);

INSERT INTO commodities(`name`, `description`, `qty`, `price`) VALUES ('椅子', '椅子', 1, 100);
INSERT INTO commodities(`name`, `description`, `qty`, `price`) VALUES ('桌子', '桌子', 2, 50);

-- *********
DROP TABLE IF EXISTS Orders;

CREATE TABLE Orders(

    id BIGINT NOT NULL AUTO_INCREMENT,
    amount INT,
    status VARCHAR(10),

    PRIMARY KEY (id)
);



