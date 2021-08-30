class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        var resultXIdx = -1
        var resultYIdx = -1

        for(i in 0 until nums.size - 1) {
            for (j in i + 1 until nums.size) {
                if(nums[i] + nums[j] == target) {
                    resultXIdx = i
                    resultYIdx = j
                    break
                }
            }
        }

        return intArrayOf(resultXIdx, resultYIdx)
    }
}