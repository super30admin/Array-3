// //tc- O(n)
// class Solution {
//     public int trap(int[] height) {
//         int n = height.length;
//         int result = 0;
//         int maxId = -1;
//         int max = 0;

//         for(int i = 0; i < n; i++){//get the max height and index of wall 
//             if(max < height[i]){
//                 max = height[i];
//                 maxId = i;
//             }
//         }

//         int l = 0, lw = 0;

//         while(l < maxId){//until l is less than max wall in future
//             if(lw > height[l]){//left wall to present wall is higher
//                 result += lw - height[l];//add to result the diff
//             }else{
//                 lw = height[l];//if left wall is not higher than present wall than make present wall left higest wall for
//                 //future comparisons
//             }
//             l++;
//         }

//         int r = n-1, rw = 0;

//         while(r  > maxId){//until r is greater than max wall in the left
//             if(rw > height[r]){//right wall to present wall is higher
//                 result += rw - height[r];//add to result the diff
//             }else{
//                 rw = height[r];//if right wall is not higher than present wall than make present wall right higest wall for
//                 //future comparisons
//             }
//             r--;
//         }

//         return result;     
//     }
// }


// //tc- O(n), without calculating max wall
// class Solution {
//     public int trap(int[] height) {
//         int n = height.length;
//         int result = 0;

//         int l = 0, lw = height[0];
//         int r = n - 1, rw = height[n-1];

//         while(l <= r){
//             if(rw > lw){//bigger right wall
//                 if(lw > height[l]){//left wall to present wall is higher
//                 result += lw - height[l];//add to result the diff
//                  }else{
//                   lw = height[l];//if left wall is not higher than present wall than make present wall left higest wall for
//                  //future comparisons
//                   }
//                   l++;
//             }else{
//                 if(rw > height[r]){//right wall to present wall is higher
//                 result += rw - height[r];//add to result the diff
//                 }else{
//                 rw = height[r];//if right wall is not higher than present wall than make present wall right higest wall for
//                 //future comparisons
//                 }
//                 r--;
//             }
//        }

//         return result;     
//     }
// }


//tc- O(n), without calculating max wall
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int result = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && height[i] > height[st.peek()]){//incoming ele from right wall
               int popped = st.pop();// wall/building we are resolving
               //top of the stack my left wall now
               if(!st.isEmpty()){
                   int minHeight = Math.min(height[i], height[st.peek()]);
                   result += (minHeight - height[popped]) * (i - st.peek() - 1);
               }

            }
            st.push(i);
        }
        return result;     
    }
}