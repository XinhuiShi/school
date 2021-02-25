package week03;

import static org.junit.Assert.*;

import java.text.DecimalFormat;

import org.junit.Test;

/**
 * 
 * @author XinDes
 *
 */
public class EmployeeTest {

	private String firstN = "Amber";
	private String lastN = "Zook";
	private double sal = 15000.00;

	@Test
	public void testEmployee() {
		try {
			Employee emp = new Employee();
		} catch (Exception e) {
			fail("Employee Constructor Failed");
		}
	}

	@Test
	public void testEmployeeSS() {
		try {
			Employee emp = new Employee("Amber", "Zook");
		} catch (Exception e) {
			fail("Employee Constructor Failed");
		}
	}

	@Test
	public void testEmployeeSSD() {
		try {
			Employee emp = new Employee("Amber", "Zook", 15000.00);
		} catch (Exception e) {
			fail("Employee Constructor Failed");
		}
	}

	@Test
	public void testSetAndGetFirst() {
		try {
			String msg = "";
			boolean fSuccess = true;
			String expected = firstN;

			Employee emp = new Employee();
			emp.setFirstName(expected);
			String actual = emp.getFirstName();
			
			if(!expected.equals(actual)) {
				fSuccess = false;
				msg += String.format(
						"Expected: %s, found %s not equal\n",
						expected.toString(), actual.toString());
			}
			if(!fSuccess)
			{
				fail("Error comparing expected with actual data\n" + msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSetAndGetLast() {
		try {
			String msg = "";
			boolean fSuccess = true;
			String expected = lastN;

			Employee emp = new Employee();
			emp.setLastName(expected);
			String actual = emp.getLastName();
			
			if(!expected.equals(actual)) {
				fSuccess = false;
				msg += String.format(
						"Expected: %s, found %s not equal\n",
						expected.toString(), actual.toString());
			}
			if(!fSuccess)
			{
				fail("Error comparing expected with actual data\n" + msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSetAndGetSalary() {
		try {
			String msg = "";
			boolean fSuccess = true;
			double expected = sal;

			Employee emp = new Employee();
			emp.setSalary(expected);
			double actual = emp.getSalary();
			
			if(expected != actual) {
				fSuccess = false;
				msg += String.format(
						"Expected: %s, found %s not equal\n",
						expected, actual);
			}
			if(!fSuccess)
			{
				fail("Error comparing expected with actual data\n" + msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testDisplayName() {
		try {
			String msg = "";
			boolean fSuccess = true;
			Employee emp = new Employee(firstN, lastN, sal);
			String expected = String.format("%s, %s", lastN, firstN);
			String actual = emp.getDisplayName();
			
			if(!expected.equals(actual)) {
				fSuccess = false;
				msg += String.format(
						"Expected: %s, found %s not equal\n",
						expected.toString(), actual.toString());
			}
			if(!fSuccess)
			{
				fail("Error comparing expected with actual data\n" + msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFormattedSalary() {
		try {
			String msg = "";
			boolean fSuccess = true;
			Employee emp = new Employee(firstN, lastN, sal);
			String expected = "15,000.00";
			String actual = emp.getFormattedSalary();
			
			if(!expected.equals(actual)) {
				fSuccess = false;
				msg += String.format(
						"Expected: %s, found %s not equal\n",
						expected.toString(), actual.toString());
			}
			if(!fSuccess)
			{
				fail("Error comparing expected with actual data\n" + msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testHashCode() {
		try {
			String msg = "";
			boolean fSuccess = true;
			Employee emp = new Employee(firstN, lastN, sal);
			int expected = 150772614;
			int actual = emp.hashCode();
			
			if(expected != actual) {
				fSuccess = false;
				msg += String.format(
						"Expected: %s, found %s not equal\n",
						expected, actual);
			}
			if(!fSuccess)
			{
				fail("Error comparing expected with actual data\n" + msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testEquals() {
		try {
			boolean fSuccess = true;
			String eFirst = firstN;
			String eLast = lastN;
			double eSal = sal;
			Employee expected = new Employee(eFirst, eLast, eSal);
			Employee test =  new Employee(eFirst, eLast, eSal);
			boolean success = expected.equals(test);
			
			if(!success)
			{
				fail("Error comparing expected with actual data\n" );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testToString() {
		try {
			String msg = "";
			boolean fSuccess = true;
			Employee emp = new Employee(firstN, lastN, sal);
			String expected = lastN + ", " + firstN + " Salary: $15,000.00"; 
			String actual = emp.toString();
			
			if(!expected.equals(actual)) {
				fSuccess = false;
				msg += String.format(
						"Expected: %s, found %s not equal\n",
						expected.toString(), actual.toString());
			}
			if(!fSuccess)
			{
				fail("Error comparing expected with actual data\n" + msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
