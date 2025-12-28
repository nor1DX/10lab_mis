package university;

public class Dean extends Employee {

    private Faculty faculty;

    public Dean(int ssNo, String name, String email) {
        super(ssNo, name, email);
        this.faculty = null;
    }

    public Faculty getFaculty() {
        return this.faculty;
    }

    public void setFaculty(Faculty faculty) {
        if (this.faculty != null && this.faculty != faculty) {
            Faculty oldFaculty = this.faculty;
            this.faculty = null;
            oldFaculty.setDean(null);
        }

        this.faculty = faculty;

        if (faculty != null && faculty.getDean() != this) {
            faculty.setDean(this);
        }
    }

    @Override
    public String getEmployeeType() {
        return "Dean";
    }

}
