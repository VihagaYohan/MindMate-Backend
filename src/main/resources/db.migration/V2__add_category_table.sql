create table Category
(
    id               bigint auto_increment
        primary key,
    title            varchar(255) not null,
    background_color varchar(255) not null
);