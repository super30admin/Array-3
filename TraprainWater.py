#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Sep 30 11:17:52 2019

@author: tanvirkaur
"""
class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        leftwall= max height on the left of the test wall 
        rightwall = max height on the right of the test wall 
        Important point is that both the wall on the sides of the test wall must be greater inorder to collect water
        """
        left = 0
        right = len(height) - 1
        leftwall = 0
        rightwall = 0
        amountOfWater = 0
        while(left <= right):
            if leftwall < rightwall:
                if leftwall < height[left]:
                    leftwall = height[left]
                else:
                    amountOfWater += leftwall - height[left]
                left += 1
            else:
                if rightwall < height[right]:
                    rightwall = height[right]
                else:
                    amountOfWater += rightwall - height[right]
                right += -1
        return amountOfWater
                    