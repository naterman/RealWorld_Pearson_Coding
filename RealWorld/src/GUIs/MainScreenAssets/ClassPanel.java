/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs.MainScreenAssets;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.Color;
import java.awt.Font;
import java.net.URL;
import java.util.LinkedList;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.BorderFactory;
import org.jdesktop.swingx.JXButton;
import org.jdesktop.swingx.JXDialog;
import org.jdesktop.swingx.JXList;
import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.SwingXUtilities;
import pearson.AuthenticationData;
import pearson.ClassInfo;
import pearson.CourseInstructors.CourseInstructors;
import pearson.CourseInstructors.Instructor;
import pearson.StudentsEnrolled.Student;
import pearson.StudentsEnrolled.StudentsEnrolled;
import pearson.myrole.MyRole;

/**
 *
 * @author Nathan Smith
 */
public class ClassPanel extends JXPanel {

    /**
     * Creates new form Class
     */
    boolean Teacher;
    ClassInfo ClassData;
    LinkedList<String> names;
    String ButtonText;
    AuthenticationData data;

    public ClassPanel(ClassInfo c, AuthenticationData data) {
        this.data = data;
        ClassData = c;
        getRole role = new getRole("https://api.learningstudio.com/me/courses/" + c.getID() + "/role", data);
        String type = role.getType();
        switch (type) {
            case "STUD":
                Teacher = false;
                break;
            case "PROF":
                Teacher = true;
                break;
            default:
                Teacher = false;
                break;
        }
        if (Teacher == true) {
            ButtonText = "View Students";
        } else {
            ButtonText = "View Students";
        }
        initComponents();

        this.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));

    }

    private void initComponents() {

        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        ViewButton = new org.jdesktop.swingx.JXButton();
        ViewButton1 = new org.jdesktop.swingx.JXButton();

        jXLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jXLabel1.setText(ClassData.getName());
        jXLabel1.setToolTipText("");
        jXLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jXLabel1.setLineWrap(true);
        jXLabel1.setTextAlignment(org.jdesktop.swingx.JXLabel.TextAlignment.CENTER);

        ViewButton.setText(ButtonText);
        ViewButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ViewButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewButtonActionPerformed(evt);
            }
        });

        ViewButton1.setText("View Assignments");
        ViewButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ViewButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(ViewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(30, 30, 30)
                                        .addComponent(ViewButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jXLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ViewButton, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                                .addComponent(ViewButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                        .addContainerGap())
        );
    }

    private void ViewButtonActionPerformed(java.awt.event.ActionEvent evt) {

        LinkedList<String> names = null;

        if(Teacher == true)
        {
            names = getNames("https://api.learningstudio.com/courses/" + ClassData.getID() + "/students", true);
        }
        else {
            names = getNames("https://api.learningstudio.com/courses/" + ClassData.getID() + "/instructors", false);
        }

        JXList namesList = new JXList(names.toArray());
        namesList.setSize(600, 300);
        namesList.setBackground(null);
        namesList.setFont(new Font("ariel", Font.PLAIN, 14));
        JXDialog ViewNameDialog = new JXDialog(namesList);
        ViewNameDialog.setBounds(100, 100, 350, 350);
        ViewNameDialog.setVisible(true);

    }

    private void ViewButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        JXPanel MainPanel = SwingXUtilities.getAncestor(JXPanel.class, this.getParent());
        JXPanel assignmentsPanel = (JXPanel) MainPanel.getComponent(5);
        JXButton newAssignmentButton = (JXButton) MainPanel.getComponent(7);
        String buttonName = newAssignmentButton.getText();
        newAssignmentButton.setVisible(Teacher);
        MainPanel.revalidate();
        MainPanel.repaint();
        assignmentsPanel.removeAll();
        new Thread(new FillAssignmentPanel(Teacher, ClassData.getID(), assignmentsPanel, data)).start();
        
    }

    LinkedList<String> getNames(String Url, boolean teacher) {

        LinkedList<String> names = new LinkedList<>();
        try {
            URL apiUrl = new URL(Url);
            HttpsURLConnection httpConn = (HttpsURLConnection) apiUrl.openConnection();
            httpConn.setRequestMethod("GET");

            for (Object headerName : data.getMapHttpHeaders().keySet()) {
                httpConn.addRequestProperty((String) headerName, (String) data.getMapHttpHeaders().get(headerName));
            }

            int responseCode = httpConn.getResponseCode();
            if (responseCode == 200) {
                if (teacher == false) {
                    ObjectMapper mapper = new ObjectMapper();
                    CourseInstructors instructors = mapper.readValue(httpConn.getInputStream(), CourseInstructors.class);
                    for (Instructor prof : instructors.getInstructors()  ) {
                        names.add(prof.getFirstName() + " " + prof.getLastName());
                    }
                } else {
                    ObjectMapper mapper = new ObjectMapper();
                    StudentsEnrolled students = mapper.readValue(httpConn.getInputStream(), StudentsEnrolled.class);
                    for (Student stud : students.getStudents()) {
                        names.add(stud.getFirstName() + " " + stud.getLastName());
                    }
                }

                return names;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

    // Variables declaration - do not modify                     
    private org.jdesktop.swingx.JXButton ViewButton;
    private org.jdesktop.swingx.JXButton ViewButton1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    // End of variables declaration                   
}

class getRole {

    String role;

    public getRole(String Url, AuthenticationData data) {
        try {
            URL apiUrl = new URL(Url);
            HttpsURLConnection httpConn = (HttpsURLConnection) apiUrl.openConnection();
            httpConn.setRequestMethod("GET");

            for (Object headerName : data.getMapHttpHeaders().keySet()) {
                httpConn.addRequestProperty((String) headerName, (String) data.getMapHttpHeaders().get(headerName));
            }

            int responseCode = httpConn.getResponseCode();
            if (responseCode == 200) {
                ObjectMapper mapper = new ObjectMapper();
                MyRole myRole = mapper.readValue(httpConn.getInputStream(), MyRole.class);
                role = myRole.getRole().getType();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public String getType() {
        return this.role;
    }
}