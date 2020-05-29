package fr.dauphine.microservice.reader.dto;

import fr.dauphine.microservice.reader.model.Gender;
import fr.dauphine.microservice.reader.model.Reader;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

public class ReaderDto extends RepresentationModel<ReaderDto> {

    private Integer id;

    private Gender gender;

    private String familyName;
    private String firstName;
    private Date birthDate;
    private String address;

    public Integer getId() {
        return id;
    }

    public ReaderDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public ReaderDto setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public String getFamilyName() {
        return familyName;
    }

    public ReaderDto setFamilyName(String familyName) {
        this.familyName = familyName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public ReaderDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public ReaderDto setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ReaderDto setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReaderDto reader = (ReaderDto) o;
        return id.equals(reader.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    public ReaderDto fill(Reader reader) {
        this.id = reader.getId();
        this.address = reader.getAddress();
        this.birthDate = reader.getBirthDate();
        this.familyName = reader.getFamilyName();
        this.firstName = reader.getFirstName();
        this.gender = reader.getGender();
        return this;
    }
}
