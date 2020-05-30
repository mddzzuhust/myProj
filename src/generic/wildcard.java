package generic;

public class wildcard {
    public void showKeyValue(Generic<Number> obj){
        System.out.println(obj.getKey());
    }

    public static void main(String[] args) {
        wildcard wildcard = new wildcard();

        Generic<Integer> gInteger = new Generic<Integer>(123);
        Generic<Number> gNumber = new Generic<Number>(456);

        wildcard.showKeyValue(gNumber);

// showKeyValue这个方法编译器会为我们报错：Generic<java.lang.Integer>
// cannot be applied to Generic<java.lang.Number>
//wildcard.showKeyValue(gInteger);
    }
}