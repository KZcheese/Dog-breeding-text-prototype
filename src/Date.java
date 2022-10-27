public class Date {
    private int date = 0;

    public int getDate(){
        return date;
    }

    public int[] getDateSegments(){
        int month = date / 20;
        int week = date % 20 / 5;
        int day = date % 20 % 5;
        return new int[]{month, week, day};
    }

    public int[] advance(){
        return advance(1);
    }
    public int[] advance(int days){
        date += days;
        return getDateSegments();
    }

    public void reset(){
        date = 0;
    }
}
