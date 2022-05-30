create table users
(
    id       serial
        primary key,
    email    varchar(255),
    password varchar(255)
);

create table skills
(
    id          serial
        primary key,
    skills_name varchar(255)
);

create table cities
(
    id   serial
        primary key,
    city varchar(255)
);

create table position
(
    id            serial
        primary key,
    position_name varchar(255)
);

create table school
(
    id          serial
        primary key,
    school_name varchar(255),
    cities_id   integer
        constraint fk52ex7ghds8ob6hjbkd71cf9ap
            references cities
);

create table links_type
(
    id        serial
        primary key,
    link_type varchar(255)
);

create table languages
(
    id            serial
        primary key,
    language_name varchar(255)
);

create table job_tittles
(
    id     serial
        primary key,
    tittle varchar(255)
);

create table employers
(
    company_names varchar(255),
    phone_number  varchar(255),
    web_adress    varchar(255),
    id            integer not null
        primary key
        constraint fknnl4ba0tc831e25ufip4ek2yq
            references users
);

create table experiences
(
    id           serial
        primary key,
    company_name varchar(255)
);

create table job_advertisement
(
    id              serial
        primary key,
    active_date     date,
    is_active       boolean,
    job_description varchar(255),
    last_date       date,
    open_position   integer,
    salary_max      integer,
    salary_min      integer,
    city_id         integer
        constraint fk4hy6kja8d0shrxgmywo4c1mq1
            references cities,
    employer_id     integer
        constraint fkomwppvulush1crsot9mkarjhd
            references employers,
    job_tittle_id   integer
        constraint fkgsn7mawgm5aj588suluu9bfj3
            references job_tittles
);

create table employees
(
    first_name varchar(255),
    last_name  varchar(255),
    id         integer not null
        primary key
        constraint fkd6th9xowehhf1kmmq1dsseq28
            references users
);

create table department
(
    id              serial
        primary key,
    department_name varchar(255)
);

create table candidates
(
    birth_year      integer,
    first_name      varchar(255),
    identity_number varchar(255),
    last_name       varchar(255),
    id              integer not null
        primary key
        constraint fkpwx8qcbu3swnypnelf5b8db9j
            references users
);

create table candidates_skills
(
    id            serial
        primary key,
    candidates_id integer
        constraint fkiec4us8mccwen0j2pj216i3la
            references candidates,
    skills_id     integer
        constraint fkij2smahjf48hbptup20myocsa
            references skills
);

create table candidates_school
(
    id            serial
        primary key,
    ended_year    varchar(255),
    started_year  varchar(255),
    candidates_id integer
        constraint fk6ogb1v4bmuvan6ivcux00qhpw
            references candidates,
    department_id integer
        constraint fkfem64ikb4ihvhpd4hroc9f9v0
            references department,
    school_id     integer
        constraint fknl28px2rpqlabqdgrepd66dyb
            references school
);

create table candidates_links
(
    id            serial
        primary key,
    link          varchar(255),
    candidates_id integer
        constraint fkjxvyqj4f5ocl4bx7mp4e1j7s3
            references candidates,
    links_type_id integer
        constraint fk13stkkc4h7wt3xxumpk62gr74
            references links_type
);

create table candidates_languages
(
    id            serial
        primary key,
    level         integer,
    candidates_id integer
        constraint fk7wgpaku7rirk2jwdj8rv95rd8
            references candidates,
    languages_id  integer
        constraint fk6ko27slg5cqo38pbf6kcav9yt
            references languages
);

create table candidates_experience
(
    id            serial
        primary key,
    last_date     varchar(255),
    start_date    varchar(255),
    candidates_id integer
        constraint fk7k66qi385fncvben29o6oy8n7
            references candidates,
    experience_id integer
        constraint fk928u497ajrxopsglg31ppjlp7
            references experiences,
    position_id   integer
        constraint fkp0ykg6g5ykcgb7vscsrwfhgyj
            references position
);



