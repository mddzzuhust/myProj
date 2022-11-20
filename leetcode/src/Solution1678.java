package leetcode;

public class Solution1678 {
    public String interpret(String command) {
        StringBuffer sb = new StringBuffer();
        int index = 0;
        while (index < command.length()) {
            if (index + 1 < command.length() && command.charAt(index) == '(' && command.charAt(index + 1) == ')') {
                sb.append("o");
                index = index + 2;
            } else if (index + 3 < command.length() && command.charAt(index) == '(' && command.charAt(index + 1) == 'a'
                    && command.charAt(index + 2) == 'l' && command.charAt(index + 3) == ')') {
                sb.append("al");
                index = index + 4;
            } else {
                sb.append(command.charAt(index));
                index = index + 1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution1678 s = new Solution1678();
        System.out.println(s.interpret("(al)G(al)()()G"));
    }
}
