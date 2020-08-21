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






