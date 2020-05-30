package generic;

//此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
//在实例化泛型类时，必须指定T的具体类型
public class Generic<T> {
    //key这个成员变量的类型为T,T的类型由外部指定
    private T key;

    public Generic(){

    }

    public Generic(T key){ //泛型构造方法形参key的类型也为T，T的类型由外部指定
        this.key = key;
    }

    public T getKey(){ //泛型方法getKey的返回值类型为T，T的类型由外部指定
        return key;
    }

    public void showKeyValue1(Generic<? extends Number> obj){
        System.out.println("key value is " + obj.getKey());
    }

    //在泛型方法中添加上下边界限制的时候，必须在权限声明与返回值之间的<T>上添加上下边界，即在泛型声明的时候添加
//public <T> T showKeyName(Generic<T extends Number> container)，编译器会报错："Unexpected bound"
    public <T extends Number> T showKeyName(Generic<T> container){
        System.out.println("container key : " + container.getKey());
        T test = container.getKey();
        return test;
    }

//泛型的上下边界添加，必须与泛型的声明在一起

    public static void main(String[] args) {
//泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
//传入的实参类型需与泛型的类型参数类型相同，即为Integer.
        Generic<Integer> genericInteger = new Generic<Integer>(123456);

//传入的实参类型需与泛型的类型参数类型相同，即为String.
        Generic<String> genericString = new Generic<String>("key_value");
        System.out.println(genericInteger.getKey());
        System.out.println(genericString.getKey());


// 泛型的类型参数只能是类类型，不能是简单类型。
// 不能对确切的泛型类型使用instanceof操作。
        Generic generic = new Generic("111111");
        Generic generic1 = new Generic(4444);
        Generic generic2 = new Generic(55.55);
        Generic generic3 = new Generic(false);

        System.out.println(generic.getKey());
        System.out.println(generic1.getKey());
        System.out.println(generic2.getKey());
        System.out.println(generic3.getKey());

        Generic generic4 = new Generic();
        generic4.showKeyValue1(generic2);
    }
}