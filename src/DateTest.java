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
			
			//input format: MM/DD/YYYY
			int m, d, y;
			String info = in.nextLine();
			m = Integer.parseInt(info.substring(0,2));
			d = Integer.parseInt(info.substring(3,5));
			y = Integer.parseInt(info.substring(6,10));
			
			Date InDate = new Date(m,d,y);

			for (int i = 0; i < 40; i++) {
				InDate.nextDay();
				System.out.println("Incremented Date: " + InDate);
				out.println(InDate);
			}

			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.toString());
		}
	}
}
