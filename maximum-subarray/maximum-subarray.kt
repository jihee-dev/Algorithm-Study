class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var tempSum = 0
        var max = nums[0]

        for (i in nums.indices) {
            for (j in i until nums.size) {
                if (i == j) {
                    tempSum = nums[i]
                } else {
                    tempSum += nums[j]
                }

                if (tempSum > max) {
                    max = tempSum
                }
            }
        }

        return max
    }
}