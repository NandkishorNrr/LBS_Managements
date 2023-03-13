package com.lbs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	Connection con;

	String name = "CustomerName";
	int billNo = 100;
	Date issueDate = Date.valueOf(LocalDate.now());
	Date returnDate = Date.valueOf(LocalDate.now());

	String mobNo = "1234567890";
	String address = "xyz abc 12345";
	
	int plate3_2 = 0;
	int plate3_1_75 = 0;
	int plate3_1_5 = 0;
	int plate3_1_25 = 0;
	int plate3_1 = 0;
	int tinPlate = 0;
	int balli_14 = 0;
	int balli_12 = 0;
	int balli_10 = 0;
	int balli_9_8 = 0;
	int chabiBadi = 0;
	int chabiChhoti = 0;
	int patiya = 0;
	
	int numDays = 20;
	int units = 0;
	int advAmount;
	int totalAmount;
	
	public Main() {
		this.con = getConnection();
	}
	
	Scanner in = new Scanner(System.in);

	private Connection getConnection() {
		Connection connection  = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lbs", "root", "Nrr@dev1ms");
		}
		catch(Exception e) {
			e.printStackTrace();
			return connection;
		}
		return connection;
	}
	
	public void updateMaterial(String flag) {
		if(flag.equals("issued")) {
			try {
				PreparedStatement ps = con.prepareStatement("UPDATE material set "
						+ "plate3_2 = plate3_2 - ?, "
						+ "plate3_1_75 = plate3_1_75 - ?,"
						+ "plate3_1_5 = plate3_1_5 - ?,"
						+ "plate3_1_25 = plate3_1_25 - ?,"
						+ "plate3_1 = plate3_1 - ?,"
						+ "tinPlate = tinPlate - ?,"
						+ "balli_14 = balli_14- ?,"
						+ "balli_12 = balli_12- ?,"
						+ "balli_10 = balli_10- ?,"
						+ "balli_9_8 = balli_9_8- ?,"
						+ "chabiChhoti = chabiChhoti- ?,"
						+ "chabiBadi = chabiBadi- ?,"
						+ "patiya = patiya- ?");
				ps.setInt(1, plate3_2);
				ps.setInt(2, plate3_1_75);
				ps.setInt(3, plate3_1_5);
				ps.setInt(4, plate3_1_25);
				ps.setInt(5, plate3_1);
				ps.setInt(6, tinPlate);
				ps.setInt(7, balli_14);
				ps.setInt(8, balli_12);
				ps.setInt(9, balli_10);
				ps.setInt(10, balli_9_8);
				ps.setInt(11, chabiChhoti);
				ps.setInt(12, chabiBadi);
				ps.setInt(13, patiya);
				ps.executeUpdate();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(flag.equals("returned")) {
			try {
				PreparedStatement ps = con.prepareStatement("UPDATE material set "
						+ "plate3_2 = plate3_2 + ?, "
						+ "plate3_1_75 = plate3_1_75 + ?,"
						+ "plate3_1_5 = plate3_1_5 + ?,"
						+ "plate3_1_25 = plate3_1_25 + ?,"
						+ "plate3_1 = plate3_1 + ?,"
						+ "tinPlate = tinPlate + ?,"
						+ "balli_14 = balli_14 + ?,"
						+ "balli_12 = balli_12 + ?,"
						+ "balli_10 = balli_10 + ?,"
						+ "balli_9_8 = balli_9_8 + ?,"
						+ "chabiChhoti = chabiChhoti + ?,"
						+ "chabiBadi = chabiBadi + ?,"
						+ "patiya = patiya- ?");
				ps.setInt(1, plate3_2);
				ps.setInt(2, plate3_1_75);
				ps.setInt(3, plate3_1_5);
				ps.setInt(4, plate3_1_25);
				ps.setInt(5, plate3_1);
				ps.setInt(6, tinPlate);
				ps.setInt(7, balli_14);
				ps.setInt(8, balli_12);
				ps.setInt(9, balli_10);
				ps.setInt(10, balli_9_8);
				ps.setInt(11, chabiChhoti);
				ps.setInt(12, chabiBadi);
				ps.setInt(13, patiya);
				ps.executeUpdate();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(flag.equals("added")){
			display();
			try {
				PreparedStatement ps = con.prepareStatement("UPDATE material set "
						+ "plate3_2 = plate3_2 + ?, "
						+ "plate3_1_75 = plate3_1_75 + ?,"
						+ "plate3_1_5 = plate3_1_5 + ?,"
						+ "plate3_1_25 = plate3_1_25 + ?,"
						+ "plate3_1 = plate3_1 + ?,"
						+ "tinPlate = tinPlate + ?,"
						+ "balli_14 = balli_14 + ?,"
						+ "balli_12 = balli_12 + ?,"
						+ "balli_10 = balli_10 + ?,"
						+ "balli_9_8 = balli_9_8 + ?,"
						+ "chabiChhoti = chabiChhoti + ?,"
						+ "chabiBadi = chabiBadi + ?,"
						+ "patiya = patiya+ ?");
				ps.setInt(1, plate3_2);
				ps.setInt(2, plate3_1_75);
				ps.setInt(3, plate3_1_5);
				ps.setInt(4, plate3_1_25);
				ps.setInt(5, plate3_1);
				ps.setInt(6, tinPlate);
				ps.setInt(7, balli_14);
				ps.setInt(8, balli_12);
				ps.setInt(9, balli_10);
				ps.setInt(10, balli_9_8);
				ps.setInt(11, chabiChhoti);
				ps.setInt(12, chabiBadi);
				ps.setInt(13, patiya);
				ps.executeUpdate();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("Added new material");
		}
	}


	public void issued() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("ISSUE");

		System.out.println("Enter customer name : ");
		name = in.nextLine();
		
		System.out.println("Enter address: ");
		address = in.nextLine();
		
		System.out.println("Enter bill number: ");
		billNo = in.nextInt();

		display();
		
		System.out.println("Advance ");
		advAmount = in.nextInt();



		/*
		 * units = (plate3_2 + plate3_1_75 + plate3_1_5 + plate3_1_25 + plate3_1 +
		 * tinPlate + balli_14 + balli_12 + balli_10 + balli_9_8 + chabiBadi +
		 * chabiChhoti); totalAmount = numDays*units + patiya*numDays*5;
		 */

		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO billing (issueDate, cstmr_name, billNo, mobNo, address, plate3_2, plate3_1_75, plate3_1_5, plate3_1_25, plate3_1, tinPlate, balli_14, balli_12, balli_10, balli_9_8, chabiChhoti, chabiBadi, patiya, numDays, advAmount, totalAmount) "
					+ "value('" + issueDate.toString() + "',  '" + name + "', '" + billNo + "', '"  + mobNo + "', '" + address + "', '" + plate3_2 + "', '" + plate3_1_75 + "', '" +  plate3_1_5 + "', '" + plate3_1_25 + "', '" + plate3_1  + "', '" + tinPlate + "', '" + balli_14  + "', ' " + balli_12 + "', '" + balli_10 + "' , '" + balli_9_8 + "', '" + chabiChhoti + "', '" + chabiBadi + "', '" + patiya + "', '" + numDays + "', '" + advAmount + "', '" + totalAmount + "' "  
					+ ");");
//			ps.setInt(1, amount);
			ps.execute();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		updateMaterial("issued");
			
		System.out.println("Issued OK");
	}
	
	public void returned(int bn) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("RETURN");

		
		System.out.println("You have to pay(Total - Adv.)");
//		advAmount = in.nextInt();



		units = (plate3_2 + plate3_1_75 + plate3_1_5 + plate3_1_25 + plate3_1 + tinPlate + balli_14 + balli_12 + balli_10 + balli_9_8 + chabiBadi + chabiChhoti);
		totalAmount = numDays*units +  patiya*numDays*5;

	
			try {
				PreparedStatement ps = con.prepareStatement("UPDATE billing set "
						+ "plate3_2 = plate3_2 - ?, "
						+ "plate3_1_75 = plate3_1_75 - ?,"
						+ "plate3_1_5 = plate3_1_5 - ?,"
						+ "plate3_1_25 = plate3_1_25 - ?,"
						+ "plate3_1 = plate3_1 - ?,"
						+ "tinPlate = tinPlate - ?,"
						+ "balli_14 = balli_14- ?,"
						+ "balli_12 = balli_12- ?,"
						+ "balli_10 = balli_10- ?,"
						+ "balli_9_8 = balli_9_8- ?,"
						+ "chabiChhoti = chabiChhoti- ?,"
						+ "chabiBadi = chabiBadi- ?,"
						+ "patiya = patiya- ?,"
						+ "returnDate = ?"
						+ "WHERE billNo = " + bn + "");
				ps.setInt(1, plate3_2);
				ps.setInt(2, plate3_1_75);
				ps.setInt(3, plate3_1_5);
				ps.setInt(4, plate3_1_25);
				ps.setInt(5, plate3_1);
				ps.setInt(6, tinPlate);
				ps.setInt(7, balli_14);
				ps.setInt(8, balli_12);
				ps.setInt(9, balli_10);
				ps.setInt(10, balli_9_8);
				ps.setInt(11, chabiChhoti);
				ps.setInt(12, chabiBadi);
				ps.setInt(13, patiya);
				ps.setDate(14, returnDate);
				ps.executeUpdate();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	
		
		updateMaterial("returned");
				
		System.out.println("Returned OK");
	}
	
	private void display() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter number of plates: ");
		System.out.println("Plates 3 X 2: ");
		plate3_2 = in.nextInt();

		System.out.println("Plates 3 X 1.75: ");
		plate3_1_75 = in.nextInt();

		System.out.println("Plates 3 X 1.5: ");
		plate3_1_5 = in.nextInt();

		System.out.println("Plates 3 X 1.25: ");
		plate3_1_25 = in.nextInt();

		System.out.println("Plates 3 X 1: ");
		plate3_1 = in.nextInt();
		
		System.out.println("Tin Plates");
		tinPlate = in.nextInt();

		System.out.println("Enter number of ballis: ");
		System.out.println("Balli 14ft");
		balli_14 = in.nextInt();

		System.out.println("Balli 12ft");
		balli_12 = in.nextInt();
		
		System.out.println("Balli 10ft");
		balli_10 = in.nextInt();
		
		System.out.println("Balli 19/8ft");
		balli_9_8 = in.nextInt();
		
		System.out.println("Chabi Badi");
		chabiBadi = in.nextInt();
		
		System.out.println("Chabi Chhoti");
		chabiChhoti = in.nextInt();
		
		System.out.println("Patiya");
		patiya = in.nextInt();
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Main main = new Main();
		
		  int n; 
		  System.out.println("Issuing..."); 
		  n = in.nextInt(); 
		  main.issued();

		  
//		  System.out.println("Returning..."); 
//		  n = in.nextInt(); 
//		  main.returned(1);
		  
		  
//		 System.out.println("NewAdding...");
//		  n = in.nextInt();
//		  main.updateMaterial("added");
		
		
	}

}
