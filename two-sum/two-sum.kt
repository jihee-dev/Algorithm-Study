class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val tempMap = mutableMapOf<Int, Int>()

        nums.forEachIndexed { index, value ->
            tempMap[target - value]?.let { 
                return@twoSum intArrayOf(it, index)
            }
            tempMap[value] = index
        }
        
        return intArrayOf()
    }
}