insert into address (id, city, post_code, state, street)
			values(1, 'Mornington', '7018', 'TAS', 'Kallora');

insert into user_table (user_id, account_non_expired, account_non_locked, credentials_non_expired , 
							enabled, password, username,firstn, gender, last_name, title, address_id, role)
			values 
				(1, true, true, true, true,'123', 'rihanna','rihanna', 1, 'zekri', 1, 1, 'ROLE_ADMIN'),
				(2, true, true, true, true,'1234', 'user1','user1', 1, 'user1', 2, 1, 'ROLE_USER'),
				(3, true, true, true, true,'12345', 'user2','user2', 1, 'user2', 2, 1, 'ROLE_USER'),
				(4, true, true, true, true,'123456', 'user3','user3', 1, 'user3', 3, 1, 'ROLE_USER'),
				(5, true, true, true, true,'1234567', 'user4','user4', 1, 'user4', 1, 1, 'ROLE_USER'),
				(6, true, true, true, true,'12345678', 'user5','user5', 1, 'user5', 1, 1, 'ROLE_USER');
