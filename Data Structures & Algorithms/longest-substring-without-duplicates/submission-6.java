class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length <= 1) {
            return length;
        }
        int[] lastSeenPos = new int[128];
        int result = 0;
        int i = 0;

        for (int j = 0; j < length; j++) {
            char currChar = s.charAt(j);
            i = Math.max(lastSeenPos[currChar], i);
            result = Math.max(result, j - i + 1);
            lastSeenPos[currChar] = j + 1;
        }

        return result;
    }
}
