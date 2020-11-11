create table item_information
(
    item_id                    int auto_increment
        primary key,
    item_type                  varchar(32)      null,
    item_state                 varchar(32)      null,
    item_manf                  varchar(32)      null,
    item_current_location_lat  double default 0 null,
    item_current_location_long double default 0 null
);

