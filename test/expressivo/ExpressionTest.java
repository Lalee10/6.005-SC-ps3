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

    // Testing strategy (only for Building Expression)
    /*
     *	Operators:
     *		1. Single
     *		2. Multiple same operators
     *		3. Multiple different operators
     * 
     *  Variables / Numbers:
     *  	1. Only Variables
     * 		2. Only Numbers
     * 		3. Variables & Numbers
     * 	
     */
	
	
	Expression t1 = new Multiply(new Number(3), new Add(new Variable("x"), new Number(5)));
	Expression t2 = new Multiply(new Number(3.9), new Add(new Number(4), new Number(5)));
	Expression t3 = new Multiply(new Number(3.9), new Add(new Number(4), new Number(5)));
	Expression t4 = new Add(new Variable("x"), new Add(new Variable("y"), new Variable("z")));
	Expression t5 = new Add(new Variable("x"), new Add(new Variable("y"), new Variable("z")));
	Expression t6 = new Multiply(new Number(5), new Variable("x"));
	Expression t7 = new Multiply(new Number(5), new Variable("x"));
	
	
	Number testInt = new Number(15);
    Number testDec = new Number(0.19);
    Variable testLower = new Variable("b");
    Variable testUpper = new Variable("B");
    Variable testWord = new Variable("beTa");
    Add testPlusSimple = new Add(testInt,testLower);
    Add testPlusSimpleRev = new Add(testLower,testInt);
    Multiply testMultSimple = new Multiply(testInt,testLower);
    Multiply testMultSimpleRev = new Multiply(testLower,testInt);
	
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    
    @Test
    
    public void parseNumber() {
    	assertEquals(Expression.parse("15"),testInt);
    	assertEquals(Expression.parse("15.0"),testInt);
    	assertEquals(Expression.parse("(15)"),testInt);
    	assertEquals(Expression.parse("0.19"),testDec);
    	assertEquals(Expression.parse("(0.19)"),testDec);
    }
    
    @Test
    public void parseVariable() {
    	assertEquals(Expression.parse("B"),testUpper);
    	assertEquals(Expression.parse("(B)"),testUpper);
        assertEquals(Expression.parse("\tb"),testLower);
        assertEquals(Expression.parse("(b\n)"),testLower);
        assertEquals(Expression.parse("beTa\n"),testWord);
        assertEquals(Expression.parse("(\tbeTa)"),testWord);
    }
    
    @Test 
    public void testParseSum(){
        assertEquals(Expression.parse("15 + b"),testPlusSimple);
        assertEquals(Expression.parse("  (15 + b)  "),testPlusSimple);
        assertEquals(Expression.parse("b + 15"),testPlusSimpleRev);
        assertEquals(Expression.parse("   (b + 15)   "),testPlusSimpleRev);
    }
    
    
    @Test 
    public void testParseMult(){
        assertEquals(Expression.parse("15 * b"),testMultSimple);
        assertEquals(Expression.parse("  (15 * b)  "),testMultSimple);
        assertEquals(Expression.parse("b * 15"),testMultSimpleRev);
        assertEquals(Expression.parse("    (b * 15)   "),testMultSimpleRev);
    }
    
    // TODO tests for Expression
    @Test
    public void testMultipleDifferentOperatorsVariablesAndNumbers() {
    	assertTrue("Expecting t1 equal to itsself", t1.equals(t1));
    	assertFalse("Expecting t1 not equal to t2", t1.equals(t2));
    	assertEquals("Expecting String to be equal to toString", t1.toString(), "(3 * (x + 5))");
    	assertEquals("Expecting Hashcode 207", t1.hashCode(), 62721);
    }
    
    @Test
    public void testMultipleDifferentOperatorsOnlyNumbers() {
    	assertTrue("Expecting t2 equal to t3", t2.equals(t3));
    	assertTrue("Expecting t3 equal to t2", t3.equals(t2));
    	assertEquals("Expecting t2 string to be: ", t2.toString(), "(3.9 * (4 + 5))");
    	assertEquals("Expecting t2 string to be equal to t3 string", t2.toString(), t3.toString());
    	assertEquals("Expecting t2 hascode to be: ", t2.hashCode(), 89901);
    	assertEquals("Expecting t2 hascode to be equal to t3 hashcode", t2.hashCode(), t3.hashCode());
    }
    
    @Test
    public void testMultipleSameOperatorOnlyVariables() {
    	assertTrue("Expecting t4 and t5 to be equal:", t4.equals(t5));
    	assertEquals("Expecting t4 to have hashcode 20907:", t4.hashCode(), 20907);
    	assertEquals("Expecting t4 and t5 to have same hashcode:", t4.hashCode(), t5.hashCode());
    	assertEquals("Expecting t4 to have string:", t4.toString(), "(x + (y + z))");
    	assertEquals("Expecting t4 and t5 to have same string returned:", t4.toString(), t5.toString());
    }
    
    @Test
    public void testSingleOperatorVariablesAndNumbers() {
    	assertTrue("Expecting t6 and t7 to be equal:", t6.equals(t7));
    	assertEquals("Expecting t6 to have hashcode 41814:", t6.hashCode(), 41814);
    	assertEquals("Expecting t6 and t7 to have same hashcode:", t6.hashCode(), t7.hashCode());
    	assertEquals("Expecting t6 to have string:", t6.toString(), "(5 * x)");
    	assertEquals("Expecting t6 and t7 to have same string returned:", t6.toString(), t7.toString());
    }    
}
