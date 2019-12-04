# LeetCode - Letter Combinations of a Phone Number
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:

        def cartesian(lst1, lst2):
            result = []
            for i in lst1:
                for j in lst2:
                    result.append(i+j)
            return result

        letters = [[], [], ['a', 'b', 'c'], ['d', 'e', 'f'],
                   ['g', 'h', 'i'], ['j', 'k', 'l'], ['m', 'n', 'o'],
                   ['p', 'q', 'r', 's'], ['t', 'u', 'v'], ['w', 'x', 'y', 'z']]

        if(len(digits) == 0):
            return ""
        elif(len(digits) == 1):
            return letters[int(digits[0])]
        elif(len(digits) == 2):
            return cartesian(letters[int(digits[0])], letters[int(digits[1])])
        else:
            return cartesian(letters[int(digits[0])], self.letterCombinations(digits[1:]))
