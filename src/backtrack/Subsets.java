package backtrack;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List interimList = new ArrayList();
        findSubset(0, nums.length, interimList, nums);
        return result;
    }

    public void findSubset(int start, int end, List interimList, int[] nums) {
        result.add(interimList);

        for(int i=start; i<end; i++) {
            interimList.add(nums[i]);
            findSubset(i+1, end, interimList, nums);
            interimList.remove(interimList.size()-1);
        }
    }

    public static void main(String arg[]) {
        Subsets s = new Subsets();
        int[] arr = {1,2,3};
        List<List<Integer>> l = s.subsets(arr);
        l.forEach(u -> {u.forEach(r-> System.out.print(r));
        System.out.println();
            });
    }
}
