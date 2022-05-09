package chapter3.section4;

import java.util.Scanner;

public class Scheduler {

    private int capacity;
    public Event[] events = new Event[capacity];
    public int n=0;
    private Scanner kb;

    public void processCommand(){
        kb = new Scanner(System.in);
        while (true){
            System.out.print("$ ");
            String command = kb.next();
            if(command.equals("addevent")){
                String type = kb.next();
                if(type.equalsIgnoreCase("oneday")){
                    handleAddOneDayEvent();
                }else if(type.equalsIgnoreCase("duration")){
                    handleAddDurationEvent();
                }else if(type.equalsIgnoreCase("deadline")){
                    handleAddDeadlinedEvent();
                }
            }else if(command.equals("list")){
                handleList();
            }else if(command.equals("show")){
                handleShow();
            }else if(command.equals("exit")){
                break;
            }
        }
        kb.close();
    }

    private void handleShow() {
        String dateString = kb.next();
        MyDate theDate = parseDateString(dateString);

        for(int i=0;i<n;i++){
            if(events[i].isRelevant(theDate)){
                System.out.println(events[i].toString());
            }
        }
    }

    private void handleList() {
        for(int i=0;i<n;i++){
            System.out.println("    " + events[i].toString());
        }
    }

    private void handleAddDeadlinedEvent() {
    }

    private void handleAddDurationEvent() {
    }

    private void handleAddOneDayEvent() {
        System.out.print("    when : ");
        String dateString = kb.next();
        System.out.print("    title : ");
        String title = kb.next();

        MyDate date = parseDateString(dateString);

        OneDayEvent ev = new OneDayEvent(title, date);

        addEvent(ev);

    }

    private void addEvent(OneDayEvent ev) {
        if(n >= capacity){
            reallocate();
        }
        events[n++] = ev;
    }

    private void reallocate() {
        Event[] tmp = new Event[capacity*2];
        for(int i=0;i<n;i++){
            tmp[i] = events[i];
        }
        events = tmp;
        capacity *=2;
    }

    private MyDate parseDateString(String dateString) {
        String[] tokens = dateString.split("/");
        int year = Integer.parseInt(tokens[0]);
        int month = Integer.parseInt(tokens[1]);
        int day = Integer.parseInt(tokens[2]);

        MyDate d = new MyDate(year, month, day);

        return d;
    }

    public static void main(String[] args) {

//        String str = "This is    a  test   string";
//        String[] str_tokens = str.split("[ ]+");
//        String[] str_tokens = str.split("\\s"); //모든 white space 검출

        Scheduler app = new Scheduler();
        app.processCommand();
    }
}
