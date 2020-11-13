create table itemDto
(
    item_id                    int auto_increment
        primary key,
    item_type                  varchar(32)      null,
    item_state                 varchar(32)      null,
    item_manf                  varchar(32)      null,
    latitude  double default 0 null,
    longitude double default 0 null
);

