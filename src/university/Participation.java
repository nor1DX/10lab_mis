package university;

public class Participation {

	private ResearchAssociate researcher;
	private Project project;
	private int hours;

	public Participation(ResearchAssociate researcher, Project project, int hours) {
		this.researcher = researcher;
		this.project = project;
		this.hours = hours;

		if (researcher != null) {
			researcher.addParticipation(this);
		}
		if (project != null) {
			project.addParticipation(this);
		}
	}

	public int getHours() {
		return this.hours;
	}

	public ResearchAssociate getResearcher() {
		return this.researcher;
	}

	public Project getProject() {
		return this.project;
	}

}
