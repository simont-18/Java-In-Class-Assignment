//Name: Kyle Johnston           contribute:33%               
//Name: Harshin Kanabar         contribute:33%               
//Name: Duy Ta                  contribute:33%
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class DateTest {
	public static void main(String args[]) {
		//declare of variable to read and write to file
		Scanner in = null;
		PrintWriter out = null;
		
		try {
			//define variable to read and write to file
			in = new Scanner(new FileInputStream("untested.txt"));
			out = new PrintWriter(new FileOutputStream("tested.txt"));
			
			//if there is more date, continue to read it
			while(in.hasNext()) {
				//input format: MM DD YYYY
				int m, d, y;
				m = in.nextInt();
				d = in.nextInt();
				y = in.nextInt();
				
				//declare and define date
				Date inDate = new Date(m,d,y);
				out.println("Date object constructor for date " + inDate);
				
				//loop through 40 netDay()
				for (int i = 0; i < 40; i++) {
					inDate.nextDay();
					System.out.println("Incremented Date: " + inDate);
					out.println("Incremented Date: " + inDate);
				}
				out.println();
			}
			
			//closing file
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			System.err.println(e);
		}
	}
}
