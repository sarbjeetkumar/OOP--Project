package ie.gmit.sw;
import model.*;
import java.util.*;

import org.xml.sax.HandlerBase;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

public class Calculate {

	/**
	 * sarabjeetkumar
	 * 
	 * Thos is used to calculate the affrent and effrent couplling ...
	 */
	//Map
	
	public Calculate(){
		super();
	}
	private static Map<Class , Measurement> myMap = new HashMap<>();
	//list
	private static List<Class> list = new ArrayList<>();
	
	private static Measurement measure;
	
	private String name;
	
	private int afferentCouplling;
    private int efferentCouplling;
	
	
	public Calculate(List ll){
		getEffrent(ll);
	}


	public Map<Class, Measurement> getEffrent(List ll) {
		// TODO Auto-generated method stub
		
		
		myMap = new HashMap();
		
		//loop through the List
		for (int i = 0; i < ll.size(); i++) {
			
			measure = new Measurement();
			
			
			//get a class
			Class clss = list.get(i).getClass();
			
			Class [] intFace = clss.getInterfaces();    //if implementing interface
			
			
			 //if the class implements interface find
            for(Class inter : intFace){

               
                if(list.contains(inter)){
                    efferentCouplling++;
                }

            }//for ends here 
			
            Constructor[] constr = clss.getConstructors();
            Class[] contParams;

            for(Constructor c: constr){

                contParams = c.getParameterTypes();

                for(Class par: contParams){

                    //if the name is present
                    if(ll.contains(par.getName())){
                    	
                        efferentCouplling ++;
                    }

                }

            }//for ends here
            
            
            
            Field[] fields = clss.getFields();

            for(Field fid: fields ){

                //add if there is 
                if(ll.contains(fid.getName())){
                	
                    efferentCouplling ++;
                }//if 

            }//for ends here fields 
            
            
            
            //retrieve al the methods 
            Method[] classMethods = clss.getMethods();
            Class[] params;

            //
            for(Method methd: classMethods){

                Class returnTypes = methd.getReturnType();

                if(ll.contains(methd.getReturnType().getName())){
                	
                    efferentCouplling ++;
                }//if 

            }//for
            
            
            
            afferentCouplling =getAferent(ll, clss.getName());
            
            name = clss.getName();
            
            //pass the name to the methoid set class name 
            measure.setClassName(name);
            
            measure.setAffrontCouplling(afferentCouplling);
            measure.setEffrontCouplling(efferentCouplling);
            
            
            //get the class 
            clss = ll.get(i).getClass();
            
            myMap.put(clss,measure);
            
           
			
		}//main for ends here 	
		
		 //set it to zero 
        efferentCouplling = 0;
		
		return myMap;
	}//getEffrent 


	public int getAferent(List<Class> list2, String name2) {
		// TODO Auto-generated method stub
		
		int aff = 0 ;	//set it to zero
		
		for (int i = 0; i < list2.size(); i++) {
			
			
			//get the class 
			
			Class clss = list2.get(i).getClass();
			
			//if there is interface 
			
			Class [] intFace = clss.getInterfaces();
			
			//if it has interface increment the aff.
			
			
			for(Class inter : intFace){

                //if the interface name is same as inter.getName() then increment afferent
                if(inter.getName() == name2){
                	
                    aff ++;
                }

            }//for ends here 
			
			
			 Constructor[] construct = clss.getConstructors();
	            Class[] constParams;

	            for(Constructor c: construct) {

	                constParams = c.getParameterTypes();

	                for (Class par : constParams) {

	                    //if constructor params == name then increment
	                    if (par.getName() == name2) {
	                    	
	                        aff++;
	                    }
	                }
	            }//ensd here 
			
	            //*********fields*******
	            Field[] fld = clss.getFields();
	            for(Field fie: fld ){

	                if(fie.getName() == name)
	                    aff++;
	            }//for ensd here 
	            
	            //methods 
	            
	            Method[] clasMethod = clss.getMethods();
	            Class [] param;
	            
	            for(Method methd : clasMethod){
	            	
	            	Class retrTypes = methd.getReturnType();
	            	
	            	if(methd.getReturnType().getName() == name2){
	            		
	            		aff++;
	            		
	            	}//if
	            }//for
	            
	            
	            
	            
		}//main for ends here 		
		return aff;
	}
	
	

}//class 
