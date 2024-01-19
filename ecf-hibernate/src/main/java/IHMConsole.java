import daoImpl.*;
import entities.*;
import exception.InputManagementException;
import services.*;

import java.util.*;

public class IHMConsole {
    private Scanner sc = new Scanner(System.in);

    private  DepartementDAO departementDAO =new DepartementDAO();
    private DepartementService departementService;
    private  ProfessorDAO professorDAO = new ProfessorDAO();
    private ProfessorService professorService;
    private ClassDAO classDAO = new ClassDAO();
    private ClassService classService;
    private StudentDAO studentDAO = new StudentDAO();
    private StudentService studentService;
    private SubjectDAO subjectDAO = new SubjectDAO();
    private SubjectService subjectService;
    private ScoreDAO scoreDAO = new ScoreDAO();
    private ScoreService scoreService;
    private ScheduleDAO scheduleDAO =new ScheduleDAO();
    private ScheduleService scheduleService;

    public IHMConsole() {
        departementService = new DepartementService(departementDAO);
        professorService = new ProfessorService(professorDAO);
        classService = new ClassService(classDAO);
        studentService = new StudentService(new StudentDAO());
        subjectService =new SubjectService(subjectDAO);
        scoreService = new ScoreService(scoreDAO);
        scheduleService = new ScheduleService(scheduleDAO);

    }


    private void menu(){
        System.out.println("################ Menu ###################");
        System.out.println(" 1. Ajouter un département.");
        System.out.println(" 2. Ajouter un enseignant.");
        System.out.println(" 3. Ajouter une classe");
        System.out.println(" 4. Ajouter un étudiant.");
        System.out.println(" 5. Ajouter une matière .");
        System.out.println(" 6. Ajouter une note.");
        System.out.println(" 7. Ajouter un emploi du temps.");
        System.out.println(" 8. Afficher la liste des classes (sans les eleves).");
        System.out.println(" 9. Afficher le nombre de matière d'un élève");
        System.out.println("10 . Afficher la liste des notes d'un eleve (avec les détails)");
        System.out.println("11 . Aficher la moyenne d'un eleve");
        System.out.println("12 . Afficher le nombre d'eleve d'un département.");
        System.out.println("13 . Afficher tous les noms des eleves d'un niveau.");
        System.out.println("14 . Suppression d'un eleve, supprimera sa note mais pas sa classe");
        System.out.println("15 . Suppression classe => supprime uniquement les éléves de cette classe");
        System.out.println("16 . Suppression d'un departement => Supprime toutes les classes et tous les professeurs");
        System.out.println(" 0. Quitter l'application");
        System.out.println("################ ************ ###################");
        System.out.print("Choix : ");

    }
    public  void start() {
         String choice;
        do {
            menu();
            choice = sc.nextLine();

            switch (choice) {
                case "1":
                    addDepartement();
                    break;
                case "2":
                    addProfessor();
                    break;
                case "3":
                    addNewClass();
                    break;
                case "4":
                    addNewStudent();
                    break;
                case "5":
                    addNewSubject();
                    break;
                case "6":
                    addNewScore();
                    break;
                case "7":
                    addSchedule();
                    break;
                case "8":
                    showListOfClass();
                    break;
                case "9":
                    showStudentSubjects();
                    break;
                case "10":
                    viewStudentScoreDetail();
                    break;
                case "11":
                    showGPA();
                    break;
                case "12":
                    showStudentsByDepartement();
                    break;
                case "13":
                    showAllStudentByLevel();
                    break;
                case "14":
                    deletAllScoreByStudent();
                    break;
                case "15":
                    deleteAllStudentsByClass();
                    break;
                case "16":
                    deleteAllClassByDepartement();
                    break;

                default:
                    System.out.println("choix invalide !");

            }
        }while(!choice.equals("0"));
        classService.close();
    }



    private void addSchedule() {
        int num = InputManagementException.getAnInteger("Combien d'emploi du temps ajoutez- vous? ", "Veuillez entrer un nombre entier valide!!!");
        for (int i = 0 ; i < num ; i++){
            String dayOfWeek = InputManagementException.getString("Entrez le jour de la semaine: ", "Veuillez entrer un jour  valide!");
            String hour = InputManagementException.getFormattedTime("Entrez l'heure (en format hh:mm): ", "Format d'heure invalide. Utilisez HH:mm");
            int idStudent = InputManagementException.getAnInteger("Cet emploi du temps contient quel étudiant (son id): ",
                    "Veuillez entrer un id en format nombre entier valide!!!");
            Student student = studentService.getStudentById(idStudent);
            Schedule schedule = new Schedule(dayOfWeek, hour,student);
            scheduleService.addNewSchedule(schedule);
                System.out.println(" Emploi du temps bien ajouté");
            }




    }

    private void addNewScore() {

            int idStudent = InputManagementException.getAnInteger("Entrez l'identifiant de l'étudiant : ",
                    "Veuillez entrer un identifiant d'étudiant valide!");

            Student student = studentService.getStudentById(idStudent);

            if (student == null) {
                System.out.println("Aucun étudiant trouvé avec l'identifiant " + idStudent);
                return;
            }

            int idSubject = InputManagementException.getAnInteger("Entrez l'identifiant de la matière : ",
                    "Veuillez entrer un identifiant de matière valide!");

            Subject subject = subjectService.getSubjectById(idSubject);

            if (subject == null) {
                System.out.println("Aucune matière trouvée avec l'identifiant " + idSubject);
                return;
            }

            double scoreValue = InputManagementException.getADouble("Entrez la valeur du score : ",
                    "Veuillez entrer une valeur de score valide!");

            String comment = InputManagementException.getString("Entrez un commentaire : ",
                    "Veuillez entrer un commentaire valide!");

            Score newScore = new Score(comment, scoreValue, subject, student);

            if (scoreService.addNewScore(newScore)){
                System.out.println("Nouveau score ajouté pour l'étudiant " + student.getFirstName() + " " +
                        student.getLastName() + " dans la matière " + subject.getSubjName());
            } else {
                System.out.println("Erreur lors de l'ajout du score.");
            }


    }


    private void addNewSubject() {
        int num = InputManagementException.getAnInteger("Combien de matières souhaitez-vous ajouter? ",
                "Veuillez entrer un nombre entier valide!!!");

        for (int i = 0; i < num; i++) {
            String subjName = InputManagementException.getString("Entrez le nom de la matière : ",
                    "Veuillez entrer un nom valide!");

            String description = InputManagementException.getString("Entrez sa description : ",
                    "Veuillez entrer un format valide!");

            int during = InputManagementException.getAnInteger("Entrez la durée de la matière en minutes : ",
                    "Veuillez entrer un nombre entier valide!!!");

            int coef = InputManagementException.getAnInteger("Entrez le coefficient de la matière : ",
                    "Veuillez entrer un nombre entier valide!!!");

            int idScore = InputManagementException.getAnInteger("Entrez l'identifiant de la note d'étudiant : ",
                    "Veuillez entrer un id en format nombre entier valide!!!");

            Score score = scoreService.getScoreById(idScore);

            Subject subject = new Subject(subjName, description, coef, during);
            subject.getScores().add(score);

            if (subjectService.addNewSubject(subject)) {
                System.out.println("La matière a bien été créée avec l'ID " + subject.getIdSubj());
            }else {
                System.out.println("Erreur");
            }

        }
    }




    private void addNewStudent() {
        int num = InputManagementException.getAnInteger("Combien d'étudiants ajoutez- vous? ",
                "Veuillez entrer un nombre entier valide!!!");
        for (int i = 0; i < num ; i++) {
            String lastName = InputManagementException.getStringWithMinLength("Entrez le nom de l'étudiant qui contient au moins 3 caractères: ",
                    "Le nom de l'étudiant doit contenir au moins 3 caractères!!!", 3);
            String firstName = InputManagementException.getString("Entrez le prénom de l'étudiant : ",
                    "Veuillez entrer un prénom  valide!" );
            Date birthDate = InputManagementException.getUserDate(
                    "Veuillez entrer la date de naissance (format : dd/MM/yyyy) :  ",
                    "Format de date invalide. Veuillez utiliser le format dd/MM/yyyy." );
            String email = InputManagementException.getEmail("Entrez email en format @gmail.com: ", "Veuillez saisir un email valide ");
            Student student= new Student(lastName,firstName,birthDate, email);
            if (studentService.addNewStudent(student)) {
                System.out.println("\nÉtudiant ajouté avec succès !" + student.showProfile());
            } else {
                System.out.println("\nErreur lors de l'ajout de l'étudiant.");
            }

        }

    }


    private void addNewClass() {

            int num = InputManagementException.getAnInteger("Combien de classes ajoutez-vous? ",
                    "Veuillez entrer un nombre entier valide!!!");

            for (int i = 0; i < num; i++) {
                String className = InputManagementException.getString("Entrez le nom de la classe : ",
                        "Veuillez entrer un nom valide!");
                String level = InputManagementException.getString("Entrez le niveau de la classe : ",
                        "Veuillez entrer un niveau valide!");

                int idDept = InputManagementException.getAnInteger("Cette classe est dans quel département (son id): ",
                        "Veuillez entrer un nombre entier valide!");
                Departement departement = departementService.getDepartementById(idDept);

                Set<Student> students = new HashSet<>();
                 int idStudent = InputManagementException.getAnInteger("Cette classe contient quel étudiant (son id): ",
                            "Veuillez entrer un id en format nombre entier valide!!!");

                  if (idStudent != 0) {
                        Student student = studentService.getStudentById(idStudent);
                        if (student != null) {
                            students.add(student);
                        } else {
                            System.out.println("Aucun étudiant trouvé avec l'ID " + idStudent);
                        }
                    }


                Set<Professor> professors = new HashSet<>();
                int idProf = InputManagementException.getAnInteger("Cette classe est dirigée par quel enseignant (son id): ",
                            "Veuillez entrer un id en format nombre entier valide!!!");

                    if (idProf != 0) {
                        Professor teacher = professorService.getProfessorByRegisterNumber(idProf);
                        if (teacher != null) {
                            professors.add(teacher);
                        } else {
                            System.out.println("Aucun enseignant trouvé avec l'ID " + idProf);
                        }
                    }

                ClassRoom newClassRoom = new ClassRoom(className, level, departement, students, professors);
                newClassRoom.setClassName(className);
                newClassRoom.setLevel(level);
                newClassRoom.getDepartment(departement);
                newClassRoom.setStudentList(new HashSet<>(students));
                newClassRoom.setProfessors(new HashSet<>(professors));

                if (classService.addNewClass(newClassRoom)) {
                    System.out.println("Une classe bien ajoutée: " + newClassRoom.getIdClass() + " " + newClassRoom.getClassName());
                }else {
                    System.out.println("Erreur lors de l'ajout de la classe.");
                }


            }

    }


    private void addProfessor() {
        int num = InputManagementException.getAnInteger("Combien de professeurs ajoutez- vous? ",
                "Veuillez entrer un nombre entier valide!!!");
        for (int i = 0; i < num ; i++) {
            String lastName = InputManagementException.getStringWithMinLength("Entrez le nom de l'enseignant qui contient au moins 3 caractères: ",
                    "Le nom de l'enseignant doit contenir au moins 3 caractères!!!", 3);
            String firstName = InputManagementException.getString("Entrez le prénom de l'enseignant : ",
                    "Veuillez entrer un prénom  valide!" );
            int age = InputManagementException.getAnIntegerWithMinValue("Saisissez l'âge du professeur (doit être majeur) :  ",
                    "Le professeur doit être majeur!", 18);
            int idDept = InputManagementException.getAnInteger("Dérisez - vous dans quel département(son id): ",
                    "Veuillez entrer un nombre entier valide!!!");
            boolean isPrincipal = InputManagementException.getBoolean("Le professeur est-il principal? (true/false): ",
                    "Veuillez saisir une valeur valide (true/false).");
            int grade = InputManagementException.getAnInteger("Entrez - vous le grade de prof: ","Veuillez entrer un nombre entier valide!!!" );
            Professor  prof = new Professor(lastName, firstName, age, isPrincipal,grade);
             if (departementService.addProfessorByDepartment(prof, idDept)){
                 System.out.println("Professeur ajouté");
             }else {
                 System.out.println("Erreur ajoute de professeur!!!");
             }


        }
    }

    private void addDepartement() {
        int num = InputManagementException.getAnInteger("Combien de département ajoutez- vous? ", "Veuillez entrer un nombre entier valide!!!");
        for (int i = 0 ; i < num ; i++){
            String nameDept = InputManagementException.getString("Entrez le nom de département: ", "Veuillez entrer un nom  valide!");
            Departement dept = new Departement(nameDept);
             departementService.addNewDepartement(dept);
            System.out.println("Votre département bien ajouté");

        }
    }

    private void deleteAllClassByDepartement() {
        try {
            int idClass = InputManagementException.getAnInteger("Dérisez - vous suprrimer quelle classe?( par son id): ",
                    "Veuillez entrer un nombre entier valide!!!");

           ClassRoom classroom = classService.getClassById(idClass);
            if (classroom != null) {
                classService.deleteClassById(idClass);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void deleteAllStudentsByClass() {
        try {
            int idStudent = InputManagementException.getAnInteger("Dérisez - vous suprrimer un étudiant?( par son id): ",
                    "Veuillez entrer un nombre entier valide!!!");
            Student st = studentService.getStudentById(idStudent);
            if (st != null) {
                studentService.deleteStudent(idStudent);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void deletAllScoreByStudent() {

    }
    private void showAllStudentByLevel() {

            String level = InputManagementException.getString("Veuillez entrer le niveau pour lequel vous souhaitez afficher les étudiants : ",
                    "Veuillez entrer un niveau valide!");

            List<Object[]> studentNames = studentService.getStudentsByClassLevel(level);

            if (!studentNames.isEmpty()) {
                System.out.println("Liste des noms d'étudiants pour le niveau " + level + ":");
                studentNames.forEach(studentName -> System.out.println(studentName));

            } else {
                System.out.println("Aucun étudiant trouvé pour le niveau " + level);
            }



    }


    private void showStudentsByDepartement() {
        int idDept = InputManagementException.getAnInteger("Dérisez - vous dans quel département(son id): ",
                "Veuillez entrer un nombre entier valide!!!");
        Departement depart = departementService.getDepartementById(idDept);
        if (depart != null) {
            Long count = studentService.countStudentsByDepartment(idDept);
            System.out.println(" Nombre d'étudiant dans ce département est : " + count);
        }

    }

    private void showGPA() {
        int idStudent = InputManagementException.getAnInteger("Dérisez - vous consulter les notes de quel étudiant?( par son id): ",
                "Veuillez entrer un nombre entier valide!!!");
        Student st = studentService.getStudentById(idStudent);
        if (st != null){
            Double gpa = scoreService.getGPAByStudent(idStudent);
            System.out.printf("|%d|%-15s|%-15s|%10s|Moyenne : %10.2f  |\n", idStudent, st.getLastName(), st.getFirstName(), st.getClass(), gpa);

        }
    }

    private void viewStudentScoreDetail() {
        int idStudent = InputManagementException.getAnInteger("Dérisez - vous consulter les notes de quel étudiant?( par son id): ",
                "Veuillez entrer un nombre entier valide!!!");
        Student st = studentService.getStudentById(idStudent);
        if (st != null){
            List<Score> scores = scoreService.getAllScoreByStudent(idStudent);
            scores.forEach(score-> System.out.printf("|%d|%-15s|%-15s|%10s|%-20d|", idStudent, st.getLastName(),st.getFirstName(),st.getClass(),score));
        }
    }

    private void showStudentSubjects() {
    }

    private void showListOfClass() {
        try {
            List<ClassRoom> classRooms = classService.getAllClass();
           classRooms.forEach(cl-> System.out.printf("\n|%5d|%-15s|%5s|", cl.getIdClass(),cl.getClassName(),cl.getLevel()));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
