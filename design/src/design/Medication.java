package design;

import java.util.Date;

class Medication
{
	private String drug;
	private String dosage;
	private String frequency;
	private int quantity;
	private String startDate;
	private String endDate;
	
	Medication(String drug,String dosage, String frequency,int quantity, String startDate, String endDate)
	{
		this.drug=drug;
		this.dosage=dosage;
		this.frequency=frequency;
		this.quantity=quantity;
		this.startDate=startDate;
		this.endDate=endDate;
	}
	
	public String getDrug()
	{
		return drug;
	}
	public void setDrug(String drug)
	{
		this.drug=drug;
	}
	public String getDosage()
	{
		return dosage;
	}
	public void setDosage(String dosage)
	{
		this.dosage=dosage;
	}
	public String getFreq()
	{
		return frequency;
	}
	public void setFreq(String freq)
	{
		this.frequency=freq;
	}
	public int getQuant()
	{
		return quantity;
	}
	public void setQuant(int quan)
	{
		this.quantity=quan;
	}
	public String getStartDate()
	{
		return startDate;
	}
	public void setStartDate(String startDate)
	{
		this.startDate=startDate;
	}
	public String getEndDate()
	{
		return endDate;
	}
	public void setEndDate(String endDate)
	{
		this.endDate=endDate;
	}

	@Override
	public String toString() {
		return "Medication [drug=" + drug + ", dosage=" + dosage + ", frequency=" + frequency + ", quantity=" + quantity
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
}