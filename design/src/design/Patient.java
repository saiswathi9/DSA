package design;

import java.time.ZonedDateTime;
import java.util.*;
class Patient
{
	private String name;
	private String age;
	private String address;
	private Set<String> phone=new HashSet<String>();
	private String contact;
	private String gender;
	private Prefix prefix;
	private ZonedDateTime dob;
	List<Allergy> a;
	
	Patient(Prefix prefix,String name,String age, Set<String> phone,String address, ZonedDateTime dob, String contact,String gender,List<Allergy> a)
	{
		super();
		this.name=name;
		this.age=age;
		this.address=address;
		this.contact=contact;
		this.gender=gender;
		this.a=a;
		this.prefix=prefix;
		this.dob=dob;
		this.phone=phone;
	}
	public Set<String> getPhone()
	{
		return phone;
	}
	public void setPhone(Set<String> phone)
	{
		this.phone=phone;
	}
	public ZonedDateTime getDob()
	{
		return dob;
	}
	public void setDob(ZonedDateTime dob)
	{
		this.dob=dob;
	}
	public Prefix getPrefix()
	{
		return prefix;
	}
	public void setPrefix(Prefix prefix)
	{
		this.prefix=prefix;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getAge()
	{
		return age;
	}
	public void setAge(String age)
	{
		this.age=age;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address=address;
	}
	public String getContact()
	{
		return contact;
	}
	public void setContact(String contact)
	{
		this.contact=contact;
	}
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender=gender;
	}
	public List<Allergy> getAllergy()
	{
		return a;
	}
	public void setGender(List<Allergy> a)
	{
		this.a=a;
	}
	@Override
	public String toString() {
		return "Patient [name=" + name + ", age=" + age + ", address=" + address + ", phone=" + phone + ", contact="
				+ contact + ", gender=" + gender + ", prefix=" + prefix + ", dob=" + dob + ", a=" + a + "]";
	}
			
}