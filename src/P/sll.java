package P;

import P.*;

import java.sql.*;

public class sll {
    Connection sllcon;

    public sll(Connection sllcon) {
        this.sllcon = sllcon;
        this.head = null;
    }

    public class userD {
        int u_id;
        String u_name;
        String u_email;
        String u_pw;
        int u_watched;

        public userD(int u_id, String u_name, String u_email, String u_pw, int u_watched) {
            this.u_id = u_id;
            this.u_name = u_name;
            this.u_email = u_email;
            this.u_pw = u_pw;
            this.u_watched = u_watched;
        }

        @Override
        public String toString() {
            return "User ID: " + u_id + ", Username: " + u_name + ", Email: " + u_email + ", Password: " + u_pw
                    + ", Watched Count: " + u_watched;
        }
    }

    public class Node {
        userD uD;
        Node next;

        Node(userD ud) {
            this.uD = ud;
            this.next = null;
        }
    }

    Node head;

    // Insert user data from the database into the linked list
    public void insert() throws Exception {
        String sql = "SELECT * FROM user";
        PreparedStatement ps = sllcon.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int u_id = rs.getInt("u_id");
            String u_name = rs.getString("u_name");
            String u_email = rs.getString("u_email");
            String u_pw = rs.getString("u_pw");
            int u_watched = rs.getInt("u_watched");

            userD newUser = new userD(u_id, u_name, u_email, u_pw, u_watched);
            Node newNode = new Node(newUser);

            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }
    }

    // Display the linked list
    public void display() throws Exception {
        if (head == null) {
            System.out.println("No users found.");
            return;
        }

        Node temp = head;
        System.out.println("User Linked List:");
        while (temp != null) {
            System.out.println(temp.uD); // Print user data
            temp = temp.next;
        }
        System.out.println();
    }

    // Get user details by user ID
    public userD getUser(int id) throws Exception {
        if (head == null) {
            System.out.println("No users in the list.");
            return null;
        }

        Node temp = head;
        while (temp != null) {
            if (temp.uD.u_id == id) {
                return temp.uD; // Return user details if found
            }
            temp = temp.next;
        }

        System.out.println("User with ID: " + id + " not found.");
        return null; // Return null if the user is not found
    }
}
