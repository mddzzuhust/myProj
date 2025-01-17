public class Solution3019 {
    public int countKeyChanges(String s) {
        if(s.length() == 1 ){
            return 0;
        }
        int count = 0;
        s = s.toLowerCase();
        for (int i = 1; i < s.length(); i++) {
            char prechar = s.charAt(i - 1);
            char currentChar = s.charAt(i);
            if(prechar != currentChar){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution3019 solution = new Solution3019();
        System.out.println(solution.countKeyChanges("AaAaAaaA"));
    }
}
