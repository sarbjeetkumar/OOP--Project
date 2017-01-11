package model;

public class Measurement {
	
	
	
	/**
	 * 
	 * 
	 * This class used to get and set the coplling and calculate the stability
	 * 
	 * 
	 * 
	 * 
	 */

	private String className;
	private int effrontCouplling;
	private int affrontCouplling;
	
	public Measurement(){
		
	}
	
	
	public Measurement(String className, int effrontCouplling, int affrontCouplling) {
		super();
		this.className = className;
		this.effrontCouplling = effrontCouplling;
		this.affrontCouplling = affrontCouplling;
	}

	public String getClassName() {
		return className;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}
	
	public int getEffrontCouplling() {
		return effrontCouplling;
	}
	
	public void setEffrontCouplling(int effrontCouplling) {
		this.effrontCouplling = effrontCouplling;
	}
	
	public int getAffrontCouplling() {
		return affrontCouplling;
	}
	
	public void setAffrontCouplling(int affrontCouplling) {
		this.affrontCouplling = affrontCouplling;
	}
	
	public double getStability(){
		
		double stabilityMetrics = 0.0;
		
		if(getEffrontCouplling() > 0){
			
			stabilityMetrics = (getEffrontCouplling() / getAffrontCouplling()
					+ getEffrontCouplling());
		}
		
		
		return stabilityMetrics;
	}
	
	

}
