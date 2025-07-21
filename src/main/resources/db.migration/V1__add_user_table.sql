create table users
(
    id         bigint auto_increment
        primary key,
    email      varchar(255)                       not null UNIQUE,
    password   varchar(255)                       not null,
    created_at DATETIME default current_timestamp null,
    updated_at DATETIME                           null on update current_timestamp,
    constraint users_profiles_id_fk
        foreign key (id) references profiles (id)
);
