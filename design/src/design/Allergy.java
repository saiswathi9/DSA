package design;
import java.util.*;

class Allergy
{
	private String symptom;
	private Reporter reporter;
	private Severity severity;
	private String disease;
	
	Allergy(String symptom,Reporter reporter,Severity severity,String disease)
	{
		super();
		this.symptom=symptom;
		this.reporter=reporter;
		this.severity=severity;
		this.disease=disease;
	}
	public String getSymptom()
	{
		return symptom;
	}
	public void getSymptom(String symptom)
	{
		this.symptom=symptom; 
	}
	public Reporter getReporter()
	{
		return reporter;
	}
	public void getReporter(Reporter reporter)
	{
		this.reporter=reporter; 
	}
	public Severity getSeverity()
	{
		return severity;
	}
	public void getSeverity(Severity severity)
	{
		this.severity=severity; 
	}
	public String getDisease()
	{
		return disease;
	}
	public void getDisease(String disease)
	{
		this.disease=disease; 
	}
	@Override
	public String toString() {
		return "Allergy [symptom=" + symptom + ", reporter=" + reporter + ", severity=" + severity + ", patient="
				+ disease + "]";
	}
}
