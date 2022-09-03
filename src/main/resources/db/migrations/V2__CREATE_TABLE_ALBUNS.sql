CREATE TABLE albuns(
    id INT NOT NULL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL ,
    descricao LONGTEXT NULL,
    situacao ENUM('ATIVADO','DESATIVADO','EXCLUIDO','PENDENTE')
);