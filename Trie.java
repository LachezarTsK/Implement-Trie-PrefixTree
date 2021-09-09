public class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (current.branches[ch - 'a'] == null) {
                current.branches[ch - 'a'] = new TrieNode();
            }
            current = current.branches[ch - 'a'];
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (current.branches[ch - 'a'] == null) {
                return false;
            }
            current = current.branches[ch - 'a'];
        }
        return current.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (current.branches[ch - 'a'] == null) {
                return false;
            }
            current = current.branches[ch - 'a'];
        }
        return true;
    }
}

class TrieNode {

    TrieNode[] branches;
    final int CHARS_IN_ALPHABET = 26;
    boolean isWord;

    public TrieNode() {
        branches = new TrieNode[CHARS_IN_ALPHABET];
    }
}
