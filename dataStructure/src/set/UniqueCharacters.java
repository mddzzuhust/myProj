package set;
//给定一个字符串，找出所有独特的字符
import java.util.HashSet;
import java.util.Set;

public class UniqueCharacters {
    public static void main(String[] args) {
        String str = "abcdeffghijk";
        Set<Character> charSet = new HashSet<>();
        for (char c : str.toCharArray()) {
            charSet.add(c);
        }

        for (char c : charSet) {
            System.out.print(c + " ");
        }
    }
}
