package leetcode.leetcode242;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        int[] arr = new int[26];
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        for(int i = 0; i < s.length(); i++) {
            arr[sChar[i] - 'a']++;
            arr[tChar[i] - 'a']--;
        }

        for(int n : arr) {
            if(n != 0){
                return false;
            }
        }

        return true;
    }
}
