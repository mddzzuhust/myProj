package RedisID;

public class RedisID {
    public static void main(String[] args) {
        long buildId = buildId(1565165536640L, 53, 1);
        System.out.println("分布式id是："+buildId);
        long buildIdLast = buildId(1565165536640L, 53, 1023);
        System.out.println("分布式id是："+buildIdLast);
    }
    public static long buildId(long miliSecond, long shardId, long seq) {
        return (miliSecond << (12 + 10)) + (shardId << 10) + seq;
    }
}
