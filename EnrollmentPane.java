//imports
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EnrollmentPane{
	//declare ang variable gawas sa constructor para maaccess sya bisan asa sulod sa class
	private JPanel p1;
	private JLabel sCode, sCourse, sDescription, sSchedule, sSection,secCode;
	private JTextField tF1, tF2, tF3, tF4, tF5, tF;
	private Font myFont;
	private String code,descrip,sched,section,sectionCode;
	int units;
	private boolean filled = false;
	//constructor nga naay parameter nga name og id
	public EnrollmentPane(String name,int id){
		
		myFont = new Font("Inter",Font.BOLD,15);
		p1 = new JPanel();
		p1.setLayout(new GridLayout(6,2,10,3));
		
		//label og textfield sa section code sa student
		sCode = new JLabel("Section Code:");
		sCode.setFont(myFont);
		tF1 = new JTextField();
		tF1.setFont(myFont);
		
		//label og textfield sa subject code sa student
		secCode = new JLabel("Subject Code:");
		secCode.setFont(myFont);
		tF = new JTextField();
		tF.setFont(myFont);
		
		//label og textfield sa subject description sa student
		sCourse = new JLabel("Subject Description:");
		sCourse.setFont(myFont);
		tF2 = new JTextField();
		tF2.setFont(myFont);
		
		//label og textfield sa subject units sa student
		sDescription = new JLabel("Subject Units:");
		sDescription.setFont(myFont);
		tF3 = new JTextField();
		tF3.setFont(myFont);
		
		//label og textfield sa schedule sa student
		sSchedule = new JLabel("Subject Schedule:");
		sSchedule.setFont(myFont);
		tF4 = new JTextField();
		tF4.setFont(myFont);
		
		//label og textfield sa section sa student
		sSection = new JLabel("Section:");
		sSection.setFont(myFont);
		tF5 = new JTextField();
		tF5.setFont(myFont);
		
		//add tanan components
		p1.add(sCode);
		p1.add(tF);
		p1.add(secCode);
		p1.add(tF1);
		p1.add(sCourse);
		p1.add(tF2);
		p1.add(sDescription);
		p1.add(tF3);
		p1.add(sSchedule);
		p1.add(tF4);
		p1.add(sSection);
		p1.add(tF5);
	
		
		//show ang optionpane tas eadd ang component nga panel1 or p1
		int result = JOptionPane.showConfirmDialog(null,p1, "Enroll A Student",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
		
		
		try {
		if(result == 0) {//check kung gi ok sa user ang pag enroll
			//0 = ok , 1 = cancel
			//check kung sakto ang input sa user 
			if(!tF.getText().equals("") && !tF1.getText().equals("") && !tF2.getText().equals("") && !tF3.getText().equals("") && !tF4.getText().equals("") && !tF5.getText().equals("")) {
				//get ang text sa textfields tas estore sa mga variables
				sectionCode = tF.getText();
				descrip= tF2.getText();
				sched = tF4.getText();
				section = tF5.getText();
				units = Integer.parseInt(tF3.getText());//convert to integers
				code = tF1.getText();
				setSubjectEnrolled(sectionCode,code,descrip,section,sched,units);//tawagon ang method nga setter para sa subject information
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want you enroll this student to subject?\n" +
				"Name: " + name + "\nID: " + id + "\n\nSection Code: " + 	sectionCode + "\nSubject Code: " + code + 
				"\nDescription: " + descrip + "\nSchedule: " + sched + "\nSection: " + section + "\n", "Confirm Enrollment", JOptionPane.YES_NO_OPTION);
				if(confirm == 0) {//kung giconfirm ang pag enroll sa student
				filled = true;
					}
				}
				else{//kung kulang ang input sa user 
					JOptionPane.showMessageDialog(null, "Please fill in all information","Warning",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		catch(NumberFormatException e) {//kung nag input og dili integer ang user sa Units
			JOptionPane.showMessageDialog(null, "Please enter a correct Value","Warning",JOptionPane.WARNING_MESSAGE);
			
		}
	}
	//setter para maset ang information sa subject nga gienrollan sa student
	public void setSubjectEnrolled(String sectionCode,String code,String descrip,String section,String sched,int units) {
		this.sectionCode = sectionCode;
		this.code = code;
		this.descrip = descrip;
		this.section = section;
		this.sched = sched;
		this.units = units;
	}
	//getters para sa subjects 
	public enrolledSubject getSubject() {
		return new enrolledSubject(sectionCode.toUpperCase(),
				code.toUpperCase(),descrip.toUpperCase(),
				section.toUpperCase(),sched.toUpperCase(),units);
		
	}
	public boolean filled() {//return true kung sakto ang input sa user false kung mali
		return filled;
	}
	
}