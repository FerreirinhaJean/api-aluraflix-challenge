CREATE TABLE categories(
    id BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    title VARCHAR(120) NOT NULL,
    color VARCHAR(20) NOT NULL,
    is_active BOOLEAN NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO categories (id, title, color, is_active) VALUES(1, 'LIVRE', 'sem cor', true);