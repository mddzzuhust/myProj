

import java.util.*;

public class ThroneInheritance {
    HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
    Set<String> set_dead = new HashSet<>();
    String kingname;

    public ThroneInheritance(String kingName) {
        this.kingname = kingName;
        hashMap.put(kingName, new ArrayList<>());
    }

    public void birth(String parentName, String childName) {
        if(hashMap.containsKey(parentName)){
            hashMap.get(parentName).add(childName);
        }else {
            ArrayList temp = new ArrayList();
            temp.add(childName);
            hashMap.put(parentName,temp);
        }
    }

    public void death(String name){
        set_dead.add(name);
    }

    public List<String> getInheritanceOrder(){
        ArrayList<String> res = new ArrayList<>();
        if(!set_dead.contains(kingname))
            res.add(kingname);
        dfs(kingname,res);
        return res;
    }

    private void dfs(String name,ArrayList<String> res){
        if(!hashMap.containsKey(name))
            return;
        ArrayList<String> childs = hashMap.get(name);
        for(String c:childs){
            if(!set_dead.contains(c))
                res.add(c);
            dfs(c,res);
        }
    }
}
