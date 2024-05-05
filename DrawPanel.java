/**
 * This class models the swing components for our Paint-program.
 * All methods required for mouse movement and button controls are found here.
 *
 * @author Matthew Moga
 * @version January 20, 2022
 */




import javax.swing.JColorChooser;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JComponent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Container;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;




public class DrawPanel extends JPanel {
    
    
    // Properly encapsulated (private) instance variables
    private JLabel statusBar;
    private Shape currentShape = null;
    private Shape poppedShape = null;
    private DynamicStack<Shape> myShape = new DynamicStack<Shape>();
    private DynamicStack<Shape> tempStack = new DynamicStack<Shape>();
    private DynamicStack<Shape> clearedStack = new DynamicStack<Shape>(); 
    private JButton colourButton;
    private Color color = Color.BLACK;    
    private boolean lineDraw;
    private JButton lineButton;
    private boolean roundRectDraw;
    private JButton roundRectButton;
    private boolean rectDraw;
    private JButton rectButton;
    private boolean ovalDraw;
    private JButton ovalButton; 
    private JButton undoButton;
    private JButton redoButton;
    private boolean filled;
    private JButton filledButton;
    private JButton emptyButton;
    private JButton saveButton;
    private BufferedImage image;
    private JButton textButton;


    
    public DrawPanel( JLabel statusLabel ) {
        setLayout( new FlowLayout() );
        ActionListener eventListener = new ButtonEventListener();
        
        
        // Create a ButtonEventListener object (to be shared by all 3 buttons)
        ActionListener buttonListener = new ButtonEventListener();
        
        
        ImageIcon colourIcon = new ImageIcon( "colour.png" );
        colourButton = new JButton( colourIcon );
        colourButton.addActionListener( eventListener );
        add( colourButton );
        
        
        ImageIcon lineIcon = new ImageIcon( "line.png" );
        lineButton = new JButton( lineIcon );
        lineButton.addActionListener( eventListener );
        add( lineButton );
        
        
        ImageIcon roundRectIcon = new ImageIcon( "roundrect.png" );
        roundRectButton = new JButton( roundRectIcon );
        roundRectButton.addActionListener( eventListener );
        add( roundRectButton );       
                
        
        ImageIcon rectIcon = new ImageIcon( "rectangle.png" );
        rectButton = new JButton( rectIcon );
        rectButton.addActionListener( eventListener );
        add( rectButton );
        
        
        ImageIcon ovalIcon = new ImageIcon( "oval.png" );
        ovalButton = new JButton( ovalIcon );
        ovalButton.addActionListener( eventListener );
        add( ovalButton );
        
        
        ImageIcon undoIcon = new ImageIcon( "undo.png" );
        undoButton = new JButton( undoIcon );
        undoButton.addActionListener( eventListener );
        add( undoButton );
        
        
        ImageIcon redoIcon = new ImageIcon( "redo.png" );
        redoButton = new JButton( redoIcon );
        redoButton.addActionListener( eventListener );
        add( redoButton );
        
        
        ImageIcon fillIcon = new ImageIcon( "fill.png" );
        filledButton = new JButton( fillIcon );
        filledButton.addActionListener( eventListener );
        add( filledButton );
        
        
        ImageIcon emptyIcon = new ImageIcon( "empty.png" );
        emptyButton = new JButton( emptyIcon );
        emptyButton.addActionListener( eventListener );
        add( emptyButton );
        
        
        ImageIcon saveIcon = new ImageIcon( "savetofile.png" );
        saveButton = new JButton( saveIcon );
        saveButton.addActionListener( eventListener );
        add( saveButton );    
        
        
        JOptionPane.showMessageDialog(null, "Mogasoft Paint loading...");


        
        statusBar = statusLabel;
        setBackground( Color.WHITE );
        
        
        // Create and register listener for mouse and mouse motion events
        MouseEventListener drawPanelListener = new MouseEventListener();
        addMouseListener( drawPanelListener );
        addMouseMotionListener( drawPanelListener );  
    }
    
            
    // Here is the inner class for event handling
    class ButtonEventListener implements ActionListener {
        /**
         * Mutator method interface requires that overrides the actionPerformed() method.
         * This method will be called automatically whenever a button event occurs.
         *
         * @param e Parameter for button event listening
         */
        @Override
        public void actionPerformed( ActionEvent e ) {
            if ( e.getSource() == colourButton ) {
                color = JColorChooser.showDialog(null,
                                                 "Select a colour", null);
            }
            else if ( e.getSource() == lineButton ) {
                lineDraw = true;
                roundRectDraw = false;
                rectDraw = false;
                ovalDraw = false;
                currentShape = new Line( 0, 0, 0, 0, color );
            }
            
            else if ( e.getSource() == roundRectButton ) {
                lineDraw = false;
                roundRectDraw = true;
                rectDraw = false;
                ovalDraw = false;
                currentShape = new RoundRectangle( 0, 0, 0, 0, color, filled );
            }
            
            else if ( e.getSource() == rectButton ) {
                lineDraw = false;
                roundRectDraw = false;
                rectDraw = true;
                ovalDraw = false;
                currentShape = new Rectangle( 0, 0, 0, 0, color, filled );
            }
            
            else if ( e.getSource() == ovalButton ) {
                lineDraw = false;
                roundRectDraw = false;
                rectDraw = false;
                ovalDraw = true;
                currentShape = new Oval( 0, 0, 0, 0, color, filled );
            }
            
            else if ( e.getSource() == undoButton ) {
                // Push items that were undone onto clearedStack while myShape is empty so redo button can push items onto clearedStack
                if (myShape.isEmpty() == false) {
                    clearedStack.push(myShape.pop());
                    repaint();
                }
            }
            
            // Push items popped from the clearedStack to redo mistakes
            else if ( e.getSource() == redoButton ) {
                if (clearedStack.isEmpty() == false) {
                    myShape.push(clearedStack.pop());
                    repaint();
                }
            }
            
            else if ( e.getSource() == filledButton ) {
                filled = true;
            }
            
            else if ( e.getSource() == emptyButton ) {
                filled = false;
            }
            
            else if ( e.getSource() == saveButton ) {
                try {
                    // Instantiate image that will be a visual representation of the current screen display
                    BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
                    Graphics graphics = image.getGraphics();
                    paint(graphics);
                    // File writing implemented to create a file that will be stored in recent downloads
                    ImageIO.write(image, "png", new File("graphics.png"));
                } catch (IOException io_e) {
                    io_e.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Image has been saved!");
            }
        }
    }
      
        
     // Inner class to handle mouse events
     class MouseEventListener extends MouseAdapter {
         /**
         * Mutator method for MouseEventListener that requires overriding the mousePressed() method.
         * This method will be called automatically whenever the mouse button is pressed. The mouse press
         * indicates a new shape has been started.
         *
         * @param event Parameter for mouse event handling
         */
         @Override
         public void mousePressed( MouseEvent event ) {
             
             // Draw round rectangle if user selects associated JButton
             if ( roundRectDraw == true ) {
                 currentShape = new RoundRectangle( event.getX(), event.getY(), event.getX(), event.getY(), color, filled );
             }
             
             // Draw Rectangle if user selects associated JButton
             else if ( rectDraw == true ) {
                 currentShape = new Rectangle( event.getX(), event.getY(), event.getX(), event.getY(), color, filled );
             }
             
             // Draw Oval if user selects associated JButton
             else if ( ovalDraw == true ) {
                 currentShape = new Oval( event.getX(), event.getY(), event.getX(), event.getY(), color, filled );
             }
             
             // Draw Line if user selects associated JButton
             else if ( lineDraw == true ) {
                 currentShape = new Line( event.getX(), event.getY(), event.getX(), event.getY(), color );                 
             }
             
             // Default drawing set to Line
             else {
                 currentShape = new Line( event.getX(), event.getY(), event.getX(), event.getY(), color );
             }


             // Tell JVM to call paintComponent( g ) and clear clearedStack before instantiating currentShape for each scenari
             clearedStack.clear();
             repaint();
         }
         
         
         /**
         * Mutator method for MouseEventListener that requires overriding the mouseReleased() method.
         * This method will be called automatically whenever the mouse button is released. The mouse release
         * indicates a new shape has been finished.
         *
         * @param event Parameter for mouse event handling
         */
         @Override
         public void mouseReleased( MouseEvent event ) {      
             currentShape.setX2( event.getX() );
             currentShape.setY2( event.getY() );           
             currentShape.setColor( color );
             statusBar.setText( String.format( "Mouse released at (%d, %d)",
                                              event.getX(), event.getY() ) );
             tempStack.push(currentShape);
             repaint();
             currentShape = null;
         }
         
         /**
         * Mutator method for MouseEventListener that requires overriding the mouseDragged() method.
         * This method will be called automatically whenever the mouse button is dragged. The mouse drag
         * indicates that a new shape drawing is processing. As mouse is dragged, ending coordinates
         * of currentLine and statusBar are updated.
         *
         * @param event Parameter for mouse event handling
         */
         @Override
         public void mouseDragged( MouseEvent event ) {
             currentShape.setX2( event.getX() );
             currentShape.setY2( event.getY() );
             currentShape.setColor( color );
             
             repaint();
         }
         
         /**
         * Mutator method for MouseEventListener that requires overriding the mouseClicked() method.
         * This method will be called automatically whenever the mouse button is clicked. The mouse click
         * simply has a status bar update of its current coordinates.
         *
         * @param event Parameter for mouse event handling
         */
         @Override
         public void mouseClicked( MouseEvent event ) {
             statusBar.setText( String.format( "Mouse clicked at (%d, %d)",
                                              event.getX(), event.getY() ) );
         }
         
         /**
         * Mutator method for MouseEventListener that requires overriding the mouseMoved() method.
         * This method will be called automatically whenever the mouse button is moved. This simply
         * has a status update of the mouse's current coordinates.
         *
         * @param event Parameter for mouse event handling
         */
         @Override
         public void mouseMoved( MouseEvent event ) {
             statusBar.setText( String.format( "Mouse at (%d, %d)",
                                              event.getX(), event.getY() ) );
         }
     }
     
    
     /**
      * Mutator method that requires overriding the paintComponent() method.
      * This method is called automatically by the JVM when the window needs to be (re)drawn.
      *
      * @param g Graphics that will be displayed on the screen in main class
      */
    @Override
    public void paintComponent( Graphics g ) {
        super.paintComponent( g );
        while (myShape.isEmpty() == false) {
            poppedShape =  myShape.pop();
            tempStack.push(poppedShape);
        }
        
        while (tempStack.isEmpty() == false) {
            poppedShape = tempStack.pop();
            poppedShape.draw(g);
            myShape.push(poppedShape);
        }
        
        if ( currentShape != null ) {
            currentShape.draw( g );
        }
    }
}
