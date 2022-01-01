class Solution {
    public int hIndex(int[] citations) {
        int arr[] = new int[citations.length+1];
        for(int i:citations)
            arr[i>citations.length?citations.length:i]++;
        int cumSum = 0;
        for(int i=citations.length;i>=0;i--)
            if((cumSum = cumSum + arr[i])>=i)
                return i;

        return 0;
    }
}