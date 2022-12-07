package net.codejava;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
 
public class HashNode {
	
    public String key;
    public String value;
    final int hashCode;
    HashNode next;
 
    HashNode(String key, String value, int hashCode) {
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
    }
}
 
class Map {
    public ArrayList<HashNode> bucketArray;
    public int numOfBuckets;
    public int size;
 
    public Map(String key, int hashCode) {
        bucketArray = new ArrayList<>();
        numOfBuckets = 10;
        size = 0;
 
        for (int i = 0; i < numOfBuckets; i++) {
            bucketArray.add(null);
        }
    }
 
    public int size() {
    	return size;
    }
    
    public boolean isEmpty() {
    	return size() == 0;
    }
     
      private final int hashCode (String key) {
        return Objects.hashCode(key);
    }
   
    private int getBucketIndex(String key)
    {
        int hashCode = hashCode(key);
        int index = hashCode % numOfBuckets;
        index = index < 0 ? index * -1 : index;
        return index;
    }
 
    public String remove(String key) {
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
        HashNode head = bucketArray.get(bucketIndex);
 
        HashNode prev = null;
        while (head != null) {
            if (head.key.equals(key) && hashCode == head.hashCode) {
                break;
            }
 
            prev = head;
            head = head.next;
        }
 
        if (head == null) {
            return null;
        }
 
        size--;
 
        if (prev != null) {
            prev.next = head.next;
        }
        else {
            bucketArray.set(bucketIndex, head.next);
        }
        return head.value;
    }
 
    public String get(String key)
    {
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
       
        HashNode head = bucketArray.get(bucketIndex);
 
        while (head != null) {
            if (head.key.equals(key) && head.hashCode == hashCode) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }
 
    public void add(String key, String value) {
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
        HashNode head = bucketArray.get(bucketIndex);
 
        while (head != null) {
            if (head.key.equals(key) && head.hashCode == hashCode) {
                head.value = value;
                return;
            }
            head = head.next;
        }
 
        size++;
        head = bucketArray.get(bucketIndex);
        HashNode newNode = new HashNode(key, value, hashCode);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);
 
        if ((1.0 * size) / numOfBuckets >= 0.7) {
            ArrayList<HashNode> temp = bucketArray;
            bucketArray = new ArrayList<>();
            numOfBuckets = 2 * numOfBuckets;
            size = 0;
            for (int i = 0; i < numOfBuckets; i++)
                bucketArray.add(null);
 
            for (HashNode headNode : temp) {
                while (headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }
 
    public static void main(String[] args) {
    	//System.out.println("bababooey");
        Map map = new Map("bababooey", 200);
        long start;
        Random random = new Random();
        String endpointKey = null;
        
        for(int i = 0; i < 10000; i++) {
        	int num = random.nextInt(1000000);
        	//I'm making the key the code in this case for simplicity
        	map.add("" + num, "" + num);
        	//
        	if(i == 100) {
        		endpointKey = "" + num;
        	}
        }
        
        start = System.currentTimeMillis();
        map.get(endpointKey);
        System.out.println("Finished searching hash table in " + (System.currentTimeMillis() - start) + " milliseconds.");
        
        //map.add("bruh", 1);
        //System.out.println(map.remove("epic"));
        //System.out.println(map.size());
        //System.out.println(map.isEmpty());
    }
}