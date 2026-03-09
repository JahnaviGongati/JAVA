import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class StudentSwingCRUD extends JFrame implements ActionListener {

    JLabel l1, l2, l3;
    JTextField t1, t2, t3;
    JButton b1, b2, b3, b4;

    Connection con;

    StudentSwingCRUD() {

        setTitle("Student CRUD - Oracle");
        setLayout(null);

        l1 = new JLabel("SID");
        l1.setBounds(50, 50, 100, 30);
        add(l1);

        t1 = new JTextField();
        t1.setBounds(150, 50, 150, 30);
        add(t1);

        l2 = new JLabel("Name");
        l2.setBounds(50, 100, 100, 30);
        add(l2);

        t2 = new JTextField();
        t2.setBounds(150, 100, 150, 30);
        add(t2);

        l3 = new JLabel("Branch");
        l3.setBounds(50, 150, 100, 30);
        add(l3);

        t3 = new JTextField();
        t3.setBounds(150, 150, 150, 30);
        add(t3);

        b1 = new JButton("Insert");
        b1.setBounds(50, 220, 100, 30);
        add(b1);

        b2 = new JButton("View");
        b2.setBounds(170, 220, 100, 30);
        add(b2);

        b3 = new JButton("Update");
        b3.setBounds(50, 270, 100, 30);
        add(b3);

        b4 = new JButton("Delete");
        b4.setBounds(170, 270, 100, 30);
        add(b4);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        setSize(380, 360);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        connectDB();
    }

    void connectDB() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE",
                    "system",
                    "12345"   // change password
            );

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    public void actionPerformed(ActionEvent e) {

        try {

            if (e.getSource() == b1) { // INSERT

                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO student1 VALUES (?, ?, ?)");

                ps.setInt(1, Integer.parseInt(t1.getText()));
                ps.setString(2, t2.getText());
                ps.setString(3, t3.getText());

                int rows = ps.executeUpdate();
                JOptionPane.showMessageDialog(this, rows + " Record Inserted");
            }

            if (e.getSource() == b2) { // VIEW

                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM student1");

                String data = "SID\tNAME\tBRANCH\n";

                while (rs.next()) {
                    data += rs.getInt("sid") + "\t"
                            + rs.getString("sname") + "\t"
                            + rs.getString("branch") + "\n";
                }

                JTextArea area = new JTextArea(data);
                JOptionPane.showMessageDialog(this, new JScrollPane(area));
            }

            if (e.getSource() == b3) { // UPDATE

                PreparedStatement ps = con.prepareStatement(
                        "UPDATE student1 SET sname=?, branch=? WHERE sid=?");

                ps.setString(1, t2.getText());
                ps.setString(2, t3.getText());
                ps.setInt(3, Integer.parseInt(t1.getText()));

                int rows = ps.executeUpdate();
                JOptionPane.showMessageDialog(this, rows + " Record Updated");
            }

            if (e.getSource() == b4) { // DELETE

                PreparedStatement ps = con.prepareStatement(
                        "DELETE FROM student1 WHERE sid=?");

                ps.setInt(1, Integer.parseInt(t1.getText()));

                int rows = ps.executeUpdate();
                JOptionPane.showMessageDialog(this, rows + " Record Deleted");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    public static void main(String[] args) {
        new StudentSwingCRUD();
    }
}