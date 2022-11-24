

public class Solution1410 {
    public String entityParser(String text) {
        text = text.replaceAll("&quot;","\\\\\"");
        text = text.replaceAll("&apos;","'");
        text = text.replaceAll("&amp;","&");
        text = text.replaceAll("&gt;",">");
        text = text.replaceAll("&lt;","<");
        text = text.replaceAll("&frasl;","/");
        return text;
    }

    public static void main(String[] args) {
        Solution1410 s= new Solution1410();
        String str = "and I quote: &quot;...&quot;";
        System.out.println(s.entityParser(str));
    }
}
