import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ToDoApp {
    public ToDoApp() {
        JFrame frame = new JFrame("To Do App");

        JPanel westPanel = new JPanel();
        JPanel projectsPanel = new JPanel();
        JLabel projectsLabel = new JLabel("Projects");
        projectsPanel.setLayout(new FlowLayout());
        projectsLabel.setFont(new Font("Serif", Font.BOLD, 30));
        projectsLabel.setForeground(Color.gray);
        projectsPanel.add(projectsLabel);


        westPanel.add(projectsPanel);
        westPanel.setPreferredSize(new Dimension(370, 600));
        frame.add(westPanel, BorderLayout.WEST);


        //4. Size the frame.
        frame.setSize(800, 600);
        frame.setResizable(false);


        //5. Show it.
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        ToDoApp newApp = new ToDoApp();
    }
}