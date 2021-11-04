create table transaction (
id bigint not null auto_increment,
describe_transaction varchar(100) not null,
value numeric(14,5) not null,
type varchar(50) not null,
status varchar(50) not null,
uuid varchar(100) not null,
payment_status varchar(50) not null,
date_transaction varchar(50) not null,
constraint pk_transaction primary key (id),
unique(uuid)
)engine=InnoDB default charset=utf8;