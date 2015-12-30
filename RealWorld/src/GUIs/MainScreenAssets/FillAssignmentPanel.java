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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.UUID;
import org.jdesktop.swingx.JXPanel;
import pearson.AuthenticationData;

/**
 *
 * @author Nathan Smith
 */
public class FillAssignmentPanel implements Runnable {
    
    boolean Teacher;
    int CourseID;
    JXPanel AssignmentPanel;
    AuthenticationData data;
    Firebase ref = new Firebase("https://glowing-inferno-9149.firebaseio.com/RealWorld");
    LinkedList<Assignment> assignments = new LinkedList<>();
    
    public FillAssignmentPanel(boolean teach, int ID, JXPanel j, AuthenticationData d)
    {
        this.Teacher = teach;
        this.CourseID = ID;
        this.AssignmentPanel = j;
        this.data = d;
        
        
    }
    
    public void run()
    {
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
                Firebase assignmentsRef = ref.child(String.valueOf(CourseID)).child("Assignments");
                assignmentsRef.addChildEventListener(new ChildEventListener() {

                    @Override
                    public void onChildAdded(DataSnapshot snapshot, String previousChildName) {
                           Assignment newAssignment = snapshot.getValue(Assignment.class);
                           AssignmentPanel.add(new AssignmentPanel(Teacher, newAssignment, "12403107"));
                           AssignmentPanel.revalidate();
                           AssignmentPanel.repaint();
                           
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
        });
        
        System.out.print("Gotten to End");
    }
}
