class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> mp = new HashMap<>();
        for(int i=0; i<strs.length; i++){
            ArrayList<String> li = new ArrayList<>();
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String st = new String(arr);
            mp.putIfAbsent(st, new ArrayList<>());
            mp.get(st).add(strs[i]);
        }
        List<List<String>> ls = new ArrayList<>(mp.values());
        return ls;
    }
}
