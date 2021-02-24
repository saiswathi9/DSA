package design;
import java.util.*;
class NotifierTest
{
	private String name;
	private String patient;
	private String getName()
	{
		return name;
	}
	private String getPat()
	{
		return patient;
	}
	public NotifierTest(String n, String p)
	{
		this.name=n;
		this.patient=p;
	}
	List<MedTime> med=new ArrayList<>();
	
	public void notify(String s,Medication m,MedTime t, String p)
	{
		med.add(t);
		if(med.contains(t))
		{
			System.out.println("Hi! "+s+" Patient "+p+" has to take: "+m+" at "+t);
		}
	}
}
interface Notifier
{
	void notify(String name,Medication m,MedTime t);
}
class Show
{
	List<NotifierTest> nt=new ArrayList<>();
	public void addListener(NotifierTest n)
	{
		nt.add(n);
	}
	public void notify(String s,Medication m,MedTime t,String p)
	{
		for(NotifierTest n:nt)
			n.notify(s, m, t,p);
	}
}
class NotifierTestMain
{
	public static void main(String[] args)
	{
		String nurse="Ben";
		String pat="Alivia";
		NotifierTest n=new NotifierTest(nurse,pat);
		Show s=new Show();
		s.addListener(n);
		Medication m=new Medication("aspirin","200mg","1 per day",10,"2/16/2019","2/26/2019");
		s.notify(nurse, m, MedTime.morning,pat);
		//System.out.println(s);
	}
}