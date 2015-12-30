/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs.MainScreenAssets;

import firebase.Assignment;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import org.jdesktop.swingx.JXButton;
import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.SwingXUtilities;

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

    public AssignmentPanel(boolean teach, Assignment a, String courseID ) {
        this.teacher = teach;
        this.assignment = a;
        this.courseID = courseID;
        
        
        initComponents();
        this.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        if (teach == true) {
            startButton.setVisible(false);
            infoButton.setVisible(false);
            this.revalidate();
        } else {
            editButton.setVisible(false);
            disableButton.setVisible(false);
            deleteButton.setVisible(false);
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
        
        
        editButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                 EditButtonAction(e);
            }
        });
        
        disableButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                DisableButtonAction(e);
            }
        });
        
        deleteButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteButtonAction(e);
            }
        });
        
        infoButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                InfoButtonAction(e);
            }
        });
        
        startButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                StartButtonAction(e);
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
    
    
    
    private void EditButtonAction(ActionEvent evt) {
        
        
    }
    
    private void DisableButtonAction(ActionEvent evt) {
        
        
    }
    
    private void DeleteButtonAction(ActionEvent evt) {
        
        
    }
    
    private void StartButtonAction(ActionEvent evt) {
        
        
    }
    
    private void InfoButtonAction(ActionEvent evt) {
        
        
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

//ViewButton1.addActionListener(new java.awt.event.ActionListener() {
//            @Override
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                ViewButton1ActionPerformed(evt);
//            }
//        });

//private void ViewButton1ActionPerformed(java.awt.event.ActionEvent evt) {
//        JXPanel MainPanel = SwingXUtilities.getAncestor(JXPanel.class, this.getParent());
//        JXPanel assignmentsPanel = (JXPanel) MainPanel.getComponent(5);
//        JXButton newAssignmentButton = (JXButton) MainPanel.getComponent(7);
//        String buttonName = newAssignmentButton.getText();
//        newAssignmentButton.setVisible(Teacher);
//        MainPanel.revalidate();
//        MainPanel.repaint();
//        assignmentsPanel.removeAll();
//        new Thread(new FillAssignmentPanel(Teacher, ClassData.getID(), assignmentsPanel, data)).start();
//        
//    }