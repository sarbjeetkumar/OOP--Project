package ie.gmit.sw;
import model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;

/**
 *  @author sarabjeet
 *  
 *	This Class used the load the file form the jar 
 *
 */


public class JarReadFile implements Readin  {
																						//**************************************************	
	public List init(String jarName) throws FileNotFoundException, IOException  {		//****This method loads the files from the Jar*******
																						//***************************************************
		
		List list = null;
		
		JarInputStream in  = new JarInputStream(new FileInputStream(new File("test.jar"))); 
		
		JarEntry next = in.getNextJarEntry(); 
		
		
		while (next!= null) {
			
			
			if (next.getName().endsWith(".class")) 
			{
				
				String name = next.getName().replaceAll("/", "\\.");
				
				name = name.replaceAll(".class", "");
				
				if (!name.contains("$")){ 
					
					name.substring(0, name.length() - ".class".length()); 
				
				
					System.out.println(name);
				
				}
				
			}
			
			
			
			next = in.getNextJarEntry();
			
			
		}//whille
		
		try {
			
			Class clss = Class.forName("ie.gmit.sw.Ford");
			Package pkg = clss.getPackage();  //get the package
			boolean iterF = clss.isInterface(); //check true or false if it is interface or not 
			Constructor [] construct = clss.getConstructors(); //get the constructors
			
			
			System.out.println(pkg.getName());
			System.out.println("----->" + clss.getName()+  " <----------");
			System.out.println("----->" + construct [0]+  " <----------");
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		return list;
	}//main ends here 
}//class 
