ALTER TABLE videos ADD COLUMN categories_id BIGINT NOT NULL;
ALTER TABLE videos ADD CONSTRAINT fk_categories FOREIGN KEY (categories_id) REFERENCES categories(id) ON UPDATE CASCADE ON DELETE RESTRICT;
UPDATE videos SET categories_id = 1;