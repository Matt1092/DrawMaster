/**
 * This subclass of Shape models the basic functionalities of a FillableShape element.
 * All methods required for a FillableShape object are found here.
 *
 * @author Matthew Moga
 * @version January 20, 2022
 */




import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;




abstract class FillableShape extends Shape {
    
    
    // Properly encapsulated (private) instance variables
    private boolean filled;
    
    
    /**
     * No-argument constructor which calls the parameterized constructor to intialize the FillableShape
     * with 0 for all coordinates and null for the color, false for the filled parameter
     */
    public FillableShape(){
        this(0,0,0,0,null,false );
    }
    
    
    /**
     * Parameterized constructor to initialize the FillableShape object
     * 
     * @param x1 The X1 coordinate of FillableShape
     * @param y1 The Y1 coordinate of FillableShape
     * @param x2 The X2 coordinate of FillableShape
     * @param y2 The Y2 coordinate of FillableShape
     * @param color The specified color for FillableShape
     * @param filled The filled boolean value for FillableShape
     */
    public FillableShape( int x1, int y1, int x2, int y2, Color color, boolean filled ) {
        setX1(x1);
        setY1(y1);
        setX2(x2);
        setY2(y2);
        setColor(color);
        setFilled(filled);
    }
    
    
    /**
     * This accessor returns the filled boolean value of FillableShape.
     *
     * @return filled - boolean
     */
    public boolean getFilled() {
        return filled;
    }
    
    
    /**
     * Mutator to set a new value for the filled value of FillableShape.
     *
     * @param param The boolean value to set for filled
     */
    public void setFilled(boolean param) {
        filled = param;
    }
    
    
    /**
     * This accessor returns the upper left X coordinate of FillableShape.
     *
     * @return upperLeftX - int
     */
    public int getUpperLeftX() {
        int upperLeftX = Math.min(super.getX1(), super.getX2());
        return upperLeftX;
    }
    
    
    /**
     * This accessor returns the upper left Y coordinate of FillableShape.
     *
     * @return upperLeftY - int
     */
    public int getUpperLeftY() {
        int upperLeftY = Math.min(super.getY1(), super.getY2());
        return upperLeftY;
    }
    
    
    /**
     * This accessor returns the width value of FillableShape.
     *
     * @return width - int
     */
    public int getWidth() {
        int width = Math.abs(super.getX1() - super.getX2());
        return width;
    }
    
    
    /**
     * This accessor returns the height value of FillableShape.
     *
     * @return height - int
     */
    public int getHeight() {
        int height = Math.abs(super.getY1() - super.getY2());
        return height;
    }
}
