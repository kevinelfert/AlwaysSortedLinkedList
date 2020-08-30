//author: Kevin Elfert
//date: 26 March 2020
public class Employee implements Comparable<Employee>
{
	private String name;
	private Integer employeeID;

	public Employee(String name, Integer employeeID)
	{
		this.name = name;
		this.employeeID = employeeID;
	}

	public Employee(Employee e)
	{
		this.name = e.getName();
		this.employeeID = e.getEmployeeID();
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return this.name;
	}

	public Integer getEmployeeID()
	{
		return this.employeeID;
	}

	public void setEmployeeID(Integer newID)
	{
		this.employeeID = newID;
	}

	public String toString()
	{
		return String.format("%s, ID number: %d\n",this.name, this.employeeID);
	}

	public int compareTo(Employee otherEmployee)
	{
		int result = this.name.compareTo(otherEmployee.getName());
		if(result == 0)
			result = this.employeeID.compareTo(otherEmployee.getEmployeeID());
		return result;
	}
}