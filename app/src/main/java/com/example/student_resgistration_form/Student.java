package com.example.student_resgistration_form;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {
    public String id;
    public String firstName;
    public String middleName;
    public String lastName;
    public String age;
    public String dateOfBirth;
    public String maritalStatus;
    public String nationality;
    public String religion;
    public String studentAddress;
    public String studentPhoneNUm;
    public String studentEmail;
    public String tribe;
    public String sponsorName;
    public String parentOrGuardian;
    public String sponsorAddress;
    public String sponsorPhoneNumber;
    public String sponsorEmail;
    public String firstPriority;
    public String secondPriority;
    public String thirdPriority;

    public Student() {
        //empty constructor
    }

    public Student(String id, String firstName, String middleName, String lastName, String age, String dateOfBirth, String maritalStatus, String nationality, String religion, String studentAddress, String studentPhoneNUm, String studentEmail, String tribe, String sponsorName, String parentOrGuardian, String sponsorAddress, String sponsorPhoneNumber, String sponsorEmail, String firstPriority, String secondPriority, String thirdPriority) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.maritalStatus = maritalStatus;
        this.nationality = nationality;
        this.religion = religion;
        this.studentAddress = studentAddress;
        this.studentPhoneNUm = studentPhoneNUm;
        this.studentEmail = studentEmail;
        this.tribe = tribe;
        this.sponsorName = sponsorName;
        this.parentOrGuardian = parentOrGuardian;
        this.sponsorAddress = sponsorAddress;
        this.sponsorPhoneNumber = sponsorPhoneNumber;
        this.sponsorEmail = sponsorEmail;
        this.firstPriority = firstPriority;
        this.secondPriority = secondPriority;
        this.thirdPriority = thirdPriority;
    }

    protected Student(Parcel in) {
        id =in.readString();
        firstName = in.readString();
        middleName = in.readString();
        lastName = in.readString();
        age = in.readString();
        dateOfBirth = in.readString();
        maritalStatus = in.readString();
        nationality = in.readString();
        religion = in.readString();
        studentAddress = in.readString();
        studentPhoneNUm = in.readString();
        studentEmail = in.readString();
        tribe = in.readString();
        sponsorName = in.readString();
        parentOrGuardian = in.readString();
        sponsorAddress = in.readString();
        sponsorPhoneNumber = in.readString();
        sponsorEmail = in.readString();
        firstPriority = in.readString();
        secondPriority = in.readString();
        thirdPriority = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }


    public void setAge(String age) {
        this.age = age;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentPhoneNUm() {
        return studentPhoneNUm;
    }

    public void setStudentPhoneNUm(String studentPhoneNUm) {
        this.studentPhoneNUm = studentPhoneNUm;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getTribe() {
        return tribe;
    }

    public void setTribe(String tribe) {
        this.tribe = tribe;
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    public String getParentOrGuardian() {
        return parentOrGuardian;
    }

    public void setParentOrGuardian(String parentOrGuardian) {
        this.parentOrGuardian = parentOrGuardian;
    }

    public String getSponsorAddress() {
        return sponsorAddress;
    }

    public void setSponsorAddress(String sponsorAddress) {
        this.sponsorAddress = sponsorAddress;
    }

    public String getSponsorPhoneNumber() {
        return sponsorPhoneNumber;
    }

    public void setSponsorPhoneNumber(String sponsorPhoneNumber) {
        this.sponsorPhoneNumber = sponsorPhoneNumber;
    }

    public String getSponsorEmail() {
        return sponsorEmail;
    }

    public void setSponsorEmail(String sponsorEmail) {
        this.sponsorEmail = sponsorEmail;
    }

    public String getFirstPriority() {
        return firstPriority;
    }

    public void setFirstPriority(String firstPriority) {
        this.firstPriority = firstPriority;
    }

    public String getSecondPriority() {
        return secondPriority;
    }

    public void setSecondPriority(String secondPriority) {
        this.secondPriority = secondPriority;
    }

    public String getThirdPriority() {
        return thirdPriority;
    }

    public void setThirdPriority(String thirdPriority) {
        this.thirdPriority = thirdPriority;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(firstName);
        parcel.writeString(middleName);
        parcel.writeString(lastName);
        parcel.writeString(age);
        parcel.writeString(dateOfBirth);
        parcel.writeString(maritalStatus);
        parcel.writeString(nationality);
        parcel.writeString(religion);
        parcel.writeString(studentAddress);
        parcel.writeString(studentPhoneNUm);
        parcel.writeString(studentEmail);
        parcel.writeString(tribe);
        parcel.writeString(sponsorName);
        parcel.writeString(parentOrGuardian);
        parcel.writeString(sponsorAddress);
        parcel.writeString(sponsorPhoneNumber);
        parcel.writeString(sponsorEmail);
        parcel.writeString(firstPriority);
        parcel.writeString(secondPriority);
        parcel.writeString(thirdPriority);
    }
}