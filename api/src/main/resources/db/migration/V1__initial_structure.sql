CREATE TABLE city (
    city_id BIGINT NOT NULL,
    name CHARACTER VARYING NOT NULL,
    CONSTRAINT pk_city PRIMARY KEY (city_id)
);

CREATE TABLE cost_center (
    cost_center_id BIGINT NOT NULL,
    name CHARACTER VARYING NOT NULL,
    created_at TIMESTAMP NOT NULL,
    city_id BIGINT NOT NULL,
    CONSTRAINT pk_cost_center PRIMARY KEY (cost_center_id),
    CONSTRAINT fk_cost_center_city FOREIGN KEY (city_id) REFERENCES city (city_id)
);

CREATE SEQUENCE seq_cost_center;

CREATE TABLE cost (
    cost_id BIGINT NOT NULL,
    name CHARACTER VARYING NOT NULL,
    created_at TIMESTAMP NOT NULL,
    cost_center_id BIGINT NOT NULL,
    value NUMERIC(16,2) NOT NULL,
    description CHARACTER VARYING,
    CONSTRAINT pk_cost PRIMARY KEY (cost_id),
    CONSTRAINT fk_cost_cost_center FOREIGN KEY (cost_center_id) REFERENCES cost_center(cost_center_id)
);

CREATE SEQUENCE seq_cost;