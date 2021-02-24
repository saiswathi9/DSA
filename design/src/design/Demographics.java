package design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import design.Address;

class Demographics
{
	private List<String> fname=new ArrayList<String>();
	private List<String> lname=new ArrayList<String>();
	private List<Address> add=new ArrayList<Address>();
	private List<String> phone=new ArrayList<String>();
	
	Demographics(List<String> fname,List<String> lname, List<Address> add,List<String> phone)
	{
		this.fname=fname;
		this.lname=lname;
		this.add=add;
		this.phone=phone;
	}
	
	public List<String> getFname()
	{
		return fname;
	}
	public void setFname(List<String> fname)
	{
		this.fname=fname;
	}
	public List<String> getLname()
	{
		return lname;
	}
	public void setLname(List<String> lname)
	{
		this.lname=lname;
	}
	public List<Address> getAdd()
	{
		return add;
	}
	public List<Address> getFullAdd()
	{
		String a;
		//for(int i=0;i<2;i++) {
		a=((Address) add).getStreet()+" "+((Address) add).getCity()+" "+((Address) add).getZip()+" "+((Address) add).getCountry();
		List<String> temp=new ArrayList<String>(Arrays.asList(a));
		System.out.println(temp);
		List<Address> ltemp=new ArrayList<Address>((Collection<? extends Address>) Arrays.asList(temp));
		//ltemp=temp;
		return ltemp;
	}
	public void setAdd(List<Address> add)
	{
		this.add=add;
	}	
	public List<String> getPhone()
	{
		return phone;
	}
	public void setPhone(List<String> phone)
	{
		this.phone=phone;
	}
}
class DemoMain
{
	public static void main(String[] args)
	{
		Address a=new Address("University Ave","Columbia",65201,"USA");
		Address b=new Address("University Ave","Columbia",65201,"USA");
		
		List<Address> addt=new ArrayList<Address>();
		addt.add(a);
		addt.add(b);

		List<String> f=new ArrayList<String>();
		f.add("sai");
		f.add("Sam");
		//for(String s:f)
			System.out.println(f);
		List<String> l=new ArrayList<String>();
		l.add("sivarathri");
		l.add("sivarathri");
		List<String> p=new ArrayList<String>();
		p.add("5735290493");
		p.add("sivarathri");
		Demographics d=new Demographics(f,l,addt,p);
		
		//d.add(new Demographics(f,l,add,p));
		//for(Demographics dtemp:d)
		System.out.println(d.getFname()+" "+d.getLname()+" "+d.getFullAdd()+" "+d.getPhone());
	}
	
}