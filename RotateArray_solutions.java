package codes;

public class RotateArray_solutions {

	 public void rotate(int[] nums, int k) {
	        k%=nums.length;
	        
	        int temp, previous;
	        
	        for(int i=0;i<k;i++){
	        	previous=nums[nums.length-1];
	            for(int j=0;j<nums.length;j++){
	                temp=nums[j];
	                nums[j]=previous;
	                previous=temp;
	            }
	        }
	    }
	 
	 
	    public void rotate2(int[] nums, int k) {
	        int [] a = new int [nums.length];
	        for(int i=0;i<nums.length;i++){
	            a[(i+k)%nums.length]=nums[i];
	        }
	        
	        
	        for(int i=0;i<nums.length;i++){
	            nums[i]=a[i];
	        }
	    }
	    
	    
	    
	    
	    public void rotate3(int[] nums, int k) {
        k%=nums.length;
	        // reverse entire array
	        reverse(nums,0,nums.length-1);
	        //reveres first k elements
	        reverse(nums,0,k-1);
	        //reverse last n-k elements
	        reverse(nums,k,nums.length-1);
	    }
	    
	    
	    public void reverse (int [] nums,int start, int end){
	        while (start<end){
	            int temp =nums[start];
	            nums[start]=nums[end];
	            nums[end]=temp;
	            start++;
	            end--;
	        }
	    }
	    
	 
	 
	 
}
