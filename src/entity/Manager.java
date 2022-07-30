package entity;

import javax.persistence.*;

@Entity
@Table(name = "manager")
public class Manager {

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "company")
    private String company;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_detail_id")
    private ManagerDetail manager_detail_id;

    public Manager() {
    }

    public Manager(String firstName, String lastName, String company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public ManagerDetail getManager_detail_id() {
        return manager_detail_id;
    }

    public void setManager_detail_id(ManagerDetail manager_detail_id) {
        this.manager_detail_id = manager_detail_id;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", company='" + company + '\'' +
                ", managerDetail=" + manager_detail_id +
                "}\n";
    }
}
