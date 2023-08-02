create type recipe_ingredient_unit as enum ('GRAM', 'MILLILITER');
CREATE TABLE IF NOT EXISTS recipe_ingredient
(
    id     serial                 NOT NULL,
    recipe varchar(255)           not null,
    name   TEXT                   NOT NULL,
    amount double precision       not null,
    unit   varchar(255) not null,
    PRIMARY KEY (id)
)
