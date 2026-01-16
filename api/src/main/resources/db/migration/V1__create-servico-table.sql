CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE table servico (
                         id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
                         nome VARCHAR(100) NOT NULL,
                         descricao VARCHAR(250) NOT NULL,
                         valor DECIMAL(10,2) NOT NULL,
                         ativo boolean NOT NULL
);