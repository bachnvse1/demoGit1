/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validate;

import Entity.Doctor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ADMIN
 */
public class Validate {

    public static Scanner sc = new Scanner(System.in);

    public int checkIntRange(int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(sc.nextLine());
                if (input < min || input > max) {
                    throw new Exception();
                }
                return input;
            } catch (Exception e) {
                System.err.println("Enter input number range " + min + "-" + max);
                System.out.print("Enter again: ");
            }
        }
    }

    public boolean containsNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            // Sử dụng phương thức isDigit() để kiểm tra xem ký tự có phải là số hay không
            if (Character.isDigit(s.charAt(i))) {
                return true; // Nếu có ít nhất một số, trả về true
            }
        }
        return false; // Nếu không có số nào, trả về false
    }

    public String checkInputString(int min, int max) {
        while (true) {
            String input = sc.nextLine().trim();
            if (input.length() < min || input.length() > max || containsNumber(input)) {
                System.err.println("Error!");
                System.out.print("Enter again: ");
            } else {
                return input;
            }
        }
    }

    public int checkInputInt() {
        double input;
        while (true) {
            try {
                input = Double.parseDouble(sc.nextLine().trim());
                if ((int) input == (double) input) {
                    return (int) input;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("Enter number integer!");
                System.out.print("Enter again: ");
            }
        }
    }

    public boolean checkCodeExist(ArrayList<Doctor> list, int code) {
        for (Doctor doctor : list) {
            if (code == doctor.getID()) {
                return false;
            }
        }
        return true;
    }

    public boolean checkDob(String input) {
        String format = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);
        while (true) {
            try {
                Date date = sdf.parse(input);
                return true;
            } catch (ParseException e) {
                return false;
            }
        }
    }

    public boolean checkEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

}
