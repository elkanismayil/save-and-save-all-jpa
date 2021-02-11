DROP TABLE IF EXISTS books;

CREATE TABLE books (
                              id INT AUTO_INCREMENT  PRIMARY KEY,
                              book_title VARCHAR(40) NOT NULL,
                              book_author VARCHAR(40) DEFAULT NULL
);

INSERT INTO books (book_title, book_author) VALUES
('Angels and Demons', 'Brown, Dan'),
('Twilight', 'Meyer, Stephenie'),
('Girl with the Dragon Tattoo,The:Millennium Trilogy', 'Larsson, Stieg'),
('Lovely Bones,The', 'Sebold, Alice');