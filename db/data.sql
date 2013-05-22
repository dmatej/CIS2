delete from "cis".code_state;

insert into "cis".code_state
  (
    idstate, rank, code, code_icao, code_iso, name, name_cz, name_en, name_nativ, name_full, name_upper, note
  ) VALUES
  (
     1,20,"CZE","CZE","CZ","Ceska republika", "Ceska republika", "Czech Republic", "Ceska republika", "Ceska republika", "CESKA REPUBLIKA", "poznamka pro CR"
  );

insert into "cis".code_state
  (
    idstate, rank, code, code_icao, code_iso, name, name_cz, name_en, name_nativ, name_full, name_upper, note
  ) VALUES
  (
     2,10,"DEU","DEU","DE","Nemecko", "Nemesko", "Germany", "Deutschland", "Spolkova republika nemecko", "NEMECKO", "poznamka pro DEU"
  );





delete from "cis".code_purposeofstay;

insert into "cis".code_purposeofstay
  (
    id, code, rank,name,note
  ) VALUES
  (
     1, "NA", 20, "navsteva", "pozn"
  );


insert into "cis".code_purposeofstay
  (
    id, code, rank, name, note
  ) VALUES
  (
     2,"PR",20,"Prace",NULL
  );

insert into "cis".code_purposeofstay
  (
    id, code, rank, name, note
  ) VALUES
  (
     3,"EM",20,"emigrace","pozn2"
  );




delete from "cis".code_permissiontype;

insert into "cis".code_permissiontype
  (
    id,code, rank, name, note
  ) VALUES
  (
     1,"PR",20,"Povoleni prace",NULL
  );

insert into "cis".code_permissiontype
  (
    id,code, rank, name, note
  ) VALUES
  (
     2,"PC",20,"Pribuzniv CR",NULL
  );




delete from "cis".code_documenttype;

insert into "cis".code_documenttype
  (
    id,code, rank, name, note
  ) VALUES
  (
     1,"OP",20,"Obcansky prukaz",NULL
  );

insert into "cis".code_documenttype
  (
    id,code, rank, name, note
  ) VALUES
  (
     2,"PS",20,"Pas",NULL
  );

insert into "cis".code_documenttype
  (
    id,code, rank, name, note
  ) VALUES
  (
     3,"RL",20,"Rodny list",NULL
  );

insert into "cis".code_documenttype
  (
    id,code, rank, name, note
  ) VALUES
  (
     4,"RP",20,"Ridicsky prukaz",NULL
  );
