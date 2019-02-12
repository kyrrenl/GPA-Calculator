import java.awt.*;
import javax.swing.*;
import java.util.Timer;
import java.util.*;
import java.awt.event.*;//package for clicking a button
import java.io.*;
import javax.swing.filechooser.*;
import java.text.DateFormat;
import java.text.*;
import javax.swing.JComboBox;

public class GPACalculator extends JFrame implements ActionListener {
   
//First GUI
   private JFrame jf1 = new JFrame();
   private JPanel jpNorth = new JPanel();
   private JPanel jpSouth = new JPanel();
   private JPanel jpCenter = new JPanel();
   private JButton jbSave = new JButton("Save");
   private JButton jbStart = new JButton("Start");
   private JTextArea jtaData = new JTextArea(20,20);
   private JLabel jlGpa = new JLabel("GPA: ");
   private JTextField jtfGpa = new JTextField(5);
   //Buttons
   private JButton jbstart;
   private JButton jbsave;
   
//Second Gui
   private JFrame jf2 = new JFrame();
   private JPanel jpNorth2 = new JPanel();
   private JPanel jpSouth2 = new JPanel();
  
   private JLabel jlClasses = new JLabel("How many classes have you taken? ");
   String[] classArray = new String[] {"3","4","5","6"};
   private JComboBox jcbClasses = new JComboBox(classArray);
   
   private int classBox = 0;
   //Buttons
   private JButton jbSelect = new JButton("Select");
   private JButton jbExit = new JButton("Exit");
   private JButton jbCalc = new JButton("Calculate");
   
   //GPABoxes
   private JLabel jl1 = new JLabel("Class 1 : "); private JLabel jlcred1 = new JLabel("Credits: "); private JLabel jlgrade1 = new JLabel("Grade: ");
   
   private JLabel jlcred2 = new JLabel("Credits: ");private JLabel jlgrade2 = new JLabel("Grade: ");
   
   private JLabel jlcred3 = new JLabel("Credits: "); private JLabel jlgrade3 = new JLabel("Grade: ");
   
   private JLabel jlcred4 = new JLabel("Credits: "); private JLabel jlgrade4 = new JLabel("Grade: ");
   
   private JLabel jlcred5 = new JLabel("Credits: "); private JLabel jlgrade5 = new JLabel("Grade: ");
   
   private JLabel jlcred6 = new JLabel("Credits: "); private JLabel jlgrade6 = new JLabel("Grade: ");
   
   private JTextField jtfcred1 = new JTextField(3); private JTextField jtfgrade1 = new JTextField(3);
   
   private JLabel jl2 = new JLabel("Class 2 : "); private JTextField jtfcred2 = new JTextField(3); private JTextField jtfgrade2 = new JTextField(3);
   
   private JLabel jl3 = new JLabel("Class 3 : "); private JTextField jtfcred3 = new JTextField(3); private JTextField jtfgrade3 = new JTextField(3);
   
   private JLabel jl4 = new JLabel("Class 4 : "); private JTextField jtfcred4 = new JTextField(3); private JTextField jtfgrade4 = new JTextField(3);
   
   private JLabel jl5 = new JLabel("Class 5 : "); private JTextField jtfcred5 = new JTextField(3); private JTextField jtfgrade5 = new JTextField(3);
   
   private JLabel jl6 = new JLabel("Class 6 : "); private JTextField jtfcred6 = new JTextField(3); private JTextField jtfgrade6 = new JTextField(3);
   
   //Calculations variables
   private double cHours;
   private double totPts;
   private double totalCredits;
   private double totPtsClass;
   private double classnum;
   private double gpa;
   private String grade = "";
   private double credit; private double credit1; private double credit2; private double credit3; private double credit4; private double credit5; private double credit6;
   
   private double gradeValue=0;
   private double gradeValue1=0; private double gradeValue2=0; private double gradeValue3=0; private double gradeValue4=0; private double gradeValue5=0; private double gradeValue6=0;
   
   private String gradeLett1; private String gradeLett2; private String gradeLett3; private String gradeLett4; private String gradeLett5; private String gradeLett6;

   
   public static void main(String[] args){
      new GPACalculator();
   }
   public GPACalculator(){
     setUpWindow();     
     Scanner in  = new Scanner (System.in);
     cHours = in.nextDouble();
     JLabel jlmessage = new JLabel("You can increase classes but not decrease!!!!");
     jpCenter.add(jlmessage);
     jf2.add(jpNorth,BorderLayout.NORTH);
   }

   public void actionPerformed(ActionEvent ae){
      switch(ae.getActionCommand()){  
         case("Start"):
            StartGui();
            jf1.setVisible(false);
            break;
         case("Save"):
            saveGpa();
            break;
         case("Exit"):
            System.exit(0);
         case("Select"):
            String classb = (String)jcbClasses.getSelectedItem();
            classBox = Integer.parseInt(classb);
            SelectGui(classBox);
            break;
         case("Calculate"):
            startCalc();
            break;
      }//switch
   }//action
   
   public void saveGpa(){
      JLabel tCredits = new JLabel("Total Credits: ");
      JTextField jtftCredits= new JTextField(5);
      JLabel cummGpa = new JLabel("Cummulative GPA: ");
      JTextField jtftcummGpa= new JTextField(5);
      
      double currGpa = Double.parseDouble(jtfGpa.getText());
      jtftcummGpa.setText(""+currGpa);
      jpSouth2.add(tCredits);
      jpSouth2.add(jtftCredits);
      jpSouth2.add(cummGpa);
      jpSouth2.add(jtftcummGpa);
      jf2.add(jpSouth2);
      jf2.add(jpSouth2,BorderLayout.SOUTH);
   }
   
   public void StartGui(){
      jbSelect.addActionListener(this);
      jbSave.addActionListener(this);
      jbCalc.addActionListener(this);
      jbCalc.setEnabled(false);
      jbExit.addActionListener(this);
      jf2.setTitle("Select your Classes");//sets title bar
      jf2.setSize(645,400);//window size
      jf2.setLocation(300,200);//screen location
      jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close program when window is closed
      jf2.setVisible(true); 
      jpCenter.add(jlClasses);
      jpCenter.add(jcbClasses); 
      jpNorth2.add(jbSelect);
      jpNorth2.add(jbCalc);
      jpNorth2.add(jbExit);
      jpSouth2.add(jbSave);
      jf2.add(jpNorth2,BorderLayout.NORTH);   
      jf2.add(jpCenter,BorderLayout.CENTER);
      jf2.add(jpSouth2,BorderLayout.SOUTH);
   }
   
   public void startCalc(){ // do the calculations gathered from the text fields
      switch(classBox){
         case(3):
            credit1 = Double.parseDouble(jtfcred1.getText());
            credit2 = Double.parseDouble(jtfcred2.getText());
            credit3 = Double.parseDouble(jtfcred3.getText());
            gradeLett1 = jtfgrade1.getText();gradeValue1 = gradeVal(gradeLett1);gradeLett2 = jtfgrade2.getText();gradeValue2 = gradeVal(gradeLett2);gradeLett3 = jtfgrade3.getText();gradeValue3 = gradeVal(gradeLett3);
            
            totPts = (gradeValue1 * credit1)+(gradeValue2 * credit2)+(gradeValue3 * credit3);
            gradeValue = gradeValue1+gradeValue2+gradeValue3;
            totalCredits = credit1+credit2+credit3;
            gpa=totPts/totalCredits;
            jtfGpa.setText(String.format("%.2f",gpa));
            break;
         case(4):
            credit1 = Double.parseDouble(jtfcred1.getText());credit2 = Double.parseDouble(jtfcred2.getText());
            credit3 = Double.parseDouble(jtfcred3.getText());credit4 = Double.parseDouble(jtfcred4.getText());
            gradeLett1 = jtfgrade1.getText();gradeValue1 = gradeVal(gradeLett1);gradeLett2 = jtfgrade2.getText();gradeValue2 = gradeVal(gradeLett2);
            gradeLett3 = jtfgrade3.getText();gradeValue3 = gradeVal(gradeLett3);gradeLett4 = jtfgrade4.getText();gradeValue4 = gradeVal(gradeLett4);
            
            totPts = (gradeValue1 * credit1)+(gradeValue2 * credit2)+(gradeValue3 * credit3)+(gradeValue4 * credit4);
            gradeValue = gradeValue1+gradeValue2+gradeValue3+gradeValue4;
            totalCredits = credit1+credit2+credit3+credit4;
            gpa=totPts/totalCredits;
            jtfGpa.setText(String.format("%.2f",gpa));
            break;
         case(5):
            credit1 = Double.parseDouble(jtfcred1.getText());credit2 = Double.parseDouble(jtfcred2.getText());credit3 = Double.parseDouble(jtfcred3.getText());
            credit4 = Double.parseDouble(jtfcred4.getText());credit5 = Double.parseDouble(jtfcred5.getText());
            gradeLett1 = jtfgrade1.getText();gradeValue1 = gradeVal(gradeLett1);
            gradeLett2 = jtfgrade2.getText(); gradeValue2 = gradeVal(gradeLett2);
            gradeLett3 = jtfgrade3.getText();gradeValue3 = gradeVal(gradeLett3);
            gradeLett4 = jtfgrade4.getText();gradeValue4 = gradeVal(gradeLett4);
            gradeLett5 = jtfgrade5.getText();gradeValue5 = gradeVal(gradeLett5);
            
            totPts = (gradeValue1 * credit1)+(gradeValue2 * credit2)+(gradeValue3 * credit3)+(gradeValue4 * credit4)+(gradeValue5 * credit5);
            gradeValue = gradeValue1+gradeValue2+gradeValue3+gradeValue4+gradeValue5;
            totalCredits = credit1+credit2+credit3+credit4+credit5;
            gpa=totPts/totalCredits;
            jtfGpa.setText(String.format("%.2f",gpa));
            break;
         case(6): 
            credit1 = Double.parseDouble(jtfcred1.getText());credit2 = Double.parseDouble(jtfcred2.getText());credit3 = Double.parseDouble(jtfcred3.getText());
            credit4 = Double.parseDouble(jtfcred4.getText());credit5 = Double.parseDouble(jtfcred5.getText());credit6 = Double.parseDouble(jtfcred6.getText());
            gradeLett1 = jtfgrade1.getText();gradeValue1 = gradeVal(gradeLett1);
            gradeLett2 = jtfgrade2.getText();gradeValue2 = gradeVal(gradeLett2);
            gradeLett3 = jtfgrade3.getText();gradeValue3 = gradeVal(gradeLett3);
            gradeLett4 = jtfgrade4.getText();gradeValue4 = gradeVal(gradeLett4);
            gradeLett5 = jtfgrade5.getText();gradeValue5 = gradeVal(gradeLett5);
            gradeLett6 = jtfgrade6.getText();gradeValue6 = gradeVal(gradeLett6);
            
            totPts = (gradeValue1 * credit1)+(gradeValue2 * credit2)+(gradeValue3 * credit3)+(gradeValue4 * credit4)+(gradeValue5 * credit5)+(gradeValue6 * credit6);
            gradeValue = gradeValue1+gradeValue2+gradeValue3+gradeValue4+gradeValue5+gradeValue6;
            totalCredits = credit1+credit2+credit3+credit4+credit5+credit6;
            gpa=totPts/totalCredits;
            jtfGpa.setText(String.format("%.2f",gpa));
            break;
      }
   }
   
   public double gradeVal(String grade){
      if (grade.equals ("A"))
            gradeValue= 4.00;
         else if (grade.equals("A-"))
            gradeValue= 3.67;
         else if (grade.equals("B+"))
            gradeValue = 3.33;
         else if (grade.equals("B"))
            gradeValue = 3.00;
         else if (grade.equals ("B-"))
            gradeValue = 2.67;
         else if (grade.equals("C+"))
            gradeValue = 2.33;
         else if (grade.equals("C"))
            gradeValue = 2.00;
         else if (grade.equals ("D+"))
            gradeValue = 1.33;
         else if (grade.equals ("D"))
            gradeValue = 1.00;
         else if (grade.equals ("F"))
            gradeValue = 0;
         else
            System.out.println ("Invalid Grade");
         return gradeValue;
      }
      
   public void SelectGui(int classnumber){ //figure out how many classes the user has and grade
      jbCalc.setEnabled(true);
      jpSouth.add(jlGpa);
      jpSouth.add(jtfGpa);
      jf2.add(jpSouth,BorderLayout.SOUTH);
      switch(classnumber){  
         case(3):
            setLayout(new GridLayout(3,0));
            jf2.setSize(275,400);//window size
            //if other pannels are set, remove them
            jf2.remove(jl1);jf2.remove(jtfcred1);jf2.remove(jtfgrade1);jf2.remove(jl2);jf2.remove(jtfcred2);jf2.remove(jtfgrade2);jf2.remove(jl3);jf2.remove(jtfcred3); jf2.remove(jtfgrade3);
            jf2.remove(jl4);jf2.remove(jtfcred4);jf2.remove(jtfgrade4);jf2.remove(jl5);jf2.remove(jtfcred5);jf2.remove(jtfgrade5);jf2.remove(jl6);jf2.remove(jtfcred6); jf2.remove(jtfgrade6);jf2.revalidate();
            //Add 3 pannels to the GUI
            jpCenter.add(jl1);jpCenter.add(jlcred1);jpCenter.add(jtfcred1);jpCenter.add(jlgrade1);jpCenter.add(jtfgrade1);
            jpCenter.add(jl2);jpCenter.add(jlcred2);jpCenter.add(jtfcred2);jpCenter.add(jlgrade2);jpCenter.add(jtfgrade2);
            jpCenter.add(jl3);jpCenter.add(jlcred3);jpCenter.add(jtfcred3);jpCenter.add(jlgrade3);jpCenter.add(jtfgrade3);
            jf2.add(jpCenter,BorderLayout.CENTER);
            break;
            
         case(4):
            jf2.setSize(275,400);//window size
            setLayout(new GridLayout(0,2));
            //if other pannels are set, remove them
            jf2.remove(jl1);jf2.remove(jtfcred1);jf2.remove(jtfgrade1);jf2.remove(jl2);jf2.remove(jtfcred2);jf2.remove(jtfgrade2);jf2.remove(jl3);jf2.remove(jtfcred3); jf2.remove(jtfgrade3);
            jf2.remove(jl4);jf2.remove(jtfcred4);jf2.remove(jtfgrade4);jf2.remove(jl5);jf2.remove(jtfcred5);jf2.remove(jtfgrade5);jf2.remove(jl6);jf2.remove(jtfcred6); jf2.remove(jtfgrade6);jf2.revalidate();;
            //Add 4 pannels to the GUI
            jpCenter.add(jl1);jpCenter.add(jlcred1);jpCenter.add(jtfcred1);jpCenter.add(jlgrade1);jpCenter.add(jtfgrade1);
            jpCenter.add(jl2);jpCenter.add(jlcred2);jpCenter.add(jtfcred2);jpCenter.add(jlgrade2);jpCenter.add(jtfgrade2);
            jpCenter.add(jl3);jpCenter.add(jlcred3);jpCenter.add(jtfcred3);jpCenter.add(jlgrade3);jpCenter.add(jtfgrade3);
            jpCenter.add(jl4);jpCenter.add(jlcred4);jpCenter.add(jtfcred4);jpCenter.add(jlgrade4);jpCenter.add(jtfgrade4);
            jf2.add(jpCenter,BorderLayout.CENTER);
            break;
            
         case(5):
            jf2.setSize(275,400);//window size
            setLayout(new GridLayout(0,2));
            //if other pannels are set, remove them
            jf2.remove(jl1);jf2.remove(jtfcred1);jf2.remove(jtfgrade1);jf2.remove(jl2);jf2.remove(jtfcred2);jf2.remove(jtfgrade2);jf2.remove(jl3);jf2.remove(jtfcred3); jf2.remove(jtfgrade3);
            jf2.remove(jl4);jf2.remove(jtfcred4);jf2.remove(jtfgrade4);jf2.remove(jl5);jf2.remove(jtfcred5);jf2.remove(jtfgrade5);jf2.remove(jl6);jf2.remove(jtfcred6); jf2.remove(jtfgrade6);jf2.revalidate();
            //Add 5 pannels to the GUI
            jpCenter.add(jl1);jpCenter.add(jlcred1);jpCenter.add(jtfcred1);jpCenter.add(jlgrade1);jpCenter.add(jtfgrade1);
            jpCenter.add(jl2);jpCenter.add(jlcred2);jpCenter.add(jtfcred2);jpCenter.add(jlgrade2);jpCenter.add(jtfgrade2);
            jpCenter.add(jl3);jpCenter.add(jlcred3);jpCenter.add(jtfcred3);jpCenter.add(jlgrade3);jpCenter.add(jtfgrade3); 
            jpCenter.add(jl4); jpCenter.add(jlcred4);jpCenter.add(jtfcred4);jpCenter.add(jlgrade4);jpCenter.add(jtfgrade4);
            jpCenter.add(jl5);jpCenter.add(jlcred5);jpCenter.add(jtfcred5);jpCenter.add(jlgrade5);jpCenter.add(jtfgrade5);
            jf2.add(jpCenter,BorderLayout.CENTER);
            break;
            
         case(6):
            jf2.setSize(275,400);//window size
            setLayout(new GridLayout(0,2));
            //if other pannels are set, remove them
            jf2.remove(jl1);jf2.remove(jtfcred1);jf2.remove(jtfgrade1);jf2.remove(jl2);jf2.remove(jtfcred2);jf2.remove(jtfgrade2);jf2.remove(jl3);jf2.remove(jtfcred3); jf2.remove(jtfgrade3);
            jf2.remove(jl4);jf2.remove(jtfcred4);jf2.remove(jtfgrade4);jf2.remove(jl5);jf2.remove(jtfcred5);jf2.remove(jtfgrade5);jf2.remove(jl6);jf2.remove(jtfcred6); jf2.remove(jtfgrade6);jf2.revalidate();     
            //Add 6 pannels to the GUI
            jpCenter.add(jl1);jpCenter.add(jlcred1);jpCenter.add(jtfcred1);jpCenter.add(jlgrade1);jpCenter.add(jtfgrade1);
            jpCenter.add(jl2);jpCenter.add(jlcred2);jpCenter.add(jtfcred2);jpCenter.add(jlgrade2);jpCenter.add(jtfgrade2);
            jpCenter.add(jl3);jpCenter.add(jlcred3);jpCenter.add(jtfcred3);jpCenter.add(jlgrade3);jpCenter.add(jtfgrade3);
            jpCenter.add(jl4);jpCenter.add(jlcred4);jpCenter.add(jtfcred4);jpCenter.add(jlgrade4);jpCenter.add(jtfgrade4);
            jpCenter.add(jl5);jpCenter.add(jlcred5);jpCenter.add(jtfcred5);jpCenter.add(jlgrade5);jpCenter.add(jtfgrade5);
            jpCenter.add(jl6);jpCenter.add(jlcred6);jpCenter.add(jtfcred6);jpCenter.add(jlgrade6);jpCenter.add(jtfgrade6);
            jf2.add(jpCenter,BorderLayout.CENTER);
            break;
      }//switch
   }
   
   public void setUpWindow(){
      jf1.setTitle("GPA");//sets title bar
      jf1.setSize(415,450);//window size
      jf1.setLocation(300,200);//screen location
      jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close program when window is closed
      jf1.setVisible(true);
      jbstart=new JButton("Start");
      jbsave=new JButton("Save");
      jbstart.addActionListener(this);
      jbsave.addActionListener(this);
      jpNorth.add(jbstart);
      //jpNorth.add(jbsave);    
      jf1.add(jpNorth,BorderLayout.NORTH);
      jf1.add(jpCenter,BorderLayout.CENTER);
   }//setUpWindow
}