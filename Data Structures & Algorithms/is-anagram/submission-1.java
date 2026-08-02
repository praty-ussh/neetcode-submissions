class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            charCount.put(s.charAt(i), charCount.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(int i=0; i<t.length(); i++){
            charCount.computeIfPresent(t.charAt(i), (key, value) -> value - 1);
            if(!charCount.containsKey(t.charAt(i))){
                return false;
            }
        }
        for(int freq : charCount.values()){
            if(freq >= 1){
                return false;
            }
        }
        return true;
    }
}
