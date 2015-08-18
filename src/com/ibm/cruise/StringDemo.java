package com.ibm.cruise;
import java.util.HashMap;
import java.util.Map;


public class StringDemo {

	
	public static void queryMaxCountChar(String s){
		int strLen = s.length();
		int maxCount = 0;
		String maxChar = "";
		Map<String, Integer> mChar = new HashMap<String, Integer>();
		while(strLen>0){
			String newChar = String.valueOf(s.charAt(0));
			s = s.replaceAll(newChar, "");
			int newStrLen = s.length();
			int charCount = strLen - newStrLen;
			strLen = newStrLen;	
			
			if(maxCount == charCount){
				mChar.put(maxChar, maxCount);
				mChar.put(newChar, charCount);
			}else if(maxCount<charCount){
				maxCount = charCount;
				maxChar = newChar;
			}
		}
		for(String key : mChar.keySet()){
			System.out.println(key + ":" + mChar.get(key));
		}
		
		
	}
	
	public static void queryMaxCountChar2(String s){
		int strLen = s.length();
		int maxCount = 0;
		String maxChar = null;
		Map<String, Integer> mChar = new HashMap<String, Integer>();
		if(s == null || strLen<1) return;
		Map<String, Integer> m = new HashMap<String, Integer>();
		for(int i = 0; i< strLen; i++){
			String newChar = String.valueOf(s.charAt(i));
			if(m.containsKey(newChar)){
				m.put(newChar, m.get(newChar)+1);
			}else{
				m.put(newChar, 1);
			}
			
			if(m.get(newChar)==maxCount){
				mChar.put(newChar, maxCount);
				mChar.put(maxChar, maxCount);
			}else if(m.get(newChar)>maxCount){
				maxCount = m.get(newChar);
				maxChar = newChar;
			}
		}
		for(String key : mChar.keySet()){
			System.out.println("char "+ key + " appears "+mChar.get(key) +" times.");
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "1j3413m2ojp2943jojkd2asj90e32j329432832jif";
		StringDemo.queryMaxCountChar(s1);
		StringDemo.queryMaxCountChar2(s1);
	}

}
