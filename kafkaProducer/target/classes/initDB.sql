CREATE TABLE IF NOT EXISTS users
(
    id          BIGSERIAL       PRIMARY KEY,
    login        VARCHAR(100)    NOT NULL,
    hash VARCHAR(100)    NOT NULL
);
CREATE TABLE IF NOT EXISTS games
(
    id          BIGSERIAL       PRIMARY KEY,
    name        VARCHAR(100)    NOT NULL,
    studio_name VARCHAR(100)    NOT NULL,
    cost        DECIMAL         NOT NULL,
    photo       VARCHAR(200)    DEFAULT NULL,
    description VARCHAR(10000)  DEFAULT NULL
);
INSERT INTO games VALUES (DEFAULT, 'Ведьмак 3', 'CD Projekt RED', '1199', null, null);
INSERT INTO games VALUES (DEFAULT, 'Grand Theft Auto V', 'Rockstar North', '1499', null, null);
INSERT INTO games VALUES (DEFAULT, 'Red Dead Redemption 2', 'Rockstar Games', '3299', null, null);
INSERT INTO games VALUES (DEFAULT, 'Overwatch', 'Blizzard Entertainment', '2699', null, null);
INSERT INTO games VALUES (DEFAULT, 'Watch Dogs', 'Ubisoft', '1499', null, null);
INSERT INTO games VALUES (DEFAULT, 'Dark Souls', 'From Software', '1199', null, null);
INSERT INTO games VALUES (DEFAULT, 'The Elder Scrolls V: Skyrim', 'Bethesda Game Studios', '1399', null, null);
INSERT INTO games VALUES (DEFAULT, 'Mortal Kombat X', 'NetherRealm Studios', '899', null, null);
INSERT INTO games VALUES (DEFAULT, 'Cyberpunk 2077', 'CD Projekt RED', '1999', null, null);
INSERT INTO games VALUES (DEFAULT, 'Fortnite', 'Epic Games', '0', null, null);

insert into users values (DEFAULT, 'guest','$2a$10$gg8PewbkHFBjGYP4afCHxu8oozTLnB6e3yQQd5YsFqG2UDKIZa5/u');