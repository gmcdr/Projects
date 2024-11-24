CREATE TABLE car (
    id BIGSERIAL PRIMARY KEY,
    carname VARCHAR(255) NOT NULL,
    brand VARCHAR(255) NOT NULL,
    model VARCHAR(255) NOT NULL,
    caryear VARCHAR(4) NOT NULL,
    color VARCHAR(50) NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    cardescription TEXT
);

