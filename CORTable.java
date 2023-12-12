//imports
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CORTable {
	//declare objects gawas sa constructors para maaccess sya bisan asa sulod sa class
	JTable table;
	private DefaultTableModel model;
	//constructor 
	public CORTable(){
		//header sa cor table
		String[] tblHeader = {"Section Code", "Subject Code","Description","Units","Schedule","Section"};
		model = new DefaultTableModel(tblHeader,0);//create og table model tas add ang array nga tblHeader as headers tas 0 
		table = new JTable(model);//create og table tas epasa ang model nga table model
		table.setRowHeight(25);//set ang height sa row
		table.setFont(new Font("Inter",Font.PLAIN,15));//set ang font
	}
	//method para maka add og row nga naay parameter nga enrolledsubject
	public void addRow(enrolledSubject subject) {
		//create ang information sa subjects as array
		Object[] subjectInfo = {
				subject.getSecCode(),subject.getSubCode(),subject.getSubDescrip(),subject.getUnits(),subject.getSubSched(),subject.getSubSection()
		};
		model.addRow(subjectInfo);//tawagon method sa table model nga addRow
	}
}
