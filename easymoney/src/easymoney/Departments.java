package easymoney;

import java.util.ArrayList;

public class Departments {
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	private String id;
	private String name;
	private ArrayList<Departments> department;
public Departments(String a, String b){
	super();
	this.id=a;
	this.name=b;
	
}
public String toString(){
	return ""+id+"     "+name;
}

}
