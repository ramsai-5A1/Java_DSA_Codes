
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
    TrieNode head;
    public Trie() {
        this.head = new TrieNode();
    }
    
    public void insertWord(String word) {
        int n = word.length();
        TrieNode curr = this.head;
        for (int index = 0; index < n; index++) {
            int position = word.charAt(index) - 'a';
            if (curr.arr[position] == null) {
                curr.arr[position] = new TrieNode();
            }
            curr = curr.arr[position];
        }
        curr.isEnd = true;
        System.out.println("Inserted " + word);
    }
    
    public boolean searchWord(String word) {
        int n = word.length();
        TrieNode curr = head;
        for (int index = 0; index < n; index++) {
            int position = word.charAt(index) - 'a';
            if (curr.arr[position] == null) {
                return false;
            }
            curr = curr.arr[position];
        }
        return curr.isEnd ? true : false;
    }
    
    public boolean startsWith(String word) {
        int n = word.length();
        TrieNode curr = this.head;
        for (int index = 0; index < n; index++) {
            int position = word.charAt(index) - 'a';
            if (curr.arr[position] == null) {
                return false;
            }
            curr = curr.arr[position];
        }
        return true;
    }
}



class TrieProgram {
    
    public static void main(String[] args) {
       Trie trie1 = new Trie();
       String[] words = {"hello", "hell", "workshop", "java"};
       for (String word: words) {
           trie1.insertWord(word);
       } 
       
       System.out.println(trie1.startsWith("work"));
       System.out.println(trie1.startsWith("jau"));
    }
}