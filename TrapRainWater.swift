//
//  TrapRainWater.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 2/27/26.
//

/*
 Approach 1 -
 Find the maximum in the array.
 This maximum can act as a right wall for elements situated towards the left side.
 This maximum can act as a left wall for elements situated towards the right side.
 
 Iterate from left until u meet the meax.
 take 2 pointers -  left and leftWall
 When leftwall is smaller than the left, then move leftWall and left both.
 When leftWall is greater than left, calculate the trapped water by taking the minimum in left and right wall. Evidently, left wall is smaller than right wall (which is maximum). calculate => (leftwall height - height of current left pointer)
 stop until u meet maximum
 
 now loop fromt the right side until right pointer is greater than the maximum
 pointer are representing indices
 Again take 2 poiters - right wall and right
 If rightWall is smaller than right then move rightWall and right both towards left by decrementing both
 
 Approach2 -
 Using single pass
 
 Approach3 -
 Using monotonic stack
 Once we think that we want to identify the bigger height.
 When height is increasing, we don't have any trap
 as soon as height decreases, and then it increases then we can have trap
 [3, 2, 1, 0, 3] //trap between 0 and 3. trap water in horizontal histogram.
 We will start resolving for 0 element where 1 will act as left wall.
 Then we will resolve for 1 element, where 2 will act as left wall.
 then resolve for 2, where 3 will act as left wall.

 To resolve previous, then again its previous and so on... we use stack.. elements are in decreasing order in the stack. Hence it's called monotonic decreasing stack
 To resolve, pop element from the stack that we are resolving. Now, peek element is the left wall
 effective height  = (min(rightWall, peek elemnt's height) - poppedElement's height)
 width = index of rightWall(bigger element which is i) - peek element index - 1
 
 Monotonic stack has 2 variatons - monotonic decreasing stack and monotonic increasing stack.
 */

class TrapRainWater {
    
    /*
     Approach 1 -
     O(n) time complexity
     */
    func trap(_ height: [Int]) -> Int {
        
        var maximumHeight = 0
        var maximumHeightIndex = -1
        for i in 0..<height.count {
            if(height[i] > maximumHeight) {
                maximumHeight = height[i]
                maximumHeightIndex = i
            }
        }

        var trappedWater = 0
        var left = 1
        var leftWall = height[0]
        while (left < maximumHeightIndex) {
            if (leftWall < height[left]) {
                // leftWall += 1
                leftWall = height[left]
                left += 1
            } else {
                trappedWater += (leftWall - height[left])
                left += 1
            }
        }

        var right = height.count - 2
        var rightWall = height[height.count - 1]

        while (right > maximumHeightIndex) {
            if (rightWall < height[right]) {
                rightWall = height[right]
                right -= 1
            } else {
                trappedWater += (rightWall - height[right])
                right -= 1
            }
        }

        return trappedWater
    }

    //Time complexity - O(n)
    //without calculating the maximum. Single pass algorithm
    func trapUsingSinglePass(_ height: [Int]) -> Int {
        
        var trappedWater = 0
        var leftWall = height[0]
        var left = 1

        var rightWall = height[height.count - 1]
        var right = height.count - 2

        while(left <= right) {
            if (leftWall <= rightWall) {
                //process left side bacue we have guarantee on the right side
                if (height[left] < leftWall) {
                    trappedWater += (leftWall - height[left])
                } else {
                    leftWall = height[left]
                }
                left += 1

            } else if (rightWall < leftWall) {
                //process right side
                if (height[right] < rightWall) {
                    trappedWater += (rightWall - height[right])
                } else {
                    rightWall = height[right]
                }
                right -= 1
            }
        }
        return trappedWater
    }

}

/*
 Approach 2 - don't find maximum.
 leftWall and left -  at the start
 rightWall and right at the end of the array
 
 If leftWall > rightWall So, leftWall is guarateed aas bigger one for rightwall. So, process right side
 if leftWall == rightWall hright wise, so process any of the left or right side.
 If right is smaller than rightWall then can trap water
 
 */

class TrapRainWaterUsingMonotonicDecreasingStack {
    
    struct Stack<T> {
        private var array = [T]()

        mutating func push(_ element: T) {
            array.append(element)
        }

        mutating func pop() -> T? {
            return array.popLast()
        }

        var size: Int {
            return array.count
        }

        var peek: T? {
           return array.last
        }

        var isEmpty: Bool {
            return array.isEmpty
        }
    }

    init() {
        let height = [0,1,0,2,1,0,1,3,2,1,2,1]
        let trappedWater = trapUsingMonotonicDecreasingStack(height)
        print("trappedWater \(trappedWater)")
    }
    
    //Time complexity - O(n), space complexity - O(n) (stack space)
    func trapUsingMonotonicDecreasingStack(_ height: [Int]) -> Int {
        
        var trappedWater = 0
        var stack = Stack<Int>()
        stack.push(-1)
        stack.push(0)
        for i in 1..<height.count {

            while (stack.peek != -1 && height[i] > height[stack.peek!]) {
                //resolve
                let poppedIndex = stack.pop()!
                //rw= i
                //lw = st.peek
                if (stack.peek != -1) {
                    let effectiveHeight = min(height[i], height[stack.peek!]) - height[poppedIndex]
                    let effWidth = i - stack.peek! - 1
                    trappedWater += effectiveHeight * effWidth
                }
            }
            stack.push(i)
        }
        return trappedWater
    }

}
