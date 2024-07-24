package Advanced DSA.Tries;

public class DesignSearchAndAddDataStructure {
    class TrieNode {
        boolean isEnd;
        TrieNode[] arr;
        
        public TrieNode() {
            this.isEnd = false;
            this.arr = new TrieNode[26];
            for (int i = 0; i < 26; i++) {
                this.arr[i] = null;
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
            TrieNode curr = this.root;
            for (int index = 0; index < n; index++) {
                int position = word.charAt(index) - 'a';
                if (curr.arr[position] == null) {
                    curr.arr[position] = new TrieNode();
                }
                curr = curr.arr[position];
            }
            curr.isEnd = true;
        }
    
        private boolean searchHelper(String word, int index, int n, TrieNode currNode) {
            if (currNode == null) {
                return false;
            } else if (index == n) {
                return currNode.isEnd;
            }  else if (word.charAt(index) != '.') {
                int position = word.charAt(index) - 'a';
                return searchHelper(word, index + 1, n, currNode.arr[position]);
            }
    
            for (int position = 0; position < 26; position++) {
                if (currNode.arr[position] != null && searchHelper(word, index + 1, n, currNode.arr[position])) {
                    return true;
                }
            }
            return false;
        }
        
        public boolean searchWord(String word) {
            return searchHelper(word, 0, word.length(), this.root);
        }
    }
    
    
    
    class WordDictionary {
    
        private Trie trie;
    
        public WordDictionary() {
            this.trie = new Trie();
        }
        
        public void addWord(String word) {
            trie.insertWord(word);
        }
        
        public boolean search(String word) {
            return trie.searchWord(word);
        }
    }
    
    /**
     * Your WordDictionary object will be instantiated and called as such:
     * WordDictionary obj = new WordDictionary();
     * obj.addWord(word);
     * boolean param_2 = obj.search(word);
     */
}
