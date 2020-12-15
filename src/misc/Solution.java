package misc;
// you can also use imports, for example:
// import java.util.*;
import java.util.*;
/**

 t=2
 1 1 1 0
 1 1 1 1
 1 1 1 1
 1 1 1 1


 **/


public class Solution
{

    static int dArr[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    // 12/12/2020 + 100  = 22/03/2021
    public static Date nextDate (Date d, int days)
    {

        // int yearI = (days>365)? days/365: 0;
        // days = days%365;//TODO: for 366

        if (days == 0)
            return d;

        int dDate = d.getDate(); //12
        int mDate = d.getMonth(); //12
        int yDate = d.getYear(); // 2020

        int cDate = dArr[mDate - 1]; //dDate= 31

        int finalDate = 0;
        int finalMonth = mDate;
        int finalYear = yDate;

        if (cDate < dDate) {
            days = cDate - dDate;
        }
        else {
            finalDate = dDate + days;
            Date lessD = new Date();
            lessD.setDate(finalDate);
            lessD.setMonth(finalMonth);
            lessD.setYear(finalYear);
            return lessD;
        }

        int monthConsidered = mDate + 1;

        if (mDate == dArr.length) {
            monthConsidered = 0;
            finalYear += 1;
        }

        while (days > 0) {
            for (int i = monthConsidered; i < dArr.length; i++) {
                if (days == 0) {
                    finalMonth = i;
                    finalDate = 1;
                }
                if (days > dArr[i]) {
                    days -= dArr[i];
                }
                else {
                    finalDate = dArr[i] - days;
                    finalMonth = i;
                }
            }
        }

        Date x = new Date();
        x.setDate(finalDate);
        x.setMonth(finalMonth);
        x.setYear(finalYear);

        return x;

    }

    public static void main (String[] args)
    {
        Date d = new Date();
        System.out.println(nextDate(d, 100));
        // you can write to stdout for debugging purposes, e.g.
        System.out.println("This is a debug message");
    }

}