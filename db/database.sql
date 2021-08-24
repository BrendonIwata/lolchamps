create database LolChamps;

CREATE TABLE campeao (
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(255) NOT NULL,
    anoLancamento DATE NOT NULL,
    rework TINYINT NOT NULL DEFAULT 0,
    posicaoPrimaria ENUM('SUPORTE', 'ATIRADOR', 'MID', 'JUNGLE', 'TOP')
);

