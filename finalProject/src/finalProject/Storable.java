package finalProject;
import TRIE.*;

public interface Storable extends Retrievable{
	public void addWord(String word, String meaning, int it, Node node);
	public boolean searchWord(String word, int it, Node node);
}
