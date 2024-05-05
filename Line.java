/**
 * This subclass of Shape models the basic functionalities of a Line element.
 * All methods required for a Line object are found here.
 *
 * @author Matthew Moga
 * @version January 20, 2022
 */




import java.awt.Color;
import java.awt.Graphics;




public class Line extends Shape {
    
    
    /**
     * Parameterized constructor to initialize the Line object
     * 
     * @param x1 The X1 coordinate of Line
     * @param y1 The Y1 coordinate of Line
     * @param x2 The X2 coordinate of Line
     * @param y2 The Y2 coordinate of Line
     * @param color The color of Line
     */
    public Line( int x1, int y1, int x2, int y2, Color color ) {
        super(x1, y1, x2, y2, color);
        
    } 
    
    
    /**
     * Mutator draw component that overrides abstract method from Shape to draw Lines.
     *
     * @param g The graphics required to draw Lines
     */
    @Override
    public void draw( Graphics g ) {
        g.setColor( super.getColor() );
        g.drawLine(super.getX1(), super.getY1(), super.getX2(), super.getY2());
    } 
    
    
    /**
     * Mutator that prints out Line characteristics
     *
     */
    @Override
    public void printName( ) {
        System.out.println("I'm a line");
    }
}
