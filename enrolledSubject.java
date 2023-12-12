
public class enrolledSubject {
	
	//declare ang information sa kada subject
	private String subDescrip;
	private String code;
	private String subSched;
	private String subSection;
	private String secCode;
	private int units;
	//constructor sa subject nga naay parameter nga information sa subject
	public enrolledSubject(String secCode,String code,String subDescrip,String subSection,String subSched,int units){
		this.secCode = secCode;
		this.code = code;
		this.subDescrip = subDescrip;
		this.subSection = subSection;
		this.subSched = subSched;
		this.units = units;
	}
	//getters sa information sa subject
	public String getSubCode() {
		return code;
		
	}
	public String getSecCode() {
		return secCode;
		
	}
	public String getSubDescrip() {
		return subDescrip;
	
	}
	public String getSubSched() {
		return subSched;
	
	}
	public String getSubSection() {
		return subSection;
	
	}
	public int getUnits() {
		return units;
	
	}
	
}
