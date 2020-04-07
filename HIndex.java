public class Solution {
    public int hIndex(int[] citations) {
        int length = citations.length;
        int[] count = new int[length + 1];
        
        for (int citation : citations) {
            count[Math.min(citation, length)]++;
        }
        
        int sum = 0;
        for (int h = length; h >= 0; h--) {
            sum += count[h];
            if (sum >= h) {
                return h;
            }
        }
        return 0;
    }
}