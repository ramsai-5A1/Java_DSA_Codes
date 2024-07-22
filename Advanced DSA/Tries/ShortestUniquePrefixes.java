
class TrieNode {
    int passing;
    TrieNode[] arr;

    public TrieNode() {
        this.passing = 0;
        this.arr = new TrieNode[26];

        for (int index = 0; index < 26; index++) {
            this.arr[index] = null;
        }
    }
}

class Trie {
    private TrieNode head;

    public Trie() {
        this.head = new TrieNode();
    }
    
    public void insert(String word) {
        int n = word.length();
        TrieNode curr = this.head;

        for (int index = 0; index < n; index++) {
            int position = word.charAt(index) - 'a';
            if (curr.arr[position] == null) {
                curr.arr[position] = new TrieNode();
            }
            curr = curr.arr[position];
            curr.passing++;
        }
    }
    
    public String findSmallerPrefix(String word) {
        int n = word.length();
        TrieNode curr = this.head;
        StringBuffer result = new StringBuffer();
        for (int index = 0; index < n; index++) {
            result.append(word.charAt(index));
            int position = word.charAt(index) - 'a';
            if (curr.arr[position].passing == 1) {
                break;
            }
            curr = curr.arr[position];
        }
        return result.toString();
    }
}

class Solution {
    static String[] findPrefixes(String[] arr, int N) {
        Trie trie = new Trie();
        String[] result = new String[N];
        for (String word: arr) {
            trie.insert(word);
        }
        
        int index = 0;
        for (String word: arr) {
            result[index] = trie.findSmallerPrefix(word);
            index++;
        }
        return result;
    }
};
