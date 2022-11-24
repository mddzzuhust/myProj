

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution399 {
    private Map<String, String> parents = new HashMap<>();
    private Map<String, Double> values = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String e = queries.get(i).get(0);
            String q = queries.get(i).get(1);

            if(!(parents.containsKey(e)&&parents.containsKey(q))){
                result[i] = -1;
                continue;
            }

            if(e.equals(q)){
                result[i] = 1;
                continue;
            }

            String r1 = root(e);
            String r2 = root(q);

            if(!r1.equals(r2)){
                result[i] = -1;
                continue;
            }

            result[i] = pm(q)/pm(e);
        }
        return result;
    }

    private void union(String parent, String child, double value) {
        add(parent);
        add(child);
        String r1 = root(parent);
        String r2 = root(child);
        if(!r1.equals(r2)){
            parents.put(r2,r1);
            values.put(r2,value*(pm(parent)/pm(child)));
        }
    }

    private void add(String x){
        if(!parents.containsKey(x)){
            parents.put(x,x);
            values.put(x,1.0);
        }
    }

    private String root(String x){
        while (!parents.get(x).equals(x)){
            x = parents.get(x);
        }
        return x;
    }

    private double pm(String x){
        double v = 1;
        while (!parents.get(x).equals(x)){
            v *= values.get(x);
            x = parents.get(x);
        }
        return v;
    }
}
