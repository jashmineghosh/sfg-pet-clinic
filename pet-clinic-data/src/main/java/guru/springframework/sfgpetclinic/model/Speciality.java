package guru.springframework.sfgpetclinic.model;

public class Speciality extends BaseEntity{
    private String Description;

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
