// Approach - Counting
// Time Complexity - O(N) - N is the length of citations
// Space Complexity - O(N)
class Solution {
  public int hIndex(int[] citations) {

    int n = citations.length;
    int[] arr = new int[n+1];

    for(int cite: citations){
      if(cite >= n){
        arr[n]++;
      }
      else{
        arr[cite]++;
      }
    }

    // print(arr);

    int result = 0;
    for(int i=n; i>=0; i--){
      result += arr[i];

      if(result >= i){
        return i;
      }
    }
    return 0;
  }

  public void print(int[] arr){
    System.out.println("");

    for(int i=0; i<arr.length; i++){
      System.out.print(arr[i]+" ");
    }

    System.out.println("");
  }
}
