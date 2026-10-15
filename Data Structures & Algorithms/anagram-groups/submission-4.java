class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 1){
            return List.of(List.of(strs[0]));
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            char ch[] = str.toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);
            if(!map.containsKey(s))
                map.put(s, new ArrayList<>(List.of(str)));
            else
                map.get(s).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
