DROP TABLE Appareils;
CREATE TABLE Appareils (
                       Id int NOT NULL ,
                       Name varchar(255),
                       Status varchar(255),
                       PRIMARY KEY (Id)
);

INSERT INTO Appareils (Id, Name, Status)
VALUES (2, 'TELEVISION', 'allumer'),
(1, 'MACHINE A LAVER', 'eteint'),
(3, 'ORDINATEUR', 'eteint'),
(4, 'IMPRIMANTE', 'allumer'),
(5, 'MACHINE A CAFE', 'allumer');
