package generic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddDaysToDate
{
    public static void main(String args[]){
        String oldDate = "2021-01-29";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(oldDate));
        } catch(ParseException e){
            e.printStackTrace();
        }
        c.add(Calendar.DAY_OF_MONTH, 7);

        String newDate = sdf.format(c.getTime());
        System.out.println("Date after add"+ newDate);
    }
}
