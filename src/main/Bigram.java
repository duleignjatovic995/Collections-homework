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
	
	
	
	
	
	public static void main(String[] args) {

		String sekvenca = "abbcceeeeeeabcc";
		Map<String, Integer> map = Bigram.createBigrams(sekvenca);
		for (Map.Entry<String, Integer> obj : map.entrySet()) {
			System.out.println(obj.getKey()+"-"+obj.getValue());
		}
	}
}
