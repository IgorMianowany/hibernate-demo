package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_detail_id")
    private ManagerDetail manager_detail_id;

    @OneToMany(mappedBy = "manager", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Employee> employeeList;

    public Manager() {
    }

    public Manager(String firstName, String lastName, String company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = company;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
                ", company='" + email + '\'' +
                ", managerDetail=" + manager_detail_id +
                "}";
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public void add(Employee employee){
        if(employeeList == null){
            employeeList = new ArrayList<>();
        }
        employeeList.add(employee);
    }
}
