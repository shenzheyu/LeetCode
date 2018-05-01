public class Trie {

    private final int CHAR_NUMS = 27;
    private TrieNode root;

    private class TrieNode {
        boolean isKey;
        TrieNode[] children;
        public TrieNode() {
            isKey = false;
            children = new TrieNode[CHAR_NUMS];
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
        root.children = new TrieNode[CHAR_NUMS];
        for(int i = 0; i < CHAR_NUMS; i++) {
            root.children[i] = new TrieNode();
        }
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        int n = word.length();
        TrieNode ptr = root;
        for(int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if(ptr.children[c - 'a'] == null) {
                ptr.children[c - 'a'] = new TrieNode();
            }
            if(ptr.children[c - 'a'].isKey) {
                ptr = ptr.children[c - 'a'];
            }else {
                ptr.children[c - 'a'].isKey = true;
//                for(int j = 0; j < CHAR_NUMS; j++) {
//                    ptr.children[c - 'a'].children[j] = new TrieNode();
//                }
                if(ptr.children[c - 'a'] == null) {
                    ptr.children[c - 'a'] = new TrieNode();
                }
                ptr = ptr.children[c - 'a'];
            }
        }
        if(ptr.children[CHAR_NUMS - 1] == null) {
            ptr.children[CHAR_NUMS - 1] = new TrieNode();
        }
        ptr.children[CHAR_NUMS - 1].isKey = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int n = word.length();
        TrieNode ptr = root;
        for(int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if(ptr.children[c - 'a'] == null) {
                return false;
            }
            if(!ptr.children[c - 'a'].isKey) {
                return false;
            }
            ptr = ptr.children[c - 'a'];
        }
        if(ptr.children[CHAR_NUMS - 1] == null) {
            return false;
        }
        if(!ptr.children[CHAR_NUMS - 1].isKey) {
            return false;
        }
        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int n = prefix.length();
        TrieNode ptr = root;
        for(int i = 0; i < n; i++) {
            char c = prefix.charAt(i);
            if(ptr.children[c - 'a'] == null) {
                return false;
            }
            if(!ptr.children[c - 'a'].isKey) {
                return false;
            }
            ptr = ptr.children[c - 'a'];
        }
        return true;
    }

}
