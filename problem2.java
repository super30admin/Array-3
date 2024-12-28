public class problem2 {
    // Time Complexity: 0(n)
    // Space Complexity:0(n)
    public int hIndex(int[] citations) {
        int n= citations.length;
        int[] buckets= new int[n+1];

        for(int el: citations)
        {
            if(el>=n)
            {
                buckets[n]++;
            }
            else
            {
                buckets[el]++;
            }

        }
        int sum=0;
        for(int i=n;i>=0;i--)
        {
            sum+= buckets[i];
            if(sum>=i)
            {
                return i;
            }
        }
        return 111;

    }

}
