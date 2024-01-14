//TC : O(n)
//SC: O(n)

public class H_Index {
    public int hIndex(int[] citations) {
      //Arrays.sort(citations);

      int[] bucket = new int[citations.length +1];

      for(int i = 0; i<citations.length; i++){

        if(citations[i] > citations.length){
          bucket[citations.length]++;
        }
        else{
          bucket[citations[i]]++;
        }
      }

      int c=0;
      for(int i = bucket.length-1; i>= 0; i--){
        c = c + bucket[i];
        //System.out.println(c);
        if(c>= i) return i;
      }

      return 0;
    }
  }
