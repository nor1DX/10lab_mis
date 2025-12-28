package university;

import java.util.*;

public class Lecturer extends ResearchAssociate {

	private Collection<Course> courses;


	public Lecturer(int ssNo, String name, String email, String fieldOfStudy) {
		super(ssNo, name, email, fieldOfStudy);
		this.courses = new ArrayList<>();
	}

	public Collection<Course> getCourses() {
		return new ArrayList<>(this.courses);
	}

	public void addCourse(Course course) {
		if (course == null) {
			return;
		}

		if (!this.courses.contains(course)) {
			this.courses.add(course);
			if (course.getLecturer() != this) {
				course.setLecturer(this);
			}
		}
	}

	@Override
	public String getEmployeeType() {
		return "Lecturer";
	}

}
