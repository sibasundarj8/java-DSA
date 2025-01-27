package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/lru-cache/1
 *
 * # LRU Cache
 *
 *   Q. Design a data structure that works like a LRU Cache. Here cap denotes the capacity of the
 *      cache and Q denotes the number of queries. Query can be of two types:
 *
 *        1. PUT x y: sets the value of the key x with value y
 *        2. GET x: gets the key of x if present else returns -1.
 *
 *          The LRUCache class has two methods get() and put() which are defined as follows.
 *
 *        1. get(key): returns the value of the key if it already exists in the cache otherwise
 *           returns -1.
 *        2. put(key, value): if the key is already present, update its value. If not present,
 *           add the key-value pair to the cache. If the cache reaches its capacity it should
 *           remove the least recently used item before inserting the new item.
 *        3. In the constructor of the class the capacity of the cache should be initialized.
 *    Ex.
 *      Input : cap = 2
 *              Q = 2
 *              Queries = [["PUT", 1, 2], ["GET", 1]]
 *      Output: [2]
 *      Explanation: Cache Size = 2
 *              ["PUT", 1, 2] will insert the key-value pair (1, 2) in the cache,
 *              ["GET", 1] will print the value corresponding to Key 1, ie 2.
 */
import java.util.HashMap;

public class GFG_74_LRU_Cache {
     private static class DLL{
        DLL next;
        DLL prev;
        int key;
        int data;
        DLL (int key, int data){
            this.key = key;
            this.data = data;
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

    private static int max_size;
    private static final HashMap<Integer, DLL> map = new HashMap<>(max_size);
    private static final DLL[] list = DLL.initialize();

    GFG_74_LRU_Cache(int cap) {
        // potd.code.hub
        max_size = cap;
    }

    // Function to return value corresponding to the key.
    public static int get(int key) {
        // potd.code.hub
        if (! map.containsKey(key)) return -1;
        DLL temp = map.get(key);
        DLL.removeNode(temp);
        DLL.insert(temp, list[0]);
        return temp.data;
    }

    // Function for storing key-value pair.
    public static void put(int key, int value) {
        // potd.code.hub
        DLL temp;
        if (map.containsKey(key)){
            temp = map.get(key);
            DLL.removeNode(temp);
            DLL.insert(temp, list[0]);
            temp.data = value;
        }
        else {
            if (map.size() == max_size){
                temp = list[1].prev;
                map.remove(temp.key);
                DLL.removeNode(temp);
            }
            temp = new DLL(key, value);
            DLL.insert(temp, list[0]);
            map.put(key, temp);
        }
    }
}

class Main{
    public static void main(String[] args) {
        new GFG_74_LRU_Cache(2);
        GFG_74_LRU_Cache.put(4, 4);
        GFG_74_LRU_Cache.put(3, 3);
        GFG_74_LRU_Cache.put(2, 2);
        GFG_74_LRU_Cache.put(1, 1);
        System.out.println(GFG_74_LRU_Cache.get(1));
        System.out.println(GFG_74_LRU_Cache.get(2));
        System.out.println(GFG_74_LRU_Cache.get(3));
        System.out.println(GFG_74_LRU_Cache.get(4));
    }
}
