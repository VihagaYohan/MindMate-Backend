alter table profiles
    add contact_person_id bigint null;

alter table profiles
    add constraint profiles_contact_persons_id_fk
        foreign key (contact_person_id) references contact_persons (id);