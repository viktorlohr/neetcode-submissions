class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // (signature, words)
        HashMap<List<Integer>,List<String>> signatureToWords = 
                new HashMap<>();
        
        for (String s : strs) {

            // [2,1,...] means 'a' is in the word twice, 'b' once
            List<Integer> signature = new ArrayList<>();

            // set initial count to zero for every letter;
            for (int i = 0; i < 26; i++) {
                signature.add(0);
            }

            // increase count if letter is found (again)
            for (char letter : s.toCharArray()) {
                int position = letter - 'a';
                signature.set(position, signature.get(position) + 1);
            }
            
            // get all previous words with that signature and add s;
            List<String> sameSignatureWords = new ArrayList<>();
            if (signatureToWords.containsKey(signature)) {
                sameSignatureWords = 
                    signatureToWords.get(signature);
            }
            sameSignatureWords.add(s);

            // update HashMap
            signatureToWords.put(signature, sameSignatureWords);
        }

        // creates a list out of all values
        return new ArrayList<>(signatureToWords.values());
    }
}
