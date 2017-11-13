import java.util.ArrayList;
import java.util.Iterator;
/**
 * This registrar class represents a registrar in a educational system.
 * This class hold the details of a registrar.
 *
 * @author Julian Rios
 * @version 2017.11.07
 */
 public class registrar
 {
   // collection of courses offered
   private ArrayList<Course> courses;

   /**
    * Create a new registrar with an empty collection of courses.
    */
   public registrar()
   {
     courses = new ArrayList<>();
   }

   /**
   * Add a course to the collection.
   */
   public void addCourse(Course newCourse)
   {
     courses.add(newCourse);
   }

   /**
   * Remove a course from the collection.
   */
   public void removeCourse(Course courseToRemove)
   {
     courses.remove(courseToRemove);
   }

   /**
   * Print a list of all the courses offered.
   */
   public void printAll()
   {
     for(Course course : courses)
     {
       System.out.println(course.getCourseID());
     }
   }

   /**
   * Print a list of all the courses not at capacity.
   */
   public void printAvailable()
   {
     for(Course course : courses)
     {
        if(course.numRegistered() < course.checkCapacity())
        {
           System.out.println(course.getCourseID());
        }
        
        else
        {
           System.out.println(course.getCourseID() +": "+ "This course is at capacity.");
        }
     }
   }

   
  /**
  * Search the course collection for a specific course.
  * Private methods are only accessible from within the class.
  */
  private String searchCourse(String courseID)
  {
    int index = 0;
    boolean notFound = true;
    Course nextCourse = courses.get(index);
    while(notFound && index < courses.size())
    {
      if(nextCourse.getCourseID().equals(courseID))
      {
      notFound = false;
      }
      else
      {
      index++;
      }
    }
    if(notFound)
    {
      return "-1";
    }
    else
    {
      return nextCourse.getCourseID();
    }
  }

  // /**
  // * Registrar new student to a course.
  // */
  // public void registerStudent(Student registerStudent)
  // {
      // courses.add(registerStudent);
      // }

  // /**
  // * Unregistrar a student from a course.
  // * Checks if student is registrared to the course before removing.
  // */
  // public void unregisterStudent(String studentToRemove)
  // {
    // Course nextCourse;
    // Iterator<Course> it = courses.iterator();
    // while(it.hasNext())
    // {
      // nextCourse = it.next();
      // if(nextCourse.getCourseID().equals(studentToRemove))
      // {
        // it.remove();
      // }
      // else
      // {
      // }
    // }
  // }

  /**
  * Print a list of all the students registered for a course.
  */
  public void printStudentList()
  {
      int index = 0;
      Course searchCourse = courses.get(index);
      Iterator<Course> it = courses.iterator();
      while(it.hasNext())
      {
        searchCourse = it.next();
        System.out.println(searchCourse.getCourseID());
        searchCourse.printStudentList();
      }
  }

  // /**
  // * Print a specified student's schedule
  // */
  // public void printStudentSchedule()
  // {
      // Course searchCourse;
      // Student students;
      // Iterator<Course> it = courses.iterator();
      // while(it.hasNext())
      // {
        // searchCourse = it.next();
        // System.out.println(searchCourse.getCourseID());
      // }
      // }
}
