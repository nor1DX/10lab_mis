package university;

import java.util.*;

public class Project {

	private Collection<Participation> participations;
	private String name;

	public Project(String name) {
		this.name = name;
		this.participations = new ArrayList<>();
	}

	public String getName() {
		return this.name;
	}

	public Collection<Participation> getParticipations() {
		return new ArrayList<>(this.participations);
	}

	public void addParticipation(Participation participation) {
		if (participation != null && !this.participations.contains(participation)) {
			this.participations.add(participation);
		}
	}

	public int getTotalHours() {
		int total = 0;
		for (Participation p : this.participations) {
			total += p.getHours();
		}
		return total;
	}

}
