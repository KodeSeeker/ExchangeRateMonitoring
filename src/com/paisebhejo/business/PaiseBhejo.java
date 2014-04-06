package com.paisebhejo.business;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PaiseBhejo {

	
	
	//
	static Map<Integer,ArrayList<Double>> rateMap;
	static Map<Integer,String> bankCodes;
	 public void pseudoConstructor(){
		 rateMap= new HashMap<Integer,ArrayList<Double>>();
		 
		 bankCodes.put(1,"AxisBank");
		 //fill the rest based on how you get the rates
		 }
	public static Map<Integer,LinkedHashMap<String,Double>>  computeExchangeMatrix(double targetRateMax,double targetRateMin)
	{
			// return a Map with Key 1- for Map withrates >targetMax	 and key 2 -for Map with rates<targetMin
		Map<Integer,LinkedHashMap<String,Double>> returnMap= new HashMap<Integer,LinkedHashMap<String,Double>>();
		
		Map<String,Double> aboveTargetMax= new HashMap<String,Double>();
		Map<String,Double> belowTargetMin= new HashMap<String,Double>();
		if(rateMap.get(1)!=null)
		{
			double exchRate=0.0; //scraped from site.
			rateMap.get(1).add(exchRate);//update the value in the arraylist.
			if(exchRate>targetRateMax)
			{
				aboveTargetMax.put("axis",exchRate);
				
			}
			else if ((exchRate<targetRateMin))
			{
				belowTargetMin.put("axis", exchRate);
				
			}

		}
		if(rateMap.get(2)!=null)
		{
			double exchRate=0.0; //scraped from site.
			rateMap.get(2).add(exchRate);//update the value in the arraylist.
			if(exchRate>targetRateMax)
			{
				aboveTargetMax.put("hdfc",exchRate);
				
			}
			else if ((exchRate<targetRateMin))
			{
				belowTargetMin.put("hdfc", exchRate);
				
			}

		}
		if(rateMap.get(3)!=null)
		{
			double exchRate=0.0; //scraped from site.
			rateMap.get(3).add(exchRate);//update the value in the arraylist.
			if(exchRate>targetRateMax)
			{
				aboveTargetMax.put("indus",exchRate);
				
			}
			else if ((exchRate<targetRateMin))
			{
				belowTargetMin.put("indus", exchRate);
				
			}

		}
		if(rateMap.get(4)!=null)
		{
			double exchRate=0.0; //scraped from site.
			rateMap.get(4).add(exchRate);//update the value in the arraylist.
			if(exchRate>targetRateMax)
			{
				aboveTargetMax.put("icici",exchRate);
				
			}
			else if ((exchRate<targetRateMin))
			{
				belowTargetMin.put("icici", exchRate);
				
			}

		}
		Map<String,Double>aboveMax= new LinkedHashMap<String,Double>();
		Map<String,Double>belowMin= new LinkedHashMap<String,Double>();
		aboveMax= sortMapByValues(aboveTargetMax);
		belowMin=sortMapByValues(belowTargetMin);
		
		returnMap.put(1, (LinkedHashMap<String, Double>) aboveMax);
		returnMap.put(2, (LinkedHashMap<String, Double>) belowMin);
		
		
		
		
		
		return returnMap;
	}
	
	public static  < K, V extends Comparable < ? super V >  >  Map < K, V > sortMapByValues(final Map  < K, V >  mapToSort)  
	{  
	    List < Map.Entry < K, V >  >  entries =  
	        new ArrayList < Map.Entry < K, V >  > (mapToSort.size());    
	  
	    entries.addAll(mapToSort.entrySet());  
	  
	    Collections.sort(entries,  
	                     new Comparator < Map.Entry < K, V >  > ()  
	    {  
	        @Override  
	        public int compare(  
	               final Map.Entry < K, V >  entry1,  
	               final Map.Entry < K, V >  entry2)  
	        {  
	            return entry1.getValue().compareTo(entry2.getValue());  
	        }  
	    });        
	  
	    Map < K, V >  sortedMap = new LinkedHashMap < K, V > ();        
	  
	    for (Map.Entry < K, V >  entry : entries)  
	    {  
	        sortedMap.put(entry.getKey(), entry.getValue());  
	    }        
	  
	    return sortedMap;  
	}  
}
