package university;

import java.util.*;

public class Institute {

    private Faculty faculty;
    private Collection<ResearchAssociate> researchers;
    private String name;
    private String address;

    public Institute(String name, String address) {
        this.name = name;
        this.address = address;
        this.faculty = null;
        this.researchers = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public Faculty getFaculty() {
        return this.faculty;
    }

    public Collection<ResearchAssociate> getResearchers() {
        return new ArrayList<>(this.researchers);
    }

    protected void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void addResearcher(ResearchAssociate researcher) {
        if (researcher == null) {
            return;
        }

        if (!this.researchers.contains(researcher)) {
            this.researchers.add(researcher);
            if (!researcher.getInstitutes().contains(this)) {
                researcher.addInstitute(this);
            }
        }
    }

}
