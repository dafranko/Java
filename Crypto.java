import java.util.*;

public class Crypto{
	public static void main(String[] args){

		String encrypText = encryptString("Ceasar shift huh, that's pretty old crypto stuff", 4, 3);
		System.out.println(encrypText);
		String decryptText = decryptString(encrypText, 4);
		System.out.println(decryptText);
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
		if(text.contains("'")){
			text = text.replace("'","");
		}
		return text; 
	}

	//shift the text by the key value
	public static String ceasarify(String text, int key){
		String ceasar = ""; //encrypted text
		String alpha = shiftAlphabet(key); //alphabet shifted by key

		for(int j = 0; j < text.length(); j++){
			int index = j + 1; //to get single char in string
			String str = text.substring(j, index); //the char in string
			int strVal = alpha.indexOf(str); //get index value of str from alpha
			String temp = ""; //to temporarly store char of string

			int remain0 = strVal + key; //original remiander, figure where the ceasar char equivalent index is located
			int remain1 = 0; //if remain0 is over 25 or under 0, calculate true ceasar index value

			if(remain0 > 25){ //if oringinal remainder is over 25
				remain1 = remain0 % 26; //wraps around the end alphabet to get true ceasar index value
				temp = alpha.substring(remain1,remain1 + 1); //get true ceasar index value
			}
			if(remain0 < 0){ //if original reimaonder is under 0
				remain1 = (((remain0 % 26) + 26) % 26); //get mod of negative value, online source
				remain1 = 26 + remain0; //add 26 to wrap around the front of alphabet
				temp = alpha.substring(remain1,remain1 + 1); //get true ceasar index value
			}
			if((remain0 < 25) && (remain0 > 0)){ //if remainder is within the alphabet length 
				temp = alpha.substring(remain0,remain0+1); //get true ceasar index value
			}
			if(remain0 == 25){ //if remainder is equal to last index of alphabet
				temp = alpha.substring(25); //get last char of alphabet
			}else if(remain0 == 0){ //if remainder is equal to first index of alphabet
				temp = alpha.substring(0,1); //get first char of alphabet
			}
			ceasar = ceasar + temp; //add ceasar char equivalent to final return string 
		}
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

	public static String decryptString(String text, int key){
		String ungroupText = ungroupify(text);
		//WHippies asdfsgjkjytredWYZ

		String ceasar = ""; //encrypted text
		String alpha = shiftAlphabet(key); //alphabet shifted by key
		//System.out.println(alpha);

		for(int j = 0; j < ungroupText.length(); j++){
			int index = j + 1; //to get single char in string
			String str = ungroupText.substring(j, index); //the char in string
			int strVal = alpha.indexOf(str); //get index value of str from alpha
			//System.out.println(str+" org");
			//System.out.println(strVal+" org index");
			String temp = ""; //to temporarly store char of string

			int remain0 = strVal - key; //original remiander, figure where the ceasar char equivalent index is located
			//System.out.println(remain0+" remain");
			int remain1 = 0; //if remain0 is over 25 or under 0, calculate true ceasar index value

			if(remain0 > 25){ //if oringinal remainder is over 25
				remain1 = remain0 % 26; //wraps around the end alphabet to get true ceasar index value
				temp = alpha.substring(remain1,remain1 + 1); //get true ceasar index value
			}
			if(remain0 < 0){ //if original reimaonder is under 0
				remain1 = (((remain0 % 26) + 26) % 26); //get mod of negative value, online source
				remain1 = 26 + remain0; //add 26 to wrap around the front of alphabet
				temp = alpha.substring(remain1,remain1 + 1); //get true ceasar index value
			}
			if((remain0 < 25) && (remain0 > 0)){ //if remainder is within the alphabet length 
				temp = alpha.substring(remain0,remain0+1); //get true ceasar index value
			}
			if(remain0 == 25){ //if remainder is equal to last index of alphabet
				temp = alpha.substring(25); //get last char of alphabet
			}else if(remain0 == 0){ //if remainder is equal to first index of alphabet
				temp = alpha.substring(0,1); //get first char of alphabet
			}
			//System.out.println(temp);
			//System.out.println("----------------------------------------------------------");
			ceasar = ceasar + temp; //add ceasar char equivalent to final return string 
		}
		return ceasar;

	}

}