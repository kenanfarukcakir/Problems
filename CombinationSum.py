

# add to result when found solution
def findNumbers(nums, targetSum, result, solution: list, index):

    if(targetSum == 0):
        # copy kullanmazsan reference kayboluyor,boş listeler geliyor
        result.append(solution.copy())
        return

    while(index < len(nums) and targetSum - nums[index] >= 0):
        solution.append(nums[index])

        findNumbers(nums, targetSum - nums[index], result, solution, index)
        index += 1

        solution.pop()


def combinationSum(nums, targetSum):
    nums.sort()
    nums = list(dict.fromkeys(nums))

    result = []
    solution = []
    index = 0
    findNumbers(nums, targetSum, result, solution, index)

    return result


if __name__ == "__main__":
    print(combinationSum([2, 3, 5], 8))
    # [[2, 2, 2, 2], [2, 3, 3], [3, 5]]
