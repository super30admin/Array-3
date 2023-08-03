import java.util.Arrays;

public class Problem42 {
    public int hIndex1(int[] citations) {
        //TC=O(nlogn)
        //SC=O(1)
        if(citations==null || citations.length==0)
            return 0;
        Arrays.sort(citations);
        int low=0;
        int n=citations.length;
        int high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int diff=n-mid;
            if(citations[mid]==diff)
                return diff;
            else if(citations[mid]>diff)
                high=mid-1;
            else
                low=mid+1;
        }

        return n-low;
    }
    public int hIndex(int[] citations) {
        //TC=O(n)
        //SC=O(n)
        int n=citations.length;
        if(citations==null || citations.length==0)
            return 0;
        int[] bucketList=new int[n+1];
        for(int i=0;i<n;i++){
            if(citations[i]>=n)
                bucketList[n]++;
            else
                bucketList[citations[i]]++;
        }
        int sum=0;
        for(int i=n;i>=0;i--){
            sum+=bucketList[i];
            if(sum>=i)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        Problem42 problem=new Problem42();
        System.out.println(problem.hIndex(new int[]{3,0,6,1,5}));
        System.out.println(problem.hIndex1(new int[]{3,0,6,1,5}));
    }
}
