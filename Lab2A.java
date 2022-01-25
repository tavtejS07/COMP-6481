import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class Lab2A {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		String threshold = "18 04 2022";
		
		
		for(int i = 0; i < N; i++) {
		String dob = sc.nextLine();
		
		SimpleDateFormat dobFormat = new SimpleDateFormat("dd MM yyyy");
		
		Date dateOfBirth = dobFormat.parse(dob);
		Date thresholdDate = dobFormat.parse(threshold);
		
		Instant local = dateOfBirth.toInstant();
		Instant localThresh = thresholdDate.toInstant();
		
		ZonedDateTime zone = local.atZone(ZoneId.systemDefault());
		ZonedDateTime zoneThresh = localThresh.atZone(ZoneId.systemDefault());
		
		LocalDate dobEntered = zone.toLocalDate();
		LocalDate thresh = zoneThresh.toLocalDate();
		
		Period diff = Period.between(dobEntered, thresh);
		
		if(diff.getYears() >=13 && N <= 25 && N >= 1) {
			System.out.println("old enough" + "\n");
		}else {
			System.out.println("too young" + "\n");
		}
		
	}
	sc.close();	

	}

}
