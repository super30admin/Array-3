/* time - nlogn space - O(1)
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if citations is None or len(citations) == 0:
            return 0
        
        n = len(citations)
        citations.sort()
        for i in range(n):
            diff = n - i
            if citations[i] >= diff:
                return diff
        return 0
*/
/*
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        
        int n = citations.length;
        Arrays.sort(citations);
        for (int i=0; i<n; i++){
            int diff = n - i;
            if (citations[i] >= diff)
                return diff;
            
        }
        return 0;
    }
}
*/
/*
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if citations is None or len(citations) == 0:
            return 0
        
        n = len(citations)
        bucket = [0]*(n+1)
        for i in range(n):
            if citations[i] >= n:
                bucket[n] += 1
            else:
                bucket[citations[i]] += 1
            
        total = 0
        for i in range(n, -1, -1):
            total += bucket[i]
            if total >= i:
                return i

*/



class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        
        int n = citations.length;
        int[] bucket = new int[n+1];
        for (int i=0; i<n; i++){
            if (citations[i] >= n)
                bucket[n] ++;
            else
                bucket[citations[i]]++;
            
        }
        
        int sum = 0;
        for (int i=n; i>=0; i--){
            sum = sum + bucket[i];
            if (sum >= i) 
                return i;
        }
        return -1;
    }
}