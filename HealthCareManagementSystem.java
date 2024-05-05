package test;
import java.sql.*;
import java.util.Scanner;

public class HealthCareManagementSystem {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/JavaDB"; //url
    static final String USER = "root";  //  MySQL username
    static final String PASS = "BB11@root"; //  MySQL password

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            int choice;
            Scanner scanner = new Scanner(System.in);
            do {
                System.out.println("\n1. INSERT\n2. DELETE\n3. DROP\n4. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        performInsertOperation(conn);
                        break;
                    case 2:
                        performDeleteOperation(conn);
                        break;
                    case 3:
                    	performDropOperation(conn);
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
                
            } while (choice != 3);

            stmt.close();
            conn.close();
            scanner.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    private static void performInsertOperation(Connection conn) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the table to perform INSERT operation:");
        System.out.println("1. Patient\n2. Healthinsurance\n3. Patient_Healthinsurance\n4. HospitalDepartment\n5. Doctor");
        System.out.print("Enter your choice: ");
        int tableChoice = scanner.nextInt();

        switch (tableChoice) {
            case 1:
            {
            	
                System.out.println("INSERT operation for Patient table selected.");
                System.out.print("Enter patient_id: ");
                int patientId = scanner.nextInt();
                System.out.print("Enter first name: ");
                String firstName = scanner.next();
                System.out.print("Enter last name: ");
                String lastName = scanner.next();
                System.out.print("Enter date of birth (yyyy-mm-dd): ");
                String dob = scanner.next();
                System.out.print("Enter Address1: ");
                String address1 = scanner.next();
                System.out.print("Enter Address2: ");
                String address2 = scanner.next();
                System.out.print("Enter City: ");
                String city = scanner.next();
                System.out.print("Enter Zipcode: ");
                String zipcode = scanner.next();
                System.out.print("Enter Country: ");
                String country = scanner.next();
                System.out.print("Enter Mobile: ");
                String mobile = scanner.next();
                System.out.print("Enter Email: ");
                String email = scanner.next();
                System.out.print("Enter EmergencyContactPerson_ID: ");
                int emergencyContactPersonId = scanner.nextInt();
                String sql = "INSERT INTO Patient (patient_id, first_name, last_name, dob, Address1, Address2, City, Zipcode, Country, Mobile, Email, EmergencyContactPerson_ID) " +
                             "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, patientId);
                preparedStatement.setString(2, firstName);
                preparedStatement.setString(3, lastName);
                preparedStatement.setString(4, dob);
                preparedStatement.setString(5, address1);
                preparedStatement.setString(6, address2);
                preparedStatement.setString(7, city);
                preparedStatement.setString(8, zipcode);
                preparedStatement.setString(9, country);
                preparedStatement.setString(10, mobile);
                preparedStatement.setString(11, email);
                preparedStatement.setInt(12, emergencyContactPersonId);
                
                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new row has been inserted successfully.");
                }

                preparedStatement.close();
            }

                break;
                
            case 2:
            {
                System.out.println("INSERT operation for Healthinsurance table selected.");
                System.out.print("Enter HealthInsurance_ID: ");
                int HealthInsurance_ID = scanner.nextInt();
                System.out.print("Enter Address 1: ");
                String Address1 = scanner.next();
                System.out.print("Enter Address 2: ");
                String Address2 = scanner.next();
                System.out.print("Enter city: ");
                String city = scanner.next();
                System.out.print("Enter Zipcode: ");
                String zip = scanner.next();
                System.out.print("Enter country: ");
                String Country = scanner.next();
                System.out.print("Enter mobile number: ");
                String Mobile = scanner.next();
                System.out.print("Enter email: ");
                String Email = scanner.next();

                String sql = "INSERT INTO Healthinsurance (HealthInsurance_ID, Address1, Address2, City, Zipcode, Country, Mobile, Email)"
                		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, HealthInsurance_ID);
                preparedStatement.setString(2, Address1);
                preparedStatement.setString(3, Address2);
                preparedStatement.setString(4, city);
                preparedStatement.setString(5, zip);
                preparedStatement.setString(6, Country);
                preparedStatement.setString(7, Mobile);
                preparedStatement.setString(8, Email);
                
                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new row has been inserted successfully.");
                }

                preparedStatement.close();
            }
                
                break;
            case 3:
            {
            	System.out.println("INSERT operation for Patient_Healthinsurance table selected.");
            	System.out.print("Enter Patient_Patient_ID: ");
                int patient_patient_ID = scanner.nextInt();
                System.out.print("Enter HealthInsurance_H: ");
                String HealthInsurance_H = scanner.next();

                String sql = "INSERT INTO Patient_Healthinsurance (patient_patient_ID, HealthInsurance_H)"+ "VALUES (?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, patient_patient_ID);
                preparedStatement.setString(2, HealthInsurance_H);
                
                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new row has been inserted successfully.");
                }

                preparedStatement.close();
            }
                break;
            case 4:
            {
                System.out.println("INSERT operation for HospitalDepartment table selected.");
                System.out.print("Enter Department_ID: ");
                int Department_ID = scanner.nextInt();
                System.out.print("Enter Name: ");
                String Name = scanner.next();
                System.out.print("Enter Address: ");
                String Address = scanner.next();
                System.out.print("Enter Phone: ");
                String Phone = scanner.next();
                System.out.print("Enter Email : ");
                String E_mail = scanner.next();
                System.out.print("Enter Note : ");
                String Note = scanner.next();
                String sql = "INSERT INTO HospitalDepartment (Department_ID, Name, Address, Phone, Email, Note)" + "VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, Department_ID);
                preparedStatement.setString(2, Name);
                preparedStatement.setString(3, Address);
                preparedStatement.setString(4, Phone);
                preparedStatement.setString(5, E_mail);
                preparedStatement.setString(6, Note);
                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new row has been inserted successfully.");
                }

                preparedStatement.close();
            }
                
                break;
            case 5:
            {
            	System.out.println("INSERT operation for Doctor table selected.");
            	System.out.print("Enter Doctor_ID : ");
                int Doctor_ID = scanner.nextInt();
                System.out.print("Enter Department_ID : ");
                String Department_ID = scanner.next();
                System.out.print("Enter Phone : ");
                String Phone = scanner.next();
                System.out.print("Enter Mobile : ");
                String Mobile = scanner.next();
                System.out.print("Enter Email : ");
                String Email = scanner.next();
                System.out.print("Enter Visit_Price : ");
                String Visit_Price = scanner.next();
                System.out.print("Enter Followup_Price : ");
                String Followup_Price = scanner.next();
                System.out.print("Enter Inpateint_Visit_Price : ");
                String Inpateint_Visit_Price = scanner.next();
                System.out.print("Enter Note : ");
                String Note = scanner.next();
                String sql = "INSERT INTO Doctor (Doctor_ID, Department_ID, Phone, Mobile, Email, Visit_Price, Followup_Price, Inpateint_Visit_Price, Note)" + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, Doctor_ID);
                preparedStatement.setString(2, Department_ID);
                preparedStatement.setString(3, Phone);
                preparedStatement.setString(4, Mobile);
                preparedStatement.setString(5, Email);
                preparedStatement.setString(6, Visit_Price);
                preparedStatement.setString(7, Followup_Price);
                preparedStatement.setString(8, Inpateint_Visit_Price);
                preparedStatement.setString(9, Note);
           
           int rowsInserted = preparedStatement.executeUpdate();
           if (rowsInserted > 0) {
               System.out.println("A new row has been inserted successfully.");
           }

           preparedStatement.close();
       }
                
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        scanner.close();
    }

    private static void performDeleteOperation(Connection conn) {
        System.out.println("DELETE operation selected.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the table to perform DELETE operation:");
        System.out.println("1. Patient\n2. Healthinsurance\n3. Patient_Healthinsurance\n4. HospitalDepartment\n5. Doctor\n");
        System.out.print("Enter your choice: ");
        int ch = scanner.nextInt();
        switch(ch)
        {
        	case 1: 
        	{
                System.out.println("Choose the column to perform DELETE operation on Patient:");
                System.out.println("1. patient_id\n2. first_name\n3. last_name\n4. dob\n5. Address1\n6. Address2\n7. City\n8. Zipcode\n9. Country\n10. Mobile\n11. Email\n12. EmergencyContactPerson_ID\n");
                System.out.print("Enter your choice: ");
                int ch2 = scanner.nextInt();
                switch(ch2)
                {
                	case 1 :
                	{
                		try {
                	        	System.out.println("DELETE operation selected for Patient table.");
                	        	System.out.print("Enter patient_id to delete: ");
                	        	int patientId = scanner.nextInt();
                	        	String sql = "DELETE FROM Patient WHERE patient_id = ?";
                	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
                	        	preparedStatement.setInt(1, patientId);
                	        	int rowsDeleted = preparedStatement.executeUpdate();
                	        	if (rowsDeleted > 0) 
                	        	{
                	        		System.out.println("The record with patient_id " + patientId + " has been deleted successfully.");
                	        	} 
                	        	else 
                	        	{
                	        		System.out.println("No record found with patient_id " + patientId);
                	        	}
                	        	preparedStatement.close();
                	    	} 
                		catch (SQLException e) 
                		{
                	        e.printStackTrace();
                	    }
                        break;
                	}
                	case 2 : 
                	{
                		try {
            	        	System.out.println("DELETE operation selected for Patient table.");
            	        	System.out.print("Enter first name to delete: ");
            	        	String f_name = scanner.next();
            	        	String sql = "DELETE FROM Patient WHERE first_name = ?";
            	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            	        	preparedStatement.setString(2, f_name);
            	        	int rowsDeleted = preparedStatement.executeUpdate();
            	        	if (rowsDeleted > 0) 
            	        	{
            	        		System.out.println("The record with first name " + f_name + " has been deleted successfully.");
            	        	} 
            	        	else 
            	        	{
            	        		System.out.println("No record found with first name " + f_name);
            	        	}
            	        	preparedStatement.close();
            	    	} 
            		catch (SQLException e) 
            		{
            	        e.printStackTrace();
            	    }
                    break;
                	}
                	case 3 :
                	{
                		try {
            	        	System.out.println("DELETE operation selected for Patient table.");
            	        	System.out.print("Enter last name to delete: ");
            	        	String l_name = scanner.next();
            	        	String sql = "DELETE FROM Patient WHERE last_name = ?";
            	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            	        	preparedStatement.setString(3, l_name);
            	        	int rowsDeleted = preparedStatement.executeUpdate();
            	        	if (rowsDeleted > 0) 
            	        	{
            	        		System.out.println("The record with last name " + l_name + " has been deleted successfully.");
            	        	} 
            	        	else 
            	        	{
            	        		System.out.println("No record found with last name " + l_name);
            	        	}
            	        	preparedStatement.close();
            	    	} 
            		catch (SQLException e) 
            		{
            	        e.printStackTrace();
            	    }
                    break;
                	}
                	case 4 :
                	{
                		try {
            	        	System.out.println("DELETE operation selected for Patient table.");
            	        	System.out.print("Enter DOB to delete: ");
            	        	String dob = scanner.next();
            	        	String sql = "DELETE FROM Patient WHERE dob = ?";
            	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            	        	preparedStatement.setString(4, dob);
            	        	int rowsDeleted = preparedStatement.executeUpdate();
            	        	if (rowsDeleted > 0) 
            	        	{
            	        		System.out.println("The record with DOB " + dob + " has been deleted successfully.");
            	        	} 
            	        	else 
            	        	{
            	        		System.out.println("No record found with DOB " + dob);
            	        	}
            	        	preparedStatement.close();
            	    	} 
            		catch (SQLException e) 
            		{
            	        e.printStackTrace();
            	    }
                    break;
                	}
                	case 5 :
                	{
                		try {
            	        	System.out.println("DELETE operation selected for Patient table.");
            	        	System.out.print("Enter Adress1 to delete: ");
            	        	String A1 = scanner.next();
            	        	String sql = "DELETE FROM Patient WHERE Address1 = ?";
            	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            	        	preparedStatement.setString(5, A1);
            	        	int rowsDeleted = preparedStatement.executeUpdate();
            	        	if (rowsDeleted > 0) 
            	        	{
            	        		System.out.println("The record with Address1 " + A1 + " has been deleted successfully.");
            	        	} 
            	        	else 
            	        	{
            	        		System.out.println("No record found with Address1 " + A1);
            	        	}
            	        	preparedStatement.close();
            	    	} 
            		catch (SQLException e) 
            		{
            	        e.printStackTrace();
            	    }
                    break;
                	}
                	case 6 :
                	{
                		try {
            	        	System.out.println("DELETE operation selected for Patient table.");
            	        	System.out.print("Enter Address2 to delete: ");
            	        	String A2 = scanner.next();
            	        	String sql = "DELETE FROM Patient WHERE Address2 = ?";
            	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            	        	preparedStatement.setString(6, A2);
            	        	int rowsDeleted = preparedStatement.executeUpdate();
            	        	if (rowsDeleted > 0) 
            	        	{
            	        		System.out.println("The record with Address2 " + A2 + " has been deleted successfully.");
            	        	} 
            	        	else 
            	        	{
            	        		System.out.println("No record found with Address2 " + A2);
            	        	}
            	        	preparedStatement.close();
            	    	} 
            		catch (SQLException e) 
            		{
            	        e.printStackTrace();
            	    }
                    break;
                	}
                	case 7 :
                	{
                		try {
            	        	System.out.println("DELETE operation selected for Patient table.");
            	        	System.out.print("Enter City to delete: ");
            	        	String city = scanner.next();
            	        	String sql = "DELETE FROM Patient WHERE City = ?";
            	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            	        	preparedStatement.setString(7, city);
            	        	int rowsDeleted = preparedStatement.executeUpdate();
            	        	if (rowsDeleted > 0) 
            	        	{
            	        		System.out.println("The record with City " + city + " has been deleted successfully.");
            	        	} 
            	        	else 
            	        	{
            	        		System.out.println("No record found with City " + city);
            	        	}
            	        	preparedStatement.close();
            	    	} 
            		catch (SQLException e) 
            		{
            	        e.printStackTrace();
            	    }
                    break;
                	}
                	case 8 :
                	{
                		try {
            	        	System.out.println("DELETE operation selected for Patient table.");
            	        	System.out.print("Enter Zipcode to delete: ");
            	        	String zip = scanner.next();
            	        	String sql = "DELETE FROM Patient WHERE Zipcode = ?";
            	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            	        	preparedStatement.setString(8, zip);
            	        	int rowsDeleted = preparedStatement.executeUpdate();
            	        	if (rowsDeleted > 0) 
            	        	{
            	        		System.out.println("The record with Zipcode " + zip + " has been deleted successfully.");
            	        	} 
            	        	else 
            	        	{
            	        		System.out.println("No record found with Zipcode " + zip);
            	        	}
            	        	preparedStatement.close();
            	    	} 
            		catch (SQLException e) 
            		{
            	        e.printStackTrace();
            	    }
                    break;
                	}
                	case 9 : 
                	{
                		try {
            	        	System.out.println("DELETE operation selected for Patient table.");
            	        	System.out.print("Enter Country to delete: ");
            	        	String country = scanner.next();
            	        	String sql = "DELETE FROM Patient WHERE Country = ?";
            	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            	        	preparedStatement.setString(9, country);
            	        	int rowsDeleted = preparedStatement.executeUpdate();
            	        	if (rowsDeleted > 0) 
            	        	{
            	        		System.out.println("The record with Country " + country + " has been deleted successfully.");
            	        	} 
            	        	else 
            	        	{
            	        		System.out.println("No record found with Country " + country);
            	        	}
            	        	preparedStatement.close();
            	    	} 
            		catch (SQLException e) 
            		{
            	        e.printStackTrace();
            	    }
                    break;	
                	}
                	case 10 :
                	{
                		try {
            	        	System.out.println("DELETE operation selected for Patient table.");
            	        	System.out.print("Enter Mobile to delete: ");
            	        	String mob = scanner.next();
            	        	String sql = "DELETE FROM Patient WHERE Mobile = ?";
            	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            	        	preparedStatement.setString(10, mob);
            	        	int rowsDeleted = preparedStatement.executeUpdate();
            	        	if (rowsDeleted > 0) 
            	        	{
            	        		System.out.println("The record with Mobile " + mob + " has been deleted successfully.");
            	        	} 
            	        	else 
            	        	{
            	        		System.out.println("No record found with Mobile " + mob);
            	        	}
            	        	preparedStatement.close();
            	    	} 
            		catch (SQLException e) 
            		{
            	        e.printStackTrace();
            	    }
                    break;
                	}
                	case 11 : 
                	{
                		try {
            	        	System.out.println("DELETE operation selected for Patient table.");
            	        	System.out.print("Enter Email to delete: ");
            	        	String em = scanner.next();
            	        	String sql = "DELETE FROM Patient WHERE Email = ?";
            	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            	        	preparedStatement.setString(11, em);
            	        	int rowsDeleted = preparedStatement.executeUpdate();
            	        	if (rowsDeleted > 0) 
            	        	{
            	        		System.out.println("The record with Email " + em + " has been deleted successfully.");
            	        	} 
            	        	else 
            	        	{
            	        		System.out.println("No record found with Email " + em);
            	        	}
            	        	preparedStatement.close();
            	    	} 
            		catch (SQLException e) 
            		{
            	        e.printStackTrace();
            	    }
                    break;
                	}
                	case 12 : 
                	{
                		try {
            	        	System.out.println("DELETE operation selected for Patient table.");
            	        	System.out.print("Enter Emergency Contact to delete: ");
            	        	int emer = scanner.nextInt();
            	        	String sql = "DELETE FROM Patient WHERE EmergencyContactPerson_ID = ?";
            	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            	        	preparedStatement.setInt(12, emer);
            	        	int rowsDeleted = preparedStatement.executeUpdate();
            	        	if (rowsDeleted > 0) 
            	        	{
            	        		System.out.println("The record with EmergencyContactPerson_ID " + emer + " has been deleted successfully.");
            	        	} 
            	        	else 
            	        	{
            	        		System.out.println("No record found with EmergencyContactPerson_ID " + emer);
            	        	}
            	        	preparedStatement.close();
            	    	} 
            		catch (SQLException e) 
            		{
            	        e.printStackTrace();
            	    }
                    break;
                	}
                	default : 
                	{
                		System.out.println("Invalid choice. Please try again.");
                	}
                }
                break;
        	}
        	case 2 :
        	{
        		System.out.println("Choose the column to perform DELETE operation on HealthInsurance :");
                System.out.println("1. HealthInsurance_ID\n2. Address1\n3. Address2\n4. City\n5. Zipcode\n6. Country\n7. Mobile\n8. Email\n");
                System.out.print("Enter your choice: ");
                int ch3 = scanner.nextInt();
                switch(ch3)
                {
                	case 1 :
                	{
                		try {
            	        	System.out.println("DELETE operation selected for HealthInsurance table.");
            	        	System.out.print("Enter HealthInsurance_ID to delete: ");
            	        	int h_id = scanner.nextInt();
            	        	String sql = "DELETE FROM healthinsurance WHERE HealthInsurance_ID = ?";
            	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            	        	preparedStatement.setInt(1, h_id);
            	        	int rowsDeleted = preparedStatement.executeUpdate();
            	        	if (rowsDeleted > 0) 
            	        	{
            	        		System.out.println("The record with HealthInsurance_ID " + h_id + " has been deleted successfully.");
            	        	} 
            	        	else 
            	        	{
            	        		System.out.println("No record found with HealthInsurance_ID " + h_id);
            	        	}
            	        	preparedStatement.close();
            	    	} 
            		catch (SQLException e) 
            		{
            	        e.printStackTrace();
            	    }
                    break;
                	}
                	case 2 :
                	{
                		try {
            	        	System.out.println("DELETE operation selected for healthinsurance table.");
            	        	System.out.print("Enter Address1 to delete: ");
            	        	String A1 = scanner.next();
            	        	String sql = "DELETE FROM healthinsurance WHERE Address1 = ?";
            	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            	        	preparedStatement.setString(2, A1);
            	        	int rowsDeleted = preparedStatement.executeUpdate();
            	        	if (rowsDeleted > 0) 
            	        	{
            	        		System.out.println("The record with Address1 " + A1 + " has been deleted successfully.");
            	        	} 
            	        	else 
            	        	{
            	        		System.out.println("No record found with Address1 " + A1);
            	        	}
            	        	preparedStatement.close();
            	    	} 
            		catch (SQLException e) 
            		{
            	        e.printStackTrace();
            	    }
                    break;
                	}
                	case 3 :
                	{
                		try {
            	        	System.out.println("DELETE operation selected for healthinsurance table.");
            	        	System.out.print("Enter Address2 to delete: ");
            	        	String A2 = scanner.next();
            	        	String sql = "DELETE FROM healthinsurance WHERE Address2 = ?";
            	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            	        	preparedStatement.setString(3, A2);
            	        	int rowsDeleted = preparedStatement.executeUpdate();
            	        	if (rowsDeleted > 0) 
            	        	{
            	        		System.out.println("The record with Address2 " + A2 + " has been deleted successfully.");
            	        	} 
            	        	else 
            	        	{
            	        		System.out.println("No record found with Address2 " + A2);
            	        	}
            	        	preparedStatement.close();
            	    	} 
            		catch (SQLException e) 
            		{
            	        e.printStackTrace();
            	    }
                    break;
                	}
                	case 4 :
                	{
                		try {
            	        	System.out.println("DELETE operation selected for healthinsurance table.");
            	        	System.out.print("Enter City to delete: ");
            	        	String city = scanner.next();
            	        	String sql = "DELETE FROM healthinsurance WHERE City = ?";
            	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            	        	preparedStatement.setString(4, city);
            	        	int rowsDeleted = preparedStatement.executeUpdate();
            	        	if (rowsDeleted > 0) 
            	        	{
            	        		System.out.println("The record with City " + city + " has been deleted successfully.");
            	        	} 
            	        	else 
            	        	{
            	        		System.out.println("No record found with City " + city);
            	        	}
            	        	preparedStatement.close();
            	    	} 
            		catch (SQLException e) 
            		{
            	        e.printStackTrace();
            	    }
                    break;
                	}
                	case 5 :
                	{
                		try {
            	        	System.out.println("DELETE operation selected for healthinsurance table.");
            	        	System.out.print("Enter Zipcode to delete: ");
            	        	String zip = scanner.next();
            	        	String sql = "DELETE FROM healthinsurance WHERE Zipcode = ?";
            	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            	        	preparedStatement.setString(5, zip);
            	        	int rowsDeleted = preparedStatement.executeUpdate();
            	        	if (rowsDeleted > 0) 
            	        	{
            	        		System.out.println("The record with Zipcode " + zip + " has been deleted successfully.");
            	        	} 
            	        	else 
            	        	{
            	        		System.out.println("No record found with Zipcode " + zip);
            	        	}
            	        	preparedStatement.close();
            	    	} 
            		catch (SQLException e) 
            		{
            	        e.printStackTrace();
            	    }
                    break;
                	}
                	case 6 :
                	{
                		try {
            	        	System.out.println("DELETE operation selected for healthinsurance table.");
            	        	System.out.print("Enter Country to delete: ");
            	        	String country = scanner.next();
            	        	String sql = "DELETE FROM healthinsurance WHERE Country = ?";
            	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            	        	preparedStatement.setString(6, country);
            	        	int rowsDeleted = preparedStatement.executeUpdate();
            	        	if (rowsDeleted > 0) 
            	        	{
            	        		System.out.println("The record with Country " + country + " has been deleted successfully.");
            	        	} 
            	        	else 
            	        	{
            	        		System.out.println("No record found with Country " + country);
            	        	}
            	        	preparedStatement.close();
            	    	} 
            		catch (SQLException e) 
            		{
            	        e.printStackTrace();
            	    }
                    break;	
                	}
                	case 7 :
                	{
                		try {
            	        	System.out.println("DELETE operation selected for healthinsurance table.");
            	        	System.out.print("Enter Mobile to delete: ");
            	        	String mob = scanner.next();
            	        	String sql = "DELETE FROM healthinsurance WHERE Mobile = ?";
            	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            	        	preparedStatement.setString(7, mob);
            	        	int rowsDeleted = preparedStatement.executeUpdate();
            	        	if (rowsDeleted > 0) 
            	        	{
            	        		System.out.println("The record with Mobile " + mob + " has been deleted successfully.");
            	        	} 
            	        	else 
            	        	{
            	        		System.out.println("No record found with Mobile " + mob);
            	        	}
            	        	preparedStatement.close();
            	    	} 
            		catch (SQLException e) 
            		{
            	        e.printStackTrace();
            	    }
                    break;
                	}
                	case 8 :
                	{
                		try {
            	        	System.out.println("DELETE operation selected for healthinsurance table.");
            	        	System.out.print("Enter Email to delete: ");
            	        	String em = scanner.next();
            	        	String sql = "DELETE FROM healthinsurance WHERE Email = ?";
            	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            	        	preparedStatement.setString(8, em);
            	        	int rowsDeleted = preparedStatement.executeUpdate();
            	        	if (rowsDeleted > 0) 
            	        	{
            	        		System.out.println("The record with Email " + em + " has been deleted successfully.");
            	        	} 
            	        	else 
            	        	{
            	        		System.out.println("No record found with Email " + em);
            	        	}
            	        	preparedStatement.close();
            	    	} 
            		catch (SQLException e) 
            		{
            	        e.printStackTrace();
            	    }
                    break;
                	}
                	default : 
                	{
                		System.out.println("Invalid choice. Please try again.");
                	}
                }
                break;
        	}
        	case 3 :
        	{
        		System.out.println("Choose the column to perform DELETE operation on patient_healthinsurance :");
                System.out.println("1. patient_patient_ID\n2. HealthInsurance_H\n");
                System.out.print("Enter your choice: ");
                int ch4 = scanner.nextInt();
                switch(ch4)
                {
                	case 1 :
                	{
                		try {
                				System.out.println("DELETE operation selected for patient_healthinsurance table.");
                				System.out.print("Enter patient_patient_ID to delete: ");
                				int pp_id = scanner.nextInt();
                				String sql = "DELETE FROM patient_healthinsurance WHERE patient_patient_ID = ?";
                				PreparedStatement preparedStatement = conn.prepareStatement(sql);
                				preparedStatement.setInt(1, pp_id);
                				int rowsDeleted = preparedStatement.executeUpdate();
                				if (rowsDeleted > 0) 
                				{
                					System.out.println("The record with patient_patient_ID " + pp_id + " has been deleted successfully.");
                				} 
                				else 
                				{
                					System.out.println("No record found with patient_patient_ID " + pp_id);
                				}
                				preparedStatement.close();
                			} 
                		catch (SQLException e) 
                		{		
                			e.printStackTrace();
                		}
                		break;
                	}
                case 2 :
                {
                	try 
                	{
        	        	System.out.println("DELETE operation selected for patient_healthinsurance table.");
        	        	System.out.print("Enter HealthInsurance_H to delete: ");
        	        	int h_h = scanner.nextInt();
        	        	String sql = "DELETE FROM patient_healthinsurance WHERE HealthInsurance_H = ?";
        	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
        	        	preparedStatement.setInt(2, h_h);
        	        	int rowsDeleted = preparedStatement.executeUpdate();
        	        	if (rowsDeleted > 0) 
        	        	{
        	        		System.out.println("The record with HealthInsurance_H " + h_h + " has been deleted successfully.");
        	        	} 
        	        	else 
        	        	{
        	        		System.out.println("No record found with HealthInsurance_H " + h_h);
        	        	}
        	        	preparedStatement.close();
        	    	} 
                	catch (SQLException e) 
                	{
                		e.printStackTrace();
                	}
                	break;
                }
                default : 
            	{
            		System.out.println("Invalid choice. Please try again.");
            	}
               }
                break;
        	}
        	case 4 : 
        	{
        		System.out.println("Choose the column to perform DELETE operation on hospitaldepartment :");
                System.out.println("1. Department_ID\n2. Name\n3. Address\n4. Phone\n5. Email\n6. Note\n");
                System.out.print("Enter your choice: ");
                int ch5 = scanner.nextInt();
                switch(ch5)
                {
                	case 1 : 
                	{
                		try 
                		{
                			System.out.println("DELETE operation selected for hospitaldepartment table.");
                			System.out.print("Enter Department_ID to delete: ");
                			int d_id = scanner.nextInt();
                			String sql = "DELETE FROM hospitaldepartment WHERE Department_ID = ?";
                			PreparedStatement preparedStatement = conn.prepareStatement(sql);
                			preparedStatement.setInt(1, d_id);
                			int rowsDeleted = preparedStatement.executeUpdate();
                			if (rowsDeleted > 0) 
                			{
                				System.out.println("The record with Department_ID " + d_id + " has been deleted successfully.");
                			} 
                			else 
                			{
                				System.out.println("No record found with Department_ID " + d_id);
                			}
                			preparedStatement.close();
                		} 
                		catch (SQLException e) 
                		{		
                			e.printStackTrace();
                		}
                		break;
                	}
                	case 2 :
                	{
                		try 
                		{
            	        	System.out.println("DELETE operation selected for hospitaldepartment table.");
            	        	System.out.print("Enter name to delete: ");
            	        	String name = scanner.next();
            	        	String sql = "DELETE FROM hospitaldepartment WHERE Name = ?";
            	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            	        	preparedStatement.setString(2, name);
            	        	int rowsDeleted = preparedStatement.executeUpdate();
            	        	if (rowsDeleted > 0) 
            	        	{
            	        		System.out.println("The record with Name " + name + " has been deleted successfully.");
            	        	} 
            	        	else 
            	        	{
            	        		System.out.println("No record found with Name " + name);
            	        	}
            	        	preparedStatement.close();
            	    	} 
                		catch (SQLException e) 
                		{
                			e.printStackTrace();
                		}
                		break;
                	}
                	case 3 :
                	{
                		try 
                		{
            	        	System.out.println("DELETE operation selected for hospitaldepartment table.");
            	        	System.out.print("Enter Address to delete: ");
            	        	String A = scanner.next();
            	        	String sql = "DELETE FROM hospitaldepartment WHERE Address = ?";
            	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            	        	preparedStatement.setString(3, A);
            	        	int rowsDeleted = preparedStatement.executeUpdate();
            	        	if (rowsDeleted > 0) 
            	        	{
            	        		System.out.println("The record with Address " + A + " has been deleted successfully.");
            	        	} 
            	        	else 
            	        	{
            	        		System.out.println("No record found with Address " + A);
            	        	}
            	        	preparedStatement.close();
            	    	} 
                		catch (SQLException e) 
                		{
                			e.printStackTrace();
                		}
                		break;
                	}
                	case 4 :
                	{
                		try 
                		{
            	        	System.out.println("DELETE operation selected for hospitaldepartment table.");
            	        	System.out.print("Enter Phone to delete: ");
            	        	String ph = scanner.next();
            	        	String sql = "DELETE FROM hospitaldepartment WHERE Phone = ?";
            	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            	        	preparedStatement.setString(4, ph);
            	        	int rowsDeleted = preparedStatement.executeUpdate();
            	        	if (rowsDeleted > 0) 
            	        	{
            	        		System.out.println("The record with Phone " + ph + " has been deleted successfully.");
            	        	} 
            	        	else 
            	        	{
            	        		System.out.println("No record found with Phone " + ph);
            	        	}
            	        	preparedStatement.close();
            	    	} 
                		catch (SQLException e) 
                		{
                			e.printStackTrace();
                		}
                		break;
                	}
                	case 5 :
                	{
                		try 
                		{
            	        	System.out.println("DELETE operation selected for hospitaldepartment table.");
            	        	System.out.print("Enter Email to delete: ");
            	        	String em = scanner.next();
            	        	String sql = "DELETE FROM hospitaldepartment WHERE Email = ?";
            	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            	        	preparedStatement.setString(5, em);
            	        	int rowsDeleted = preparedStatement.executeUpdate();
            	        	if (rowsDeleted > 0) 
            	        	{
            	        		System.out.println("The record with Email " + em + " has been deleted successfully.");
            	        	} 
            	        	else 
            	        	{
            	        		System.out.println("No record found with Email " + em);
            	        	}
            	        	preparedStatement.close();
            	    	} 
                		catch (SQLException e) 
                		{
                			e.printStackTrace();
                		}
                		break;
                	}
                	case 6 :
                	{
                		try 
                		{
            	        	System.out.println("DELETE operation selected for hospitaldepartment table.");
            	        	System.out.print("Enter Note to delete: ");
            	        	String note = scanner.next();
            	        	String sql = "DELETE FROM hospitaldepartment WHERE Note = ?";
            	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            	        	preparedStatement.setString(6, note);
            	        	int rowsDeleted = preparedStatement.executeUpdate();
            	        	if (rowsDeleted > 0) 
            	        	{
            	        		System.out.println("The record with Note " + note + " has been deleted successfully.");
            	        	} 
            	        	else 
            	        	{
            	        		System.out.println("No record found with Note " + note);
            	        	}
            	        	preparedStatement.close();
            	    	} 
                		catch (SQLException e) 
                		{
                			e.printStackTrace();
                		}
                		break;
                	}
                	default : 
                	{
                		System.out.println("Invalid choice. Please try again.");
                	}
                	
                }
                break;
        	}
        	case 5 :
        	{
        		System.out.println("Choose the column to perform DELETE operation on Doctor :");
                System.out.println("1. Doctor_ID\n2. Department_ID\n3. Phone\n4. Mobile\n5. Email\n6. Visit_Price\n7. Followup_Price\n8. Inpateint_Visit_Price\n9. Note\n");
                System.out.print("Enter your choice: ");
                int ch6 = scanner.nextInt();
                switch(ch6)
                {
                	case 1 :
                	{
                		try {
                	        	System.out.println("DELETE operation selected for doctor table.");
                	        	System.out.print("Enter patient_id to Doctor_ID : ");
                	        	int Doctor_ID = scanner.nextInt();
                	        	String sql = "DELETE FROM doctor WHERE Doctor_ID = ?";
                	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
                	        	preparedStatement.setInt(1, Doctor_ID);
                	        	int rowsDeleted = preparedStatement.executeUpdate();
                	        	if (rowsDeleted > 0) 
                	        	{
                	        		System.out.println("The record with Doctor_ID " + Doctor_ID + " has been deleted successfully.");
                	        	} 
                	        	else 
                	        	{
                	        		System.out.println("No record found with Doctor_ID " + Doctor_ID);
                	        	}
                	        	preparedStatement.close();
                	    	} 
                		catch (SQLException e) 
                		{
                	        e.printStackTrace();
                	    }
                        break;
                	}
                	case 2 : 
                	{
                		try 
                		{
            	        	System.out.println("DELETE operation selected for doctor table.");
            	        	System.out.print("Enter patient_id to Department_ID : ");
            	        	int Department_ID = scanner.nextInt();
            	        	String sql = "DELETE FROM doctor WHERE Department_ID = ?";
            	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            	        	preparedStatement.setInt(2, Department_ID);
            	        	int rowsDeleted = preparedStatement.executeUpdate();
            	        	if (rowsDeleted > 0) 
            	        	{
            	        		System.out.println("The record with Department_ID " + Department_ID + " has been deleted successfully.");
            	        	} 
            	        	else 
            	        	{
            	        		System.out.println("No record found with Department_ID " + Department_ID);
            	        	}
            	        	preparedStatement.close();
            	    	} 
                		catch (SQLException e) 
                		{
                			e.printStackTrace();
                		}
                		break;
                	}
                	case 3 :
                	{
                		try 
                		{
            	        	System.out.println("DELETE operation selected for doctor table.");
            	        	System.out.print("Enter Phone to delete: ");
            	        	String Phone = scanner.next();
            	        	String sql = "DELETE FROM doctor WHERE Phone = ?";
            	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            	        	preparedStatement.setString(3, Phone);
            	        	int rowsDeleted = preparedStatement.executeUpdate();
            	        	if (rowsDeleted > 0) 
            	        	{
            	        		System.out.println("The record with Phone " + Phone + " has been deleted successfully.");
            	        	} 
            	        	else 
            	        	{
            	        		System.out.println("No record found with Phone " + Phone);
            	        	}
            	        	preparedStatement.close();
            	    	} 
                		catch (SQLException e) 
                		{
                			e.printStackTrace();
                		}
                		break;
                	}
                	case 4 :
                	{
                		try 
                		{
            	        	System.out.println("DELETE operation selected for doctor table.");
            	        	System.out.print("Enter Mobile to delete: ");
            	        	String Mobile = scanner.next();
            	        	String sql = "DELETE FROM doctor WHERE Mobile = ?";
            	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            	        	preparedStatement.setString(4, Mobile);
            	        	int rowsDeleted = preparedStatement.executeUpdate();
            	        	if (rowsDeleted > 0) 
            	        	{
            	        		System.out.println("The record with Mobile " + Mobile + " has been deleted successfully.");
            	        	} 
            	        	else 
            	        	{
            	        		System.out.println("No record found with Mobile " + Mobile);
            	        	}
            	        	preparedStatement.close();
            	    	} 
                		catch (SQLException e) 
                		{
                			e.printStackTrace();
                		}
                		break;
                	}
                	case 5 :
                	{
                		try 
                		{
            	        	System.out.println("DELETE operation selected for doctor table.");
            	        	System.out.print("Enter Email to delete: ");
            	        	String Email = scanner.next();
            	        	String sql = "DELETE FROM doctor WHERE Email = ?";
            	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            	        	preparedStatement.setString(5, Email);
            	        	int rowsDeleted = preparedStatement.executeUpdate();
            	        	if (rowsDeleted > 0) 
            	        	{
            	        		System.out.println("The record with Email " + Email + " has been deleted successfully.");
            	        	} 
            	        	else 
            	        	{
            	        		System.out.println("No record found with Email " + Email);
            	        	}
            	        	preparedStatement.close();
            	    	} 
                		catch (SQLException e) 
                		{
                			e.printStackTrace();
                		}
                		break;
                	}
                	case 6 :
                	{
                		try 
                		{
            	        	System.out.println("DELETE operation selected for doctor table.");
            	        	System.out.print("Enter Visit_Price to delete: ");
            	        	String Visit_Price = scanner.next();
            	        	String sql = "DELETE FROM doctor WHERE Visit_Price = ?";
            	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            	        	preparedStatement.setString(6, Visit_Price);
            	        	int rowsDeleted = preparedStatement.executeUpdate();
            	        	if (rowsDeleted > 0) 
            	        	{
            	        		System.out.println("The record with Visit_Price " + Visit_Price + " has been deleted successfully.");
            	        	} 
            	        	else 
            	        	{
            	        		System.out.println("No record found with Visit_Price " + Visit_Price);
            	        	}
            	        	preparedStatement.close();
            	    	} 
                		catch (SQLException e) 
                		{
                			e.printStackTrace();
                		}
                		break;
                	}
                	case 7 :
                	{
                		try {
            	        	System.out.println("DELETE operation selected for doctor table.");
            	        	System.out.print("Enter Followup_Price to delete: ");
            	        	String Followup_Price = scanner.next();
            	        	String sql = "DELETE FROM doctor WHERE Followup_Price = ?";
            	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            	        	preparedStatement.setString(7, Followup_Price);
            	        	int rowsDeleted = preparedStatement.executeUpdate();
            	        	if (rowsDeleted > 0) 
            	        	{
            	        		System.out.println("The record with Followup_Price " + Followup_Price + " has been deleted successfully.");
            	        	} 
            	        	else 
            	        	{
            	        		System.out.println("No record found with Followup_Price " + Followup_Price);
            	        	}
            	        	preparedStatement.close();
            	    	} 
                		catch (SQLException e) 
                		{
                			e.printStackTrace();
                		}
                		break;
                	}
                	case 8 :
                	{
                		try 
                		{
            	        	System.out.println("DELETE operation selected for doctor table.");
            	        	System.out.print("Enter Inpateint_Visit_Price to delete: ");
            	        	String Inpateint_Visit_Price = scanner.next();
            	        	String sql = "DELETE FROM doctor WHERE Inpateint_Visit_Price = ?";
            	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            	        	preparedStatement.setString(8, Inpateint_Visit_Price);
            	        	int rowsDeleted = preparedStatement.executeUpdate();
            	        	if (rowsDeleted > 0) 
            	        	{
            	        		System.out.println("The record with Inpateint_Visit_Price " + Inpateint_Visit_Price + " has been deleted successfully.");
            	        	} 
            	        	else 
            	        	{
            	        		System.out.println("No record found with Inpateint_Visit_Price " + Inpateint_Visit_Price);
            	        	}
            	        	preparedStatement.close();
            	    	} 
                		catch (SQLException e) 
                		{
                			e.printStackTrace();
                		}
                		break;
                	}
                	case 9 : 
                	{
                		try 
                		{
            	        	System.out.println("DELETE operation selected for doctor table.");
            	        	System.out.print("Enter Note to delete: ");
            	        	String Note = scanner.next();
            	        	String sql = "DELETE FROM doctor WHERE Note = ?";
            	        	PreparedStatement preparedStatement = conn.prepareStatement(sql);
            	        	preparedStatement.setString(9, Note);
            	        	int rowsDeleted = preparedStatement.executeUpdate();
            	        	if (rowsDeleted > 0) 
            	        	{
            	        		System.out.println("The record with Note " + Note + " has been deleted successfully.");
            	        	} 
            	        	else 
            	        	{
            	        		System.out.println("No record found with Note " + Note);
            	        	}
            	        	preparedStatement.close();
            	    	} 
                		catch (SQLException e) 
                		{
                			e.printStackTrace();
                		}
                		break;	
                	}
                	default : 
                	{
                		System.out.println("Invalid choice. Please try again.");
                	}
                }
                break;
        	}
        	default : 
        	{
        		System.out.println("Invalid choice. Please try again.");
        	}
        }  
    }
    private static void performDropOperation(Connection conn) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("DROP operation selected.");
        System.out.print("Select the name of the table to drop : ");
        System.out.println("1. doctor\n2. healthinsurance\n3. hospitaldepartment\n4. patient\n5. patient_healthinsurance\n");
        System.out.print("Enter your choice: ");
        int ch7 = scanner.nextInt();
        switch(ch7)
        {
        	case 1 : 
        	{
        		String sql = "DROP TABLE IF EXISTS doctor";
                Statement statement = conn.createStatement();
                statement.executeUpdate(sql);
                System.out.println("Table doctor has been dropped successfully.");
                
                break;
        	}
        	case 2 : 
        	{
        		String sql = "DROP TABLE IF EXISTS healthinsurance";
                Statement statement = conn.createStatement();
                statement.executeUpdate(sql);
                System.out.println("Table healthinsurance has been dropped successfully.");
                break;
        	}
        	case 3 : 
        	{
        		String sql = "DROP TABLE IF EXISTS hospitaldepartment";
                Statement statement = conn.createStatement();
                statement.executeUpdate(sql);
                System.out.println("Table hospitaldepartment has been dropped successfully.");
                break;
        	}
        	case 4 : 
        	{
        		String sql = "DROP TABLE IF EXISTS patient";
                Statement statement = conn.createStatement();
                statement.executeUpdate(sql);
                System.out.println("Table patient has been dropped successfully.");
                break;
        	}
        	case 5 : 
        	{
        		String sql = "DROP TABLE IF EXISTS patient_healthinsurance";
                Statement statement = conn.createStatement();
                statement.executeUpdate(sql);
                System.out.println("Table patient_healthinsurance has been dropped successfully.");
                break;
        	}
        	default :
        	{
        		System.out.println("Invalid input. Please try again!");
        	}
        }
        scanner.close();
    }
}