//Time Complexity: O(n); where n is the length of citations array
//Space Complexity: O(n)
//Code run successfully on LeetCode.

public class Problem2_2 {

    public int hIndex(int[] citations)
    {
        if(citations == null|| citations.length == 0)
            return 0;
        
        int n = citations.length;
        
        int[] result = new int[n+1];
        
        for(int i =0; i <n; i++)
        {
            if(citations[i] <= n)
                result[citations[i]]++;
            else
                result[n]++;
        }
        
        int sum =0;
        
        for(int i =n; i >=0; i--)
        {
            sum += result[i];
            
            if(sum >= i)
                return i;
        }
        
        return 0;
    }
}
