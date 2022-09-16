CREATE TABLE product
(
    product_id serial PRIMARY KEY,
    product_name varchar(100) NOT NULL,
    product_type varchar(100) NOT NULL
);

CREATE TABLE investor_details
(
    investor_id serial PRIMARY KEY,
    idnumber varchar(14) NOT NULL UNIQUE,
    investor_name varchar(100) NOT NULL,
    surname varchar(100) NOT NULL,
    dob date NOT NULL ,
    address varchar(1000) DEFAULT NULL,
    email varchar(100) DEFAULT NULL,
    contact_number varchar(20) DEFAULT NULL
);

CREATE TABLE bank_details
(
    bank_details_id serial PRIMARY KEY,
    bank_name varchar(100) NOT NULL,
    account_number decimal NOT NULL,
    account_type varchar(50),
    investor_id integer,
    constraint fk_investor_id
        foreign key(investor_id) references investor_details(investor_id)
);

CREATE TABLE investor_product
(
    ivp_id serial PRIMARY KEY,
    product_id integer,
    investor_id integer NOT NULL,
    currentBalance decimal NOT NULL,
    constraint fk_product_id
        foreign key(product_id) references product(product_id),
    constraint fk_investor_id
    foreign key(investor_id) references investor_details(investor_id)
);

CREATE TABLE withdrawal
(
    withdrawal_id serial PRIMARY KEY,
    investor_product_id integer,
    withdrawal_time timestamp NOT NULL default current_timestamp,
    withdrawal_amount decimal(16,2),
    opening_balance decimal(16,2),
    closing_balance decimal(16,2),
    constraint fk_investor_product
        foreign key(investor_product_id) references investor_product(ivp_id)
);

CREATE TABLE status_log
(
    log_id serial PRIMARY KEY,
    withdrawal_id integer,
    current_status varchar(10) NOT NULL,
    status_time timestamp NOT NULL default current_timestamp,
    constraint fk_withdrawal_id
        foreign key(withdrawal_id) references withdrawal(withdrawal_id)
);

insert into investor_details (idnumber,investor_name, surname, dob,address,email,contact_number)
values('52417457542','Senzo','Maphumulo','1995-10-06','P.O. Box 114 Johannesburg 2000','senzo@email.com','0914236547');

insert into product(product_name, product_type) values ('Pension', 'RETIREMENT');
insert into product(product_name, product_type) values ('Annuity', 'SAVINGS');
