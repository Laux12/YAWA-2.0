import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Table{
	int id;
	String name,year,program;
	JTable table;//declare ang table
	DefaultTableModel model;
	ArrayList<Student> studentList = new ArrayList<>();//arraylist sa students 
	public	Table(){//constructor
		String[] tblHeader = {"ID", "Name","Year","Program"};//set ang headers kung pila kabouk
		model = new DefaultTableModel(tblHeader,0);//instanciate ang tablemodel tas epass ang header og kung pila ka rows
		table = new JTable(model);//instaciate ang table tas ipasa ang table model
		table.setRowHeight(25);//set ang height kada row
		table.setFont(new Font("Inter",Font.PLAIN,15));//set ang font sa table
		}
	//methods for adding student nga naa parameter nga student nga object
	public void addStudent(Student student) {
		studentList.add(student);//add ang student sa list
		Object[] studentInfo = {
				student.getID(),student.getName(),student.getProgram(),student.getYear()
		};//temporary array
		model.addRow(studentInfo);//add row tas display tanan information sa student
		
		
	}
	
	//meothods para update nga naay parameter nga id name year og program 
	public void updateStudent(int id, String name,String year,String program) {
		int index = 0;
		for(int i = 0; i < studentList.size(); i++) {//check kung unsa ang index sa student nga eupdate
			if(studentList.get(i).getID() == id) {
				index = i;
			}
		}
		//display ang updated value sa table
		model.setValueAt(name, index, 1);
		model.setValueAt(year, index, 2);
		model.setValueAt(program, index, 3);
		studentList.get(index).setNewInfo(name, year, program);//set ang updated information sa student
		
		
	}
	//method para sa delete nga naay parameter nga id
	public void deleteStudent(int id) {
		int index = 0;
		for(int i = 0; i < studentList.size(); i++) {//check ang index sa student nga edelete
			if(studentList.get(i).getID() == id) {
				index = i;
			}
		}
		model.removeRow(index);//remove ang selected row
		studentList.remove(index);//remove ang student sa arraylist
	}

	
		
	

}
