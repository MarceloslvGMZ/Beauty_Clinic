CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE table cliente (
                         id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
                         nome VARCHAR(100) NOT NULL,
                         telefone VARCHAR(20) NOT NULL

);