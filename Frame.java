import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
//naka extends sa JFrame og naka implement sa action og listSelection listener
public class Frame extends JFrame implements ActionListener,ListSelectionListener{
	private static final long serialVersionUID = 1L;//;optional
	JTextField studentId,studentName,studentProgram,studentYear;//declare ang textfields
	JPanel panel1,panel2,panel3,panel4;//declare ang panels
	JLabel idLabel,nameLabel,programLabel,yearLabel;//declare ang panels
	JButton idLabel1,nameLabel1,programLabel1,yearLabel1;//declare ang buttons
	Color myColor,myColor1;//declare og color para mas dali na butangan og color 
	Font myFont; //declare og font para mas dali og mas mubo ang code
	JButton[] accessButton = new JButton[7];//declare og array sa buttons
	JButton addButton,updateButton,deleteButton,enrollButton,viewButton,gradeButton,corButton;//declare og nga ngalan sa buttons para sa array nga buttons
	Table table = new Table();//declare ang Table nga class
	ListSelectionModel selectedRow;//para sa mabal an ang value sa columns sa selected nga row
	int studentID = 1000,id;
	String name,year,program;
	public Frame(){//constructor
		myColor = Color.decode("#D2E0FB");// butangan og value ang mycolor
		myColor1 = Color.decode("#176B87");//butangan og value ang mycolor1
		myFont = new Font("Inter",Font.BOLD,15);//butangan og value ang myfont
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//para pag eexit ang frame ma close diritso ang program
		this.setSize(800,600);//size sa frame
		this.setTitle("Student Enrollment System");//title sa frame
		this.setLayout(null);//layout sa frame
		this.setResizable(false);//para dili resize ang frame
		this.setLocationRelativeTo(null);//para macenter sa screen ang frame
		
		panel1 = new JPanel();//instanciate ang panel1
		panel1.setBounds(0,3,785,97);//set ang y og x axis tas set ang width og hieght
		panel1.setLayout(new GridLayout(3,4,-1,3));//set og grid layout 
		panel1.setBackground(myColor);//set og background color
		
		
		idLabel = new JLabel("  ID");//instanciate ang idlabel
		idLabel.setBackground(myColor);//add background color
		idLabel.setForeground(myColor1);//add og color sa text
		idLabel.setFont(myFont);//add og font
		idLabel.setOpaque(true);//para ma set ang color
		
		nameLabel = new JLabel("  Name");//instanciate ang namelabel
		nameLabel.setBackground(myColor);//add background color
		nameLabel.setForeground(myColor1);//add og color sa text
		nameLabel.setFont(myFont);//add og font
		nameLabel.setOpaque(true);//para ma set ang color
		
		programLabel = new JLabel("  Program");
		programLabel.setBackground(myColor);//add background color
		programLabel.setForeground(myColor1);//add og color sa text
		programLabel.setFont(myFont);//add og font
		programLabel.setOpaque(true);//para ma set ang color
		
		yearLabel = new JLabel("  Year");
		yearLabel.setBackground(myColor);//add background color
		yearLabel.setForeground(myColor1);//add og color sa text
		yearLabel.setFont(myFont);//add og font
		yearLabel.setOpaque(true);//para ma set ang color
		
		studentId = new JTextField();
		studentId.setBorder(javax.swing.BorderFactory.createDashedBorder(myColor));
		studentId.setFocusable(false);//add background color
		studentId.setFont(myFont);//add og font
	
		studentName = new JTextField();
		studentName.setBorder(javax.swing.BorderFactory.createBevelBorder(1));
		studentName.setFont(myFont);//add og font
		studentProgram = new JTextField();
		studentProgram.setBorder(javax.swing.BorderFactory.createBevelBorder(1));
		studentProgram.setFont(myFont);//add og font
		studentYear = new JTextField();
		studentYear.setBorder(javax.swing.BorderFactory.createBevelBorder(1));
		studentYear.setFont(myFont);//add og font
		
		idLabel1 = new JButton("ID");
		idLabel1.setBackground(myColor);//add background color
		idLabel1.setForeground(myColor1);//add og color sa text
		idLabel1.setFont(myFont);//add og font
		idLabel1.setFocusable(false);//add background color
		
		nameLabel1 = new JButton("Name");
		nameLabel1.setBackground(myColor);//add background color
		nameLabel1.setForeground(myColor1);//add og color sa text
		nameLabel1.setFont(myFont);//add og font
		nameLabel1.setFocusable(false);//add background color
		
		programLabel1 = new JButton("Program");
		programLabel1.setBackground(myColor);//add background color
		programLabel1.setForeground(myColor1);//add og color sa text
		programLabel1.setFont(myFont);//add og font
		programLabel1.setFocusable(false);//add background color
		
		yearLabel1 = new JButton("Year");
		yearLabel1.setBackground(myColor);//add background color
		yearLabel1.setForeground(myColor1);
		yearLabel1.setFont(myFont);//add og font
		yearLabel1.setFocusable(false);//para walay box ang text sa buttons
		
		//add ang tanan components sa panel1
		panel1.add(idLabel);
		panel1.add(studentId);
		panel1.add(nameLabel);
		panel1.add(studentName);
		panel1.add(programLabel);
		panel1.add(studentProgram);
		panel1.add(yearLabel);
		panel1.add(studentYear);
		panel1.add(idLabel1);
		panel1.add(nameLabel1);
		panel1.add(programLabel1);
		panel1.add(yearLabel1);
		
		panel2 = new JPanel();
		panel2.setBounds(0,490, 800,80);//set ang y og x axis tas set ang width og height
		panel2.setBackground(myColor);//set ang background sa panel2
		panel2.setLayout(null);//null ang layout
		panel2.setBorder(BorderFactory.createEtchedBorder());//design sa buttons
		
		panel3 = new JPanel();//instaciate ang panel3
		panel3.setBounds(43,panel2.getHeight() / 4, 700,35);//set ang y og x axis tas set ang width og height
		panel3.setBackground(Color.decode("#D2E0FB"));
		panel3.setLayout(new GridLayout(1,7,15,0));
		//set ang design sa buttons nga naa sa array 
		for(int i =0; i < accessButton.length; i++) {
			accessButton[i] = new JButton();
			accessButton[i].setBackground(Color.decode("#78D6C6"));
			accessButton[i].setFont(new Font("Inter",Font.BOLD,12));//set ang font
			accessButton[i].setForeground(myColor1);
			accessButton[i].setFocusable(false);//add background color
			accessButton[i].setBorder(BorderFactory.createEtchedBorder());
			accessButton[i].addActionListener(this);
		}
		//pangalanan ang mga buttons nga naa sa array
		//tas eset ang text sa buttons
		accessButton[0].setText("ADD");
		addButton = accessButton[0];
		
		accessButton[1].setText("UPDATE");
		updateButton = accessButton[1];
		
		accessButton[2].setText("DELETE");
		deleteButton = accessButton[2];
		
		accessButton[3].setText("ENROLL");
		enrollButton = accessButton[3];
		
		accessButton[4].setText("ADD GRADE");
		gradeButton = accessButton[4];
		
		accessButton[5].setText("VIEW GRADE");
		viewButton = accessButton[5]; 
		
		accessButton[6].setText("COR");
		corButton = accessButton[6];
		//add tanan buttons nga naa sa array sa panel3
		for(int i =0; i < accessButton.length; i++) {
			panel3.add(accessButton[i]);
		}
		//set up para sa table nga butangan sa name id program og year sa students
		panel4 = new JPanel();
		panel4.setBounds(0,panel1.getHeight() + 2,786,600 - panel1.getHeight() - 112);
		panel4.setLayout(new GridLayout());
		//para mabal an kung unsa ang selected nga row sa table og para makuha ang value
		selectedRow = table.table.getSelectionModel();
		selectedRow.addListSelectionListener(this);//add og listener
		
		//add tanan components
		panel4.add(table.table);
		panel2.add(panel3);
		this.add(panel4);
		this.add(panel2);
		this.add(panel1);
		this.setVisible(true);
		
	}
	//actionlistener nga method override kay na implents ang class sa actionlistener nga interface
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addButton) {//ang addButton nga button ang giclick 
			int checker = 1;
			String studentname = studentName.getText().toUpperCase();//kwaon ang text nga naa sa textfield nga student name tas econvert into uppercase
			//check kung existed na daan ang name sa student nga eadd
			if(table.studentList.size() != 0) {//kung naa nay sulod daan ang table
				for(int i = 0;i < table.studentList.size(); i++) {
					if(table.studentList.get(i).getName().equals(studentname)) {
						
						//kung naa na ang student sa list daan
						JOptionPane.showMessageDialog(null, "Student name already Exist","Message",JOptionPane.ERROR_MESSAGE);
						emptyTheTextField();//walaon tanan text nga naa sa textfields
						checker = 0;//set ang checker to 0 - meaning naa na ang student
					}
					
				
				}
			}
			if(checker != 0) {//kung ang student kay wala pa sa table
				if(!studentName.getText().equals("") && !studentProgram.getText().equals("") && !studentYear.getText().equals("")) {//check kung naa nabay value tanan textfields
					int id = studentID + 1;//kada add og student mo increment
					studentID += 1;
					String name = studentname;
					String year = studentYear.getText().toUpperCase();//get ang text nga naa sa textfields
					String program = studentProgram.getText().toUpperCase();
					
					//add og student sa arraylist tas ipasa ang id name year og program sa student
					table.addStudent(new Student(id,name,year,program));
					emptyTheTextField();
					JOptionPane.showMessageDialog(null, "Student " + id + " Added Successfully","Message",JOptionPane.PLAIN_MESSAGE);
			
				}
				else {//kung kulang ang input sa user
				JOptionPane.showMessageDialog(null, "Please fill in all information","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
		if(e.getSource() == updateButton) {//kung updateButton ang ang gi pindot nga button sa user
			if(id == 0) {
				JOptionPane.showMessageDialog(null, "Please select A Student to Update","Warning",JOptionPane.WARNING_MESSAGE);
			}else {
			if(studentName.getText().equals(name) && studentProgram.getText().equals(program) && studentYear.getText().equals(year)) {//check kung wala bay na bag o sa information sa student
				JOptionPane.showMessageDialog(null, "There is No Changes","Information",JOptionPane.INFORMATION_MESSAGE);
				
				
			}else//kung naay nabag o sa information sa student
			if(!studentName.getText().equals("") && !studentProgram.getText().equals("") && !studentYear.getText().equals("")) {//check kung naa bay value ang textfields
			//kwaon tanan text nga naa sa textfields tas econvert into uppercase
			int id = Integer.parseInt(studentId.getText());//convert ang id into integer
			String name = studentName.getText().toUpperCase();
			String year = studentYear.getText().toUpperCase();
			String program = studentProgram.getText().toUpperCase();
			//eupdate ang information sa student nga naa sa arraylist
			table.updateStudent(id,name,program,year);
			emptyTheTextField();
			JOptionPane.showMessageDialog(null, "Student " + id + " Updated Successfully","Message",JOptionPane.PLAIN_MESSAGE);
			
			
			}
			//kung wala nag select og student ang user
			
			else {//kung naa kulang ang input sa user
				JOptionPane.showMessageDialog(null, "Please fill in all information","Error",JOptionPane.ERROR_MESSAGE);
			}
			}
		}
		if(e.getSource() == deleteButton) {//kung deleteButton ang gi pindot nga button sa user
			if(id != 0) {//check kung na select ang user og student sa table
			int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to DELETE this student? ","Confirm Delete", JOptionPane.YES_NO_OPTION);
			if(confirm == 0) {
			table.deleteStudent(id);//delete or remove ang student sa arraylist og sa table
			emptyTheTextField();
			JOptionPane.showMessageDialog(null, "Student " + id + " Deleted Successfully","Message",JOptionPane.PLAIN_MESSAGE);
			
			
			id = 0;
			}
			//kung wala nakaselect og student ang user sa table
			}else {
				JOptionPane.showMessageDialog(null, "Please Select A Student to Delete","Warning",JOptionPane.WARNING_MESSAGE);
				
			}
		}
		if(e.getSource() == enrollButton) {//kung ang enrollButton ang source sa action nga giperform sa user
			if(id != 0) {
				EnrollmentPane enroll = new EnrollmentPane(name, id);//tawagon pane para sa enrollment
				
				if(enroll.filled()) {//check kung walay kulang sa input sa user 
					int i = 0;
					while(table.studentList.get(i).getID() != id) {//check ang index sa id sa student
						i++;
						
					}
					int index = 0;
					boolean exist = false;
					if(table.studentList.get(i).getSubject().size() != 0) {//check kung wala pa bay sulod ang subject nga arraylist sa student
						//check kung nag exist naba ang subject nga enrollan sa student
					while(index < table.studentList.get(i).getSubject().size()) {
						if(table.studentList.get(i).getSubject().get(index).getSubCode().toUpperCase().equals(enroll.getSubject().getSubCode())) {
							exist = true;
							break;
						}
						else {
							index++;
							}
						}	
					}
					if(!exist) {//kung wala pa nag exist ang subject nga enrollan sa student
					//eadd ang subject nga enrollan sa student sa arraylist
					table.studentList.get(i).addSubject(enroll.getSubject());
					table.studentList.get(i).addGrade(0);//add og temporary grade nga 0
					table.studentList.get(i).setEnrolled(true);
					
					JOptionPane.showMessageDialog(null, "Student " + id + " Enrolled to subject Succesfully","Success",JOptionPane.PLAIN_MESSAGE);
					//kung nag exist na ang subject
					}else {
						JOptionPane.showMessageDialog(null, "Student Already Enrolled to this subject","Warning",JOptionPane.ERROR_MESSAGE);
						
					}
				}
			}else {//kung wala nag select og student ang user
				JOptionPane.showMessageDialog(null, "Please Select A Student to Enroll","Warning",JOptionPane.WARNING_MESSAGE);
			}
		}
		if(e.getSource() == gradeButton) {//kung ang gradeButton nga button ang source sa action nga giperform sa user
				
			if(id != 0) {//check kung wala pa nag select og student ang user sa table
				int i = 0;
				while(table.studentList.get(i).getID() != id) {//check ang index sa id sa student
					i++;
				}
				//check if enrolled naba ang student
				if(table.studentList.get(i).getEnrolled()) {//kung wala pa na enroll ang student
					GradingPane grading = new GradingPane(id,name);//tawagon ang pane sa grading 
						if(grading.getFilled()) {//kung sakto ang gi input sa user sa pag enroll
							int index = 0;
							boolean exist = false;
							//check if naa ang subject nga gradohan
							while(index <= table.studentList.get(i).getSubject().size() - 1) {
								if(table.studentList.get(i).getSubject().get(index).getSubCode().equals(grading.getSubjectCode())) {
									exist = true;
									break;
								}
								else {
								index++;
								}
								
							}
							if(exist) {//kung nag exist ang subject nga gradohan
							table.studentList.get(i).setGrade(index, grading.getGrade());//set ang grade sa subject 
							JOptionPane.showMessageDialog(null, "Student " + id + " Graded Succesfully","Success",JOptionPane.PLAIN_MESSAGE);
							}
							
							else {//kung wala nag exist ang subject
								JOptionPane.showMessageDialog(null, "Subject not Found","Warning",JOptionPane.WARNING_MESSAGE);
								
							}
						}
				}else {//kung wala pa na enroll ang student
					JOptionPane.showMessageDialog(null, "Student not Enrolled yet","Warning",JOptionPane.WARNING_MESSAGE);
				}
			}
			else {//kung wala nag select ang user og student sa table
				JOptionPane.showMessageDialog(null, "Please Select A Student to Grade","Warning",JOptionPane.WARNING_MESSAGE);
				
			}
		}
		if(e.getSource() == viewButton) {//kung ang viewButton ang gipindot sa user
			if(id != 0) {//check kung wala nag select ang user og student sa table
				int i = 0;
				while(table.studentList.get(i).getID() != id) {//check ang index sa id sa student
					i++;
					}
				//check kung enrolled naba ang student 
				if(table.studentList.get(i).getEnrolled()) {//false kung wala true kung enrolled
					//tawagon ang table sa grades
				new GradeTable(id,name,year,program,table.studentList.get(i).getGrades(),table.studentList.get(i).getSubject());
				}else {//kung wala pa na enrolled ang student
					JOptionPane.showMessageDialog(null, "Student not Enrolled yet","Warning",JOptionPane.WARNING_MESSAGE);
					
				}
			}else {//kung wala nag select ang user og student sa table
				JOptionPane.showMessageDialog(null, "Please Select A Student","Warning",JOptionPane.WARNING_MESSAGE);
				
			}
		}
		if(e.getSource() == corButton) {//kung ang corButton ang source sa action nga giperformed sa user
			if(id != 0) {//check kung nag select ang user og student sa table
			CORFrame corFrame = new CORFrame(id,name, year,program);//tawagon ang frame sa cor
			int i = 0;
			while(table.studentList.get(i).getID() != id) {//check ang index sa id sa selected student
				i++;
				
			}
			corFrame.addSubjectList(table.studentList.get(i).getSubject());//eadd ang subject nga gienrollan sa student
			corFrame.displayList();//display ang table 
		
			}else {//kung wala nag select og student ang user 
				JOptionPane.showMessageDialog(null, "Please Select A Student","Warning",JOptionPane.WARNING_MESSAGE);
				
			}
		}
		
		}
	public void valueChanged(ListSelectionEvent e) {//para makuha ang value sa giselect nga user sa user
		if(!selectedRow.isSelectionEmpty()) {//check kung dili empty ang rows
			//store ang information sa selected rows sa id name program og year nga variables
			//cast ang id as integer
			id = (int) table.table.getValueAt(selectedRow.getMinSelectionIndex(), 0);
			//cast ang name as strings
			name = (String) table.table.getValueAt(selectedRow.getMinSelectionIndex(), 1);
			program = (String) table.table.getValueAt(selectedRow.getMinSelectionIndex(), 2);
			year = (String) table.table.getValueAt(selectedRow.getMinSelectionIndex(), 3);
			
			//set ang textfield depende kung unsa nga information ang naa sa row
			studentId.setText(String.valueOf(id));
			studentName.setText(name);
			studentYear.setText(year);
			studentProgram.setText(program);
		}
	}
	public void emptyTheTextField() {//method para ma empty ang textfields
		studentId.setText("");
		studentName.setText("");
		studentYear.setText("");
		studentProgram.setText("");
	}
}
