import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class StudentRegistration extends JFrame implements ActionListener {

    // Declare components
    JTextField txtName, txtRoll;
    JRadioButton rbMale, rbFemale;
    JComboBox<String> cbCourse;
    JCheckBox cbSports, cbMusic, cbReading;
    JTextArea taAddress;
    JButton btnSubmit;

    StudentRegistration() {

        // Frame settings
        setTitle("Student Registration Form");
        setSize(400, 450);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Labels and TextFields
        add(new JLabel("Student Name:"));
        txtName = new JTextField(20);
        add(txtName);

        add(new JLabel("Roll Number:"));
        txtRoll = new JTextField(20);
        add(txtRoll);

        // Gender Radio Buttons
        add(new JLabel("Gender:"));
        rbMale = new JRadioButton("Male");
        rbFemale = new JRadioButton("Female");

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbMale);
        bg.add(rbFemale);

        add(rbMale);
        add(rbFemale);

        // Course ComboBox
        add(new JLabel("Course:"));
        String courses[] = {"BCA", "BSc", "MCA", "MSc"};
        cbCourse = new JComboBox<>(courses);
        add(cbCourse);

        // Hobbies CheckBoxes
        add(new JLabel("Hobbies:"));
        cbSports = new JCheckBox("Sports");
        cbMusic = new JCheckBox("Music");
        cbReading = new JCheckBox("Reading");

        add(cbSports);
        add(cbMusic);
        add(cbReading);

        // Address TextArea
        add(new JLabel("Address:"));
        taAddress = new JTextArea(4, 20);
        add(new JScrollPane(taAddress));

        // Submit Button
        btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(this);
        add(btnSubmit);

        setVisible(true);
    }

    // Event Handling
    public void actionPerformed(ActionEvent e) {

        String name = txtName.getText();
        String roll = txtRoll.getText();
        String gender = rbMale.isSelected() ? "Male" : "Female";
        String course = cbCourse.getSelectedItem().toString();

        String hobbies = "";
        if (cbSports.isSelected()) hobbies += "Sports ";
        if (cbMusic.isSelected()) hobbies += "Music ";
        if (cbReading.isSelected()) hobbies += "Reading ";

        String address = taAddress.getText();

        JOptionPane.showMessageDialog(this,
                "Name: " + name +
                "\nRoll No: " + roll +
                "\nGender: " + gender +
                "\nCourse: " + course +
                "\nHobbies: " + hobbies +
                "\nAddress: " + address,
                "Student Details",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new StudentRegistration();
    }
}