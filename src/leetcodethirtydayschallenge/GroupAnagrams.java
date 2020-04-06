package leetcodethirtydayschallenge;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> checkString = new HashMap<>();


        for (String str : strs) {
            char alphabet[] = new char[26];
            for (int i = 0; i < str.length(); i++) {
                alphabet[str.charAt(i) - 97]++;
            }

            String keyStr = new String(alphabet);

            if (checkString.containsKey(keyStr)) {
                checkString.get(keyStr).add(str);
            } else {
                ArrayList x = new ArrayList();
                x.add(str);
                checkString.put(keyStr, x);
            }
        }
        result.addAll(checkString.values());
        return result;
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) return result;
        String[] sb = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            sb[i] = sortString(strs[i]);
        }
        HashMap<String, Integer> search = new HashMap<>();
        int index = -1;
        for (int i = 0; i < strs.length; i++) {
            if (search.containsKey(sb[i])) result.get(search.get(sb[i])).add(strs[i]);
            else {
                index++;
                search.put(sb[i], index);
                result.add(new ArrayList<String>());
                result.get(index).add(strs[i]);
            }
        }
        return result;

    }

    public static String sortString(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }


    public static void main(String arg[]) {
        String arr[] = {"eat", "tea", "tan", "ate", "nat", "bat"};

        groupAnagrams(arr).forEach(e -> e.forEach(e1 ->System.out.println(e1)));

        //This is the faster approach
        groupAnagrams2(arr).forEach(e -> e.forEach(e1 ->System.out.println(e1)));

    }
}
