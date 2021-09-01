class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var tempMap = mutableMapOf<Char, Char>()
        var j = 0
        var max = 0

        for (i in s.indices) {
            while (j < s.length) {
                if (tempMap.containsKey(s[j])) {
                    break
                }
                tempMap[s[j]] = s[j]
                j++
            }
            max = maxOf(max, j - i)
            tempMap.remove(s[i])
        }

        return max
    }
}