package hash;

public class MyHashMap<K, V> {
    private Entry[] bucketArray;
    private static final double LOAD_FACTOR = 0.75;
    private int threshold;
    private int size;

    public MyHashMap() {
        bucketArray = new Entry[16];
        threshold = (int)(16 * LOAD_FACTOR);
    }

    public V put(K key, V value) {
        if (size >= threshold) {
            // 处理哈希冲突，例如链地址法或开放定址法
        }
        int index = hash(key);
        Entry<K, V> entry = bucketArray[index];
        if (entry == null) {
            bucketArray[index] = new Entry<>(key, value);
        } else {
            // 处理键冲突
        }
        size++;
        return value;
    }

    public V get(K key) {
        int index = hash(key);
        Entry<K, V> entry = bucketArray[index];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    private int hash(K key) {
        // 使用哈希函数计算索引
        return key.hashCode() % bucketArray.length;
    }

    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
