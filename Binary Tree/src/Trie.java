public class Trie{
	private TrieNode root;
	public Trie(){
		root = new TrieNode();
	}
	private class TrieNode{
		private TrieNode[] children;
		private boolean isWord;
		
		public TrieNode(){
			this.children = new TrieNode[26];
			this.isWord = false;
		}
	}
	
	public void insert(String word) {
		if(word.isEmpty() || word == null)
			throw new IllegalArgumentException("Invalid input");
		word = word.toLowerCase();
		TrieNode curr = root;
		for(int i=0;i<word.length();i++) {
			int index = word.charAt(i)-'a';
			if(curr.children[index] == null) {
				TrieNode n = new TrieNode();
				curr.children[index] = n;
				curr = n;
			}
			else {
			curr = curr.children[index];
			}
		}
		curr.isWord = true;
	}
	
	public boolean search(String word) {
		TrieNode tmp = root;
		for(int i = 0;i<word.length();i++) {
			int index = word.charAt(i)-'a';
			if(tmp.children[index] == null) 
				return false;
			tmp = tmp.children[index];
		}
		return (tmp!=null && tmp.isWord);
	}
	
	public static void main(String[] args) {
		Trie t = new Trie();
		t.insert("cat");
		t.insert("cab");
		t.insert("son");
		t.insert("so");
		System.out.println(t.search("so"));
		System.out.println("Success!");
	}
}