CREATE TABLE IF NOT EXISTS recipe
(
    id          varchar(255) NOT NULL,
    name        TEXT NOT NULL,
    description TEXT,
    image_url   TEXT,
    PRIMARY KEY (id)
)
