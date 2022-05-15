package dataStructure;

import java.util.List;
import java.util.Vector;

class Stack_m<T>{
    private List<T> stack = new Vector<T>();
    public void push(T t){
        this.stack.add(t);
    }
    public T pop(){
        int size = this.stack.size();
        T mid;
        mid = this.stack.get(size-1);
        this.stack.remove(size-1);
        return mid;
    }
}
public class Demo3_Stack {
    public static void main(String[] args) {
        Stack_m stack_m = new Stack_m();
        stack_m.push("hello");
        stack_m.push("world");
        stack_m.push("Mufasa");
        stack_m.push("最后一个push");
        for (int i = 0; i < 4; i++) {
            System.out.println(stack_m.pop());
        }
    }
}