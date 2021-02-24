package design;
class Temperature
{
	private float temp;
	private Location loc;
	
	Temperature(Location loc)
	{
		this.temp=0;
		this.loc=loc;
	}
	Temperature(float temp,Location loc)
	{
		this.temp=temp;
		this.loc=loc;
	}
	public float getTemp()
	{
		return temp;
	}
	public void setTemp(float temp)
	{
		this.temp=temp;
	}
	public Location getLocation()
	{
		return loc;
	}
	public void setLocation(Location loc)
	{
		this.loc=loc;
	}
	public float getFTemp(float temp)
	{
		return (temp*9/5)+32;
	}
	@Override
	public String toString() {
		return "Temperature [temp=" + temp + ", loc=" + loc + "]";
	}
	
}