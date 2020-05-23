import java.util.*;

public class Crypto{
	public static void main(String[] args){

		String encrypText = encryptString("WHippies! are", -4, 3);
		System.out.println(encrypText);
		/*String ungroup = ungroupify(encrypText);
		System.out.println(ungroup);*/
	}

	//nomralize the text
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

	//shift the text by the key value
	public static String ceasarify(String text, int key){
		String ceasar = ""; //encrypted text
		System.out.println(text.length());
		String alpha = shiftAlphabet(key); //alphabet shifted by key

		for(int j = 0; j < text.length(); j++){
			int index = j + 1; //to get single char in string
			String str = text.substring(j,index); //the char in string
			int strVal = alpha.indexOf(str); //get index value of str from alpha
			String temp = ""; //to temporarly store char of string 

			int remaind = strVal % 26;
			System.out.println(remaind);
			if((remaind + key) > 25){
				remaind = strVal % 26;
				remaind = remaind + key;
				System.out.println(remaind);
				temp = alpha.substring(0,remaind);
			}else if((remaind + key) < 0){
				remaind = (26 - (Math.abs(strVal) % 26) ) % 26;
				System.out.println("----------------------------------");
				System.out.println(remaind);
				temp = alpha.substring(remaind,remaind + 1); //add index value to get the ceasar char equivalent
			}else{
				temp = alpha.substring(strVal+key,strVal+key+1);
			}

			ceasar = ceasar + temp; //add ceasar equivalent to final return string 
		}
		System.out.println(ceasar + "ceasar");
		return ceasar;
	}	 

	//alphabet that is shifted by shift value, provided by edX course
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
    	System.out.println(result);
    	return result;
	}

	//group the text letters by the group value 
	public static String groupify(String text, int group){
		String groupText = ""; //final string to return, grouped and padded if needed
		int index0 = 0, index1 = 0; //for substring
		int count = 0; //for iteration, to keep while loop balanced

		boolean flag = text.length() % group == 0; //for padding

		while(!flag){
			text = text + 'x'; //pad text with x to group 
			flag = text.length() % group == 0; //if padding is done
		}
		
		while((groupText.length() - count) != text.length()){
			String temp = ""; //holds the group string
			index1 = index1 + group; //holds the index value of the last char of group
			temp = text.substring(index0,index1); //from index0 to index 1, get string
			index0 = index1; //update the staring index value
			groupText = groupText + temp + " " ; //seperate the groups
			count ++; //for every " " we add to the groupText length, used to subtract " " char from length
		}	
		return groupText;
	}

	public static String encryptString(String text, int key, int group){
		String normalText = normalizeText(text);
		String ceasarText = ceasarify(normalText, key);
		String groupText = groupify(ceasarText, group);

		return groupText;
	}

	public static String ungroupify(String text){
		String ungroup = text; //text that is ungrouped
		ungroup = ungroup.replace(" ", "");

		int index0 = 0, index1 = 0;

		for(int j = 0; j < ungroup.length(); j++){
			index1 = index0 + 1;
			String ch = ungroup.substring(index0,index1);
			boolean flag = ch.equals("x");
			if(flag){
				ungroup = ungroup.replace(ch, "");
			}
			index0 = index1;
		}
		return ungroup;
	}

}