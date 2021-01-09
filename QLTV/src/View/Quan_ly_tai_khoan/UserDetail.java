/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Quan_ly_tai_khoan;

import BaseClass.BaseClass;
import Model.Da.Da.UserDA;
//import Model.Da.Da.StoreDA;
import Model.Da.User;
//import Model.Da.Book;
import View.Thong_bao.Message;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 *
 * @author tudv
 */
public class UserDetail extends javax.swing.JDialog {

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnMyStore;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblMsv;
    private javax.swing.JLabel lblTruong;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JTextField txtMsv;
    private javax.swing.JTextField txtTruong;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtEmail;

    // End of variables declaration   
    private Message mes = BaseClass.getMessage();

    private int id = -1;

    private UserDA userDa = new UserDA();
    private User user = null;

    private JFrame frameAfter = null;

    public UserDetail(int id, JFrame frameAfter) throws SQLException {
        this.id = id;
        this.frameAfter = frameAfter;
        User user = new User();
        if (id != -1) {
            user = userDa.getUserByID(id);
        }
        initComponents();
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        lblName = new javax.swing.JLabel();
        lblMsv = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblTruong = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtTruong = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtMsv = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        lblInfo = new javax.swing.JLabel();
        btnMyStore = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        // setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        lblName.setText("Tên sinh viên");

        lblMsv.setText("Mã sinh viên");

        lblEmail.setText("Email");

        lblTruong.setText("Trường");

        txtName.setText("jTextField1");
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        txtTruong.setText("jTextField1");

        txtEmail.setText("jTextField1");

        txtMsv.setText("jTextField1");

        btnUpdate.setText("Cập nhật");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        lblInfo.setText("Thông tin chi tiết");

        	btnMyStore.setText("My store");

        btnDelete.setText("Xóa sinh viên");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(21)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(btnUpdate)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
        					.addGap(25)
        					.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        						.addComponent(jSeparator1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblInfo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        					.addGap(84)
        					.addComponent(btnMyStore)
        					.addGap(27)
        					.addComponent(btnDelete))
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblMsv, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblTruong, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
        					.addGap(25)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
        						.addComponent(txtMsv, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
        						.addComponent(txtTruong, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)))
        				.addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblInfo)
        				.addComponent(btnDelete)
        				.addComponent(btnMyStore))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblName)
        				.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(37)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtMsv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblMsv))
        			.addGap(51)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblEmail))
        			.addGap(37)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtTruong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblTruong))
        			.addPreferredGap(ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
        			.addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
        			.addGap(10)
        			.addComponent(btnUpdate)
        			.addGap(20))
        );
        getContentPane().setLayout(layout);
        if (user != null) {
            txtName.setText(user.getName());
           // txtMsv.setText(user.getMasv());
            txtEmail.setText(user.getEmail());
            //txtTruong.setText(String.valueOf(book.getBorrowNumber()));
        }
        pack();
    }// </editor-fold>                        

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        User us = new User();
        us.setName(txtName.getText());
      //  us.setMasv(txtMsv.getText());
        us.setEmail(txtEmail.getText());
        boolean status = userDa.update(user.getID(), us);
        if (status) {
            mes.showMessage("success", "Cập nhật thành công!");
            if (frameAfter != null) {
                if (frameAfter instanceof AccountManager) {
                    AccountManager m = (AccountManager) frameAfter;
                    UserDA userDa = new UserDA();
                    m.updateModel(userDa.getAll());
                }
            }
        } else {
            mes.showMessage("error", "Thất bại!");
        }
    }

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

//    private void btnMuonSachActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
//        muon_sach m = new muon_sach(book.getId());
//    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        if (user != null) {
            boolean status = userDa.delete(user.getID());
            if (status) {
                this.dispose();
                if (frameAfter instanceof AccountManager) {
                    AccountManager m = (AccountManager) frameAfter;
                    UserDA userDa = new UserDA();
                    m.updateModel(userDa.getAll());
                }
            }
        }

    }

    private void txtDaMuonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public static void main(String args[]) throws SQLException {
        UserDetail userDetail = new UserDetail(-1, null);
        userDetail.setVisible(true);
    }

}
