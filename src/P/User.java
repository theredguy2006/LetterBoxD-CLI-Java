package P;

import P.*;
import java.sql.*;
import java.util.*;

public class User {
    Admin a;
    Main m;
    String u_name;
    String Password;
    Connection ucon;
    Trending t;
    int u;
    searchBST st;

    public User(Connection ucon, String u_name, String password) {
        this.u_name = u_name;
        this.Password = password;
        this.ucon = ucon;
    }

    public int getUid(String u_name) throws Exception {
        String sql = "SELECT u_id FROM user WHERE u_name = ?";
        PreparedStatement ps = ucon.prepareStatement(sql);
        ps.setString(1, u_name);

        ResultSet rs = ps.executeQuery();
        int u = -1;

        if (rs.next()) {
            u = rs.getInt("u_id");
        }

        return u;
    }

    public void userOptions() throws Exception {
        st = new searchBST(ucon);
        st.insert();
        ucon.setAutoCommit(true);
        t = new Trending(ucon);
        Boolean apb = true; // Admin Privelages Boolean
        Scanner sc = new Scanner(System.in);
        while (apb) {
            System.out.println("Select what you want to do ");
            System.out.println("Press 1.) View All movies in database ");
            System.out.println("Press 2.) Search Movie by ID in Database");
            System.out.println("Press 3.) Create Watchlist Table ");
            System.out.println("Press 4.) Add Movie Into Watchlist Table");
            System.out.println("Press 5.) Remove Movie From Watchlist Or Mark as Watched");
            System.out.println("Press 6.) Show Trending Movies ");
            System.out.println("Press 7.) To Change Password ");
            System.out.println("Press 8.) Change Username ");
            System.out.println("Press 9.) Mark a Movie as Watched Directly");
            System.out.println("Press 10.) View Your Watchlists ");
            System.out.println("Press 11.) Delete Your Watchlists ");
            System.out.println("Press 12.) To View Movies You Have Watched  ");
            System.out.println("Press 13.) To Exit ");

            int aps = sc.nextInt();
            sc.nextLine();
            switch (aps) {
                case 1:
                    System.out.println("Viewing All Movies");
                    viewAll();
                    break;
                case 2:
                    System.out.println("Enter Movie Id to search: ");
                    int id = sc.nextInt();
                    searchMovie(id);
                    break;
                case 3:
                    System.out.println("You Have selected to create a watchlist");
                    System.out.println("Enter WatchList name: ");
                    String w_name = sc.nextLine();
                    createWatchlist(getUid(u_name), w_name);
                    break;
                case 4:
                    System.out.println("View Your Watchlists First ");
                    viewYourWatchlists();
                    System.out.println("Enter Movie(ID of the Movie) you want to enter: ");
                    int movieToAdd = sc.nextInt();
                    System.out.println("Enter watchlist ID to add movie to: ");
                    int watchlistIdToAdd = sc.nextInt();
                    addMovieToWatchlist(watchlistIdToAdd, movieToAdd);
                    break;
                case 5:
                    System.out.println("View Your Watchlists First ");
                    viewYourWatchlists();
                    System.out.println("Enter Movie(ID of the Movie) you want to Remove: ");
                    int movieToRemove = sc.nextInt();
                    System.out.println("Enter watchlist ID to remove movie from: ");
                    int watchlistIdToRemoveFrom = sc.nextInt();
                    System.out.println("Enter rating for the movie (1 to 10): ");
                    int rating = sc.nextInt();
                    watchedMovie(watchlistIdToRemoveFrom, movieToRemove, rating);
                    break;
                case 6:
                    System.out.println("Viewing Trending Movies");
                    t.TrendingMovies();
                    break;
                case 7:
                    System.out.println("Changing Password");
                    System.out.println("Your current password is " + Password);
                    System.out.println("Please Enter New Password: ");
                    String NPW = sc.nextLine();
                    changePW(Password, NPW);
                    break;
                case 8:
                    System.out.println("Changing Username");
                    System.out.println("Your current Username is " + u_name);
                    System.out.println("Please Enter New Username: ");
                    String nun = sc.nextLine();
                    changeUN(u_name, nun);
                    break;
                case 9:
                    System.out.println("Marking a Movie as Watched Directly");
                    manuallyMarkMovieAsWatched();

                    break;
                case 10:
                    System.out.println("Viewing Your Watchlists");
                    viewYourWatchlists();
                    break;
                case 11:
                    System.out.println("Deleting Your Watchlists");
                    System.out.print(" But View Your Watchlist first ");
                    viewYourWatchlists();
                    System.out.println("Enter Your Watchlist To Remove ");
                    int watchlistIdToRemove = sc.nextInt();
                    deleteWatchlist(watchlistIdToRemove);
                    break;
                case 12:
                    System.out.println("You Selected with all movies you have watched ");
                    viewWatchedMovies(getUid(u_name));
                    break;
                case 13:
                    System.out.println("Exiting. Bye!");
                    apb = false;
                    break;
                default:
                    System.out.println("Invalid input! Please select from the options above.");
                    break;
            }
        }
    }

    public void viewAll() throws Exception {
        st.displayMovies();
        /*
         * String sql = "SELECT * FROM movie";
         * PreparedStatement pst = ucon.prepareStatement(sql);
         * ResultSet rs = pst.executeQuery();
         * while (rs.next()) {
         * System.out.print("Movie Id ----> " + rs.getInt(1));
         * System.out.print(" Movie Name ----> " + rs.getString(2));
         * System.out.print(" Director ----> " + rs.getString(3));
         * System.out.print(" Movie Release Date ----> " + rs.getString(4));
         * System.out.print(" Movie Rating----> " + rs.getInt(5));
         * System.out.println();
         * }
         */
    }

    public void searchMovie(int id) throws Exception {
        System.out.println(st.search(id));
        /*
         * String sql = "SELECT * FROM movie WHERE id = ?";
         * PreparedStatement ps = ucon.prepareStatement(sql);
         * ps.setInt(1, id);
         * ResultSet rs = ps.executeQuery();
         * while (rs.next()) {
         * System.out.print("Movie Id " + rs.getInt(1) + " Movie Name " +
         * rs.getString(2) + " Director's Name "
         * + rs.getString(3) + " Release Date " + rs.getString(4) + " Current Rating " +
         * rs.getInt(5));
         * System.out.println();
         * }
         */
    }

    public void createWatchlist(int userId, String watchlistName) throws Exception {
        String sql = "INSERT INTO watchlist (user_id, watchlist_name) VALUES (?, ?)";
        PreparedStatement ps = ucon.prepareStatement(sql);
        ps.setInt(1, userId);
        ps.setString(2, watchlistName);
        int rowsInserted = ps.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Watchlist '" + watchlistName + "' created successfully for user ID: " + userId);
        } else {
            System.out.println("Failed to create watchlist.");
        }
    }

    public void addMovieToWatchlist(int watchlistId, int movieId) throws Exception {

        String checkWatchlistSql = "SELECT COUNT(*) FROM watchlist WHERE watchlist_id = ?";
        PreparedStatement checkPst = ucon.prepareStatement(checkWatchlistSql);
        checkPst.setInt(1, watchlistId);
        ResultSet rs = checkPst.executeQuery();

        if (rs.next() && rs.getInt(1) > 0) {

            String sql = "INSERT INTO watchlist_movie (watchlist_id, id) VALUES (?, ?)";
            PreparedStatement ps = ucon.prepareStatement(sql);
            ps.setInt(1, watchlistId);
            ps.setInt(2, movieId);
            int rowsInserted = ps.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println(st.search(movieId) + " added to watchlist ID: " + watchlistId);
            } else {
                System.out.println("Failed to add movie to watchlist.");
            }
        } else {
            System.out.println("Watchlist ID: " + watchlistId + " does not exist.");
        }

    }

    public void removeMovieFromWatchlist(int watchlistId, int movieId) throws Exception {

        String checkMovieSql = "SELECT COUNT(*) FROM watchlist_movie WHERE watchlist_id = ? AND id = ?";
        PreparedStatement checkPs = ucon.prepareStatement(checkMovieSql);
        checkPs.setInt(1, watchlistId);
        checkPs.setInt(2, movieId);
        ResultSet checkRs = checkPs.executeQuery();

        if (checkRs.next() && checkRs.getInt(1) > 0) {

            String deleteSql = "DELETE FROM watchlist_movie WHERE watchlist_id = ? AND id = ?";
            PreparedStatement deletePs = ucon.prepareStatement(deleteSql);
            deletePs.setInt(1, watchlistId);
            deletePs.setInt(2, movieId);
            int rowsDeleted = deletePs.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println(st.search(movieId) + " removed from watchlist ID: " + watchlistId);
            } else {
                System.out.println("Failed to remove movie from watchlist.");
            }

            deletePs.close();
        } else {

            System.out.println("The movie does not exist in the specified watchlist or the watchlist is empty.");
        }

    }

    public void deleteWatchlist(int watchlistId) throws Exception {
        String verifyOwnershipSql = "SELECT COUNT(*) FROM watchlist WHERE watchlist_id = ? AND user_id = ?";
        int userId = getUid(u_name);
        boolean isOwner = false;

        try (PreparedStatement ps = ucon.prepareStatement(verifyOwnershipSql)) {
            ps.setInt(1, watchlistId);
            ps.setInt(2, userId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    isOwner = rs.getInt(1) > 0;
                }
            }
        }

        if (!isOwner) {
            System.out.println("You do not have permission to delete this watchlist.");
            return;
        }

        String deleteMoviesSql = "DELETE FROM watchlist_movie WHERE watchlist_id = ?";
        try (PreparedStatement ps = ucon.prepareStatement(deleteMoviesSql)) {
            ps.setInt(1, watchlistId);
            ps.executeUpdate();
        }

        String deleteWatchlistSql = "DELETE FROM watchlist WHERE watchlist_id = ? AND user_id = ?";
        try (PreparedStatement ps = ucon.prepareStatement(deleteWatchlistSql)) {
            ps.setInt(1, watchlistId);
            ps.setInt(2, userId);
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Watchlist ID: " + watchlistId + " deleted successfully.");
            } else {
                System.out.println("Failed to delete watchlist.");
            }
        }
    }

    public void changePW(String Password, String NPW) throws Exception {
        ucon.setAutoCommit(true);
        String checkSql = "SELECT u_pw FROM user WHERE u_pw = ?";
        PreparedStatement checkPst = ucon.prepareStatement(checkSql);
        checkPst.setString(1, Password);
        ResultSet rs = checkPst.executeQuery();
        if (rs.next()) {
            String updateSql = "UPDATE user SET u_pw = ? WHERE u_pw = ?";
            PreparedStatement updatePst = ucon.prepareStatement(updateSql);
            updatePst.setString(1, NPW);
            updatePst.setString(2, Password);
            int i = updatePst.executeUpdate();
            if (i > 0) {
                System.out.println("Your password updated successfully.");
            } else {
                System.out.println("Password update failed.");
            }
        } else {
            System.out.println("Current password is incorrect.");
        }
    }

    public void changeUN(String u_name, String NUN) throws Exception {
        ucon.setAutoCommit(true);
        String checkSql = "SELECT u_name FROM user WHERE u_name = ?";
        PreparedStatement checkPst = ucon.prepareStatement(checkSql);
        checkPst.setString(1, u_name);
        ResultSet rs = checkPst.executeQuery();
        if (rs.next()) {
            String updateSql = "UPDATE user SET u_name = ? WHERE u_name = ?";
            PreparedStatement updatePst = ucon.prepareStatement(updateSql);
            updatePst.setString(1, NUN);
            updatePst.setString(2, u_name);
            int i = updatePst.executeUpdate();
            if (i > 0) {
                System.out.println("Your username updated successfully.");
            } else {
                System.out.println("Username update failed.");
            }
        } else {
            System.out.println("Current username is incorrect.");
        }
    }

    public void watchedMovie(int watchlistId, int movieId, int rating) throws Exception {
        ucon.setAutoCommit(true);

        removeMovieFromWatchlist(watchlistId, movieId);

        String sql = "INSERT INTO watched  (id, user_id, rating) VALUES (?, ?, ?)";
        PreparedStatement ps = ucon.prepareStatement(sql);
        ps.setInt(1, movieId);
        ps.setInt(2, getUid(u_name));
        ps.setInt(3, rating);
        int rowsInserted = ps.executeUpdate();
        System.out.println("Movies Being Marked Right Now " + rowsInserted);
        if (rowsInserted > 0) {
            System.out.println(st.search(movieId) + " marked as watched with rating: " + rating);
        } else {
            System.out.println("Failed to mark movie as watched.");
        }
    }

    public void manuallyMarkMovieAsWatched() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Movie(ID of the Movie) you want to mark as watched");
        int movieToMark = sc.nextInt();
        System.out.println("Enter your rating for this movie (1 to 10): ");
        int rating = sc.nextInt();
        String sql = "INSERT INTO watched  (id, user_id, rating) VALUES (?, ?, ?)";
        PreparedStatement ps = ucon.prepareStatement(sql);
        ps.setInt(1, movieToMark);
        ps.setInt(2, getUid(u_name));
        ps.setInt(3, rating);
        int rowsInserted = ps.executeUpdate();
        // System.out.println("ps.execute" + ps.execute());
        System.out.println("Movies Being Marked Right Now " + rowsInserted);
        if (rowsInserted > 0) {
            System.out.println(st.search(movieToMark) + " marked as watched with rating: " + rating);
        } else {
            System.out.println("Failed to mark movie as watched.");
        }
    }

    public void viewYourWatchlists() throws Exception {

        String watchlistSql = "SELECT watchlist_id, watchlist_name FROM watchlist WHERE user_id = ?";
        PreparedStatement watchlistPst = ucon.prepareStatement(watchlistSql);
        watchlistPst.setInt(1, getUid(u_name));
        ResultSet watchlistRs = watchlistPst.executeQuery();

        if (!watchlistRs.next()) {
            System.out.println("No watchlists found for the user.");
            return;
        }

        watchlistRs = watchlistPst.executeQuery();

        while (watchlistRs.next()) {
            int watchlistId = watchlistRs.getInt("watchlist_id");
            String watchlistName = watchlistRs.getString("watchlist_name");
            System.out.println("Watchlist Id: " + watchlistId + " Watchlist: " + watchlistName);

            String movieSql = "SELECT m.id, m.name FROM watchlist_movie wm JOIN movie m ON wm.id = m.id WHERE wm.watchlist_id = ?";
            PreparedStatement moviePst = ucon.prepareStatement(movieSql);
            moviePst.setInt(1, watchlistId);
            ResultSet movieRs = moviePst.executeQuery();

            if (!movieRs.next()) {
                System.out.println("  No movies in this watchlist.");
            } else {

                movieRs = moviePst.executeQuery();
                while (movieRs.next()) {
                    System.out.println(st.search(movieRs.getInt(1)));
                }
            }
        }
    }

    public void updateAverageRatingForMovie(int movieId) throws Exception {
        String avgSql = "SELECT AVG(rating) as avg_rating FROM watched_movies WHERE id = ?";
        PreparedStatement avgPst = ucon.prepareStatement(avgSql);
        avgPst.setInt(1, movieId);
        ResultSet avgRs = avgPst.executeQuery();
        if (avgRs.next()) {
            double avgRating = avgRs.getDouble("avg_rating");

            String updateSql = "UPDATE movie SET rating = ? WHERE id = ?";
            PreparedStatement updatePst = ucon.prepareStatement(updateSql);
            updatePst.setDouble(1, avgRating);
            updatePst.setInt(2, movieId);
            updatePst.executeUpdate();

            System.out.println("Updated Movie ID: " + movieId + " with Average Rating: " + avgRating);
        } else {
            System.out.println("No ratings found for Movie ID: " + movieId);
        }
    }

    public void viewWatchedMovies(int userId) throws Exception {
        String sql = "SELECT m.id, m.name, w.rating " +
                "FROM watched w JOIN movie m ON w.id = m.id " +
                "WHERE w.user_id = ?";
        PreparedStatement pstmt = ucon.prepareStatement(sql);
        pstmt.setInt(1, userId);
        ResultSet rs = pstmt.executeQuery();
        if (!rs.isBeforeFirst()) {
            System.out.println("You haven't watched any movies yet.");
            return;
        }
        System.out.println("Movies you have watched:");
        while (rs.next()) {
            int movieId = rs.getInt("id");
            String movieName = rs.getString("name");
            int rating = rs.getInt("rating");

            System.out.println("Movie ID: " + movieId);
            System.out.println("Movie Name: " + movieName);
            System.out.println("Rating: " + rating);
            System.out.println("-----------------------------");
        }

    }

}
