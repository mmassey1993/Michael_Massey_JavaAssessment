package ja.assess;

import java.util.ArrayList;

public class Player implements Placeable{


    private int pos1;
    private int pos2;
    public ArrayList<Integer> posPlayer;


    public Player(){
        this.setPos1((int) Math.random()*5);
        this.setPos2((int) Math.random()*5);
        setPos();
    }


    @Override
    public ArrayList<Integer> setPos() {
        double posA = Math.random()*5;
        double posB = Math.random()*5;
        ArrayList<Integer> posPlayer = new ArrayList<>();
        posPlayer.add((int) posA);
        posPlayer.add((int) posB);
        this.posPlayer = posPlayer;
        return this.posPlayer;
    }

    public int getPos1() {
        return pos1;
    }

    public void setPos1(int pos1) {
        this.pos1 = pos1;
    }

    public int getPos2() {
        return pos2;
    }

    public void setPos2(int pos2) {
        this.pos2 = pos2;
    }


}
