package ie.gmit.sw;

import java.util.HashMap;
import java.util.Map;

import model.Measurement;

public class GetData {
	
	
	/**
	 * 
	 * This Class is responsible for geettin data  
	 * for gui .
	 * 
	 * 
	 */

	 @SuppressWarnings("rawtypes")
	Map<Class , Measurement> myMap = new HashMap<>();
		
	 
	 
	 
	public GetData() {
		// TODO Auto-generated constructor stub
		super();
	}

	
	
	
	
	
	public GetData(Map myMap){
		
		// TODO Auto-generated constructor stub
		getData(myMap);
	}



	private Object[][] getData(Map myMap2) {
		
		
		// TODO Auto-generated method stub
		
		Object[][] array = new Object[myMap.size()][4];
		
		int j = 0;
		
		for(Measurement measure : myMap.values()){
		
			array[j][0] = measure.getClassName();
			array[j][2] = measure.getAffrontCouplling();
			array[j][3] = measure.getEffrontCouplling();
			array[j][4] = measure.getStability();
			j++;
		}
		
		
		return array;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//Class ends here 


