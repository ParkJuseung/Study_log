create table tblLanguage(
    name varchar2(100) primary key,
    icon varchar2(100) not null,
    color varchar2(10) not null
);


insert into tblLanguage values ('Java','fa-brands fa-java','#27548A');
insert into tblLanguage values ('SQL','fa-solid fa-database','#27548A');
insert into tblLanguage values ('HTML','fa-brands fa-html5','#27548A');
insert into tblLanguage values ('CSS','fa-brands fa-css','#DDA853');
insert into tblLanguage values ('JavaScript','fa-brands fa-js','#FF9149');


create table tblCode(
    seq number primary key,
    subject varchar2(300) not null,
    code varchar2(2000) not null,
    regdate date default sysdate not null,
    language varchar2(100) not null references tblLanguage(name)
);


create sequence seqCode;