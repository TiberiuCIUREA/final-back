create table mentor (email varchar(255) not null, type varchar(255), first_name varchar(255), last_name varchar(255), phone_number varchar(255), linkedin_url varchar(255), no_of_overall_trainings_done integer not null, years_of_experience integer, primary key (email));
create table mentor_calendar (id varchar(255) not null, type varchar(255), end_time timestamp not null, maximum_number_of_trainees integer not null, start_time timestamp not null, training_id varchar(255), primary key (id));
create table mentor_calendar_trainees_booked (mentor_calendar_id varchar(255) not null, email varchar(255));
create table mentor_training (id varchar(255) not null, type varchar(255), facilities varchar(255), fee decimal(19,2) not null, mentor_id varchar(255), no_of_trainings_done integer not null, training_prerequisite varchar(255), skill_id varchar(255), primary key (id));
create table skill (id varchar(255) not null, type varchar(255), skill_name varchar(255), primary key (id));
create table user (email varchar(255) not null, type varchar(255), first_name varchar(255), last_name varchar(255), phone_number varchar(255), primary key (email));
alter table mentor_calendar_trainees_booked add constraint FK7px49or1558ad1fvbq3rprwn4 foreign key (mentor_calendar_id) references mentor_calendar;
alter table mentor_training add constraint FKr4i7mi8tn120db8fh8l1wkh3g foreign key (mentor_id) references mentor;
