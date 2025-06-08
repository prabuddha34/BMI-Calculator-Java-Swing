import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frame extends JFrame implements ActionListener {
    JPanel panel;
    JLabel label, ageLabel, genderLabel,heightLabel,weightLabel;
    JTextField nameField, ageField,heightField,weightField;
    JButton submitButton;
    JRadioButton maleButton, femaleButton;
    ButtonGroup genderGroup;

    boolean isSubmitting = false;

    public frame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setTitle("BMI Calculator");

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(50, 50, 600, 600);

        label = new JLabel("What is your name?");
        label.setBounds(50, 10, 200, 25);

        nameField = new JTextField();
        nameField.setBounds(50, 35, 200, 25);

        ageLabel = new JLabel("What is your age?");
        ageLabel.setBounds(50, 70, 200, 25);

        ageField = new JTextField();
        ageField.setBounds(50, 95, 200, 25);

        weightLabel=new JLabel("What is your weight ?");
        weightLabel.setBounds(50,120,200,25);

        weightField=new JTextField();
        weightField.setBounds(50,145,200,25);

        heightLabel=new JLabel("What is your height ?");
        heightLabel.setBounds(50,165,200,25);

        heightField=new JTextField();
        heightField.setBounds(50,185,200,25);



        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(50, 210, 100, 25);

        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        maleButton.setBounds(50, 235, 70, 25);
        femaleButton.setBounds(130, 235, 100, 25);

        genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        submitButton = new JButton("Calculate");
        submitButton.setBounds(100, 315, 150, 25);
        submitButton.addActionListener(this);

        panel.add(label);
        panel.add(nameField);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(weightLabel);
        panel.add(weightField);
        panel.add(heightLabel);
        panel.add(heightField);
        panel.add(submitButton);
        panel.add(genderLabel);
        panel.add(maleButton);
        panel.add(femaleButton);


        this.setLayout(null);
        this.add(panel);
        submitButton.setFocusable(false);
        this.setVisible(true);
    }
    public  static  void main(String []args){
        new frame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     if(e.getSource() == submitButton){
         Double age=Double.parseDouble(ageField.getText());
         Double weight=Double.parseDouble(weightField.getText());
         Double heightInMeters=Double.parseDouble(heightField.getText())/(100);
         Double bmi = weight / (heightInMeters * heightInMeters);
         String bmiCategory;
         if (bmi < 18.5) {
             bmiCategory = "Underweight";
         } else if (bmi < 25) {
             bmiCategory = "Normal weight";
         } else if (bmi < 30) {
             bmiCategory = "Overweight";
         } else {
             bmiCategory = "Obese";
         }
         JOptionPane.showMessageDialog(this,"The BMI of the person is" +" "+bmi+" "+"and the category is "+" "+bmiCategory);
     }

    }
}
