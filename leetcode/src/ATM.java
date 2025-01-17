public class ATM {
    private long[] cnt;
    private long[] value;

    public ATM() {
        cnt = new long[]{0,0,0,0,0};
        value = new long[]{20,50,100,200,500};
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < 5; i++) {
            cnt[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int[] res = new int[5];
        for (int i = 4; i >= 0 ; i--) {
            res[i] = (int)Math.min(cnt[i], amount/value[i]);
            amount -= res[i]*value[i];
        }
        if(amount > 0 ){
            return new int[]{-1};
        }else {
            for (int i = 0; i < 5; i++) {
                cnt[i] -= res[i];
            }
            return res;
        }
    }
}
