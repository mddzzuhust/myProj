import java.util.Arrays;

/**
 * skiplist(跳跃表)：用于有序列表快速搜索查找的数据结构，是一个随机性的数据结构，
 * 实质是一种可以进行二分查找的有序链表，
 * 在原有的有序链表基础上增加了多级索引，
 * 通过索引实现快速查找，提高搜索、插入、删除的性能。
 * 性能与红黑树、AVL树接近
 * <p>
 * 定义跳跃表元素节点,采用数组实现
 * <p>
 * 实现：查询，删除，插入
 */

/**
 * 1.定义跳跃表节点
 */
public class SkipListNode {

    public Integer value;//存放元素

    public SkipListNode[] next;//向前的指针，跳表是多层的，这个指向的指针，最多和层数一样。


    public SkipListNode(Integer value, int size) {
        this.value = value;
        this.next = new SkipListNode[size];
    }


    @Override
    public String toString() {
        return "SkipListNode{" +
                "value=" + value +
                ", next=" + Arrays.toString(next) +
                '}';
    }
}

/**
 * 跳跃表：增删查实现
 */
class SkipList {

    private Integer currentLevel = 1;//当前有效层级数，从1开始
    private static final Integer DEFAULT_MAX_LEVEL = 32;//最大层数
    private static final Double DEFAULT_P_FACTOR = 0.5; //随机层数概率，第1层以上的（不包括第一层）继续叠加的概率，层数不超过maxLevel,层数的起始号为1

    private SkipListNode head = new SkipListNode(null, DEFAULT_MAX_LEVEL);//头节点


    /**
     * 查询
     *
     * @param target
     * @return
     */
    public boolean search(final int target) {
        SkipListNode searchNode = head;
        for (int i = currentLevel - 1; i >= 0; i--) {
            searchNode = findClosest(searchNode, i, target);
            if (searchNode.next[i] != null && target == searchNode.next[i].value) {
                return true;
            }
        }
        return false;
    }


    /**
     * 通用的方法-找出target最近节点，这也是为啥不直接找出相等节点原因，
     * 因为当删除查询的时候如果是相等的话就改变不了前一个节点所在层的next
     * 虽然可以定制不同的查询，但是使用通用方法只维护一种查询，维护成本低
     *
     * @param searchNode 当前查询节点
     * @param levelIndex 当前遍历层数index
     * @param target     查询值
     * @return
     */
    private SkipListNode findClosest(SkipListNode searchNode, int levelIndex, int target) {
        while (searchNode.next[levelIndex] != null && target > searchNode.next[levelIndex].value) {
            searchNode = searchNode.next[levelIndex];
        }
        return searchNode;
    }

    /**
     * 添加元素
     *
     * @param num
     */
    public void add(int num) {
        int level = randomLevel();
        SkipListNode newNode = new SkipListNode(num, level);

        SkipListNode searchNode = head;

        //只用一次遍历
        int biggerLevel = level > currentLevel ? level : currentLevel;
        for (int i = biggerLevel - 1; i >= 0; i--) {
            //当level index大于currentLevel-1时
            if (i > (currentLevel - 1)) {
                head.next[i] = newNode;
            } else {//当level index小于等于currentLevel-1时
                searchNode = findClosest(searchNode, i, num);
                if (i < level) {
                    if (searchNode.next[i] == null) {
                        searchNode.next[i] = newNode;
                    } else {
                        SkipListNode tmp = searchNode.next[i];
                        searchNode.next[i] = newNode;
                        newNode.next[i] = tmp;
                    }
                }

            }
        }
        //大于当前就替换
        if (level > currentLevel) {
            currentLevel = level;
        }
    }

    /**
     * 随机一个层数控制小于等于上限并且不等大于目前层数+n
     *
     * @return
     */
    private int randomLevel() {
        int level = 0;
        while (Math.random() < DEFAULT_P_FACTOR && level < DEFAULT_MAX_LEVEL && level < (currentLevel + 3)) {
            ++level;
        }

        return level;
    }

    /**
     * 删除：找到并改变next就行与链表删除类似
     *
     * @param num
     * @return
     */
    public boolean del(int num) {
        boolean flag = false;
        SkipListNode searchNode = head;
        for (int i = currentLevel - 1; i >= 0; i--) {
            searchNode = findClosest(searchNode, i, num);
            if (searchNode.next[i] != null && num == searchNode.next[i].value) {
                flag = true;
                searchNode.next[i] = searchNode.next[i].next[i];
                continue;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        SkipList skipList1 = new SkipList();
        skipList1.add(1);
        skipList1.add(2);
        skipList1.add(3);
        skipList1.add(4);
        System.out.println("查找0的结果：" + skipList1.search(0));

        System.out.println("查找1的结果：" + skipList1.search(1));

        System.out.println("删除0的结果：" + skipList1.del(0));
        System.out.println("删除1的结果：" + skipList1.del(1));
        System.out.println("查找1的结果：" + skipList1.search(1));
    }
}