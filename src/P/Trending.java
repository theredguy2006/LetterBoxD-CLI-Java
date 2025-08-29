package P;

import P.*;
import java.sql.*;

public class Trending {
    public String[] stack;
    public int[] Istack;
    public int top;
    public int size;
    Connection Tcon;

    public Trending(Connection con) {
        this.Tcon = con;
        this.size = 10;
        this.stack = new String[size];
        this.Istack = new int[size];
        this.top = 0;
    }

    public void push() throws Exception {
        String sql = "SELECT id,name FROM movie ORDER BY RAND() LIMIT 10";
        PreparedStatement ps = Tcon.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (top < size && rs.next()) {
            Istack[top] = rs.getInt(1);
            stack[top++] = rs.getString(2);
        }
    }

    public void TrendingMovies() throws Exception {

        if (top == 0) {
            push();
        }

        System.out.println("Trending Movies are:");
        for (int i = 0; i < top; i++) {
            System.out.print("#Rank " + (i + 1) + " Movie Id  " + Istack[i]);
            System.out.print(" Movie Name  " + stack[i]);
            System.out.println();
        }
    }
}
