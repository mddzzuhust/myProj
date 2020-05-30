package DataStructure;

import java.util.List;
import java.util.Vector;

class Queue_m<T>{
    private List<T> stack = new Vector<T>();
    public void add(T t){
        stack.add(t);
    }
    public T offer(){
        int size = stack.size();
        T mid;
        mid = stack.get(0);
        stack.remove(0);
        return mid;
    }
}
public class Demo4_Queue {
    public static void main(String[] args) {
        Queue_m queue_m = new Queue_m();
        queue_m.add("hello");
        queue_m.add("world");
        queue_m.add("Mufass");
        queue_m.add("最后一个push");
        for (int i = 0; i < 4; i++) {
            System.out.println(queue_m.offer());
        }
    }
}