package Advanced DSA.Tries;

public class PhoneDirectory {
    class TrieNode {
        boolean isEnd;
        TrieNode[] arr;
        
        public TrieNode() {
            this.isEnd = false;
            this.arr = new TrieNode[26];
            
            for (int position = 0; position < 26; position++) {
                this.arr[position] = null;
            }
        }
    }
    
    class Trie {
        TrieNode root;
        
        public Trie() {
            this.root = new TrieNode();
        }
        
        public void insertWord(String word) {
            int n = word.length();
            TrieNode currNode = this.root;
            
            for (int index = 0; index < n; index++) {
                int position = word.charAt(index) - 'a';
                if (currNode.arr[position] == null) {
                    currNode.arr[position] = new TrieNode();   
                }
                currNode = currNode.arr[position];
            }
            currNode.isEnd = true;
        }
        
        
        private void prefixHelper(TrieNode currNode, ArrayList<String> subResult, StringBuilder prefix) {
            if (currNode == null) {
                return;
            } else if (currNode.isEnd == true) {
                subResult.add(prefix.toString());
            }
            
            for (int position = 0; position < 26; position++) {
                if (currNode.arr[position] != null) {
                    prefix.append((char) ('a' + position));
                    this.prefixHelper(currNode.arr[position], subResult, prefix);
                    prefix.deleteCharAt(prefix.length() - 1);
                }
            }
        }
        
        public ArrayList<ArrayList<String>> getAllPrefixes(String word) {
            ArrayList<ArrayList<String>> result = new ArrayList<>();
            int n = word.length();
            TrieNode currNode = this.root;
            StringBuilder prefix = new StringBuilder();
            
            for (int index = 0; index < n; index++) {
                ArrayList<String> subResult = new ArrayList<>();
                prefix.append(word.charAt(index));
                if (currNode != null) {
                    currNode = currNode.arr[word.charAt(index) - 'a'];
                }
                this.prefixHelper(currNode, subResult, prefix);
                if (subResult.size() == 0) {
                    subResult.add("0");
                }
                result.add(subResult);
            }
            return result;
        }
    }
    
    class Solution{
        static ArrayList<ArrayList<String>> displayContacts(int n, 
                                            String contact[], String s) {
                                    
            Trie trie = new Trie();
            for (String word: contact) {
                trie.insertWord(word);
            }
            return trie.getAllPrefixes(s);
        }
    }
}
