package design;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Infection
{
	private float temp;
	private boolean hasInfection;
	private Scale scale;
	private float res;
	private float curr;
	private boolean phy=false;
	
	Infection(float temp,Scale scale)
	{
		this.temp=temp;
		this.scale=scale;
		if(scale==Scale.C)
		{
			res=(temp * 9/5) + 32;
		}
		if(scale==Scale.K)
		{
			res=(float) ((temp - 273.15) * 9/5 + 32);
		}
		if(scale==Scale.F)
		{
			res=temp;
		}
	}
	Infection(float temp,Scale scale,float curr)
	{
		this.temp=temp;
		this.scale=scale;
		this.curr=curr;
	}
	public void getConvTemp(float temp,Scale scale,float curr,boolean phy) {
		if(scale==Scale.C )
		{
			res=(temp * 9/5) + 32;
			System.out.println(res);
			
			curr=(curr * 9/5) + 32;
			System.out.println(curr);
			if(curr>res+1 || curr<res-1 && phy==true)
			{
				//setInfStatus(true);//true 
				System.out.println("True! has fever C");
			}
			else
				System.out.println("False alarm! C");
		}
		if(scale==Scale.K)
		{
			res=(float) ((temp - 273.15) * 9/5 + 32);
			curr=(float) ((curr - 273.15) * 9/5 + 32);
			if(phy==true && curr>res+1 || curr<res-1)
			{
				//setInfStatus(true);//true 
				System.out.println("True! has fever K");
			}
			else
				System.out.println("False alarm! K");
		}
		if(scale==Scale.F)
		{
			res=temp;
			if(curr>res+1 || curr<res-1 && phy==true)
			{
				//setInfStatus(true);//true 
				System.out.println("True! has fever F");
			}
			else
				System.out.println("False alarm! F");
		}
		//return hasInfection+" ";
	}
	Infection(float temp, boolean hasInfection)
	{
		this.temp=temp;
		this.hasInfection=hasInfection;
	}
	public Infection() {
		// TODO Auto-generated constructor stub
	}
	public float getTemp()
	{
		return temp;
	}
	public void setTemp(float temp)
	{
		this.temp=temp;
	}
	public float getCurr()
	{
		return curr;
	}
	public void setCurr(float curr)
	{
		this.curr=curr;
	}
	public float getFTemp()
	{
		return ((temp*9/5)+32);
	}
	public boolean getInfStatus()
	{	
		
		return hasInfection;
	}
	public void setInfStatus(boolean inf)
	{
		System.out.println(hasInfection);
		this.hasInfection=inf;
	}
}
class InfectionMain
{
	public static void main(String[] args)
	{
		//float curr=(float) ((99.5*9/5)+32);
		/*float curr=100;
		System.out.println(curr);*/
		Infection i=new Infection();
	/*	System.out.println(i.getFTemp());
		if(curr>i.getFTemp()+1 || curr<i.getFTemp()-1)
		{
			i.setInfStatus(true);//true 
			System.out.println("True! has fever");
		}
		else
		{
			i.setInfStatus(false);
			System.out.println("false alarm");
		}*/
		List<Float> f=new ArrayList<>();
		for(int k=0;k<3;k++) {	
		float temp=313;
		i.setTemp(temp);
		float curr=315;
		i.setCurr(curr);
		i.getConvTemp(temp, Scale.K, curr , false);
		try {
		Thread.sleep(1000);
		f.add(temp);
		System.out.println(f);
		}
		catch(Exception e)
		{
			System.err.println("Error: "+e);
		}
		}
		//System.out.print(i.getConvTemp(99, 'F', 105));
	}
}
