CIS2
====
Malý školní projekt, prototyp nového GUI CIS.

Inicializace databáze
---------------------
Informix 11.70DE
- pod Linuxem viz firemní dokumentace
- pod Windows:
(úprava spouštěcího skriptu pro cmd)... C:\Program Files\IBM\Informix\11.70\ol_informix1170.cmd
- změnit oprávnění pro uživatele
- editovat, přidat ... v mém případě:

        set INFORMIXDIR=C:\PROGRA~1\IBM\Informix\11.70
        set REGMACHINE=\\DMATEJ-VIRTUAL
        set INFORMIXSERVER=ol_informix1170
        set ONCONFIG=onconfig.ol_informix1170
        set PATH=%INFORMIXDIR%\bin;%PATH%
        set CLIENT_LOCALE=cs_cz.912@sis
        set DBDATE=dmy4.
        set DBD_INFORMIX_DATABASE=cis
        set DB_LOCALE=cs_cz.912@sis
        set DBMONEY=.Kc

- vytvořit prázdný soubor na nějaké cestě (to je na vás, parametr -p) a pak spustit:

        onspaces -c -d dbspacecis -p /app/informix/informix/dbspaces/dbspacecis -o 0 -s 7340032

- vytvořte databázi v dbspace; pozor na locale, viz set výše - po změně pak nejde spustit žádné SQL proti db, tj. ani drop!

        echo  drop database cis; | dbaccess
        echo  create database cis in dbspacecis with buffered log; | dbaccess

- vytvořte schéma:

        dbaccess -a -e cis < f:\db\jet.sql 

Spuštění buildu
---------------
    mvn clean verify

Instalace EAR na Glassfish3
-----------------------
1. vytvořit jdbc pool cis
2. vytvořit jdbc resource jdbc/cis

V domain.xml pak bude tohle:

    <jdbc-connection-pool
      connection-validation-method="meta-data" max-pool-size="8"
      datasource-classname="com.informix.jdbcx.IfxXADataSource" pool-resize-quantity="1"
      res-type="javax.sql.XADataSource" steady-pool-size="1" allow-non-component-callers="true"
      name="cis" is-connection-validation-required="true" ping="true">
      <property name="user" value="informix"></property>
      <property name="password" value="localcis"></property>
      <property name="IfxCLIENT_LOCALE" value="cs_cz.912@sis"></property>
      <property name="IfxIFXHOST" value="localhost"></property>
      <property name="portNumber" value="1520"></property>
      <property name="databaseName" value="cis"></property>
      <property name="ServerName" value="localcis"></property>
      <property name="JDBC30DataSource" value="true"></property><!-- ifxjdbc nepodporuje JDBC4, jen 3 -->
    </jdbc-connection-pool>
    <jdbc-resource pool-name="cis" description="" jndi-name="jdbc/cis"></jdbc-resource>

Funguje to?
-----------

Zkuste do browseru zadat tohle (příp. upravte port podle vašeho GF): http://localhost:8080/cis/db

