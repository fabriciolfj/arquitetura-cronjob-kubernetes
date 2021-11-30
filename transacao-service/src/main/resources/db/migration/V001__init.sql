create table transaction (
id bigint not null auto_increment,
describe_transaction varchar(100) not null,
value numeric(14,5) not null,
status varchar(50) not null,
uuid varchar(100) not null,
date_transaction varchar(50) not null,
constraint pk_transaction primary key (id),
unique(uuid)
);

create table payment (
id bigint not null auto_increment,
value numeric(15,4) not null,
status varchar(30) not null,
type varchar(30) not null,
transaction_id bigint not null,
constraint fk_transaction foreign key (transaction_id) references transaction(id),
constraint pk_payment primary key (id)
);