package story;

public class Territory {
	private Culture culture;
	private String name;
	private String size;
	
	
	public Territory(Culture c, String n, String s){
		culture = c;
		name = n;
		size = n;
	}

	public Culture culture(){
		return culture;
	}
	
	public String name(){
		return name;
	}
	
	public String size(){
		return size;
	}
	
}
