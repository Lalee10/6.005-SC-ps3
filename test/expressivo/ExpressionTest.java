/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package expressivo;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for the Expression abstract data type.
 */
public class ExpressionTest {

    // Testing strategy
    /*
     *	Operators:
     *		1. Single
     *		2. Multiple same operators
     *		3. Multiple different operators
     * 
     *	Brackets / Priority:
     *		1. Same priority without brackets
     *		2. Different priority without brackets
     * 	
     * 	
     */
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    
    // TODO tests for Expression
    
}
