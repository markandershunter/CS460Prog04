--Adviser
insert into adviser (id_num, name, position, dept_name, phone_num, email)
    values (1001, 'Rudy Bates', 'Student Adviser', 'English', '520-546-9442', 'rudybates@yahoo.com');

insert into adviser (id_num, name, position, dept_name, phone_num, email)
    values (1002, 'Caden Bailey', 'Student Adviser', 'Math', '520-569-4371', 'cadenbailey@hotmail.com');

insert into adviser (id_num, name, position, dept_name, phone_num, email)
    values (1003, 'Jackie Reynolds', 'Student Adviser', 'Biology', '226-906-2721', 'jackiereynolds@gmail.com');

insert into adviser (id_num, name, position, dept_name, phone_num, email)
    values (1004, 'Jaime Price', 'Student Adviser', 'Chemistry', '630-446-8851', 'jaimeprice@hotmail.com');

insert into adviser (id_num, name, position, dept_name, phone_num, email)
    values (1005, 'Aaren Marsh', 'Student Adviser', 'Engineering', '520-355-1755', 'aarenmarsh@gmail.com');

--Room
insert into room (room_num, building_num, monthly_rent)
    values (101, 1, 700);

insert into room (room_num, building_num, monthly_rent)
    values (102, 1, 700);

insert into room (room_num, building_num, monthly_rent)
    values (103, 1, 700);

insert into room (room_num, building_num, monthly_rent)
    values (201, 1, 750);

insert into room (room_num, building_num, monthly_rent)
    values (202, 1, 750);

insert into room (room_num, building_num, monthly_rent)
    values (203, 1, 750);

insert into room (room_num, building_num, monthly_rent)
    values (101, 2, 850);

insert into room (room_num, building_num, monthly_rent)
    values (102, 2, 850);

insert into room (room_num, building_num, monthly_rent)
    values (103, 2, 850);

--Building
insert into building (building_num, type)
    values (1, 'apartment');

insert into building (building_num, type)
    values (2, 'res_hall');

--Staff
insert into staff (staff_id, building_num, name, email, home_addr, dob, gender, title)
    values (1006, 1, 'Josh Wallace', 'joshwallace@gmail.com', '123 6th St', '03/21/1987', 'male', 'hall manager');

insert into staff (staff_id, building_num, name, email, home_addr, dob, gender, title)
    values (1007, 1, 'Dexter Morris', 'dextermorris@hotmail.com', '4 Goldfield Rd', '01/07/1962', 'male', 'cleaner');

insert into staff (staff_id, building_num, name, email, home_addr, dob, gender, title)
    values (1008, 1, 'August Hickman', 'august@yahoo.com', '514 S Magnolia St', '10/29/1978', 'female', 'administrative assistant');

insert into staff (staff_id, building_num, name, email, home_addr, dob, gender, title)
    values (1009, 2, 'Jadon Figueroa', 'jadenfig@gmail.com', '71 Pilgrim Ave', '12/06/1980', 'male', 'hall manager');

insert into staff (staff_id, building_num, name, email, home_addr, dob, gender, title)
    values (1010, 2, 'Luciano Golden', 'lucgold@hotmail.com', '76 Ryan Ave', '06/08/1972', 'male', 'cleaner');

insert into staff (staff_id, building_num, name, email, home_addr, dob, gender, title)
    values (1011, 2, 'Ashton Arnold', 'ashton@gmail.com', '36 Talbot Ave', '07/01/1991', 'female', 'administrative assistant');

--Inspection
insert into inspection (inspection_id, staff_id, inspect_date, good_cond, actions, room_num, building_num)
    values (1, 1006, '06/09/2018', 1, 'none', 101, 1);

insert into inspection (inspection_id, staff_id, inspect_date, good_cond, actions, room_num, building_num)
    values (2, 1006, '06/09/2018', 1, 'none', 102, 1);

insert into inspection (inspection_id, staff_id, inspect_date, good_cond, actions, room_num, building_num)
    values (3, 1006, '06/10/2018', 0, 'leaseholder was fined', 103, 1);

insert into inspection (inspection_id, staff_id, inspect_date, good_cond, actions, room_num, building_num)
    values (4, 1006, '06/10/2018', 1, 'none', 201, 1);

insert into inspection (inspection_id, staff_id, inspect_date, good_cond, actions, room_num, building_num)
    values (5, 1006, '06/10/2018', 1, 'none', 202, 1);

insert into inspection (inspection_id, staff_id, inspect_date, good_cond, actions, room_num, building_num)
    values (6, 1006, '06/10/2018', 0, 'leaseholder was fined and charged for repairs', 203, 1);

insert into inspection (inspection_id, staff_id, inspect_date, good_cond, actions, room_num, building_num)
    values (10, 1009, '06/09/2018', 1, 'none', 101, 2);

insert into inspection (inspection_id, staff_id, inspect_date, good_cond, actions, room_num, building_num)
    values (11, 1009, '06/09/2018', 1, 'none', 102, 2);

insert into inspection (inspection_id, staff_id, inspect_date, good_cond, actions, room_num, building_num)
    values (12, 1009, '06/09/2018', 1, 'none', 103, 2);

--Student
insert into student (id_num, name, home_addr, phone_num, email, gender, dob, category, major, minor, adviser_id)
    values (2001, 'Billie Graves', '3 N York St', '520-387-9624', 'bgraves@gmail.com', 'male', '07/03/2001', 'undergrad', 'English', 'none', 1001);

insert into student (id_num, name, home_addr, phone_num, email, gender, dob, category, major, minor, adviser_id)
    values (2002, 'Aubrey White', '8851 Essex St', '520-674-5832', 'awhite@yahoo.com', 'female', '04/21/2000', 'undergrad', 'Biology', 'none', 1003);

insert into student (id_num, name, home_addr, phone_num, email, gender, dob, category, major, minor, adviser_id)
    values (2003, 'Franky Gordon', '313 Carson Lane', '520-643-7591', 'frankgord@hotmail.com', 'male', '01/02/1997', 'postgrad', 'English', 'Spanish', 1001);

insert into student (id_num, name, home_addr, phone_num, email, gender, dob, category, major, minor, adviser_id)
    values (2004, 'Sammy Smith', '831 Walnut Drive', '520-871-4352', 'sammay@yahoo.com', 'male', '02/01/1996', 'postgrad', 'Engineering', 'Math', 1005);

insert into student (id_num, name, home_addr, phone_num, email, gender, dob, category, major, minor, adviser_id)
    values (2005, 'Alexis Madden', '296 Hawthorne Ave', '520-631-7869', 'madalex@gmail.com', 'female', '08/09/1999', 'undergrad', 'Chemistry', 'none', 1004);

insert into student (id_num, name, home_addr, phone_num, email, gender, dob, category, major, minor, adviser_id)
    values (2006, 'Rory Parker', '751 Henry Lane', '520-439-1123', 'rory@yahoo.com', 'male', '09/30/2001', 'undergrad', 'Math', 'none', 1002);

insert into student (id_num, name, home_addr, phone_num, email, gender, dob, category, major, minor, adviser_id)
    values (2007, 'John Jacobs', '123 Drury Lane', '520-119-9103', 'jj@gmail.com', 'male', '12/31/2002', 'undergrad', 'English', 'Psychology', 1001);

insert into student (id_num, name, home_addr, phone_num, email, gender, dob, category, major, minor, adviser_id)
    values (2008, 'Jess Young', '561 E North Ave', '520-768-9212', 'jesss@yahoo.com', 'female', '12/12/2000', 'undergrad', 'Biology', 'none', 1003);

insert into student (id_num, name, home_addr, phone_num, email, gender, dob, category, major, minor, adviser_id)
    values (2009, 'Gale Gates', '3498 S Pillar Rd', '602-907-8904', 'ggates@gmail.com', 'female', '11/11/1999', 'undergrad', 'Chemistry', 'none', 1004);

--Lease
insert into lease (lease_num, duration, student_id, building_num, room_num, monthly_cost)
    values (1, 2, 2007, 1, 103, 700);

insert into lease (lease_num, duration, student_id, building_num, room_num, monthly_cost)
    values (2, 1, 2004, 1, 102, 700);

insert into lease (lease_num, duration, student_id, building_num, room_num, monthly_cost)
    values (3, 2, 2001, 1, 101, 700);

insert into lease (lease_num, duration, student_id, building_num, room_num, monthly_cost)
    values (4, 2, 2003, 1, 201, 750);

insert into lease (lease_num, duration, student_id, building_num, room_num, monthly_cost)
    values (5, 1, 2005, 1, 202, 750);

insert into lease (lease_num, duration, student_id, building_num, room_num, monthly_cost)
    values (6, 2, 2002, 1, 203, 750);

insert into lease (lease_num, duration, student_id, building_num, room_num, monthly_cost)
    values (7, 2, 2006, 2, 101, 850);

insert into lease (lease_num, duration, student_id, building_num, room_num, monthly_cost)
    values (9, 1, 2009, 2, 102, 850);

insert into lease (lease_num, duration, student_id, building_num, room_num, monthly_cost)
    values (9, 2, 2008, 2, 103, 850);

--Invoice
insert into invoice (invoice_num, lease_num, semester, amount_due, date_paid)
    values (1, 1, 1, 700, '');

insert into invoice (invoice_num, lease_num, semester, amount_due, date_paid)
    values (2, 2, 1, 700, '04/01/2018');

insert into invoice (invoice_num, lease_num, semester, amount_due, date_paid)
    values (3, 3, 1, 700, '04/01/2018');

insert into invoice (invoice_num, lease_num, semester, amount_due, date_paid)
    values (4, 4, 2, 750, '04/01/2018');

insert into invoice (invoice_num, lease_num, semester, amount_due, date_paid)
    values (5, 5, 1, 750, '04/01/2018');

insert into invoice (invoice_num, lease_num, semester, amount_due, date_paid)
    values (6, 6, 1, 750, '04/01/2018');

insert into invoice (invoice_num, lease_num, semester, amount_due, date_paid)
    values (7, 7, 2, 850, '04/01/2018');

insert into invoice (invoice_num, lease_num, semester, amount_due, date_paid)
    values (8, 8, 1, 850, '');

insert into invoice (invoice_num, lease_num, semester, amount_due, date_paid)
    values (9, 9, 2, 850, '');

--resHallInfo
insert into resHallInfo (building_num, name, addr, staff_id, phone_num)
    values (1, 'Hall1', '124 7th Ave', 1006, '520-674-9838');

insert into resHallInfo (building_num, name, addr, staff_id, phone_num)
    values (2, 'Hall2', '125 7th Ave', 1009, '520-912-0457');
