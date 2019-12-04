# LeetCode - Container With Most Water
class Solution:

    def maxArea(self, height):  # height:list
        i = 0
        j = len(height) - 1

        area = 0
        while j > i:
            h = (height[i] if height[i] < height[j] else height[j])
            area = max(area, (j-i) * h)
            if(height[i] < height[j]):
                i = i+1
            else:
                j = j-1

        return area
