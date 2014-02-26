import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class DateTest {
	public static void main(String args[]) {
		Scanner in = null;
		PrintWriter out = null;
		
		try {
			in = new Scanner(new FileInputStream("untested.txt"));
			out = new PrintWriter(new FileOutputStream("tested.txt"));
			
			while(in.hasNext()) {
				//input format: MM DD YYYY
				int m, d, y;
				m = in.nextInt();
				d = in.nextInt();
				y = in.nextInt();
				
				Date inDate = new Date(m,d,y);

				for (int i = 0; i < 40; i++) {
					inDate.nextDay();
					System.out.println("Incremented Date: " + inDate);
					out.println(inDate);
				}
			}
			
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.toString());
		}
	}
}
