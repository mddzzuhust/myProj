package byteDance;

import java.util.Stack;

public class MinStack {
    Stack<Integer> elements=new Stack<Integer>();
    Stack<Integer> mins=new Stack<Integer>();
    int nm=0;
    public void push(int x){
        elements.push(x);
        //System.out.println(elements.peek());
        if(mins.isEmpty()||x<=mins.peek()){
            mins.push(x);
            //nm++;
            //System.out.println(mins.peek());
        }
    }

    public void pop() {
        if(elements.isEmpty()) return;
        int a=elements.peek(),b=mins.peek();
        //System.out.println(a+" "+b);
        if(a==b){
            //System.out.println(nm);
            mins.pop();
            //nm--;
        }
        //System.out.println(nm);
        //System.out.println(mins.peek());
        elements.pop();
    }

    public int top(){
        return elements.peek();
    }

    public int getMin(){
        return mins.peek();
    }
    public static void main(String[] args){
        MinStack m=new MinStack();
        m.push(512);
        m.push(-1024);
        m.push(-1024);
        m.push(512);
        m.pop();
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.getMin());
    }
}
