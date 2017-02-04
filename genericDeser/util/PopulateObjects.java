package genericDeser.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import genericDeser.fileOperations.FileProcessor;

public class PopulateObjects {
	private FileProcessor fpobj;
	
	private Map<String,Class> hmap;
	
	private Map<First,Integer> map1 = new HashMap<First,Integer>();
	private Map<Second,Integer> map2 = new HashMap<Second,Integer>();
	
	/**
	 * Constructor
	 * @param fpobjIn
	 */
	public PopulateObjects(FileProcessor fpobjIn) {
		// TODO Auto-generated constructor stub

		Logger.writeMessage("Constructor of PopulateObjects Called", Logger.DebugLevel.CONSTRUCTORCALLED);
		this.fpobj = fpobjIn ;
		hmap = new HashMap<String,Class>();
		hmap.put("int", Integer.TYPE);
		hmap.put("String",String.class);
		hmap.put("float", Float.TYPE);
		hmap.put("double", Double.TYPE);
		hmap.put("short", Short.TYPE);
		hmap.put("boolean", Boolean.TYPE);
	}

	/**
	 * Method to read from file
	 * and invoke appropriate object
	 * and put it in a data structure
	 */
	public void deserObjects(){
		
		String str;
		String classname = null;
		String type=null;
		String value=null;
		String methodName = null;
		Class cls=null;
		Object obj=null;
		
		while((str=fpobj.readFile())!=null){
			try {
				if(str.contains("fqn")){
					if(!(classname==null)){
						if(classname.equals("genericDeser.util.First")){
							if(map1.containsKey(obj)){
								int count = map1.get(obj);
								count++;
								map1.put((First) obj,count);
								Logger.writeMessage("Entry added to hashmap1", Logger.DebugLevel.ENTRYTOHASHMAP);
							}
							else{
								map1.put((First) obj, 1);
								Logger.writeMessage("Entry added to hashmap1", Logger.DebugLevel.ENTRYTOHASHMAP);
							}
						
						}
						else if(classname.equals("genericDeser.util.Second")){
							if(map2.containsKey(obj)){
								int count = map2.get(obj);
								count++;
								map2.put((Second) obj,count);
								Logger.writeMessage("Entry added to hashmap2", Logger.DebugLevel.ENTRYTOHASHMAP);
							}
							else{
								map2.put((Second) obj, 1);
								Logger.writeMessage("Entry added to hashmap2", Logger.DebugLevel.ENTRYTOHASHMAP);
							}
						}
				
					}
				String arr[] = str.split(":");
				classname = arr[1];
				cls = Class.forName(classname);
				obj = cls.newInstance();
			}
			else if(str.contains("int") || str.contains("float") || str.contains("double") || str.contains("short") || str.contains("String") || str.contains("boolean")){
				String s1[] = str.split(",");
				s1[1] =s1[1].replaceAll(" ", "");
				s1[2] =s1[2].replaceAll(" ", "");
				String s2[] = s1[0].split("=");
				String s3[] = s1[1].split("=");
				String s4[] = s1[2].split("=");
				type = s2[1];
				methodName = s3[1];
				value = s4[1];
				Class c1 = hmap.get(type);
				Method m1 = cls.getMethod("set"+methodName, c1);
				Object ob1 = obType(value,type);
				Object result = m1.invoke(obj, ob1);
			
			}
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		
		if(classname!=null && classname.equals("genericDeser.util.First")){
			if(map1.containsKey(obj)){
				int count = map1.get(obj);
				count++;
				map1.put((First) obj,count);
				Logger.writeMessage("Entry added to hashmap1", Logger.DebugLevel.ENTRYTOHASHMAP);
			}
			else{
				map1.put((First) obj, 1);
				Logger.writeMessage("Entry added to hashmap1", Logger.DebugLevel.ENTRYTOHASHMAP);
			}
			
		}
		else if(classname!=null && classname.equals("genericDeser.util.Second")){
			if(map2.containsKey(obj)){
				int count = map2.get(obj);
				count++;
				map2.put((Second) obj,count);
				Logger.writeMessage("Entry added to hashmap2", Logger.DebugLevel.ENTRYTOHASHMAP);
			}
			else{
				map2.put((Second) obj, 1);
				Logger.writeMessage("Entry added to hashmap2", Logger.DebugLevel.ENTRYTOHASHMAP);
			}
		}

		print();
	}


	/**
	* Method to return value
	* 
	* @param value
	* @param type
	* @return
	*/
	private Object obType(String value, String type) {
		Object object = null;
		if (type.equalsIgnoreCase("int")) {
			object = Integer.parseInt(value);
		} else if (type.equalsIgnoreCase("String")) {
			object = value;
		} else if (type.equalsIgnoreCase("double")) {
			object = Double.parseDouble(value);
		} else if (type.equalsIgnoreCase("float")) {
			object = Float.parseFloat(value);
		} else if (type.equalsIgnoreCase("short")) {
			object = Short.parseShort(value);
		}else if (type.equalsIgnoreCase("boolean")) {
			object = Boolean.parseBoolean(value);
		}
		return object;	
	}
	
	/**
	 * Method to print the final output
	 */
	public void print(){
		
		Logger.writeMessage("Number of unique First objects: "+map1.size(), Logger.DebugLevel.PRINTOUTPUT);		
		int sum1=0;
		for(int i: map1.values()){
			sum1 += i;
		}
		Logger.writeMessage("Total Number of First objects: "+sum1, Logger.DebugLevel.PRINTOUTPUT);
		
		Logger.writeMessage("Number of unique Second objects: "+map2.size(), Logger.DebugLevel.PRINTOUTPUT);
		
		int sum2=0;
		for(int i: map2.values()){
			sum2 += i;
		}
		Logger.writeMessage("Total Number of Second objects: "+sum2, Logger.DebugLevel.PRINTOUTPUT);
		
	}
	
	
}
