package chapter3.section4;

public class MyDate {
    public int year;
    public int month;
    public int day;

    public MyDate(int y, int m, int d) {
        this.year = y;
        this.month = m;
        this.day = d;
    }

    public String toString(){
        return year + "/" + month +"/" + day;
    }
}
