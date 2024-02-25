create table authority
(
    name varchar(50) not null,
    primary key (name)
) engine=InnoDB;

create table category
(
    id                 bigint       not null auto_increment,
    name               varchar(100) not null,
    status             integer,
    created_date       datetime(6),
    last_modified_date datetime(6),
    primary key (id)
) engine=InnoDB;

create table sub_category
(
    id                 bigint       not null auto_increment,
    name               varchar(100) not null,
    image              varchar(250),
    category_id        bigint,
    status             integer,
    created_date       datetime(6),
    last_modified_date datetime(6),
    primary key (id)
) engine=InnoDB;

create table product
(
    id                 bigint       not null auto_increment,
    code               varchar(20)  not null,
    name               varchar(100) not null,
    image              varchar(150),
    description        varchar(255),
    sub_category_id        bigint,
    promotion_id       bigint,
    status             integer,
    created_date       datetime(6),
    last_modified_date datetime(6),
    primary key (id)
) engine=InnoDB;
create table product_detail
(
    id                 bigint       not null auto_increment,
    sku                varchar(30)  not null,
    name               varchar(100) not null,
    price              float(23)    not null,
    product_id         bigint,
    featured           float(23),
    sold               integer,
    status             integer,
    created_date       datetime(6),
    created_by         varchar(50)  not null,
    last_modified_by   varchar(50),
    last_modified_date datetime(6),
    primary key (id)
) engine=InnoDB;
create table product_de_variant_op
(
    product_detail_id bigint not null,
    variant_option_id bigint not null,
    primary key (product_detail_id, variant_option_id)
) engine=InnoDB;
create table promotion
(
    id                 bigint      not null auto_increment,
    code               varchar(50) not null,
    name               varchar(100),
    type               bit         not null,
    value              decimal(38, 2),
    start_date         datetime(6),
    end_date           datetime(6),
    max_spend          decimal(38, 2),
    min_spend          decimal(38, 2),
    quantity_used      integer,
    status             integer,
    created_date       datetime(6),
    last_modified_date datetime(6),
    primary key (id)
) engine=InnoDB;
create table user
(
    id                 bigint      not null auto_increment,
    login              varchar(50) not null,
    email              varchar(254),
    first_name         varchar(50),
    middle_name        varchar(50),
    last_name          varchar(50),
    password_hash      varchar(60) not null,
    image_url          varchar(256),
    activated          bit         not null,
    lang_key           varchar(10),
    activation_key     varchar(20),
    reset_key          varchar(20),
    created_by         varchar(50) not null,
    last_modified_by   varchar(50),
    created_date       datetime(6),
    last_modified_date datetime(6),
    reset_date         datetime(6),
    primary key (id)
) engine=InnoDB;
create table user_authority
(
    user_id        bigint      not null,
    authority_name varchar(50) not null,
    primary key (user_id, authority_name)
) engine=InnoDB;
create table variation
(
    id                 bigint       not null auto_increment,
    name               varchar(100) not null,
    category_id        bigint,
    status             integer,
    created_date       datetime(6),
    last_modified_date datetime(6),
    primary key (id)
) engine=InnoDB;
create table variation_option
(
    id                 bigint       not null auto_increment,
    name               varchar(150) not null,
    status             integer,
    created_date       datetime(6),
    last_modified_date datetime(6),
    primary key (id)
) engine=InnoDB;
alter table user
    add constraint UK_ew1hvam8uwaknuaellwhqchhb unique (login);
alter table user
    add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email);
alter table sub_category
    add constraint FKs2ride9gvilxy2tcuv7witnxc foreign key (category_id) references category (id);
alter table product
    add constraint FK1mtsbur82frn64de7balymq9s foreign key (sub_category_id) references sub_category (id);
alter table product
    add constraint FKcli9x921yidy04cx25k6m46fy foreign key (promotion_id) references promotion (id);
alter table product_detail
    add constraint FKilxoi77ctyin6jn9robktb16c foreign key (product_id) references product (id);
alter table product_de_variant_op
    add constraint FKr177ssdy3y7h09v938d1ue94h foreign key (variant_option_id) references variation_option (id);
alter table product_de_variant_op
    add constraint FKe4n4peanqg6yn6415qors51kx foreign key (product_detail_id) references product_detail (id);
alter table user_authority
    add constraint FK6ktglpl5mjosa283rvken2py5 foreign key (authority_name) references authority (name);
alter table user_authority
    add constraint FKpqlsjpkybgos9w2svcri7j8xy foreign key (user_id) references user (id);
alter table variation
    add constraint FKcyhn1nd52sy3lm12vm62f5cmg foreign key (category_id) references category (id);