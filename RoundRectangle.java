/**
 * This subclass of FillableShape models the basic functionalities of a Round Rectangle element.
 * All methods required for a Round Rectangle object are found here.
 *
 * @author Matthew Moga
 * @version January 20, 2022
 */




import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.awt.geom.RectangularShape;
import java.awt.geom.RoundRectangle2D;




public class RoundRectangle extends FillableShape {
    
    
    /**
     * Parameterized constructor to initialize the Round Rectangle object
     * 
     * @param x1 The X1 coordinate of Round Rectangle
     * @param y1 The Y1 coordinate of Round Rectangle
     * @param x2 The X2 coordinate of Round Rectangle
     * @param y2 The Y2 coordinate of Round Rectangle
     * @param color The color of Round Rectangle
     * @param filled The filled boolean value of Round Rectangle
     */
    public RoundRectangle( int x1, int y1, int x2, int y2, Color color, boolean filled ) {
        super(x1, y1, x2, y2, color, filled);
    }
    
    
    /**
     * Mutator draw component that overrides abstract method from parent class to draw Round Rectangles.
     *
     * @param g The graphics required to draw Round Rectangles
     */
    @Override
    public void draw( Graphics g ) {
        g.setColor( super.getColor() );
        int arc = Math.min(super.getWidth(), super.getHeight());
        if (arc < 50) {
            arc = 10;
        }
        else if (arc < 100) {
            arc = 20;
        }
        else if (arc < 200) {
            arc = 30;
        }
        else {
            arc = 50;
        }
        if (super.getFilled()) {
            g.fillRoundRect(super.getUpperLeftX(), super.getUpperLeftY(), super.getWidth(), super.getHeight(), arc, arc);
        }
        else {
            g.drawRoundRect(super.getUpperLeftX(), super.getUpperLeftY(), super.getWidth(), super.getHeight(), arc, arc);
        }
    } 
    
    /**
     * Mutator that prints out Round Rectangle characteristics
     *
     */
    @Override
    public void printName( ) {
        System.out.println("I'm a round rectangle");
    }
}
