-- DDL
CREATE TABLE IF NOT EXISTS usuarios(
  id BIGSERIAL PRIMARY KEY,
  nome VARCHAR(120) NOT NULL,
  email VARCHAR(160) NOT NULL UNIQUE,
  tipo VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS eletronicos(
  id BIGSERIAL PRIMARY KEY,
  nome VARCHAR(120) NOT NULL,
  descricao TEXT NOT NULL,
  estado VARCHAR(40) NOT NULL,
  disponivel BOOLEAN NOT NULL DEFAULT TRUE,
  doador_id BIGINT NOT NULL REFERENCES usuarios(id)
);

CREATE TABLE IF NOT EXISTS doacoes(
  id BIGSERIAL PRIMARY KEY,
  eletronico_id BIGINT NOT NULL REFERENCES eletronicos(id),
  estudante_id BIGINT NOT NULL REFERENCES usuarios(id),
  status VARCHAR(20) NOT NULL,
  data DATE NOT NULL
);

-- DML (exemplo)
INSERT INTO usuarios (nome, email, tipo) VALUES
('Ana Doadora','ana@exemplo.com','DOADOR')
ON CONFLICT DO NOTHING;

INSERT INTO usuarios (nome, email, tipo) VALUES
('Bruno Estudante','bruno@exemplo.com','ESTUDANTE')
ON CONFLICT DO NOTHING;

INSERT INTO eletronicos (nome, descricao, estado, disponivel, doador_id) VALUES
('Notebook HP','Core i5, 8GB, 256GB SSD','usado-bom', TRUE, 1);

INSERT INTO doacoes (eletronico_id, estudante_id, status, data) VALUES
(1, 2, 'EM_TRIAGEM', CURRENT_DATE);
