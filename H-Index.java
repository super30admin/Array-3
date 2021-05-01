class Solution {
    public int hIndex(int[] citations) {
        //base case
        if(citations == null || citations.length == 0){
            return 0;
        }
        
        int n = citations.length;
        
        int[] sort = new int[n+1];
        
        for(int elem: citations){
            //if the elem is greater than length of array, it is limited to n
            if(elem >= n){
                sort[n]++;
            }else{
                sort[elem]++;
            }
        }
        
        int pappers = 0;
        for(int x = n; x >= 0; x--){
            pappers += sort[x];
            //if number of pappers greater than or eqaual to x then x is h-index
            if(pappers >= x){
                return x;
            }
        }
        
        return 0;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)