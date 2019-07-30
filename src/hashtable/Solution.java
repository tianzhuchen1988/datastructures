package hashtable;

class Solution {
    public int firstUniqChar(String s) {
        int[] seqArr = new int[26];
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            seqArr[c - 'a']++;
        }

        for(int i = 0; i < s.length(); i++){
            if(seqArr[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }

        return -1;
    }
}
