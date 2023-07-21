import java.util.Arrays;

public class H_Index {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int diff = n - i;
            if (citations[i] >= diff) {
                return diff;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        H_Index solution = new H_Index();

        // Example input array
        int[] citations = { 3, 0, 6, 1, 5 };

        int hIndexValue = solution.hIndex(citations);
        System.out.println("H-Index: " + hIndexValue);
    }
}
