class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var localMax = 0
        var globalMax = nums[0]

        for (i in nums.indices) {
            localMax = max(nums[i], nums[i] + localMax)
            globalMax = max(globalMax, localMax)
        }

        return globalMax
    }
}