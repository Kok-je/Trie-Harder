// { Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            sc.nextLine();
            String[] keys = sc.nextLine().split(" ");

            TrieNode root = new TrieNode();
            for (int i = 0; i < n; i++) {
                insert(root, keys[i]);
            }
            String abc = sc.nextLine();
            if (search(root, abc))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }

    static final int ALPHABET_SIZE = 26;

    // trie node
    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) children[i] = null;
        }
    };

    
 // } Driver Code Ends
// User function Template for Java

// If not present, inserts key into trie
// If the key is prefix of trie node,
// just marks leaf node
//Function to insert string into TRIE.
static void insert(TrieNode root, String key) 
{
    // Your code here
    int level;
    int length = key.length();
    int index;
    
    TrieNode crawler = root;
    
    // In a Trie, each node representing a character is considered as "one level" 
    for (level = 0; level < length; level++) {
        index = key.charAt(level) - 'a';
        if (crawler.children[index] == null) {
            crawler.children[index] = new TrieNode();
        }
        crawler = crawler.children[index];
    }

    // Mark the last node as a leaf
    crawler.isEndOfWord = true;
}

//Function to use TRIE data structure and search the given string.
static boolean search(TrieNode root, String key)
{
    // Your code here
    int level;
    int length = key.length();
    int index;
    TrieNode crawler = root;
    
    for (level = 0; level < length; level++){
        index = key.charAt(level) - 'a';
        if (crawler.children[index] == null){
            return false;
        }
        crawler = crawler.children[index];
    }
    
    return (crawler.isEndOfWord);
}


// { Driver Code Starts.
}  // } Driver Code Ends