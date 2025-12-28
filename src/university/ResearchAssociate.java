package university;

import java.util.*;

public class ResearchAssociate extends Employee {

	private Collection<Institute> institutes;
	private Collection<Participation> participations;
	private String fieldOfStudy;

	public ResearchAssociate(int ssNo, String name, String email, String fieldOfStudy) {
		super(ssNo, name, email);
		this.fieldOfStudy = fieldOfStudy;
		this.institutes = new ArrayList<>();
		this.participations = new ArrayList<>();
	}

	public String getFieldOfStudy() {
		return this.fieldOfStudy;
	}

	public Collection<Institute> getInstitutes() {
		return new ArrayList<>(this.institutes);
	}

	public Collection<Participation> getParticipations() {
		return new ArrayList<>(this.participations);
	}

	public void addInstitute(Institute institute) {
		if (institute == null) {
			return;
		}

		if (!this.institutes.contains(institute)) {
			this.institutes.add(institute);
			if (!institute.getResearchers().contains(this)) {
				institute.addResearcher(this);
			}
		}
	}

	public void addParticipation(Participation participation) {
		if (participation != null && !this.participations.contains(participation)) {
			this.participations.add(participation);
		}
	}

	@Override
	public String getEmployeeType() {
		return "ResearchAssociate";
	}

}
