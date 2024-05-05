/**
 * This class models the Paint-program main class for our swing program.
 * All program functions are demonstrated here.
 *
 * @author Matthew Moga
 * @version January 19, 2022
 */




import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;




public class ShapePainter {
    
    
    /**
     * This method defines the mainline logic for our program. 
     * It uses a JFrame object to run the program.
     * 
     * @param args (String[])
     */
    public static void main( String[] args ) {
        JFrame appWindow = new JFrame( "Microsoft Paint App" );
        
        // Put statusLabel in NORTH to display mouse coordinates
        JLabel statusLabel = new JLabel();
        
        appWindow.add( statusLabel, BorderLayout.NORTH );
        
        // Put DrawPanel in CENTER and pass reference to statusLabel for updates
        appWindow.add( new DrawPanel( statusLabel ), BorderLayout.CENTER );        
        
        appWindow.setSize( 1920, 1080 );
        appWindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        appWindow.setVisible( true );
    }    
}
