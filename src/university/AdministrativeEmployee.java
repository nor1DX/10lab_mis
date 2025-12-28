package university;

public class AdministrativeEmployee extends Employee {

	public AdministrativeEmployee(int ssNo, String name, String email) {
		super(ssNo, name, email);
	}

	@Override
	public String getEmployeeType() {
		return "AdministrativeEmployee";
	}

}
