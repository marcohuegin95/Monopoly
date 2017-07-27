/**
 * Created by marco on 25.07.17.
 */
public class Player {
    public enum  color{
        RED,GREEN,BLUE, YELLOW, ORANGE, BLACK;
    }
    private int money;
    private String name;
    private color color;

    public Player(String name, color pcolor) {
        this.name = name;
        this.color = pcolor;
    }

    public void transferMoney(int getMoney){
        money=money+getMoney;
    }

    public boolean isBankrupt(){
        if (money<=0) {
            return true;
        }else{
            return false;
            }
    }

    public void takeTurn(Die die1, Die die2){
        die1.roll();
        die2.roll();


    }

//    public int getColor() {
//        return color;
//    }

//    public void setColor(int color) {
//        this.color = color;
//    }

    public int getMonrey() {
        return money;
    }

    public void setMonrey(int monrey) {
        this.money = monrey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
