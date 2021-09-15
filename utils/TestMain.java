package granguil.data.utils;

import java.util.HashMap;
import java.util.Map;

import granguil.data.Enum.TypeRole;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,String> heros=new HashMap<String,String>();
		heros.put("Hedric", "Tnom");
		heros.put("Eileen","Duchés");
		heros.put("Lisi", "Garde Lunaire");
		for (Map.Entry<String, String> entry : heros.entrySet()) {
	        System.out.println(entry.getKey() + ":" + entry.getValue());
	    }
		heros.put("Lisi", "Conseil des 6");
		for (Map.Entry<String, String> entry : heros.entrySet()) {
	        System.out.println(entry.getKey() + ":" + entry.getValue());
	    }

	}

}
