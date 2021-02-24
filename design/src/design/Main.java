package design;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TimeZone;

import design.Prefix;
class Main
{
	public static void main(String[] args)
	{
		Set<String> phone=new HashSet<String>(3);
		Scanner s=new Scanner(System.in);
		System.out.println("Enter name");
		String name=s.nextLine();
		System.out.println("Enter age");
		String age=s.nextLine();
		System.out.println("Enter phone numbers at max 3");
		for(int i=0;i<3;i++) {
			System.out.println("Enter phone "+i+" : ");
			phone.add(s.nextLine());
			}
		System.out.println("Enter address");
		String address=s.nextLine();
		System.out.println("Enter phone numer");
		String contact=s.nextLine();
		System.out.println("Enter gender");
		String gender=s.nextLine();
		//SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy 'T' HH:mm:ss");
		//TimeZone usa=TimeZone.getTimeZone("Asia/Karachi");
		//sd.setTimeZone(usa);
		//System.out.println(sd.format(new Date()));
		//System.out.println("Enter DOB");
		//ZonedDateTime g = ZonedDateTime.now(); 
		//System.out.println(g);
		//ZonedDateTime b = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
		//System.out.println(b);
		ZonedDateTime d=ZonedDateTime.now(ZoneId.of("Europe/Paris"));
		LocalDate dobdate=LocalDate.of(1993, Month.AUGUST, 23);
		LocalDate currdate=LocalDate.now();
		Period period=Period.between(dobdate, currdate);
		System.out.println(period);
		//Patient p=new Patient("Caleb",53,"columbia","5735290493","M");
		Allergy a=new Allergy("cough",Reporter.nurse,Severity.low,"flu");
		List<Allergy> l=new ArrayList<Allergy>();
		l.add(a);
		System.out.println(a);
		Patient p=new Patient(Prefix.Mr,name,age,phone,address,d,contact,gender,l);
		System.out.println(Arrays.asList(Prefix.values()));
		System.out.println(p);
		Medication m=new Medication("aspirin","200mg","1 per day",10,"2/16/2019","2/26/2019");
		System.out.println(m);
		System.out.println("Enter temp of patient in C");
		float ctemp=s.nextFloat();
		System.out.println(Arrays.asList(Location.values()));
		Temperature t=new Temperature(ctemp,Location.ear);
		if(t.getFTemp(ctemp)>99.0)
			System.out.println("Patient has fever.");
		else
			System.out.println("Patient is fine!");
				
		Address aa=new Address("University Ave","Columbia",65201,"USA");
		Address b=new Address("University Ave","Columbia",65201,"USA");
		
		List<Address> add=new ArrayList<Address>();
		add.add(aa);
		add.add(b);
		
		List<String> f=new ArrayList<String>();
		f.add("sai");
		List<String> la=new ArrayList<String>();
		la.add("sivarathri");
		List<String> pa=new ArrayList<String>();
		pa.add("5735290493");
		Demographics da=new Demographics(f,la,add,pa);
		System.out.println(da);
	}
}