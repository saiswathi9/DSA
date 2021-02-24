package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class PatientListDisplay
{
	private String name;
	private String medicine;
	PatientListDisplay()
	{
		
	}
	PatientListDisplay(String name,String medicine)
	{
		this.name=name;
		this.medicine=medicine;
	}
	public String getName()
	{
		return name;
	}
	public String getMedicine()
	{
		return medicine;
	}
	static <k,v> List<k> getAllPatientsList(Map<k,v> m, v value)
	{
		List<k> l=null;
		if(m.containsValue(value))
		{
			l=new ArrayList<>();
			for(Entry<k, v> e:m.entrySet())
			{
				if(e.getValue().equals(value))
				{
					l.add(e.getKey());
				}
			}
		}
		return l;
	}
}
class PatientListDisplayMain
{
	public static void main(String[] args)
	{
		PatientListDisplay p=new PatientListDisplay();
		HashMap<String, String> m= new HashMap<String,String>();
		m.put("Sai", "Aspirin");
		m.put("Sam", "Benadryl");
		m.put("Swathi", "Aspirin");
		m.put("Kumar", "Aspirin");
		List<String> patients=PatientListDisplay.getAllPatientsList(m,"Aspirin");
		List<String> list=patients.subList(0, 2);
		System.out.println(list);
	}
}