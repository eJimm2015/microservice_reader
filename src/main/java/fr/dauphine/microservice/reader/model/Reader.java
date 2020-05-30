package fr.dauphine.microservice.reader.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.hateoas.RepresentationModel;

@Entity
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Gender gender;

    private String familyName;
    private String firstName;
    private Date birthDate;
    private String address;

    public Integer getId() {
        return id;
    }

    public Reader setId(Integer id) {
        this.id = id;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public Reader setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public String getFamilyName() {
        return familyName;
    }

    public Reader setFamilyName(String familyName) {
        this.familyName = familyName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Reader setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Reader setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Reader setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return id.equals(reader.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", gender=" + gender +
                ", familyName='" + familyName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                '}';
    }

    public Reader update(Reader reader) {
        if(Objects.nonNull(reader.gender)) this.gender = reader.gender;
        if(Objects.nonNull(reader.familyName)) this.familyName = reader.familyName;
        if(Objects.nonNull(reader.firstName)) this.firstName = reader.firstName;
        if(Objects.nonNull(reader.address)) this.address = reader.address;
        if(Objects.nonNull(reader.birthDate)) this.birthDate = reader.birthDate;
        return this;
    }
}
