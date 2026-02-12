import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Faculty itFaculty = FacultyFactory.getFaculty("IT");
        Faculty lawFaculty = FacultyFactory.getFaculty("Law");
        Faculty econFaculty = FacultyFactory.getFaculty("Economics");


        StudentState studying = new StudyingState();
        StudentState session = new SessionState();
        StudentState expelled = new ExpelledState();


        Student anna = new Student.Builder(1, "Анна")
                .setCourse(2)
                .setAverageMark(4.5)
                .setFaculty(itFaculty)
                .build();

        Student bogdan = new Student.Builder(2, "Богдан")
                .setCourse(1)
                .setAverageMark(3.8)
                .setFaculty(lawFaculty)
                .build();

        Student viktoria = new Student.Builder(3, "Вікторія")
                .setCourse(3)
                .setAverageMark(2.5)
                .setFaculty(econFaculty)
                .build();


        Student[] students = {anna, bogdan, viktoria};


        for (Student student : students) {
            System.out.println("\n=== " + student.getName() + " (" + student.getFaculty().getName() + ") ===");

            System.out.println("Оберіть стан студента:");
            System.out.println("1 - Навчається");
            System.out.println("2 - На сесії");
            System.out.println("3 - Відрахований");

            int choice = 0;
            while (choice < 1 || choice > 3) {
                System.out.print("Введіть номер стану: ");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    if (choice < 1 || choice > 3) {
                        System.out.println("Некоректний вибір. Спробуйте ще раз.");
                    }
                } else {
                    System.out.println("Будь ласка, введіть число!");
                    scanner.next();
                }
            }


            switch (choice) {
                case 1 -> student.setState(studying);
                case 2 -> student.setState(session);
                case 3 -> student.setState(expelled);
            }


            student.performAction();
        }

        scanner.close();
    }
}
