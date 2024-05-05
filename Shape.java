/**
 * This class models the basic functionalities of a Shape element.
 * All methods required for a Shape object are found here.
 *
 * @author Matthew Moga
 * @version January 20, 2022
 */




import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;




abstract class Shape {
    
    
    // Properly encapsulated (private) instance variables
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private Color color;
    
    
    /**
     * No-argument constructor which calls the parameterized constructor to intialize the Shape
     * with 0 for all coordinates and null for the color
     */
    public Shape (){
        this(0,0,0,0, null);
    }
    
    
    /**
     * Parameterized constructor to initialize the Shape object
     * 
     * @param x1 The X1 coordinate of Shape
     * @param y1 The Y1 coordinate of Shape
     * @param x2 The X2 coordinate of Shape
     * @param y2 The Y2 coordinate of Shape
     * @param color The color of Shape
     */
    public Shape( int x1, int y1, int x2, int y2, Color color ) {
        setX1(x1);
        setY1(y1);
        setX2(x2);
        setY2(y2);
        setColor(color);
    }
    
    
    /**
     * This accessor returns the X1 coordinate of Shape.
     *
     * @return int - x1
     */
    public int getX1() {
        return x1;
    }
    
    
    /**
     * This accessor returns the Y1 coordinate of Shape.
     *
     * @return int - y1
     */
    public int getY1() {
        return y1;
    }
    
    
    /**
     * This accessor returns the X2 coordinate of Shape.
     *
     * @return int - x2
     */
    public int getX2() {
        return x2;
    }
    
    
    /**
     * This accessor returns the Y2 coordinate of Shape.
     *
     * @return int - y2
     */
    public int getY2() {
        return y2;
    }
    
    
    /**
     * This accessor returns the color of Shape.
     *
     * @return color - Color
     */
    public Color getColor() {
        return color;
    }
    
    
    /**
     * Mutator to set a new value for the X1 coordinate of Shape.
     *
     * @param xCoord1 The value to set the X1 coordinate to
     */
    public void setX1(int xCoord1) {
        if (xCoord1 < 0) {
            System.err.println( "Attempt to set x1 to less than 0 ignored, setting to 0 by default." );
            x1 = 0;
        }
        else {
            x1 = xCoord1;
        }        
    }
    
    
    /**
     * Mutator to set a new value for the Y1 coordinate of Shape.
     *
     * @param yCoord1 The value to set the Y1 coordinate to
     */
    public void setY1(int yCoord1) {
        if (yCoord1 < 0) {
            System.err.println( "Attempt to set y1 to less than 0 ignored, setting to 0 by default." );
            y1 = 0;
        }
        else {
            y1 = yCoord1;
        }
    }
    
    
    /**
     * Mutator to set a new value for the X2 coordinate of Shape.
     *
     * @param xCoord2 The value to set the x2 coordinate to
     */
    public void setX2(int xCoord2) {
        if (xCoord2 < 0) {
            System.err.println( "Attempt to set x2 to less than 0 ignored, setting to 0 by default." );
            x2 = 0;
        }
        else {
            x2 = xCoord2;
        }
    }
    
    
    /**
     * Mutator to set a new value for the Y2 coordinate of Shape.
     *
     * @param yCoord2 The value to set the Y2 coordinate to
     */
    public void setY2(int yCoord2) {
        if (yCoord2 < 0) {
            System.err.println( "Attempt to set y2 to less than 0 ignored, setting to 0 by default." );
            y2 = 0;
        }
        else {
            y2 = yCoord2;
        }
    }
    
    
    /**
     * Mutator to set a new color for the Shape.
     *
     * @param color The specified color
     */
    public void setColor(Color color) {
        // generate a random color
        this.color = color;
    }
    
    
    /**
     * Abstract Mutator for Shape drawing.
     *
     * @param g The painting graphics for the Shape
     */
    public abstract void draw( Graphics g );
    
    
    /**
     * Abstract Mutator to print the Shape characteristics.
     *
     */
    public abstract void printName( );
}
