import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.util.StringTokenizer;
import javax.swing.JFrame;
/*************************************************
 * 
 * This DateGUI class creates a GUI with a GridLayout format of one row and two columns.
 * It declares a JFrame, Container, and TextArea.
 * The DateGUI constructor passes in the Date212 array, the String array, and the counter. It calls upon the initialize method.
 * The initialize method creates the GUI. The GUI's left column contains the String array. The GUI's right column contains the Date212 array.
 *
 */
public class DateGUI {
	static JFrame myFrame;
	static Container cPane;			//ContentPane
	static TextArea LeftColumn, RightColumn;
	
	public DateGUI(Date212[] RightArray, String[] LeftArray, int count) {	//DatesArray and LeftColArray from Project1 class are passed in
		initialize(RightArray, LeftArray, count);
	}
	
	public void initialize(Date212[] RightArray, String[] LeftArray, int count) {
		LeftColumn = new TextArea();				//create a new TextArea for the left column
		RightColumn = new TextArea();
		myFrame = new JFrame();
		myFrame.setSize(500, 400);
		myFrame.setLocation(200, 200);
		myFrame.setTitle("Project 1");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setLayout(new GridLayout(1, 2));	//creates one row, two columns
		cPane = myFrame.getContentPane();
		cPane.add(LeftColumn);
		cPane.add(RightColumn);
	
		for (int i=0; i < count; i++){					//this loops through each of the values in the arrays
			LeftColumn.append(LeftArray[i] + "\n");		//LeftColArray, unsorted and not converted to String, is displayed on the left column
			RightColumn.append(RightArray[i] + "\n");	//DatesArray, sorted and converted by the toString method, is displayed on the right column
		}
		
		myFrame.setVisible(true);						//To make sure the frame is visible to users
	}
}//class