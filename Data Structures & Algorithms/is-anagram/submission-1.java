class Solution {
    public boolean isAnagram(String s, String t) {
        if (t.length() != s.length()) {
        return false;
        }
        HashMap<Character,Integer> letters = new HashMap<>();
        // get letters in s
        for (char letter : s.toCharArray()) {
            int count = letters.getOrDefault(letter, 0) + 1;
            letters.put(letter, count);
        }

        for (char letter : t.toCharArray()) {
            // if key is not contained (anymore), letters do not match
            if (!letters.containsKey(letter)) {
                return false;
            }

            // count "down" letters
            int count = letters.get(letter) - 1;
            letters.put(letter, count);

            // remove letters if the same amount has been found in t
            if (count == 0) {
                letters.remove(letter);
            }
        }
        return true;
    }
}
