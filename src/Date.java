public class Date {
	int month, day, year;
	int limit[] = { 0, 31, 28, 31, 30, 31, 30, 31, 30, 30, 31, 30, 31 };

	Date() {
		setall(1, 1, 2000);
		System.out.println("Date object constructor for date " + toString());
	}

	Date(int m, int d, int y) {
		setall(m, d, y);
		System.out.println("Date object constructor for date " + toString());
	}

	public void setall(int m, int d, int y) {
		setYear(y);
		setMonth(m);
		setDay(d);
	}

	public void nextDay() {
		setDay(++day);
	}

	public void setMonth(int m) {
		if (m > 0 && m <= 12)
			month = m;
		else if (m > 0 && m > 12) {
			month = 1;
			setYear(++year);
		}
	}

	public void setDay(int d) {
		checkLeapYear(year);
		if (d > 0 && d <= limit[month])
			day = d;
		else if (d > 0 && d > limit[month]) {
			day = 1;
			setMonth(++month);
		}
	}

	public void setYear(int y) {
		if (y >= 0 && y <= 2100)
			year = y;
		else
			year = 2000;
	}

	public void checkLeapYear(int y) {
		if (y % 4 == 0) {
			limit[2] = 29;
			if (y % 100 == 0)
				limit[2] = 28;
			if (y % 400 == 0)
				limit[2] = 29;
		}
	}

	@Override
	public String toString() {
		return (month + "/" + day + "/" + year);
	}
}
