package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of characters where each character represents
 * a fruit tree, you are given two baskets and your goal is to put
 * maximum number of fruits in each basket. The only restriction
 * is that each basket can have only one type of fruit.
 *
 * Input: Fruit=['A', 'B', 'C', 'A', 'C']
 * Output: 3
 * Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
 *
 */
public class FruitIntoBasket
{
    public static int findLength(char[] arr){
        int windowStart =0, maxLength =0;
        Map<Character, Integer> fruitFrequencyMap = new HashMap<>();
        for(int windowEnd =0; windowEnd< arr.length; windowEnd++){
            fruitFrequencyMap.put(arr[windowEnd], fruitFrequencyMap.getOrDefault(arr[windowEnd],0) +1);

            while(fruitFrequencyMap.size()>2){
                fruitFrequencyMap.put(arr[windowStart], fruitFrequencyMap.get(arr[windowStart])-1);
                if(fruitFrequencyMap.get(arr[windowStart])==0){
                    fruitFrequencyMap.remove(arr[windowStart]);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd-windowStart+1);
        }

        return maxLength;
    }

    public static void main(String arg[]){
        FruitIntoBasket  f = new FruitIntoBasket();
        System.out.println(
            f.findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'})
        );
    }
}
