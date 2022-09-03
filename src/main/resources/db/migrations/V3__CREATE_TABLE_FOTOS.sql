CREATE TABLE fotos(
    id INT NOT NULL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL ,
    endereco TEXT NOT NULL ,
    descricao LONGTEXT NULL ,
    album_id INT NOT NULL ,
    FOREIGN KEY albuns(album_id) REFERENCES albuns(id)
);