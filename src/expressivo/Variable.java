package expressivo;

public class Variable implements Expression{
	
	
	private final String var;
	
	public Variable(String v){
		var = v;
	};
	
	public String toString(){return var;}
	

	public boolean equals(Object other){
		if(!(other instanceof Variable)){return false;}
		Variable otherVar = (Variable) other;
		return var.equals(otherVar.var);
		}
	public int hashCode(){
	    int result = 43;
	    int c = var.hashCode();
	    return 37*result + c;
	}

}
