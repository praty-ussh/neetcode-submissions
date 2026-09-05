class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = (int)Math.ceil(s.length()/0.75);
        int length = s.length();
        if(s.length() == 1){
            return 1;
        }
        Set<Character> set = new HashSet<>(n);
        int result = 0;
        int i=0;
        for(int j=0; j< length; j++){
            while(!set.add(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            }
            result = Math.max(set.size(), result);
        }
        return result;
    }
}
