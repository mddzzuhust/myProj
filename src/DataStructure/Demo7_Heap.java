package DataStructure;

import java.util.ArrayList;

class Heap_m{
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    private boolean type;
    private Integer mid_i;
    public Heap_m(boolean type){
        this.type = type;
    }

    public void add(int i){
        arrayList.add(i);
        shiftUp(this.arrayList.size()-1);
    }

    public int deleteRoot(){
        int mid_root = this.arrayList.get(0);
        this.mid_i = this.arrayList.get(this.arrayList.size()-1);
        this.arrayList.remove(this.arrayList.size()-1);
        this.arrayList.set(0,this.mid_i);
        shiftDown(0);
        return mid_root;
    }

    public int delet(int index){
        if(index<0||index>this.arrayList.size()-1){
            throw new IndexOutOfBoundsException("删除节点index范围有误");
        }
        int mid_value = this.arrayList.get(index);
        this.mid_i = this.arrayList.get(this.arrayList.size()-1);
        this.arrayList.remove(this.arrayList.size()-1);
        this.arrayList.set(index,this.mid_i);
        shiftDown(index);
        return mid_value;
    }

    private void shiftUp(int index){
        if(type){
            if((index-1)/2!=-1){
                if(this.arrayList.get((index-1)/2)<this.arrayList.get(index)){
                    mid_i = this.arrayList.get((index-1)/2);
                    this.arrayList.set((index-1)/2,this.arrayList.get(index));
                    this.arrayList.set(index,mid_i);
                    shiftUp((index-1)/2);
                }
            }
        }else {
            if((index-1)/2!=-1){
                if(this.arrayList.get((index-1)/2)>this.arrayList.get(index)){
                    mid_i = this.arrayList.get((index-1)/2);
                    this.arrayList.set((index-1)/2,this.arrayList.get(index));
                    this.arrayList.set(index,mid_i);
                    shiftUp((index-1)/2);
                }
            }
        }
    }

    private void shiftDown(int index){
        if(type){
            if(index*2+1<this.arrayList.size()){
                if(this.arrayList.get(2*index+1)>this.arrayList.get(index)){
                    mid_i = this.arrayList.get(2*index+1);
                    this.arrayList.set(2*index+1,this.arrayList.get(index));
                    this.arrayList.set(index,mid_i);
                    shiftDown(2*index+1);
                }
            }
        }else {
            if(index*2+1<this.arrayList.size()){
                if(this.arrayList.get(2*index+1)<this.arrayList.get(index)){
                    mid_i = this.arrayList.get(2*index+1);
                    this.arrayList.set(2*index+1,this.arrayList.get(index));
                    this.arrayList.set(index,mid_i);
                    shiftDown(2*index+1);
                }
            }
        }
    }

    public ArrayList<Integer> getHeap_m(){
        return this.arrayList;
    }
}
public class Demo7_Heap {
    public static void main(String[] args) {
        Heap_m heap_m = new Heap_m(true);
        heap_m.add(5);
        heap_m.add(10);
        heap_m.add(1);
        heap_m.add(7);
        heap_m.add(2);
        System.out.println(heap_m.getHeap_m());
        System.out.println(heap_m.deleteRoot());
        System.out.println(heap_m.getHeap_m());
//heap_m.delet(-1);
    }
}