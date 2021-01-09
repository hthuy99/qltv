/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Da.Da;

import BaseClass.BaseClass;
import Model.Da.User;
import Database.ConnectDb;
import Interface.MyInterface;
import Model.Da.Book;
import Model.Da.BookExtension;
import Model.Da.UserExtension;
import View.Thong_bao.Message;
//import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tudv
 */
public class BookDA implements MyInterface {

    public BookDA() {
    }

    private Connection con = BaseClass.getConnectDb();
    private Message mess = BaseClass.getMessage();

    @Override
    public ArrayList getAll() {
        ArrayList<Book> listBook = new ArrayList<Book>();
        if (con == null) {
            mess.showMessage("error", "Connect to DB failed!");
        } else {
            try {
                String sql = "SELECT * FROM book where deleted_at is null ";
                Statement stmt;
                stmt = (Statement) con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Book book = new Book();
                    book.setId(rs.getInt(1));
                    book.setStoreID(rs.getInt(3));
                    book.setName(rs.getString(2));
                    book.setType(rs.getInt(6));
                    book.setBookPrice(rs.getDouble(11));
                    book.setDeletedAt(rs.getString(12));
                    book.setAuthor(rs.getString(4));
                    book.setBorrowNumber(rs.getInt(13));
                    book.setEmptyNumber(rs.getInt(14));
                    book.setNumber(rs.getInt(7));
                    listBook.add(book);
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserDA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listBook;
    }

    public Book getBookByID(int id) throws SQLException {
        Book book = null;
        if (con == null) {
            mess.showMessage("error", "Connect to DB failed!");
            return null;
        } else {
            String sql = "SELECT * FROM book WHERE book.id = ? AND book.deleted_at is null";
            java.sql.PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                book = new BookExtension();
                book.setId(rs.getInt(1));
                book.setStoreID(rs.getInt(3));
                book.setName(rs.getString(2));
                book.setType(rs.getInt(6));
                book.setBookPrice(rs.getDouble(11));
                book.setDeletedAt(rs.getString(12));
                book.setAuthor(rs.getString(4));
                //  book.setStoreName(rs);
            }
        }
        return book;
    }

    @Override
    public boolean create(Object item) {

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (con == null) {
            mess.showMessage("error", "Connect to DB failed or user not found");
        } else {
            try {
                Book book = getBookByID(id);
                if (book.getDeletedAt() != null) {
                    return false;
                }
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                String sql = "update book set book.deleted_at = ? where book.id = ?";
                PreparedStatement stmt;
                stmt = (PreparedStatement) con.prepareStatement(sql);
                stmt.setString(1, dtf.format(now));
                stmt.setInt(2, id);
                int count = stmt.executeUpdate();
                if (count > 0) {
                    return true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserDA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean update(int id, Object item) {
        Book newBook = (Book) item;
        if (con == null || newBook.getDeletedAt() != null) {
            mess.showMessage("error", "Connect to DB failed or User not found");
            return false;
        } else {
            String sql = "update book set "
                    + "bo_name = ? "
                    + ",bo_author=?,"
                    + "bo_number=? "
                    + "where id = ?";
            PreparedStatement stmt;
            try {
                stmt = (PreparedStatement) con.prepareStatement(sql);
                stmt.setString(1, newBook.getName());
                stmt.setString(2, newBook.getAuthor());
                stmt.setInt(3, newBook.getNumber());
                stmt.setInt(4, id);
                int count = stmt.executeUpdate();
                if (count > 0) {
                    return true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserDA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public ArrayList getAllBookByStoreID(int store_id) throws SQLException {
        ArrayList<Book> listBook = new ArrayList<>();
        if (con == null) {
            mess.showMessage("error", "Connect to DB failed!");
            return null;
        } else {
            String sql = "SELECT * FROM book WHERE bo_id_store = ? AND book.deleted_at is null";
            java.sql.PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, store_id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt(1));
                book.setStoreID(rs.getInt(3));
                book.setName(rs.getString(2));
                book.setType(rs.getInt(6));
                book.setBookPrice(rs.getDouble(11));
                book.setDeletedAt(rs.getString(12));
                book.setAuthor(rs.getString(4));
                listBook.add(book);
            }
        }
        return listBook;
    }

    public static void main(String[] args) throws SQLException {
        BookDA qe = new BookDA();
//        ArrayList<UserExtension> listUser = qe.getAll();
//        for (UserExtension u : listUser) {
//            System.out.println(u.getMasv());
//        }
        //qe.delete(23);
        qe.getAllBookByStoreID(1);
    }

}
