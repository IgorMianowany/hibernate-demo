package entity;

import javax.persistence.*;

@Entity
@Table(name = "manager_detail")
public class ManagerDetail {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "department")
    private String department;

    @Column(name = "hobby")
    private String hobby;

    @OneToOne(mappedBy = "manager_detail_id")
    private Manager manager;

    public ManagerDetail() {
    }

    public ManagerDetail(String department, String hobby) {
        this.department = department;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "ManagerDetail{" +
                "id=" + id +
                ", department='" + department + '\'' +
                ", hobby='" + hobby + '\'' +
                "}\n";
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
