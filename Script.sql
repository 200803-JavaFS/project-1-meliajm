--create database project1;

drop table if exists reimbursement;

create table user_roles (
	user_role_id SERIAL primary key,
	user_role VARCHAR(10) not null
);

create table reimbursement_type (
	reimb_type_id SERIAL primary key,
	reimb_type VARCHAR(10) not null
);

create table reimbursement_status (
	reimb_status_id SERIAL primary key,
	reimb_status VARCHAR(10) not null
);

create table users (
	user_id SERIAL primary key,
	username VARCHAR(50) unique not null,
	user_password VARCHAR(50) not null,
	first_name VARCHAR(100) not null,
	last_name VARCHAR(100) not null,
	email VARCHAR(150) unique not null,
	user_role_id INTEGER references user_roles(user_role_id)
);

create table reimbursement (
	reimb_id SERIAL primary key,
	reimb_amount NUMERIC(12,2),
	reimb_submitted TIME not null,
	reimb_resolved TIME,
	reimb_description VARCHAR(250),
	reimb_author INTEGER references users(user_id) not null,
	reimb_resolver INTEGER references users(user_id),
	reimb_status_id INTEGER references reimbursement_status(reimb_status_id) not null,
	reimb_type_id INTEGER references reimbursement_type(reimb_type_id) not null
)

insert into user_roles (user_role)
	values ('FinanceM'),
	('Employee')
;

insert into reimbursement_type (reimb_type)
	values ('Lodging'),
	('Other'),
	('Travel'),
	('Food')
;

insert into reimbursement_status (reimb_status)
	values ('Approved'),
	('Denied'),
	('Pending')
;

insert into users(username, user_password, first_name, last_name, email, user_role_id)
	values ('captain', 'p', 'el capitan', 'miller',  'captain@mycaptain.com', 1),
	('tiaclair1', 'p', 'tiaclair', 'toomey', 'tia@clair.com', 2)
;

create or replace function get_current_time() returns time with time zone 
as $$
select current_time;
$$ language sql;

select get_current_time();

insert into reimbursement(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)
	values (314.15, get_current_time(), null, 'macros', 2, null, 3, 1)
;

create schema hibernate;

insert into reimbursement(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)
	values (15.16, get_current_time(), null, 'butterfly bubblegum', 4, null, 3, 4)
;

insert into reimbursement(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)
	values (5.43, get_current_time(), null, 'sling shot', 4, null, 3, 2)
;

insert into reimbursement(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)
	values (414.15, get_current_time(), null, 'micros', 2, null, 1, 1)
;

insert into reimbursement(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)
	values (514.15, get_current_time(), null, 'flag', 2, null, 2, 1)
;

select * from reimbursement r where reimb_id = 1;

select * from users where user_id = 10;


insert 
    into
        users
        (email, first_name, last_name, user_password, user_role_id, username) 
    values
        ('email', 'bame', 'big', 'bambig', 2, 'bambis');
        
select
        reimbursem0_.reimb_id as reimb_id1_0_,
        reimbursem0_.reimb_amount as reimb_am2_0_,
        reimbursem0_.reimb_author as reimb_au6_0_,
        reimbursem0_.reimb_description as reimb_de3_0_,
        reimbursem0_.reimb_resolver as reimb_re7_0_,
        reimbursem0_.reimb_status_id as reimb_st8_0_,
        reimbursem0_.reimb_type_id as reimb_ty9_0_,
        reimbursem0_.reimb_resolved as reimb_re4_0_,
        reimbursem0_.reimb_submitted as reimb_su5_0_ 
    from
    reimbursement reimbursem0_;

    
--p
--p
--lemon
--pass
--bambi
--bambig
--pass

--ALTER TABLE users 
--ALTER COLUMN user_password TYPE INTEGER
--USING user_password::integer;

    
    
    
    
ALTER TABLE users 
ADD COLUMN user_hashcode INTEGER;

ALTER TABLE users ALTER COLUMN user_hashcode SET DEFAULT 1216985755;

ALTER TABLE users DROP COLUMN user_hashcode;

--ALTER TABLE users ALTER COLUMN user_hashcode SET default 1216985755 ;

ALTER TABLE users ADD COLUMN user_hashcode INTEGER;

INSERT INTO 
   users (user_hashcode)
VALUES
   (1216985755),
   (1216985755),
   (1216985755),
   (1216985755),
   (1216985755),
   (1216985755),
   (1216985755)
  ;
 
 insert into users(username, user_password, first_name, last_name, email, user_role_id, user_hashcode)
	values ('mona', 'p', 'liza', 'lm',  'lm@mycaptain.com', 2, 1216985755)
;

insert into users(username, user_password, first_name, last_name, email, user_role_id, user_hashcode)
	values ('captini', 'p', 'el cap', 'mills',  'capt@mycaptain.com', 1, 1216985755)
;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        





