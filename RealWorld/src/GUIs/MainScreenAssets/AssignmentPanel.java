/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs.MainScreenAssets;

import Design.Colors;
import GUIs.NewAssignment;
import GUIs.StudentAssignmentPanel;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import firebase.Assignment;
import firebase.FullAssignmentData;
import firebase.Question;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.JXDialog;
import org.jdesktop.swingx.JXFrame;
import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.JXTextArea;

/**
 *
 * @author Nathan Smith
 */
public class AssignmentPanel extends JXPanel {

    /**
     * Creates new form AssignmentPanel
     */
    boolean teacher;
    Assignment assignment;
    String courseID;

    /**
     *
     * @param teach
     * @param a
     * @param courseID
     */
    public AssignmentPanel(boolean teach, Assignment a, String courseID) {
        this.teacher = teach;
        this.assignment = a;
        this.courseID = courseID;

        initComponents();

        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        if (teach == true) {
            startButton.setVisible(false);
            infoButton.setVisible(false);
            
            if (!assignment.isEnable()) {
                disableButton.setText("Enable");
                disableButton.repaint();
            }
            
        } else {
            editButton.setVisible(false);
            disableButton.setVisible(false);
            deleteButton.setVisible(false);
            
            if (!assignment.isEnable()) {
                startButton.setVisible(false);
            }
            
            this.revalidate();
        }

    }

    private void initComponents() {

        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        editButton = new org.jdesktop.swingx.JXButton();
        disableButton = new org.jdesktop.swingx.JXButton();
        deleteButton = new org.jdesktop.swingx.JXButton();
        infoButton = new org.jdesktop.swingx.JXButton();
        startButton = new org.jdesktop.swingx.JXButton();

        jXLabel1.setText(assignment.getName());

        editButton.setText("Edit");

        disableButton.setText("Disable");

        deleteButton.setText("Delete");

        infoButton.setText("Info");

        startButton.setText("Start");

        editButton.setBackground(Colors.ButtonColorOrange.color());

        disableButton.setBackground(Colors.ButtonColorOrange.color());

        deleteButton.setBackground(Colors.ButtonColorOrange.color());

        infoButton.setBackground(Colors.ButtonColorOrange.color());

        startButton.setBackground(Colors.ButtonColorOrange.color());

        editButton.setForeground(Color.white);

        disableButton.setForeground(Color.white);

        deleteButton.setForeground(Color.white);

        infoButton.setForeground(Color.white);

        startButton.setForeground(Color.white);

        editButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                editButtonAction(e);
            }
        });

        disableButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                disableButtonAction(e);
            }
        });

        deleteButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                deleteButtonAction(e);
            }
        });

        infoButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                infoButtonAction(e);
            }
        });

        startButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                startButtonAction(e);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(disableButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                        .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jXLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(disableButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(infoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }

    private void editButtonAction(ActionEvent evt) {
        FullAssignmentData fullAssignment = new FullAssignmentData(assignment);
        fullAssignment.setCourseID(courseID);

        JXFrame editingPane = new JXFrame();
        editingPane.setExtendedState(JXFrame.MAXIMIZED_BOTH);
        editingPane.setLayout(new FlowLayout(FlowLayout.CENTER));
        editingPane.setDefaultCloseOperation(JXFrame.DISPOSE_ON_CLOSE);
        NewAssignment newAssignmentPanel = new NewAssignment(fullAssignment, false);
        editingPane.add(newAssignmentPanel);
        editingPane.getContentPane().setBackground(Colors.BackgroundGray.color());
        editingPane.setVisible(true);

    }

    private void disableButtonAction(ActionEvent evt) {
        final Firebase ref = new Firebase("https://glowing-inferno-9149.firebaseio.com/RealWorld/" + courseID + "/Assignments/" + assignment.getId());
        if (assignment.isEnable()) {
            assignment.setEnable(false);
            disableButton.setText("Enable");
        } else {
            assignment.setEnable(true);
            disableButton.setText("Disable");
        }

        disableButton.repaint();
        ref.setValue(assignment);
    }

    private void deleteButtonAction(ActionEvent evt) {

        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to Delete?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            final Firebase ref = new Firebase("https://glowing-inferno-9149.firebaseio.com/RealWorld/" + courseID);
            ref.child("Assignments").child(assignment.getId()).removeValue();
            Query qRef = ref.child("Data").child("Questions");
            qRef.addChildEventListener(new ChildEventListener() {

                @Override
                public void onChildAdded(DataSnapshot snapshot, String previousChildName) {
                    Question newQuestion = snapshot.getValue(Question.class);
                    if (newQuestion.getLinktoid().equals(assignment.getId())) {
                        ref.child("Data").child("Questions").child(newQuestion.getId()).removeValue();
                    }
                }

                @Override
                public void onChildChanged(DataSnapshot snapshot, String previousChildName) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void onChildRemoved(DataSnapshot snapshot) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void onChildMoved(DataSnapshot snapshot, String previousChildName) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void onCancelled(FirebaseError error) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
        }

    }

    private void startButtonAction(ActionEvent evt) {

        JXFrame assignmentPanel = new JXFrame();
        assignmentPanel.setExtendedState(JXFrame.MAXIMIZED_BOTH);
        assignmentPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        assignmentPanel.setDefaultCloseOperation(JXFrame.DISPOSE_ON_CLOSE);
        FullAssignmentData fullAssignment = new FullAssignmentData(assignment);
        fullAssignment.setCourseID(courseID);
        StudentAssignmentPanel newAssignmentPanel = new StudentAssignmentPanel(fullAssignment);

        assignmentPanel.add(newAssignmentPanel);
        assignmentPanel.getContentPane().setBackground(Colors.BackgroundGray.color());
        assignmentPanel.setVisible(true);

    }

    private void infoButtonAction(ActionEvent evt) {

        JXTextArea info = new JXTextArea();
        info.setText(assignment.getInfo());
        info.setEditable(false);
        info.setWrapStyleWord(true);
        JXDialog infoDialog = new JXDialog(info);
        infoDialog.setSize(500, 500);
        infoDialog.setLocationRelativeTo(this);
        infoDialog.setVisible(true);

    }

    // Variables declaration - do not modify                     
    private org.jdesktop.swingx.JXButton deleteButton;
    private org.jdesktop.swingx.JXButton disableButton;
    private org.jdesktop.swingx.JXButton editButton;
    private org.jdesktop.swingx.JXButton infoButton;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXButton startButton;
    // End of variables declaration                   
}
