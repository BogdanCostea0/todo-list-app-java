import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoListApp {
    private JFrame frame;
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskEntry;
    
    public ToDoListApp() {
        frame = new JFrame("To-Do List App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(new BorderLayout());
        
        // Create a panel for the title
        JPanel titlePanel = new JPanel();
        titlePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        JLabel titleLabel = new JLabel("To-Do List");
        titleLabel.setFont(new Font("Comic Sans", Font.BOLD, 18));
        titlePanel.add(titleLabel);
        titlePanel.setBackground(new Color(149, 200, 216));
        frame.add(titlePanel, BorderLayout.NORTH);
        
        // Create a DefaultListModel to store tasks
        taskListModel = new DefaultListModel<>();
        
        // Create JList and customize its appearance
        taskList = new JList<>(taskListModel);
        taskList.setFont(new Font("Comic Sans", Font.PLAIN, 14));
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        taskList.setBackground(new Color(230, 230, 230));
        
        // Create a JScrollPane to add the task list
        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setPreferredSize(new Dimension(350, 250));
        frame.add(scrollPane, BorderLayout.CENTER);
        
        // Create a panel for input components
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        inputPanel.setBackground(new Color(149, 200, 216));
        // Create a text field for entering tasks
        taskEntry = new JTextField(20);
        inputPanel.add(taskEntry);
        
        // Create the "Add Task" button
        JButton addButton = new JButton("Add Task");
        addButton.setFont(new Font("Comic Sans", Font.PLAIN, 14));
        addButton.setBackground(new Color(76, 175, 80));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        
        // Add an action listener to handle adding tasks
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = taskEntry.getText();
                if (!task.isEmpty()) {
                    taskListModel.addElement(task);
                    taskEntry.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter a task.", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        inputPanel.add(addButton);
        
        // Create the "Delete Task" button
        JButton deleteButton = new JButton("Delete Task");
        deleteButton.setFont(new Font("Comic Sans", Font.PLAIN, 14));
        deleteButton.setBackground(new Color(244, 67, 54));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFocusPainted(false);
        
        // Add an action listener to handle deleting tasks
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    String selectedTask = taskListModel.getElementAt(selectedIndex);
                    int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete '" + selectedTask + "'?", "Confirmation", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        taskListModel.remove(selectedIndex);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a task to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        inputPanel.add(deleteButton);
        
        frame.add(inputPanel, BorderLayout.SOUTH);
        
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ToDoListApp();
            }
        });
    }
}







