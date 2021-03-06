/**
 * The Student class represents a student in a educational system.
 * It hold the details of a student.
 *
 * @author Julian Rios
 * @version 2017.11.07
 */

public class Student
{
  // the student's first name
  private String firstName;
  // the student's last name
  private String lastName;
  // the student's id
  private String studentID;

  /**
   * Create a new student with a given name and ID number.
   */
  public Student(String first, String last, String id)
  {
      String fullName;
      firstName = first;
      lastName = last;
      studentID = id;
  }

  /**
   * Return the full name of this student.
   */
  public String getName()
  {
      return firstName + " " + lastName;
  }

  /**
   * Return the student ID of this student.
   */
  public String getStudentID()
  {
     return studentID;
  }

  /**
   * Return the student's name and ID number.
   */
  public String printDetails()
  {
      return firstName + " " + lastName + ", Student ID: " + studentID;
  }
}
