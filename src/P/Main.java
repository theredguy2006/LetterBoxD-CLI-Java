package P;

import P.*;
import java.sql.*;
import java.util.*;

class Main {
    Connection mcon;

    public Main(Connection mcon) {
        this.mcon = mcon;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String driverName = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/letterboxd";
        String dbUser = "root";
        String dbPass = "";
        Class.forName(driverName);
        Connection con = DriverManager.getConnection(dbURL, dbUser,
                dbPass);
        if (con != null) {
            System.out.println("DB Connection Success");
        } else {
            System.out.println("Connection Failed. ..");
        }
        Admin a = new Admin(con);
        Main m = new Main(con);
        System.out.println(" Please Enter your user name ");
        String u_name = sc.nextLine();
        System.out.println(" Please Enter your Password  ");
        String Password = sc.nextLine();
        searchBST sBst = new searchBST(con);
        sll uSll = new sll(con);
        Trending t = new Trending(con);
        if (u_name.equalsIgnoreCase("admin") && Password.equalsIgnoreCase("admin")) {
            System.out.println("Admin");
            a.adminPrivelages();
        } else if (u_name.equalsIgnoreCase("new") && Password.equalsIgnoreCase("new")) {
            System.out.println("Registering a new user...");

            System.out.println("Please enter your desired username:");
            String newUserName = sc.nextLine();

            String newEmail;
            do {
                System.out.println("Please enter your email (must end with @gmail.com):");
                newEmail = sc.nextLine();

                if (!newEmail.endsWith("@gmail.com")) {
                    System.out.println("Invalid email! Please enter a valid Gmail address.");
                }
            } while (!newEmail.endsWith("@gmail.com"));

            System.out.println("Please enter your password:");
            String newPassword = sc.nextLine();

            int watchedCount = 0;

            String sql = "INSERT INTO user (u_name, u_email, u_pw, u_watched) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, newUserName);
            ps.setString(2, newEmail);
            ps.setString(3, newPassword);
            ps.setInt(4, watchedCount);

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("User registered successfully!");

                User newUser = new User(con, newUserName, newPassword);
                newUser.userOptions();
            } else {
                System.out.println("User registration failed. Please try again.");
            }

        } else if (m.isValidUser(u_name, Password)) {
            User u = new User(con, u_name, Password);
            u.userOptions();
        } else {
            System.out.println("Please Try Again ");
        }
    }

    public boolean isValidUser(String username, String password) throws Exception {
        String query = "SELECT * FROM user WHERE u_name = ?";
        PreparedStatement pstmt = mcon.prepareStatement(query);
        pstmt.setString(1, username);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            String email = rs.getString("u_email");

            // Check if the password entered is "forgot"
            if (password.equalsIgnoreCase("forgot")) {

                System.out.println("A reset code has been sent to your email address.");

                Scanner sc = new Scanner(System.in);
                System.out.println("Please enter the reset code:");
                String enteredCode = sc.nextLine();

                if (enteredCode.equals("1234")) {
                    System.out.println("Code verified. Please enter your new password:");
                    String newPassword = sc.nextLine();

                    String updateQuery = "UPDATE user SET u_pw = ? WHERE u_name = ?";
                    PreparedStatement updatePstmt = mcon.prepareStatement(updateQuery);
                    updatePstmt.setString(1, newPassword);
                    updatePstmt.setString(2, username);
                    int rowsUpdated = updatePstmt.executeUpdate();

                    if (rowsUpdated > 0) {
                        System.out.println("Your password has been updated successfully.");
                        return true;
                    } else {
                        System.out.println("Password update failed. Please try again.");
                        return false;
                    }
                } else {
                    System.out.println("Invalid reset code. Please try again.");
                    return false;
                }
            } else {

                String storedPassword = rs.getString("u_pw");
                if (storedPassword.equals(password)) {
                    return true;
                }
            }
        }

        return false;
    }

}