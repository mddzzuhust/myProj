

import java.util.*;

public class Solution1452 {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> result = new ArrayList<>();
        int n = favoriteCompanies.size();
        Set<String>[] arr = new Set[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new HashSet(favoriteCompanies.get(i));
        }

        for (int i = 0; i < n; i++) {
            boolean mark = true;
            for (int j = 0; j < n; j++) {
                if(i==j)
                    continue;
                if(arr[j].containsAll(arr[i])){
                    mark = false;
                    break;
                }
            }
            if(mark==true){
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution1452 s = new Solution1452();
        List<List<String>> list = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        tmp.add("ovqdyfqmlpxapbjwtssm");
        tmp.add("nxaqhyoprhlhvhyojanr");
        tmp.add("qmsbphxzmnvflrwyvxlc");
        tmp.add("udfuxjdxkxwqnqvgjjsp");
        tmp.add("yawoixzhsdkaaauramvg");
        tmp.add("zycidpyopumzgdpamnty");
        list.add(tmp);
        List<String> tmp1 = new ArrayList<>();
        tmp1.add("nxaqhyoprhlhvhyojanr");
        tmp1.add("ovqdyfqmlpxapbjwtssm");
        tmp1.add("udfuxjdxkxwqnqvgjjsp");
        tmp1.add("yawoixzhsdkaaauramvg");
        tmp1.add("zycidpyopumzgdpamnty");
        list.add(tmp1);
        List<String> tmp2 = new ArrayList<>();
        tmp2.add("ovqdyfqmlpxapbjwtssm");
        tmp2.add("qmsbphxzmnvflrwyvxlc");
        tmp2.add("udfuxjdxkxwqnqvgjjsp");
        tmp2.add("yawoixzhsdkaaauramvg");
        tmp2.add("zycidpyopumzgdpamnty");
        list.add(tmp2);

        List<Integer> list1 = s.peopleIndexes(list);
        System.out.println(list1.size());

    }
}
