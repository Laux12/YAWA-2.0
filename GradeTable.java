//imports
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//table para sa grade sa student nga naka extends sa JFrame
public class GradeTable extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel model;
	//constructor nga naay parameter nga id name year program grades nga arraylist og subjects nga arraylist
	public GradeTable(int id,String name,String year,String program,ArrayList<Float> grades,ArrayList<enrolledSubject> subject){
		this.setSize(550,400);	//size sa frame
		this.setLayout(null);
		this.setBackground(Color.decode("#D2E0FB"));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Student Grade");
			
			JLabel grade_name = new JLabel();//label para sa name sa student
			grade_name.setText("Name: " + name);//set ang text
			grade_name.setFont(new Font("Inter",Font.BOLD,15));//set font
			JLabel grade_id = new JLabel();//label para sa id sa student
			grade_id.setText("ID No: " + id);//set ang text 
			grade_id.setFont(new Font("Inter",Font.BOLD,15));//set font
			JLabel grade_course = new JLabel();//label para sa year sa student
			grade_course.setText("Year: " + year);	
			grade_course.setFont(new Font("Inter",Font.BOLD,15));//set ang font
			JLabel grade_period = new JLabel();//label para sa program sa student
			grade_period.setText("Program: " + program);
			grade_period.setFont(new Font("Inter",Font.BOLD,15));
			
			JPanel grade_panel_1 = new JPanel();//para nga sudlanan sa name, id ,program og year
			grade_panel_1.setBounds(0,1,550,60);//set ang location og size
			grade_panel_1.setBackground(Color.decode("#D2E0FB"));
			grade_panel_1.setLayout(new GridLayout(2,2));
			grade_panel_1.setFont(new Font("Inter",Font.BOLD,13));
			
			//add tanan components
			grade_panel_1.add(grade_name);
			grade_panel_1.add(grade_course);
			grade_panel_1.add(grade_id);
			grade_panel_1.add(grade_period);
			
			//panel sudlanan sa mga headers
			JPanel gradePanel = new JPanel();
			gradePanel.setBounds(0,61,545,30);//set ang location og size
			gradePanel.setBackground(Color.decode("#78D6C6"));
			gradePanel.setFont(new Font("Inter",Font.BOLD,12));
			gradePanel.setLayout(new GridLayout(1,2,-1,0));
			
			//mga headers sa table
			JButton subjectLabel = new JButton("Subject Code");
			JButton gradeLabel = new JButton("Final Grade");
			subjectLabel.setBackground(Color.decode("#78D6C6"));
			subjectLabel.setFont(new Font("Inter",Font.BOLD,13));
			subjectLabel.setFocusable(false);
			
			gradeLabel.setBackground(Color.decode("#78D6C6"));
			gradeLabel.setFont(new Font("Inter",Font.BOLD,13));
			gradeLabel.setFocusable(false);
			//add tanan components nga headers
			gradePanel.add(subjectLabel);
			gradePanel.add(gradeLabel);
			
			
			
			String[] tblHeader = {"Section Code", "Final Grade"};//headers sa table kung pila kabouk ang column
			model = new DefaultTableModel(tblHeader,0);//add ang header og kung pila kabouk rows 
			table = new JTable(model);//create ang table 
			table.setRowHeight(25);//height sa row sa table
			table.setFont(new Font("Inter",Font.PLAIN,15));//set ang font
			
			//panel nga container sa table
			JPanel tableContainer = new JPanel();
			tableContainer.setBounds(1,92,545,460);
			tableContainer.setBackground(Color.black);
			tableContainer.setLayout(new GridLayout(1,1));
			
			//add row depende kung pila kabouk sabject ang gi enrollan sa student
			for(int i = 0;i < grades.size();i++) {
				addRow(grades.get(i),subject.get(i).getSubCode());//tawagon ang method nga addrow
			}
			
			tableContainer.add(table);//add ang table sa  panel nga tableCOntainer
			//add tanan components sa frame
			this.add(gradePanel);
			this.add(grade_panel_1);
			this.add(tableContainer);
			this.setVisible(true);
	}
	//method para mag add og row
	public void addRow(float grade,String subjectCode) {
		Object[] studentGrade = {
				subjectCode,grade
		};
		model.addRow(studentGrade);
	}
	
	
}
