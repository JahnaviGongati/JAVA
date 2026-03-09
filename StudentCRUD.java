import java.sql.*;
import java.util.Scanner;

public class StudentCRUD {

    static final String URL =
    "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
static final String USER = "system";
static final String PASSWORD = "1234";
 

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            int choice;

            do {
                System.out.println("\n===== STUDENT MENU =====");
                System.out.println("1. Insert");
                System.out.println("2. View");
                System.out.println("3. Update");
                System.out.println("4. Delete");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();
                sc.nextLine(); // clear buffer

                switch (choice) {

                    case 1: // INSERT
                        System.out.print("Enter SID: ");
                        int sid = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Branch: ");
                        String branch = sc.nextLine();

                        PreparedStatement psInsert = con.prepareStatement(
                                "INSERT INTO student1 VALUES (?, ?, ?)");
                        psInsert.setInt(1, sid);
                        psInsert.setString(2, name);
                        psInsert.setString(3, branch);

                        int inserted = psInsert.executeUpdate();
                        System.out.println(inserted + " record inserted.");
                        break;

                    case 2: // VIEW
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM student1");

                        System.out.println("\nSID\tNAME\tBRANCH");
                        while (rs.next()) {
                            System.out.println(
                                    rs.getInt("sid") + "\t" +
                                    rs.getString("sname") + "\t" +
                                    rs.getString("branch"));
                        }
                        break;

                    case 3: // UPDATE
                        System.out.print("Enter SID to update: ");
                        int usid = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter New Name: ");
                        String newName = sc.nextLine();

                        System.out.print("Enter New Branch: ");
                        String newBranch = sc.nextLine();

                        PreparedStatement psUpdate = con.prepareStatement(
                                "UPDATE student1 SET sname=?, branch=? WHERE sid=?");
                        psUpdate.setString(1, newName);
                        psUpdate.setString(2, newBranch);
                        psUpdate.setInt(3, usid);

                        int updated = psUpdate.executeUpdate();
                        System.out.println(updated + " record updated.");
                        break;

                    case 4: // DELETE
                        System.out.print("Enter SID to delete: ");
                        int dsid = sc.nextInt();

                        PreparedStatement psDelete = con.prepareStatement(
                                "DELETE FROM student1 WHERE sid=?");
                        psDelete.setInt(1, dsid);

                        int deleted = psDelete.executeUpdate();
                        System.out.println(deleted + " record deleted.");
                        break;

                    case 5:
                        System.out.println("Exiting program...");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

            } while (choice != 5);

            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}