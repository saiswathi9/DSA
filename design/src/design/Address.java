package design;
class Address
{
	private String street;
	private String city;
	private int zip;
	private String country;
	
	Address(String street,String city,int zip,String country)
	{
		this.street=street;
		this.city=city;
		this.zip=zip;
		this.country=country;
	}
	
	public String getStreet()
	{
		return street;
	}
	public void setStreet(String street)
	{
		this.street=street;
	}
	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city=city;
	}
	public int getZip()
	{
		return zip;
	}
	public void setZip(int zip)
	{
		this.zip=zip;
	}
	public String getCountry()
	{
		return country;
	}
	public void setCountry(String country)
	{
		this.country=country;
	}
}