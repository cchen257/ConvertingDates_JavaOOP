import java.util.StringTokenizer;
/*********************************************
 * 
 * This Project1 class declares a TextFileInput type, a String as the line that will be read in from the .txt file, a StringTokenizer type, a Date212 type array, a String array, and a counter.
 * This class also contains a main method that reads in dates from the .txt file, sorts the dates, and creates a GUI.
 * The readDatesFromFile method reads in a .txt file, and puts the file's dates into both the Date212 array and the String array.
 * The selectionSort method sorts the Date212 array into chronological order, from oldest to newest date. 
 *
 */

public class Project1 {
	static TextFileInput myFile;
	static String line;
	static StringTokenizer myTokens;
	static Date212[] DatesArray;
	static int count=0;				//created to count the number of spaces filled up in DatesArray and LeftColArray
	static String[] LeftColArray;	//this is for printing on left column of the GUI, it will be the original format of the dates in thedates.txt
									//without having the toString method and without being sorted
	
	public static void main(String[] args) {
		readDatesFromFile("thedates.txt");
		selectionSort();												//sort the dates in chronological order
		DateGUI myGUI = new DateGUI(DatesArray, LeftColArray, count);	//create a new DateGUI object, pass all of these parameters to
																		//DateGUI class for printing
	}
	
	public static void readDatesFromFile(String fileName) {
		myFile = new TextFileInput(fileName);
		String line;
		line = myFile.readLine();

		DatesArray = new Date212[100];				//creates an array, type being Date212 object, with 100 possible spaces to be filled
		LeftColArray = new String[100];
		
		while (line!=null){									//while we haven't hit the end of thedates.txt yet and there is still a date in the line
			myTokens = new StringTokenizer(line, ",");		//comma is the delimiter, separates dates from another
			
			while ( myTokens.hasMoreTokens() ) {			//While there are still more tokens
				String thisisADate = myTokens.nextToken();	//Create a new String that will hold the token being read
				Date212 aDateObj= new Date212(thisisADate);	//Then create a Date212 object that will hold the String. this is so that the String
															//becomes a Date212 object type
				DatesArray[count] = aDateObj;				//This array is Date212 object type, so it will be displayed on the GUI's right column
															//The Date212 object that was created to hold the String being read in line by line,
															//is now being fed into each column of DatesArray
				LeftColArray[count] = thisisADate;			//This array is a String type, it will go on the GUI's left column. It holds the String
															//type, thisisADate. LeftColArray was created so that we can have the dates displayed
															//in the GUI simply as they are, meaning not ordered, with its months not converted to
															//words, not a Date212 object.
				count++;									//This a counter for the number of dates we have read, or the length of DatesArray
															//and LeftColArray
			}
			line = myFile.readLine();						//This saves the current line, and goes on to read the next line in thedates.txt
		}
	}
	
	private static void selectionSort() {					//This is the only small error in my project that I have not figured out!
		for (int i=0; i < count-1; i++) {					//My selectionSort method is not able to sort the dates, from oldest to
			int indexLowest = i;							//newest date, in my GUI's right column.
			
			for (int j = i+1; j < count; j++) {
				if ( (DatesArray[j].compareTo(DatesArray[indexLowest]) )< 0 ) indexLowest=j;	//calls on the compareTo method.
																								//if compareTo returns a negative number,
																								//that means DatesArray[j] is smaller than
																								//DatesArray[indexLowest], so we set the
																								//lowest index to be j
				if (! DatesArray[indexLowest].equals(DatesArray[i] )) {
					Date212 temp = DatesArray[indexLowest];				//swap the smallest value with DatesArray[i]
					DatesArray[indexLowest] = DatesArray[i];
					DatesArray[i] = temp;
				}
			}//for

		}//for
	}
	
}//class
