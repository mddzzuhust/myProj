import java.util.ArrayList;
import java.util.List;

public class StringSubSet {
    public List<String> subset(String s){
        List<String> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s.charAt(0));
        for(int i=1; i< s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                continue;
            }
            stringBuilder.append(s.charAt(i));
        }
        backtrack(result, new StringBuilder(),stringBuilder.toString(),0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder tempBuilder,String s, int start){
        result.add(tempBuilder.toString());
        for(int i=start;i<s.length();i++){
            tempBuilder.append(s.charAt(i));
            backtrack(result,tempBuilder,s,i+1);
            tempBuilder.deleteCharAt(tempBuilder.length()-1);
        }
    }

    public static void main(String[] args) {
        StringSubSet stringSubSet = new StringSubSet();
        List<String> result = stringSubSet.subset("aabbccdd");//abcd
        for(String string : result){
            System.out.println(string);
        }
    }
}
