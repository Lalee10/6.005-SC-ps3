package expressivo;

public class Number implements Expression{
	
	private final double num;
	
	
	public Number(double n) {
		num = n;
	}
	
	
	public boolean equals(Object other){
		if(!(other instanceof Number)){return false;}
		Number otherNum = (Number)other;
		return num == otherNum.num;
	}
	
	public String toString(){
		return num+"";
	}

	
	
	public int hashCode() {
		return (int)num*23;
	}

}
