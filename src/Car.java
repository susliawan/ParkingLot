
public class Car {
	
	private String registrationNo;
	private String colour;
	
	public Car(){}
	
	public Car(String _registrationNo, String _colour){
		this.registrationNo = _registrationNo;
		this.colour = _colour;
	}
	
	public String registrationNo(){
		return this.registrationNo;
	}
	
	public String colour(){
		return this.colour;
	}
}
