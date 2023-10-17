package coding.mentor.service;

import coding.mentor.data.Course;
import coding.mentor.data.Mentor;
import coding.mentor.database.Database;

public class CourseService {
	
	public void showAllCourses() {
		
		for (int i = 0; i < Database.COURSES_DB.size(); i++) {
			System.out.print(i+1 + "." + Database.COURSES_DB.get(i).getName());
			for (Mentor mentor : Database.COURSES_DB.get(i).getTeachingMentors()) {
				System.out.print(" --- mentor name : " + mentor.getName());
			}
		System.out.println();
		}
	}
	
	public static void showCourseDetails(Course selectedCourse) {
		System.out.println("Course : " + selectedCourse.getName());
		for (Mentor mentor : selectedCourse.getTeachingMentors()) {
			System.out.print(" --- mentor name : " + mentor.getName());
		}
	System.out.println("Begin date : " + selectedCourse.getBegin());
	System.out.println("End date : " + selectedCourse.getEnd());
	System.out.println("Fee : " + selectedCourse.getFee());
			
		}
	
	
	public static void showMentorsByCourse(Course course) {
		System.out.println("Mentor Details : " + course.getName() + "as below : ");
		for (Mentor mentor : course.getTeachingMentors()) {
			System.out.println("Name : " + mentor.getName());
			System.out.println("Phone : " + mentor.getPhone());
			System.out.println("Email : " + mentor.getEmail());
		}
		
	} 
	
}
