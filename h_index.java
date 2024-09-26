Time Complexity = O(nlogn)
Space Complexity = O(1)

class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){
            return 0;
        }
        
        int n = citations.length;
        int[] bucket = new int[n+1];
        
        for(int c:citations){
            if(c > n){
                c = n;
            }
            bucket[c]++;
        }
        
        int runningSum = 0;
        int index = bucket.length - 1;
        
        while(true){
            runningSum+= bucket[index];
            if(index <= runningSum)break;
            
            index--;
        }
        return index;
    }
}