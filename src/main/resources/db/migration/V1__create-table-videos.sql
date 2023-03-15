CREATE TABLE videos(
    id BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    title VARCHAR(120) NOT NULL,
    description VARCHAR(400) NOT NULL,
    url VARCHAR(300) NOT NULL,
    PRIMARY KEY(id)
);