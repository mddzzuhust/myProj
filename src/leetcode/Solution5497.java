package leetcode;

public class Solution5497 {
    public int findLatestStep(int[] arr, int m) {
        int pos = -1;
        StringBuilder sbl = new StringBuilder();
        StringBuilder sbr = new StringBuilder();
        sbr.append("0");
        StringBuilder sbm = new StringBuilder();
        sbm.append("0");
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append("1");
            sbl.append("1");
            sbr.append("1");
            sbm.append("1");
        }
        sbl.append("0");
        sbm.append("0");
        for (int i = 0; i < arr.length; i++) {
            res.append("0");
        }
        String mark = sb.toString();
        for (int i = 0; i < arr.length; i++) {
            res.replace(arr[i]-1,arr[i],"1");
            String tmp = res.toString();
            int indexl = tmp.indexOf(sbl.toString());
            if(indexl==0){
                pos = i+1;
            }
            int indexr = tmp.indexOf(sbr.toString());
            if(indexr!=-1&&(indexr+sbr.toString().length()==tmp.length())){
                pos = i+1;
            }
            int indexm = tmp.indexOf(sbm.toString());
            if(indexm>=0&&(indexm+sbm.toString().length()<=tmp.length())){
                pos = i+1;
            }
            int index = tmp.indexOf(sb.toString());
            if(index==0&&(index+sb.toString().length()==tmp.length())){
                pos = i+1;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        Solution5497 s = new Solution5497();
        int[] arr = new int[]{2,1};
        int m =2;
        System.out.println(s.findLatestStep(arr,m));
        System.out.println();
    }
}
