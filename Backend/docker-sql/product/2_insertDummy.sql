insert into shops(shop_name)
values ('빈폴');

insert into categories(parent_category_id, has_child_category, content)
values (null, false, '바지');

insert into products(shop_id, thumbnail_photo_id, category_id, sub_category_id, sale_id, serial_number, product_state,
                     product_name, product_desc, gender, price, register_dt)
values (1, 1, 1, null, null, 'SERIAL_NUMBER', 'REGISTERED', '데님 바지', '남자 데님 바지', 'MALE', 78000, null);
