// Time Complexity: O(n) + O(n) - > O(n)
// Space Complexity: O(n)
// Bucket Sort
public class HIndex {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0;
        int n = citations.length;
        int [] diff = new int[n+1];
        
        // get the count of citiations for each i value
        for(int i = 0 ; i < n ; i ++)
        {
            if(citations[i] > n)
            {
                diff[n]++;
            }
            else
            {
                diff[citations[i]]++;
            }
        }
        int sum = 0;
        for(int i = n ; i >= 0 ; i--)
        {
            sum += diff[i];
            if(sum >= i)
                return i; // H -index is i 
        }
        return 0;
    }
}

// Time Complexity: O(nlogn)
// Space Complexity: O(1)
// Sorting and searching
public class HIndex {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0;
        
        Arrays.sort(citations);
        int n = citations.length;
        for(int i = 0 ; i < n ; i ++)
        {
            int diff = n - i;
            if(citations[i] >= diff)
                return diff;
        }
        
        return 0;
    }
}
