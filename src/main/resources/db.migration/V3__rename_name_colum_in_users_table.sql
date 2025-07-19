alter table users
    change name first_name varchar(255) not null;

alter table users
    add last_name varchar(255) not null;