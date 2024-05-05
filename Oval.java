/**
 * This subclass of FillableShape models the basic functionalities of an Oval element.
 * All methods required for an Oval object are found here.
 *
 * @author Matthew Moga
 * @version January 20, 2022
 */




import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;




public class Oval extends FillableShape {
    
    
    /**
     * Parameterized constructor to initialize the Oval object
     * 
     * @param x1 The X1 coordinate of Oval
     * @param y1 The Y1 coordinate of Oval
     * @param x2 The X2 coordinate of Oval
     * @param y2 The Y2 coordinate of Oval
     * @param color The color of Oval
     * @param filled The filled boolean value of Oval
     */
    public Oval( int x1, int y1, int x2, int y2, Color color, boolean filled ) {
        super(x1, y1, x2, y2, color, filled);
    }
    
    
    /**
     * Mutator draw component that overrides abstract method from Shape to draw Ovals.
     *
     * @param g The graphics required to draw Ovals
     */
    @Override
    public void draw( Graphics g ) {
        g.setColor( super.getColor() );
        if (super.getFilled()) {
            g.fillOval(super.getUpperLeftX(), super.getUpperLeftY(), super.getWidth(), super.getHeight());
        }
        else {
            g.drawOval(super.getUpperLeftX(), super.getUpperLeftY(), super.getWidth(), super.getHeight());
        }
    } 
    
    
    /**
     * Mutator that prints out Oval characteristics
     *
     */
    @Override
    public void printName( ) {
        System.out.println("I'm an oval");
    }
}
