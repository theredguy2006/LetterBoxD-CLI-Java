package P;

import P.*;
import java.sql.*;
import java.util.*;

public class Admin {
    Admin a;
    Main m;
    Connection acon;
    sll uSll;

    public Admin(Connection con) {
        acon = con;
    }

    public void adminPrivelages() throws Exception {
        Boolean apb = true; // Admin Privelages Boolean
        Scanner sc = new Scanner(System.in);
        uSll = new sll(acon);
        uSll.insert();
        while (apb) {
            System.out.println("Select what you want to do ");
            System.out.println("Press 1.) To add a movie in database ");
            System.out.println("Press 2.) To delete a movie from databse ");
            System.out.println("Press 3.) To add a new User ");
            System.out.println("Press 4.) To delete a user ");
            System.out.println("Press 5.)  To change a user's password   ");
            System.out.println("Press 6.)  To View all movies   ");
            System.out.println("Press 7.)  To Search a User By Id  ");
            System.out.println("Press 8.)  To Exit ");
            int aps = sc.nextInt(); // Admin Privelages Boolean
            sc.nextLine();
            switch (aps) {
                case 1:
                    System.out.println("Enter Movie Name ");
                    String Mname = sc.nextLine();
                    System.out.println("Enter Director  Name ");
                    String Dname = sc.nextLine();
                    System.out.println("Enter Release Date in Format yyyy-mm-dd ");
                    String date = sc.nextLine();
                    System.out.println(" Taking Rating to be 0 for now ");
                    int rating = 0;
                    addMovies(Mname, Dname, date, rating);

                    break;
                case 2:
                    System.out.println("Enter Movie Id to delete  ");
                    int id = sc.nextInt();
                    delMovie(id);

                    break;
                case 3:
                    System.out.println("Enter User Name ");
                    String u_name = sc.nextLine();
                    System.out.println("Enter User Email");
                    String u_mail = sc.nextLine();
                    System.out.println("Enter " + u_name + "'s password");
                    String u_pw = sc.nextLine();
                    break;
                case 4:
                    System.out.println("Enter User Id to delete  ");
                    int u_id = sc.nextInt();
                    delMovie(u_id);

                    break;
                case 5:
                    System.out.println("Enter user id ");
                    int u_id2 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter New User Password ");
                    String u_pw2 = sc.nextLine();
                    changePW(u_id2, u_pw2);

                    break;
                case 6:
                    System.out.println("You selected view all movies");
                    viewAll();
                    break;
                case 7:
                    System.out.println("Enter a User to seach By Id ");
                    int u_id3 = sc.nextInt();
                    System.out.println("User you searched for " + uSll.getUser(u_id3));
                    break;
                case 8:
                    System.out.println("Bye !!!!");
                    apb = false;
                default:
                    System.out.println("Input Not Registered Please Select From above given options ");
                    break;
            }
        }

    }

    public void addMovies(String Mname, String Dname, String Date, int rating) throws Exception {
        // Date d = valueOf(Date);
        String sql = "insert into movie values(?,?,?,?)";
        PreparedStatement pst = acon.prepareStatement(sql);
        pst.setString(1, Mname);
        pst.setString(2, Dname);
        pst.setString(3, Date);
        pst.setInt(4, rating);
        boolean adm;
        if (adm = pst.execute()) {
            System.out.println("Movie Inserted Succesfully");
        } else {
            System.out.println(" Movie not inserted please check input ");
        }

    }

    public void viewAll() throws Exception {
        String sql = "select * from movie ";
        PreparedStatement pst = acon.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {

            System.out.println("Movie Id ---->" + rs.getInt(1));
            System.out.println("Movie Name ---->" + rs.getString(2));
            System.out.println("Director ---->" + rs.getString(3));
            System.out.println("Movie Release Date ---->" + rs.getString(4));
            System.out.println("Movie Rating---->" + rs.getInt(5));
        }

    }

    public void delMovie(int id) throws Exception {
        String checkSql = "SELECT id FROM movie WHERE id = ?";
        PreparedStatement checkPst = acon.prepareStatement(checkSql);
        checkPst.setInt(1, id);
        ResultSet rs = checkPst.executeQuery();
        if (rs.next()) {
            String sql = "DELETE FROM movie WHERE id = ?";
            PreparedStatement pst = acon.prepareStatement(sql);
            pst.setInt(1, id);
            int rowsDeleted = pst.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Movie deleted successfully.");
            } else {
                System.out.println("Movie not deleted due to an unknown error.");
            }
        } else {
            System.out.println("Movie with ID " + id + " does not exist. Please check the Movie ID.");
        }
    }

    public void addUser(String u_name, String u_mail, String u_pw) throws Exception {
        // Date d = valueOf(Date);
        String sql = "insert into user values(?,?,?,?)";
        PreparedStatement pst = acon.prepareStatement(sql);
        pst.setString(1, u_name);
        pst.setString(2, u_mail);
        pst.setString(3, u_pw);
        pst.setInt(4, 0);
        boolean adm;
        if (adm = pst.execute()) {
            System.out.println("User Enrolled Succesfully");
        } else {
            System.out.println(" User not Enrolled please check input ");
        }

    }

    public void delUser(int u_id) throws Exception {
        String checkSql = "SELECT id FROM user WHERE id = ?";
        PreparedStatement checkPst = acon.prepareStatement(checkSql);
        checkPst.setInt(1, u_id);
        ResultSet rs = checkPst.executeQuery();
        if (rs.next()) {
            String sql = "DELETE FROM user WHERE id = ?";
            PreparedStatement pst = acon.prepareStatement(sql);
            pst.setInt(1, u_id);
            int rowsDeleted = pst.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("User deleted successfully.");
            } else {
                System.out.println("User not deleted due to an unknown error.");
            }
        } else {
            System.out.println("User with ID " + u_id + " does not exist. Please check the User ID.");
        }
    }

    public void changePW(int u_id, String newPassword) throws Exception {

        String checkSql = "SELECT u_id FROM user WHERE u_id = ?";
        PreparedStatement checkPst = acon.prepareStatement(checkSql);
        checkPst.setInt(1, u_id);
        ResultSet rs = checkPst.executeQuery();

        if (rs.next()) {

            String updateSql = "UPDATE user SET u_pw = ? WHERE u_id = ?";
            PreparedStatement updatePst = acon.prepareStatement(updateSql);
            updatePst.setString(1, newPassword);
            updatePst.setInt(2, u_id);

            int rowsUpdated = updatePst.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("User's password updated successfully for ID: " + u_id);
            } else {
                System.out.println("Password update failed.");
            }
        } else {
            System.out.println("User ID not found. Please check the User ID.");
        }
    }

}
