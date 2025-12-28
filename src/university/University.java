package university;

import java.util.*;

public class University {

	private Collection<Faculty> faculties;
	private String name;

	public University(String name) {
		this.name = name;
		this.faculties = new ArrayList<>();
	}

	public String getName() {
		return this.name;
	}

	public Collection<Faculty> getFaculties() {
		return new ArrayList<>(this.faculties);
	}

	public void addFaculty(Faculty faculty) {
		if (faculty == null) {
			return;
		}

		if (!this.faculties.contains(faculty)) {
			this.faculties.add(faculty);
			faculty.setUniversity(this);
		}
	}

}
