package finalProject;
import TRIE.*;

public class Dictionary extends TRIE{
	
	public void addWord(String str, String meaning, int it, Node node) {
		
		// TODO adds a word into the dictionary along with its meaning
		
		if(it == str.length()) {
			node.setFinal();
			node.addMeaning(meaning);
			size++;
			return;
		}
		if(node.isParent(str.charAt(it))) {
			addWord(str,meaning,it+1,node.getChild(str.charAt(it)));
		}
		else {
			Node temp = new Node(str.charAt(it));
			node.setChild(temp);
			addWord(str,meaning,it+1,temp);
		}
	}
	
	public boolean searchWord(String key,int it, Node node) {
		
		// searches for a word in the dictionary and prints meaning if word exists
		boolean flag = false;
		if(it == key.length()) {
			if(node.isFinal()) {
				flag = true;
				System.out.print(key);
				System.out.println("\nMeaning : ");
				node.printMeaning();
				return flag;
			}
			else {
				flag = false;
				return flag;
			}
		}
		if(node.isParent(key.charAt(it))) {
			flag = searchWord(key,it+1,node.getChild(key.charAt(it)));
		}
		return flag;
	}
	
public boolean returnWord(String key,int it, Node node) {
		
		// searches for a word in the dictionary and prints meaning if word exists
		boolean flag = false;
		if(it == key.length()) {
			if(node.isFinal()) {
				flag = true;
				System.out.println("\nMeaning :");
				node.printMeaning();
				return flag;
			}
			else {
				flag = false;
				return flag;
			}
		}
		if(node.isParent(key.charAt(it))) {
			flag = returnWord(key,it+1,node.getChild(key.charAt(it)));
		}
		return flag;
	}

	public String getNeighbour(String str, int it, Node node) {
		for(int i = str.length(); i < str.length() + 2; ++i) {
			String temp = str;
			String temp1;
			for(char ch = 'a'; ch <= 'z'; ++ch) {
				temp1 = temp + ch;
				if(searchWord(temp1,0,getRoot())) {
					return temp;
				}
			}
		}
		for(int i = str.length()-1; i > 0; --i) {
			String temp;
			String temp1;
			temp1 = str.substring(0, i);
			for(char ch = 'a'; ch <= 'z' ; ++ch) {
				temp = temp1 + ch;
				if(searchWord(temp,0,getRoot())) {
					return temp;
				}
			}
		}
		return null;
	}
	
}
