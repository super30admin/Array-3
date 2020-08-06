
//TC - O(NlogN)
//SC - O(1)
import java.util.*;

class Solution3 {
	public int hIndex(int[] citations) {
		int n = citations.length;
		Arrays.sort(citations);
		for (int i = 0; i < n; i++) {
			int diff = n - i;
			if (citations[i] >= diff)
				return diff;
		}
		return 0;
	}
}