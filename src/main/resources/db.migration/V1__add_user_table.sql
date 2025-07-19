create table users
(
    id       bigint auto_increment primary key,
    email    varchar(255) not null,
    password varchar(255) not null,
    name varchar(255) not null,
    username varchar(255) not null,
    gender varchar(20) not null,
    birth_date DATE,
    created_at TIMESTAMP not null default current_timestamp,
    updated_at TIMESTAMP not null default current_timestamp on update current_timestamp,
    is_active boolean not null default true,
    role varchar(50) not null default 'USER',
    profile_image_url varchar(255),
    language varchar(20) default 'en'
);