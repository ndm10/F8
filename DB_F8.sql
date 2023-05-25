-- drop database db_f8;
CREATE DATABASE DB_F8;
USE DB_F8;
create table Setting (
	id int primary key,
    actor nvarchar(100)
);
create table Account (
	id int AUTO_INCREMENT  primary key,
    userName nvarchar(100),
    password nvarchar(100),
    phone nvarchar(100),
    mail nvarchar(100),
    bio nvarchar(500),
    avatar nvarchar(100),
    url nvarchar(100),
    verificationCode nvarchar(100),
    registrationDate nvarchar(100),
    firstAndLastName nvarchar(100),
    coverImage nvarchar(300),
    roleID int,
    foreign key (roleID) references Setting(id)
);

create table Blog(
	id int primary key,
    title nvarchar(100),
    topic nvarchar(100),
    content nvarchar(1000),
    numOfLikes nvarchar(100),
    date nvarchar(100),
    userID int,
    foreign key (userID) references Account(id)
);
create table CommentBlog(
	id int primary key,
    content nvarchar(500),
    reply nvarchar(100),
    numOfLikes nvarchar(100),
    date nvarchar(100),
    userID int,
    foreign key (userID) references Account(id),
    blogID int,
    foreign key (blogID) references Blog(id)
);
create table RouteType(
	id int primary key,
    name nvarchar(100),
    indexx nvarchar(100)
);
create table Course(
	id int primary key,
    title nvarchar(100),
    numOfPeopleJoin nvarchar(100),
    price nvarchar(100),
    routeID int, 
    foreign key (routeID) references RouteType(id)
);
create table CourseDetail(
	id int primary key,
    level nvarchar(100),
    sumLesson nvarchar(100),
    time nvarchar(100),
    detailCourseDes nvarchar(500),
    image nvarchar(100),
    courseID int,
	foreign key (courseID) references Course(id)
);
create table CourseAccount(
	id int primary key,
    accountID int,
    foreign key (accountID) references Account(id),
    courseID int,
	foreign key (courseID)	references Course(id)
);
create table Chapter(
	id int primary key,
    name nvarchar(100)
);
create table Lesson(
	id int primary key,
    name nvarchar(100),
    content nvarchar(1000),
    retry nvarchar(100),
    date nvarchar(100),
    numOfLikes nvarchar(100),
    chapterID int,
	foreign key (chapterID)	references Chapter(id)
);
create table Question(
	id int primary key,
    content nvarchar(1000)
);
create table Answer(
	id int primary key,
    content nvarchar(500),
    quesID int,
    foreign key (quesID) references Question(id)
);
create table CorrectAnswer(
	id int primary key,
    content nvarchar(500),
    quesID int,
	foreign key (quesID)	references Question(id)
);
create table Note(
	id int primary key,
    detail nvarchar(500),
    date nvarchar(100),
    lessonID int,
	foreign key (lessonID)	references Lesson(id)
);
-- Insert Setting table
insert into Setting(id, actor) Values(1, "Admin");
insert into Setting(id, actor) Values(2, "Customer");
insert into Setting(id, actor) Values(3, "Marketing");
insert into Setting(id, actor) Values(4, "Sales");
insert into Setting(id, actor) Values(5, "Expert");
-- Insert Account table
insert into Account(id, userName, password, mail, bio, avatar, url, verificationCode, registrationDate, firstAndLastName, coverImage, roleID)
Values(1, "dat310", "123", "datnguyen83@fpt.edu.vn", "Hoa rơi cửa phật , vạn sự tùy duyên", "https://i.pinimg.com/originals/e0/0e/d9/e00ed96cc83f6dc8d3b54e9fb63161d2.jpg", "https://www.facebook.com/sieusao.chemgio.90", 
null, NOW(), "Dat Cuu", "https://thuthuatnhanh.com/wp-content/uploads/2020/01/hinh-anh-nhung-chu-cho-de-thuong-nhat.jpg", 1);
insert into Account(id, userName, password,phone, mail, bio, avatar, url, verificationCode, registrationDate, firstAndLastName, coverImage, roleID)
Values(2, "tri", "123","0377069365", "trilee2002@gmail.com", "tokada", "https://media-cdn-v2.laodong.vn/Storage/NewsPortal/2020/8/21/829850/Bat-Cuoi-Truoc-Nhung-07.jpg", "https://www.facebook.com/junfoke", 
null, NOW(), "trapboiz37", "https://i.pinimg.com/originals/2a/73/4d/2a734da3d156164bfe7f2836b279737c.jpg", 2);
insert into Account(id, userName, password, mail, bio, avatar, url, verificationCode, registrationDate, firstAndLastName, coverImage, roleID)
Values(3, "dinhdung123", "123", "dinhdungviettel@gmail.com", "toiyeufpt", "https://mega.com.vn/media/news/0206_leesin.jpg", "https://www.facebook.com/tiendungg.1411", 
null, NOW(), "Mãi yêu tập đoàn FPT", "https://i.pinimg.com/736x/de/1b/d8/de1bd867f4055b61a2fa4bab10dc8930.jpg", 5);
-- Insert into table RouteType
insert into RouteType(id, name, indexx) Values(1, "Front End", 1);
insert into RouteType(id, name, indexx) Values(2, "Back End", 1);
-- Insert Course table
insert into Course(id, title, numOfPeopleJoin, price, routeID) Values(1, "HTML, CSS", 1500, 0, 1);
insert into Course(id, title, numOfPeopleJoin, price, routeID) Values(2, "JavaScript", 1200, 0, 1);
insert into Course(id, title, numOfPeopleJoin, price, routeID) Values(3, "ReactJS", 1000, 0, 1);
insert into Course(id, title, numOfPeopleJoin, price, routeID) Values(4, "HTML, CSS", 1500, 0, 2);
insert into Course(id, title, numOfPeopleJoin, price, routeID) Values(5, "JavaScript", 1200, 0, 2);
insert into Course(id, title, numOfPeopleJoin, price, routeID) Values(6, "NodeJS", 1000, 0, 2);
insert into Course(id, title, numOfPeopleJoin, price, routeID) Values(7, "HTML CSS Pro", 100, 1000000, 1);
-- Insert CourseDetail Table
insert into CourseDetail(id, level, sumLesson, time, detailCourseDes, image, courseID) Values(1, "Easy", 20, "300", "Trong khóa này chúng ta sẽ cùng nhau xây dựng giao diện 2 trang web là The Band & Shopee.","https://files.fullstack.edu.vn/f8-prod/courses/2.png", 1);
insert into CourseDetail(id, level, sumLesson, time, detailCourseDes, image, courseID) Values(2, "Medium", 10, "150", "Học Javascript cơ bản phù hợp cho người chưa từng học lập trình. Với hơn 100 bài học và có bài tập thực hành sau mỗi bài học.","https://files.fullstack.edu.vn/f8-prod/courses/1.png", 2);
insert into CourseDetail(id, level, sumLesson, time, detailCourseDes, image, courseID) Values(3, "Hard", 15, "250", "Khóa học ReactJS từ cơ bản tới nâng cao, kết quả của khóa học này là bạn có thể làm hầu hết các dự án thường gặp với ReactJS. Cuối khóa học này bạn sẽ sở hữu một dự án giống Tiktok.com, bạn có thể tự tin đi xin việc khi nắm chắc các kiến thức được chia sẻ trong khóa học này.","https://files.fullstack.edu.vn/f8-prod/courses/13/13.png", 3);
insert into CourseDetail(id, level, sumLesson, time, detailCourseDes, image, courseID) Values(4, "Hard", 20, "300", "Học Back-end với Node & ExpressJS framework, hiểu các khái niệm khi làm Back-end và xây dựng RESTful API cho trang web.","https://files.fullstack.edu.vn/f8-prod/courses/6.png", 6);
insert into CourseDetail(id, level, sumLesson, time, detailCourseDes, image, courseID) Values(5, "Easy", 20, "300", "Cách dễ nhất để học HTML CSS cho người mới bắt đầu!","https://files.fullstack.edu.vn/f8-prod/courses/15/62f13d2424a47.png", 7);
-- use db_f8;
-- select * from Course c join CourseDetail cd on c.id = cd.courseID where c.price = 0;
-- select * from CourseDetail;
-- delete from CourseDetail where id > 4;
-- delete from Course where id > 6;

select * from account
