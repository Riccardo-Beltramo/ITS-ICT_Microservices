CREATE DATABASE "borrow" OWNER postgres;
\connect borrow
ALTER DATABASE "borrow";

CREATE TABLE "borrows"
(
    borrow_id integer,
    start_borrow character varying,
    end_borrow character varying,
    book integer,
    customer integer,
    notification character varying
) TABLESPACE pg_default;

ALTER TABLE "borrows"
    OWNER to postgres;