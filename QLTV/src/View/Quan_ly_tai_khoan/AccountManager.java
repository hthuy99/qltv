package View.Quan_ly_tai_khoan;

import Core.UserCore.SearchOrFilter;
import Model.Da.User;
import Model.Da.Da.UserDA;
import Model.Da.Da.BookDA;
import Model.Da.Da.StoreDA;
import Model.Da.Store;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
/**
 *
 * @author tudv
 */
public class AccountManager extends javax.swing.JFrame {

    // Variables declaration - do not modify                     
    private com.toedter.calendar.JDateChooser DateChooserFromDate;
    private com.toedter.calendar.JDateChooser DateChooserTodate;
    private javax.swing.JButton btnAddAccount;
    private javax.swing.JButton btnFilter;
    private javax.swing.JComboBox cbxStatus1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFromDate;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTodate;
    private javax.swing.JMenu menuBarAccout;
    private javax.swing.JPanel panelMain;
    private javax.swing.JTable tbtData;

    private javax.swing.JMenuItem jMenuItemAccout;
   // private javax.swing.JMenuItem jMenuItem3;

    // End of variables declaration   
    private DefaultTableModel model;
    private JScrollPane scrollPane;
    
    private UserDA userDa = new UserDA();
    
    private ArrayList<User> listUser = userDa.getAll();

    private JPanel accout = new JPanel();

    private String status = "";
    private JTextField textField;
    private JTextField textField_1;

    public AccountManager() {
        initComponents();
        updateModel(listUser);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        lblFromDate = new javax.swing.JLabel();
        DateChooserFromDate = new com.toedter.calendar.JDateChooser();
        lblTodate = new javax.swing.JLabel();
        DateChooserTodate = new com.toedter.calendar.JDateChooser();
        lblStatus = new javax.swing.JLabel();
        cbxStatus1 = new javax.swing.JComboBox();
        btnFilter = new javax.swing.JButton();
        btnAddAccount = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbtData = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuBarAccout = new javax.swing.JMenu();

        jMenuItemAccout = new JMenuItem("Quản lý tài khoản");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblFromDate.setText("From-date");

        lblTodate.setText("To-date");

        lblStatus.setText("Trạng thái");

        //cbxStatus1.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"", "Dá»—i", "Ä�Ã£ mÆ°á»£n háº¿t"}));

      // cbxStore.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        btnFilter.setText("Lọc");
    
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnFilterActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(AccountManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    
        btnAddAccount.setText("Thêm tài khoản");
        btnAddAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnAddAccountActionPerformed(evt);
            }
        });
        jScrollPane1.setViewportView(tbtData);
        
        JButton btnSearch = new JButton();
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnSearchActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(AccountManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
        textField = new JTextField();
        textField.setColumns(10);
        
        JLabel lblMSinhVin = new JLabel();
        lblMSinhVin.setText("Mã sinh viên");
        
        JLabel lblTnSinhVin = new JLabel();
        lblTnSinhVin.setText("Tên sinh viên");
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMainLayout.setHorizontalGroup(
        	panelMainLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(panelMainLayout.createSequentialGroup()
        			.addGroup(panelMainLayout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 1026, Short.MAX_VALUE)
        				.addGroup(panelMainLayout.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(panelMainLayout.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblFromDate)
        						.addComponent(lblMSinhVin, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addGroup(panelMainLayout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(DateChooserFromDate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
        					.addGap(73)
        					.addGroup(panelMainLayout.createParallelGroup(Alignment.LEADING, false)
        						.addGroup(panelMainLayout.createSequentialGroup()
        							.addComponent(lblTodate, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
        							.addGap(34)
        							.addComponent(DateChooserTodate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        						.addGroup(panelMainLayout.createSequentialGroup()
        							.addComponent(lblTnSinhVin, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)))
        					.addGap(45)
        					.addComponent(lblStatus)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(cbxStatus1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
        					.addGap(34)
        					.addGroup(panelMainLayout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(btnAddAccount, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(btnSearch, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
        						.addComponent(btnFilter, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))))
        			.addGap(20))
        );
        panelMainLayout.setVerticalGroup(
        	panelMainLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panelMainLayout.createSequentialGroup()
        			.addGap(13)
        			.addGroup(panelMainLayout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(panelMainLayout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(btnFilter)
        					.addComponent(lblStatus)
        					.addComponent(cbxStatus1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        				.addGroup(panelMainLayout.createSequentialGroup()
        					.addGroup(panelMainLayout.createParallelGroup(Alignment.LEADING)
        						.addComponent(DateChooserTodate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(DateChooserFromDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblFromDate, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblTodate, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
        					.addGap(6)))
        			.addGroup(panelMainLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(panelMainLayout.createSequentialGroup()
        					.addGap(6)
        					.addComponent(btnSearch)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnAddAccount))
        				.addGroup(panelMainLayout.createSequentialGroup()
        					.addGap(22)
        					.addGroup(panelMainLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblMSinhVin, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
        						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblTnSinhVin, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
        						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
        			.addGap(18)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        panelMain.setLayout(panelMainLayout);

        menuBarAccout.setText("Account Manager");

        menuBarAccout.add(jMenuItemAccout);
        jMenuBar1.add(menuBarAccout);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(panelMain, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGap(38))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(panelMain, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(194, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);
        jMenuItemAccout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelMain.removeAll();
                panelMain.add(new JLabel("Quan ly tai khoan"));
            }
        });
        cbxStatus1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemSelected = cbxStatus1.getSelectedItem().toString();
                System.out.println("it== " + itemSelected);
                if (itemSelected.equals("")) {
                    status = "";
                }
                if (itemSelected.equals("Dá»—i")) {
                    status = "1";
                }
                if (itemSelected.equals("Ä�Ã£ mÆ°á»£n háº¿t")) {
                    status = "0";
                }
            }
        });
        loadCombobox();
        pack();
    }// </editor-fold>                        

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateFrom = "";
        String dateTo = "";
        if (DateChooserFromDate.getDate() != null) {
            dateFrom = sdf.format(DateChooserFromDate.getDate());
        }
        System.out.println("date from === " + dateFrom);
        if (DateChooserFromDate.getDate() != null) {
            dateTo = sdf.format(DateChooserTodate.getDate());
        }
        System.out.println("date to === " + dateTo);
        System.out.println("status == " + status);
        SearchOrFilter searchOrFilter = new SearchOrFilter();
        ArrayList<User> listFilter = searchOrFilter.filterUser(dateFrom, dateTo, status);
        updateModel(listFilter);
    }
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        String msv = textField.getText();
        String ten = textField_1.getText();
        SearchOrFilter searchOrFilter = new SearchOrFilter();
        ArrayList<User> listSearch = searchOrFilter.searchUser(msv,ten);
        updateModel(listSearch);
    }

    private void btnAddAccountActionPerformed(java.awt.event.ActionEvent evt) {
        them_user them = new them_user();
    }

    public void updateModel(ArrayList<User> listUser) {
        javax.swing.JFrame self = this;
        model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("ID");
        model.addColumn("Tên sinh viên");
        model.addColumn("Mã sinh viên");
        model.addColumn("Email");
        model.addColumn("Role");
        model.addColumn("ID School");
        model.addColumn("ID major");
        model.addColumn("ID faculty");
        model.addColumn("Update");
        int index = 0;
        for (User user : listUser) {
            Object[] values = new Object[10];
            values[0] = String.valueOf(user.getID());
            values[1] = user.getName();
            values[2] = user.getMasv();
            values[3] = user.getEmail();
            values[4] = user.getRole();
            values[5] = user.getId_school();
            values[6] = user.getId_major();
            values[7] = user.getId_faculty();
            values[8] = "Edit";
            model.addRow(values);
        }
        tbtData.setModel(model);
        tbtData.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                String data = (String) tbtData.getValueAt(tbtData.getSelectedRow(), 0);
                try {
                   UserDetail userDetail = new UserDetail(Integer.valueOf(data), self);
                } catch (SQLException ex) {
                    Logger.getLogger(AccountManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void loadCombobox() {
        cbxStatus1.addItem("Đã trả đúng hạn");
        cbxStatus1.addItem("Trả quá hạn");
        cbxStatus1.addItem("Đang mượn");
        cbxStatus1.addItem("Làm mất");
        //cbxStatus1.setSelectedIndex(listUser.size());
    }

    public static void main(String args[]) {
        AccountManager m = new AccountManager();
        // m.updateModel();
        //m.setVisible(true);
    }
}
