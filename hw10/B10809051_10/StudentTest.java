/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw10;

/**
 *
 * @author jenny
 */
public class StudentTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        System.out.println("******** MasterStudent ********");
        MasterStudent David = new MasterStudent("David Tsai", "M10009001", "Information Management",
        "Integrated Digital Service Lab", "Professor Lo", "EMBA", false);
        System.out.printf("Name: %s\n",David.getName());
        System.out.printf("Student ID: %s\n",David.getID());
        System.out.printf("Major: %s\n",David.getMajor());
        System.out.printf("Lab: %s\n",David.getLab());
        System.out.printf("Advisor: %s\n",David.getProfessor());
        System.out.printf("System: %s\n",David.getSystem());
        System.out.printf("Thesis: %s\n",David.getThesis());
        System.out.println("");
        
        System.out.println("******** PhDStudent ********");
        PhDStudent Peter = new PhDStudent("Peter Yang", "D10015001", "Computer Science",
        "Software Engineering Lab", "Professor Lee", true, false);
        System.out.printf("Name: %s\n",Peter.getName());
        System.out.printf("Student ID: %s\n",Peter.getID());
        System.out.printf("Major: %s\n",Peter.getMajor());
        System.out.printf("Lab: %s\n",Peter.getLab());
        System.out.printf("Advisor: %s\n",Peter.getProfessor());
        System.out.printf("Qualify: %s\n",Peter.getQualify());
        System.out.printf("Dissertation: %s\n",Peter.getDissertation());
        System.out.println("");
        
        System.out.println("******** FullTimeStudent ********");
        FullTimeStudent Jack = new FullTimeStudent("Jack Chen", "B10005001", "Construction Engineering",
        "Sophmore", "class A", "Baseball Club", "Leader");
        System.out.printf("Name: %s\n",Jack.getName());
        System.out.printf("Student ID: %s\n",Jack.getID());
        System.out.printf("Major: %s\n",Jack.getMajor());
        System.out.printf("Grade: %s\n",Jack.getGrade());
        System.out.printf("Class: %s\n",Jack.getClasses());
        System.out.printf("Club: %s\n",Jack.getClub());
        System.out.printf("Role: %s\n",Jack.getRole());
        System.out.println("");
        
        System.out.println("******** PartTimeStudent ********");
        PartTimeStudent Michelle = new PartTimeStudent("Michele Lin", "B10008001", "Business Administration",
        "Freshman", "class B", "7-ELEVEN", "Clerk");
        System.out.printf("Name: %s\n",Michelle.getName());
        System.out.printf("Student ID: %s\n",Michelle.getID());
        System.out.printf("Major: %s\n",Michelle.getMajor());
        System.out.printf("Grade: %s\n",Michelle.getGrade());
        System.out.printf("Class: %s\n",Michelle.getClasses());
        System.out.printf("Company: %s\n",Michelle.getCompany());
        System.out.printf("Position: %s\n",Michelle.getPosition());
        System.out.println("");
    }
    
}
