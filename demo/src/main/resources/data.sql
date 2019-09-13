insert into users (username, password, enabled) values ('admin','$2a$12$pWttrXAfUGCyte7/pPTDTOjhqZMXZjdr5FM9ojrUbgo429wpU2Hiu',1);
insert into users (username, password, enabled) values ('user','$2a$10$2OEfhUjcMBKjUjKE/wavoeGmQa53wKCYyVDz6AErr8hGMhkiUL8IW',1);


insert into authorities (username, authority) values ('admin','ROLE_ADMIN');
insert into authorities (username, authority) values ('admin','ROLE_USER');
insert into authorities (username, authority) values ('user','ROLE_USER');



