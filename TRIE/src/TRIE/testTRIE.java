package TRIE;
import java.util.Scanner;

public class testTRIE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TRIE test = new TRIE();
		Scanner sc = new Scanner(System.in);
		String str;
		int choice = 1;
		System.out.println("1.Enter string into TRIE");
		System.out.println("2.Check if string exists in TRIE");
		System.out.println("3.Print size of TRIE");
		System.out.println("4.Print words in TRIE");
		System.out.println("5.Remove a string from TRIE");
		System.out.println("0.Exit");
		choice = sc.nextInt();
		while(choice != 0) {
			if(choice == 1) {
				System.out.println("Enter string : ");
				str = sc.next();
				test.insertString(str, 0, test.getRoot());
			}
			else if(choice == 2) {
				System.out.println("Enter string : ");
				str = sc.next();
				if(test.searchString(str, 0, test.getRoot())) {
					System.out.println(str + " exists in TRzIE");
				}
				else {
					System.out.println(str + " does not exist in TRIE");
				}
			}
			else if(choice == 3) {
				System.out.println("Size of TRIE : " + test.size());
			}
			else if(choice == 4) {
				System.out.println("The words in the TRIE are : ");
				test.printStrings(test.getRoot());
			}
			else if(choice == 5) {
				System.out.println("Enter String : ");
				String word = sc.next();
				test.removeString(word, test.getRoot().getChild(word.charAt(0)), 0);
			}
			System.out.println("Enter choice : ");
			choice = sc.nextInt();
		}
		
	}

}
