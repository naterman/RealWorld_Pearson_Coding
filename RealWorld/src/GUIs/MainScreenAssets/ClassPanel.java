/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs.MainScreenAssets;

import GUIs.CreateAssignment;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    boolean teacher;
    ClassInfo classData;
    LinkedList<String> names;
    String buttonText;
    AuthenticationData data;

    /**
     *
     * @param c
     * @param data
     */
    public ClassPanel(ClassInfo c, AuthenticationData data) {
        this.data = data;
        classData = c;
        GetRole role = new GetRole("https://api.learningstudio.com/me/courses/" + c.getID() + "/role", data);
        String type = role.getType();
        switch (type) {
            case "STUD":
                teacher = false;
                break;
            case "PROF":
                teacher = true;
                break;
            default:
                teacher = false;
                break;
        }
        if (teacher == true) {
            buttonText = "View Students";
        } else {
            buttonText = "View Teachers";
        }
        initComponents();

        this.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));

    }

    private void initComponents() {

        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        viewButton = new org.jdesktop.swingx.JXButton();
        viewButton1 = new org.jdesktop.swingx.JXButton();

        jXLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jXLabel1.setText(classData.getName());
        jXLabel1.setToolTipText("");
        jXLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jXLabel1.setLineWrap(true);
        jXLabel1.setTextAlignment(org.jdesktop.swingx.JXLabel.TextAlignment.CENTER);

        viewButton.setText(buttonText);
        viewButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });

        viewButton1.setText("View Assignments");
        viewButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        viewButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButton1ActionPerformed(evt);
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
                                        .addComponent(viewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(30, 30, 30)
                                        .addComponent(viewButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                .addComponent(viewButton, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                                .addComponent(viewButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                        .addContainerGap())
        );
    }

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {

        LinkedList<String> names = null;

        if (teacher == true) {
            names = getNames("https://api.learningstudio.com/courses/" + classData.getID() + "/students", true);
        } else {
            names = getNames("https://api.learningstudio.com/courses/" + classData.getID() + "/instructors", false);
        }

        JXList namesList = new JXList(names.toArray());
        namesList.setSize(600, 300);
        namesList.setBackground(null);
        namesList.setFont(new Font("ariel", Font.PLAIN, 14));
        JXDialog ViewNameDialog = new JXDialog(namesList);
        ViewNameDialog.setBounds(100, 100, 350, 350);
        ViewNameDialog.setVisible(true);

    }

    private void viewButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        JXPanel MainPanel = SwingXUtilities.getAncestor(JXPanel.class, this.getParent());
        JXPanel assignmentsPanel = (JXPanel) MainPanel.getComponent(5);
        JXButton newAssignmentButton = (JXButton) MainPanel.getComponent(7);
        newAssignmentButton.setVisible(teacher);

        if (newAssignmentButton.getActionListeners().length == 0) {
            newAssignmentButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    newAssignmentButtonAction(e);
                }
            });
        }

        MainPanel.revalidate();
        MainPanel.repaint();
        assignmentsPanel.removeAll();
        FillAssignmentPanel FillAPanel = new FillAssignmentPanel(teacher, classData.getID(), assignmentsPanel, data);
        FillAPanel.fill();
    }

    private void newAssignmentButtonAction(ActionEvent evt) {
        JXDialog naFrame = new JXDialog(new CreateAssignment(String.valueOf(classData.getID())));
        naFrame.setLocationRelativeTo(this);

        naFrame.setSize(425, 400);
        naFrame.setVisible(true);
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
                    for (Instructor prof : instructors.getInstructors()) {
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
        }
        catch (RuntimeException rex)
        {
            throw rex;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

    // Variables declaration - do not modify                     
    private org.jdesktop.swingx.JXButton viewButton;
    private org.jdesktop.swingx.JXButton viewButton1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    // End of variables declaration                   
}

class GetRole {

    String role;

    public GetRole(String Url, AuthenticationData data) {
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
        } 
        catch (RuntimeException rex)
        {
            throw rex;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public String getType() {
        return this.role;
    }
}
