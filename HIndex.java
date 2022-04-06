import java.util.Arrays;
/*
Time complexity: O(nlogn+n) n is the length of citations array, (nlogn) for the sorting of the given citations array and
n is for simple iteration over the array~ amortized it would be (nlogn)

Space Complexity: O(1)

Run on leetcode: yes
Any difficulties: yes, this problem is not easy to understand

Approach:
1. I will be sorting the citations array and then comparing values to get hIndex to satisfy the condition for H-Index

 */
public class HIndex {
    public static int hIndex(int[] citations){
        Arrays.sort(citations);
        int hIndex = 0;
        for(int i = citations.length-1; i>=0; i--){
            int count = citations.length-i;
            if(count<=citations[i]){
                hIndex=count;
            }else{
                break;
            }
        }
        return hIndex;
    }
    public static void main(String[] args){
        int[] citations = {3,0,6,1,5};

        System.out.println("H Index: "+hIndex(citations));
    }
}
