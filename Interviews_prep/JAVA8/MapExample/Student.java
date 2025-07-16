package Interviews_prep.JAVA8.MapExample;

import java.util.Objects;

public class Student {
    int id;
    String name;
    String F_name;
    String M_name;
    String department;

    public Student(int id, String name, String f_name, String m_name, String department) {
        this.id = id;
        this.name = name;
        F_name = f_name;
        M_name = m_name;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", F_name='" + F_name + '\'' +
                ", M_name='" + M_name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getF_name() {
        return F_name;
    }

    public String getM_name() {
        return M_name;
    }

    public String getDepartment() {
        return department;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setF_name(String f_name) {
        F_name = f_name;
    }

    public void setM_name(String m_name) {
        M_name = m_name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Student std))return false;
        return id == std.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
