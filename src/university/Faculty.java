package university;

import java.util.*;

public class Faculty {

    private University university;
    private Dean dean;
    private Collection<Institute> institutes;
    private String name;

    public Faculty(String name) {
        this.name = name;
        this.dean = null;
        this.university = null;
        this.institutes = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public Dean getDean() {
        return this.dean;
    }

    public University getUniversity() {
        return this.university;
    }

    public Collection<Institute> getInstitutes() {
        return new ArrayList<>(this.institutes);
    }

    public void setDean(Dean dean) {
        if (this.dean != null && this.dean != dean) {
            Dean oldDean = this.dean;
            this.dean = null;
            oldDean.setFaculty(null);
        }

        this.dean = dean;

        if (dean != null && dean.getFaculty() != this) {
            dean.setFaculty(this);
        }
    }

    protected void setUniversity(University university) {
        this.university = university;
    }

    public void addInstitute(Institute institute) {
        if (institute == null) {
            return;
        }

        if (!this.institutes.contains(institute)) {
            this.institutes.add(institute);
            institute.setFaculty(this);
        }
    }

}
