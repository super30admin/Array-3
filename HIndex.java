//before class solution
/*
public class Solution {
    public int hIndex(int[] citations) {
        int length = citations.length;
        int[] count = new int[length + 1];
        
        for (int citation : citations) {
            count[Math.min(citation, length)]++;
        }
        
        int sum = 0;
        for (int h = length; h >= 0; h--) {
            sum += count[h];
            if (sum >= h) {
                return h;
            }
        }
        return 0;
    }
}
*/

// class solution
// Uses Bucket Sort
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
	public int hIndex(int[] citations) {

		int n = citations.length;
		int[] bucket = new int[n + 1];

		for (int citation: citations) {
			if(citation > n) {
				citation = n;
			}
			bucket[citation]++;
		}

		int index = n;
		int runningSum = 0;

		while(true) {
			runningSum += bucket[index];
			if(index <= runningSum) break;

			index--;
		}

		return index;
	}
}