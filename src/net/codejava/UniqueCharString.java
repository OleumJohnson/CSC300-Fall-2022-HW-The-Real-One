package net.codejava;
import java.util.ArrayList;

public class UniqueCharString {	
	
	static ArrayList<Character> s_t_r = new ArrayList<>();
	
	UniqueCharString() {
	}

	public static String FindIfStringHasAllUniqueChars(String str) {
		for(int i = 0; i < str.length(); i++) {
			s_t_r.add(str.charAt(i));
			//adding all chars of str to an arraylist composing the string's characters
		}
		
		for(int i = 0; i < str.length(); i++) {
			for(int j = 0; j < s_t_r.size(); j++) {
				if(s_t_r.get(i) == (s_t_r.get(j)) && i != j) {
					//System.out.println(s_t_r);
					s_t_r.clear();
					return "shoot this string doesn't contain all unique letters";
				}
			}
		}
		s_t_r.clear();
		return "wow sick this string contains all unique letters";
	}
	
	public static void main(String[] args) {
		String string1 = "bababooey";
		String string2 = "garfield";
		String string3 = "ok i pull up";
		String string4 = "shrek 4";
		String string5 = "iphone x";
		String string6 = "what da dog doin";
		System.out.println(FindIfStringHasAllUniqueChars(string1));
		System.out.println(FindIfStringHasAllUniqueChars(string2));
		System.out.println(FindIfStringHasAllUniqueChars(string3));
		System.out.println(FindIfStringHasAllUniqueChars(string4));
		System.out.println(FindIfStringHasAllUniqueChars(string5));
		System.out.println(FindIfStringHasAllUniqueChars(string6));
	}

}
