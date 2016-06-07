package main;

import java.util.HashMap;
import java.util.Map;

public class Bigram {
	
	
	public static Map<String, Integer> createBigrams(String sekvenca){
		if (sekvenca == null || sekvenca.isEmpty()) {
			return null;
		}
		Map<String, Integer> mapa = new HashMap<>();
		for (int i = 2; i <= sekvenca.length(); i++) {
			String temp = sekvenca.substring(i-2, i);
			if (mapa.get(temp)==null) {
				mapa.put(temp, 1);
			} else {
				mapa.put(temp, mapa.get(temp)+1);
			}
		}
		
		return mapa;
	}
	
	public static String predictChar(Map<String, Integer> mapa, String s) {
		int max = 0;
		String slovo = "";
		String chr = s.substring(s.length()-1);
		for (Map.Entry<String, Integer> obj : mapa.entrySet()) {
			if (obj.getKey().startsWith(chr) && obj.getValue() > max) {
				slovo = obj.getKey().substring(1, 2);
				max = obj.getValue();
			}
		}
		return slovo;
	}
	
	
	
	public static void main(String[] args) {
		String p = "ja";
		String sekvenca = "abbcceeeeeeabcc";
		Map<String, Integer> map = Bigram.createBigrams(sekvenca);
		for (Map.Entry<String, Integer> obj : map.entrySet()) {
			System.out.println(obj.getKey()+"-"+obj.getValue());
		}
		
		for (int i = 0; i < 3; i++) {
			p+=Bigram.predictChar(map, p);			
		}
		
		System.out.println(p);
//		String s = "123456789840932840234";
//		System.out.println(s.substring(s.length()-1));
		
	}
}
