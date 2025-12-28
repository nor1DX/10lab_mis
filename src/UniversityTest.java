import university.*;

public class UniversityTest {

	private static int passed = 0;
	private static int failed = 0;

	public static void main(String[] args) {
		System.out.println("UNIVERSITY SYSTEM - TESTS");
		System.out.println("=========================\n");

		testEmployeeCreation();
		testFacultyDeanRelationship();
		testUniversityComposition();
		testFacultyComposition();
		testResearcherInstitute();
		testLecturerCourse();
		testProjectParticipation();
		testEmployeeCounter();
		testInheritance();
		testBidirectionalLinks();

		System.out.println("\n=========================");
		System.out.println("RESULTS:");
		System.out.println("Passed: " + passed);
		System.out.println("Failed: " + failed);
		System.out.println("Total:  " + (passed + failed));
		System.out.println("=========================");

		if (failed == 0) {
			System.out.println("\nALL TESTS PASSED ✓\n");
		} else {
			System.out.println("\nSOME TESTS FAILED ✗\n");
		}
	}

	private static void testEmployeeCreation() {
		System.out.println("Test 1: Employee Creation");
		try {
			Dean dean = new Dean(1, "Test Dean", "dean@test.com");

			assert dean.getSsNo() == 1 : "SSN mismatch";
			assert dean.getName().equals("Test Dean") : "Name mismatch";
			assert dean.getEmail().equals("dean@test.com") : "Email mismatch";

			System.out.println("  ✓ PASSED\n");
			passed++;
		} catch (AssertionError e) {
			System.out.println("  ✗ FAILED: " + e.getMessage() + "\n");
			failed++;
		} catch (Exception e) {
			System.out.println("  ✗ FAILED: " + e.getMessage() + "\n");
			failed++;
		}
	}

	private static void testFacultyDeanRelationship() {
		System.out.println("Test 2: Faculty-Dean Relationship (Bidirectional)");
		try {
			Dean dean = new Dean(2, "Dean Two", "dean2@test.com");
			Faculty faculty = new Faculty("Test Faculty");

			faculty.setDean(dean);

			assert faculty.getDean() == dean : "Faculty->Dean link failed";
			assert dean.getFaculty() == faculty : "Dean->Faculty link failed";

			System.out.println("  ✓ PASSED\n");
			passed++;
		} catch (AssertionError e) {
			System.out.println("  ✗ FAILED: " + e.getMessage() + "\n");
			failed++;
		} catch (Exception e) {
			System.out.println("  ✗ FAILED: " + e.getMessage() + "\n");
			failed++;
		}
	}

	private static void testUniversityComposition() {
		System.out.println("Test 3: University-Faculty Composition");
		try {
			University university = new University("Test University");
			Faculty faculty = new Faculty("Test Faculty");

			university.addFaculty(faculty);

			assert university.getFaculties().size() == 1 : "Faculty not added";
			assert faculty.getUniversity() == university : "Composition link failed";

			System.out.println("  ✓ PASSED\n");
			passed++;
		} catch (AssertionError e) {
			System.out.println("  ✗ FAILED: " + e.getMessage() + "\n");
			failed++;
		} catch (Exception e) {
			System.out.println("  ✗ FAILED: " + e.getMessage() + "\n");
			failed++;
		}
	}

	private static void testFacultyComposition() {
		System.out.println("Test 4: Faculty-Institute Composition");
		try {
			Faculty faculty = new Faculty("Test Faculty");
			Institute institute = new Institute("Test Institute", "Address 1");

			faculty.addInstitute(institute);

			assert faculty.getInstitutes().size() == 1 : "Institute not added";
			assert institute.getFaculty() == faculty : "Composition link failed";

			System.out.println("  ✓ PASSED\n");
			passed++;
		} catch (AssertionError e) {
			System.out.println("  ✗ FAILED: " + e.getMessage() + "\n");
			failed++;
		} catch (Exception e) {
			System.out.println("  ✗ FAILED: " + e.getMessage() + "\n");
			failed++;
		}
	}

	private static void testResearcherInstitute() {
		System.out.println("Test 5: Researcher-Institute Many-to-Many");
		try {
			ResearchAssociate researcher = new ResearchAssociate(5, "Researcher", "r@test.com", "AI");
			Institute inst1 = new Institute("Institute 1", "Addr 1");
			Institute inst2 = new Institute("Institute 2", "Addr 2");

			inst1.addResearcher(researcher);
			inst2.addResearcher(researcher);

			assert researcher.getInstitutes().size() == 2 : "Not all institutes added";
			assert inst1.getResearchers().contains(researcher) : "Bidirectional link failed";
			assert inst2.getResearchers().contains(researcher) : "Bidirectional link failed";

			System.out.println("  ✓ PASSED\n");
			passed++;
		} catch (AssertionError e) {
			System.out.println("  ✗ FAILED: " + e.getMessage() + "\n");
			failed++;
		} catch (Exception e) {
			System.out.println("  ✗ FAILED: " + e.getMessage() + "\n");
			failed++;
		}
	}

	private static void testLecturerCourse() {
		System.out.println("Test 6: Lecturer-Course Relationship");
		try {
			Lecturer lecturer = new Lecturer(6, "Lecturer", "l@test.com", "CS");
			Course course1 = new Course(101, "Course 1", 40.0f);
			Course course2 = new Course(102, "Course 2", 50.0f);

			course1.setLecturer(lecturer);
			course2.setLecturer(lecturer);

			assert lecturer.getCourses().size() == 2 : "Courses not added";
			assert course1.getLecturer() == lecturer : "Course->Lecturer link failed";
			assert course2.getLecturer() == lecturer : "Course->Lecturer link failed";

			System.out.println("  ✓ PASSED\n");
			passed++;
		} catch (AssertionError e) {
			System.out.println("  ✗ FAILED: " + e.getMessage() + "\n");
			failed++;
		} catch (Exception e) {
			System.out.println("  ✗ FAILED: " + e.getMessage() + "\n");
			failed++;
		}
	}

	private static void testProjectParticipation() {
		System.out.println("Test 7: Project-Participation Association Class");
		try {
			ResearchAssociate researcher = new ResearchAssociate(7, "Researcher", "r7@test.com", "ML");
			Project project = new Project("Project 1");
			Participation participation = new Participation(researcher, project, 100);

			assert researcher.getParticipations().size() == 1 : "Participation not added to researcher";
			assert project.getParticipations().size() == 1 : "Participation not added to project";
			assert project.getTotalHours() == 100 : "Total hours calculation failed";

			System.out.println("  ✓ PASSED\n");
			passed++;
		} catch (AssertionError e) {
			System.out.println("  ✗ FAILED: " + e.getMessage() + "\n");
			failed++;
		} catch (Exception e) {
			System.out.println("  ✗ FAILED: " + e.getMessage() + "\n");
			failed++;
		}
	}

	private static void testEmployeeCounter() {
		System.out.println("Test 8: Employee Static Counter");
		try {
			int initial = Employee.getCounter();
			new Dean(8, "Dean", "d@test.com");
			new AdministrativeEmployee(9, "Admin", "a@test.com");
			int current = Employee.getCounter();

			assert (current - initial) == 2 : "Counter increment failed";

			System.out.println("  ✓ PASSED\n");
			passed++;
		} catch (AssertionError e) {
			System.out.println("  ✗ FAILED: " + e.getMessage() + "\n");
			failed++;
		} catch (Exception e) {
			System.out.println("  ✗ FAILED: " + e.getMessage() + "\n");
			failed++;
		}
	}

	private static void testInheritance() {
		System.out.println("Test 9: Inheritance Hierarchy");
		try {
			Dean dean = new Dean(10, "Dean", "d@test.com");
			Lecturer lec = new Lecturer(11, "Lec", "lec@test.com", "CS");

			assert dean instanceof Employee : "Dean not instance of Employee";
			assert lec instanceof Employee : "Lecturer not instance of Employee";
			assert lec instanceof ResearchAssociate : "Lecturer not instance of ResearchAssociate";
			assert dean.getEmployeeType().equals("Dean") : "EmployeeType incorrect";
			assert lec.getEmployeeType().equals("Lecturer") : "EmployeeType incorrect";

			System.out.println("  ✓ PASSED\n");
			passed++;
		} catch (AssertionError e) {
			System.out.println("  ✗ FAILED: " + e.getMessage() + "\n");
			failed++;
		} catch (Exception e) {
			System.out.println("  ✗ FAILED: " + e.getMessage() + "\n");
			failed++;
		}
	}

	private static void testBidirectionalLinks() {
		System.out.println("Test 10: Bidirectional Link Switching");
		try {
			Dean dean1 = new Dean(12, "Dean 1", "d1@test.com");
			Dean dean2 = new Dean(13, "Dean 2", "d2@test.com");
			Faculty faculty = new Faculty("Faculty");

			// Set first dean
			faculty.setDean(dean1);
			assert faculty.getDean() == dean1 : "First dean not set";
			assert dean1.getFaculty() == faculty : "Bidirectional link failed";

			// Switch to second dean
			faculty.setDean(dean2);
			assert faculty.getDean() == dean2 : "Second dean not set";
			assert dean2.getFaculty() == faculty : "New bidirectional link failed";
			assert dean1.getFaculty() == null : "Old link not cleared";

			System.out.println("  ✓ PASSED\n");
			passed++;
		} catch (AssertionError e) {
			System.out.println("  ✗ FAILED: " + e.getMessage() + "\n");
			failed++;
		} catch (Exception e) {
			System.out.println("  ✗ FAILED: " + e.getMessage() + "\n");
			failed++;
		}
	}
}
