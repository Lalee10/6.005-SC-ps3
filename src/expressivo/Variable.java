package expressivo;

public class Variable implements Expression {

	private final String var;

	public Variable(String v) {
		this.var = v;
	};

	public String toString() {
		return this.var;
	}

	public boolean equals(Object other) {
		if (!(other instanceof Variable)) {
			return false;
		}
		Variable otherVar = (Variable) other;
		return this.var.equals(otherVar.var);
	}

	public int hashCode() {
		return this.var.length() * 6969;
	}

}
