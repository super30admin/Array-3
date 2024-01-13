//H-Index and H-Index-II added


/*

citations is not in sorted manner
if sorted, we can just us n-h approach as folows
1. Sort the array. 
2. h index will lie from 0 to n = length of the array 
3. find the index, where, h index value <= citations values. 
4. return that index. 

TC: O(n logn) + O(n)
sc: O(1)*/

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int n = citations.length; // dont do -1 as h index is 1 to n

        for (int i = 0; i < n; i++) {
            int hindex = n - i;
            if (citations[i] >= hindex)
                return hindex;
        }
        // never found it
        return 0;
    }
}

/*
 * approach
 * 1. take the new array of size n+1
 * 2. go to the citations, and mark that indx in arr[] an increase it by 1.
 * 3. when find a value bigger than the n, just keep incrementing the last
 * index.
 * 4. run a nother for loop to find the H index.
 * 5. take a sm variable, an keep a running sum while traversing backwards.
 * 6. when sum >= index value; that index is h-index.
 * TC: O(n) - 2 pass
 * SC: O(n)
 */
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;

        int[] arr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int index = citations[i];
            if (index > n)
                arr[n]++;
            else
                arr[index]++;
        }

        // go backward from the right side and maintain a sum
        int sum = 0;
        for (int i = n; i > 0; i--) {
            sum = sum + arr[i];
            if (sum >= i)
                return i;
        }
        // never found it
        return 0;
    }
}

/*
Binary Search approach :
 
1. Take low and high pointer on bounds for binary search 
2. we'll look for condition where mid's value >= diff. 
2a. if we find mid; we have to make sure, that's our left most mid, where condition satisifed.
2b. So to check that, we check the adjacent element, and diff at that point. 
note -> the diff calculated is for mid position only. For mid-1; ths diff will be diff+1.
3.if we found mid-1 satisfying condition, we update high = mid-1; else return the mid
4. in case, where mid's val < difff, perform low = mid+1;

TC: O(log n)
SC: O(1)
*/
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        
        int[] arr = new int[n+1];
        int low =0, high =n-1;
        
        while(low <= high)        {
            int mid = low + (high-low)/2;
            int diff = n-mid;
            if(citations[mid] >= diff) {
                //if found match on above conditon, let's explore where this condition is match on the left most side. 
              if(mid>0 && citations[mid-1] >= diff+1) {
                    high = mid -1;
                }
                else
                    return diff;
            }
            else
                low = mid+1; //diff is greater to mid's value, go on right side.
        }
        //never found it
        return 0;
    }
}
