import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDemo {
	
	public static void main(String[] args) throws IOException {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_boot_training","root","admin");
			con.setAutoCommit(false);
			Statement stmt = con.createStatement();

			 ResultSet debitrs = stmt.executeQuery("select * from account1");
			 debitrs.next();
			Integer debtorId =  debitrs.getInt("userid");
			String debtorName = debitrs.getString("username");
			Integer debtBalance =  debitrs.getInt("balance");
			
			System.out.println("User : " + debtorName + ": Balance : " + debtBalance);
			
			ResultSet creditrs = stmt.executeQuery("select * from account2");
			creditrs.next();
			Integer creditId =  creditrs.getInt("userid");
			String creditorName = creditrs.getString("username");
			Integer creditortBalance =  creditrs.getInt("balance");
			
			System.out.println("User : " + creditorName + ": Balance : " + creditortBalance);
			
			BufferedReader buferReader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Ammount to To Transfer");
			
			 Integer ammount  = Integer.parseInt(buferReader.readLine());
			 
			 if(debtBalance>=ammount) {
				int  currentBalance = debtBalance - ammount;
				
				String debitquery = "update account1 set balance ="+currentBalance;
				stmt.executeUpdate(debitquery);
				System.out.println("Ammount Debitted from " + debtorName);
				
				int creditBalnace = creditortBalance + ammount;
				String creditQuery =  "update account2 set balanc ="+creditBalnace;
				stmt.executeUpdate(creditQuery);
				System.out.println("Ammount Credit to "+ creditorName);
				
				con.commit();
				
			 }else {
				 System.out.println("Not Have Suffecient Ammount");
			 }
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Ammount Reverted");
			e.printStackTrace();
		}
		
	}

}
