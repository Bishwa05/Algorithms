package date;

public class DaysBetweenDates {
    public static final int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // A helper method to convert a date to an integer in the form of YYYYMMDD
    public static int dateToInt(int year, int month, int day) {
        return year * 10000 + month * 100 + day;
    }

    // A helper method to find the number of days between two dates
    public static int daysBetween(int year1, int month1, int day1, int year2, int month2, int day2) {
        // Convert the dates to integers
        int date1 = dateToInt(year1, month1, day1);
        int date2 = dateToInt(year2, month2, day2);

        // Swap the dates if the first date is later than the second date
        if (date1 > date2) {
            int temp = date1;
            date1 = date2;
            date2 = temp;
        }

        // Find the difference in days without considering the month and year boundaries
        int diff = date2 - date1;

        // Find the number of days in the full years between the dates
        int daysInYears = diff / 10000 * 365;

        // Find the difference in months between the dates
        int diffInMonths = diff % 100;

        // Find the number of days in the months between the dates
        int daysInMonths = 0;
        for (int i = month1; i < month2; i++) {
            daysInMonths += DAYS_IN_MONTH[i - 1];
            // Add one extra day for February if it is a leap year
            if (i == 2 && isLeapYear(year1)) {
                daysInMonths++;
            }
        }

        // Find the number of days in the first and last months
        int daysInFirstAndLastMonth = 0;
        daysInFirstAndLastMonth -= day1;
        daysInFirstAndLastMonth += day2;
        // Add one extra day for February if it is a leap year and the second date is later than the 28th
        if (month2 == 2 && isLeapYear(year2) && day2 > 28) {
            daysInFirstAndLastMonth++;
        }

        // Add the results of the previous steps
        int daysBetween = daysInYears + daysInMonths + daysInFirstAndLastMonth;

        // Return the final result
        return daysBetween;
    }

    public static void main(String[] args) {
        // Test the method with some sample dates
        System.out.println(daysBetween(2024, 2, 23, 2024, 3, 15)); // 21
        System.out.println(daysBetween(2020, 2, 29, 2021, 3, 1)); // 366
        System.out.println(daysBetween(2019, 12, 31, 2020, 1, 1)); // 1
        System.out.println(daysBetween(2000, 1, 1, 1999, 12, 31)); // 1
    }
}
