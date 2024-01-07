package org.example;

import java.text.SimpleDateFormat;
import java.util.*;

public class App
{
    private static final Scanner scanner = new Scanner(System.in);
    private static void teacherPerspective(List<Discipline> disciplines) {
        while (true) {
            System.out.println("\nTeacher Perspective:");
            System.out.println("1. Add Discipline");
            System.out.println("2. Add Student");
            System.out.println("3. Add Grade");
            System.out.println("4. Calculate Final Average");
            System.out.println("5. Display Data");
            System.out.println("6. Sort Disciplines Alphabetically");
            System.out.println("7. Sort Students Alphabetically");
            System.out.println("8. Sort by Date");
            System.out.println("9. Overall ");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addDiscipline(disciplines);
                    break;
                case 2:
                    addStudent(disciplines);
                    break;
                case 3:
                    addGrade(disciplines);
                    break;
                case 4:
                    calculateFinalAverage(disciplines);
                    break;
                case 5:
                    displayData(disciplines);
                    break;
                case 6:
                    sortDisciplinesAlphabetically(disciplines);
                    break;
                case 7:
                    sortStudentsAlphabetically(disciplines);
                    break;
                case 8:
                    sortByDate(disciplines);
                    break;
                case 9:
                    generateOverallRanking(disciplines);
                    break;
                case 0:
                    FileManager.saveData(disciplines);
                    System.out.println("Exiting the application. Data saved.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void studentPerspective(List<Discipline> disciplines) {
        while (true) {
            System.out.println("\nStudent Perspective:");
            System.out.println("1. Display Data");
            System.out.println("2. Exit");
            System.out.println("n. Go back to roles");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayData(disciplines);
                    break;
                case 2:
                    System.out.println("Exiting the application.");
                    System.exit(0);
                    break;
                default:
                    Call();
            }
        }
    }
    private static void Call(){
        List<Discipline> disciplines = FileManager.loadData();

        System.out.print("Are you a teacher or a student? (1. Teacher, 2. Student): ");
        int userType = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (userType == 1) {
            teacherPerspective(disciplines);
        } else if (userType == 2) {
            studentPerspective(disciplines);
        } else {
            System.out.println("Invalid user type. Exiting the application.");
        }
    }

    public static void main( String[] args )
    {
        Call();
    }



    private static void addDiscipline(List<Discipline> disciplines) {
        System.out.print("Enter discipline name: ");
        String disciplineName = scanner.nextLine();

        disciplines.add(new Discipline(disciplineName));
        System.out.println("Discipline added successfully.");
    }

    private static void addStudent(List<Discipline> disciplines) {
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter discipline name to add the student: ");
        String disciplineName = scanner.nextLine();

        Discipline discipline = findDisciplineByName(disciplines, disciplineName);
        if (discipline != null) {
            discipline.addStudent(new Student(studentName));
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Discipline not found.");
        }
    }

    private static void addGrade(List<Discipline> disciplines)
    {
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter discipline name: ");
        String disciplineName = scanner.nextLine();

        System.out.print("Enter grade value: ");
        double gradeValue = scanner.nextDouble();

        Discipline discipline = findDisciplineByName(disciplines, disciplineName);
        if (discipline != null)
        {
            Student student = findStudentByName(discipline.getStudents(), studentName);
            if (student != null)
            {
                student.addGrade(disciplineName, gradeValue);
                System.out.println("Grade added successfully.");
            }
            else
            {
                System.out.println("Student not found.");
            }
        }
        else
        {
            System.out.println("Discipline not found.");
        }
    }

    private static void calculateFinalAverage(List<Discipline> disciplines)
    {
        System.out.print("Enter discipline name: ");
        String disciplineName = scanner.nextLine();

        Discipline discipline = findDisciplineByName(disciplines, disciplineName);
        if (discipline != null) {
            List<Student> students = discipline.getStudents();
            for (Student student : students) {
                List<Grade> grades = student.getGrades().get(disciplineName);
                if (grades != null && !grades.isEmpty()) {
                    double sum = grades.stream().mapToDouble(Grade::getValue).sum();
                    double average = sum / grades.size();
                    System.out.println("Student: " + student.getName() + ", Average: " + average);

                    student.addGrade("Overall", average);
                }
            }
        } else {
            System.out.println("Discipline not found.");
        }
    }

    private static void displayData(List<Discipline> disciplines)
    {
        for (Discipline discipline : disciplines) {
            System.out.println("\nDiscipline: " + discipline.getName());
            List<Student> students = discipline.getStudents();
            for (Student student : students) {
                System.out.println("  Student: " + student.getName());
                Map<String, List<Grade>> studentGrades = student.getGrades();
                for (Map.Entry<String, List<Grade>> entry : studentGrades.entrySet()) {
                    System.out.println("    Discipline: " + entry.getKey());
                    List<Grade> grades = entry.getValue();
                    for (Grade grade : grades) {
                        System.out.println("      Grade: " + grade.getValue()+ ", Date: "+
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(grade.getDate()));
                    }
                }
            }
        }
    }

    private static void sortDisciplinesAlphabetically(List<Discipline> disciplines) {
        disciplines.sort(Comparator.comparing(Discipline::getName));
        System.out.println("Disciplines sorted alphabetically.");
        displayData(disciplines);
    }

    private static void sortStudentsAlphabetically(List<Discipline> disciplines) {
        for (Discipline discipline : disciplines) {
            discipline.getStudents().sort(Comparator.comparing(Student::getName));
        }
        System.out.println("Students sorted alphabetically.");
        displayData(disciplines);
    }

    private static void sortByDate(List<Discipline> disciplines) {
        for (Discipline discipline : disciplines) {
            for (Student student : discipline.getStudents()) {
                Map<String, List<Grade>> studentGrades = student.getGrades();
                for (Map.Entry<String, List<Grade>> entry : studentGrades.entrySet()) {
                    entry.getValue().sort(Comparator.comparing(Grade::getDate));
                }
            }
        }
        System.out.println("Data sorted by date.");
        displayData(disciplines);
    }

    private static Discipline findDisciplineByName(List<Discipline> disciplines, String disciplineName) {
        for (Discipline discipline : disciplines) {
            if (discipline.getName().equalsIgnoreCase(disciplineName)) {
                return discipline;
            }
        }
        return null;
    }

    private static Student findStudentByName(List<Student> students, String studentName)
    {
        for (Student student : students)
        {
            if (student.getName().equalsIgnoreCase(studentName))
            {
                return student;
            }
        }
        return null;
    }

    private static void generateOverallRanking(List<Discipline> disciplines) {
        List<Student> overallRanking = new ArrayList<>();

        for (Discipline discipline : disciplines) {
            for (Student student : discipline.getStudents()) {
                Map<String, List<Grade>> studentGrades = student.getGrades();
                double totalAverage = 0.0;
                int count = 0;

                for (Map.Entry<String, List<Grade>> entry : studentGrades.entrySet()) {
                    List<Grade> grades = entry.getValue();
                    if (!grades.isEmpty()) {
                        double sum = grades.stream().mapToDouble(Grade::getValue).sum();
                        totalAverage += sum / grades.size();
                        count++;
                    }
                }

                if (count > 0) {
                    double overallAverage = totalAverage / count;
                    student.addGrade("Overall", overallAverage);
                    overallRanking.add(student);
                }
            }
        }

        overallRanking.sort(Comparator.comparingDouble(s -> s.getGrades().get("Overall").get(0).getValue()));
        Collections.reverse(overallRanking);

        System.out.println("\nOverall Ranking:");
        for (int i = 0; i < overallRanking.size(); i++) {
            Student student = overallRanking.get(i);
            System.out.println((i + 1) + ". " + student.getName() + ", Overall Average: " +
                    student.getGrades().get("Overall").get(0).getValue());
        }
    }
}
