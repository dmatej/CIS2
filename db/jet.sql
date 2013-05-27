grant dba to "informix";
grant dba to "cis";


grant "extend" to "cis" ;


{ TABLE "cis".image row size = 64 number of columns = 3 index size = 14 }
create table "cis".image
  (
    id serial not null constraint "cis".n_image_id,
    data byte
  );

revoke all on "cis".image from "public" as "cis";


{ TABLE "cis".identity row size = 278 number of columns = 20 index size = 300
              }
create table "cis".identity
  (
    id serial not null constraint "cis".n_identity_id,
    idorgunit integer
        default -1 not null constraint "cis".n_identity_idorgunit,
    idperson integer,
    birthdate char(8)
        default '00000000' not null constraint "cis".n_identity_birthdate,
    sex char(1),
    idstate integer
        default 1 not null constraint "cis".n_identity_idstate,
    validfrom date,
    validto date,
    idstateofbirth integer
        default 1 not null constraint "cis".n_identity_idstateofbirth,
    rstatus integer
        default 0 not null constraint "cis".n_identity_rstatus,
    birthnumber varchar(10)
        default '' not null constraint "cis".n_identity_birthnumber,
    firstname nvarchar(24)
        default '' not null constraint "cis".n_identity_firstname,
    lastname nvarchar(50)
        default '' not null constraint "cis".n_identity_lastname,
    birthname nvarchar(35)
        default '' not null constraint "cis".n_identity_birthname,
    othernames nvarchar(35)
        default '' not null constraint "cis".n_identity_othernames,
    birthplace nvarchar(48)
        default '' not null constraint "cis".n_identity_birthplace,

    check ((sex IS NULL ) OR (sex IN ('X' ,'M' ,'Z' )) ) constraint
              "cis".c_identity_sex
  );

revoke all on "cis".identity from "public" as "cis";


{ TABLE "cis".message row size = 289 number of columns = 7 index size = 9 }
create table "cis".message
  (
    id serial not null constraint "cis".n_message_id,
    type char(1)
        default 'A',
    validfrom datetime year to second
        default current year to second,
    validto datetime year to second not null constraint "cis".n_message_validto,
    text varchar(255),
    cidcisuser integer not null constraint "cis".n_message_cidcisuser,
    cdate datetime year to second
        default current year to second,

    check ((type IS NULL ) OR (type IN ('A' ,'L' )) ) constraint "cis".c_message_type
  );

revoke all on "cis".message from "public" as "cis";


{ TABLE "cis".code_documenttype row size = 338 number of columns = 15 index size = 16
              }
create table "cis".code_documenttype
  (
    id serial not null constraint "cis".n_code_documenttype_id,
    code char(2) not null constraint "cis".n_code_documenttype_code,
    rank smallint,
    validfrom date
        default  '01.01.1900',
    validto date
        default  '31.12.2999',
    name nvarchar(50),
    note varchar(255)
  );

revoke all on "cis".code_documenttype from "public" as "cis";


{ TABLE "cis".code_permissiontype row size = 498 number of columns = 14 index size =
              25 }
create table "cis".code_permissiontype
  (
    id serial not null constraint "cis".n_code_permissiontype_id,
    code char(2) not null constraint "cis".n_code_permissiontype_code,
    rank smallint,
    validfrom date
        default  '01.01.1900',
    validto date
        default  '31.12.2999',
    name varchar(72),
    note varchar(255)
  );

revoke all on "cis".code_permissiontype from "public" as "cis";


{ TABLE "cis".code_state row size = 2452 number of columns = 33 index size = 339 }
create table "cis".code_state
  (
    id serial not null constraint "cis".n_code_state_id,
    idstate integer,
    rank smallint,
    code char(3) not null constraint "cis".n_code_state_code,
    code_icao char(3) not null constraint "cis".n_code_state_code_icao,
    code_iso char(2),
    name nvarchar(23,3),
    name_cz nvarchar(50) not null constraint "cis".n_code_state_name_cz,
    name_en varchar(50) not null constraint "cis".n_code_state_name_en,
    name_nativ varchar(50),
    name_full nvarchar(60),
    name_upper nvarchar(50),
    note varchar(50),
    validfrom date
        default  '01.01.1900' not null constraint "cis".n_code_state_validfrom,
    validto date
        default  '31.12.2999' not null constraint "cis".n_code_state_validto
  );

revoke all on "cis".code_state from "public" as "cis";


{ TABLE "cis".code_purposeofstay row size = 335 number of columns = 8 index size = 16
              }
create table "cis".code_purposeofstay
  (
    id serial not null constraint "cis".n_code_purposeofstay_id,
    code char(2) not null constraint "cis".n_code_purposeofstay_code,
    rank smallint,
    validfrom date
        default  '01.01.1900',
    validto date
        default  '31.12.2999',
    name varchar(60) not null constraint "cis".n_code_purposeofstay_name,
    note varchar(255)
  );

revoke all on "cis".code_purposeofstay from "public" as "cis";


{ TABLE "cis".cisuser row size = 2241 number of columns = 23 index size = 109 }
create table "cis".cisuser
  (
    id serial not null constraint "cis".n_cisuser_id,
    idorgunit integer,
    uid char(8) not null constraint "cis".n_cisuser_uid,
    surname nvarchar(35) not null constraint "cis".n_cisuser_surname,
    name nvarchar(24) not null constraint "cis".n_cisuser_name,
    degreeprefix varchar(35),
    degreesuffix varchar(10),
    blocked integer,
    forcepwdchange integer,
    cidcisuser integer,
    cdate datetime year to second not null constraint "cis".n_cisuser_cdate,
    validfrom date
        default  '01.01.1900' not null constraint "cis".n_cisuser_validfrom,
    validto date
        default  '31.12.2999' not null constraint "cis".n_cisuser_validto,
    didcisuser integer,
    ddate datetime year to second,
    uidcisuser integer,
    udate datetime year to second,
    lastbadlogin datetime year to second,
    badlogincount smallint,
    lastlogin datetime year to second,
    info lvarchar(2040)
  );

revoke all on "cis".cisuser from "public" as "cis";

{ TABLE "cis".password row size = 317 number of columns = 10 index size = 295
              }
create table "cis".password
  (
    id serial not null constraint "cis".n_password_id,
    idcisuser integer not null constraint "cis".n_password_idcisuser,
    validfrom date
        default  '01.01.1900' not null constraint "cis".n_password_validfrom,
    validto date
        default  '31.12.2999' not null constraint "cis".n_password_validto,
    cidcisuser integer,
    cdate datetime year to second not null constraint "cis".n_password_cdate,
    didcisuser integer,
    ddate datetime year to second,
    algorithm varchar(20),
    password varchar(255) not null constraint "cis".n_password_password
  );
revoke all on "cis".password from "public" as "cis";

{ TABLE "cis".cispermission row size = 650 number of columns = 13 index size = 74
              }
create table "cis".cispermission
  (
    id serial not null constraint "cis".n_cispermission_id,
    code varchar(30) not null constraint "cis".n_cispermission_code,
    name varchar(50) not null constraint "cis".n_cispermission_name,
    description varchar(255),
    validfrom datetime year to second
        default  datetime (1900-01-01 00:00:00) year to second not null constraint
              "cis".n_cispermission_validfrom,
    validto datetime year to second
        default  datetime (2999-12-31 23:59:59) year to second not null constraint
              "cis".n_cispermission_validto,
    cidcisuser integer,
    cdate datetime year to second
        default current year to second not null constraint "cis".n_cispermission_cdate,
    didcisuser integer,
    ddate datetime year to second,
    uidcisuser integer,
    udate datetime year to second,
    annotation varchar(255)
  );

revoke all on "cis".cispermission from "public" as "cis";


{ TABLE "cis".orgunit row size = 516 number of columns = 24 index size = 80 }
create table "cis".orgunit
  (
    id serial not null constraint "cis".n_orgunit_id,
    code char(7) not null constraint "cis".n_orgunit_code,
    unittype integer not null constraint "cis".n_orgunit_unittype,
    phone1 char(13),
    phone2 char(13),
    fax char(13),
    email varchar(65),
    validfrom date
        default  '01.01.1900' not null constraint "cis".n_orgunit_validfrom,
    validto date
        default  '31.12.2999' not null constraint "cis".n_orgunit_validto,
    unitname nvarchar(65) not null constraint "cis".n_orgunit_unitname,
    cidcisuser integer,
    cdate datetime year to second,
    didcisuser integer,
    ddate datetime year to second,
    uidcisuser integer,
    udate datetime year to second,
    note varchar(255)
  );

revoke all on "cis".orgunit from "public" as "cis";


{ TABLE "cis".cisrole row size = 388 number of columns = 13 index size = 73 }
create table "cis".cisrole
  (
    id serial not null constraint "cis".n_cisrole_id,
    type smallint not null constraint "cis".n_cisrole_type,
    code varchar(30) not null constraint "cis".n_cisrole_code,
    name varchar(50) not null constraint "cis".n_cisrole_name,
    description varchar(255),
    validfrom date
        default  '01.01.1900' not null constraint "cis".n_cisrole_validfrom,
    validto date
        default  '31.12.2999' not null constraint "cis".n_cisrole_validto,
    cidcisuser integer,
    cdate datetime year to second not null constraint "cis".n_cisrole_cdate,
    didcisuser integer,
    ddate datetime year to second,
    uidcisuser integer,
    udate datetime year to second
  );

revoke all on "cis".cisrole from "public" as "cis";


{ TABLE "cis".cisuserrole row size = 44 number of columns = 9 index size = 52 }
create table "cis".cisuserrole
  (
    id serial not null constraint "cis".n_cisuserrole_id,
    idcisuser integer not null constraint "cis".n_cisuserrole_idcisuser,
    idrole integer not null constraint "cis".n_cisuserrole_idrole,
    validfrom date
        default  '01.01.1900' not null constraint "cis".n_cisuserrole_validfrom,
    validto date
        default  '31.12.2999' not null constraint "cis".n_cisuserrole_validto,
    cidcisuser integer,
    cdate datetime year to second not null constraint "cis".n_cisuserrole_cdate,
    didcisuser integer,
    ddate datetime year to second
  );

revoke all on "cis".cisuserrole from "public" as "cis";


{ TABLE "cis".cisrolepermission row size = 44 number of columns = 9 index size = 43 }
create table "cis".cisrolepermission
  (
    id serial not null constraint "cis".n_cisrolepermission_id,
    idrole integer not null constraint "cis".n_cisrolepermission_idrole,
    idpermission integer not null constraint "cis".n_cisrolepermission_idpermission,
    validfrom date
        default  '01.01.1900' not null constraint "cis".n_cisrolepermission_validfrom,
    validto date
        default  '31.12.2999' not null constraint "cis".n_cisrolepermission_validto,
    cidcisuser integer,
    cdate datetime year to second not null constraint "cis".n_cisrolepermission_cdate,
    didcisuser integer,
    ddate datetime year to second
  );

revoke all on "cis".cisrolepermission from "public" as "cis";


{ TABLE "cis".tduperson row size = 2388 number of columns = 55 index size = 80 }
create table "cis".tduperson
  (
    id serial not null constraint "cis".n_tduperson_id,
    idperson_original integer,
    ididentity_actual integer,
    idstay_actual integer
        default -1,
    idstayplace_actual integer
        default -1,
    idimage integer,
    iddeathplace integer,
    iddeathstate integer,
    idcisuser integer,
    deathdate date,
    degreeprefix varchar(15),
    degreesuffix varchar(15),
    deathplace varchar(30),
    note lvarchar,
    rstatus integer
        default 0 not null constraint "cis".n_tduperson_rstatus,
    cidcisuser integer
        default -2 not null constraint "cis".n_tduperson_cidcisuser,
    uidcisuser integer,
    didcisuser integer,
    cdate datetime year to second
        default current year to second not null constraint "cis".n_tduperson_cdate,
    udate datetime year to second,
    ddate datetime year to second
  );

revoke all on "cis".tduperson from "public" as "cis";


{ TABLE "cis".tdustayplace row size = 399 number of columns = 25 index size = 99
              }
create table "cis".tdustayplace
  (
    id serial not null constraint "cis".n_tdustayplace_id,
    idperson integer not null constraint "cis".n_tdustayplace_idperson,
    idperson_original integer,
    idtdustay integer,
    address varchar(255),
    idorgunit integer,
    datefrom date
        default  '01.01.1900' not null constraint "cis".n_tdustayplace_datefrom,
    dateto date
        default  '31.12.2999' not null constraint "cis".n_tdustayplace_dateto,
    rstatus integer
        default 0 not null constraint "cis".n_tdustayplace_rstatus,
    cidcisuser integer
        default -2 not null constraint "cis".n_tdustayplace_cidcisuser,
    uidcisuser integer,
    didcisuser integer,
    cdate datetime year to second
        default current year to second not null constraint "cis".n_tdustayplace_cdate,
    udate datetime year to second,
    ddate datetime year to second,
    note varchar(255)
  );

revoke all on "cis".tdustayplace from "public" as "cis";


{ TABLE "cis".tdustay row size = 2232 number of columns = 35 index size = 126 }
create table "cis".tdustay
  (
    id serial not null constraint "cis".n_tdustay_id,
    idperson integer not null constraint "cis".n_tdustay_idperson,
    idperson_original integer,
    idpobytucel integer,
    idorgunit integer,
    idorgunituziv integer,
    pkp char(10),
    refnumber char(27),
    datefrom date,
    grantedfrom date
        default  '01.01.1900' not null constraint "cis".n_tdustay_grantedfrom,
    grantedto date
        default  '01.01.1900' not null constraint "cis".n_tdustay_grantedto,
    arrivaldate date,
    terminationdate date,
    visaapplicationnumber varchar(16),
    note lvarchar(2040),
    rstatus integer
        default 0 not null constraint "cis".n_tdustay_rstatus,
    cidcisuser integer
        default -2 not null constraint "cis".n_tdustay_cidcisuser,
    uidcisuser integer,
    didcisuser integer,
    cdate datetime year to second
        default current year to second not null constraint "cis".n_tdustay_cdate,
    udate datetime year to second,
    ddate datetime year to second
  );

revoke all on "cis".tdustay from "public" as "cis";


{ TABLE "cis".tdudocument row size = 2203 number of columns = 31 index size = 96 }
create table "cis".tdudocument
  (
    id serial not null constraint "cis".n_tdudocument_id,
    idperson integer not null constraint "cis".n_tdudocument_idperson,
    idperson_original integer,
    ididentity integer not null constraint "cis".n_tdudocument_ididentity,
    idtdustay integer,
    idcodedocumenttype integer not null constraint "cis".n_tdudocument_idcodedocumenttype,
    idstateissued integer,
    idorgunitissued integer,
    idcisuser integer,
    number char(15),
    issued date,
    validfrom date
        default  '01.01.1900' not null constraint "cis".n_tdudocument_validfrom,
    validto date
        default  '31.12.2999' not null constraint "cis".n_tdudocument_validto,
    dateofreceipt date,
    dateofrenewal date,
    dateofcancel date,
    note lvarchar(2040),
    rstatus integer
        default 0 not null constraint "cis".n_tdudocument_rstatus,
    cidcisuser integer
        default -2 not null constraint "cis".n_tdudocument_cidcisuser,
    uidcisuser integer,
    didcisuser integer,
    cdate datetime year to second
        default current year to second not null constraint "cis".n_tdudocument_cdate,
    udate datetime year to second,
    ddate datetime year to second,
    visaapplicationnumber varchar(16)
  );
revoke all on "cis".tdudocument from "public" as "cis";

-- OPERATIONS -********************************************************************************************
grant select on "cis".image to "public" as "cis";
grant update on "cis".image to "public" as "cis";
grant insert on "cis".image to "public" as "cis";
grant delete on "cis".image to "public" as "cis";
grant index on "cis".image to "public" as "cis";
grant select on "cis".identity to "public" as "cis";
grant update on "cis".identity to "public" as "cis";
grant insert on "cis".identity to "public" as "cis";
grant delete on "cis".identity to "public" as "cis";
grant index on "cis".identity to "public" as "cis";
grant select on "cis".message to "public" as "cis";
grant update on "cis".message to "public" as "cis";
grant insert on "cis".message to "public" as "cis";
grant delete on "cis".message to "public" as "cis";
grant index on "cis".message to "public" as "cis";
grant select on "cis".code_documenttype to "public" as "cis";
grant update on "cis".code_documenttype to "public" as "cis";
grant insert on "cis".code_documenttype to "public" as "cis";
grant delete on "cis".code_documenttype to "public" as "cis";
grant index on "cis".code_documenttype to "public" as "cis";
grant select on "cis".code_permissiontype to "public" as "cis";
grant update on "cis".code_permissiontype to "public" as "cis";
grant insert on "cis".code_permissiontype to "public" as "cis";
grant delete on "cis".code_permissiontype to "public" as "cis";
grant index on "cis".code_permissiontype to "public" as "cis";
grant select on "cis".code_state to "public" as "cis";
grant update on "cis".code_state to "public" as "cis";
grant insert on "cis".code_state to "public" as "cis";
grant delete on "cis".code_state to "public" as "cis";
grant index on "cis".code_state to "public" as "cis";
grant select on "cis".code_purposeofstay to "public" as "cis";
grant update on "cis".code_purposeofstay to "public" as "cis";
grant insert on "cis".code_purposeofstay to "public" as "cis";
grant delete on "cis".code_purposeofstay to "public" as "cis";
grant index on "cis".code_purposeofstay to "public" as "cis";
grant select on "cis".cisuser to "public" as "cis";
grant update on "cis".cisuser to "public" as "cis";
grant insert on "cis".cisuser to "public" as "cis";
grant delete on "cis".cisuser to "public" as "cis";
grant index on "cis".cisuser to "public" as "cis";
grant select on "cis".cisuserrole to "public" as "cis";
grant update on "cis".cisuserrole to "public" as "cis";
grant insert on "cis".cisuserrole to "public" as "cis";
grant delete on "cis".cisuserrole to "public" as "cis";
grant index on "cis".cisuserrole to "public" as "cis";
grant select on "cis".cispermission to "public" as "cis";
grant update on "cis".cispermission to "public" as "cis";
grant insert on "cis".cispermission to "public" as "cis";
grant delete on "cis".cispermission to "public" as "cis";
grant index on "cis".cispermission to "public" as "cis";
grant select on "cis".orgunit to "public" as "cis";
grant update on "cis".orgunit to "public" as "cis";
grant insert on "cis".orgunit to "public" as "cis";
grant delete on "cis".orgunit to "public" as "cis";
grant index on "cis".orgunit to "public" as "cis";
grant select on "cis".password to "public" as "cis";
grant update on "cis".password to "public" as "cis";
grant insert on "cis".password to "public" as "cis";
grant delete on "cis".password to "public" as "cis";
grant index on "cis".password to "public" as "cis";
grant select on "cis".cisrole to "public" as "cis";
grant update on "cis".cisrole to "public" as "cis";
grant insert on "cis".cisrole to "public" as "cis";
grant delete on "cis".cisrole to "public" as "cis";
grant index on "cis".cisrole to "public" as "cis";
grant select on "cis".cisrolepermission to "public" as "cis";
grant update on "cis".cisrolepermission to "public" as "cis";
grant insert on "cis".cisrolepermission to "public" as "cis";
grant delete on "cis".cisrolepermission to "public" as "cis";
grant index on "cis".cisrolepermission to "public" as "cis";
grant select on "cis".tdustayplace to "public" as "cis";
grant update on "cis".tdustayplace to "public" as "cis";
grant insert on "cis".tdustayplace to "public" as "cis";
grant delete on "cis".tdustayplace to "public" as "cis";
grant index on "cis".tdustayplace to "public" as "cis";
grant select on "cis".tdustay to "public" as "cis";
grant update on "cis".tdustay to "public" as "cis";
grant insert on "cis".tdustay to "public" as "cis";
grant delete on "cis".tdustay to "public" as "cis";
grant index on "cis".tdustay to "public" as "cis";
grant select on "cis".tduperson to "public" as "cis";
grant update on "cis".tduperson to "public" as "cis";
grant insert on "cis".tduperson to "public" as "cis";
grant delete on "cis".tduperson to "public" as "cis";
grant index on "cis".tduperson to "public" as "cis";
grant select on "cis".tdudocument to "public" as "cis";
grant update on "cis".tdudocument to "public" as "cis";
grant insert on "cis".tdudocument to "public" as "cis";
grant delete on "cis".tdudocument to "public" as "cis";
grant index on "cis".tdudocument to "public" as "cis";
grant select on "cis".tdustay to "public" as "cis";
grant update on "cis".tdustay to "public" as "cis";
grant insert on "cis".tdustay to "public" as "cis";
grant delete on "cis".tdustay to "public" as "cis";
grant index on "cis".tdustay to "public" as "cis";


-- CONSTRAINTS -********************************************************************************************
create unique index "cis".ip_code_state_id on "cis".code_state (id)
    using btree ;
create unique index "cis".iu_code_state_idstate on "cis".code_state (idstate)
    using btree ;
create unique index "cis".iu_code_state_code on "cis".code_state (code)
    using btree ;
create unique index "cis".iu_code_state_code_icao on "cis".code_state
    (code_icao) using btree ;
create unique index "cis".iu_code_state_name on "cis".code_state (name)
    using btree ;
create index "cis".i_code_state_name_cz on "cis".code_state (name_cz)
    using btree ;
create index "cis".i_code_state_name_en on "cis".code_state (name_en)
    using btree ;
create index "cis".i_code_state_name_full on "cis".code_state (name_full)
    using btree ;
create index "cis".i_code_state_name_upper on "cis".code_state (name_upper)
    using btree ;
create index "cis".i_code_state_rank on "cis".code_state (rank)
    using btree ;
alter table "cis".code_state add constraint primary key (id)
    constraint "cis".pk_code_state  ;
create unique index "cis".ip_code_documenttype_id on "cis".code_documenttype
    (id) using btree ;
create unique index "cis".iu_code_documenttype_code on "cis".code_documenttype
    (code) using btree ;
alter table "cis".code_documenttype add constraint primary key (id)
    constraint "cis".pk_code_documenttype  ;
create unique index "cis".ip_code_purposeofstay_id on "cis".code_purposeofstay
    (id) using btree ;
alter table "cis".code_purposeofstay add constraint primary key (id)
    constraint "cis".pk_code_purposeofstay  ;
create unique index "cis".ip_code_permissiontype_id on "cis".code_permissiontype
    (id) using btree ;
create unique index "cis".iu_code_permissiontype_code on "cis".code_permissiontype
    (code) using btree ;
alter table "cis".code_permissiontype add constraint primary key
    (id) constraint "cis".pk_code_permissiontype  ;

create unique index "cis".ip_cisuser_id on "cis".cisuser
    (id) using btree ;
create unique index "cis".iu_cisuser_uid_ddate on "cis".cisuser
    (uid,ddate) using btree ;
create index "cis".i_cisuser_surname_name on "cis".cisuser
    (surname,name) using btree ;
create index "cis".i_cisuser_validfrom_validto on "cis".cisuser
    (validfrom,validto) using btree ;
alter table "cis".cisuser add constraint primary key (id)
    constraint "cis".pk_cisuser  ;

create unique index "cis".ip_password_id on "cis".password
    (id) using btree ;
create unique index "cis".iu_password_idcisuser_password_ddate
    on "cis".password (idcisuser,password,ddate) using btree ;
create index "cis".i_password_validfrom_validto on "cis".password
    (validfrom,validto) using btree ;
alter table "cis".password add constraint primary key (id)
    constraint "cis".pk_password  ;

create unique index "cis".iu_cispermission_code_ddate on "cis".cispermission
    (code,ddate) using btree ;
create index "cis".i_cispermission_validfrom_validto on "cis".cispermission
    (validfrom,validto) using btree ;
alter table "cis".cispermission add constraint primary key (id)
    constraint "cis".pk_cispermission  ;
create unique index "cis".ip_orgunit_idorgunit on "cis".orgunit
    (id) using btree ;
create unique index "cis".iu_orgunit_code_ddate on "cis"
    .orgunit (code,ddate) using btree ;
create index "cis".i_orgunit_unittype on "cis".orgunit (unittype)
    using btree ;
create index "cis".i_orgunit_validfrom_validto on "cis".orgunit
    (validfrom,validto) using btree ;
alter table "cis".orgunit add constraint primary key (id)
    constraint "cis".pk_orgunit  ;

create unique index "cis".ip_cisuserrole_id on "cis"
    .cisuserrole (id) using btree ;
create unique index "cis".iu_cisuserrole_idcisuser_idrole_ddate
    on "cis".cisuserrole (idcisuser,idrole,ddate) using btree ;
create index "cis".i_cisuserrole_idrole on "cis".cisuserrole
    (idrole) using btree ;
create index "cis".i_cisuserrole_validfrom_validto on "cis".cisuserrole
    (validfrom,validto) using btree ;
alter table "cis".cisuserrole add constraint primary key (id)
    constraint "cis".pk_cisuserrole  ;

create unique index "cis".ip_cisrole_idrole on "cis".cisrole (id)
    using btree ;
create unique index "cis".iu_cisrole_code_ddate on "cis".cisrole
    (code,ddate) using btree ;
create index "cis".i_cisrole_type on "cis".cisrole (type) using
    btree ;
create index "cis".i_cisrole_validfrom_validto on "cis".cisrole
    (validfrom,validto) using btree ;
alter table "cis".cisrole add constraint primary key (id)
    constraint "cis".pk_cisrole  ;
create unique index "cis".ip_cisrolepermission_idroleoper on "cis".cisrolepermission
    (id) using btree ;
create unique index "cis".iu_cisrolepermission_idrole_idpermission_ddate
    on "cis".cisrolepermission (idrole,idpermission,ddate) using btree
    ;
create index "cis".i_cisrolepermission_validfrom_validto on "cis".cisrolepermission
    (validfrom,validto) using btree ;
alter table "cis".cisrolepermission add constraint primary key (id)
    constraint "cis".pk_cisrolepermission  ;

create index "cis".if_tdustay_idperson on "cis".tdustay (idperson)
    using btree ;
create unique index "cis".ip_tdustay_id on "cis".tdustay
    (id) using btree ;
create index "cis".i_tdustay_visaapplicationnumber on "cis".tdustay (visaapplicationnumber)
    using btree ;
create index "cis".i_tdustay_grantedto on "cis".tdustay (grantedto)
    using btree ;
create index "cis".i_tdustay_grantedfrom on "cis".tdustay (grantedfrom)
    using btree ;
create index "cis".i_tdustay_datefrom on "cis".tdustay (datefrom)
    using btree ;
create index "cis".i_tdustay_terminationdate on "cis".tdustay (terminationdate)
    using btree ;
create index "cis".i_tdustay_idorgunit_idorgunituziv on "cis".tdustay
    (idorgunit,idorgunituziv,terminationdate) using btree ;
create index "cis".i_tdustay_pkp on "cis".tdustay (pkp) using
    btree ;
alter table "cis".tdustay add constraint primary key (id)
    constraint "cis".pk_tdustay  ;

create index "cis".if_tdustayplace_idperson on "cis".tdustayplace
    (idperson) using btree ;
create unique index "cis".ip_tdustayplace_idtdustayplace
    on "cis".tdustayplace (id) using btree ;
create index "cis".i_tdustayplace_dateto on "cis".tdustayplace
    (dateto) using btree ;
create index "cis".i_tdustayplace_datefrom on "cis".tdustayplace
    (datefrom) using btree ;
alter table "cis".tdustayplace add constraint primary key (id)
    constraint "cis".pk_tdustayplace  ;

create index "cis".if_tduperson_idimage on "cis".tduperson (idimage)
    using btree ;
create index "cis".if_tduperson_iddeathstate on "cis".tduperson (iddeathstate)
    using btree ;
create unique index "cis".ip_tduperson_idperson on "cis".tduperson
    (id) using btree ;
create index "cis".i_tduperson_ididentity_actual on "cis".tduperson (ididentity_actual)
    using btree ;

alter table "cis".image add constraint primary key (id)
    constraint "cis".pk_image  ;
create function "cis".tduperson_idimage_1(a integer) returning integer with (not variant)
 return a+1;
end function;
grant execute on function "cis".tduperson_idimage_1 (integer) to "public" as "cis";
create index "cis".image_x_idimage_1 on "cis".image
    ("cis".tduperson_idimage_1(id)) using btree ;
create index "cis".tduperson_x_idimage_1 on "cis".tduperson (
    "cis".tduperson_idimage_1(id)) using btree ;
alter table "cis".tduperson add constraint primary key (id)
    constraint "cis".pk_tduperson  ;


alter table "cis".tdustay add constraint (foreign key (idperson)
    references "cis".tduperson  constraint "cis".fk_tdustay_idperson);

alter table "cis".tduperson add constraint (foreign key (iddeathstate)
    references "cis".code_state  constraint "cis".fk_tduperson_iddeathstate);
alter table "cis".tduperson add constraint (foreign key (idimage)
    references "cis".image  constraint "cis".fk_tduperson_idimage);

alter table "cis".tdudocument add constraint (foreign key (idstateissued)
    references "cis".code_state  constraint "cis".fk_tdudocument_idstateissued);
alter table "cis".tdudocument add constraint (foreign key (idperson)
    references "cis".tduperson  constraint "cis".fk_tdudocument_idperson);

alter table "cis".tdustayplace add constraint (foreign key
    (idperson) references "cis".tduperson  constraint "cis".fk_tdustayplace_idperson);

