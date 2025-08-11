//time complexity- O(n log(n)) where n is array length
//space complexity- O(1)
import java.util.*;
public class HIndex {
    static int hIndex(int[] citations) {
        int n = citations.length;
        int max = 0;
        Arrays.sort(citations);

        for(int i = 1; i <= n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(citations[j] >= i) count++;
            }
            if(count >= i) max = Math.max(max, i);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};
        System.out.println("H index is: "+ hIndex(citations));
    }
}
