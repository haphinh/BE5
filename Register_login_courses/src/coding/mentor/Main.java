package coding.mentor;

import java.util.Scanner;

import coding.mentor.data.Course;
import coding.mentor.data.User;
import coding.mentor.database.Database;
import coding.mentor.service.CourseService;
import coding.mentor.service.UserService;

public class Main {
	static final int DO_LOGIN_MENU = 1;
	static final int DO_REGISTER_MENU = 2;
	static final int REGISTER_NEW_COURSE = 1;
	static final int EXIT = 2;
	static final int VIEW_MENTOR_DETAILS = 3;

	public static void main(String[] args, Course course) {
		Scanner scanner = new Scanner(System.in);
		CourseService courseService = new CourseService();
		UserService userService = new UserService();
		User user = new User();
		User currentUser = null;
		int selectedCourse = 0;
	

		Database.initDB();

		// Log in and register menu

		do {
			System.out.println("----- Welcome To Coding Mentor -----");
			System.out.println("1. Login");
			System.out.println("2. Register");
			int choose = scanner.nextInt();
			
			switch (choose) {
			case DO_LOGIN_MENU:
				System.out.println("Enter ID: ");
				String loginId = scanner.nextLine();
				System.out.println("Enter password: ");
				String loginPassword = scanner.nextLine();

				currentUser = UserService.login(loginId, loginPassword);

				if (currentUser != null) {

					do {
						System.out.println("----------------- ");
						System.out.println("0. Show my registered courses");
						courseService.showAllCourses();

						System.out.println("Select your option: ");
						selectedCourse = scanner.nextInt();

						if (selectedCourse == 0) {
							UserService.showResgisteredCoursesbyUser(currentUser);
							break;
						}
					
						System.out.println("1. Register");
						System.out.println("2. NO");
						System.out.println("3. View mentor details");
						int userOption = scanner.nextInt();

						switch (userOption) {

						case REGISTER_NEW_COURSE:
							UserService.registerNewCourse(selectedCourse, currentUser);
							break;

						case EXIT:
							System.out.println("GOOD BYE!");
							break;

						case VIEW_MENTOR_DETAILS:

							CourseService.showMentorsByCourse(course);
							break;

						}

					} while (selectedCourse != 0);

				}
				break; 

			case DO_REGISTER_MENU:
				System.out.println("----- Register Form -----");
				System.out.println("Input ID: ");
				String id = scanner.nextLine();
				System.out.println("Input password: ");
				String password = scanner.nextLine();
				System.out.println("Input name: ");
				String name = scanner.nextLine();

				UserService.registerNewUser(id, password, name);
			}

		} while (currentUser == null);

	}
}
