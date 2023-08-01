CREATE TABLE IF NOT EXISTS recipe
(
    id          UUID NOT NULL,
    name        TEXT NOT NULL,
    description TEXT,
    image_url   TEXT,
    PRIMARY KEY (id)
)
