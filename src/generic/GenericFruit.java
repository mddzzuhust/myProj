package generic;

public class GenericFruit {

    class Fruit{
        @Override
        public String toString(){
            return "fruit";
        }
    }

    class Apple extends Fruit{
        @Override
        public String toString(){
            return "apple";
        }
    }

    class Person{
        @Override
        public String toString(){
            return "Person";
        }
    }

    class GenerateTest<T>{
        public void show_1(T t){
            System.out.println(t.toString());
        }

        //在泛型类中声明了一个泛型方法，使用泛型E，这种泛型E可以为任意类型。可以类型与T相同，也可以不同。
//由于泛型方法在声明的时候会声明泛型<E>，因此即使在泛型类中并未声明泛型，编译器也能够正确识别泛型方法中识别的泛型。
        public <E> void show_3(E t){
            System.out.println(t.toString());
        }

        //在泛型类中声明了一个泛型方法，使用泛型T，注意这个T是一种全新的类型，可以与泛型类中声明的T不是同一种类型。
        public <T> void show_2(T t){
            System.out.println(t.toString());
        }
    }

    public <T> void printMsg(T... args){
        for (T t : args){
            System.out.println("t is " + t);
        }
    }
    /**
     * 如果在类中定义使用泛型的静态方法，需要添加额外的泛型声明（将这个方法定义成泛型方法）
     * 即使静态方法要使用泛型类中已经声明过的泛型也不可以。
     * 如：public static void show(T t){..},此时编译器会提示错误信息：
     "StaticGenerator cannot be refrenced from static context"
     */
    public static <T> void show(T t){

    }

    public static void main(String[] args) {
        GenericFruit genericFruit = new GenericFruit();
        genericFruit.printMsg("111",222,"aaaa","2323.4",55.55);


// 无论何时，如果你能做到，你就该尽量使用泛型方法。也就是说，如果使用泛型方法将整个类泛型化，
//
// 那么就应该使用泛型方法。另外对于一个static的方法而已，无法访问泛型类型的参数。
//
// 所以如果static方法要使用泛型能力，就必须使其成为泛型方法。
    }
}