

public class Solution1405 {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        int counta = 0,countb = 0,countc = 0;
        while (a>0||b>0||c>0){
            int max = Math.max(a, Math.max(b,c));
            if(a==max){
                if(b==0&&c==0&&counta==2){
                    break;
                }
                if(counta<2){
                    if(a>0) {
                        sb.append('a');
                        a--;
                        counta++;
                        countb=0;
                        countc=0;
                    }
                }else if(counta==2){
                    counta=0;
                    if(b>=c){
                        if(b>0) {
                            sb.append('b');
                            b--;
                            countb++;
                            counta=0;
                            countc=0;
                        }
                    }else {
                        if(c>0) {
                            sb.append('c');
                            c--;
                            countc++;
                            counta=0;
                            countb=0;
                        }
                    }
                }

            }else if(b==max){
                if(a==0&&c==0&&countb==2){
                    break;
                }
                if(countb<2){
                    if(b>0) {
                        sb.append('b');
                        b--;
                        countb++;
                        counta=0;
                        countc=0;
                    }
                }else {
                    countb=0;
                    if(a>=c){
                        if(a>0) {
                            sb.append('a');
                            a--;
                            counta++;
                            countb=0;
                            countc=0;
                        }
                    }else {
                        if(c>0) {
                            sb.append('c');
                            c--;
                            countc++;
                            counta=0;
                            countb=0;
                        }
                    }
                }
            }else if(c==max){
                if(a==0&&b==0&&countc==2){
                    break;
                }
                if(countc<2){
                    if(c>0) {
                        sb.append('c');
                        countc++;
                        c--;
                        counta=0;
                        countb=0;
                    }
                }else {
                    countc=0;
                    if(a>=b){
                        if(a>0) {
                            sb.append('a');
                            counta++;
                            a--;
                            countb=0;
                            countc=0;
                        }
                    }else {
                        if(b>0) {
                            sb.append('b');
                            countb++;
                            b--;
                            counta=0;
                            countc=0;
                        }
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution1405 s= new Solution1405();
        System.out.println(s.longestDiverseString(1,0,3));
    }
}
