package View.Quan_ly_tai_khoan;

import BaseClass.BaseClass;
import BaseClass.Validate;
import Controller.Quan_ly_tai_khoan.UserController;
import Model.Da.Da.UserDA;
import Model.Da.Faculty;
import Model.Da.Major;
import Model.Da.School;
import Model.Da.User;
import View.Quan_ly_kho.muon_sach;
import View.Thong_bao.Message;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//import static javafx.scene.input.KeyCode.T;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

public class FormRegister<T> extends JFrame {

    private Connection con = BaseClass.getConnectDb();
    private Message mes = BaseClass.getMessage();

    private JTextField txtUsername, txtPasswordAgain, txtEmail, txtMsv;
    private JPasswordField txtPassword;
    private JButton btnResgister, btnCancel;

    private JLabel lblUsername, lblPassword,
            lblPasswordAgain, lblMsv, lblEmail,
            lblSchool, lblFaculty, lblMarjor;

    private int sch_id = -1;
    private int fac_id = -1;
    private int maj_id = -1;

    private JComboBox cbxListSchool = new JComboBox();
    private JComboBox cbxListFaculty = new JComboBox();
    private JComboBox cbxListMajor = new JComboBox();

    public UserController userController;

    public ArrayList<School> listSchool;
    public ArrayList<Faculty> listFaculty;
    public ArrayList<Major> listMajor;

    private JFrame frameAfter = null;
    private int userID = -1;

    private Validate validator = new Validate();

    private UserDA userDa = new UserDA();

    public FormRegister(JFrame frameAfter, int userID) throws SQLException {
        this.frameAfter = frameAfter;
        this.userID = userID;
        userController = new UserController(this);
        this.setTitle("Ä�Äƒng kÃ½");
        this.setSize(780, 442);
        JLabel background = new JLabel(new ImageIcon(ClassLoader.getSystemResource("asset/img/bg_1.jpg")));
        background.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setContentPane(background);
        this.setLayout(new BorderLayout());

        String[] petStrings = {"Bird", "Cat", "Dog", "Rabbit", "Pig"};

        listSchool = userController.getListSchool();
        listFaculty = userController.getListFaculty();
        listMajor = userController.getListMajor();

        loadCombobox((ArrayList<T>) listSchool, cbxListSchool, 1);

        JPanel contend = new JPanel();
        contend.setLayout(new MigLayout("", "[][grow]", "[][]"));

        lblUsername = new JLabel("TÃªn truy nháº­p*");
        contend.add(lblUsername, "cell 0 0,alignx trailing");
        txtUsername = new JTextField();
        contend.add(txtUsername, "cell 1 0,growx");

        lblPassword = new JLabel("Máº­t kháº©u*");
        contend.add(lblPassword, "cell 0 1,alignx trailing");
        txtPassword = new JPasswordField();
        contend.add(txtPassword, "cell 1 1,growx");

        lblPasswordAgain = new JLabel("GÃµ láº¡i MK*");
        contend.add(lblPasswordAgain, "cell 0 2,alignx trailing");
        txtPasswordAgain = new JPasswordField();
        contend.add(txtPasswordAgain, "cell 1 2,growx");

        lblMsv = new JLabel("MÃ£ sinh viÃªn*");
        contend.add(lblMsv, "cell 0 3,alignx trailing");
        txtMsv = new JTextField();
        contend.add(txtMsv, "cell 1 3,growx");

        lblEmail = new JLabel("Email*");
        contend.add(lblEmail, "cell 0 4,alignx trailing");
        txtEmail = new JTextField();
        contend.add(txtEmail, "cell 1 4,growx");

        lblSchool = new JLabel("TrÆ°á»�ng*");
        contend.add(lblSchool, "cell 0 5,alignx trailing");
        contend.add(cbxListSchool, "cell 1 5,growx");

        lblFaculty = new JLabel("Khoa*");
        contend.add(lblFaculty, "cell 0 6,alignx trailing");
        contend.add(cbxListFaculty, "cell 1 6,growx");

        lblMarjor = new JLabel("NgÃ nh*");
        contend.add(lblMarjor, "cell 0 7,alignx trailing");
        contend.add(cbxListMajor, "cell 1 7,growx");

        btnResgister = new JButton("Ä�Äƒng KÃ½");
        btnCancel = new JButton("ThoÃ¡t");

        if (this.userID != -1) {
            loadCombobox((ArrayList<T>) listFaculty, cbxListFaculty, 2);
            loadCombobox((ArrayList<T>) listMajor, cbxListMajor, 3);
            btnResgister.setText("Cáº­p nháº­t");
            setTextIfEdit();
        }

        contend.add(btnResgister, "cell 1 8,growx");
        contend.add(btnCancel, "cell 1 8,growx");
        contend.setBackground(new Color(0f, 0f, 0f, 0f));
        contend.setBorder(BorderFactory.createEmptyBorder(30, 400, 0, 0));

        this.add(contend, BorderLayout.WEST);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        actionListener();

    }

    // type = 1 : truong
    // type = 2: khoa
    // type = 3 : nganh
    public void loadCombobox(ArrayList<T> list, JComboBox cbx, int type) {
        cbx.removeAllItems();
        if (list.size() == 0) {
            return;
        }
        for (T x : list) {
            if (type == 1) {
                School school = new School();
                school = (School) x;
                cbx.addItem(school.getId() + "-" + school.getName());
            }
            if (type == 2) {
                Faculty fac = new Faculty();
                fac = (Faculty) x;
                cbx.addItem(fac.getId() + "-" + fac.getName());
            }
            if (type == 3) {
                Major major = new Major();
                major = (Major) x;
                cbx.addItem(major.getId() + "-" + major.getName());
            }
        }
        cbx.setSelectedItem(null);
    }

    public void actionListener() {
        JFrame self = this;
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (frameAfter != null) {
                    frameAfter.setVisible(true);
                }
                self.dispose();
            }
        });

        btnResgister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "";
                message += !(validator.validateFieldRequired(txtUsername.getText(), lblUsername.getText()).equals(""))
                        ? validator.validateFieldRequired(txtUsername.getText(), lblUsername.getText())
                        + "\n" : "";
                message += !(validator.validateFieldRequired(txtPassword.getText(), lblPassword.getText()).equals(""))
                        ? validator.validateFieldRequired(txtPassword.getText(), lblPassword.getText())
                        + "\n" : "";
                message += !(validator.validateFieldRequired(txtPasswordAgain.getText(), lblPasswordAgain.getText()).equals(""))
                        ? validator.validateFieldRequired(txtPasswordAgain.getText(), lblPasswordAgain.getText())
                        + "\n" : "";
                message += !(validator.validateFieldRequired(txtMsv.getText(), lblMsv.getText())).equals("")
                        ? validator.validateFieldRequired(txtMsv.getText(), lblMsv.getText())
                        + "\n" : "";
                message += !(validator.validateFieldRequired(txtEmail.getText(), lblEmail.getText()).equals(""))
                        ? validator.validateFieldRequired(txtEmail.getText(), lblEmail.getText())
                        + "\n" : "";
                message += !(validator.validateSelected(cbxListSchool, lblSchool.getText())).equals("")
                        ? validator.validateSelected(cbxListSchool, lblSchool.getText())
                        + "\n" : "";
                message += !(validator.validateSelected(cbxListFaculty, lblFaculty.getText())).equals("")
                        ? validator.validateSelected(cbxListFaculty, lblFaculty.getText())
                        + "\n" : "";
                message += !(validator.validateSelected(cbxListMajor, lblMarjor.getText())).equals("")
                        ? validator.validateSelected(cbxListMajor, lblMarjor.getText())
                        + "\n" : "";
                message += !(validator.validateEmail(txtEmail.getText()).equals(""))
                        ? validator.validateEmail(txtEmail.getText())
                        + "\n" : "";
                message += !(validator.validateSamePass(txtPassword.getText(), txtPasswordAgain.getText()).equals(""))
                        ? validator.validateSamePass(txtPassword.getText(), txtPasswordAgain.getText())
                        : "";
                if (!message.equals("")) {
                    mes.showMessage("error", message);
                } else {
                    User us = new User();
                    us.setEmail(txtEmail.getText());
                    us.setName(txtUsername.getText());
                    us.setId_faculty(fac_id);
                    us.setId_major(maj_id);
                    us.setId_school(sch_id);
                    us.setPassword(txtPassword.getText());
                    us.setRole(2);
                    us.setMasv(Integer.valueOf(txtMsv.getText()));
                    if (userID != -1) {
                        if (!userDa.update(userID, us)) {
                            mes.showMessage("error", "Cáº­p nháº­t khÃ´ng thÃ nh cÃ´ng");
                        } else {
                            mes.showMessage("success", "Cáº­p nháº­t thÃ nh cÃ´ng");
                            self.dispose();
                        }
                    } else {
                        if (!userDa.create(us)) {
                            mes.showMessage("error", "Táº¡o má»›i khÃ´ng thÃ nh cÃ´ng");
                        } else {
                            mes.showMessage("success", "Táº¡o má»›i thÃ nh cÃ´ng");
                            self.dispose();
                        }
                    }
                    if (frameAfter != null) {
                        if (frameAfter instanceof muon_sach) {
                            muon_sach bookBorrow = (muon_sach) frameAfter;
                            bookBorrow.textField.setText(txtUsername.getText());
                            bookBorrow.textField_1.setText(txtMsv.getText());
                            bookBorrow.loadCombobox();
                            ArrayList<User> listUser = bookBorrow.listUser;
                            for (int i = 0; i < listUser.size(); i++) {
                                if (listUser.get(i).getMasv() == Integer.valueOf(txtMsv.getText())) {
                                    bookBorrow.comboBox_2.setSelectedIndex(i);
                                    break;
                                }
                            }
                        }
                        if (frameAfter instanceof FormLogin) {
                            FormLogin formLogin = (FormLogin) frameAfter;
                            formLogin.setTxtMail(txtEmail.getText());
                            formLogin.setTxtPass(txtPassword.getText());
                        }
                        frameAfter.setVisible(true);
                        self.dispose();
                    }

                }
            }
        });
        cbxListSchool.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String itemSelected = cbxListSchool.getSelectedItem().toString();
                sch_id = Regex.findNumber(itemSelected);
                try {
                    listFaculty = userController.getListFacultyBySchId(sch_id);
                    loadCombobox((ArrayList<T>) listFaculty, cbxListFaculty, 2);
                    cbxListFaculty.setSelectedItem(null);
                } catch (SQLException ex) {
                    Logger.getLogger(FormRegister.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        cbxListFaculty.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Object itemSelected = cbxListFaculty.getSelectedItem();
                if (itemSelected != null) {
                    try {
                        fac_id = Regex.findNumber(itemSelected.toString());
                        listMajor = userController.getListMajorByFacId(fac_id);
                        loadCombobox((ArrayList<T>) listMajor, cbxListMajor, 3);
                        cbxListMajor.setSelectedItem(null);
                    } catch (SQLException ex) {
                        Logger.getLogger(FormRegister.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        cbxListMajor.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Object itemSelected = cbxListMajor.getSelectedItem();
                if (itemSelected != null) {
                    maj_id = Regex.findNumber(itemSelected.toString());
                }
            }
        });
    }

    public void setTextIfEdit() throws SQLException {
        if (userID != -1) {
            User user = userDa.getUserByID(userID);
            txtUsername.setText(user.getName());
            txtEmail.setText(user.getEmail());
            txtMsv.setText(String.valueOf(user.getMasv()));
            txtPassword.setText(user.getPassword());
            txtPasswordAgain.setText(user.getPassword());
            if (user.getId_school() != -1) {
                setSelectedCombobox(cbxListSchool, user.getId_school(), 1, (ArrayList<T>) listSchool);
            }
            if (user.getId_faculty()!= -1) {
                setSelectedCombobox(cbxListFaculty, user.getId_faculty(), 2, (ArrayList<T>) listFaculty);
            }
            if (user.getId_major()!= -1) {
                setSelectedCombobox(cbxListMajor, user.getId_major(), 3, (ArrayList<T>) listMajor);
            }
        }
    }

    public void setSelectedCombobox(JComboBox cbx, int value, int type, ArrayList<T> list) {
        int size = list.size();
        if(size <= 0) return;
        for (int i = 0; i < size; i++) {
            if (type == 1) {
                School school = new School();
                school = (School) list.get(i);
                if (value == school.getId()) {
                    cbx.setSelectedIndex(i);
                    sch_id = value;
                    break;
                }
            }
            if (type == 2) {
                Faculty fac = new Faculty();
                fac = (Faculty) list.get(i);
                if (value == fac.getId()) {
                    cbx.setSelectedIndex(i);
                    fac_id = value;
                    break;
                }
            }
            if (type == 3) {
                Major major = new Major();
                major = (Major) list.get(i);
                if (value == major.getId()) {
                    cbx.setSelectedIndex(i);
                    maj_id = value;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        FormRegister f = new FormRegister(null, 38);
        f.actionListener();
    }
}
