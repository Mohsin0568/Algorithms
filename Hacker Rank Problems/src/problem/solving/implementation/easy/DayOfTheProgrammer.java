package problem.solving.implementation.easy;

public class DayOfTheProgrammer {

	public static void main(String[] args) {
		System.out.println(dayOfProgrammer(2017));

	}
	
	static String dayOfProgrammer(int year) {
        String leapYear = "12.09."+year;
        String nonLeapYear = "13.09."+year;        
        
        if(year < 1918) {
            if(year % 4 == 0)
                return leapYear;
            else
                return nonLeapYear;
        }

        if(year == 1918) {
            return "26.09.1918";
        }
        else {
            if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
                return leapYear;
            else
                return nonLeapYear;
        }

    }

}
