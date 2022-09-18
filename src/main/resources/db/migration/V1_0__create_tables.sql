CREATE TABLE product
(
    product_id integer PRIMARY KEY,
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
    account_number varchar(100) NOT NULL,
    account_type varchar(50),
    investor_id integer,
    constraint fk_bnk_investor_id
        foreign key(investor_id) references investor_details(investor_id)
);

CREATE TABLE investor_product
(
    ivp_id serial PRIMARY KEY,
    product_id integer,
    investor_id integer NOT NULL,
    currentBalance decimal(16,2) NOT NULL,
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

insert into investor_details
values(5,'5605050419042','Silindile','Khomo','1956-05-05','77 Umbilo Rd, Dbn 4000','silindile@sgmail.com','0831234567');

insert into product values (1,'Pension', 'RETIREMENT');
insert into product values (2,'Annuity', 'SAVINGS');

insert into investor_product(product_id,investor_id,currentBalance) values (1,5,500000);
insert into investor_product(product_id,investor_id,currentBalance) values (2,5,36000);
