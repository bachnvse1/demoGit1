/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author ADMIN
 */
public class Doctor {
    private int ID;
    private String name;
    private String DateOfBirth;
    private String Specialization;
    private int Availability;
    private String email;
    private String Mobile;

    public Doctor() {
    }

    public Doctor(int ID, String name, String DateOfBirth, String Specialization, int Availability, String email, String Mobile) {
        this.ID = ID;
        this.name = name;
        this.DateOfBirth = DateOfBirth;
        this.Specialization = Specialization;
        this.Availability = Availability;
        this.email = email;
        this.Mobile = Mobile;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String Specialization) {
        this.Specialization = Specialization;
    }

    public int getAvailability() {
        return Availability;
    }

    public void setAvailability(int Availability) {
        this.Availability = Availability;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    @Override
    public String toString() {
        return "Doctor{" + "ID=" + ID + ", name=" + name + ", DateOfBirth=" + DateOfBirth + ", Specialization=" + Specialization + ", Availability=" + Availability + ", email=" + email + ", Mobile=" + Mobile + '}';
    }
    
    
}
