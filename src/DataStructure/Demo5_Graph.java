package DataStructure;

import java.util.LinkedList;
import java.util.Vector;

class Graph_m1{
    private Vector<Vector<Integer>> graph = new Vector<Vector<Integer>>();
    private Vector<Integer> midVector;
    public Graph_m1(){ }
    public void add(Vector<Integer> midVector){
        this.graph.add(midVector);
    }
    public void add(int index1, Vector<Integer> midVector){
        this.graph.add(index1,midVector);
    }
    public void add(int index1,int t){
        midVector = graph.get(index1);
        midVector.add(t);
        graph.set(index1,midVector);
    }
    public void add(int index1,int index2,int t){
        midVector = graph.get(index1);
        midVector.add(index2,t);
        graph.set(index1,midVector);
    }
    public void set(int index1,int index2,int t){
        midVector = graph.get(index1);
        midVector.set(index2,t);
        graph.set(index1,midVector);
    }
    public int get(int index1,int index2){
        midVector = graph.get(index1);
        return midVector.get(index2);
    }
    public void getAll(){
        for(Vector<Integer> temp:graph){
            for(Integer temp1:temp){
                System.out.println(temp1+",");
            }
            System.out.println(" ");
        }
    }
}
class Graph_m2<T>{
    private LinkedList<LinkedList<T>> graph = new LinkedList<LinkedList<T>>();
    private LinkedList<T> midLinkedList;
    public void add(LinkedList<T> midLinkedList){
        this.graph.add(midLinkedList);
    }
    public void add(int index1,LinkedList<T> midLinkedList){
        this.graph.add(index1,midLinkedList);
    }
    public void getAll(){
        for(LinkedList<T> temp:this.graph){
            for(T temp1:temp){
                System.out.println(temp1+",");
            }
            System.out.println();
        }
    }
}
public class Demo5_Graph {
    public static void main(String[] args) {
        Graph_m2 graph = new Graph_m2();
        LinkedList<Integer> linkedList;
        for (int i = 0; i < 3; i++) {
            linkedList = new LinkedList<Integer>();
            for (int j = 0; j < 5; j++) {
                linkedList.add(j+i);
            }
            graph.add(linkedList);
        }
        graph.getAll();
    }
}