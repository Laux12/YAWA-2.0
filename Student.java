import java.util.ArrayList;

public class Student {
	
	//declare ang variables nga butangan sa information sa student
	private String name;
	private String program;
	private String year;
	private int id;
	private ArrayList<enrolledSubject> subjects = new ArrayList<>();//arraylist sa gienrollan sa student
	private ArrayList<Float> grades = new ArrayList<>();//arraylist sa grades sa gienrollan nga subject sa student
	private boolean enrolled = false;
	public Student(int id,String name, String year, String program){//constructor
		this.id = id;
		this.name = name;
		this.program = program;
		this.year = year;
	}
	//getters sa information sa student
	public int getID() {
		return id;
	}
	public String getName() {
		return name;
		
	}
	public String getProgram() {
		return program;
		
	}
	public String getYear() {
		return year;
		
	}
	//setters kung gusto mag update ang user sa information sa student
	public void setNewInfo(String name,String year,String program) {
		this.name = name;
		this.year = year;
		this.program = program;
	}
	
	
	//para mag add og subject nga gienrollan sa student nga naay parameter nga enrolledSubject nga object
	public void addSubject(enrolledSubject subject) {
		subjects.add(subject);
	}
	//getter sa enrolled subject sa student
	public ArrayList<enrolledSubject> getSubject() {
		return subjects;
		
	}
	// for adding grades sa list nga naa parameter nga float grade
	public void addGrade(float grade) {
		grades.add((float) grade);
	}
	//setter sa grades
	public void setGrade(int index,float grade) {
		grades.set(index, grade);
	}
	//getter sa grades
	public ArrayList<Float> getGrades(){
		return grades;
	}
	//setter kung na enroll na ang student
	public void setEnrolled(boolean enroll) {
		this.enrolled = enroll;
	}
	//getter kung na enroll na ang student
	public boolean getEnrolled() {
		return enrolled;
	}
}
