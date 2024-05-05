/**
 * This subclass of FillableShape models the basic functionalities of a Rectangle element.
 * All methods required for a Rectangle object are found here.
 *
 * @author Matthew Moga
 * @version January 20, 2022
 */




import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;




public class Rectangle extends FillableShape {
    
    
    /**
     * Parameterized constructor to initialize the Rectangle object
     * 
     * @param x1 The X1 coordinate of Rectangle
     * @param y1 The Y1 coordinate of Rectangle
     * @param x2 The X2 coordinate of Rectangle
     * @param y2 The Y2 coordinate of Rectangle
     * @param color The color of Rectangle
     * @param filled The filled boolean value of Rectangle
     */
    public Rectangle( int x1, int y1, int x2, int y2, Color color, boolean filled ) {
        super(x1, y1, x2, y2, color, filled);
    }
    
    
    /**
     * Mutator draw component that overrides abstract method from Shape to draw Rectangles.
     *
     * @param g The graphics required to draw Rectangles
     */
    @Override
    public void draw( Graphics g ) {
        g.setColor( super.getColor() );
        if (super.getFilled()) {
            g.fillRect(super.getUpperLeftX(), super.getUpperLeftY(), super.getWidth(), super.getHeight());
        }
        else {
            g.drawRect(super.getUpperLeftX(), super.getUpperLeftY(), super.getWidth(), super.getHeight());
        }
    } 
    


    /**
     * Mutator that prints out Rectangle characteristics
     *
     */
    @Override
    public void printName( ) {
        System.out.println("I'm a rectangle");
    }
}
