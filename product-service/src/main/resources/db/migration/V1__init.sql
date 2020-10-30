create table products (
      id serial primary key,
      title varchar(50) not null,
      price numeric not null,
      old_price numeric default -1,
      on_create timestamp default current_timestamp,
      on_update timestamp default current_timestamp,
      enabled boolean not null
);

create or replace function update_date() returns trigger as $$
declare
    i integer;
begin
    i = old.id;
    update products set on_update = now() where id = i;
return new;
end;
$$ language 'plpgsql';

create trigger update_date_trigger after update on products for each row when (old.* is distinct from new.*) execute procedure update_date();

insert into products(title, price, enabled)
values ('milk', 120, true), ('choclate', 200, true),
       ('ananas', 300, true), ('lemon', 60, true),
       ('mango', 260, true), ('coffie', 100, true);