class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int arr[]=new int[n+1];
        for(int i=0;i<n;i++)
        {
            arr[Math.min(n,citations[i])]++;
        }
        
        int sum=0;
        for(int i=n;i>=0;i--)
        {
            sum=sum+arr[i];
            if(sum>=i) return i;
        }
        return 187;
    }
}
