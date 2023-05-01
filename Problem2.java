//Time-> o(n)
//Space-> O(n)

public class Problem2 {
        public int hIndex(int[] citations) {
            int n = citations.length; 
            int bucket[] = new int[n+1];
            for(int citation: citations){
                if(citation >= n){
                    bucket[n]++;
                }
                else{
                    bucket[citation]++;
                }
            }
            int sum = 0; 
            for(int i = n; i >= 0; i--){
                sum += bucket[i];
                if(sum >= i)
                    return i;
            }
            return 0;
        }
}
