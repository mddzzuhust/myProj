package string;

public class StringComparison {
    public static void main(String[] args) {
        // 使用字符串字面量创建字符串对象 str1
        String str1 = "Hello";
        // 使用 new 关键字创建字符串对象 str2
        String str2 = new String("Hello");
        // 使用字符串字面量拼接创建字符串对象 str3
        String str3 = "He" + "llo";
        // 使用字符串字面量和 new 关键字创建的字符串拼接创建字符串对象 str4
        String str4 = "He" + new String("llo");

        // 比较 str1 和 str2 的引用是否相等
        System.out.println(str1 == str2);
        // 比较 str1 和 str3 的引用是否相等
        System.out.println(str1 == str3);
        // 比较 str1 和 str4 的引用是否相等
        System.out.println(str1 == str4);
    }
}

/*
str1 == str2: == 运算符在比较引用类型时，比较的是两个对象的引用是否相等，即它们是否指向同一个内存地址。str1 是通过字符串字面量创建的，它会被存储在字符串常量池中；而 str2 是通过 new 关键字创建的，它会在堆内存中创建一个新的对象。因此，str1 和 str2 指向不同的内存地址，str1 == str2 的结果为 false。
str1 == str3: 由于 Java 编译器在编译时会对字符串字面量的拼接进行优化，将 "He" + "llo" 直接拼接成 "Hello"。所以 str3 实际上也指向字符串常量池中的 "Hello" 对象，与 str1 指向同一个内存地址，str1 == str3 的结果为 true。
str4 == str1: str4 是通过字符串字面量 "He" 和 new String("llo") 拼接而成的。由于 new String("llo") 会在堆内存中创建一个新的对象，拼接后的 str4 也会在堆内存中创建一个新的对象，而不是从字符串常量池中获取。因此，str4 和 str1 指向不同的内存地址，str1 == str4 的结果为 false。/
 */
