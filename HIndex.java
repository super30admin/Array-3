//TC = O(N)
//SC = O(N)

/*
 * Running Sum Technique is used to maintain all the frequencies of 
 * the citations. When the citations match with the index when looked from the last 
 * element, the index is given as the answer.
 */

public class HIndex {
    
    public static int hIndex(int[] citations)
    {
        if(citations == null || citations.length == 0) return 0;


        int[] buckets = new int[citations.length+1];
        int n = citations.length;

        for(int i =0;i<citations.length;i++)
        {
            if(citations[i]>n)
            {
                buckets[n]++;
            }
            else{
                buckets[citations[i]]++;
            }
        }

        int sum = 0;

        for(int i = n;i>=0;i--)
        {
            sum+=buckets[i];

            if(sum>=i)
            {
                return i;
            }
        }

        return 0;

    }

    public static void main(String args[])
    {
        int[] citations = {3,0,6,1,5};
        System.out.println(hIndex(citations));
    }
}
