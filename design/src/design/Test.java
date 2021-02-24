package design;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import design.Medication;
class Test
{
	public static void main(String[] args)
	{
		PatientTest p=new PatientTest("Alicia");
		p.addTime(Frequency.freq.lifelong);
		PatientTest q=new PatientTest("Ben");
		q.addTime(Frequency.freq.hourly);
		SchedulerTest s=new SchedulerTest();
		s.addListener(p);
		s.addListener(q);
		Medication m= new Medication("aspirin","200mg","1 per day",10,"2/16/2019","2/26/2019");
		s.notify(Frequency.freq.hourly, m);
		s.notify(Frequency.freq.lifelong, m);
	}
}
class Frequency
{
	enum freq
	{
		hourly,daily,lifelong;
	}
}
interface Notify
{
	void notify(Frequency.freq f, Medication m);
}
class PatientTest implements Notify
{
	private String name;
	private String disease;
	Set<Frequency.freq> s=new HashSet<>();
	
	PatientTest(String name)
	{
		this.name=name;
	}
	public void addTime(Frequency.freq f)
	{
		s.add(f); 
	}
	public void notify(Frequency.freq f,Medication m)
	{
		if(s.contains(f))
		{
			System.out.println("Hi! "+name+", Its time for your "+f+" "+m);
		}
	}
}
class SchedulerTest
{
	List<Notify> l=new ArrayList<>();
	public void addListener(Notify n)
	{
		l.add(n);
	}
	public void notify(Frequency.freq f,Medication m)
	{
		for(Notify n:l)
		{
			n.notify(f,m);
		}
	}
}