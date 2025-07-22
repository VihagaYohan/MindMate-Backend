create table contact_persons
(
    id            bigint auto_increment
        primary key,
    first_name    varchar(255) not null,
    last_name     varchar(255) not null,
    mobile_number varchar(20)  not null
);

