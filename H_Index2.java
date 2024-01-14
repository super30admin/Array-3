//TC : O(n)
//SC: O(1)

public class H_Index2 {
    public int hIndex(int[] citations) {

      //if(citations.length == 1 && citations[0]!=0) return 1;
      for(int i = 0; i<citations.length; i++){
        if(citations[i]>= citations.length-i) return citations.length-i;
      }

      return 0;
    }
  }
