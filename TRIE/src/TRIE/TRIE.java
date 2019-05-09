package TRIE;
import java.util.*;

public class TRIE implements Retrievable {

	protected int size;
	protected Node root;
	protected ArrayList<Node> strings = new ArrayList<Node>();
	
	protected TRIE(){
		size = 0;
		root = new Node('*');
	}
	
	public Node getRoot() {
		return root;
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public void insertString(String str, int it, Node node) {
		// TODO Auto-generated method stub
		if(it == str.length()) {
			node.setFinal();
			size++;
			return;
		}
		if(node.isParent(str.charAt(it))) {
			insertString(str,it+1,node.getChild(str.charAt(it)));
		}
		else {
			Node temp = new Node(str.charAt(it));
			node.setChild(temp);
			insertString(str,it+1,temp);
		}
	}

	@Override
	public boolean searchString(String key,int it, Node node) {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(it == key.length()) {
			if(node.isFinal()) {
				flag = true;
				return flag;
			}
			else {
				flag = false;
				return flag;
			}
		}
		if(node.isParent(key.charAt(it))) {
			flag = searchString(key,it+1,node.getChild(key.charAt(it)));
		}
		return flag;
	}
	
	public void printStrings(Node node) {
		if(isEmpty()) {
			System.out.println("The TRIE is empty");
		}
		strings.add(node);
		if(node.isFinal()) {
			int i;
			for(i = 1; i < strings.size(); ++i) {
				System.out.print(strings.get(i).getCharacter());
			}
			System.out.println();
		}
		for(int i = 0; i < 26; ++i) {
			if(node.hasThisChild(i)) {
				printStrings(node.getChild(i));
			}
		}
		strings.remove(strings.size() - 1);
	}
	
	public void removeString(String str, Node node, int it) {
			if(node.isFinal() && !node.isExternal()) {
				node.resetFinal();
				size--;
				return;
			}
	
			else if(node.isExternal()){
				node.resetFinal();
				node.setCharacter('\0');
				size--;
				return;
			}
		removeString(str, node.getChild(str.charAt(it+1)), it+1);
	}


}
