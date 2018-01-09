-- criando banco de dados
-- CREATE DATABASE `poll`;

-- selecionando banco de dados
-- USE `poll`;

-- criando tabela de votação
CREATE TABLE `poll` (
	`poll_id` bigint(20) NOT NULL,
	`poll_description` varchar(255) NOT NULL,
	`poll_views` bigint(20) NOT NULL,
	`poll_created_at` datetime NOT NULL,
	`poll_updated_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- adicionando PK a tabela de votação
ALTER TABLE `poll`
	ADD PRIMARY KEY (`poll_id`);
	
-- adicionando auto incremento na tabela votação
ALTER TABLE `poll`
	MODIFY `poll_id` bigint(20) NOT NULL AUTO_INCREMENT;
	
	
-- criando tabela de opções de votação
CREATE TABLE `poll_option` (
	`option_id` bigint(20) NOT NULL,
	`option_description` varchar(255) NOT NULL,
	`option_votes` bigint(20) NOT NULL,
	`poll_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- adicionando PK a tabela de votação
ALTER TABLE `poll_option`
	ADD PRIMARY KEY (`option_id`);
	
-- adicionando auto incremento na tabela votação
ALTER TABLE `poll_option`
	MODIFY `option_id` bigint(20) NOT NULL AUTO_INCREMENT;

-- adicionando FK entre tabela poll e option
ALTER TABLE `poll_option`
	ADD CONSTRAINT `FK_POLL_OPTION` FOREIGN KEY (`poll_id`) REFERENCES `poll` (`poll_id`);
	
-- adicionando index poll_id na tabela opções de voto
ALTER TABLE `poll_option`
	ADD INDEX `IDX_POLL_ID` (`poll_id`);