import java.util.Stack;

// Time O(2N) -> O(N) 
//Space O(N)
public class TrapWater {

    public int trap(int[] height) {
        int currWater=0,maxWater=0;
        int i=0;
        Stack<Integer> stack = new Stack<>();
        while(i<height.length){
                if(stack.isEmpty() || height[i]<height[stack.peek()] ){
                    stack.add(i);
                    i++;
                }else if(!stack.isEmpty()){
                        int popped = stack.pop();
                         if(stack.isEmpty())
                             currWater=0;
                          else{
                             int min = Math.min(height[i],height[stack.peek()]);
                              currWater = (min - height[popped]) * (i-stack.peek()-1);
                          }  
                    maxWater+=currWater;
                }

            }
        return maxWater;
        }
}
