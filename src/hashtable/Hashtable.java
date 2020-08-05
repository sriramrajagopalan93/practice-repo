package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Hashtable {

	List<KeyValue>[] bucketArray;
	int currentLength; // filled buckets
	
	Hashtable(int size){
		//create a bucket array of given size where each bucket has List<KeyValue>
		this.bucketArray = new ArrayList[size]; //'this' is optional here
		this.currentLength = 0; //'this' is optional here
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable hashtable = new Hashtable(50);
		hashtable.set("grapes",10);
		hashtable.set("apple",20);
		hashtable.set("guava",40);
		hashtable.get("grapes");
		hashtable.get("grapessss");
		hashtable.set("tomatoes",30);
		hashtable.keys();
	}

	//hashing function
	private int hash(String key) {
		 return Integer.valueOf(key.charAt(0))%2;
	}
	
	private void set(String key, int value) {
		int address = hash(key);
		List<KeyValue> keyValueList = this.bucketArray[address];
		if(keyValueList == null) {
			keyValueList = new ArrayList<KeyValue>();
			this.bucketArray[address] = keyValueList; 
			//keyValueList and this.bucketArray[address] will point to same loccation in memory
		}
		KeyValue keyValue = new KeyValue(key, value);
		keyValueList.add(keyValue);
		this.currentLength++;
		/*	once this method is over keyValueList reference variable (in stack memory) will be garbage collected 
		 *  but this.bucketArray[address] will still point to the location in memory
		 */
	}
	
	private void get(String key) {
		int address = hash(key);
		List<KeyValue> keyValueList = this.bucketArray[address];
		if(keyValueList!=null) {
			for(KeyValue keyValue: keyValueList) {
				if(keyValue.key.equals(key)) {
					System.out.println("The value of "+key+" is:"+keyValue.value);
					return;
				}
			}
		}
		System.out.println("No value present for the key "+key);
	}

	private void keys() {
		String keysArray[] = new String[this.currentLength];
		int stringIndex = 0;
		for(int i=0;i< bucketArray.length;i++) {
			List<KeyValue> keyValueList = this.bucketArray[i];
			if(keyValueList!=null) {
				for(KeyValue keyValue: keyValueList) {
					keysArray[stringIndex] = keyValue.key;
					stringIndex++;
					}
				}
			}
		System.out.println("list of keys: " + Arrays.toString(keysArray));
	}
}
