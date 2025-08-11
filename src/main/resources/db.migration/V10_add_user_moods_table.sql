create table user_moods
(
    id               bigint auto_increment
        primary key,
    user_id          bigint                             not null,
    mood_level       tinyint                            not null,
    mood_description varchar(255)                       null,
    notes            text                               null,
    created_at       datetime default current_timestamp not null,
    updated_at       datetime default current_timestamp not null,
    constraint user_moods_profiles_id_fk
        foreign key (user_id) references profiles (id)
);