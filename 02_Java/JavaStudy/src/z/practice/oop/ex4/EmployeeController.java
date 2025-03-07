package z.practice.oop.ex4;

public class EmployeeController {

	Employee e = new Employee();

	public void add(int empNo, String name, char gender, String phone) {
		e = new Employee(empNo, name, gender, phone);
	}

	public void add(int empNo, String name, char gender, String phone, String dept, int salary, double bonus) {
		e = new Employee(empNo, name, gender, phone, dept, salary, bonus);
	}

	public void modify(String phone) {
		e.setPhone(phone);
	}

	public void modiy(int salary) {
		e.setSalary(salary);
	}

	public void modiy(double bonus) {
		e.setBonus(bonus);
	}

	public Employee remove() {
		return this.e = null;
	}
	
	public String inform() {
		if(this.e == null) {
			return null;
		} else {
			return e.printEmployee();
		}
	}
}
