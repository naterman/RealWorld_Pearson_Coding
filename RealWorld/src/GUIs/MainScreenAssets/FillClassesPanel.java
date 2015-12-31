/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs.MainScreenAssets;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.Dimension;
import java.net.URL;
import java.util.LinkedList;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.Box;
import org.jdesktop.swingx.JXPanel;
import pearson.AuthenticationData;
import pearson.ClassInfo;
import pearson.usercourses.Courses;
import pearson.usercourses.MyCourses;

/**
 *
 * @author Nathan Smith
 */
public class FillClassesPanel {

    JXPanel classPanel;
    AuthenticationData data;
    LinkedList<ClassInfo> cInfo = new LinkedList<>();

    /**
     *
     * @param p
     * @param data
     */
    public FillClassesPanel(JXPanel p, AuthenticationData data) {
        this.classPanel = p;
        this.data = data;
    }

    /**
     * Fills the Current Class panel with classes the user is currently in
     */
    public void fill() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            URL apiUrl = new URL("https://api.learningstudio.com/me/courses?expand=course");
            HttpsURLConnection httpConn = (HttpsURLConnection) apiUrl.openConnection();
            httpConn.setRequestMethod("GET");

            for (Object headerName : data.getMapHttpHeaders().keySet()) {
                httpConn.addRequestProperty((String) headerName, (String) data.getMapHttpHeaders().get(headerName));
            }

            int responseCode = httpConn.getResponseCode();
            if (responseCode == 200) {
                
                MyCourses myCourses = mapper.readValue(httpConn.getInputStream(), MyCourses.class);
                for (Courses item : myCourses.getCourses()) {
                    ClassInfo newClass = new ClassInfo(item.getLinks().get(0).getCourse().getTitle(), item.getLinks().get(0).getCourse().getId());
                    cInfo.add(newClass);

                }

                for (ClassInfo item : cInfo) {
                    classPanel.add(Box.createRigidArea(new Dimension(25, 10)));
                    classPanel.add(new ClassPanel(item, data));
                    classPanel.revalidate();
                    classPanel.repaint();
                }
                classPanel.revalidate();
                classPanel.repaint();
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
}
