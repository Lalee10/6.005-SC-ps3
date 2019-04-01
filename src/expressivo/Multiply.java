package expressivo;

public class Multiply implements Expression {
	private final Expression left;
	private final Expression right;
	
	public Multiply(Expression l, Expression r) {
		this.left = l;
		this.right = r;
	}
	
	/**
     * @return a parsable representation of this expression, such that
     * for all e:Expression, e.equals(Expression.parse(e.toString())).
     */
    @Override 
    public String toString() {
    	return "(" + this.left.toString() + " * " + this.right.toString() + ")"; 
    };
    
    
    /**
     * @param thatObject any object
     * @return true if and only if this and thatObject are structurally-equal
     * Expressions, as defined in the PS3 handout.
     */
    @Override
    public boolean equals(Object otherNode) {
    	
    	if(!(otherNode instanceof Multiply)){return false;}
        Multiply M = (Multiply) otherNode;
        return (this.left.equals(M.left) && this.right.equals(M.right));
    }
    
    /**
     * @return hash code value consistent with the equals() definition of structural
     * equality, such that for all e1,e2:Expression,
     *     e1.equals(e2) implies e1.hashCode() == e2.hashCode()
     */
    @Override
    public int hashCode() {
    	return this.left.hashCode() + this.right.hashCode();
    }
    
    /**
     * @return returns a new multiply node with the specified children
     */
    public Multiply editChildren(Expression l, Expression r) {
    	return new Multiply(l, r);
    }
    
    
    
    
}
