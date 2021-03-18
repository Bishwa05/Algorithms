package dfs;

/**
 * A Strobogrammatic number is a number that looks the same
 * when rotated 180 degree(looked at upside down)
 *
 * Example
 * Input : low = 50, high = 100
 * Output : 3
 * Explaination : 69, 88, 96
 */
public class StrobogrammaticNumberIII
{
    private static final char[][] pairs = {{'0','0'},
                                           {'1', '1'},
                                           {'8', '8'},
                                           {'6','9'},
                                           {'9', '6'}};

    public int strobogramaticInRange(String low, String high){
        int[] count = new int[1];
        for(int i = low.length(); i<= high.length(); i++){
            dfs(i, 0, new char[i], Long.parseLong(low),
                Long.parseLong(high), count);
        }
        return count[0];
    }

    private void dfs(int i, int left, char[] number,
                     long low, long high, int[] count){
        if(left > i-1 -left){
            String s = new String(number);
            long n = Long.parseLong(s);
            if(low<=n && n<= high){
                count[0]++;
            }
            return;
        }

        for(char[] pair : pairs){
            if(pair[0] =='0' && (left ==0 && i != 1)){
                continue;
            }
            if(left == i-1-left && pair[0] != pair[1]){
                continue;
            }
            number[left] = pair[0];
            number[i-1-left] = pair[1];
            dfs(i, left+1, number, low, high, count);
        }
    }

    public static void main(String arg[]){
        StrobogrammaticNumberIII s = new StrobogrammaticNumberIII();
        System.out.println(s.strobogramaticInRange("50", "100"));
    }
}
