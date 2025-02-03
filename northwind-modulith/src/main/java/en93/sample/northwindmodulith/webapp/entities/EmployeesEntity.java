
package en93.sample.northwindmodulith.webapp.entities;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "Employees")
public class EmployeesEntity {

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
    private String photo;//todo, there must be a better type
    @Column(name = "notes")
    private String notes;

    public EmployeesEntity() {
    }

    public EmployeesEntity(Integer employeeID, String lastName, String firstName, LocalDateTime birthDate, String photo, String notes) {
        this.employeeID = employeeID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.photo = photo;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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
        EmployeesEntity that = (EmployeesEntity) o;
        return Objects.equals(employeeID, that.employeeID) && Objects.equals(lastName, that.lastName) && Objects.equals(firstName, that.firstName) && Objects.equals(birthDate, that.birthDate) && Objects.equals(photo, that.photo) && Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeID, lastName, firstName, birthDate, photo, notes);
    }

    @Override
    public String toString() {
        return "EmployeesEntity{" +
                "employeeID=" + employeeID +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthDate=" + birthDate +
                ", photo='" + photo + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
