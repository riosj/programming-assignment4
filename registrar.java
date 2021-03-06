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
   // instance of a student object
   private Student students;
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

  /**
  * Registrar new student to a course.
  */
  public void registerStudent(Course course, Student registerStudent)
  {
    Course registerCourse = course;
    if(registerStudent != null)
    {
      registerCourse.addStudent(registerStudent);
    }
  }

  /**
  * Unregistrar a student from a course.
  */
  public void unregisterStudent(Course course, Student unregisterStudent)
  {
    Course unregisterCourse = course;
    if(unregisterStudent != null)
    {
      unregisterCourse.removeStudent(unregisterStudent);
    }
  }

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
        System.out.println("Below is the class list for: " + searchCourse.getCourseID());
        searchCourse.printStudentList();
      }
  }

  /**
  * Print a specified student's schedule
  */
  public void printStudentSchedule(String studentIDNum)
  {
   int index = 0;
   Course checkCourse = courses.get(index);
   Iterator<Course> it = courses.iterator();
   while(it.hasNext())
   {
       if(checkCourse.searchStudent(studentIDNum) != null)
       {
         checkCourse = it.next();
         System.out.println(checkCourse.getCourseID());
       }
       else
       {
           System.out.println("You are not registered for: " + checkCourse.getCourseID());
       }
   }
  }
}
