--DROP SCHEMA IF EXISTS general CASCADE;

CREATE SCHEMA IF NOT EXISTS general;

--UTILS SCHEMA

CREATE TABLE general.car
(
    id varchar NOT NULL,
    chat_id varchar NOT NULL,
    model varchar NOT NULL,
    year integer NOT NULL,
    engine_volume decimal NOT NULL,
    mileage bigint NOT NULL,
    transmission varchar NOT NULL,
    CONSTRAINT pk_car
        PRIMARY KEY (id)
);



