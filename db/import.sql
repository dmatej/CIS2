-- nutno spoustet z adresare s unl soubory
-- dbaccess -a -e cis2 < import.sql

truncate table code_state;
load from code_state.unl insert into code_state;

