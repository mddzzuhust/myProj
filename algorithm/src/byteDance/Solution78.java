package byteDance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution78 {
    boolean[] f;
    List<List<Integer>> list;
    public List<List<Integer>> subsets(int[] nums) {
        list = new ArrayList<List<Integer>>();

        if(nums.length == 0){//必须是有效k值
            return list;
        }
        f = new boolean[nums.length];

        for(int i = 0; i <= nums.length;i++){
            count(nums,"",i,0);//调用函数
        }

        return list;
    }
    /**
     * 实现对k个数字的排练组合
     * @param a 数组
     * @param s 排练组合得到的结果
     * @param nn 排练组合的数字个数
     */
    private void count(int[] a,String s,int nn,int j){
        if(nn == 0){//处理结果
            String[] sa = s.split(",");//分割数组
            List<Integer> al = new ArrayList<Integer>();
            for(int i = 0;i < sa.length; i++){
                if(sa[i].length() > 0)//只有当不为空的时候才添加
                    al.add(Integer.parseInt(sa[i]));//添加
            }
            Collections.sort(al);//排序，非降序
            list.add(al);
            return;
        }
        //遍历,从i=j开始，只要i开头的与i大的值
        for(int i = j; i < a.length; i++){
            if(!f[i]){
                f[i] = true;
                count(a,s + "," + a[i],nn-1,i+1);//调用下一个为false的数字
                f[i] = false;
            }
        }
    }
}
