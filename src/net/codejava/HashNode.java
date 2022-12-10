package net.codejava;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
 
public class HashNode {
	
    public String key;
    public String value;
    final int hashCode;
    HashNode next;
    HashNode deleter = null;
    //int height = 20;
 
    HashNode(String key, String value, int hashCode) {
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
    }
}
 
//this isn't a mispelling, eclipse just hates when I name things HashMap
class HasMap {
    public ArrayList<HashNode> bucketArray;
    public int numOfBuckets;
    public static int size;
    int height = 10;
    
 
    public HasMap(String key, int hashCode) {
        bucketArray = new ArrayList<>();
        numOfBuckets = 10;
        //size;
 
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
     /*
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
 	*/
    public String remove(String key) {
    	int hashIndex = Integer.parseInt(key) % height;
    	
    	while(bucketArray.get(hashIndex) != null) {
    		if(bucketArray.get(hashIndex).key.equals(key)) {
    			bucketArray.remove(hashIndex);
    			return null;
    		}
    		hashIndex++;
    		hashIndex %= height;
    	}
    	return null;
    	
    	/*
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
        */
    }
 
    public String get(String key)
    {
        //int bucketIndex = getBucketIndex(key);
        //int hashCode = hashCode(key);
        int hashIndex = (Integer.parseInt(key) % height);
        //HashNode head = bucketArray.get(bucketIndex);
        int count = 0;
 
        while (bucketArray.get(hashIndex) != null) {
        	if(count + 1 > height) {
        		break;
        	}
            if (bucketArray.get(hashIndex).key.equals(key)) {
                return bucketArray.get(hashIndex).value;
            }
            hashIndex++;
            hashIndex %= height;
        }
        return null;
    }
 
    public void add(String key, String value) {
    	HashNode placeholder = new HashNode(key, value, this.hashCode());
    	placeholder.key = key;
    	placeholder.value = value;
    	int hashIndex = Integer.parseInt(key) % height;
    	
    	while(bucketArray.get(hashIndex) != null && bucketArray.get(hashIndex).key != key && bucketArray.get(hashIndex).key != null) {
    		hashIndex++;
    		hashIndex %= height;
    	}
    	
    	if(bucketArray.get(hashIndex) == null || bucketArray.get(hashIndex).key == null) {
    		size++;
    	}
    	    	
    	//bucketArray.set(hashIndex, placeholder);
    	
    	/*
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
        }*/
    }
 
    public static void main(String[] args) {
    	//System.out.println("bababooey");
        HasMap map = new HasMap("bababooey", 200);
        long start;
        Random random = new Random();
        String endpointKey = null;
        String value;
        //HasMap temp = new HasMap(null, -1);
        
        for(int i = 0; i < 10000; i++) {
        	int num = random.nextInt(1000000);
        	//I'm making the key the code in this case for simplicity
        	map.add("" + num, "" + num);
        	//System.out.println(map.get("" + num));
        	//
        	if(i == 100) {
        		endpointKey = "" + num;
        	}
        }
        
        for(int i = 0; i < 3; i++) {
            start = System.currentTimeMillis();
        	for(int j = 0; j < 100; j++) {
        		value = Integer.toString(random.nextInt(10000));
        		map.get(value);
        	}
            System.out.println("Finished " + (i + 1) + "st search of hash table in " + (System.currentTimeMillis() - start) + " milliseconds.");
        }
        
        //start = System.currentTimeMillis();
        //map.get(endpointKey);
        
        //map.add("bruh", 1);
        //System.out.println(map.remove("epic"));
        //System.out.println(map.size());
        //System.out.println(map.isEmpty());
    }
}