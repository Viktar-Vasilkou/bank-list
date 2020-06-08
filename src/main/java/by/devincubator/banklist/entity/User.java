package by.devincubator.banklist.entity;

import java.io.Serializable;

public class User implements Identifiable, Serializable {
    private Integer id;
    private String secondName;
    private String fistName;

    public User(){

    }

    public User(Integer id, String secondName, String fistName) {
        this.id = id;
        this.secondName = secondName;
        this.fistName = fistName;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getFistName() {
        return fistName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (secondName != null ? !secondName.equals(user.secondName) : user.secondName != null) return false;
        return fistName != null ? fistName.equals(user.fistName) : user.fistName == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (fistName != null ? fistName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", secondName='" + secondName + '\'' +
                ", fistName='" + fistName + '\'' +
                '}';
    }


}
