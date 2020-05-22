import java.util.*;

public class Crypto{
	public static void main(String[] args){
		String crypt = normalizeText("Hippies!");
		String ceasar = ceasarify(crypt , 1);
		System.out.println(crypt);
		System.out.println(ceasar);
	}

	public static String normalizeText(String text){
		text = text.replace(" ", "");
		text = text.toUpperCase();

		if(text.contains(")")){
			text = text.replace(")","");
		}
		if(text.contains("(")){
			text = text.replace("(","");
		}
		if(text.contains("!")){
			text = text.replace("!","");
		}
		if(text.contains("?")){
			text = text.replace("?","");
		}
		if(text.contains("\"")){
			text = text.replace("\"","");
		}
		if(text.contains(";")){
			text = text.replace(";","");
		}
		if(text.contains(":")){
			text = text.replace(":","");
		}
		if(text.contains(",")){
			text = text.replace(",","");
		}
		if(text.contains(".")){
			text = text.replace(".","");
		}
		return text; 
	}

	public static String ceasarify(String text, int key){
		String ceasar = ""; //encrypted text
		String alpha = shiftAlphabet(key); //alphabet shifted by key

		for(int j = 0; j < text.length(); j++){
			int index = j + 1;
			String str = text.substring(j,index);
			//get index value of str from alpha
			//add index value to get the ceasar equivalent
			System.out.println(str);
		}
		return ceasar;
	} 

	public static String shiftAlphabet(int shift) {
    int start = 0;
    if (shift < 0) {
        start = (int) 'Z' + shift + 1;
    } else {
        start = 'A' + shift;
    }
    String result = "";
    char currChar = (char) start;
    for(; currChar <= 'Z'; ++currChar) {
        result = result + currChar;
    }
    if(result.length() < 26) {
        for(currChar = 'A'; result.length() < 26; ++currChar) {
            result = result + currChar;
        }
    }
    return result;
}
}