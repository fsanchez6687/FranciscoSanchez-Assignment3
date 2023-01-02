
import java.io.IOException;
import java.util.Scanner;

public class UserValidation {
	public User[] users = new User[4]; 
	private UserService userService = new UserService();
	
	UserArrayService userArrayService = new UserArrayService();

	public static void main(String[] args) throws IOException {
		UserValidation validation = new UserValidation();
		validation.program();
		
	}
	
	public void program () throws IOException {
		
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			
			boolean Login = false;
			int l = 0;
			while (!Login && l < 5) {
				System.out.println("Enter your email: ");
				String username = scanner.nextLine();
				System.out.println("Enter your password: ");
				String password = scanner.nextLine();

				User validUser = userService.validateUser(username, password);
				if (validUser != null) {
					System.out.println("Welcome: " + validUser.getName());
					Login = true;
				} else {
					System.out.println("Invalid login, please try again");
					l++;
					if (l == 5) {
						System.out.println("Too many failed login attempts, you are now locked out.");
					}
				}
			}
		} finally {
			if (scanner != null)
				scanner.close();
		}
	
	}
}
