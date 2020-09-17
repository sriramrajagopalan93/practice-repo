package trial_programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
 * NOT SOLVED YET!
 */
public class RationPredicament {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RationPredicament rationPredicament = new RationPredicament();
		int quantityInKgs = 146;
		List<Float> sizesList = Arrays.asList(0.5f, 1f, 2f, 5f);
		List<Float> logisticsConstraintList = Arrays.asList(50f, 50f, 50f, 20f);
		List<Float> topUpList = Arrays.asList(10f, 10f, 10f, 10f);
		List<Float> availableCapacityList = Arrays.asList(103f, 15f, 27f, 20f);
		
//		int quantityInKgs = 124;
//		List<Float> sizesList = Arrays.asList(0.5f, 1f, 2f, 5f);
//		List<Float> logisticsConstraintList = Arrays.asList(50f, 50f, 50f, 30f);
//		List<Float> topUpList = Arrays.asList(10f, 10f, 10f, 10f);
//		List<Float> availableCapacityList = Arrays.asList(63f, 125f, 40f, 20f);
		
		
		System.out.println("quantityInKgs: " + quantityInKgs + " SizesList: " + sizesList + " topUpList: " + topUpList
				+ " availableCapacityList: " + availableCapacityList);
		rationPredicament.allocate(quantityInKgs, sizesList, logisticsConstraintList, topUpList, availableCapacityList);


	}

	private Map<String, List<Float>> allocate(int quantityInKgs, List<Float> sizesList,
			List<Float> logisticsConstraintList, List<Float> topUpList, List<Float> availableCapacityList) {
		List<Float> remainderList = new ArrayList<>();
		List<Float> allocationList = new ArrayList<>();
		List<Float> postAllocationCapacityList = new ArrayList<>();
		Map<String, List<Float>> resultMap = new HashMap<>();

		float currentQuantityReached = 0;
		float prevUsedUpQuantity = 0;
		float halfKgUsedUpQuantity = 0;
		float oneKgUsedUpQuantity = 0;
		float twoKgUsedUpQuantity = 0;
		float fiveKgUsedUpQuantity = 0;
		float prevCurrentQuantityReached = 0;
		float logisticsConstraintTopUp = 0;
		boolean topUpFlag = false;
		
		while (currentQuantityReached/2 <= quantityInKgs && halfKgUsedUpQuantity <= availableCapacityList.get(0)) {
//			System.out.println("half kg while");
			prevCurrentQuantityReached = currentQuantityReached;
			prevUsedUpQuantity = halfKgUsedUpQuantity;
			if (0.5 * logisticsConstraintList.get(0) <= quantityInKgs && !topUpFlag) {
				halfKgUsedUpQuantity = 0.5f * logisticsConstraintList.get(0);
				currentQuantityReached = 0.5f * logisticsConstraintList.get(0);
				topUpFlag = true;
			} else {
				logisticsConstraintTopUp = topUpList.get(0);
					halfKgUsedUpQuantity = halfKgUsedUpQuantity +(0.5f * logisticsConstraintTopUp); // if half kg crosses the available limit
																			// end while loop
					currentQuantityReached = currentQuantityReached + (0.5f * logisticsConstraintTopUp);
			}

			if(!(currentQuantityReached/2 <= quantityInKgs) || !(halfKgUsedUpQuantity <= availableCapacityList.get(0))) {
				currentQuantityReached = prevCurrentQuantityReached/2;
				halfKgUsedUpQuantity = prevUsedUpQuantity;
				break;
			}
		}
		

		topUpFlag = false;
		while (currentQuantityReached <= quantityInKgs && oneKgUsedUpQuantity <= availableCapacityList.get(1)) {
//			System.out.println("one kg while");
			prevCurrentQuantityReached = currentQuantityReached;
			prevUsedUpQuantity = oneKgUsedUpQuantity;
			if (currentQuantityReached +(1 * logisticsConstraintList.get(1)) <= quantityInKgs && !topUpFlag) {
				oneKgUsedUpQuantity = 1 * logisticsConstraintList.get(1);
				currentQuantityReached = currentQuantityReached + (1 * logisticsConstraintList.get(1));
				topUpFlag = true;
			} else {
				logisticsConstraintTopUp = topUpList.get(1);
					oneKgUsedUpQuantity = oneKgUsedUpQuantity +(1 * logisticsConstraintTopUp); // if one kg crosses the available limit
																		// end while loop
					currentQuantityReached = currentQuantityReached + (1 * logisticsConstraintTopUp);
			}
			if(!(currentQuantityReached <= quantityInKgs) || !(oneKgUsedUpQuantity <= availableCapacityList.get(1))) {
				currentQuantityReached = prevCurrentQuantityReached;
				oneKgUsedUpQuantity = prevUsedUpQuantity;
				break;
			}
		}

		topUpFlag = false;
		while (currentQuantityReached <= quantityInKgs && twoKgUsedUpQuantity/2 <= availableCapacityList.get(2)) {
//			System.out.println("two kg while");
			prevCurrentQuantityReached = currentQuantityReached;
			prevUsedUpQuantity = twoKgUsedUpQuantity;
			if (2 * logisticsConstraintList.get(2) <= quantityInKgs && !topUpFlag) {
				twoKgUsedUpQuantity = 2 * logisticsConstraintList.get(2);
				currentQuantityReached = currentQuantityReached + (2 * logisticsConstraintList.get(2));
				topUpFlag = true;
			} else {
				logisticsConstraintTopUp = topUpList.get(2);
					twoKgUsedUpQuantity = twoKgUsedUpQuantity +(2 * logisticsConstraintTopUp); // if 2 kg crosses the available limit
																		// end while loop
					currentQuantityReached =currentQuantityReached +( 2 * logisticsConstraintTopUp);
			}
			if(!(currentQuantityReached <= quantityInKgs) || !(twoKgUsedUpQuantity/2 <= availableCapacityList.get(2))) {
				currentQuantityReached = prevCurrentQuantityReached;
				twoKgUsedUpQuantity = prevUsedUpQuantity/2;
				break;
			}
		}

		topUpFlag = false;
		while (currentQuantityReached <= quantityInKgs && fiveKgUsedUpQuantity/5 <= availableCapacityList.get(3)) {
//			System.out.println("five kg while");
			prevCurrentQuantityReached = currentQuantityReached;
			prevUsedUpQuantity = fiveKgUsedUpQuantity;
			if (5 * logisticsConstraintList.get(3) <= quantityInKgs && !topUpFlag) {
				fiveKgUsedUpQuantity = 5 * logisticsConstraintList.get(3);
				currentQuantityReached = currentQuantityReached + (5 * logisticsConstraintList.get(3));
				topUpFlag = true;
			} else {
				logisticsConstraintTopUp = topUpList.get(3);
					fiveKgUsedUpQuantity = fiveKgUsedUpQuantity +(5 * logisticsConstraintTopUp); // if 5 kg crosses the available limit
																			// end while loop
					currentQuantityReached = currentQuantityReached + (5 * logisticsConstraintTopUp);
			}
			if(!(currentQuantityReached <= quantityInKgs) || !(fiveKgUsedUpQuantity/5 <= availableCapacityList.get(3))) {
				currentQuantityReached = prevCurrentQuantityReached;
				fiveKgUsedUpQuantity = prevUsedUpQuantity/5;
				break;
			}
		}

		remainderList.add(quantityInKgs - currentQuantityReached);
		resultMap.put("remainder", remainderList);

		resultMap.put("variant", sizesList);
		resultMap.put("uoms", logisticsConstraintList);

		allocationList.add(halfKgUsedUpQuantity);
		allocationList.add(oneKgUsedUpQuantity);
		allocationList.add(twoKgUsedUpQuantity);
		allocationList.add(fiveKgUsedUpQuantity);
		resultMap.put("allocations", allocationList);

		postAllocationCapacityList.add(availableCapacityList.get(0) - halfKgUsedUpQuantity);
		postAllocationCapacityList.add(availableCapacityList.get(1) - oneKgUsedUpQuantity);
		postAllocationCapacityList.add(availableCapacityList.get(2) - twoKgUsedUpQuantity);
		postAllocationCapacityList.add(availableCapacityList.get(3) - fiveKgUsedUpQuantity);
		resultMap.put("post_alloc_capacity", postAllocationCapacityList);

		resultMap.entrySet().stream().forEach(entry -> {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		});

		return resultMap;
	}

}
