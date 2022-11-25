package Person;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Person {
    static Scanner input = new Scanner(System.in);
    private String name, gender, address, email, phoneNumber;
    private Integer age;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Person(String name, String gender, String address, String email, Integer age, String phoneNumber) {
        super();
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public Person() {
        super();
    }
    public void Add() {
        try {
            System.out.print("Nhập họ tên: ");
            setName(input.nextLine());

            do {
                System.out.print("Nhập tuổi: ");
                setAge(input.nextInt());
            } while (age < 0);

            do {
                input.nextLine();
                System.out.print("Nhập giới tính: ");
                setGender(input.nextLine());
            } while (!gender.equalsIgnoreCase("nam") && !gender.equalsIgnoreCase("nu"));

            System.out.print("Nhập địa chỉ: ");
            setAddress(input.nextLine());

            System.out.print("Nhập Email: ");
            setEmail(input.nextLine());

            System.out.print("Nhập số điện thoại: ");
            setPhoneNumber(input.nextLine());

        } catch (InputMismatchException ie) {
            System.out.println("Nhập giá trị không hợp lệ, vui lòng nhập lại!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
