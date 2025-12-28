import university.*;

public class Main {

	public static void main(String[] args) {
		System.out.println("UNIVERSITY MANAGEMENT SYSTEM");
		System.out.println("============================");

		// Create university
		System.out.println("\n1. Creating University");
		University vsu = new University("Voronezh State University");
		System.out.println("Created: " + vsu.getName());

		// Create employees
		System.out.println("\n2. Creating Employees");
		Dean dean1 = new Dean(1001, "Prof. Ivan Petrov", "petrov@vsu.ru");
		Dean dean2 = new Dean(1002, "Prof. Maria Sidorova", "sidorova@vsu.ru");

		ResearchAssociate researcher1 = new ResearchAssociate(
				2001, "Dr. Alexey Ivanov", "ivanov@vsu.ru", "Artificial Intelligence"
		);

		Lecturer lecturer1 = new Lecturer(
				3001, "Dr. Dmitry Smirnov", "smirnov@vsu.ru", "Software Engineering"
		);

		AdministrativeEmployee admin1 = new AdministrativeEmployee(
				4001, "Olga Kuznetsova", "kuznetsova@vsu.ru"
		);

		System.out.println("Created " + Employee.getCounter() + " employees");

		// Create faculties
		System.out.println("\n3. Creating Faculties");
		Faculty computerScience = new Faculty("Faculty of Computer Science");
		Faculty mathematics = new Faculty("Faculty of Mathematics");

		vsu.addFaculty(computerScience);
		vsu.addFaculty(mathematics);

		// Assign deans
		System.out.println("\n4. Assigning Deans");
		computerScience.setDean(dean1);
		mathematics.setDean(dean2);
		System.out.println(dean1.getName() + " -> " + computerScience.getName());
		System.out.println(dean2.getName() + " -> " + mathematics.getName());

		// Create institutes
		System.out.println("\n5. Creating Institutes");
		Institute aiInstitute = new Institute("AI Institute", "Room 301");
		Institute seInstitute = new Institute("SE Institute", "Room 405");

		computerScience.addInstitute(aiInstitute);
		computerScience.addInstitute(seInstitute);

		// Assign researchers
		System.out.println("\n6. Assigning Researchers");
		aiInstitute.addResearcher(researcher1);
		aiInstitute.addResearcher(lecturer1);
		System.out.println("AI Institute: " + aiInstitute.getResearchers().size() + " researchers");

		// Create courses
		System.out.println("\n7. Creating Courses");
		Course course1 = new Course(101, "Machine Learning", 64.0f);
		Course course2 = new Course(102, "Design Patterns", 48.0f);

		course1.setLecturer(lecturer1);
		course2.setLecturer(lecturer1);
		System.out.println(lecturer1.getName() + " teaches " + lecturer1.getCourses().size() + " courses");

		// Create projects
		System.out.println("\n8. Creating Projects");
		Project project1 = new Project("Neural Networks Project");

		Participation p1 = new Participation(researcher1, project1, 120);
		Participation p2 = new Participation(lecturer1, project1, 80);

		System.out.println(project1.getName() + ": " + project1.getParticipations().size() + " participants");

		// Show relationships
		System.out.println("\n9. Relationships");
		System.out.println("Dean leads faculty: " + dean1.getFaculty().getName());
		System.out.println("Researcher works in " + researcher1.getInstitutes().size() + " institutes");

		System.out.println("\n============================");
		System.out.println("Total Employees: " + Employee.getCounter());
		System.out.println("============================");
	}
}
