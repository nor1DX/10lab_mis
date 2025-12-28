package university;

public class Course {

    private Lecturer lecturer;
    private int id;
    private String name;
    private float hours;

    public Course(int id, String name, float hours) {
        this.id = id;
        this.name = name;
        this.hours = hours;
        this.lecturer = null;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public float getHours() {
        return this.hours;
    }

    public Lecturer getLecturer() {
        return this.lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        if (this.lecturer != null && this.lecturer != lecturer) {
            Lecturer oldLecturer = this.lecturer;
            this.lecturer = null;
            if (oldLecturer.getCourses().contains(this)) {
            }
        }

        this.lecturer = lecturer;

        if (lecturer != null && !lecturer.getCourses().contains(this)) {
            lecturer.addCourse(this);
        }
    }

}
