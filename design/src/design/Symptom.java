package design;

import java.util.*;
class Person
{
	private String mName;
	  private int mAge;
	  private String oName;  
	  public Person(int age) {
	  //   mName = name;
	     mAge = age;
	   //  oName = oname;
	  }
	  public int getAge()
	  {
		  return mAge;
	  }
	  public String getName() {
	     return mName;
	  }
	  public String getOtherName() {
		  return oName;
	  }
	@Override
	public String toString() {
		return "Person [mName=" + mName + ", mAge=" + mAge + ", oName=" + oName + "]";
	}
	  
	}
class Symptom{
	
	public static void main(String[] args) {
	Set<Person> arr = new HashSet<>();
	arr.add(new Person(10));
	arr.add(new Person(20));
	arr.add(new Person(30));
	arr.add(new Person(40));
	//System.out.println(arr);
	
	int a=10;
	if(arr.contains(a))
	{
		System.out.println("s");
	}
	//getNames(arr,a);
	}
	public static Set<Person> getNames(Set<Person> s,String oname)
	{
		Set<Person> res=new HashSet<Person>();
		//System.out.println(s);
			if(s.contains(oname))
			{
				res.iterator().next();
				System.out.println("here");
			}
			//x.equals(s.iterator().next());
		System.out.println(res);
		return res;
	}
}
