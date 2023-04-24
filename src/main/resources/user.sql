-- insert into user (first_name, last_name, login, password) values ('Ryslan', 'Zaitsev', '1111', '2222');
-- insert into user (first_name, last_name, login, password) VALUES ('Oleg', 'Petrov', '3333', '4444');

create table users (
                       id int auto_increment,
                       user_name varchar(50),
                       password varchar(150),
                       first_name varchar(50) unique,
                       last_name varchar(50),
                       gender varchar(50),
                       primary key (id)
);

create table roles(
                      id int auto_increment,
                      role_name varchar(50) not null,
                      primary key (id)
);

create table users_roles (
                             user_id int not null,
                             role_id int not null,
                             primary key (user_id, role_id),
                             foreign key (user_id) references users (id),
                             foreign key (role_id) references roles (id)
);

insert into users (user_name, password, first_name, last_name, gender)
VALUES ('qwerty', '12345', 'Ruslan', 'Zaitsev', 'men');

insert into roles (role_name)
values ('ROLE_USER'), ('ROLE_ADMIN');

insert into users (user_name, password, first_name, last_name, gender)
VALUES ('qwerty213', '56789', 'Olga', 'Petrova', 'woman');

insert into users_roles (user_id, role_id) VALUES (2, 1);

insert into users_roles (user_id, role_id) values (1, 2);
