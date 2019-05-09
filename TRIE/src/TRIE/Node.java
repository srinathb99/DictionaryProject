package TRIE;
import java.util.*;
public class Node {
	public static final int ALPHABETS = 26;
	protected Node[] children = new Node[ALPHABETS];
	protected char character;
	protected boolean isFinal;
	private ArrayList<String> meaning;
	
	public Node(char ch) {
		character = ch;
		for(int i = 0; i < ALPHABETS; ++i) {
			children[i] = null;
		}
		isFinal = false;
		meaning = new ArrayList<String>();
	}
	
	public boolean isParent(char ch) {
		return children[ch - 'a'] != null;
	}

	public char getCharacter() {
		return character;
	}
	
	public void setCharacter(char ch) {
		character = ch;
	}
	
	public void addMeaning(String str) {
		if(meaning.isEmpty()) {
			meaning.add(str);
			return;
		}
		if(str != meaning.get(meaning.size() - 1))meaning.add(str);
	}
	
	public void printMeaning() {
		for(int i = 0; i < meaning.size(); ++i) {
			System.out.println(meaning.get(i));
		}
	}
	
	public boolean hasMeaning() {
		return meaning != null;
	}
	

	
	public void setChild(Node node) {
		int index = node.getCharacter() - 'a';
		children[index] = node;
	}
	
	public void setChild(char ch, Node node) {
		int index = ch - 'a';
		children[index] = node;
	}
	
	public Node getChild(char ch) {
		int index = ch - 'a';
		return children[index];
	}
	
	public Node getChild(int i) {
		return children[i];
	}
	
	public void setFinal() {
		isFinal = true;
	}
	
	public void resetFinal() {
		isFinal = false;
	}
	
	public boolean isFinal() {
		return isFinal;
	}
	
	public boolean isExternal() {
		boolean flag = true;
		for(int i = 0; i < ALPHABETS; ++i) {
			if(children[i] != null) {
				flag = false;
			}
		}
		return flag;
	}
	
	public Node getNextChild(int it) {
		for(int i = it+1; i < ALPHABETS; ++i) {
			if(children[i] != null) {
				return children[i];
			}
		}
		return null;
	}
	
	public boolean hasThisChild(int i) {
		return children[i] != null;
	}
	
}
