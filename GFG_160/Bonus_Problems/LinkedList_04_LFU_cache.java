package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/lfu-cache-1665050355/0
 *
 * # LFU cache
 *
 *   Q. Design and implement an LFU (Least Frequently Used) cache. Here cap denotes the capacity
 *      of the cache and Q denotes the number of queries. Query can be of two types GET(x) and
 *      PUT(x, y).
 *
 *      The LRU cache should support the following operations:
 *
 *      • LFUCache(cap): initializes the cache with a given capacity.
 *
 *      • get(key): returns the value associated with the key if it exists; otherwise, returns -1.
 *
 *      • put(key, value): inserts or updates the key with value. If the cache has reached its
 *          capacity, the least frequently used (LFU) key should be removed. If there is a tie
 *          between keys with the same frequency, the least recently used (LRU) key among them
 *          should be removed.
 *    Ex.
 *      Input : cap = 2,
 *              Q = 9,
 *              Queries = [["PUT", 1, 1],
 *                         ["PUT", 2, 2],
 *                         ["GET", 1],
 *                         ["PUT", 3, 3],
 *                         ["GET", 2],
 *                         ["PUT", 4, 4],
 *                         ["GET", 3],
 *                         ["GET", 4],
 *                         ["PUT", 5, 5]]
 *      Output: [1 , -1, -1, 4]
 *      Explanation: Cache Size = 2
 *
 *         • ["PUT", 1, 1]: inserts the key-value pair (1, 1).
 *
 *         • ["PUT", 2, 2]: inserts the key-value pair (2, 2).
 *
 *         • ["GET", 1]: the cache retrieves the value for key 1, which is 1. After accessing
 *                       key 1, its frequency increases to 2.
 *
 *         • ["PUT", 3, 3]: The cache is now full (capacity = 2). To insert the new key-value
 *                       pair (3, 3), the least frequently used key must be removed. key 2 have
 *                       a frequency of 1. As a result, key 2 (the least recently accessed key)
 *                       is removed and key-value pair (3, 3) is inserted with frequency 1.
 *
 *         • ["GET", 2]: cache returns -1 indicating that key 2 is not found.
 *
 *         • ["PUT", 4, 4]: key 3 is removed as it has frequency of 1 and key-value pair (4, 4)
 *                       is inserted with frequency 1.
 *
 *         • ["GET", 3]: returns -1 (key 3 not found)
 *
 *         • ["GET", 4]: the cache retrieves the value for key 4, which is 4. After accessing
 *                       key 4, its frequency increases to 2.
 *
 *         • ["PUT", 5, 5]: key 1 and key 4 both have a frequency of 2 . Now, key 1 will be
 *                       removed as key 4 is most recently used and key-value pair (5, 5) is
 *                       inserted with frequency 1.
 */
import java.util.HashMap;

public class LinkedList_04_LFU_cache {

    /// main Method
    public static void main(String[] args) {

        LFUcache cache = new LFUcache(3);

        cache.put(2,2);
        cache.put(1,1);
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        cache.put(3,3);
        cache.put(4,4);
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        System.out.println(cache.get(4));

        cache.printCache();
    }
}
class LFUcache{
    private static class DLL{
        int key, data, freq;
        DLL prev, next;
        DLL(int key, int data){
            this.key = key;
            this.data = data;
            this.freq = 0;
        }
        static DLL[] initialize(){
            DLL head = new DLL(-1, -1);
            DLL tail = new DLL(-1, -1);
            head.next = tail;
            tail.prev = head;
            return new DLL[]{head, tail};
        }
        static void removeNode (DLL temp){
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        static void insert(DLL temp, DLL head){
            temp.next = head.next;
            temp.next.prev = temp;
            temp.prev = head;
            head.next = temp;
        }
    }

    private final int cap;
    private int minFreq;
    private final HashMap<Integer, DLL> keyNode;
    private final HashMap<Integer, DLL[]> freqList;
    public LFUcache(int cap) {
        // potd.code.hub
        this.cap = cap;
        this.keyNode = new HashMap<>(cap);
        this.freqList = new HashMap<>(cap);
        this.minFreq = 0;
    }

    public int get(int key) {
        // potd.code.hub
        if (!keyNode.containsKey(key)) return -1;
        DLL temp = keyNode.get(key);
        DLL.removeNode(temp);
        temp.freq++;
        update(temp);
        return temp.data;
    }

    public void put(int key, int value) {
        // potd.code.hub
        if (cap == 0) return;
        DLL temp;
        if (keyNode.containsKey(key)){
            temp = keyNode.get(key);
            temp.data = value;
            DLL.removeNode(temp);
            temp.freq++;
            update(temp);
        }
        else {
            if (keyNode.size() >= cap){
                DLL[] list = freqList.get(minFreq);
                temp = list[1].prev;
                keyNode.remove(temp.key);
                DLL.removeNode(temp);
                freqList.put(temp.freq, list);
            }
            temp = new DLL(key, value);
            keyNode.put(key, temp);
            update(temp);
            minFreq = 0;
        }
    }

    private void update(DLL node){
        int freq = node.freq;
        DLL[] list = freqList.getOrDefault(freq, DLL.initialize());
        DLL.insert(node, list[0]);
        freqList.put(freq, list);
        list = freqList.get(minFreq);
        if (list[0].next == list[1]) minFreq++;
    }

    void printCache(){
        System.out.println("\nMin Frequency: " + minFreq);
        freqList.forEach((x, y) -> {
            System.out.print(x + " -> ");
            DLL temp = y[0].next;
            while (temp != y[1]){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        });
        System.out.println();
    }
}
