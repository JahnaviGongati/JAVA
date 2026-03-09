import java.io.*;
import java.util.*;

public class StudentCourseSystem {

    static Scanner sc = new Scanner(System.in);
    static String fileName = "students.txt";

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== STUDENT COURSE REGISTRATION SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);
    }

    // Add Student
    static void addStudent() {

        try {
            FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);

            System.out.print("Enter Roll Number: ");
            int roll = sc.nextInt();

            sc.nextLine(); // Clear buffer

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Course: ");
            String course = sc.nextLine();

            System.out.print("Enter Year: ");
            String year = sc.nextLine();

            bw.write(roll + "," + name + "," + course + "," + year);
            bw.newLine();

            bw.close();

            System.out.println("Student Added Successfully!");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    // View Students
    static void viewStudents() {

        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            String line;

            System.out.println("\nRoll\tName\tCourse\tYear");
            System.out.println("--------------------------------");

            while ((line = br.readLine()) != null) {

                String data[] = line.split(",");

                System.out.println(data[0] + "\t" + data[1] + "\t" + data[2] + "\t" + data[3]);
            }

            br.close();

        } catch (Exception e) {
            System.out.println("No Records Found!");
        }
    }

    // Search Student
    static void searchStudent() {

        System.out.print("Enter Roll Number to Search: ");
        int searchRoll = sc.nextInt();

        boolean found = false;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            String line;

            while ((line = br.readLine()) != null) {

                String data[] = line.split(",");

                if (Integer.parseInt(data[0]) == searchRoll) {

                    System.out.println("\nStudent Found!");
                    System.out.println("Roll: " + data[0]);
                    System.out.println("Name: " + data[1]);
                    System.out.println("Course: " + data[2]);
                    System.out.println("Year: " + data[3]);

                    found = true;
                    break;
                }
            }

            br.close();

            if (!found) {
                System.out.println("Student Not Found!");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    // Delete Student
    static void deleteStudent() {

        System.out.print("Enter Roll Number to Delete: ");
        int deleteRoll = sc.nextInt();

        boolean found = false;

        try {

            File inputFile = new File(fileName);
            File tempFile = new File("temp.txt");

            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));

            String line;

            while ((line = br.readLine()) != null) {

                String data[] = line.split(",");

                if (Integer.parseInt(data[0]) != deleteRoll) {
                    bw.write(line);
                    bw.newLine();
                } else {
                    found = true;
                }
            }

            br.close();
            bw.close();

            inputFile.delete();
            tempFile.renameTo(inputFile);

            if (found) {
                System.out.println("Student Deleted Successfully!");
            } else {
                System.out.println("Student Not Found!");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
