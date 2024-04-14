package y_2024.m04.d14.problem705;

/**
 * <a href="https://leetcode.cn/problems/design-hashset/description/?envType=daily-question&envId=2024-04-14">...</a>
 */
public class MyHashSet {
    private static final int MX = 31251;
    int[] buckets;    // buckets[i]存放[i*32, (i+1)*32)的元素信息

    public MyHashSet() {
        buckets = new int[MX];
    }

    public void add(int key) {
        setVal(key / 32, key % 32, 1);  // 将key所在的位置的整数的对应位置为1
    }

    public void remove(int key) {
        setVal(key / 32, key % 32, 0);  // 将key所在的位置的整数的对应位置为0
    }

    public boolean contains(int key) {
        return getVal(key / 32, key % 32) == 1; // 返回对应位是否为1
    }

    /**
     * 将buckets[bucketId]的bitId位置为val
     */
    private void setVal(int bucketId, int bitId, int val) {
        if (val == 1) {
            buckets[bucketId] |= (1 << bitId);  // 置为1
        } else {
            buckets[bucketId] &= ~(1 << bitId); // 置为0
        }
    }

    /**
     * 返回buckets[bucketId]的bitId位置的值
     */
    private int getVal(int bucketId, int bitId) {
        return (buckets[bucketId] >> bitId) & 1;
    }
}