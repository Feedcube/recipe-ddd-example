create type recipe_ingredient_unit as enum ('GRAM', 'MILLILITER');
CREATE TABLE IF NOT EXISTS recipe_ingredient
(
    id        UUID                   NOT NULL,
    recipe_id uuid                   not null,
    name      TEXT                   NOT NULL,
    amount    double precision       not null,
    unit      varchar not null,
    PRIMARY KEY (id)
)
