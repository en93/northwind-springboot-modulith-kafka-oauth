
package en93.sample.northwindmodulith.webapp.entities;


import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "Employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "employeeID")
    private Integer employeeID;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "birthDate")
    private LocalDateTime birthDate;
    @Column(name = "photo")
    private String photoTitle;
    @Column(name = "notes")
    private String notes;

    public EmployeeEntity() {
    }

    public EmployeeEntity(Integer employeeID, String lastName, String firstName, LocalDateTime birthDate, String photoTitle, String notes) {
        this.employeeID = employeeID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.photoTitle = photoTitle;
        this.notes = notes;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhotoTitle() {
        return photoTitle;
    }

    public void setPhotoTitle(String photoTitle) {
        this.photoTitle = photoTitle;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return Objects.equals(employeeID, that.employeeID) && Objects.equals(lastName, that.lastName) && Objects.equals(firstName, that.firstName) && Objects.equals(birthDate, that.birthDate) && Objects.equals(photoTitle, that.photoTitle) && Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeID, lastName, firstName, birthDate, photoTitle, notes);
    }

    @Override
    public String toString() {
        return "EmployeesEntity{" +
                "employeeID=" + employeeID +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthDate=" + birthDate +
                ", photoTitle='" + photoTitle + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
