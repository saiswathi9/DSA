package design;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import design.Medication;

class MedicateNurse{
	public static void main(String args[])
	{
		NotPatient a=new NotPatient("Alice");
		a.addTime(Freq.when.morning);
		NotPatient b=new NotPatient("Bob");
		b.addTime(Freq.when.evening);
		Scheduler s=new Scheduler();
		s.addListener(a);
		s.addListener(b);
		Medication m= new Medication("aspirin","200mg","1 per day",10,"2/16/2019","2/26/2019");
		s.notify(Freq.when.morning,m,Type.disease);
		s.notify(Freq.when.evening,m,Type.disease);
	}
	
}
class Freq
{
	enum when{
		morning,afternoon,evening,night
	}
}
interface NotifyPatient
{
	void notify(Freq.when w,Medication m,Type t);
}
class NotPatient implements NotifyPatient
{
	private String name;
	private Set<Freq.when> s=new HashSet<>();
	NotPatient(String name)
	{
		this.name=name;
	}
	public void addTime(Freq.when w)
	{
		this.s.add(w);
	}
	public void notify(Freq.when w, Medication m,Type t)
	{
		if(s.contains(w))
		{
			System.out.println(name+" It's time for your medicine: "+w+ " "+m+" "+t);
		}
			
	}
//	@Override
/*	public String toString()
	{
		StringBuffer sb=new StringBuffer();
		sb.append(name).append(": scheduled for");
		for(Freq.when f:s)
		{
			sb.append(" ").append(f);
		}
		return sb.toString();
	}*/
}
class Scheduler
{
	List<NotifyPatient> l=new ArrayList<>();
	public void addListener(NotifyPatient n)
	{
		l.add(n);
	}
	public void notify(Freq.when w, Medication m,Type t)
	{
		for(NotifyPatient n:l)
		{
			n.notify(w,m,t);
		}
	}
}