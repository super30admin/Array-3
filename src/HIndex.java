/**
 * 
 */

/**
 * @author Aditya Sinha
 * Create a count array (bucket sort) to store frequencies of citation counts.
 * We only need a size up to n, as an h-index cannot exceed the total number of papers.
 * Citations greater than n are grouped into the n-th bucket.
 *
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 * 
 */
public class HIndex {
	    public int hIndex(int[] citations) {
	        int n = citations.length;
	        int[] counts = new int[n + 1];

	        for (int c : citations) {
	            if (c >= n) {
	                counts[n]++;
	            } else {
	                counts[c]++;
	            }
	        }

	        int totalPapers = 0;
	        for (int h = n; h >= 0; h--) {
	            // Add the number of papers that have exactly 'h' citations to our running total.
	            totalPapers += counts[h];

	            // If the total number of papers with AT LEAST 'h' citations 
	            // is greater than or equal to 'h' itself, we found the h-index.
	            if (totalPapers >= h) {
	                return h;
	            }
	        }
	        
	        return 0; 
	    }

}

class MainHIndex {
	public static void main(String[] args) {
		HIndex hi = new HIndex();
		int [] citations = {3,0,6,1,5};
		System.out.println("h-Index will be = " + hi.hIndex(citations));
	}
}
