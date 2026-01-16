CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE table profissional (
                         id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
                         nome VARCHAR(100) NOT NULL
);