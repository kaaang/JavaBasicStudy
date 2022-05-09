package chapter3.section4;

public class DeadlinedEvent extends Event {
    public MyDate deadline;

    public DeadlinedEvent(String title, MyDate date) {
        super(title);
        this.deadline = date;
    }

    public String toString(){
        return title + ", " + deadline.toString();
    }
}
