public class Bank {
    private double money;

    public double getMoney(){
        return money;
    }

    private double deposit(double cash){
        money += cash;
        return money;
    }

    public double withDraw(double cash){
        return money;
    }
}
