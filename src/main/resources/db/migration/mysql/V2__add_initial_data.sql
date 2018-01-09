INSERT INTO `poll`.`poll` (`poll_description`, `poll_views`, `poll_created_at`, `poll_updated_at`)
	VALUES ('This is the question', 0, '2018-01-08 23:28:58', '2018-01-08 23:28:58');
	
INSERT INTO `poll`.`poll_option` (`option_description`, `option_votes`, `poll_id`) 
	VALUES ('First option', 0, '1');

INSERT INTO `poll`.`poll_option` (`option_description`, `option_votes`, `poll_id`) 
	VALUES ('Second option', 0, '1');

INSERT INTO `poll`.`poll_option` (`option_description`, `option_votes`, `poll_id`) 
	VALUES ('Third option', 0, '1');
	
	