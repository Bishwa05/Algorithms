package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Input  : 3
 *          1 2 2
 * Output : 4
 * All temples must receive at-least one offering.
 * Now, the second temple is at a higher altitude
 * compared to the first one. Thus it receives one
 * extra offering.
 * The second temple and third temple are at the
 * same height, so we do not need to modify the
 * offerings. Offerings given are therefore: 1, 2,
 * 1 giving a total of 4.
 *
 * Input  : 6
 *          1 4 3 6 2 1
 * Output : 10
 * We can distribute the offerings in the following
 * way, 1, 2, 1, 3, 2, 1. The second temple has to
 * receive more offerings than the first due to its
 * height being higher. The fourth must receive more
 * than the fifth, which in turn must receive more
 * than the sixth. Thus the total becomes 10.
 *
 */
class Temple {
    int left;
    int right;

    Temple(int l, int r){
        left = l;
        right =r;
    }
}

public class TempleOfferings {


    static int offeringNumber(int[] templeHeight) {
        int n = templeHeight.length;
            List<Temple> templeArr = new ArrayList();

        for (int i=0; i<n; i++) {
            Temple t = new Temple(-1,-1);
            templeArr.add(t);
        }

        templeArr.get(0).left =1;
        templeArr.get(n-1).right =1;

        // Filling left and right values using same
        // values of previous(or next)
        for (int i=1; i<n; ++i)
        {
            if (templeHeight[i - 1] < templeHeight[i])
                templeArr.get(i).left = templeArr.get(i - 1).left + 1;
            else
                templeArr.get(i).left = 1;
        }

        for (int i=n-2; i>=0; --i)
        {
            if (templeHeight[i + 1] < templeHeight[i])
                templeArr.get(i).right = templeArr.get(i+1).right + 1;
            else
                templeArr.get(i).right = 1;
        }

        // Computing max of left and right for all
        // temples and returning sum.
        int sum = 0;
        for (int i = 0; i < n; ++i)
            sum += Math.max(templeArr.get(i).left, templeArr.get(i).right);
        return sum;

    }
    public static void main(String arg[]) {
        int arr1[] = {1, 2, 2};
        System.out.println(offeringNumber(arr1));

        int arr2[] = {1, 4, 3, 6, 2, 1};
        System.out.println(offeringNumber(arr2));
    }

}
