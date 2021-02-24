package design;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Notifying
{
	void notify(String s,List<Boolean> res);
}

class TemperatureTest
{
	private float temp;
	private String nurse;
	private Scale scale;
	private float curr;
	private boolean pa;
	private Location loc;
	private boolean res=false;
	public void setNotify(String nurse, List<Boolean> res)
	{
		this.nurse=nurse;
	}
	TemperatureTest(float temp)
	{
		this.temp=temp;
	}
	
	TemperatureTest(float temp,Scale scale,float curr,boolean pa,Location loc)
	{
		this.temp=temp;
		this.curr=curr;
		this.scale=scale;
		this.pa=pa;
		this.loc=loc;
	}
	
	TemperatureTest(float temp, Scale scale, float curr)
	{
		this.temp=temp;
		this.scale=scale;
		this.curr=curr;
	}
	public float getTemp()
	{
		return temp;
	}
	public boolean getRes()
	{
		return res;
	}
	public void setTemp(float temp)
	{
		this.temp=temp;
	}
	public Scale getScale()
	{
		return scale;
	}
	public float getCurr()
	{
		return curr;
	}
	public void conv(float temp,Scale scale,float curr)
	{
		
		if(Scale.C==scale)
		{
			temp=temp*9/5+32;
			curr=curr*9/5+32;
		}
		if(Scale.F==scale)
		{
			this.temp=temp;
			this.curr=curr;
		}
		if(Scale.K==scale)
		{
			temp=(float) ((temp-273.15)*9/5+32);
			curr=(float) ((temp-273.15)*9/5+32);
		} 
	}
	public boolean fever(float temp,Scale scale,float curr,boolean pa,Location loc)
	{
		conv(temp,scale,curr);
		if(pa==false) {
		if(curr>temp+1 || curr<temp-1)
		{
			System.out.println("Patient has fever!!!"+loc);
			res=true;
		}
		else {
			System.out.println("No!! Patient doesn't have fever"+loc);
			res=false;
		}
		}
		else {
			if(curr>temp+1 || curr<temp-1)
			{
				System.out.println("Patient might have fever. Check for other symptoms."+loc);
				res=true;
			}
			else {
				System.out.println("No!! Patient doesn't have fever"+loc);
				res=false;
			}
			}
		//System.out.println(res);
		return res;
	}
}
class TempTestMain 
{
	public static void main(String[] args)
	{
		String nurse="Benny";
		List<Float> l=new ArrayList<>();		
		float f;
		Not n=new Not(nurse);
		for(int i=0;i<10;i++) {
		System.out.println("Enter temp: ");
		Scanner s=new Scanner(System.in);
		f=s.nextFloat();
		TemperatureTest t=new TemperatureTest(f);
		
		//t.conv(98, Scale.F, 100);
		l.add(t.getTemp());
		System.out.println(l);
		t.fever(f, Scale.F,100, false,Location.ear);
		
		//System.out.println(b);
		List<Boolean> b=new ArrayList<>();
		b.add(t.getRes());
		if(t.getRes())
			System.out.println("has infection");
		Schedule sc=new Schedule();
		sc.addListen(n);
		sc.notify(nurse,b);
		try {
		Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
		}
	}
	

}
class Not implements Notifying
{
	private String nurse;
	Not(String nurse)
	{
		this.nurse=nurse;
	}
	public void notify(String s,List<Boolean> b)
	{
		//List<Boolean> b=new ArrayList<>();

		if(b.contains(true))
			System.out.println(s+" Alert! Patient has fever.");
	}
}
class Schedule
{
	List<Notifying> m=new ArrayList<>();
	public void addListen(Notifying n)
	{
		m.add(n);
	}
	public void notify(String s, List<Boolean> b)
	{
		for(Notifying n:m)
		n.notify(s,b);
		
	}
}