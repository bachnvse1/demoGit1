/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1;
import Entity.Doctor;
import java.util.*;
import validate.Validate;
/**
 *
 * @author ADMIN
 */
public class DoctorManagement {
    private List<Doctor> listDoctor = new ArrayList();
    private Doctor doc = new Doctor();
    private Validate validate = new Validate();
    
    public void addDoctor() {
        String name = validate.checkInputString(1, 51);
        
    }
}
