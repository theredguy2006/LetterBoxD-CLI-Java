package P;

import P.*;

import java.sql.*;

public class searchBST {
    int M_id;
    String M_name;
    String M_dname;
    String M_rdate;
    int rating;

    Connection scon;

    public searchBST(Connection scon) {
        this.scon = scon;
        this.root = null;
    }

    public class details {
        int M_id;
        String M_name;
        String M_dname;
        String M_rdate;
        int rating;

        public details(int m_id, String m_name, String m_dname, String m_rdate, int rating) {
            this.M_id = m_id;
            this.M_name = m_name;
            this.M_dname = m_dname;
            this.M_rdate = m_rdate;
            this.rating = rating;
        }

        @Override
        public String toString() {
            return "Movie Id: " + M_id + ", Movie Name: " + M_name + ", Director's Name: " + M_dname +
                    ", Release Date: " + M_rdate + ", Rating: " + rating;
        }
    }

    class Node {
        Node left;
        Node right;
        details d;

        public Node(details d) {
            this.d = d;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    public void insert() throws Exception {

        String sql = "SELECT * FROM movie";
        PreparedStatement ps = scon.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            int movieId = rs.getInt("id");
            String movieName = rs.getString("name");
            String directorName = rs.getString("d_name");
            String releaseDate = rs.getString("release_date");
            int rating = rs.getInt("ratings");

            details movieDetails = new details(movieId, movieName, directorName, releaseDate, rating);

            root = insertRec(root, movieDetails);
        }

        rs.close();
        ps.close();
    }

    public Node insertRec(Node root, details d) {
        if (root == null) {
            root = new Node(d);
            return root;
        }

        if (d.M_id < root.d.M_id) {
            root.left = insertRec(root.left, d);
        } else if (d.M_id > root.d.M_id) {
            root.right = insertRec(root.right, d);
        }

        return root;
    }

    public details search(int id) {
        return searchRec(root, id);
    }

    public details searchRec(Node root, int id) {

        if (root == null || root.d.M_id == id) {
            return (root != null) ? root.d : null;
        }

        if (id < root.d.M_id) {
            return searchRec(root.left, id);
        }

        return searchRec(root.right, id);
    }

    public void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.println(root.d);
            inorderTraversal(root.right);
        }
    }

    public void displayMovies() {
        if (root == null) {
            System.out.println("No movies in the database.");
        } else {
            inorderTraversal(root);
        }
    }
}
