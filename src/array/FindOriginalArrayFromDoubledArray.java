package array;

public class FindOriginalArrayFromDoubledArray {
    public int[] findOriginalArray(int[] changed) {

        int N = changed.length;
        if(N == 1 || N % 2 == 1) return new int[0];

        int maxNum = Integer.MIN_VALUE;
        for (int j : changed) {
            maxNum = Math.max(maxNum, j);
        }

        int freq[] = new int[2 * maxNum+1];
        for(int i = 0;i<N;i++){
            freq[changed[i]]++;
        }
        int[] original = new int[N/2];
        int index=0;
        for (int currNum =0;currNum<=maxNum;currNum++) {
            if(freq[currNum]>0){
                freq[currNum]--;
                int doubleNum = currNum*2;
                if(freq[doubleNum]>0){
                    freq[doubleNum]--;
                    original[index++]= currNum;
                    currNum--;
                }else{
                    return new int[0];
                }
            }
        }
        return original;
    }

    public static void main(String[] args) {
        int[] changed = new int[] {1,3,4,2,6,8};
        FindOriginalArrayFromDoubledArray fOA = new FindOriginalArrayFromDoubledArray();
        fOA.findOriginalArray(changed);
    }
}
