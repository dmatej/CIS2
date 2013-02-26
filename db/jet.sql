grant dba to "informix";
grant dba to "cis";


grant "extend" to "cis" ;


{ TABLE "cis".cisblobpool row size = 64 number of columns = 3 index size = 14 }
create table "cis".cisblobpool
  (
    idblobpool serial not null constraint "cis".n_cisblobpool_idblobpool,
    idevidence integer,
    obraz byte
  );

revoke all on "cis".cisblobpool from "public" as "cis";


{ TABLE "cis".cisidentita row size = 278 number of columns = 20 index size = 300
              }
create table "cis".cisidentita
  (
    ididentita serial not null constraint "cis".n_cisidentita_ididentita,
    idevidence integer not null constraint "cis".n_cisidentita_idevidence,
    idutvar integer
        default -1 not null constraint "cis".n_cisidentita_idutvar,
    idosoba integer,
    datnar char(8)
        default '00000000' not null constraint "cis".n_cisidentita_datnar,
    kodpohlavi char(1),
    idstat integer
        default 1 not null constraint "cis".n_cisidentita_idstat,
    datidentod date,
    datidentdo date,
    idstatnar integer
        default 1 not null constraint "cis".n_cisidentita_idstatnar,
    rstatus integer
        default 0 not null constraint "cis".n_cisidentita_rstatus,
    rodcis varchar(10)
        default '' not null constraint "cis".n_cisidentita_rodcis,
    jmeno nvarchar(24)
        default '' not null constraint "cis".n_cisidentita_jmeno,
    prijmeni nvarchar(50)
        default '' not null constraint "cis".n_cisidentita_prijmeni,
    rodne nvarchar(35)
        default '' not null constraint "cis".n_cisidentita_rodne,
    jmena_ost nvarchar(35)
        default '' not null constraint "cis".n_cisidentita_jmena_ost,
    mistonar nvarchar(48)
        default '' not null constraint "cis".n_cisidentita_mistonar,

    check ((kodpohlavi IS NULL ) OR (kodpohlavi IN ('X' ,'M' ,'Z' )) ) constraint
              "cis".c_cisidentita_kodpohlavi
  );

revoke all on "cis".cisidentita from "public" as "cis";


{ TABLE "cis".cismsg row size = 289 number of columns = 7 index size = 9 }
create table "cis".cismsg
  (
    id serial not null constraint "cis".n_cismsg_id,
    type char(1)
        default 'A',
    validfrom datetime year to second
        default current year to second,
    validto datetime year to second not null constraint "cis".n_cismsg_validto,
    txt varchar(255),
    ciduser integer not null constraint "cis".n_cismsg_ciduser,
    cdate datetime year to second
        default current year to second,

    check ((type IS NULL ) OR (type IN ('A' ,'L' )) ) constraint "cis".c_cismsg_type
  );

revoke all on "cis".cismsg from "public" as "cis";


{ TABLE "cis".koddokladdruh row size = 338 number of columns = 15 index size = 16
              }
create table "cis".koddokladdruh
  (
    idkod serial not null constraint "cis".n_koddokladdruh_idkod,
    kod char(2) not null constraint "cis".n_koddokladdruh_kod,
    poradi smallint,
    platod date
        default  '01.01.1900',
    platdo date
        default  '31.12.2999',
    nazev nvarchar(50),
    pozn varchar(255)
  );

revoke all on "cis".koddokladdruh from "public" as "cis";


{ TABLE "cis".kodpobytucel row size = 442 number of columns = 18 index size = 30
              }
create table "cis".kodpobytucel
  (
    idkod serial not null constraint "cis".n_kodpobytucel_idkod,
    idkoducelpobytu integer,
    kod char(3) not null constraint "cis".n_kodpobytucel_kod,
    poradi smallint,
    platod date
        default  '01.01.1900',
    platdo date
        default  '31.12.2999',
    menuupa smallint,
    menupoz smallint,
    menuviz smallint,
    menuevc smallint,
    vizak smallint,
    vizad smallint,
    vydelkat smallint,
    nazev nvarchar(100),
    tiskkod varchar(5),
    pozn varchar(255)
  );

revoke all on "cis".kodpobytucel from "public" as "cis";


{ TABLE "cis".kodpovolenidruh row size = 498 number of columns = 14 index size =
              25 }
create table "cis".kodpovolenidruh
  (
    idkod serial not null constraint "cis".n_kodpovolenidruh_idkod,
    kod char(2) not null constraint "cis".n_kodpovolenidruh_kod,
    poradi smallint,
    platod date
        default  '01.01.1900',
    platdo date
        default  '31.12.2999',
    plattrvale smallint,
    znakviza smallint,
    idkodvis integer,
    nazev varchar(72),
    tiskkod varchar(2),
    tiskinfo1 varchar(50),
    tiskinfo2 varchar(50),
    pozn varchar(255)
  );

revoke all on "cis".kodpovolenidruh from "public" as "cis";


{ TABLE "cis".kodstat row size = 2452 number of columns = 33 index size = 339 }
create table "cis".kodstat
  (
    idkod serial not null constraint "cis".n_kodstat_idkod,
    idstat integer,
    poradi smallint,
    kod char(3) not null constraint "cis".n_kodstat_kod,
    kod_icao char(3) not null constraint "cis".n_kodstat_kod_icao,
    zkr_iso char(2),
    nazev nvarchar(23,3),
    nazev_cz nvarchar(50) not null constraint "cis".n_kodstat_nazev_cz,
    nazev_en varchar(50) not null constraint "cis".n_kodstat_nazev_en,
    nazev_nativ varchar(50),
    nazev_full nvarchar(60),
    nazev_upper nvarchar(50),
    pozn varchar(50),
    platod date
        default  '01.01.1900' not null constraint "cis".n_kodstat_platod,
    platdo date
        default  '31.12.2999' not null constraint "cis".n_kodstat_platdo
  );

revoke all on "cis".kodstat from "public" as "cis";


{ TABLE "cis".koducelpobytu row size = 335 number of columns = 8 index size = 16
              }
create table "cis".koducelpobytu
  (
    idkod serial not null constraint "cis".n_koducelpobytu_idkod,
    kod char(2) not null constraint "cis".n_koducelpobytu_kod,
    poradi smallint,
    platod date
        default  '01.01.1900',
    platdo date
        default  '31.12.2999',
    nazev varchar(60) not null constraint "cis".n_koducelpobytu_nazev,
    pozn varchar(255)
  );

revoke all on "cis".koducelpobytu from "public" as "cis";


{ TABLE "cis".supclient row size = 2241 number of columns = 23 index size = 109 }
create table "cis".supclient
  (
    idclient serial not null constraint "cis".n_supclient_idclient,
    idorgunit integer,
    uid char(8) not null constraint "cis".n_supclient_uid,
    surname nvarchar(35) not null constraint "cis".n_supclient_surname,
    name nvarchar(24) not null constraint "cis".n_supclient_name,
    degreeprefix varchar(35),
    degreesuffix varchar(10),
    blocked integer,
    forcepwdchange integer,
    cidclient integer,
    cdate datetime year to second not null constraint "cis".n_supclient_cdate,
    validfrom date
        default  '01.01.1900' not null constraint "cis".n_supclient_validfrom,
    validto date
        default  '31.12.2999' not null constraint "cis".n_supclient_validto,
    didclient integer,
    ddate datetime year to second,
    uidclient integer,
    udate datetime year to second,
    lastbadlogin datetime year to second,
    badlogincount smallint,
    lastlogin datetime year to second,
    info lvarchar(2040)
  );

revoke all on "cis".supclient from "public" as "cis";

{ TABLE "cis".suppassword row size = 317 number of columns = 10 index size = 295
              }
create table "cis".suppassword
  (
    idpassword serial not null constraint "cis".n_suppassword_idpassword,
    idclient integer not null constraint "cis".n_suppassword_idclient,
    validfrom date
        default  '01.01.1900' not null constraint "cis".n_suppassword_validfrom,
    validto date
        default  '31.12.2999' not null constraint "cis".n_suppassword_validto,
    cidclient integer,
    cdate datetime year to second not null constraint "cis".n_suppassword_cdate,
    didclient integer,
    ddate datetime year to second,
    algorithm varchar(20),
    passwd varchar(255) not null constraint "cis".n_suppassword_passwd
  );
revoke all on "cis".suppassword from "public" as "cis";

{ TABLE "cis".supoperation row size = 650 number of columns = 13 index size = 74
              }
create table "cis".supoperation
  (
    idoperation serial not null constraint "cis".n_supoperation_idoperation,
    code varchar(30) not null constraint "cis".n_supoperation_code,
    name varchar(50) not null constraint "cis".n_supoperation_name,
    description varchar(255),
    validfrom datetime year to second
        default  datetime (1900-01-01 00:00:00) year to second not null constraint
              "cis".n_supoperation_validfrom,
    validto datetime year to second
        default  datetime (2999-12-31 23:59:59) year to second not null constraint
              "cis".n_supoperation_validto,
    cidclient integer,
    cdate datetime year to second
        default current year to second not null constraint "cis".n_supoperation_cdate,
    didclient integer,
    ddate datetime year to second,
    uidclient integer,
    udate datetime year to second,
    annotation varchar(255)
  );

revoke all on "cis".supoperation from "public" as "cis";


{ TABLE "cis".suporgunit row size = 516 number of columns = 24 index size = 80 }
create table "cis".suporgunit
  (
    idorgunit serial not null constraint "cis".n_suporgunit_idorgunit,
    unitcode char(7) not null constraint "cis".n_suporgunit_unitcode,
    unittype integer not null constraint "cis".n_suporgunit_unittype,
    phone1 char(13),
    phone2 char(13),
    fax char(13),
    email varchar(65),
    idaddress integer,
    validfrom date
        default  '01.01.1900' not null constraint "cis".n_suporgunit_validfrom,
    validto date
        default  '31.12.2999' not null constraint "cis".n_suporgunit_validto,
    unitname nvarchar(65) not null constraint "cis".n_suporgunit_unitname,
    kodtudu char(4),
    cidclient integer,
    cdate datetime year to second,
    didclient integer,
    ddate datetime year to second,
    uidclient integer,
    udate datetime year to second,
    pozn varchar(255)
  );

revoke all on "cis".suporgunit from "public" as "cis";


{ TABLE "cis".suprole row size = 388 number of columns = 13 index size = 73 }
create table "cis".suprole
  (
    idrole serial not null constraint "cis".n_suprole_idrole,
    type smallint not null constraint "cis".n_suprole_type,
    code varchar(30) not null constraint "cis".n_suprole_code,
    name varchar(50) not null constraint "cis".n_suprole_name,
    description varchar(255),
    validfrom date
        default  '01.01.1900' not null constraint "cis".n_suprole_validfrom,
    validto date
        default  '31.12.2999' not null constraint "cis".n_suprole_validto,
    cidclient integer,
    cdate datetime year to second not null constraint "cis".n_suprole_cdate,
    didclient integer,
    ddate datetime year to second,
    uidclient integer,
    udate datetime year to second
  );

revoke all on "cis".suprole from "public" as "cis";


{ TABLE "cis".supclientrole row size = 44 number of columns = 9 index size = 52 }
create table "cis".supclientrole
  (
    idclientrole serial not null constraint "cis".n_supclientrole_idclientrole,
    idclient integer not null constraint "cis".n_supclientrole_idclient,
    idrole integer not null constraint "cis".n_supclientrole_idrole,
    validfrom date
        default  '01.01.1900' not null constraint "cis".n_supclientrole_validfrom,
    validto date
        default  '31.12.2999' not null constraint "cis".n_supclientrole_validto,
    cidclient integer,
    cdate datetime year to second not null constraint "cis".n_supclientrole_cdate,
    didclient integer,
    ddate datetime year to second
  );

revoke all on "cis".supclientrole from "public" as "cis";


{ TABLE "cis".suproleoper row size = 44 number of columns = 9 index size = 43 }
create table "cis".suproleoper
  (
    idroleoper serial not null constraint "cis".n_suproleoper_idroleoper,
    idrole integer not null constraint "cis".n_suproleoper_idrole,
    idoperation integer not null constraint "cis".n_suproleoper_idoperation,
    validfrom date
        default  '01.01.1900' not null constraint "cis".n_suproleoper_validfrom,
    validto date
        default  '31.12.2999' not null constraint "cis".n_suproleoper_validto,
    cidclient integer,
    cdate datetime year to second not null constraint "cis".n_suproleoper_cdate,
    didclient integer,
    ddate datetime year to second
  );

revoke all on "cis".suproleoper from "public" as "cis";


{ TABLE "cis".tduosoba row size = 2388 number of columns = 55 index size = 80 }
create table "cis".tduosoba
  (
    idosoba integer not null constraint "cis".n_tduosoba_idosoba,
    idosoori integer,
    ididentakt integer,
    idpobytakt integer
        default -1,
    idmpakt integer
        default -1,
    idblobpool integer,
    idmistoumrti integer,
    idstatumrti integer,
    idpobytkatos integer,
    idvydelkat integer,
    idutvarosoby integer,
    idutvarosobyminul integer,
    idutvaruziv integer,
    iduziv integer,
    kodpohlavi char(1),
    datnpmpozm char(8),
    kodrodstav char(1),
    datumrti date,
    datskartpl date,
    datskartsk date,
    datakt datetime year to second,
    titul_pred varchar(15),
    titul_za varchar(15),
    mistoumrti varchar(30),
    ico varchar(8),
    zivnlist varchar(15),
    txtzkpu varchar(60),
    pozn lvarchar,
    rstatus integer
        default 0 not null constraint "cis".n_tduosoba_rstatus,
    ciduser integer
        default -2 not null constraint "cis".n_tduosoba_ciduser,
    uiduser integer,
    diduser integer,
    cdate datetime year to second
        default current year to second not null constraint "cis".n_tduosoba_cdate,
    udate datetime year to second,
    ddate datetime year to second,
    idkodspisznak integer,
    skartznak char(1),
    rokskartpl smallint,
    idkodvyrazeni integer,
    datskartdg date,
    zlikvidovat char(1)
        default 'N' not null constraint "cis".n_tduosoba_zlikvidovat,
    check (zlikvidovat IN ('A' ,'N' )) constraint "cis".c_tduosoba_zlikvidovat_an
  );

revoke all on "cis".tduosoba from "public" as "cis";


{ TABLE "cis".tdumistopobytu row size = 399 number of columns = 25 index size = 99
              }
create table "cis".tdumistopobytu
  (
    idtdumistopobytu serial not null constraint "cis".n_tdumistopobytu_idtdumistopobytu,
    idosoba integer not null constraint "cis".n_tdumistopobytu_idosoba,
    idosoori integer,
    idtdupobyt integer,
    idtduuby integer,
    idadrpcdmp integer,
    idtduadresamp integer,
    idkodbydldruh integer,
    idutvarmp integer,
    idam integer,
    idutvaruziv integer,
    datod date
        default  '01.01.1900' not null constraint "cis".n_tdumistopobytu_datod,
    datdo date
        default  '31.12.2999' not null constraint "cis".n_tdumistopobytu_datdo,
    datakt datetime year to second,
    koduby char(4),
    icouby char(8),
    nazevuby varchar(30),
    rstatus integer
        default 0 not null constraint "cis".n_tdumistopobytu_rstatus,
    ciduser integer
        default -2 not null constraint "cis".n_tdumistopobytu_ciduser,
    uiduser integer,
    diduser integer,
    cdate datetime year to second
        default current year to second not null constraint "cis".n_tdumistopobytu_cdate,
    udate datetime year to second,
    ddate datetime year to second,
    pozn varchar(255)
  );

revoke all on "cis".tdumistopobytu from "public" as "cis";


{ TABLE "cis".tdupobyt row size = 2232 number of columns = 35 index size = 126 }
create table "cis".tdupobyt
  (
    idtdupobyt serial not null constraint "cis".n_tdupobyt_idtdupobyt,
    idtduall integer,
    idosoba integer not null constraint "cis".n_tdupobyt_idosoba,
    idosoori integer,
    idtdupobytprodl integer,
    idpobytkat integer not null constraint "cis".n_tdupobyt_idpobytkat,
    idpobytucel integer,
    idpobytstav integer not null constraint "cis".n_tdupobyt_idpobytstav,
    idutvarpobytu integer not null constraint "cis".n_tdupobyt_idutvarpobytu,
    iduradpobytu integer,
    idstatbydl integer,
    idkodpobytkonec integer,
    idutvar integer,
    idutvaruziv integer,
    pkp char(10),
    pocdeti smallint,
    cisjednaci char(27),
    datpobytod date,
    datpkpod date
        default  '01.01.1900' not null constraint "cis".n_tdupobyt_datpkpod,
    datpkpdo date
        default  '01.01.1900' not null constraint "cis".n_tdupobyt_datpkpdo,
    datnabytipm date,
    datprijezd date,
    datukoncen date,
    priznakbez char(1),
    datakt datetime year to second,
    cislozov varchar(16),
    pozn lvarchar(2040),
    rstatus integer
        default 0 not null constraint "cis".n_tdupobyt_rstatus,
    ciduser integer
        default -2 not null constraint "cis".n_tdupobyt_ciduser,
    uiduser integer,
    diduser integer,
    cdate datetime year to second
        default current year to second not null constraint "cis".n_tdupobyt_cdate,
    udate datetime year to second,
    ddate datetime year to second,
    platnostdoprukaz date
  );

revoke all on "cis".tdupobyt from "public" as "cis";


{ TABLE "cis".tdudoklad row size = 2203 number of columns = 31 index size = 96 }
create table "cis".tdudoklad
  (
    idtdudoklad serial not null constraint "cis".n_tdudoklad_idtdudoklad,
    idosoba integer not null constraint "cis".n_tdudoklad_idosoba,
    idosoori integer,
    ididentita integer not null constraint "cis".n_tdudoklad_ididentita,
    idtdupobyt integer,
    iddokladdruh integer not null constraint "cis".n_tdudoklad_iddokladdruh,
    idstatvydal integer,
    idutvarvydal integer,
    iduziv integer,
    idutvaruziv integer,
    cisdoklad char(15),
    datvydal date,
    datplatod date
        default  '01.01.1900' not null constraint "cis".n_tdudoklad_datplatod,
    datplatdo date
        default  '31.12.2999' not null constraint "cis".n_tdudoklad_datplatdo,
    datprevzeti date,
    datprodlouzeni date,
    datzruseni date,
    datakt datetime year to second,
    pozn lvarchar(2040),
    rstatus integer
        default 0 not null constraint "cis".n_tdudoklad_rstatus,
    ciduser integer
        default -2 not null constraint "cis".n_tdudoklad_ciduser,
    uiduser integer,
    diduser integer,
    cdate datetime year to second
        default current year to second not null constraint "cis".n_tdudoklad_cdate,
    udate datetime year to second,
    ddate datetime year to second,
    cislozov varchar(16)
  );
revoke all on "cis".tdudoklad from "public" as "cis";

-- OPERATIONS -********************************************************************************************
grant select on "cis".cisblobpool to "public" as "cis";
grant update on "cis".cisblobpool to "public" as "cis";
grant insert on "cis".cisblobpool to "public" as "cis";
grant delete on "cis".cisblobpool to "public" as "cis";
grant index on "cis".cisblobpool to "public" as "cis";
grant select on "cis".cisidentita to "public" as "cis";
grant update on "cis".cisidentita to "public" as "cis";
grant insert on "cis".cisidentita to "public" as "cis";
grant delete on "cis".cisidentita to "public" as "cis";
grant index on "cis".cisidentita to "public" as "cis";
grant select on "cis".cismsg to "public" as "cis";
grant update on "cis".cismsg to "public" as "cis";
grant insert on "cis".cismsg to "public" as "cis";
grant delete on "cis".cismsg to "public" as "cis";
grant index on "cis".cismsg to "public" as "cis";
grant select on "cis".koddokladdruh to "public" as "cis";
grant update on "cis".koddokladdruh to "public" as "cis";
grant insert on "cis".koddokladdruh to "public" as "cis";
grant delete on "cis".koddokladdruh to "public" as "cis";
grant index on "cis".koddokladdruh to "public" as "cis";
grant select on "cis".kodpobytucel to "public" as "cis";
grant update on "cis".kodpobytucel to "public" as "cis";
grant insert on "cis".kodpobytucel to "public" as "cis";
grant delete on "cis".kodpobytucel to "public" as "cis";
grant index on "cis".kodpobytucel to "public" as "cis";
grant select on "cis".kodpovolenidruh to "public" as "cis";
grant update on "cis".kodpovolenidruh to "public" as "cis";
grant insert on "cis".kodpovolenidruh to "public" as "cis";
grant delete on "cis".kodpovolenidruh to "public" as "cis";
grant index on "cis".kodpovolenidruh to "public" as "cis";
grant select on "cis".kodstat to "public" as "cis";
grant update on "cis".kodstat to "public" as "cis";
grant insert on "cis".kodstat to "public" as "cis";
grant delete on "cis".kodstat to "public" as "cis";
grant index on "cis".kodstat to "public" as "cis";
grant select on "cis".koducelpobytu to "public" as "cis";
grant update on "cis".koducelpobytu to "public" as "cis";
grant insert on "cis".koducelpobytu to "public" as "cis";
grant delete on "cis".koducelpobytu to "public" as "cis";
grant index on "cis".koducelpobytu to "public" as "cis";
grant select on "cis".supclient to "public" as "cis";
grant update on "cis".supclient to "public" as "cis";
grant insert on "cis".supclient to "public" as "cis";
grant delete on "cis".supclient to "public" as "cis";
grant index on "cis".supclient to "public" as "cis";
grant select on "cis".supclientrole to "public" as "cis";
grant update on "cis".supclientrole to "public" as "cis";
grant insert on "cis".supclientrole to "public" as "cis";
grant delete on "cis".supclientrole to "public" as "cis";
grant index on "cis".supclientrole to "public" as "cis";
grant select on "cis".supoperation to "public" as "cis";
grant update on "cis".supoperation to "public" as "cis";
grant insert on "cis".supoperation to "public" as "cis";
grant delete on "cis".supoperation to "public" as "cis";
grant index on "cis".supoperation to "public" as "cis";
grant select on "cis".suporgunit to "public" as "cis";
grant update on "cis".suporgunit to "public" as "cis";
grant insert on "cis".suporgunit to "public" as "cis";
grant delete on "cis".suporgunit to "public" as "cis";
grant index on "cis".suporgunit to "public" as "cis";
grant select on "cis".suppassword to "public" as "cis";
grant update on "cis".suppassword to "public" as "cis";
grant insert on "cis".suppassword to "public" as "cis";
grant delete on "cis".suppassword to "public" as "cis";
grant index on "cis".suppassword to "public" as "cis";
grant select on "cis".suprole to "public" as "cis";
grant update on "cis".suprole to "public" as "cis";
grant insert on "cis".suprole to "public" as "cis";
grant delete on "cis".suprole to "public" as "cis";
grant index on "cis".suprole to "public" as "cis";
grant select on "cis".suproleoper to "public" as "cis";
grant update on "cis".suproleoper to "public" as "cis";
grant insert on "cis".suproleoper to "public" as "cis";
grant delete on "cis".suproleoper to "public" as "cis";
grant index on "cis".suproleoper to "public" as "cis";
grant select on "cis".tdumistopobytu to "public" as "cis";
grant update on "cis".tdumistopobytu to "public" as "cis";
grant insert on "cis".tdumistopobytu to "public" as "cis";
grant delete on "cis".tdumistopobytu to "public" as "cis";
grant index on "cis".tdumistopobytu to "public" as "cis";
grant select on "cis".tdupobyt to "public" as "cis";
grant update on "cis".tdupobyt to "public" as "cis";
grant insert on "cis".tdupobyt to "public" as "cis";
grant delete on "cis".tdupobyt to "public" as "cis";
grant index on "cis".tdupobyt to "public" as "cis";
grant select on "cis".tduosoba to "public" as "cis";
grant update on "cis".tduosoba to "public" as "cis";
grant insert on "cis".tduosoba to "public" as "cis";
grant delete on "cis".tduosoba to "public" as "cis";
grant index on "cis".tduosoba to "public" as "cis";
grant select on "cis".tdudoklad to "public" as "cis";
grant update on "cis".tdudoklad to "public" as "cis";
grant insert on "cis".tdudoklad to "public" as "cis";
grant delete on "cis".tdudoklad to "public" as "cis";
grant index on "cis".tdudoklad to "public" as "cis";
grant select on "cis".tdupobyt to "public" as "cis";
grant update on "cis".tdupobyt to "public" as "cis";
grant insert on "cis".tdupobyt to "public" as "cis";
grant delete on "cis".tdupobyt to "public" as "cis";
grant index on "cis".tdupobyt to "public" as "cis";


-- CONSTRAINTS -********************************************************************************************
create unique index "cis".ip_kodstat_idkod on "cis".kodstat (idkod)
    using btree ;
create unique index "cis".iu_kodstat_idstat on "cis".kodstat (idstat)
    using btree ;
create unique index "cis".iu_kodstat_kod on "cis".kodstat (kod)
    using btree ;
create unique index "cis".iu_kodstat_kod_icao on "cis".kodstat
    (kod_icao) using btree ;
create unique index "cis".iu_kodstat_nazev on "cis".kodstat (nazev)
    using btree ;
create index "cis".i_kodstat_nazev_cz on "cis".kodstat (nazev_cz)
    using btree ;
create index "cis".i_kodstat_nazev_en on "cis".kodstat (nazev_en)
    using btree ;
create index "cis".i_kodstat_nazev_full on "cis".kodstat (nazev_full)
    using btree ;
create index "cis".i_kodstat_nazev_upper on "cis".kodstat (nazev_upper)
    using btree ;
create index "cis".i_kodstat_poradi on "cis".kodstat (poradi)
    using btree ;
alter table "cis".kodstat add constraint primary key (idkod)
    constraint "cis".pk_kodstat  ;
create unique index "cis".ip_koddokladdruh_idkod on "cis".koddokladdruh
    (idkod) using btree ;
create unique index "cis".iu_koddokladdruh_kod on "cis".koddokladdruh
    (kod) using btree ;
alter table "cis".koddokladdruh add constraint primary key (idkod)
    constraint "cis".pk_koddokladdruh  ;
create unique index "cis".ip_kodpobytucel_idkod on "cis".kodpobytucel
    (idkod) using btree ;
alter table "cis".kodpobytucel add constraint primary key (idkod)
    constraint "cis".pk_kodpobytucel  ;
create unique index "cis".ip_kodpovolenidruh_idkod on "cis".kodpovolenidruh
    (idkod) using btree ;
create unique index "cis".iu_kodpovolenidruh_kod on "cis".kodpovolenidruh
    (kod) using btree ;
alter table "cis".kodpovolenidruh add constraint primary key
    (idkod) constraint "cis".pk_kodpovolenidruh  ;

create unique index "cis".ip_supclient_idclient on "cis".supclient
    (idclient) using btree ;
create unique index "cis".iu_supclient_uid_ddate on "cis".supclient
    (uid,ddate) using btree ;
create index "cis".i_supclient_surname_name on "cis".supclient
    (surname,name) using btree ;
create index "cis".i_supclient_validfrom_validto on "cis".supclient
    (validfrom,validto) using btree ;
alter table "cis".supclient add constraint primary key (idclient)
    constraint "cis".pk_supclient  ;

create unique index "cis".ip_suppassword_idpassword on "cis".suppassword
    (idpassword) using btree ;
create unique index "cis".iu_suppassword_idclient_passwd_ddate
    on "cis".suppassword (idclient,passwd,ddate) using btree ;
create index "cis".i_suppassword_validfrom_validto on "cis".suppassword
    (validfrom,validto) using btree ;
alter table "cis".suppassword add constraint primary key (idpassword)
    constraint "cis".pk_suppassword  ;

create unique index "cis".iu_supoperation_code_ddate on "cis".supoperation
    (code,ddate) using btree ;
create index "cis".i_supoperation_validfrom_validto on "cis".supoperation
    (validfrom,validto) using btree ;
alter table "cis".supoperation add constraint primary key (idoperation)
    constraint "cis".pk_supoperation  ;
create unique index "cis".ip_suporgunit_idorgunit on "cis".suporgunit
    (idorgunit) using btree ;
create unique index "cis".iu_suporgunit_unitcode_ddate on "cis"
    .suporgunit (unitcode,ddate) using btree ;
create index "cis".i_suporgunit_kodtudu on "cis".suporgunit (kodtudu)
    using btree ;
create index "cis".i_suporgunit_unittype on "cis".suporgunit (unittype)
    using btree ;
create index "cis".i_suporgunit_validfrom_validto on "cis".suporgunit
    (validfrom,validto) using btree ;
alter table "cis".suporgunit add constraint primary key (idorgunit)
    constraint "cis".pk_suporgunit  ;

create unique index "cis".ip_supclientrole_idclientrole on "cis"
    .supclientrole (idclientrole) using btree ;
create unique index "cis".iu_supclientrole_idclient_idrole_ddate
    on "cis".supclientrole (idclient,idrole,ddate) using btree ;
create index "cis".i_supclientrole_idrole on "cis".supclientrole
    (idrole) using btree ;
create index "cis".i_supclientrole_validfrom_validto on "cis".supclientrole
    (validfrom,validto) using btree ;
alter table "cis".supclientrole add constraint primary key (idclientrole)
    constraint "cis".pk_supclientrole  ;

create unique index "cis".ip_suprole_idrole on "cis".suprole (idrole)
    using btree ;
create unique index "cis".iu_suprole_code_ddate on "cis".suprole
    (code,ddate) using btree ;
create index "cis".i_suprole_type on "cis".suprole (type) using
    btree ;
create index "cis".i_suprole_validfrom_validto on "cis".suprole
    (validfrom,validto) using btree ;
alter table "cis".suprole add constraint primary key (idrole)
    constraint "cis".pk_suprole  ;
create unique index "cis".ip_suproleoper_idroleoper on "cis".suproleoper
    (idroleoper) using btree ;
create unique index "cis".iu_suproleoper_idrole_idoperation_ddate
    on "cis".suproleoper (idrole,idoperation,ddate) using btree
    ;
create index "cis".i_suproleoper_validfrom_validto on "cis".suproleoper
    (validfrom,validto) using btree ;
alter table "cis".suproleoper add constraint primary key (idroleoper)
    constraint "cis".pk_suproleoper  ;

create index "cis".if_tdupobyt_idkodpobytkonec on "cis".tdupobyt
    (idkodpobytkonec) using btree ;
create index "cis".if_tdupobyt_idosoba on "cis".tdupobyt (idosoba)
    using btree ;
create index "cis".if_tdupobyt_idstatbydl on "cis".tdupobyt (idstatbydl)
    using btree ;
create unique index "cis".ip_tdupobyt_idtdupobyt on "cis".tdupobyt
    (idtdupobyt) using btree ;
create index "cis".i_tdupobyt_cislozov on "cis".tdupobyt (cislozov)
    using btree ;
create index "cis".i_tdupobyt_datpkpdo on "cis".tdupobyt (datpkpdo)
    using btree ;
create index "cis".i_tdupobyt_datpkpod on "cis".tdupobyt (datpkpod)
    using btree ;
create index "cis".i_tdupobyt_datpobytod on "cis".tdupobyt (datpobytod)
    using btree ;
create index "cis".i_tdupobyt_datukoncen on "cis".tdupobyt (datukoncen)
    using btree ;
create index "cis".i_tdupobyt_idutvar_idutvaruziv on "cis".tdupobyt
    (idutvar,idutvaruziv,datukoncen) using btree ;
create index "cis".i_tdupobyt_pkp on "cis".tdupobyt (pkp) using
    btree ;
alter table "cis".tdupobyt add constraint primary key (idtdupobyt)
    constraint "cis".pk_tdupobyt  ;

create index "cis".if_tdumistopobytu_idosoba on "cis".tdumistopobytu
    (idosoba) using btree ;
create unique index "cis".ip_tdumistopobytu_idtdumistopobytu
    on "cis".tdumistopobytu (idtdumistopobytu) using btree ;
create index "cis".i_tdumistopobytu_datdo on "cis".tdumistopobytu
    (datdo) using btree ;
create index "cis".i_tdumistopobytu_datod on "cis".tdumistopobytu
    (datod) using btree ;
create index "cis".i_tdumistopobytu_nazevuby on "cis".tdumistopobytu
    (nazevuby) using btree ;
alter table "cis".tdumistopobytu add constraint primary key (idtdumistopobytu)
    constraint "cis".pk_tdumistopobytu  ;

create index "cis".if_tduosoba_idblobpool on "cis".tduosoba (idblobpool)
    using btree ;
create index "cis".if_tduosoba_idstatumrti on "cis".tduosoba (idstatumrti)
    using btree ;
create unique index "cis".ip_tduosoba_idosoba on "cis".tduosoba
    (idosoba) using btree ;
create index "cis".i_tduosoba_datakt on "cis".tduosoba (datakt)
    using btree ;
create index "cis".i_tduosoba_ididentakt on "cis".tduosoba (ididentakt)
    using btree ;
create index "cis".i_tduosoba_idutvaruziv_idpobytkatos on "cis"
    .tduosoba (idutvaruziv,idpobytkatos) using btree ;
create index "cis".i_tduosoba_idutvar_idutvarosoby_idpobytkatos
    on "cis".tduosoba (idutvarosoby,idpobytkatos) using btree
    ;

alter table "cis".cisblobpool add constraint primary key (idblobpool)
    constraint "cis".pk_cisblobpool  ;
create function "cis".tduosoba_idblobpool_1(a integer) returning integer with (not variant)
 return a+1;
end function;
grant execute on function "cis".tduosoba_idblobpool_1 (integer) to "public" as "cis";
create index "cis".cisblobpool_x_idblobpool_1 on "cis".cisblobpool
    ("cis".tduosoba_idblobpool_1(idblobpool)) using btree ;
create index "cis".tduosoba_x_idblobpool_1 on "cis".tduosoba (
    "cis".tduosoba_idblobpool_1(idblobpool)) using btree ;
alter table "cis".tduosoba add constraint primary key (idosoba)
    constraint "cis".pk_tduosoba  ;


alter table "cis".tdupobyt add constraint (foreign key (idstatbydl)
    references "cis".kodstat  constraint "cis".fk_tdupobyt_idstatbydl);
alter table "cis".tdupobyt add constraint (foreign key (idosoba)
    references "cis".tduosoba  constraint "cis".fk_tdupobyt_idosoba);

alter table "cis".tduosoba add constraint (foreign key (idstatumrti)
    references "cis".kodstat  constraint "cis".fk_tduosoba_idstatumrti);
alter table "cis".tduosoba add constraint (foreign key (idblobpool)
    references "cis".cisblobpool  constraint "cis".fk_tduosoba_idblobpool);

alter table "cis".tdudoklad add constraint (foreign key (idstatvydal)
    references "cis".kodstat  constraint "cis".fk_tdudoklad_idstatvydal);
alter table "cis".tdudoklad add constraint (foreign key (idosoba)
    references "cis".tduosoba  constraint "cis".fk_tdudoklad_idosoba);

alter table "cis".tdumistopobytu add constraint (foreign key
    (idosoba) references "cis".tduosoba  constraint "cis".fk_tdumistopobytu_idosoba);

