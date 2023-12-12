import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GradingPane{
	//declare variables
	private	JTextField sCode;
	private JTextField sGrade;
	private Font myFont;
	private boolean filled = false;
	private float grade;
	private String subCode;
	
	public GradingPane(int id, String name){//constructor
			//set tanan design sa pane
		 	myFont = new Font("Inter",Font.BOLD,14);//declare og font
		    sCode = new JTextField();//textfield para sa subject code
		    sCode.setFont(myFont);//set ang font 
	        sGrade = new JTextField();//textfield para sa grades
	        sGrade.setFont(myFont);//set font sa textfield
	        JLabel sCodeLabel = new JLabel("Subject Code: ");//declare og label para sa subject code
	        sCodeLabel.setFont(myFont);//set ang font
	        
	        
	        JLabel sGradeLabel = new JLabel("Grade: ");//label para sa grade
	        sGradeLabel.setFont(myFont);//set ang font
	        
	        JPanel panel = new JPanel(new GridLayout(2,2,5,5));//panel sudlanan sa labels og textfield
	        //add ang textfield og labels sa panel
	        panel.add(sCodeLabel);
	        panel.add(sCode);
	        panel.add(sGradeLabel);
	        panel.add(sGrade);
	        //buhat og Optionpaane para sa grade sa student
	        int result = JOptionPane.showConfirmDialog(
	           null,//parent components set to null
	           panel,//component set to panel
	           "Enroll Student in Subject",
	           JOptionPane.OK_CANCEL_OPTION,
	           JOptionPane.PLAIN_MESSAGE
	        );
	        //0 = ok , 1 = cancel
	        if (result == 0) {//kung gi ok sa user
	        	//try and catch para sa error nga numberexception nga error
	        	try {
	        		if(!sCode.getText().equals("")) {//check if walay kulang sa gi input sa user 
	        		subCode = sCode.getText().toUpperCase();
	        		grade = Float.parseFloat(sGrade.getText());
	        		int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to grade this student?\n" + 
	        		"Name: " + name + "\nID: " + id,"Confirm Grading",JOptionPane.YES_NO_OPTION);
	        		if(confirm == 0) {//kung gi confirm sa user ang pag grade
	        			filled = true;
	        			}
	        		}
	        	}
	        	catch(NumberFormatException e) {//catch niya ang error nga NUmberFormatException - meaning nag type ang user og dili integer sa textfield nga grade
	        		JOptionPane.showMessageDialog(null, "Please enter the correct Value","Error",JOptionPane.ERROR_MESSAGE);
	        	}
	        	
	        	
	        	
	        }
	    }
	//getter para sa subject code nga gi input sa user
	 public String getSubjectCode() {
		 return subCode;
	 }
	 //getter para sa grade nga gi input sa user
	 public float getGrade() {
		 return grade;
	 }
	 //getter sa filled kung sakto ang input sa user return syag true pero kung dili return syag false
	 public boolean getFilled() {
		 return filled;
	 }
}