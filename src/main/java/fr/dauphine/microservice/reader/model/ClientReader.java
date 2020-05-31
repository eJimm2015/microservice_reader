package fr.dauphine.microservice.reader.model;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;
import java.util.Objects;

public class ClientReader {

    private Gender gender;
    private String familyName;
    private String firstName;

    @ApiModelProperty(value = "YYYY-MM-DD",example = "YYYY-MM-DD")
    private LocalDate birthDate;
    private String address;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientReader that = (ClientReader) o;
        return gender == that.gender &&
                familyName.equals(that.familyName) &&
                firstName.equals(that.firstName) &&
                birthDate.equals(that.birthDate) &&
                address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender, familyName, firstName, birthDate, address);
    }

    @Override
    public String toString() {
        return "ClientReader{" +
                "gender=" + gender +
                ", familyName='" + familyName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                '}';
    }

    public Reader toReader() {
        return new Reader()
                .setFamilyName(familyName)
                .setFirstName(firstName)
                .setAddress(address)
                .setBirthDate(birthDate)
                .setGender(gender);
    }
}
