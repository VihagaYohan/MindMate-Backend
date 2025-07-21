create table profiles
(
    id         bigint auto_increment
        primary key,
    first_name varchar(255)                         not null,
    last_name  varchar(255)                         not null,
    gender     varchar(10)                          not null,
    created_at DATETIME default current_timestamp() not null,
    updated_at DATETIME default current_timestamp   null on update current_timestamp,
    constraint profiles_contact_persons_id_fk
        foreign key (id) references contact_persons (id)
);
