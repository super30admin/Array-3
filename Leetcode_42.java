//way1:
//USe monotonic decreasing stack
//Put all the decereasing elements.
//If increasing element is found, calculate result by keep on popping from stack
//Else put in stack
//TC: O(n)
//SC: O(n)
class Solution {
    public int trap(int[] height) {
        int result=0;
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);

        for(int i=0;i<height.length;i++){
            while(stack.peek()!=-1 && height[i]>height[stack.peek()]){
                int rw=height[i];
                int curr=height[stack.pop()];
                if(stack.peek()!=-1){
                    
                    int lw=height[stack.peek()];

                    int eh=Math.min(lw,rw) - curr;
                    int ew= i-stack.peek()-1;

                    result=result+(eh*ew);

                }
            }

            

            stack.push(i);
        }
        return result;
    }
}


//way2
//Identify the heightest wall in one pass
//Left side to heightest wall: Consider height wall as right boundary. Travel from left side. If left wall > curr height -> add to reuslt. Else.\ make left wall to current height
//Follow simitlarly for right side as well
//TC: O(2n)
//SC: O(1);
class Solution {
    public int trap(int[] height) {
        int max=Integer.MIN_VALUE;
        int maxIdx=-1;

        for(int i=0;i<height.length;i++){
            if(max<height[i]){
                max=height[i];
                maxIdx=i;
            }
        }

        int l=0;
        int lw=0;
        int result=0;

        while(l<maxIdx){
            if(height[l]<height[lw]){
                result=result+(height[lw]-height[l]);

            }else{
                lw=l;
            }
            l++;
        }

        int r=height.length-1;
        int rw=height.length-1;

        while(r>maxIdx){
            if(height[r]<height[rw]){
                result=result+(height[rw]-height[r]);

            }else{
                rw=r;
            }
            r--;
        }

        return result;


        
    }
}


//way3:
//Two pointer
//lw=-1, l=0; rw=-1, r=height.lenght-1
//If lw > rw -> Consider lw as left boundary. And in right side, if height[r]<rw-> add to result. Else, make rw as r
//Vice versa for left side as well
//TC: O(n)
//SC: O(1)
class Solution {
    public int trap(int[] height) {
        int lw=-1;
        int rw=-1;
        int l=0;
        int r=height.length-1;
        int result=0;

        while(l<=r)
        {
            if(height[l]<=height[r]){
                if(lw>height[l]){

                    result=result+(lw-height[l]);

                }else{
                    lw=height[l];
                }
                l++;
            }else{
                if(rw>height[r]){

                    result=result+(rw-height[r]);

                }else{
                    rw=height[r];
                }
                r--;

            }
        }

        return result;
        
    }
}


//way4
class Solution {
    public int trap(int[] height) {
        int n=height.length;

        int[] prefix=new int[n];
        int[] suffix=new int[n];

        //prefix
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,height[i]);
            prefix[i]=max;
        }

        //suffix
        max=0;
        for(int i=n-1;i>=0;i--){
            max=Math.max(max,height[i]);
            suffix[i]=max;
        }

       
        //result
        int result=0;
        for(int i=1;i<=n-2;i++){
          
            result=Math.max(result,result+(Math.min(prefix[i-1],suffix[i+1])-height[i]));

        }

        return result;
        
    }
}
