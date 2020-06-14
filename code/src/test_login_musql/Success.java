/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_login_musql;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author daoud
 */
public class Success extends javax.swing.JFrame {
    
    String gender;
    String famele;
    String filename = null;
    byte[] person_image = null;
    
    public Success() {
        this.person_image = null;
        initComponents();
        show_user();
        
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
    }
    
    public ArrayList<User> userList(){
        ArrayList<User> UsersList = new ArrayList<>();
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetmysql", "root", "");
            String query1 = "SELECT * FROM users";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            
            User user;
            while (rs.next()) {
                
                user = new User(rs.getInt("sno"), rs.getString("name"), rs.getString("address"), rs.getString("gender"),rs.getString("knowledge"), rs.getString("subject"), rs.getBytes("image"), rs.getString("date"));
                UsersList.add(user);
            }
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
        return UsersList;
    }
    
    public void show_user(){
        ArrayList<User> list = userList();
        DefaultTableModel model = (DefaultTableModel) tabless.getModel();
        
        Object[] row = new Object[7];
        
        for (int i = 0; i < list.size(); i++) {
            
            row[0] = list.get(i).getsno();
            row[1] = list.get(i).getname();
            row[2] = list.get(i).getaddress();
            row[3] = list.get(i).getgender();
            row[4] = list.get(i).getknowledge();
            row[5] = list.get(i).getsubject();
            row[6] = list.get(i).getDate();
            model.addRow(row);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        genderr = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        coreJava = new javax.swing.JCheckBox();
        python = new javax.swing.JCheckBox();
        subject = new javax.swing.JComboBox<>();
        saveBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabless = new javax.swing.JTable();
        txt_image = new javax.swing.JLabel();
        btnImage = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        date_choose = new com.toedter.calendar.JDateChooser();
        searchdata = new javax.swing.JTextField();
        sno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Name");

        jLabel3.setText("Address");

        genderr.setText("Gender");

        jLabel5.setText("Knowledge");

        jLabel6.setText("Subject");

        buttonGroup1.add(male);
        male.setText("Male");
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });

        buttonGroup1.add(female);
        female.setText("Female");
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });

        coreJava.setText("Java");

        python.setText("Python");
        python.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pythonActionPerformed(evt);
            }
        });

        subject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Computer", "Management", "Humanities", "Arts", "Education" }));
        subject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectActionPerformed(evt);
            }
        });

        saveBtn.setBackground(new java.awt.Color(51, 51, 255));
        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        tabless.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sno", "Name", "Address", "Gender", "Knowledge", "Subject", "date"
            }
        ));
        tabless.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablessMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabless);

        btnImage.setText("Choose");
        btnImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_image, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnImage))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_image, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnImage)
                        .addGap(91, 91, 91)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        resetBtn.setForeground(new java.awt.Color(255, 51, 51));
        resetBtn.setText("Reset");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Date");

        searchdata.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchdataKeyReleased(evt);
            }
        });

        jLabel4.setText("Seach");

        jLabel7.setText("Sno");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(saveBtn)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton1)
                                    .addGap(18, 18, 18)
                                    .addComponent(deleteBtn)
                                    .addGap(18, 18, 18)
                                    .addComponent(resetBtn))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(genderr)
                                        .addComponent(jLabel6))
                                    .addGap(81, 81, 81)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(coreJava)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(python))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(male)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(female)))
                                            .addGap(36, 36, 36))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(subject, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(date_choose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGap(26, 26, 26))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(81, 81, 81)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(name)
                                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(searchdata, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(sno, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 20, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(genderr)
                            .addComponent(male)
                            .addComponent(female))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(coreJava)
                            .addComponent(python))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(subject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(date_choose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(resetBtn)
                            .addComponent(deleteBtn)
                            .addComponent(jButton1)
                            .addComponent(saveBtn))
                        .addGap(76, 76, 76))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(38, 38, 38))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetmysql", "root", "");
            String query = "INSERT INTO users (name, address, gender, knowledge, subject, image, date) VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name.getText());
            pst.setString(2, address.getText());
            
            if (male.isSelected()) {
                gender = "Male";
            }
            
            if (female.isSelected()) {
                famele = "Famele";
            }
            
            pst.setString(3, gender);
            String knowledge = "";
            
            if (coreJava.isSelected()) {
                knowledge += coreJava.getText() + " ";
            }
            
            if (python.isSelected()) {
                knowledge += python.getText() + " ";
            }
            
            pst.setString(4, knowledge);
            String course ;
            course = subject.getSelectedItem().toString();
            pst.setString(5, course);
            
            pst.setBytes(6, person_image);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(date_choose.getDate());
            pst.setString(7, date);
            
            pst.executeUpdate();
            
            DefaultTableModel model = (DefaultTableModel) tabless.getModel();
            model.setRowCount(0);
            show_user();
            
            JOptionPane.showMessageDialog(null, "Inserted Successfully");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
 
    }//GEN-LAST:event_saveBtnActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        name.setText("");
        address.setText("");
        buttonGroup1.clearSelection();
        coreJava.setSelected(false);
        python.setSelected(false);
        subject.setSelectedIndex(0);
        txt_image.setIcon(null);
    }//GEN-LAST:event_resetBtnActionPerformed

    private void subjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectActionPerformed

    private void pythonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pythonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pythonActionPerformed

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maleActionPerformed

    private void femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_femaleActionPerformed

    private void tablessMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablessMouseClicked
        
        int i = tabless.getSelectedRow();
        
        TableModel model = tabless.getModel();
        name.setText(model.getValueAt(i, 1).toString());
        sno.setText(model.getValueAt(i, 0).toString());
        address.setText(model.getValueAt(i, 2).toString());
        String sex = model.getValueAt(i, 3).toString();
        if (sex.equals("Male")) {
            male.setSelected(true);
        }else{
            female.setSelected(true);
        }
        String knowledge = model.getValueAt(i, 4).toString();
            switch(knowledge){
                case "Java ":
                    coreJava.setSelected(true);
                    python.setSelected(false);
                    break;
                case "Python ":
                    python.setSelected(true);
                    coreJava.setSelected(false);
                    break;  
                default:
                    coreJava.setSelected(true);
                    python.setSelected(true);
            }
            
            String subject1 = model.getValueAt(i, 5).toString();
            switch(subject1){
                case "Computer":
                    subject.setSelectedIndex(0);
                    break;
                
                case "Management":
                    subject.setSelectedIndex(1);
                    break;           
                    
                case "Humanities":
                    subject.setSelectedIndex(2);
                    break;
                    
                case "Arts":
                    subject.setSelectedIndex(3);
                    break;
                    
                case "Education":
                    subject.setSelectedIndex(4);
                    break;
            }
        
            byte[] img = (userList().get(i).getImage());
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(txt_image.getWidth(), txt_image.getHeight(), Image.SCALE_SMOOTH));
            txt_image.setIcon(imageIcon);
            person_image = img;
            
            try {
                int srow = tabless.getSelectedRow();
                Date date = new SimpleDateFormat("yyy-MM-dd").parse((String)model.getValueAt(srow, 6));
                date_choose.setDate(date);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_tablessMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetmysql", "root", "");
            //int row = tabless.getSelectedRow();
           // String value = (tabless.getModel().getValueAt(row, 0).toString());
            
            String value = sno.getText();
            String query = "UPDATE users SET name=?, address=?, gender=?, knowledge=?, subject=?, image=?, date=? WHERE sno="+value;
            
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name.getText());
            pst.setString(2, address.getText());
            
            if (male.isSelected()) {
                gender = "Male";
            }
            
            if (female.isSelected()) {
                famele = "Famele";
            }
            
            pst.setString(3, gender);
            String knowledge = "";
            
            if (coreJava.isSelected()) {
                knowledge += coreJava.getText() + " ";
            }
            
            if (python.isSelected()) {
                knowledge += python.getText() + " ";
            }
            
            pst.setString(4, knowledge);
            String course ;
            course = subject.getSelectedItem().toString();
            pst.setString(5, course);
            byte[] img = person_image;
            pst.setBytes(6, img);
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(date_choose.getDate());
            pst.setString(7, date);
            
            pst.executeUpdate();
            
            DefaultTableModel model = (DefaultTableModel) tabless.getModel();
            model.setRowCount(0);
            show_user();
            
            JOptionPane.showMessageDialog(null, "Updated Successfully");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        
        int opt = JOptionPane.showConfirmDialog(null, "Are you sure to delete", "Delete", JOptionPane.YES_NO_OPTION);
        
        if (opt == 0) {
                
            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetmysql", "root", "");
                int row = tabless.getSelectedRow();
                String value = (tabless.getModel().getValueAt(row, 0).toString());
                String query = "DELETE FROM users WHERE sno="+value;
                PreparedStatement pst = con.prepareStatement(query);
                pst.executeUpdate();

                DefaultTableModel model = (DefaultTableModel) tabless.getModel();
                model.setRowCount(0);
                
                show_user();

                JOptionPane.showMessageDialog(null, "Deleted Successfully");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void btnImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImageActionPerformed
       
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(txt_image.getWidth(), txt_image.getHeight(), Image.SCALE_SMOOTH));
        txt_image.setIcon(imageIcon);
        
        try {
            File  image = new File(filename);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for(int readNum; (readNum = fis.read(buf)) != -1;){
                bos.write(buf, 0, readNum);             
            }
            person_image = bos.toByteArray();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_btnImageActionPerformed

    private void searchdataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchdataKeyReleased
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetmysql", "root", "");
            String sql = "SELECT * FROM users WHERE sno=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, searchdata.getText());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String setid = rs.getString("sno");
                sno.setText(setid);
                
                String setName = rs.getString("name");
                name.setText(setName);
                String setadd = rs.getString("address");
                address.setText(setadd);
                String sex = rs.getString("gender");
                if (sex.equals("Male")) {
                    male.setSelected(true);                   
                }else{
                    female.setSelected(true);
                }
                String knowledge = rs.getString("knowledge");
                switch(knowledge){
                    case "Java ":
                        coreJava.setSelected(true);
                        python.setSelected(false);
                        break;
                    case "Python ":
                        python.setSelected(true);
                        coreJava.setSelected(false);
                        break;  
                    default:
                        coreJava.setSelected(true);
                        python.setSelected(true);
                        break;
                }
                
                String subject1 = rs.getString("subject");
                switch(subject1){
                    case "Computer":
                        subject.setSelectedIndex(0);
                        break;

                    case "Management":
                        subject.setSelectedIndex(1);
                        break;           

                    case "Humanities":
                        subject.setSelectedIndex(2);
                        break;

                    case "Arts":
                        subject.setSelectedIndex(3);
                        break;

                    case "Education":
                        subject.setSelectedIndex(4);
                        break;
                }
                date_choose.setDate(rs.getDate("date"));
                byte[] img = rs.getBytes("image");
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(txt_image.getWidth(), txt_image.getHeight(), Image.SCALE_SMOOTH));
                txt_image.setIcon(imageIcon);
                person_image = img;
                
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_searchdataKeyReleased

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
            java.util.logging.Logger.getLogger(Success.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Success.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Success.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Success.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Success().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JButton btnImage;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox coreJava;
    private com.toedter.calendar.JDateChooser date_choose;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JRadioButton female;
    private javax.swing.JLabel genderr;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton male;
    private javax.swing.JTextField name;
    private javax.swing.JCheckBox python;
    private javax.swing.JButton resetBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField searchdata;
    private javax.swing.JTextField sno;
    private javax.swing.JComboBox<String> subject;
    private javax.swing.JTable tabless;
    private javax.swing.JLabel txt_image;
    // End of variables declaration//GEN-END:variables
}
