alter table users
    add constraint users_profiles_id_fk
        foreign key (id) references profiles (id)
            on delete cascade;

alter table profiles
    add constraint profiles_users_id_fk
        foreign key (id) references users (id);