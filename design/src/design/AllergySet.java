package design;

import java.util.*;

class AllergySet
{
	private static Scanner s;

	public static void main(String args[]) {
	Set<Set> all=new HashSet<Set>();	
	Set<String> rhinitis=new HashSet<String>(); 
	rhinitis.addAll(Arrays.asList(new String[] {"rhinitis","sneezes","itchiness","runny nose"}));
	Set<String> conjuctivitis=new HashSet<String>();
	conjuctivitis.addAll(Arrays.asList(new String[] {"conjuctivitis","red eyes","itchiness","watering"}));
	Set<String> hives=new HashSet<String>();
	hives.addAll(Arrays.asList(new String[] {"hives","rashes","itchy skin","raised skin"}));
	all.add(rhinitis);
	all.add(conjuctivitis);
	all.add(hives);
	//System.out.println(all);
	System.out.println("give a symptom:");
	s = new Scanner(System.in);
    String symptom=s.nextLine();
    if(rhinitis.contains(symptom))
    {
    	System.out.println("rhinitis");
    }
    else if(conjuctivitis.contains(symptom))
    {
    	System.out.println("conjuctivitis");
    }
    else if(hives.contains(symptom))
    {
    	System.out.println("hives");
    }
    else
    {
    	System.out.println("Given symptom doesn't match with an disease");
    }
    String sym="itchiness";
    //System.out.println();
    getList(sym,all);
	}
	public static Set<String> getList(String sym,Set<Set> all)
	{
		Set<String> res=new HashSet<String>();
		
		for(Set<Set>f:all)
		if(f.contains(sym))
		{
			res.add(f.toString());
			for(String x: res) {
				
			System.out.println(x);
			Iterator r=res.iterator();
			Object o=r.next();
			//System.out.println(f);
			//System.out.println(o);
			}
		}
		
		return res;
	}
	
}