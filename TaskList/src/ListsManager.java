/* U08223 Week 1
 *
 * This class provides methods to manage the two lists of tasks.
 * Your code will complete the methods below.
 */

import java.util.*;

public class ListsManager {

    public ArrayList<String> highPriority, lowPriority;  // the two lists of tasks
    public TaskListGUI controller; // a reference to the main program, with the GUI

    /* Constructs a ListManager object. */
    public ListsManager(TaskListGUI ref) {
        // (you should not change the code in this method)
        controller = ref;
        initialiseLists();
    }

    /* Initialises both lists, to initially be empty. */
    public void initialiseLists() {
        highPriority = new ArrayList<>();
        lowPriority = new ArrayList<>();

    }


    /* Adds the given task to the end of the low-priority list.
     */
    public void addTask(String task) {
        lowPriority.add(task);

    }

    /* Removes the given task to the end of the high-priority list.
     * The index integer gives the current position of the task in
     * the relevant list of tasks. (You can assume that index is a
     * valid position in the relevant list.)
     */
    public void removeLowPriorityTask(int index) {
        lowPriority.remove(index);

    }


    /* Removes the given task from the high-priority list.
     * The index integer gives the current position of the task in
     * the relevant list of tasks. (You can assume that index is a
     * valid position in the relevant list.)
     */
    public void removeHighPriorityTask(int index) {
        highPriority.remove(index);

    }

    /* Changes the priority of the given task.
     * The given boolean important indicates the previous priority
     * of the task. e.g. if important is true, then the task was
     * a high-priority task.
     * The index integer gives the current position of the task in
     * the relevant list of tasks. (You can assume that index is a
     * valid position in the relevant list.)
     */
    public void changePriority(boolean important, int index) {
        if (important){
            String tempTask = highPriority.get(index);
            lowPriority.add(0, tempTask);
            highPriority.remove(index);
        }
        else{
            String tempTask = lowPriority.get(index);
            highPriority.add(tempTask);
            lowPriority.remove(index);
        }
       

    }

    /* Produces a string that can be used to save the task lists. */
    public String toString() {
        String st = new String("");

        st += "The high priority taks are: \n";
    for (String task:highPriority){
            st +=task + "\n";
        }

        st+= "Th low Priority taks are:\n";
    for (String task:lowPriority){
            st +=task + "\n";
        }

        return st;  // dummy return value (before this method is implemented)
    }

    /* Pushes an important task one higher up.
     * The index gives the current position of the task in the
     * highPriority list. (You can assume that index is a
     * valid position in the highPriority list.)
     */
    public void promote(int index) {
        String tempTask = highPriority.get(index);
        if (index != 0){
            String oldTask = highPriority.get(index-1);
            highPriority.add(index-1, tempTask);
            highPriority.remove(index);
            highPriority.set(index, oldTask);
        }

    }
}
