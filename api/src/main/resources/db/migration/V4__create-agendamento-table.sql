CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE table agendamento (
                         id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
                         status VARCHAR(100) NOT NULL,
                         date TIMESTAMP NOT NULL ,
                         servico_id UUID,
                         FOREIGN KEY (servico_id) references servico(id) ON DELETE CASCADE ,
                         cliente_id UUID,
                         FOREIGN KEY (cliente_id) references cliente(id) ON DELETE CASCADE ,
                         profissional_id UUID,
                         FOREIGN KEY (profissional_id) references profissional(id) ON DELETE CASCADE
);
