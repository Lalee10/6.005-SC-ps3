package expressivo;

public class Number implements Expression {

	private final double num;

	public Number(double n) {
		this.num = n;
	}

	public boolean equals(Object other) {
		if (!(other instanceof Number)) {
			return false;
		}
		Number otherNum = (Number) other;
		return this.num == otherNum.num;
	}

	public String toString() {
		if ((int) this.num == (double) num) {
			return ((int) this.num) + "";
		}
		return this.num + "";
	}

	public int hashCode() {
		return (int) Math.ceil(this.num * 6969);
	}

}
