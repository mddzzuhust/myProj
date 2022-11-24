

public class Solution593 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if(isSame(p1,p2)||isSame(p1,p3)||isSame(p1,p4)||isSame(p2,p3)||isSame(p2,p4)||isSame(p3,p4))
            return false;
        double x_c = (p1[0] + p2[0] + p3[0] + p4[0])*1.0/4;
        double y_c = (p1[1] + p2[1] + p3[1] + p4[1])*1.0/4;
        double d1 = dis(new double[]{p1[0],p1[1]}, new double[]{x_c,y_c});
        double d2 = dis(new double[]{p2[0],p2[1]}, new double[]{x_c,y_c});
        double d3 = dis(new double[]{p3[0],p3[1]}, new double[]{x_c,y_c});
        double d4 = dis(new double[]{p4[0],p4[1]}, new double[]{x_c,y_c});

       if(!(d1 == d2 && d1 == d3 && d1 == d4))
           return false;
        if((x_c-p1[0]==p2[0]-x_c)&&(y_c-p1[1]==p2[1]-y_c)){
            if((x_c - p1[0]) * (x_c - p3[0]) + (y_c - p1[1]) * (y_c - p3[1]) == 0){
                return true;
            }else {
                return false;
            }
        }else {
            if((x_c - p1[0]) * (x_c - p2[0]) + (y_c - p1[1]) * (y_c - p2[1]) == 0){
                return true;
            }else {
                return false;
            }
        }
    }

    private double dis(double[] p1,double[] p2){
        return (p1[0] - p2[0])*(p1[0] - p2[0]) + (p1[1] - p2[1])*(p1[1] - p2[1]);
    }

    private boolean isSame(int[] p1,int[] p2){
        if(p1[0]==p2[0]&&p1[1]==p2[1])
            return true;
        return false;
    }

    public static void main(String[] args) {
        Solution593 s = new Solution593();
        int[] p1 = new int[]{1,0};
        int[] p2 = new int[]{0,1};
        int[] p3 = new int[]{1,0};
        int[] p4 = new int[]{0,-1};

        System.out.println(s.validSquare(p1,p2,p3,p4));

    }
}
