// Time complexity = O(n)
// Space complexity = O(n)
class Solution {
  public int hIndex(int[] citations) {
    int n = citations.length;
    if(citations == null || n == 0) return 0;
    // Creating an array to store exact number of citations
    int[] indegree = new int[n+1];
    for(int cit: citations) {
      if(cit > n) indegree[n]++;
      else {
        indegree[cit]++;
      }
    }

    int total = 0;
    for(int i = n; i>=0; i--) {
      total += indegree[i];
      if(total >= i) {
        return i;
      }
    }
    return 0;
  }
}