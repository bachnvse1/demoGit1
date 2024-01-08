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
    Scanner sc = new Scanner(System.in);

    public void addDoctor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("===== Add doctor =====");
        System.out.println("Input number of doctor u want: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Enter name: ");
            String name = validate.checkInputString(1, 51);
            while (true) {
                System.out.println("Enter dob: ");
                String Dob = sc.nextLine();
                if (validate.checkDob(Dob)) {
                    System.out.println("Enter specialization: ");
                    String Specialization = validate.checkInputString(0, 256);
                    System.out.println("Enter avaibility: ");
                    int Availability = validate.checkIntRange(0, 3);
                    System.out.println("Enter email: ");
                    String email = validate.checkEmail();
                    System.out.println("Enter mobile: ");
                    String mobile = validate.checkMobile();
                    if (listDoctor.size() == 0) {
                        if (Availability == 1) {
                            listDoctor.add(new Doctor(1, name, Dob, Specialization, "in vacation", email, mobile));
                            System.err.println("Add success!");
                            break;
                        } if (Availability == 1) {
                            listDoctor.add(new Doctor(1, name, Dob, Specialization, "available", email, mobile));
                            System.err.println("Add success!");
                            break;
                        } if (Availability == 2) {
                            listDoctor.add(new Doctor(1, name, Dob, Specialization, "busy in emergency case", email, mobile));
                            System.err.println("Add success!");
                            break;
                        } if (Availability == 3) {
                            listDoctor.add(new Doctor(1, name, Dob, Specialization, " in diagnosing case", email, mobile));
                            System.err.println("Add success!");
                            break;
                        }

                    } else {
                        if (Availability == 1) {
                            listDoctor.add(new Doctor(listDoctor.get(listDoctor.size() - 1).getID() + 1, name, Dob, Specialization, "in vacation", email, mobile));
                            System.err.println("Add success!");
                            break;
                        } if (Availability == 1) {
                            listDoctor.add(new Doctor(listDoctor.get(listDoctor.size() - 1).getID() + 1, name, Dob, Specialization, "available", email, mobile));
                            System.err.println("Add success!");
                            break;
                        } if (Availability == 2) {
                            listDoctor.add(new Doctor(listDoctor.get(listDoctor.size() - 1).getID() + 1, name, Dob, Specialization, "busy in emergency case", email, mobile));
                            System.err.println("Add success!");
                            break;
                        } if (Availability == 3) {
                            listDoctor.add(new Doctor(listDoctor.get(listDoctor.size() - 1).getID() + 1, name, Dob, Specialization, " in diagnosing case", email, mobile));
                            System.err.println("Add success!");
                            break;
                        }
                    }
                }
            }
        }
    }

    public void deleteDoctor() {
        System.out.println("===== Delete doctor =====");
        System.out.printf("%-10s|%-15s|%-15s|%-15s|%-25s|%-25s|%-20s\n", "ID", "Name", "Date of birth", "Specialization", "Availability", "Email", "Mobile");
        for (Doctor doctor : listDoctor) {
            System.out.printf("%-10s|%-15s|%-15s|%-15s|%-25s|%-25s|%-20s\n", doctor.getID(), doctor.getName(),
                    doctor.getDateOfBirth(), doctor.getSpecialization(),
                    doctor.getAvailability(), doctor.getEmail(), doctor.getMobile());
        }
        System.out.println("Choose id doctor u want to delete: ");
        while (true) {
            try {
                int ID = Integer.parseInt(sc.nextLine());
                if (finDoctor(ID, null) != null) {
                    listDoctor.remove(finDoctor(ID, null));
                    System.out.println("Delete success!");
                    return;
                }
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Doctor is not exist!");
                return;
            }
        }
    }

    public void editInformationDoctor() {
        System.out.println("===== Edit information =====");
        System.out.printf("%-10s|%-15s|%-15s|%-15s|%-25s|%-25s|%-20s\n", "ID", "Name", "Date of birth", "Specialization", "Availability", "Email", "Mobile");
        for (Doctor doctor : listDoctor) {
            System.out.printf("%-10s|%-15s|%-15s|%-15s|%-25s|%-25s|%-20s\n", doctor.getID(), doctor.getName(),
                    doctor.getDateOfBirth(), doctor.getSpecialization(),
                    doctor.getAvailability(), doctor.getEmail(), doctor.getMobile());
        }
        System.out.println("Choose id doctor u want to edit: ");
        while (true) {
            try {
                int ID = Integer.parseInt(sc.nextLine());
                if (finDoctor(ID, null) != null) {
                    while (true) {
                        System.out.println("Enter name: ");
                        String name = validate.checkInputString(1, 51);
                        System.out.println("Enter dob: ");
                        String Dob = sc.nextLine();
                        if (validate.checkDob(Dob)) {
                            System.out.println("Enter specialization: ");
                            String Specialization = validate.checkInputString(0, 256);
                            System.out.println("Enter avaibility: ");
                            int Availability = validate.checkIntRange(0, 3);
                            System.out.println("Enter email: ");
                            String email = validate.checkEmail();
                            System.out.println("Enter mobile: ");
                            String mobile = validate.checkMobile();
                            finDoctor(ID, null).setName(name);
                            finDoctor(ID, null).setDateOfBirth(Dob);
                            finDoctor(ID, null).setSpecialization(Specialization);
                            finDoctor(ID, null).setEmail(email);
                            finDoctor(ID, null).setMobile(mobile);
                            System.err.println("Edit success!");
                            return;
                        }
                    }
                }
                throw new Exception();

            } catch (Exception e) {
                System.err.println("Doctor is not exist!");
                return;
            }
        }
    }

    public Doctor finDoctor(int ID, String name) {
        for (Doctor doctor : listDoctor) {
            if (ID == doctor.getID() || name.equals(doctor.getName())) {
                return doctor;
            }
        }
        return null;
    }

    public void findDoctor1() {
        int choice;
        System.out.println("===== Search doctor by name and id =====");
        System.out.println("U want to search by id or name (1 is id and 2 is name): ");
        choice = validate.checkIntRange(1, 2);
        if (choice == 1) {
            System.out.println("Input id to search: ");
            while (true) {
                try {
                    int id = Integer.parseInt(sc.nextLine());
                    if (finDoctor(id, null) != null) {
                        System.out.println("This is doctor u want: ");
                        System.out.println(finDoctor(id, null).toString());
                        break;
                    }
                    throw new Exception();
                } catch (Exception e) {
                    System.out.println("Doctor u want not exist!");
                    return;
                }
            }
        } else {
            System.out.println("Input name to search: ");
            while (true) {
                try {
                    String name = validate.checkInputString(1, 51);
                    if (finDoctor(0, name) != null) {
                        System.out.println("This is doctor u want: ");
                        System.out.println(finDoctor(0, name).toString());
                        break;
                    }
                    throw new Exception();
                } catch (Exception e) {
                    System.out.println("Doctor u want not exist!");
                    return;
                }
            }
        }
    }

    public void sortDoctorByDob() {
        Collections.sort(listDoctor, Comparator.comparing(p -> p.getDateOfBirth()));
        for (Doctor doctor : listDoctor) {
            System.out.println(doctor.toString());
        }
    }

    public void menu() {
        System.out.println("===== Doctor Management System =====");
        while (true) {
            System.out.println("1. Create a Doctor\n"
                    + "2. Edit a Doctor Information\n"
                    + "3. Delete a Doctor\n"
                    + "4. Search doctor by ID and by Name\n"
                    + "5. Sort doctor by DateOfBirth\n"
                    + "6. Exit!");
            System.out.println("Choose features u want: ");
            int choice = validate.checkIntRange(1, 6);
            switch (choice) {
                case 1:
                    addDoctor();
                    break;
                case 2:
                    editInformationDoctor();
                    break;
                case 3:
                    deleteDoctor();
                    break;
                case 4:
                    findDoctor1();
                    break;
                case 5:
                    sortDoctorByDob();
                    break;
                case 6:
                    System.out.println("Exit!!!");
                    return;
            }
        }
    }
}
