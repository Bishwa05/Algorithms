package backtrack;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;


class Schedules
{

    /*
     * Complete the 'findSchedules' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER workHours
     *  2. INTEGER dayHours
     *  3. STRING pattern
     */

    /**

     */

    public static List<String> findSchedules(int workHours, int dayHours, String pattern) {
        // Write your code here
        int arr[] = new int[pattern.length()];

        List<String> result = new ArrayList<>();

        int providedhours = 0;
        for(int i =0; i<pattern.length(); i++){
            char ch = pattern.charAt(i);
            if(ch==63){
                arr[i] = -1;
            } else{
                int hr = ch-48;
                providedhours +=hr;
                arr[i] = hr;
            }
        }

        // for(int x : arr){
        //     System.out.println(x);
        // }
        Set<String> unique = new HashSet<>();
        findAllSchedule(arr, dayHours, workHours-providedhours, result,unique);
        Collections.sort(result);
        return result;
    }

    public static void findAllSchedule(int[] arr, int dayHours, int remainingHours, List<String> result, Set<String> unique){
        // System.out.println("Remaining "+remainingHours);
        //if(remainingHours<0) return;
        if(remainingHours <=0) {
            StringBuilder sb = new StringBuilder();
            for(int x : arr){
                if(x !=-1){
                    sb.append(x);
                } else{
                    sb.append("0");
                }
            }
            if(unique.add(sb.toString()))
                result.add(sb.toString());
            return;
        }

        for(int i =0; i< arr.length; i++){
            if(arr[i] == -1){
                arr[i] = (remainingHours>dayHours)?  dayHours: remainingHours;
                findAllSchedule(arr, dayHours, remainingHours-dayHours, result, unique);
                arr[i] = -1;
            }
        }

    }




    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int workHours = Integer.parseInt(bufferedReader.readLine().trim());

        int dayHours = Integer.parseInt(bufferedReader.readLine().trim());

        String pattern = bufferedReader.readLine();

        List<String> result = Schedules.findSchedules(workHours, dayHours, pattern);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
                + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
