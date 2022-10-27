
import javax.persistence.*;
import java.util.List;

@Entity
public class UserQ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "first_name")
    private String name;
    private int age;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    List<Pet> pets;

    public List<Pet> getPet() {
        return pets;
    }

    public void setPet(List<Pet> pets) {
        this.pets = pets;
    }

    public UserQ(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public UserQ() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserQ{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", pets=" + pets +
                '}';
    }
}


