package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

// Dynamic programming is - caching the repeatedly executed values, to avoid re computation
public class AddTo80Memoization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddTo80Memoization addTo80Memoization = new AddTo80Memoization();
		addTo80Memoization.addTo80Normal(10);
		addTo80Memoization.addTo80Normal(10);
		
		Map<Integer, Integer> cachedMap = new HashMap<>();
		addTo80Memoization.addTo80Memoized(10, cachedMap);
		addTo80Memoization.addTo80Memoized(10, cachedMap);
	}

	private void addTo80Memoized(int value, Map<Integer, Integer> cachedMap) {
		if(!cachedMap.containsKey(value)) {
			System.out.println("long computation time/logic");
			cachedMap.put(value, 80+value);
		}
		System.out.println("Result: "+cachedMap.get(value));
	}

	private void addTo80Normal(int value) {
		System.out.println("long computation time/logic");
		System.out.println("Result: "+(80+value));
	}

}
