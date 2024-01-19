create database schoolbis;
use schoolbis;
CREATE TABLE Professor(
   register_Number_ VARCHAR(50)  ,
   firstName VARCHAR(50) NOT NULL,
   lastName VARCHAR(50) NOT NULL,
   age INT,
   prof_principal boolean,
   grade INT,
   PRIMARY KEY(register_Number_)
);

CREATE TABLE Subject(
   id_subj INT  Auto_increment,
   subj_name VARCHAR(50),
   description_ VARCHAR(50),
   coefficient_ INT,
   during INT,
   PRIMARY KEY(id_subj)
);

CREATE TABLE schedule(
   id_day_class INT  Auto_increment,
   day_class VARCHAR(50) NOT NULL,
   hour_class TIME NOT NULL,
   PRIMARY KEY(id_day_class)
);

CREATE TABLE Departement(
   id_Dept INT  Auto_increment,
   deptName VARCHAR(50),
   register_Number_ VARCHAR(50) NOT NULL,
   PRIMARY KEY(id_Dept),
   FOREIGN KEY(register_Number_) REFERENCES Professor(register_Number_)
);

CREATE TABLE Class(
   id_class INT  Auto_increment,
   class_name VARCHAR(50),
   level VARCHAR(50),
   id_Dept INT NOT NULL,
   PRIMARY KEY(id_class),
   FOREIGN KEY(id_Dept) REFERENCES Departement(id_Dept)
);

CREATE TABLE Student(
   id_student INT  Auto_increment,
   firstName VARCHAR(50) NOT NULL,
   lastName VARCHAR(50) NOT NULL,
   date_of_birth DATE,
   email VARCHAR(50),
   id_day_class INT NOT NULL,
   id_class INT NOT NULL,
   PRIMARY KEY(id_student),
   FOREIGN KEY(id_day_class) REFERENCES schedule(id_day_class),
   FOREIGN KEY(id_class) REFERENCES Class(id_class)
);

CREATE TABLE Score(
   id_score INT  Auto_increment,
   comment VARCHAR(50),
   score VARCHAR(50),
   id_subj INT NOT NULL,
   id_student INT NOT NULL,
   PRIMARY KEY(id_score),
   FOREIGN KEY(id_subj) REFERENCES Subject(id_subj),
   FOREIGN KEY(id_student) REFERENCES Student(id_student)
);

CREATE TABLE enseigner(
   register_Number_ VARCHAR(50)  ,
   id_subj INT,
   PRIMARY KEY(register_Number_, id_subj),
   FOREIGN KEY(register_Number_) REFERENCES Professor(register_Number_),
   FOREIGN KEY(id_subj) REFERENCES Subject(id_subj)
);

CREATE TABLE occuper_(
   register_Number_ VARCHAR(50),
   id_class INT,
   PRIMARY KEY(register_Number_, id_class),
   FOREIGN KEY(register_Number_) REFERENCES Professor(register_Number_),
   FOREIGN KEY(id_class) REFERENCES Class(id_class)
);

-- Insertion des données pour Professor
INSERT INTO Professor (register_Number_, firstName, lastName, age, prof_principal, grade)
VALUES
    ('PROF001', 'John', 'Doe', 40, true, 1),
    ('PROF002', 'Jane', 'Smith', 35, false, 2),
    ('PROF003', 'Bob', 'Johnson', 45, true, 3);

-- Insertion des données pour Subject
INSERT INTO Subject (id_subj, subj_name, description_, coefficient_, during)
VALUES
    (1, 'Mathematics', 'Advanced Math', 3, 60),
    (2, 'History', 'World History', 2, 45),
    (3, 'Science', 'Physics', 4, 75);

-- Insertion des données pour Schedule
INSERT INTO Schedule (id_day_class, day_class, hour_class)
VALUES
    (1, 'Monday', '09:00'),
    (2, 'Wednesday', '14:30'),
    (3, 'Friday', '11:15');

-- Insertion des données pour Departement
-- Correction de la requête d'insertion pour Departement
INSERT INTO Departement (deptName, register_Number_)
VALUES
    ('Science Department', 'PROF001'),
    ('History Department', 'PROF002'),
    ('Math Department', 'PROF003');


-- Insertion des données pour Class
INSERT INTO Class (id_class, class_name, level, id_Dept)
VALUES
    (1, 'ClassA', '5th Grade', 1),
    (2, 'ClassB', '8th Grade', 2),
    (3, 'ClassC', '10th Grade', 3);

-- Insertion des données pour Student
INSERT INTO Student (id_student, firstName, lastName, date_of_birth, email, id_day_class, id_class)
VALUES
    (1, 'Alice', 'Johnson', '2005-03-12', 'alice@example.com', 1, 1),
    (2, 'Bob', 'Williams', '2004-07-25', 'bob@example.com', 2, 2),
    (3, 'Catherine', 'Brown', '2003-01-10', 'catherine@example.com', 3, 3);

-- Insertion des données pour Score
INSERT INTO Score (id_score, comment, score, id_subj, id_student)
VALUES
    (1, 'Excellent', 'A+', 1, 1),
    (2, 'Good', 'B', 1, 2),
    (3, 'Average', 'C', 2, 3);

-- Insertion des données pour Enseigner
INSERT INTO enseigner (register_Number_, id_subj)
VALUES
    ('PROF001', 1),
    ('PROF002', 2),
    ('PROF003', 3);


-- Insertion de données pour Occuper_
INSERT INTO occuper_ (register_Number_, id_class)
VALUES
    ('PROF001', 1),
    ('PROF002', 2),
    ('PROF003', 3);


-- Afficher la liste des classes (sans les élèves) :
SELECT id_class, class_name, level FROM Class;
 -- Afficher le nombre de matières d'un élève :
SELECT s.firstName, s.lastName, COUNT(sc.id_subj) AS nombre_matieres
FROM Student s
LEFT JOIN Score sc ON s.id_student = sc.id_student
WHERE s.id_student = 1;

INSERT INTO Subject (id_subj, subj_name, description_, coefficient_, during)
VALUES
    (4, 'Anglais', 'Advanced English', 2, 60);
INSERT INTO Score (id_score, comment, score, id_subj, id_student)
VALUES
    (4, 'Excellent', 'A++', 4, 1);    
select * from Student;
select * from subject;
select * from score;
-- Afficher la liste des notes d'un élève (avec les détails) :
SELECT s.firstName, s.lastName, su.subj_name, sc.comment, sc.score
FROM Student s
JOIN Score sc ON s.id_student = sc.id_student
JOIN Subject su ON sc.id_subj = su.id_subj
WHERE s.id_student = 1;

 -- Afficher la moyenne d'un élève :
 SELECT s.firstName, s.lastName, AVG(CAST(sc.score AS DECIMAL)) AS moyenne
FROM Student s
JOIN Score sc ON s.id_student = sc.id_student
WHERE s.id_student = 1;

 
 
 -- Afficher le nombre d'élèves d'un département :
SELECT d.deptName, COUNT(s.id_student) AS nombre_eleves
FROM Departement d
JOIN Class c ON d.id_Dept = c.id_Dept
JOIN Student s ON c.id_class = s.id_class
GROUP BY d.deptName;

-- Afficher tous les noms des élèves d'un niveau :
SELECT c.level, s.firstName, s.lastName
FROM Class c
JOIN Student s ON c.id_class = s.id_class
WHERE c.level = '5th Grade';

-- Suppression d'un eleve, supprimera sa note mais pas sa classe.
-- Suppression d'un élève par son identifiant
DELETE FROM Student WHERE id_student = 1;


-- Suppression classe => supprime uniquement les éléves de cette classe.
-- Suppression d'une classe par son identifiant
DELETE FROM Class WHERE id_class = 1;



-- Suppression d'un departement => Supprime toutes les classes et tous les professeurs.

-- Suppression d'un département par son identifiant
DELETE FROM Departement WHERE id_Dept = 1;
-- Suppression de toutes les classes du département
DELETE FROM Class WHERE id_Dept = 1;
-- Suppression de tous les professeurs du département
DELETE FROM Professor WHERE register_Number_ IN (SELECT register_Number_ FROM Departement WHERE id_Dept = 1);

