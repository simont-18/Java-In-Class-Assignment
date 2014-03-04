public class Date {
	//private member data type
	private int month, day, year;
	private int limit[] = { 0, 31, 28, 31, 30, 31, 30, 31, 30, 30, 31, 30, 31 };

	//constructor
	Date() {
		setall(1, 1, 2000);
		System.out.println("Date object constructor for date " + toString());
	}

	Date(int m, int d, int y) {
		setall(m, d, y);
		System.out.println("Date object constructor for date " + toString());
	}

	//set all private variable
	private void setall(int m, int d, int y) {
		setYear(y);
		setMonth(m);
		setDay(d);
	}

	//increment to the nextDay
	public void nextDay() {
		setDay(++day);
	}

	//check parameter and then set month
	private void setMonth(int m) {
		if (m > 0 && m <= 12)
			month = m;
		else if (m > 0 && m > 12) {
			month = 1;
			setYear(++year);
		} else if(m <= 0)
			month = 1;
	}

	//check parameter and then set day
	private void setDay(int d) {
		checkLeapYear(year);
		if (d > 0 && d <= limit[month])
			day = d;
		else if (d > 0 && d > limit[month]) {
			int inc = d - limit[month];
			day = 0;
			setMonth(++month);
			for(int i = 0; i < inc; i++)
				setDay(++day);
		} else if(d <= 0)
			day = 1;
	}

	//check parameter and then set year
	private void setYear(int y) {
		if (y >= 0 && y <= 2500)
			year = y;
		else
			year = 2000;
		checkLeapYear(year);
	}

	//check year to determine if Feb have 28 or 29 days
	private void checkLeapYear(int y) {
		if (y % 4 == 0) {
			limit[2] = 29;
			if (y % 100 == 0) {
				limit[2] = 28;
				if (y % 400 == 0)
					limit[2] = 29;
			}
		} else
			limit[2] = 28;
	}

	@Override
	public String toString() {
		return (month + "/" + day + "/" + year);
	}
}
