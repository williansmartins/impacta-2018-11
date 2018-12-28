-- select
select * from user;
select * from role;
select * from user_role;
select password from user where user_id = 1;

-- delete
delete from user where user_id in (20);
delete from user_role where user_id in (2,17,19)

-- update
update user
set password = "$2a$10$Cqko2kb1LlDUkRb1g.FiQ.bvJrQtsXXqZCLKkWA1Po5CmxBxFAL8q" 
where user_id = 19