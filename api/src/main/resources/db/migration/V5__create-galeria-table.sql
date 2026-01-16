CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE table galeria
(
    id     UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    imgUrl VARCHAR(250) NOT NULL,
    servico_id UUID,
    FOREIGN KEY (servico_id) REFERENCES servico(id)
);