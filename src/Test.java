public class Test {
    public static void main(String[] args) {
        String str = "Search and preview millions of books from libraries and publishers worldwide using Google Book Search.";
        String[] strings = str.split("[ ,.]");
        for (String item:strings){
            System.out.println(item);
        }

        System.out.println("".split("\\|").toString());
    }
}
