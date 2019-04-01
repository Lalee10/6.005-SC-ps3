package expressivo;

public class Add implements Expression {
	private final Expression left;
	private final Expression right;

	public Add(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	/**
	 * @return a parsable representation of this expression, such that for all
	 *         e:Expression, e.equals(Expression.parse(e.toString())).
	 */
	@Override
	public String toString() {
		return "(" + this.left.toString() + " + " + this.right.toString() + ")";
	}

	/**
	 * @param thatObject any object
	 * @return true if and only if this and thatObject are structurally-equal
	 *         Expressions, as defined in the PS3 handout.
	 */
	@Override
	public boolean equals(Object thatObject) {
		if (!(thatObject instanceof Add)) {
			return false;
		}

		Add thatAdd = (Add) thatObject;
		return (this.left.equals(thatAdd.left) && this.right.equals(thatAdd));
	}

	/**
	 * @return hash code value consistent with the equals() definition of structural
	 *         equality, such that for all e1,e2:Expression, e1.equals(e2) implies
	 *         e1.hashCode() == e2.hashCode()
	 */
	@Override
	public int hashCode() {
		return this.left.hashCode() + this.right.hashCode();
	}

	public Add editChildren(Expression left, Expression right) {
		return new Add(left, right);
	}
}
