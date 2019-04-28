/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package expressivo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Console interface to the expression system.
 * 
 * <p>PS3 instructions: you are free to change this user interface class.
 */
public class Main {
    
    
    /**
     * Read expression and command inputs from the console and output results.
     * An empty input terminates the program.
     * @param args unused
     * @throws IOException if there is an error reading the input
     */
    public static void main(String[] args) throws IOException {
    	System.out.println("===== Welcome to Expressivo =====");
        System.out.print("Enter your expression and watch the beauty of the trees: ");
        
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            final String input = in.readLine();
            
            if (input.isEmpty()) {
                return; // exits the program
            }
            
            Expression.parse(input);
        }
    }
}
