public class HindexI {
    //TC O(n)
    //SC O(n)
    public static void main(String[] args) {
        int[]  citations = {3,0,6,1,5};
        System.out.println(hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        if(citations==null||citations.length==0) return 0;
        int n = citations.length;
        int[] buckets = new int[n+1];
        for(int i = 0;i<n;i++){
            if(citations[i]>n) buckets[n]++;
            else buckets[citations[i]]++;
        }
        int rsum=0;
        for(int i =n;i>=0;i--){
            rsum += buckets[i];
            if(rsum>=i) return i;
        }



        return 0;
    }




    //TC O(nlogn)
    //  SC O(1)
    /*
    public static int hIndex(int[] citations) {
        if(citations==null||citations.length==0) return 0;
        int n = citations.length;
        Arrays.sort(citations);
        for(int i = 0 ;i<n;i++){
            int diff = n-i;
            if(citations[i]>=diff) return diff;
        }
        return 0;
    }*/

}
