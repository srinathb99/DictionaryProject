package finalProject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import TRIE.*;


public class testDictionary {
	
	public static boolean isAlpha(String name) {
		int i;

	    for (i = 0; i < name.length() - 1; ++i) {
	    	char c = name.charAt(i);
	        if(c < 'a' || c > 'z') {
	            return false;
	        }
	    }
	    char c = name.charAt(name.length()-1);
	    if(c >= 'a' && c <= 'z')
	    {
	    	return true;
	    }
	    if(Character.isDigit(c)) {
	    	return true;
	    }
	    return false;
	}
	
	public static String modString(String key) {
		String mod = key;
		if(Character.isDigit(key.charAt(key.length()-1))) {
			mod = key.substring(0, key.length()-1);
		}
		return mod;
	}
    public static void main(String[] args) {
    	//entering dictionary
    	int cnt = 0;
    	String string1 = null;
    	String string2 = null;
    	Dictionary dic = new Dictionary();
        try (BufferedReader br = new BufferedReader(new FileReader("/home/srinath/3rd Sem/OOPS/Project/Oxford_English_Dictionary.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
            	Pattern pattern = Pattern.compile("   *");
            	Matcher matcher = pattern.matcher(line);
            	if (matcher.find()) {
            	    string1 = line.substring(0, matcher.start());
            	    string2 = line.substring(matcher.end());
            	}
            	string1 = string1.toLowerCase();
                if(isAlpha(string1)) {
                	
                	String temp = modString(string1);
                	dic.addWord(temp,string2, 0, dic.getRoot());
                }
            }
            //accessing dictionary
            Scanner sc = new Scanner(System.in);
    		String str;
    		int choice = 1;
    		System.out.println("1.Check meaning in dictionary.");
    		System.out.println("0.Exit");
    		choice = sc.nextInt();
    		while(choice != 0) {
    			++cnt;
    			if(choice == 1) {
    				System.out.println("Enter word : ");
    				str = sc.next();
    				if(dic.searchWord(str.toLowerCase(), 0, dic.getRoot())) {
    					System.out.println("Found word.");
    				}
    				else {
    					System.out.println("This word does not exist in the dictionary. Did you mean : ");
    					String suggestion = dic.getNeighbour(str.toLowerCase(),0,dic.getRoot());
    				}
    			}
    			System.out.println("1.Check meaning in dictionary.");
        		System.out.println("0.Exit");
    			choice = sc.nextInt();
    		}
    		System.out.println("Dictionary exited.");
    		
    		
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}