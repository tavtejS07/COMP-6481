//------------------------------------------
//Assignment 1
//@Tavtej Singh Lehri
//Written by: Tavtej Singh Lehri 40121745
//------------------------------------------

package comp6481_assignment1;

/**
 * Vaccine Class implementation
 * @author tavtejsingh
 *
 */

enum Brand{
	 pfizer,
	 moderna,
	 johnson,
	 covishield;
}

public class Vaccine {
	private Brand brand;
	public static int count = 0;
	private double dose;
	private String expiry_date;
	private long id;
	private double price_tag;
	
	/**
	 * Constructor class
	 * 
	 * @param brand
	 * @param dose
	 * @param expiry_date
	 * @param id
	 * @param price_tag
	 */
	public Vaccine(Brand brand, double dose, String expiry_date, long id, double price_tag) {
		//this.brand = brand;
		this.brand = brand;
		this.dose = dose;
		this.expiry_date = expiry_date;
		this.id = id;
		this.price_tag = price_tag;
		count++;
	}
	
	/**
	 * copy constructor
	 * 
	 * @param vac
	 */
	public Vaccine(Vaccine vac) {
		this.brand = vac.brand;
		this.dose = vac.dose;
		this.expiry_date = vac.expiry_date;
		this.id = vac.id;
		this.price_tag = vac.price_tag;
		count++;
	}	
	
	/**
	 * 
	 */
	public Vaccine() {
		count++;
	}

	/**
	 * @return the brand
	 */
	public Brand getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	/**
	 * @return the dose
	 */
	public double getDose() {
		return dose;
	}

	/**
	 * @param dose the dose to set
	 */
	public void setDose(double dose) {
		this.dose = dose;
	}

	/**
	 * @return the expiry_date
	 */
	public String getExpiry_date() {
		return expiry_date;
	}

	/**
	 * @param expiry_date the expiry_date to set
	 */
	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the price_tag
	 */
	public double getPrice_tag() {
		return price_tag;
	}

	/**
	 * @param price_tag the price_tag to set
	 */
	public void setPrice_tag(double price_tag) {
		this.price_tag = price_tag;
	}
	
	/**
	 * find the number of vaccine objects created
	 * @return
	 */
	public static int findNumberOfCreatedVaccined() {
		return count;
	}

	@Override
	public String toString() {
		return "Brand: " + this.brand + "\nDose: " + this.dose + "\nExpiry: " + this.expiry_date
				+ "\nID: " + this.id + "\nPrice: " + this.price_tag;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(this == null || obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		else {
			Vaccine vac = (Vaccine) obj;
			if(this.brand.equals(vac.getBrand()) &&
					this.dose == vac.getDose()) {
				return true;
			}else {
				return false;
			}
		}
	}

}
