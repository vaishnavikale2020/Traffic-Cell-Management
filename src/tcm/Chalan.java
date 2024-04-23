/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcm;

import java.awt.print.PrinterJob;
import java.awt.print.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;
import javax.swing.JOptionPane;
import sun.security.pkcs11.Secmod;

/**
 *
 * @author lenovo
 */
public class Chalan extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
   
    mydb db;
    Connection conn;
    String Muname,mode;
    int MDid,MVid,MCid;
    public Chalan(String uname,String m) {
        
        db=new mydb();
        conn=db.getConnection();
        initComponents();
        update_btn.setVisible(false);
        delete_btn.setVisible(false);
        Muname=uname.trim();
        uname_lbl.setText(Muname);
        mode=m;
        chalanInit(mode);
        driverInit();
        vehicalInit();
        staffInit();
        //staffDetails_panel.setVisible(false);
        //staffDetInit();
    }

    void staffInit()
    {
        try {
            ResultSet rs=db.searchQuery("select * from staff");
            if(rs.isBeforeFirst()){
            while (rs.next())
            {
          //      Cstaff.addItem(rs.getInt("id")+" - "+rs.getString("name"));
            }
            }
            else
                { 
                    JOptionPane.showMessageDialog(this, "No Staff Entry Found\n(add a staff for chalan)","Staff Error",JOptionPane.ERROR);
                    new menuForm(Muname).setVisible(true);
                    this.dispose();
                }
        } catch (SQLException ex) {
            Logger.getLogger(Chalan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
                
           
           
    
    void chalanInit(String m)
    {
        
        try {
            int max=0;
            ResultSet rs=db.searchQuery("select MAX(c_id) from chalan ");
            if(rs.next())
            { 
                MCid=rs.getInt(1); 
                System.err.println("chalan no : "+rs.getInt(1));
            }
            chalan_id.setText(String.valueOf(MCid+1));
        } catch (SQLException ex) {  Logger.getLogger(Chalan.class.getName()).log(Level.SEVERE, null, ex);}
            if(mode.equals("driver"))
            {
                main.removeAll();
                main.revalidate();
                main.repaint();
                main.add(DriverInfo_panel);
                return;
            }
            if(mode.equals("vehical"))
            {
                main.removeAll();
                main.revalidate();
                main.repaint();
                main.add(vehicalInfo_panel);
                return;
            }
            if(mode.equals("chalan"))
            {
                main.removeAll();
                main.revalidate();
                main.repaint();
                main.add(chalanInfo_panel);
                return;
            }
          
        
    }
    void driverInit()
    {
        try {
           ResultSet rs=db.searchQuery("select MAX(id) from driver ");
            if(rs.next())
            { 
                MDid=rs.getInt(1); 
                System.err.println("driver no : "+rs.getInt(1));
            }
            driver_id.setText(String.valueOf(MDid+1));
        } catch (SQLException ex) {
            Logger.getLogger(Chalan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void vehicalInit()
    {
        try {
           ResultSet rs=db.searchQuery("select MAX(id) from vehical ");
            if(rs.next())
            { 
                MVid=rs.getInt(1); 
                System.err.println("vehical no : "+rs.getInt(1));
            }
            vehical_id.setText(String.valueOf(MVid+1));
        } catch (SQLException ex) {
            Logger.getLogger(Chalan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void clearAll()
    {
        driver_name.setText("");
        driver_height.setText("");
        driver_add1.setText("");
        driver_add2.setText("");
        driver_add_err.setText("");
        driver_age.setText("");
        driver_dob.setText("");
        driver_email.setText("");
        vehical_name.setText("");
        vehical_add_err.setText("");
        vehical_engine.setText("");
        vehical_fuel.setText("");
        vehical_regNo.setText("");
        chalan_err.setText("");
        chalan_fine.setText("");
        chalan_ipcno.setText("");
        chalan_longDes.setText("");
        chalan_normDes.setText("");
        chalan_offno.setText("");
        chalan_offDes.setText("");
        chalan_terms.setText("");
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grp = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        tcm = new javax.swing.JLabel();
        uname_lbl = new javax.swing.JLabel();
        main = new javax.swing.JPanel();
        DriverInfo_panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        driverPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        driver_id = new javax.swing.JTextField();
        driver_name = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        driver_age = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        driver_dob = new javax.swing.JTextField();
        driver_add1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        driver_height = new javax.swing.JTextField();
        driver_add2 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        driver_email = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        driver_add_err = new javax.swing.JLabel();
        driver_add3 = new javax.swing.JButton();
        vehicalInfo_panel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        vehicalPanel = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        vehical_id = new javax.swing.JTextField();
        vehical_name = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        vehical_regNo = new javax.swing.JTextField();
        vehical_fuel = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        vehical_engine = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        vehical_add_err = new javax.swing.JLabel();
        vehical_add1 = new javax.swing.JButton();
        chalanInfo_panel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        chalanPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        chalan_id = new javax.swing.JTextField();
        chalan_normDes = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        chalan_ipcno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        chalan_offno = new javax.swing.JTextField();
        chalan_offDes = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        chalan_longDes = new javax.swing.JTextField();
        chalan_fine = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        chalan_terms = new javax.swing.JTextField();
        add_chalan = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        chalan_err = new javax.swing.JLabel();
        update_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jButton2.setText("Menu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tcm.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        tcm.setForeground(new java.awt.Color(255, 102, 0));
        tcm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tcm.setText("TCM");

        uname_lbl.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        uname_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        uname_lbl.setText("uname");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(uname_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tcm, javax.swing.GroupLayout.DEFAULT_SIZE, 1457, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addComponent(uname_lbl)
                .addGap(47, 47, 47))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(87, 87, 87)
                    .addComponent(tcm, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(78, Short.MAX_VALUE)))
        );

        main.setBackground(new java.awt.Color(255, 51, 0));
        main.setLayout(new java.awt.CardLayout());

        driverPanel.setBackground(new java.awt.Color(255, 255, 204));

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel11.setText("*Driver ID :");

        driver_id.setEditable(false);
        driver_id.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        driver_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                driver_nameKeyPressed(evt);
            }
        });

        driver_name.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        driver_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                driver_nameKeyPressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel12.setText("*Driver Name :");

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel13.setText("*Age :");

        driver_age.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        driver_age.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                driver_nameKeyPressed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel14.setText("DOB :");

        driver_dob.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        driver_dob.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                driver_nameKeyPressed(evt);
            }
        });

        driver_add1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        driver_add1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                driver_nameKeyPressed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel15.setText("Height :");

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel16.setText("Address_1 :");

        driver_height.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        driver_height.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                driver_nameKeyPressed(evt);
            }
        });

        driver_add2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        driver_add2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                driver_nameKeyPressed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel17.setText("Address_2 :");

        jLabel18.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel18.setText("Email  :");

        driver_email.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        driver_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                driver_nameKeyPressed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 255, 102));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Driver Details");

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));

        driver_add_err.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        driver_add_err.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        driver_add3.setBackground(new java.awt.Color(0, 255, 0));
        driver_add3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        driver_add3.setText("ADD");
        driver_add3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                driver_add3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout driverPanelLayout = new javax.swing.GroupLayout(driverPanel);
        driverPanel.setLayout(driverPanelLayout);
        driverPanelLayout.setHorizontalGroup(
            driverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(driverPanelLayout.createSequentialGroup()
                .addContainerGap(239, Short.MAX_VALUE)
                .addGroup(driverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator4)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, driverPanelLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(driver_id, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(driver_name, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, driverPanelLayout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(driver_age, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(driver_dob, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, driverPanelLayout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(driver_add1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(driver_height, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, driverPanelLayout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(driver_add2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(driver_email, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, driverPanelLayout.createSequentialGroup()
                        .addGap(454, 454, 454)
                        .addComponent(driver_add3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151)
                        .addComponent(driver_add_err, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(240, Short.MAX_VALUE))
        );
        driverPanelLayout.setVerticalGroup(
            driverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(driverPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(driverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(driverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(driver_name)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(driverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(driver_id)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(66, 66, 66)
                .addGroup(driverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(driverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(driver_dob)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(driverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(driver_age)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(66, 66, 66)
                .addGroup(driverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(driverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(driver_height)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(driverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(driver_add1)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(66, 66, 66)
                .addGroup(driverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(driverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(driver_email)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(driverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(driver_add2)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(driverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(driver_add_err, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(driver_add3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        jScrollPane1.setViewportView(driverPanel);

        javax.swing.GroupLayout DriverInfo_panelLayout = new javax.swing.GroupLayout(DriverInfo_panel);
        DriverInfo_panel.setLayout(DriverInfo_panelLayout);
        DriverInfo_panelLayout.setHorizontalGroup(
            DriverInfo_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        DriverInfo_panelLayout.setVerticalGroup(
            DriverInfo_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE)
        );

        main.add(DriverInfo_panel, "card2");

        vehicalPanel.setBackground(new java.awt.Color(255, 255, 204));

        jLabel21.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel21.setText("*Vehical ID :");

        vehical_id.setEditable(false);
        vehical_id.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        vehical_name.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel22.setText("Vehical Name :");

        jLabel23.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel23.setText("*Reg No :");

        vehical_regNo.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        vehical_fuel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel26.setText("Fuel type :");

        vehical_engine.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel27.setText("Engine Type :");

        jLabel29.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(102, 255, 102));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Vehical Details");

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));

        vehical_add_err.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        vehical_add_err.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        vehical_add1.setBackground(new java.awt.Color(0, 255, 0));
        vehical_add1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        vehical_add1.setText("ADD");
        vehical_add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehical_add1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout vehicalPanelLayout = new javax.swing.GroupLayout(vehicalPanel);
        vehicalPanel.setLayout(vehicalPanelLayout);
        vehicalPanelLayout.setHorizontalGroup(
            vehicalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vehicalPanelLayout.createSequentialGroup()
                .addGroup(vehicalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator6)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, vehicalPanelLayout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(vehical_id, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(vehical_name, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, vehicalPanelLayout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(vehical_regNo, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, vehicalPanelLayout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(vehical_fuel, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, vehicalPanelLayout.createSequentialGroup()
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(vehical_engine, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, vehicalPanelLayout.createSequentialGroup()
                        .addGap(521, 521, 521)
                        .addComponent(vehical_add1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(vehical_add_err, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(479, Short.MAX_VALUE))
        );
        vehicalPanelLayout.setVerticalGroup(
            vehicalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vehicalPanelLayout.createSequentialGroup()
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(vehicalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(vehicalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(vehical_name)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(vehicalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(vehical_id)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(66, 66, 66)
                .addGroup(vehicalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(vehical_regNo)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(vehicalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(vehical_fuel)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(vehicalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(vehical_engine)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(vehicalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vehical_add_err, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vehical_add1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        jScrollPane2.setViewportView(vehicalPanel);

        javax.swing.GroupLayout vehicalInfo_panelLayout = new javax.swing.GroupLayout(vehicalInfo_panel);
        vehicalInfo_panel.setLayout(vehicalInfo_panelLayout);
        vehicalInfo_panelLayout.setHorizontalGroup(
            vehicalInfo_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        vehicalInfo_panelLayout.setVerticalGroup(
            vehicalInfo_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );

        main.add(vehicalInfo_panel, "card2");

        chalanPanel.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("*Chalan Norm No :");

        chalan_id.setEditable(false);
        chalan_id.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        chalan_normDes.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setText("*Chalan Norm Description :");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setText("IPC no :");

        chalan_ipcno.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setText("Offence No :");

        chalan_offno.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        chalan_offDes.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel5.setText("long description :");

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setText("Offence Description :");

        chalan_longDes.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        chalan_fine.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        chalan_fine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chalan_fineActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel7.setText("*Financial Fine :");

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel8.setText("Imprisenment terms :");

        chalan_terms.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        add_chalan.setBackground(new java.awt.Color(0, 255, 0));
        add_chalan.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        add_chalan.setText("ADD");
        add_chalan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_chalanActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 255, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Chalan Details");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));

        chalan_err.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        chalan_err.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        update_btn.setText("Update");
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });

        delete_btn.setForeground(new java.awt.Color(255, 51, 0));
        delete_btn.setText("Delete");
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout chalanPanelLayout = new javax.swing.GroupLayout(chalanPanel);
        chalanPanel.setLayout(chalanPanelLayout);
        chalanPanelLayout.setHorizontalGroup(
            chalanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chalanPanelLayout.createSequentialGroup()
                .addGroup(chalanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chalanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator2)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, chalanPanelLayout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(chalan_id, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(chalan_normDes, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, chalanPanelLayout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(chalan_ipcno, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(chalan_offno, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, chalanPanelLayout.createSequentialGroup()
                            .addGap(447, 447, 447)
                            .addComponent(update_btn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(delete_btn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chalan_err, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, chalanPanelLayout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(chalan_offDes, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(chalan_longDes, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, chalanPanelLayout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(chalan_fine, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(chalan_terms, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(chalanPanelLayout.createSequentialGroup()
                        .addGap(539, 539, 539)
                        .addComponent(add_chalan, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(477, Short.MAX_VALUE))
        );
        chalanPanelLayout.setVerticalGroup(
            chalanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chalanPanelLayout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(chalanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(chalanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(chalan_normDes)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, chalanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chalan_id, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)))
                .addGap(65, 65, 65)
                .addGroup(chalanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chalanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chalan_offno, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chalan_ipcno, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(chalanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chalan_offDes, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chalan_longDes, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(chalanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chalanPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addGroup(chalanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chalan_fine, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(303, 303, 303))
                    .addGroup(chalanPanelLayout.createSequentialGroup()
                        .addGroup(chalanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(chalanPanelLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(chalanPanelLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(chalan_terms, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37)
                        .addComponent(add_chalan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(chalan_err, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(chalanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jScrollPane3.setViewportView(chalanPanel);

        javax.swing.GroupLayout chalanInfo_panelLayout = new javax.swing.GroupLayout(chalanInfo_panel);
        chalanInfo_panel.setLayout(chalanInfo_panelLayout);
        chalanInfo_panelLayout.setHorizontalGroup(
            chalanInfo_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chalanInfo_panelLayout.createSequentialGroup()
                .addGap(0, 23, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1460, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        chalanInfo_panelLayout.setVerticalGroup(
            chalanInfo_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );

        main.add(chalanInfo_panel, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void add_chalanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_chalanActionPerformed
        // TODO add your handling code here:
        
        String Cnorm_des=chalan_normDes.getText().trim().toLowerCase();
        String Cipc_no=chalan_ipcno.getText().trim().toLowerCase();
        String Coffence_no=chalan_offno.getText().trim().toLowerCase();
        String Coffence_des=chalan_offDes.getText().trim().toLowerCase();
        String Clong_des=chalan_longDes.getText().trim().toLowerCase();
        String Cfine=chalan_fine.getText().trim().toLowerCase();
        String Cterms=chalan_terms.getText().trim().toLowerCase();
        
        if(db.addChalan(Cfine,Cipc_no,Cnorm_des,Coffence_no,Coffence_des,Clong_des,Cterms))
        {
            //chalanInit();
            chalan_err.setText("Added");
        }
        
       
            
        
    }//GEN-LAST:event_add_chalanActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        menuForm mf=new menuForm(Muname);
        mf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void driver_nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_driver_nameKeyPressed
        // TODO add your handling code here
        driver_add_err.setText(null);
    }//GEN-LAST:event_driver_nameKeyPressed

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
        // TODO add your handling code here:
   
        String Cnorm_des=chalan_normDes.getText().trim().toLowerCase();
        String Cipc_no=chalan_ipcno.getText().trim().toLowerCase();
        String Coffence_no=chalan_offno.getText().trim().toLowerCase();
        String Coffence_des=chalan_offDes.getText().trim().toLowerCase();
        String Clong_des=chalan_longDes.getText().trim().toLowerCase();
        String Cfine=chalan_fine.getText().trim().toLowerCase();
        String Cterms=chalan_terms.getText().trim().toLowerCase();
        int CId=Integer.parseInt(chalan_id.getText().trim());
        if(db.uptChalan(CId,Cfine,Cipc_no,Cnorm_des,Coffence_no,Coffence_des,Clong_des,Cterms))
        {
            //chalanInit();
            chalan_err.setText("Updated");
        }
        
            JOptionPane.showMessageDialog(this,"Done Update!","Done",JOptionPane.INFORMATION_MESSAGE);
    //        if(choice
            //{}
//            else{
                clearAll();
                main.removeAll();
                main.repaint();
                main.revalidate();
                main.add(DriverInfo_panel);
                chalan_id.setText(null);  //          
    }//GEN-LAST:event_update_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        // TODO add your handling code here:
        db.deleteQuery("delete from chalan where c_id='"+chalan_id.getText().trim()+"'");
        db.deleteQuery("delete from driver where id='"+driver_id.getText().trim()+"'");
        db.deleteQuery("delete from from vehical where id='"+vehical_id.getText().trim()+"'");
        clearAll();
        JOptionPane.showMessageDialog(this, "Done Delete!");
       // refresh_btnActionPerformed(evt);
    }//GEN-LAST:event_delete_btnActionPerformed

    private void driver_add3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_driver_add3ActionPerformed
        // TODO add your handling code here:
        if(driver_id.getText().trim().equals("")||driver_name.getText().trim().equals("")||driver_age.getText().trim().equals(""))//driver_dob.getText().trim().equals("")||driver_email.getText().trim().equals("")||driver_height.getText().trim().equals("")||driver_add1.getText().trim().equals("")||driver_add2.getText().trim().equals("")||driver_add_err.getText().trim().equals(""))
        {
            driver_add_err.setText("Empty Fields / * fields should be filled");
            return;
        }
        else{
        String Dname=driver_name.getText().trim().toLowerCase();
        String Dage=driver_age.getText().trim().toLowerCase();
        String Ddob=driver_dob.getText().trim().toLowerCase();
        String Dheight=driver_height.getText().trim().toLowerCase();
        String Demail=driver_email.getText().trim().toLowerCase();
        String Daddress1=driver_add1.getText().trim().toLowerCase();
        String Daddress2=driver_add2.getText().trim().toLowerCase();
        int Did=Integer.parseInt(driver_id.getText().trim());
        if(db.addDriver( Dname, Dage, Ddob, Dheight, Demail, Daddress1, Daddress2))
        {
//            driverInit();
            driver_add_err.setText("Added");
            driverInit();
            driver_add_err.setText("Added");
        }
        else{
            driver_add_err.setText("Not Added");
        }
        }
    }//GEN-LAST:event_driver_add3ActionPerformed

    private void vehical_add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehical_add1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vehical_add1ActionPerformed

    private void chalan_fineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chalan_fineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chalan_fineActionPerformed

    void updateInit()
    {
        clearAll();
        update_btn.setVisible(true);
        delete_btn.setVisible(true);
        add_chalan.setVisible(false);
        String id=JOptionPane.showInputDialog(this,"Enter Chalan ID");
        
        ResultSet rs=db.searchQuery("select * from chalan where c_id='"+id.trim()+"'");
        try{
        if(rs.next())
        {
            
                driver_id.setText(String.valueOf(rs.getInt("chalan_driver_id")));
                vehical_id.setText(String.valueOf(rs.getInt("chalan_vehical_id")));
                chalan_id.setText(String.valueOf(rs.getInt("c_id")));
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Problem Fetching!");
        }
        rs=db.searchQuery("select * from driver where id='"+driver_id.getText().trim()+"'");
                //driver
                if(rs.next()){
                driver_add_err.setText("Retrived");
                driver_name.setText(rs.getString("name"));
                driver_age.setText(rs.getString("age"));
                driver_height.setText(rs.getString("height"));
                driver_email.setText(rs.getString("email"));
                driver_dob.setText(rs.getString("dob"));
                driver_add1.setText(rs.getString("address1"));
                driver_add2.setText(rs.getString("address2"));
                }
                else
                    driver_add_err.setText("problem fetching");
        rs=db.searchQuery("select * from vehical where id='"+vehical_id.getText().trim()+"'");
                //vehical
                if(rs.next()){
                vehical_name.setText(rs.getString("name"));
                vehical_regNo.setText(rs.getString("reg_no"));
                vehical_fuel.setText(rs.getString("fuel_type"));
                vehical_engine.setText(rs.getString("engine_type"));
                vehical_add_err.setText("Retrived");
                }
                else
                {
                    vehical_add_err.setText("problem Fetching!");
                }
        rs=db.searchQuery("select * from chalan where c_id='"+chalan_id.getText().trim()+"'");
                //chalan
                if(rs.next()){
                chalan_normDes.setText(rs.getString("description"));
                chalan_fine.setText(rs.getString("fine"));
                chalan_ipcno.setText(rs.getString("ipc_no"));
                chalan_offno.setText(rs.getString("offence_no"));
                chalan_offDes.setText(rs.getString("offence_description"));
                chalan_longDes.setText(rs.getString("long_description"));
                chalan_terms.setText(rs.getString("terms"));
                //Cstaff.setSelectedItem(rs.getString("sname"));
                
                }
                else
                {
                    vehical_add_err.setText("problem Fetching!");
                }        
        }catch (SQLException ex) {
                Logger.getLogger(Chalan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Chalan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chalan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chalan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chalan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DriverInfo_panel;
    private javax.swing.JButton add_chalan;
    private javax.swing.JPanel chalanInfo_panel;
    private javax.swing.JPanel chalanPanel;
    private javax.swing.JLabel chalan_err;
    private javax.swing.JTextField chalan_fine;
    private javax.swing.JTextField chalan_id;
    private javax.swing.JTextField chalan_ipcno;
    private javax.swing.JTextField chalan_longDes;
    private javax.swing.JTextField chalan_normDes;
    private javax.swing.JTextField chalan_offDes;
    private javax.swing.JTextField chalan_offno;
    private javax.swing.JTextField chalan_terms;
    private javax.swing.JButton delete_btn;
    private javax.swing.JPanel driverPanel;
    private javax.swing.JTextField driver_add1;
    private javax.swing.JTextField driver_add2;
    private javax.swing.JButton driver_add3;
    private javax.swing.JLabel driver_add_err;
    private javax.swing.JTextField driver_age;
    private javax.swing.JTextField driver_dob;
    private javax.swing.JTextField driver_email;
    private javax.swing.JTextField driver_height;
    private javax.swing.JTextField driver_id;
    private javax.swing.JTextField driver_name;
    private javax.swing.ButtonGroup grp;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JPanel main;
    public javax.swing.JLabel tcm;
    private javax.swing.JLabel uname_lbl;
    private javax.swing.JButton update_btn;
    private javax.swing.JPanel vehicalInfo_panel;
    private javax.swing.JPanel vehicalPanel;
    private javax.swing.JButton vehical_add1;
    private javax.swing.JLabel vehical_add_err;
    private javax.swing.JTextField vehical_engine;
    private javax.swing.JTextField vehical_fuel;
    private javax.swing.JTextField vehical_id;
    private javax.swing.JTextField vehical_name;
    private javax.swing.JTextField vehical_regNo;
    // End of variables declaration//GEN-END:variables
}
