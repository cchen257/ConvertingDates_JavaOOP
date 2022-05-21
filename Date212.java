/**************************************************
 * 
 * This Date212 class declares private variables year, month, and day for each individual Date212 object created.
 * It has get and set methods for the year, month, and day.
 * The Date212 constructor takes each date in the .txt file as a String, and determines which parts of this date are the year, month, and day. It converts each of these to integer type.
 * The compareTo method determines whether one date is older, newer, or equal to another date.
 * The equals method returns true if the year, month, and day of a date are exactly equal to those of another date.
 * The toString method converts a date's month to its month on the calendar, in word format. This method also converts an entire date to the format, "Month Day, Year".
 * 
 */

public class Date212 {
	private int year, month, day;	//these are the variables for each individual Date212 object
	
	public int getYear() { return year; }
	
	public int getMonth() { return month; }
	
	public int getDay() { return day; }
	
	public void setYear(int y){ year = y; }
	
	public void setMonth(int m) { month = m; }
	
	public void setDay(int d) { day = d; }
	
	public Date212(String ADate) {		/*The constructor, cuts each part of the string, ADate, into year (first four characters),
										*month, and day. This constructor is invoked every time a new Date212 object will be created.
										*I have to convert ADate to integer type because at first, it will be a string type due to being
										*read in from a file, using TextFileInput. Each line of the txt file will be read in as a String first
										*/
		year = Integer.parseInt( ADate.substring(0,4) );
		month = Integer.parseInt( ADate.substring(4,6) );
		day = Integer.parseInt( ADate.substring(6,8) );
	}
	
	public int compareTo(Date212 other) {		//I will use compareTo method later on to sort the dates in chronological order
		if (this.year < other.year) return -10;
		if (this.year > other.year) return 10;
		if ( this.year == other.year ) {
			if (this.month < other.month) return -10;
			else if (this.month > other.month) return 10;
			else if (this.month == other.month){
				if (this.day < other.day) return -10;
				if (this.day > other.day) return 10;
				if (this.day == other.day) return 0;
			}//else if
		}//if
		return 50; //return a random number to satisfy the method
	}
	
	public boolean equals(Date212 other) {	//returns true if year, month, and day of a date is all the same
		return (this.year == other.year) && (this.month == other.month) && (this.day == other.day);
	}
	
	public String toString() {			//converts the month in a date to words.
		String[] months = {"", "January", "February", "March", "April", "May", "June",			//I start with a blank space for months[0]
							"July", "August", "September", "October", "November", "December"};	//so that months[1] can correspond to January
		return months[month] + " " + day + ", " + year;		//This is what will be displayed on the right column of the GUI
	}
	
} //class
