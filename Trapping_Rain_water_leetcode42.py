class Solution:
    def trap(self, height: List[int]) -> int:
        # Two pointers
        # SC - O(n) for left_answer, right_answer each, O(1) - pivot
        # TC  - O(n) for left pass, right pass, for loop for final answer each

        left = 0
        right = left + 1  # ie. right = 1
        left_answer = [0] * len(height)
        right_answer = [0] * len(height)

        while right < len(height) - 1:
            if height[right] < height[left]:
                right += 1
            if height[right] >= height[left]:
                pivot = left + 1
                while pivot < right:
                    left_answer[pivot] = height[left] - height[pivot]
                    pivot += 1
                left = right
                right = right + 1

        right = len(height) - 1
        left = right - 1

        while left > 0:
            if height[left] < height[right]:
                left -= 1
            if height[left] >= height[right]:
                pivot = right - 1
                while pivot > left:
                    right_answer[pivot] = height[right] - height[pivot]
                    pivot -= 1
                right = left
                left = left - 1

        answer = 0
        for i in range(len(height)):
            answer += max(left_answer[i], right_answer[i])

        print(left_answer, right_answer)
        return answer

    '''    
        # DP - TC - O(n) SC - O(n)
        left_max = [0]*len(height)
        right_max = [0]*len(height)
        answer = 0

        left_max[0] = height[0]
        for i in range(1, len(height)):                  # TC - O(n)
            left_max[i] = max(left_max[i-1],height[i])  

        right_max[len(height)-1] = height[len(height)-1]
        for i in range(len(height)-2,-1,-1):             # TC - O(n)
                right_max[i] = max(right_max[i+1],height[i]) 

        for i in range(len(height)):                     # TC - O(n)
            answer += max(0, min(left_max[i],right_max[i]) - height[i])
        return answer
    '''

    '''
        # Brute Force - Time limite exceeded
        # TC  - O(n**2) 
        # SC - O(1)
        answer = 0
        for i in range(len(height)):  # TC - O(n)
            left_max = 0
            right_max = 0
            if i >0:
                left_max = max(height[0:i])   # TC - O(n)
            if i < len(height)-1:
                right_max = max(height[i+1:len(height)])  # TC - O(n)
            answer += max(0, min(left_max,right_max) - height[i])
        return answer
    '''

    '''

        # Two pointers 
        # SC - O(n) for left_answer, right_answer each, O(1) - pivot
        # TC  - O(n) for left pass, right pass, for loop for final answer each
        left = 0
        right = left + 1        # ie. right = 1
        curr_answer = 0
        answer = 0


        while right<len(height)-1:
            if height[right] < height[left]:
                right += 1
                answer += curr_answer
                curr_answer = 0
            if height[right] >= height[left]:
                pivot = left+1
                while pivot < right:
                    curr_answer += height[left] - height[pivot]
                    pivot += 1
                left = right
                right = right + 1



        peak = right
        right = len(height)-1
        left = right -1
        curr_answer = 0

        while left>=peak:
            if height[left] < height[right]:
                pivot = right-1
                while pivot > left:
                    curr_answer  += height[right] - height[pivot]
                    pivot -= 1
                right = left
                left = left - 1
            if height[left] >= height[right]:
                left -= 1
                answer += curr_answer
                curr_answer = 0

        return answer

    '''



