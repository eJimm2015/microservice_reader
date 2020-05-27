package fr.dauphine.microservice.reader.model;

public enum Gender {
    M("M"),F("F");
    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return gender;
    }
}
