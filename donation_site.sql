drop database online_donation_site;
create database online_donation_site;
use online_donation_site;

create table role
(
    id_role  int primary key auto_increment,
    name varchar(60)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
;

create table user
(
    id_user    int primary key auto_increment,
    email     varchar(75)  not null,
    first_name varchar(50)  not null,
    last_name  varchar(50)  not null,
    password  varchar(150) not null,
    unique (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
;

create table user_role
(
    id_user_role int primary key auto_increment,
    id_user       int not null,
    id_role       int not null,
    foreign key (id_user) references user (id_user),
    foreign key (id_role) references role (id_role)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
;


create table if not exists persistent_logins
(
    username  varchar(100) not null,
    series    varchar(64) primary key,
    token     varchar(64)  not null,
    last_used timestamp    not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;




create table country
(
    id_country   int primary key auto_increment,
    country_name varchar(100)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;







create table department
(
    id_department int primary key auto_increment,
    id_country    int,
    name          varchar(100),
    foreign key (id_country) references country (id_country)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
;

create table document
(
    id_document   int primary key auto_increment,
    document_name varchar(100)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

create table institution
(
    id_institution int primary key auto_increment,
    name           varchar(100),
    id_country     int,
    foreign key (id_country) references country (id_country)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
;


create table donator
(
    id_donator      int primary key auto_increment,
    id_user         int,
    id_document     int,
    document_number varchar(20),
    id_country      int,
    id_department   int,
    foreign key (id_user) references user (id_user),
    foreign key (id_document) references document (id_document),
    foreign key (id_country) references country (id_country),
    foreign key (id_department) references department (id_department)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;


create table donation
(
    id_donation    int primary key auto_increment,
    id_donator     int,
    id_institution int,
    ammount        DECIMAL(13, 2),
    fecha          datetime,
    cc_number	   nvarchar(20),
    foreign key (id_donator) references donator (id_donator),
    foreign key (id_institution) references institution (id_institution)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;



INSERT INTO Role (name)
VALUES ('ROLE_ADMIN'),
       ('ROLE_USER')
;

INSERT INTO User (email, first_name, last_name, password)
VALUES ('admin@gmail.com', 'admin', 'admin', '$2a$10$hKDVYxLefVHV/vtuPhWD3OigtRyOykRLDdUAp80Z1crSoS1lFqaFS'),
       ('user@gmail.com', 'user', 'user', '$2a$10$ByIUiNaRfBKSV6urZoBBxe4UbJ/sS6u1ZaPORHF9AtNWAuVPVz1by');


insert into user_role(id_user, id_role)
values (1, 1),
       (1, 2),
       (2, 2)
;

insert into country (country_name)
values ('El Salvador');
insert into department (id_country, name)
    value (1,'San Salvador');
insert into document(document_name) values ('dui'), ('pasaporte');
insert into institution( name, id_country) values ('Glora Kriete', 1);

insert into donator (id_user,id_document,document_number,id_country,id_department) value(2,1,'12345678-1',1,1);


/* Este es el select que se consideró para la validación pero en ejecución me daba conflicto por la timezone dentro de java y la del server mysql por el UTC aparentemente, cuando comparaba con fecha me daba NULL
select  sum(count_country) as TotalCount
from
    (
        SELECT
            count(c.country_name) as count_country,
            d.id_institution as id_institution,
            c.country_name, d.fecha
        FROM donation as d
        inner join institution i on d.id_institution = i.id_institution
        inner join country c on i.id_country = c.id_country
        where d.fecha between (CURRENT_DATE() - INTERVAL 1 MONTH) AND CURRENT_DATE()
        group by c.country_name
        order by count(d.id_donation) desc

    )a
group by id_institution;*/

