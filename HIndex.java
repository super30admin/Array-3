class HIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buc = new int[n+1];
        for(int i=0;i<n;i++)
        {
            if(citations[i] >= n)
            {
                buc[n]++;
            }
            else{
                    buc[citations[i]]++;
            }
        }
        int count =0;
        for(int i=n;i>=0;i--)
        {
            count+=buc[i];
            if(count >=i)
            {
                return i;
            }
        }
        return 0;
    }
}

//tc: O(n)
//sc: O(n)