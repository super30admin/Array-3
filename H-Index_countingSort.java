//counting sort
//Time Complexity:O(n)
//SPace Complexity:O(1)
//Approach- Counting sort is used to store the count of occurrance of each index in the citations array(as a hashmap). All those indices whose values are greater than or equal to the value of the citations array length are added to the last index of the count array. Then this temp array is iterated from behind and if I find any index whose count value is equal to or greater than the current index value, then that index would become the h index.

class Solution {
    public int hIndex(int[] citations) {
        int total=0;
        int n=citations.length;
        int[] temp=new int[n+1];
        for(int c:citations){
            if(c>=n){
                temp[n]++;
            }
            else{
                temp[c]++;
            }
        }
        for(int i=n;i>=0;i--){
            total+=temp[i];
            if(total>=i){
                return i;
            }
        }
        return 0;
    }
} 