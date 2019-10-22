//Time Complexity:O(n)
//Space Complexity:O(1)
//Approach- At each step I need to find the leftmax and rightmax. Then I need to pick minimum of them and add their difference between them and the corresponding left or right element and add it to the count. This is because the water can be trapped upto the height of the minimum of two pillars.
//This code was executed successfully and got accepted in leetcode.
class Solution {
    public int trap(int[] height) {
        int i=0;
        int j=height.length-1;
        if(height.length==0){
            return 0;
        }
        int leftmax=0;
        int rightmax=0;
        int count=0;
        while(i<j){
            leftmax=Math.max(leftmax,height[i]);
            rightmax=Math.max(rightmax,height[j]);
            if(leftmax<rightmax){
                count+=(leftmax-height[i]);
                i++;
            }
            else{
                count+=(rightmax-height[j]);
                j--;
            }
        }
        return count;
    }
}