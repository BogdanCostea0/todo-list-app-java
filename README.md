# todo-list-app-java
A simple Java app with some GUI

The ToDoListApp class represents a simple to-do list application with a graphical
user interface. It allows users to add and delete tasks from a list.
Class Structure:
ToDoListApp
frame: JFrame
taskListModel: DefaultListModel<String>
taskList: JList<String>
taskEntry: JTextField
Methods:
ToDoListApp():
Constructor method that initializes the graphical user interface.
Key Components:
JFrame:
The main window for the application.
DefaultListModel:
Stores the tasks in a list model.
JList:
Displays the tasks in a list format.
JTextField:
Allows users to enter new tasks.
Functionality:
Displaying Tasks:
The taskList JList displays the tasks added by the user.
It uses the taskListModel as the underlying data model.
The tasks are displayed in a scrollable pane using JScrollPane.
Adding Tasks:
ToDo App Java
Users can enter new tasks using the taskEntry JTextField.
The "Add Task" button adds the entered task to the taskListModel.
If no task is entered, a warning message is displayed.
Deleting Tasks:
Users can select a task from the taskList and click the "Delete Task" button.
A confirmation dialog is displayed to confirm the task deletion.
If a task is selected, it is removed from the taskListModel.
If no task is selected, a warning message is displayed.
Customization:
Fonts:
The taskList font is set to "Comic Sans" with a plain style and size 14.
The title label font is set to "Comic Sans" with a bold style and size 18.
Colors:
The "Add Task" button background color is set to RGB(76, 175, 80) (green).
The "Delete Task" button background color is set to RGB(244, 67, 54) (red).
The button foreground colors are set to white blue .
Layout:
BorderLayout:
The task list is positioned in the center of the frame.
The input components (taskEntry and buttons) are positioned in the south of the
frame.
The title label is positioned in the north of the frame.
