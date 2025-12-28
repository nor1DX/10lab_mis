package university;

public abstract class Employee {

    private int ssNo;
    private String name;
    private String email;
    private static int counter = 0;

    public Employee(int ssNo, String name, String email) {
        this.ssNo = ssNo;
        this.name = name;
        this.email = email;
        counter++;
    }

    public int getSsNo() {
        return this.ssNo;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public static int getCounter() {
        return counter;
    }

    public abstract String getEmployeeType();

}
