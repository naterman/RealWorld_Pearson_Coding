/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs.MainScreenAssets;

import com.firebase.client.AuthData;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.security.token.TokenGenerator;
import firebase.Assignment;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.UUID;
import javax.swing.Box;
import org.jdesktop.swingx.JXPanel;
import pearson.AuthenticationData;

/**
 *
 * @author Nathan Smith
 */
public class FillAssignmentPanel {

    boolean teacher;
    int courseID;
    JXPanel assignmentPanel;
    Firebase ref = new Firebase("https://glowing-inferno-9149.firebaseio.com/RealWorld");
    HashMap<String, Assignment> assignments = new HashMap<>();

    /**
     *
     * @param teach
     * @param ID
     * @param j
     * @param d
     */
    public FillAssignmentPanel(boolean teach, int ID, JXPanel j, AuthenticationData d) {
        this.teacher = teach;
        this.courseID = ID;
        this.assignmentPanel = j;

    }

    /**
     * Fills the Assignment Panel with current Assignments
     */
    public void fill() {
        UUID id = UUID.randomUUID();
        HashMap<String, Object> payload = new HashMap<>();
        payload.put("uid", id.toString());

        TokenGenerator tokenGenerator = new TokenGenerator("5o0SAwAWTiOLYdfoLXKgqRATnYWQzIqmV9fuqDNq");
        String token = tokenGenerator.createToken(payload);
        ref.authWithCustomToken(token, new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticationError(FirebaseError error) {
                System.err.println("Login Failed! " + error.getMessage());
            }

            @Override
            public void onAuthenticated(AuthData authData) {
                Firebase assignmentsRef = ref.child(String.valueOf(courseID)).child("Assignments");
                assignmentsRef.addChildEventListener(new ChildEventListener() {

                    @Override
                    public void onChildAdded(DataSnapshot snapshot, String previousChildName) {
                        Assignment newAssignment = snapshot.getValue(Assignment.class);
                        if (teacher == true || (teacher == false && newAssignment.isEnable())) {
                            assignments.put(newAssignment.getId(), newAssignment);
                        }
                        assignmentPanel.add(Box.createRigidArea(new Dimension(50, 15)));
                        assignmentPanel.add(new AssignmentPanel(teacher, newAssignment, String.valueOf(courseID)));
                        assignmentPanel.revalidate();
                        assignmentPanel.repaint();

                    }

                    @Override
                    public void onChildChanged(DataSnapshot snapshot, String previousChildName) {
                        assignmentPanel.removeAll();
                        for (Assignment item : assignments.values()) {
                            assignmentPanel.add(new AssignmentPanel(teacher, item, String.valueOf(courseID)));
                            assignmentPanel.revalidate();
                            assignmentPanel.repaint();

                            assignmentPanel.add(Box.createVerticalStrut(20));
                            assignmentPanel.revalidate();
                            assignmentPanel.repaint();
                        }
                    }

                    @Override
                    public void onChildRemoved(DataSnapshot snapshot) {

                        Assignment oldAssignment = snapshot.getValue(Assignment.class);
                        assignments.remove(oldAssignment.getId());
                        assignmentPanel.removeAll();
                        for (Assignment item : assignments.values()) {
                            assignmentPanel.add(new AssignmentPanel(teacher, item, String.valueOf(courseID)));
                            assignmentPanel.revalidate();
                            assignmentPanel.repaint();

                            assignmentPanel.add(Box.createVerticalStrut(20));
                            assignmentPanel.revalidate();
                            assignmentPanel.repaint();
                        }

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
        });
    }

}
