package org.namo;

public class Pages {
    // The AddToList page where you add a task to your todolist.txt
    public static void AddToList() {
        while (true) {
            Functions.ClearScreen();
            Functions.Figlet("TodoList");
            Functions.ShowTasks();
            String task = Functions.Input("Enter your task: ");
            Functions.AddTask(task);
            System.out.println("\nAdded to todolist.txt");
            break;
        }
    }
    // Removes a task from the list
    public static void RemoveFromlist() {
        while (true) {
            Functions.ClearScreen();
            Functions.Figlet("TodoList");
            Functions.ShowTasks();
            String remove = Functions.Input("Enter a number to remove: ");
            int option = Integer.parseInt(remove);
            Functions.RemoveFromList(option);
            break;
        }
    }
}
