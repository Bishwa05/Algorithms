package unionfind;

import java.util.*;

/**
 * Leetcode 721. Accounts Merge
 *
 * Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.
 *
 * After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
 *
 * Input:
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * Explanation:
 * The first and third John's are the same person as they have the common email "johnsmith@mail.com".
 * The second John and Mary are different people as none of their email addresses are used by other accounts.
 * We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 *
 *
 */
public class AccountsMerge
{
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> g = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        buildGraph(g, emailToName, accounts);

        List<List<String>> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        for(String mail : emailToName.keySet()){
            if(visited.add(mail)){
              List<String> list = new ArrayList<>();
              list.add(mail);
              dfs(g, list, mail, visited);
              Collections.sort(list);
              list.add(0, emailToName.get(mail));
              result.add(list);
            }
        }
        return result;
    }

    private void buildGraph(Map<String, Set<String>>g, Map<String, String> emailToName, List<List<String>>accounts) {
        for(List<String> a: accounts){
            String name = a.get(0);

            for(int i =1; i<a.size(); i++){
                String mail = a.get(i);
                emailToName.put(mail, name);
                g.putIfAbsent(mail, new HashSet<>());

                if(i ==1) continue;
                String prev = a.get(i-1);
                g.get(prev).add(mail);
                g.get(mail).add(prev);
            }
        }
    }


    private void dfs(Map<String, Set<String>>g, List<String> list,
                     String mail, Set<String> visited){
        if(g.get(mail) == null || g.get(mail).size() ==0) return;

        for(String neighbour : g.get(mail)){
            if(visited.add(neighbour)){
                list.add(neighbour);
                dfs(g, list, neighbour, visited);
            }
        }
    }
}
