package com.ibits.greedy;

/*
 * https://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/
 * Related problems : https://www.geeksforgeeks.org/number-of-circular-tours-that-visit-all-petrol-pumps/
 */

class PetrolPump {
	int petrol;
	int distance;

	public PetrolPump(int petrol, int distance) {
		this.petrol = petrol;
		this.distance = distance;
	}
}

public class GasStation {

	public static void main(String[] args) {

		int petrol[] = { 6, 3, 7 };
		int dist[] = { 4, 6, 3 };

		/*
		 * int petrol[] = { 0 }; int dist[] = { 0 };
		 */
		int n = petrol.length;

		PetrolPump[] pumps = new PetrolPump[n];

		for (int i = 0; i < n; i++) {
			pumps[i] = new PetrolPump(petrol[i], dist[i]);
		}

		System.out.println(startingPetrolPump(pumps, n));
	}

	private static int startingPetrolPump(PetrolPump[] pumps, int n) {
		// If there is only one gas station then the first
		// petrol pump index 0 is the answer
		if (n == 1)
			return 0;
		int start = 0, end = 1;
		int petrolLeft = pumps[start].petrol - pumps[start].distance;

		// Check if starting point is same as end point OR
		// petrol left is less than 0
		while (start != end || petrolLeft < 0) {
			while (petrolLeft < 0 && start != end) {
				// Remove the starting point and add the next one as the starting
				// point
				petrolLeft -= (pumps[start].petrol - pumps[start].distance);

				// Since it is a circular tour, we take modulus n
				start = (start + 1) % n;

				// If we return back to original starting point i.e 0
				// It means the circular tour is not possible
				if (start == 0)
					return -1;
			}
			petrolLeft += pumps[end].petrol - pumps[end].distance;
			end = (end + 1) % n;
		}

		// Return the starting point
		return start;
	}
}
