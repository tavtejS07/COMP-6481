//----------------------------------------------
//
// Assignment 2
// Tavtej Singh Lehri
// Written by: Tavtej Singh Lehri 40121745
//----------------------------------------------

import java.util.*;
/**
 * 
 * @author tavtejsingh
 *
 */

public class Sales {
	
	private String country;
	private String item_type;
	private char order_priority;
	Date date;
	private long order_ID;
	Date ship_date;
	private int units_sold;
	private float unit_price;
	private float unit_cost;
	private double revenue;
	private double total_cost;
	private double total_profit;

	/**
	 * Constructor Class
	 * @param country
	 * @param item_type
	 * @param order_priority
	 * @param date
	 * @param order_ID
	 * @param ship_date
	 * @param units_sold
	 * @param unit_price
	 * @param unit_cost
	 * @param revenue
	 * @param total_cost
	 * @param total_profit
	 */
	public Sales(String country, String item_type, char order_priority, Date date, long order_ID, Date ship_date,
			int units_sold, float unit_price, float unit_cost, double revenue, double total_cost, double total_profit) {
		super();
		this.country = country;
		this.item_type = item_type;
		this.order_priority = order_priority;
		this.date = date;
		this.order_ID = order_ID;
		this.ship_date = ship_date;
		this.units_sold = units_sold;
		this.unit_price = unit_price;
		this.unit_cost = unit_cost;
		this.revenue = revenue;
		this.total_cost = total_cost;
		this.total_profit = total_profit;
	}
	
	/**
	 * Copy Constructor
	 * 
	 * @param sales
	 */
	public Sales(Sales sales) {
		this.country = sales.country;
		this.item_type = sales.item_type;
		this.order_priority = sales.order_priority;
		this.date = sales.date;
		this.order_ID = sales.order_ID;
		this.ship_date = sales.ship_date;
		this.units_sold = sales.units_sold;
		this.unit_price = sales.unit_price;
		this.unit_cost = sales.unit_cost;
		this.revenue = sales.revenue;
		this.total_cost = sales.total_cost;
		this.total_profit = sales.total_profit;
	}
	
	/**
	 * Default Constructor
	 */
	public Sales() {
		
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the item_type
	 */
	public String getItem_type() {
		return item_type;
	}

	/**
	 * @param item_type the item_type to set
	 */
	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}

	/**
	 * @return the order_priority
	 */
	public char getOrder_priority() {
		return order_priority;
	}

	/**
	 * @param order_priority the order_priority to set
	 */
	public void setOrder_priority(char order_priority) {
		this.order_priority = order_priority;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the order_ID
	 */
	public long getOrder_ID() {
		return order_ID;
	}

	/**
	 * @param order_ID the order_ID to set
	 */
	public void setOrder_ID(long order_ID) {
		this.order_ID = order_ID;
	}

	/**
	 * @return the ship_date
	 */
	public Date getShip_date() {
		return ship_date;
	}

	/**
	 * @param ship_date the ship_date to set
	 */
	public void setShip_date(Date ship_date) {
		this.ship_date = ship_date;
	}

	/**
	 * @return the units_sold
	 */
	public int getUnits_sold() {
		return units_sold;
	}

	/**
	 * @param units_sold the units_sold to set
	 */
	public void setUnits_sold(int units_sold) {
		this.units_sold = units_sold;
	}

	/**
	 * @return the unit_price
	 */
	public float getUnit_price() {
		return unit_price;
	}

	/**
	 * @param unit_price the unit_price to set
	 */
	public void setUnit_price(float unit_price) {
		this.unit_price = unit_price;
	}

	/**
	 * @return the unit_cost
	 */
	public float getUnit_cost() {
		return unit_cost;
	}

	/**
	 * @param unit_cost the unit_cost to set
	 */
	public void setUnit_cost(float unit_cost) {
		this.unit_cost = unit_cost;
	}

	/**
	 * @return the revenue
	 */
	public double getRevenue() {
		return revenue;
	}

	/**
	 * @param revenue the revenue to set
	 */
	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}

	/**
	 * @return the total_cost
	 */
	public double getTotal_cost() {
		return total_cost;
	}

	/**
	 * @param total_cost the total_cost to set
	 */
	public void setTotal_cost(double total_cost) {
		this.total_cost = total_cost;
	}

	/**
	 * @return the total_profit
	 */
	public double getTotal_profit() {
		return total_profit;
	}

	/**
	 * @param total_profit the total_profit to set
	 */
	public void setTotal_profit(double total_profit) {
		this.total_profit = total_profit;
	}

	@Override
	public String toString() {
		return country + "\t" + item_type + "\t"  + order_priority + "\t" +  date + "\t"  + order_ID +"\t" +  ship_date + "\t"
				+ units_sold + "\t"  + unit_price + "\t" + unit_cost + "\t" + revenue + "\t" + total_cost + "\t" + total_profit;
	}
	
	

}
