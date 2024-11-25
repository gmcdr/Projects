CREATE TABLE IF NOT EXISTS public.optional_feature
(
    id bigint NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    price numeric(38,2),
    CONSTRAINT optional_feature_pkey PRIMARY KEY (id)
)