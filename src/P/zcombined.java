
// import java.sql.*;
// import java.util.*;

// class Main {
// Connection mcon;

// public Main(Connection mcon) {
// this.mcon = mcon;
// }

// public static void main(String[] args) throws Exception {
// Scanner sc = new Scanner(System.in);
// String driverName = "com.mysql.jdbc.Driver";
// String dbURL = "jdbc:mysql://localhost:3306/letterboxd";
// String dbUser = "root";
// String dbPass = "";
// Class.forName(driverName);
// Connection con = DriverManager.getConnection(dbURL, dbUser,
// dbPass);
// if (con != null) {
// System.out.println("DB Connection Success");
// } else {
// System.out.println("Connection Failed. ..");
// }
// Admin a = new Admin(con);
// Main m = new Main(con);
// System.out.println(" Please Enter your user name ");
// String u_name = sc.nextLine();
// System.out.println(" Please Enter your Password ");
// String Password = sc.nextLine();
// searchBST sBst = new searchBST(con);
// sll uSll = new sll(con);
// Trending t = new Trending(con);
// if (u_name.equalsIgnoreCase("admin") && Password.equalsIgnoreCase("admin")) {
// System.out.println("Admin");
// a.adminPrivelages();
// } else if (u_name.equalsIgnoreCase("new") &&
// Password.equalsIgnoreCase("new")) {
// System.out.println("Registering a new user...");

// System.out.println("Please enter your desired username:");
// String newUserName = sc.nextLine();

// String newEmail;
// do {
// System.out.println("Please enter your email (must end with @gmail.com):");
// newEmail = sc.nextLine();

// if (!newEmail.endsWith("@gmail.com")) {
// System.out.println("Invalid email! Please enter a valid Gmail address.");
// }
// } while (!newEmail.endsWith("@gmail.com"));

// System.out.println("Please enter your password:");
// String newPassword = sc.nextLine();

// int watchedCount = 0;

// String sql = "INSERT INTO user (u_name, u_email, u_pw, u_watched) VALUES (?,
// ?, ?, ?)";

// PreparedStatement ps = con.prepareStatement(sql);
// ps.setString(1, newUserName);
// ps.setString(2, newEmail);
// ps.setString(3, newPassword);
// ps.setInt(4, watchedCount);

// int rowsInserted = ps.executeUpdate();
// if (rowsInserted > 0) {
// System.out.println("User registered successfully!");

// User newUser = new User(con, newUserName, newPassword);
// newUser.userOptions();
// } else {
// System.out.println("User registration failed. Please try again.");
// }

// } else if (m.isValidUser(u_name, Password)) {
// User u = new User(con, u_name, Password);
// u.userOptions();
// } else {
// System.out.println("Please Try Again ");
// }
// }

// public boolean isValidUser(String username, String password) throws Exception
// {
// String query = "SELECT * FROM user WHERE u_name = ?";
// PreparedStatement pstmt = mcon.prepareStatement(query);
// pstmt.setString(1, username);
// ResultSet rs = pstmt.executeQuery();

// if (rs.next()) {
// String email = rs.getString("u_email");

// // Check if the password entered is "forgot"
// if (password.equalsIgnoreCase("forgot")) {

// System.out.println("A reset code has been sent to your email address.");

// Scanner sc = new Scanner(System.in);
// System.out.println("Please enter the reset code:");
// String enteredCode = sc.nextLine();

// if (enteredCode.equals("1234")) {
// System.out.println("Code verified. Please enter your new password:");
// String newPassword = sc.nextLine();

// String updateQuery = "UPDATE user SET u_pw = ? WHERE u_name = ?";
// PreparedStatement updatePstmt = mcon.prepareStatement(updateQuery);
// updatePstmt.setString(1, newPassword);
// updatePstmt.setString(2, username);
// int rowsUpdated = updatePstmt.executeUpdate();

// if (rowsUpdated > 0) {
// System.out.println("Your password has been updated successfully.");
// return true;
// } else {
// System.out.println("Password update failed. Please try again.");
// return false;
// }
// } else {
// System.out.println("Invalid reset code. Please try again.");
// return false;
// }
// } else {

// String storedPassword = rs.getString("u_pw");
// if (storedPassword.equals(password)) {
// return true;
// }
// }
// }

// return false;
// }

// }
// public class Admin {
// Admin a;
// Main m;
// Connection acon;
// sll uSll;

// public Admin(Connection con) {
// acon = con;
// }

// public void adminPrivelages() throws Exception {
// Boolean apb = true; // Admin Privelages Boolean
// Scanner sc = new Scanner(System.in);
// uSll = new sll(acon);
// uSll.insert();
// while (apb) {
// System.out.println("Select what you want to do ");
// System.out.println("Press 1.) To add a movie in database ");
// System.out.println("Press 2.) To delete a movie from databse ");
// System.out.println("Press 3.) To add a new User ");
// System.out.println("Press 4.) To delete a user ");
// System.out.println("Press 5.) To change a user's password ");
// System.out.println("Press 6.) To View all movies ");
// System.out.println("Press 7.) To Search a User By Id ");
// System.out.println("Press 8.) To Exit ");
// int aps = sc.nextInt(); // Admin Privelages Boolean
// sc.nextLine();
// switch (aps) {
// case 1:
// System.out.println("Enter Movie Name ");
// String Mname = sc.nextLine();
// System.out.println("Enter Director Name ");
// String Dname = sc.nextLine();
// System.out.println("Enter Release Date in Format yyyy-mm-dd ");
// String date = sc.nextLine();
// System.out.println(" Taking Rating to be 0 for now ");
// int rating = 0;
// addMovies(Mname, Dname, date, rating);

// break;
// case 2:
// System.out.println("Enter Movie Id to delete ");
// int id = sc.nextInt();
// delMovie(id);

// break;
// case 3:
// System.out.println("Enter User Name ");
// String u_name = sc.nextLine();
// System.out.println("Enter User Email");
// String u_mail = sc.nextLine();
// System.out.println("Enter " + u_name + "'s password");
// String u_pw = sc.nextLine();
// break;
// case 4:
// System.out.println("Enter User Id to delete ");
// int u_id = sc.nextInt();
// delMovie(u_id);

// break;
// case 5:
// System.out.println("Enter user id ");
// int u_id2 = sc.nextInt();
// sc.nextLine();
// System.out.println("Enter New User Password ");
// String u_pw2 = sc.nextLine();
// changePW(u_id2, u_pw2);

// break;
// case 6:
// System.out.println("You selected view all movies");
// viewAll();
// break;
// case 7:
// System.out.println("Enter a User to seach By Id ");
// int u_id3 = sc.nextInt();
// System.out.println("User you searched for " + uSll.getUser(u_id3));
// break;
// case 8:
// System.out.println("Bye !!!!");
// apb = false;
// default:
// System.out.println("Input Not Registered Please Select From above given
// options ");
// break;
// }
// }

// }

// public void addMovies(String Mname, String Dname, String Date, int rating)
// throws Exception {
// // Date d = valueOf(Date);
// String sql = "insert into movie values(?,?,?,?)";
// PreparedStatement pst = acon.prepareStatement(sql);
// pst.setString(1, Mname);
// pst.setString(2, Dname);
// pst.setString(3, Date);
// pst.setInt(4, rating);
// boolean adm;
// if (adm = pst.execute()) {
// System.out.println("Movie Inserted Succesfully");
// } else {
// System.out.println(" Movie not inserted please check input ");
// }

// }

// public void viewAll() throws Exception {
// String sql = "select * from movie ";
// PreparedStatement pst = acon.prepareStatement(sql);
// ResultSet rs = pst.executeQuery();
// while (rs.next()) {

// System.out.println("Movie Id ---->" + rs.getInt(1));
// System.out.println("Movie Name ---->" + rs.getString(2));
// System.out.println("Director ---->" + rs.getString(3));
// System.out.println("Movie Release Date ---->" + rs.getString(4));
// System.out.println("Movie Rating---->" + rs.getInt(5));
// }

// }

// public void delMovie(int id) throws Exception {
// String checkSql = "SELECT id FROM movie WHERE id = ?";
// PreparedStatement checkPst = acon.prepareStatement(checkSql);
// checkPst.setInt(1, id);
// ResultSet rs = checkPst.executeQuery();
// if (rs.next()) {
// String sql = "DELETE FROM movie WHERE id = ?";
// PreparedStatement pst = acon.prepareStatement(sql);
// pst.setInt(1, id);
// int rowsDeleted = pst.executeUpdate();
// if (rowsDeleted > 0) {
// System.out.println("Movie deleted successfully.");
// } else {
// System.out.println("Movie not deleted due to an unknown error.");
// }
// } else {
// System.out.println("Movie with ID " + id + " does not exist. Please check the
// Movie ID.");
// }
// }

// public void addUser(String u_name, String u_mail, String u_pw) throws
// Exception {
// // Date d = valueOf(Date);
// String sql = "insert into user values(?,?,?,?)";
// PreparedStatement pst = acon.prepareStatement(sql);
// pst.setString(1, u_name);
// pst.setString(2, u_mail);
// pst.setString(3, u_pw);
// pst.setInt(4, 0);
// boolean adm;
// if (adm = pst.execute()) {
// System.out.println("User Enrolled Succesfully");
// } else {
// System.out.println(" User not Enrolled please check input ");
// }

// }

// public void delUser(int u_id) throws Exception {
// String checkSql = "SELECT id FROM user WHERE id = ?";
// PreparedStatement checkPst = acon.prepareStatement(checkSql);
// checkPst.setInt(1, u_id);
// ResultSet rs = checkPst.executeQuery();
// if (rs.next()) {
// String sql = "DELETE FROM user WHERE id = ?";
// PreparedStatement pst = acon.prepareStatement(sql);
// pst.setInt(1, u_id);
// int rowsDeleted = pst.executeUpdate();
// if (rowsDeleted > 0) {
// System.out.println("User deleted successfully.");
// } else {
// System.out.println("User not deleted due to an unknown error.");
// }
// } else {
// System.out.println("User with ID " + u_id + " does not exist. Please check
// the User ID.");
// }
// }

// public void changePW(int u_id, String newPassword) throws Exception {

// String checkSql = "SELECT u_id FROM user WHERE u_id = ?";
// PreparedStatement checkPst = acon.prepareStatement(checkSql);
// checkPst.setInt(1, u_id);
// ResultSet rs = checkPst.executeQuery();

// if (rs.next()) {

// String updateSql = "UPDATE user SET u_pw = ? WHERE u_id = ?";
// PreparedStatement updatePst = acon.prepareStatement(updateSql);
// updatePst.setString(1, newPassword);
// updatePst.setInt(2, u_id);

// int rowsUpdated = updatePst.executeUpdate();
// if (rowsUpdated > 0) {
// System.out.println("User's password updated successfully for ID: " + u_id);
// } else {
// System.out.println("Password update failed.");
// }
// } else {
// System.out.println("User ID not found. Please check the User ID.");
// }
// }

// }

// public class User {
// Admin a;
// Main m;
// String u_name;
// String Password;
// Connection ucon;
// Trending t;
// int u;
// searchBST st;

// public User(Connection ucon, String u_name, String password) {
// this.u_name = u_name;
// this.Password = password;
// this.ucon = ucon;
// }

// public int getUid(String u_name) throws Exception {
// String sql = "SELECT u_id FROM user WHERE u_name = ?";
// PreparedStatement ps = ucon.prepareStatement(sql);
// ps.setString(1, u_name);

// ResultSet rs = ps.executeQuery();
// int u = -1;

// if (rs.next()) {
// u = rs.getInt("u_id");
// }

// return u;
// }

// public void userOptions() throws Exception {
// st = new searchBST(ucon);
// st.insert();
// ucon.setAutoCommit(true);
// t = new Trending(ucon);
// Boolean apb = true; // Admin Privelages Boolean
// Scanner sc = new Scanner(System.in);
// while (apb) {
// System.out.println("Select what you want to do ");
// System.out.println("Press 1.) View All movies in database ");
// System.out.println("Press 2.) Search Movie by ID in Database");
// System.out.println("Press 3.) Create Watchlist Table ");
// System.out.println("Press 4.) Add Movie Into Watchlist Table");
// System.out.println("Press 5.) Remove Movie From Watchlist Or Mark as
// Watched");
// System.out.println("Press 6.) Show Trending Movies ");
// System.out.println("Press 7.) To Change Password ");
// System.out.println("Press 8.) Change Username ");
// System.out.println("Press 9.) Mark a Movie as Watched Directly");
// System.out.println("Press 10.) View Your Watchlists ");
// System.out.println("Press 11.) Delete Your Watchlists ");
// System.out.println("Press 12.) To View Movies You Have Watched ");
// System.out.println("Press 13.) To Exit ");

// int aps = sc.nextInt();
// sc.nextLine();
// switch (aps) {
// case 1:
// System.out.println("Viewing All Movies");
// viewAll();
// break;
// case 2:
// System.out.println("Enter Movie Id to search: ");
// int id = sc.nextInt();
// searchMovie(id);
// break;
// case 3:
// System.out.println("You Have selected to create a watchlist");
// System.out.println("Enter WatchList name: ");
// String w_name = sc.nextLine();
// createWatchlist(getUid(u_name), w_name);
// break;
// case 4:
// System.out.println("View Your Watchlists First ");
// viewYourWatchlists();
// System.out.println("Enter Movie(ID of the Movie) you want to enter: ");
// int movieToAdd = sc.nextInt();
// System.out.println("Enter watchlist ID to add movie to: ");
// int watchlistIdToAdd = sc.nextInt();
// addMovieToWatchlist(watchlistIdToAdd, movieToAdd);
// break;
// case 5:
// System.out.println("View Your Watchlists First ");
// viewYourWatchlists();
// System.out.println("Enter Movie(ID of the Movie) you want to Remove: ");
// int movieToRemove = sc.nextInt();
// System.out.println("Enter watchlist ID to remove movie from: ");
// int watchlistIdToRemoveFrom = sc.nextInt();
// System.out.println("Enter rating for the movie (1 to 10): ");
// int rating = sc.nextInt();
// watchedMovie(watchlistIdToRemoveFrom, movieToRemove, rating);
// break;
// case 6:
// System.out.println("Viewing Trending Movies");
// t.TrendingMovies();
// break;
// case 7:
// System.out.println("Changing Password");
// System.out.println("Your current password is " + Password);
// System.out.println("Please Enter New Password: ");
// String NPW = sc.nextLine();
// changePW(Password, NPW);
// break;
// case 8:
// System.out.println("Changing Username");
// System.out.println("Your current Username is " + u_name);
// System.out.println("Please Enter New Username: ");
// String nun = sc.nextLine();
// changeUN(u_name, nun);
// break;
// case 9:
// System.out.println("Marking a Movie as Watched Directly");
// manuallyMarkMovieAsWatched();

// break;
// case 10:
// System.out.println("Viewing Your Watchlists");
// viewYourWatchlists();
// break;
// case 11:
// System.out.println("Deleting Your Watchlists");
// System.out.print(" But View Your Watchlist first ");
// viewYourWatchlists();
// System.out.println("Enter Your Watchlist To Remove ");
// int watchlistIdToRemove = sc.nextInt();
// deleteWatchlist(watchlistIdToRemove);
// break;
// case 12:
// System.out.println("You Selected with all movies you have watched ");
// viewWatchedMovies(getUid(u_name));
// break;
// case 13:
// System.out.println("Exiting. Bye!");
// apb = false;
// break;
// default:
// System.out.println("Invalid input! Please select from the options above.");
// break;
// }
// }
// }

// public void viewAll() throws Exception {
// st.displayMovies();
// /*
// * String sql = "SELECT * FROM movie";
// * PreparedStatement pst = ucon.prepareStatement(sql);
// * ResultSet rs = pst.executeQuery();
// * while (rs.next()) {
// * System.out.print("Movie Id ----> " + rs.getInt(1));
// * System.out.print(" Movie Name ----> " + rs.getString(2));
// * System.out.print(" Director ----> " + rs.getString(3));
// * System.out.print(" Movie Release Date ----> " + rs.getString(4));
// * System.out.print(" Movie Rating----> " + rs.getInt(5));
// * System.out.println();
// * }
// */
// }

// public void searchMovie(int id) throws Exception {
// System.out.println(st.search(id));
// /*
// * String sql = "SELECT * FROM movie WHERE id = ?";
// * PreparedStatement ps = ucon.prepareStatement(sql);
// * ps.setInt(1, id);
// * ResultSet rs = ps.executeQuery();
// * while (rs.next()) {
// * System.out.print("Movie Id " + rs.getInt(1) + " Movie Name " +
// * rs.getString(2) + " Director's Name "
// * + rs.getString(3) + " Release Date " + rs.getString(4) + " Current Rating "
// +
// * rs.getInt(5));
// * System.out.println();
// * }
// */
// }

// public void createWatchlist(int userId, String watchlistName) throws
// Exception {
// String sql = "INSERT INTO watchlist (user_id, watchlist_name) VALUES (?, ?)";
// PreparedStatement ps = ucon.prepareStatement(sql);
// ps.setInt(1, userId);
// ps.setString(2, watchlistName);
// int rowsInserted = ps.executeUpdate();
// if (rowsInserted > 0) {
// System.out.println("Watchlist '" + watchlistName + "' created successfully
// for user ID: " + userId);
// } else {
// System.out.println("Failed to create watchlist.");
// }
// }

// public void addMovieToWatchlist(int watchlistId, int movieId) throws
// Exception {

// String checkWatchlistSql = "SELECT COUNT(*) FROM watchlist WHERE watchlist_id
// = ?";
// PreparedStatement checkPst = ucon.prepareStatement(checkWatchlistSql);
// checkPst.setInt(1, watchlistId);
// ResultSet rs = checkPst.executeQuery();

// if (rs.next() && rs.getInt(1) > 0) {

// String sql = "INSERT INTO watchlist_movie (watchlist_id, id) VALUES (?, ?)";
// PreparedStatement ps = ucon.prepareStatement(sql);
// ps.setInt(1, watchlistId);
// ps.setInt(2, movieId);
// int rowsInserted = ps.executeUpdate();

// if (rowsInserted > 0) {
// System.out.println(st.search(movieId) + " added to watchlist ID: " +
// watchlistId);
// } else {
// System.out.println("Failed to add movie to watchlist.");
// }
// } else {
// System.out.println("Watchlist ID: " + watchlistId + " does not exist.");
// }

// }

// public void removeMovieFromWatchlist(int watchlistId, int movieId) throws
// Exception {

// String checkMovieSql = "SELECT COUNT(*) FROM watchlist_movie WHERE
// watchlist_id = ? AND id = ?";
// PreparedStatement checkPs = ucon.prepareStatement(checkMovieSql);
// checkPs.setInt(1, watchlistId);
// checkPs.setInt(2, movieId);
// ResultSet checkRs = checkPs.executeQuery();

// if (checkRs.next() && checkRs.getInt(1) > 0) {

// String deleteSql = "DELETE FROM watchlist_movie WHERE watchlist_id = ? AND id
// = ?";
// PreparedStatement deletePs = ucon.prepareStatement(deleteSql);
// deletePs.setInt(1, watchlistId);
// deletePs.setInt(2, movieId);
// int rowsDeleted = deletePs.executeUpdate();

// if (rowsDeleted > 0) {
// System.out.println(st.search(movieId) + " removed from watchlist ID: " +
// watchlistId);
// } else {
// System.out.println("Failed to remove movie from watchlist.");
// }

// deletePs.close();
// } else {

// System.out.println("The movie does not exist in the specified watchlist or
// the watchlist is empty.");
// }

// }

// public void deleteWatchlist(int watchlistId) throws Exception {
// String verifyOwnershipSql = "SELECT COUNT(*) FROM watchlist WHERE
// watchlist_id = ? AND user_id = ?";
// int userId = getUid(u_name);
// boolean isOwner = false;

// try (PreparedStatement ps = ucon.prepareStatement(verifyOwnershipSql)) {
// ps.setInt(1, watchlistId);
// ps.setInt(2, userId);

// try (ResultSet rs = ps.executeQuery()) {
// if (rs.next()) {
// isOwner = rs.getInt(1) > 0;
// }
// }
// }

// if (!isOwner) {
// System.out.println("You do not have permission to delete this watchlist.");
// return;
// }

// String deleteMoviesSql = "DELETE FROM watchlist_movie WHERE watchlist_id =
// ?";
// try (PreparedStatement ps = ucon.prepareStatement(deleteMoviesSql)) {
// ps.setInt(1, watchlistId);
// ps.executeUpdate();
// }

// String deleteWatchlistSql = "DELETE FROM watchlist WHERE watchlist_id = ? AND
// user_id = ?";
// try (PreparedStatement ps = ucon.prepareStatement(deleteWatchlistSql)) {
// ps.setInt(1, watchlistId);
// ps.setInt(2, userId);
// int rowsDeleted = ps.executeUpdate();
// if (rowsDeleted > 0) {
// System.out.println("Watchlist ID: " + watchlistId + " deleted
// successfully.");
// } else {
// System.out.println("Failed to delete watchlist.");
// }
// }
// }

// public void changePW(String Password, String NPW) throws Exception {
// ucon.setAutoCommit(true);
// String checkSql = "SELECT u_pw FROM user WHERE u_pw = ?";
// PreparedStatement checkPst = ucon.prepareStatement(checkSql);
// checkPst.setString(1, Password);
// ResultSet rs = checkPst.executeQuery();
// if (rs.next()) {
// String updateSql = "UPDATE user SET u_pw = ? WHERE u_pw = ?";
// PreparedStatement updatePst = ucon.prepareStatement(updateSql);
// updatePst.setString(1, NPW);
// updatePst.setString(2, Password);
// int i = updatePst.executeUpdate();
// if (i > 0) {
// System.out.println("Your password updated successfully.");
// } else {
// System.out.println("Password update failed.");
// }
// } else {
// System.out.println("Current password is incorrect.");
// }
// }

// public void changeUN(String u_name, String NUN) throws Exception {
// ucon.setAutoCommit(true);
// String checkSql = "SELECT u_name FROM user WHERE u_name = ?";
// PreparedStatement checkPst = ucon.prepareStatement(checkSql);
// checkPst.setString(1, u_name);
// ResultSet rs = checkPst.executeQuery();
// if (rs.next()) {
// String updateSql = "UPDATE user SET u_name = ? WHERE u_name = ?";
// PreparedStatement updatePst = ucon.prepareStatement(updateSql);
// updatePst.setString(1, NUN);
// updatePst.setString(2, u_name);
// int i = updatePst.executeUpdate();
// if (i > 0) {
// System.out.println("Your username updated successfully.");
// } else {
// System.out.println("Username update failed.");
// }
// } else {
// System.out.println("Current username is incorrect.");
// }
// }

// public void watchedMovie(int watchlistId, int movieId, int rating) throws
// Exception {
// ucon.setAutoCommit(true);

// removeMovieFromWatchlist(watchlistId, movieId);

// String sql = "INSERT INTO watched (id, user_id, rating) VALUES (?, ?, ?)";
// PreparedStatement ps = ucon.prepareStatement(sql);
// ps.setInt(1, movieId);
// ps.setInt(2, getUid(u_name));
// ps.setInt(3, rating);
// int rowsInserted = ps.executeUpdate();
// System.out.println("Movies Being Marked Right Now " + rowsInserted);
// if (rowsInserted > 0) {
// System.out.println(st.search(movieId) + " marked as watched with rating: " +
// rating);
// } else {
// System.out.println("Failed to mark movie as watched.");
// }
// }

// public void manuallyMarkMovieAsWatched() throws Exception {
// Scanner sc = new Scanner(System.in);
// System.out.println("Enter Movie(ID of the Movie) you want to mark as
// watched");
// int movieToMark = sc.nextInt();
// System.out.println("Enter your rating for this movie (1 to 10): ");
// int rating = sc.nextInt();
// String sql = "INSERT INTO watched (id, user_id, rating) VALUES (?, ?, ?)";
// PreparedStatement ps = ucon.prepareStatement(sql);
// ps.setInt(1, movieToMark);
// ps.setInt(2, getUid(u_name));
// ps.setInt(3, rating);
// int rowsInserted = ps.executeUpdate();
// // System.out.println("ps.execute" + ps.execute());
// System.out.println("Movies Being Marked Right Now " + rowsInserted);
// if (rowsInserted > 0) {
// System.out.println(st.search(movieToMark) + " marked as watched with rating:
// " + rating);
// } else {
// System.out.println("Failed to mark movie as watched.");
// }
// }

// public void viewYourWatchlists() throws Exception {

// String watchlistSql = "SELECT watchlist_id, watchlist_name FROM watchlist
// WHERE user_id = ?";
// PreparedStatement watchlistPst = ucon.prepareStatement(watchlistSql);
// watchlistPst.setInt(1, getUid(u_name));
// ResultSet watchlistRs = watchlistPst.executeQuery();

// if (!watchlistRs.next()) {
// System.out.println("No watchlists found for the user.");
// return;
// }

// watchlistRs = watchlistPst.executeQuery();

// while (watchlistRs.next()) {
// int watchlistId = watchlistRs.getInt("watchlist_id");
// String watchlistName = watchlistRs.getString("watchlist_name");
// System.out.println("Watchlist Id: " + watchlistId + " Watchlist: " +
// watchlistName);

// String movieSql = "SELECT m.id, m.name FROM watchlist_movie wm JOIN movie m
// ON wm.id = m.id WHERE wm.watchlist_id = ?";
// PreparedStatement moviePst = ucon.prepareStatement(movieSql);
// moviePst.setInt(1, watchlistId);
// ResultSet movieRs = moviePst.executeQuery();

// if (!movieRs.next()) {
// System.out.println(" No movies in this watchlist.");
// } else {

// movieRs = moviePst.executeQuery();
// while (movieRs.next()) {
// System.out.println(st.search(movieRs.getInt(1)));
// }
// }
// }
// }

// public void updateAverageRatingForMovie(int movieId) throws Exception {
// String avgSql = "SELECT AVG(rating) as avg_rating FROM watched_movies WHERE
// id = ?";
// PreparedStatement avgPst = ucon.prepareStatement(avgSql);
// avgPst.setInt(1, movieId);
// ResultSet avgRs = avgPst.executeQuery();
// if (avgRs.next()) {
// double avgRating = avgRs.getDouble("avg_rating");

// String updateSql = "UPDATE movie SET rating = ? WHERE id = ?";
// PreparedStatement updatePst = ucon.prepareStatement(updateSql);
// updatePst.setDouble(1, avgRating);
// updatePst.setInt(2, movieId);
// updatePst.executeUpdate();

// System.out.println("Updated Movie ID: " + movieId + " with Average Rating: "
// + avgRating);
// } else {
// System.out.println("No ratings found for Movie ID: " + movieId);
// }
// }

// public void viewWatchedMovies(int userId) throws Exception {
// String sql = "SELECT m.id, m.name, w.rating " +
// "FROM watched w JOIN movie m ON w.id = m.id " +
// "WHERE w.user_id = ?";
// PreparedStatement pstmt = ucon.prepareStatement(sql);
// pstmt.setInt(1, userId);
// ResultSet rs = pstmt.executeQuery();
// if (!rs.isBeforeFirst()) {
// System.out.println("You haven't watched any movies yet.");
// return;
// }
// System.out.println("Movies you have watched:");
// while (rs.next()) {
// int movieId = rs.getInt("id");
// String movieName = rs.getString("name");
// int rating = rs.getInt("rating");

// System.out.println("Movie ID: " + movieId);
// System.out.println("Movie Name: " + movieName);
// System.out.println("Rating: " + rating);
// System.out.println("-----------------------------");
// }

// }

// }

// public class Trending {
// public String[] stack;
// public int[] Istack;
// public int top;
// public int size;
// Connection Tcon;

// public Trending(Connection con) {
// this.Tcon = con;
// this.size = 10;
// this.stack = new String[size];
// this.Istack = new int[size];
// this.top = 0;
// }

// public void push() throws Exception {
// String sql = "SELECT id,name FROM movie ORDER BY RAND() LIMIT 10";
// PreparedStatement ps = Tcon.prepareStatement(sql);
// ResultSet rs = ps.executeQuery();

// while (top < size && rs.next()) {
// Istack[top] = rs.getInt(1);
// stack[top++] = rs.getString(2);
// }
// }

// public void TrendingMovies() throws Exception {

// if (top == 0) {
// push();
// }

// System.out.println("Trending Movies are:");
// for (int i = 0; i < top; i++) {
// System.out.print("#Rank " + (i + 1) + " Movie Id " + Istack[i]);
// System.out.print(" Movie Name " + stack[i]);
// System.out.println();
// }
// }
// }

// public class sll {
// Connection sllcon;

// public sll(Connection sllcon) {
// this.sllcon = sllcon;
// this.head = null;
// }

// public class userD {
// int u_id;
// String u_name;
// String u_email;
// String u_pw;
// int u_watched;

// public userD(int u_id, String u_name, String u_email, String u_pw, int
// u_watched) {
// this.u_id = u_id;
// this.u_name = u_name;
// this.u_email = u_email;
// this.u_pw = u_pw;
// this.u_watched = u_watched;
// }

// @Override
// public String toString() {
// return "User ID: " + u_id + ", Username: " + u_name + ", Email: " + u_email +
// ", Password: " + u_pw
// + ", Watched Count: " + u_watched;
// }
// }

// public class Node {
// userD uD;
// Node next;

// Node(userD ud) {
// this.uD = ud;
// this.next = null;
// }
// }

// Node head;

// // Insert user data from the database into the linked list
// public void insert() throws Exception {
// String sql = "SELECT * FROM user";
// PreparedStatement ps = sllcon.prepareStatement(sql);
// ResultSet rs = ps.executeQuery();

// while (rs.next()) {
// int u_id = rs.getInt("u_id");
// String u_name = rs.getString("u_name");
// String u_email = rs.getString("u_email");
// String u_pw = rs.getString("u_pw");
// int u_watched = rs.getInt("u_watched");

// userD newUser = new userD(u_id, u_name, u_email, u_pw, u_watched);
// Node newNode = new Node(newUser);

// if (head == null) {
// head = newNode;
// } else {
// Node temp = head;
// while (temp.next != null) {
// temp = temp.next;
// }
// temp.next = newNode;
// }
// }
// }

// // Display the linked list
// public void display() throws Exception {
// if (head == null) {
// System.out.println("No users found.");
// return;
// }

// Node temp = head;
// System.out.println("User Linked List:");
// while (temp != null) {
// System.out.println(temp.uD); // Print user data
// temp = temp.next;
// }
// System.out.println();
// }

// // Get user details by user ID
// public userD getUser(int id) throws Exception {
// if (head == null) {
// System.out.println("No users in the list.");
// return null;
// }

// Node temp = head;
// while (temp != null) {
// if (temp.uD.u_id == id) {
// return temp.uD; // Return user details if found
// }
// temp = temp.next;
// }

// System.out.println("User with ID: " + id + " not found.");
// return null; // Return null if the user is not found
// }
// }

// public class searchBST {
// int M_id;
// String M_name;
// String M_dname;
// String M_rdate;
// int rating;

// Connection scon;

// public searchBST(Connection scon) {
// this.scon = scon;
// this.root = null;
// }

// public class details {
// int M_id;
// String M_name;
// String M_dname;
// String M_rdate;
// int rating;

// public details(int m_id, String m_name, String m_dname, String m_rdate, int
// rating) {
// this.M_id = m_id;
// this.M_name = m_name;
// this.M_dname = m_dname;
// this.M_rdate = m_rdate;
// this.rating = rating;
// }

// @Override
// public String toString() {
// return "Movie Id: " + M_id + ", Movie Name: " + M_name + ", Director's Name:
// " + M_dname +
// ", Release Date: " + M_rdate + ", Rating: " + rating;
// }
// }

// class Node {
// Node left;
// Node right;
// details d;

// public Node(details d) {
// this.d = d;
// this.left = null;
// this.right = null;
// }
// }

// Node root;

// public void insert() throws Exception {

// String sql = "SELECT * FROM movie";
// PreparedStatement ps = scon.prepareStatement(sql);

// ResultSet rs = ps.executeQuery();

// while (rs.next()) {

// int movieId = rs.getInt("id");
// String movieName = rs.getString("name");
// String directorName = rs.getString("d_name");
// String releaseDate = rs.getString("release_date");
// int rating = rs.getInt("ratings");

// details movieDetails = new details(movieId, movieName, directorName,
// releaseDate, rating);

// root = insertRec(root, movieDetails);
// }

// rs.close();
// ps.close();
// }

// public Node insertRec(Node root, details d) {
// if (root == null) {
// root = new Node(d);
// return root;
// }

// if (d.M_id < root.d.M_id) {
// root.left = insertRec(root.left, d);
// } else if (d.M_id > root.d.M_id) {
// root.right = insertRec(root.right, d);
// }

// return root;
// }

// public details search(int id) {
// return searchRec(root, id);
// }

// public details searchRec(Node root, int id) {

// if (root == null || root.d.M_id == id) {
// return (root != null) ? root.d : null;
// }

// if (id < root.d.M_id) {
// return searchRec(root.left, id);
// }

// return searchRec(root.right, id);
// }

// public void inorderTraversal(Node root) {
// if (root != null) {
// inorderTraversal(root.left);
// System.out.println(root.d);
// inorderTraversal(root.right);
// }
// }

// public void displayMovies() {
// if (root == null) {
// System.out.println("No movies in the database.");
// } else {
// inorderTraversal(root);
// }
// }
// }
