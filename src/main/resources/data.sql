DROP TABLE IF EXISTS book;

CREATE TABLE book (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  title VARCHAR(250) NOT NULL,
  price DOUBLE NOT NULL,
  author VARCHAR(250) DEFAULT NULL
);

--INSERT INTO book (title, price, author) VALUES
--  ('title 1', 10, 'Author 1'),
--  ('title 2', 11, 'Author 2'),
--  ('title 3', 12, 'Author 3');