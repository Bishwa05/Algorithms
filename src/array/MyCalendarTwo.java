package array;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarTwo
{
    List<int[]> events = new ArrayList<>();
    List<int[]> overlaps = new ArrayList<>();

    public MyCalendarTwo(){}

    public boolean book(int start, int end){
        if(start<0 || end<0 || start> end){
            return true;
        }

        for(int[] overlap : overlaps){
            if(overlap[0]< end && overlap[1]>start){
                return false;
            }
        }

        for(int[] event: events){
            if(event[0] < end && event[1]> start){
                overlaps.add(new int[]{Math.max(event[0], start),
                                       Math.min(event[1], end)});
            }
        }
        events.add(new int[]{start, end});
        return true;
    }
}
