class Solution {
    public int trap(int[] height) {
        Stack<Pair<Integer, Integer>> s = new Stack<>();
        int max_area  = 0;
        
        for(int i = 0 ; i < height.length; i++){
            
            while(!s.isEmpty() && height[i] > s.peek().getKey()){
                
                //calculate the area.
                
                //get the width.
                Pair<Integer, Integer> popped = s.pop();
                
                //We put this condition because we have to do a peek()
                if(s.isEmpty()){
                    break;
                }
                
                Pair<Integer, Integer> top = s.peek();
                int width = i - s.peek().getValue() - 1;
                int h = Math.min(top.getKey(), height[i]) - popped.getKey();
                
                max_area += h * width;
                
            }
            
            s.push(new Pair<Integer, Integer>(height[i], i));
            
        }
        
        return max_area;
    }
}