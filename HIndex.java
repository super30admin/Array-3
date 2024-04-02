package week10.day1;
//TC - O(n)
//SC - O(n)
class Solution29 {
    public int hIndex(int[] citations) {
        int[] count = new int[citations.length+1];
        int len = count.length-1;
        for(int i=0;i<citations.length;i++){
            int n = citations[i];
            if(n < count.length){
                count[n]++;
            }
            else
             count[len]++;
        }
        int sum =0;
        for(int j=len;j>=0;j--){
            sum = sum +count[j];
            if(sum>=j)
                return j;
        }
        return 123;
    }
}
public class HIndex {

	public static void main(String[] args) {
		int[] height = { 3,0,6,1,5 };
		Solution29 s2 = new Solution29();
		System.out.println(s2.hIndex(height));

	}

}
