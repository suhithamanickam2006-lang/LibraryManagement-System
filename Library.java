package library;

import java.util.ArrayList;
import java.sql.*;
public class Library {

    ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {

        String query =
                "INSERT INTO books VALUES(?,?,?,?)";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, book.id);
            ps.setString(2, book.title);
            ps.setString(3, book.author);
            ps.setBoolean(4, false);

            ps.executeUpdate();

            System.out.println("Book Added");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void displayBooks() {

        String query = "SELECT * FROM books";

        try {

            Connection con =
                    DBConnection.getConnection();

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(query);

            while(rs.next()) {

                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("title") + " " +
                                rs.getString("author") + " " +
                                rs.getBoolean("issued")
                );
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void issueBook(int id) {

        String query =
                "UPDATE books SET issued=true WHERE id=?";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Book Issued");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void returnBook(int id) {

        String query =
                "UPDATE books SET issued=false WHERE id=?";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Book Returned");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}