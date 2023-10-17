package coding.mentor.service;

import java.util.ArrayList;

import coding.mentor.data.Course;
import coding.mentor.data.User;
import coding.mentor.database.Database;

public class UserService {

	public static void registerNewUser(String id, String password, String name) {

		User user = new User(id, password, name);

		Database.USERS_DB.add(user);
		System.out.println("Register successfully!");
		System.out.println("Welcome " + user.getName());

//		for (int i = 0; i < Database.USERS_DB.size(); i++) {
//			if (Database.USERS_DB.get(i).getId().equals(id)) {
//				System.out.println("This account already exists, please try again");
//			}
//
//		}
	}

	public static User login(String id, String password) {
		for (User user : Database.USERS_DB) {
			if (user.getId().equals(id) && user.getPassword().equals(password)) {
				System.out.println("Log in successfully");
				return user;
				
			}
		}
		return null;
	}

	public static void showResgisteredCoursesbyUser(User user) {

		ArrayList<Course> registeredCourses = user.getRegisteredCourses();

		if (registeredCourses == null) {
			System.out.println("No course is registered");
			return;
		}

		for (Course course : registeredCourses) {
			System.out.println("Registered Courses :" + course.getName());

		}
	}

	public static void registerNewCourse(int id, User user) {
		user.getRegisteredCourses();
		System.out.println("Course register successfully!");

	}

}
