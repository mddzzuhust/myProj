package sort;

//桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。
//
//桶排序 (Bucket sort)的工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，
//每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排

import java.util.ArrayList;

//算法描述
//人为设置一个BucketSize，作为每个桶所能放置多少个不同数值（例如当BucketSize==5时，该桶可以存放｛1,2,3,4,5｝这几种数字，
//但是容量不限，即可以存放100个3）；
//遍历输入数据，并且把数据一个一个放到对应的桶里去；
//对每个不是空的桶进行排序，可以使用其它排序方法，也可以递归使用桶排序；
//从不是空的桶里把排好序的数据拼接起来。
//注意，如果递归使用桶排序为各个桶排序，则当桶数量为1时要手动减小BucketSize增加下一循环桶的数量，否则会陷入死循环，导致内存溢出。

//算法分析
//桶排序最好情况下使用线性时间O(n)，桶排序的时间复杂度，取决与对各个桶之间数据进行排序的时间复杂度，
//因为其它部分的时间复杂度都为O(n)。很显然，桶划分的越小，各个桶之间的数据越少，排序所用的时间也会越少。
//但相应的空间消耗就会增大。
//
//最佳情况：T(n) = O(n+k)
//最差情况：T(n) = O(n+k)
//平均情况：T(n) = O(n2)
public class BucketSort {
    public static ArrayList<Integer> BucketSort(ArrayList<Integer> array, int bucketSize){
        if(array==null||array.size()<2)
            return array;
        int max = array.get(0),min = array.get(0);
        for (int i = 0; i < array.size(); i++) {
            if(array.get(i)>max)
                max = array.get(i);
            if(array.get(i)<min)
                min = array.get(i);
        }

        int bucketCount = (max-min)/bucketSize+1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < array.size(); i++) {
            bucketArr.get((array.get(i)-min)/bucketSize).add(array.get(i));
        }
        for (int i = 0; i < bucketCount; i++) {
            if(bucketSize==1){
                for (int j = 0; j < bucketArr.get(i).size(); j++) {
                    resultArr.add(bucketArr.get(i).get(j));
                }
            }else {
                if(bucketCount==1)
                    bucketSize--;
                ArrayList<Integer> temp = BucketSort(bucketArr.get(i),bucketSize);
                for (int j = 0; j < temp.size(); j++) {
                    resultArr.add(temp.get(j));
                }
            }
        }
        return resultArr;
    }

    public static void main(String[] args) {
        int[] array = new int[]{5,4,3,2,1};
        BucketSort bucketSort = new BucketSort();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        ArrayList<Integer> result = bucketSort.BucketSort(list,2);

        for (int j = 0; j < result.size(); j++) {
            System.out.printf(result.get(j)+" ");
        }
    }
}
