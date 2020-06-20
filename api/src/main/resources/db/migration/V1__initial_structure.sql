CREATE TABLE city (
    city_id BIGINT PRIMARY KEY,
    name CHARACTER VARYING NOT NULL,
    state INTEGER NOT NULL
);

CREATE TABLE cost_center (
    cost_center_id BIGINT PRIMARY KEY,
    name CHARACTER VARYING NOT NULL,
    created_at TIMESTAMP NOT NULL,
    state INTEGER NOT NULL,
    city_id BIGINT NOT NULL,

    FOREIGN KEY (city_id) REFERENCES city (city_id)
);

CREATE SEQUENCE seq_cost_center;

CREATE TABLE cost (
    cost_id BIGINT PRIMARY KEY,
    name CHARACTER VARYING NOT NULL,
    created_at TIMESTAMP NOT NULL,
    cost_center_id BIGINT NOT NULL,
    value NUMERIC(16,2) NOT NULL,
    description CHARACTER VARYING,

    FOREIGN KEY (cost_center_id) REFERENCES cost_center (cost_center_id)
);

CREATE SEQUENCE seq_cost;