-- nutno spoustet z adresare s unl soubory
-- dbaccess -a -e cis2 < import.sql

truncate table code_state;
load from code_state.unl insert into code_state;

truncate table code_documenttype;
load from code_documenttype.unl insert into code_documenttype;

truncate table code_permissiontype;
load from code_permissiontype.unl insert into code_permissiontype;

truncate table code_purposeofstay;
load from code_purposeofstay.unl insert into code_purposeofstay;

