package ja.assess;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Game extends Player{

    public int mapLength;
    public int mapWidth;
    private ArrayList<Integer> posTreasure;
    private boolean gameOver = false;
    private int count = 0;


    public Game(int mapLength, int mapWidth){
        super();
        this.mapLength = mapLength;
        this.mapWidth = mapWidth;
    }

    public int[] setMap(){
        int[] map = {mapLength, mapWidth};
        return map;
    }

    public ArrayList<Integer> setPosTreasure(){
        double pos1 = Math.random()*5;
        double pos2 = Math.random()*5;
        ArrayList<Integer> posTreasure = new ArrayList<>();
        posTreasure.add((int)pos1);
        posTreasure.add((int)pos2);
        this.posTreasure = posTreasure;
        return this.posTreasure;
    }

    public void runGame(){

        Scanner sc = new Scanner(System.in);
        System.out.println("You awaken to find yourself in a barren moor. Try 'look' ");
        String input = sc.nextLine();
        playGame(input);
        getPosPlayer();

        do {
            //System.out.println("You're currently at " + posPlayer);
            //System.out.println("The treasure is at " + posTreasure);
            System.out.println("Which way will you go?");
            String command = sc.nextLine();
            playGame(command);
            count++;
            } while (!gameOver);
        System.out.println(endStatement());

        }

    public String help(){
        String sen1 = "Grey foggy clouds float oppressively close to you, reflected in the murky grey water which reaches up your shins.";
        String sen2 = "\nSome black plants barely poke out of the shallow water.";
        String sen3 = "\nYou notice a small watch-like device which points towards some object close by. It has hands like a watch, but the hands don’t seem to tell time.";
        String sen4 = "\nTry “north”,”south”,”east”,or “west”.";
        String help = sen1 + sen2 + sen3 + sen4;
        return help;
    }

    public void playGame(String input){
        switch (input) {
            case ("look"):
                System.out.println(help());
                break;
            case ("north"):
                goNorth(getPosPlayer());
                break;
            case ("south"):
                goSouth(getPosPlayer());
                break;
            case ("east"):
                goEast(getPosPlayer());
                break;
            case ("west"):
                goWest(getPosPlayer());
                break;
            default:
                System.out.println("This is not a valid command! Try 'north', 'south', 'east' or 'west'.");
        }
    }

    public ArrayList<Integer> goNorth(ArrayList<Integer> posPlayer){
        if (posPlayer.get(1) == 5){
            System.out.println("You should not travel further north!");
            return posPlayer;
        } else {
            posPlayer.set(1, posPlayer.get(1) + 1);
            System.out.println(prizeNearby());
            endGame();
            return posPlayer;

        }
    }

    public ArrayList<Integer> goSouth(ArrayList<Integer> posPlayer){
        if (posPlayer.get(1) == 0){
            System.out.println("You should not travel further south!");
            return posPlayer;
        } else {
            posPlayer.set(1, posPlayer.get(1) - 1);
            System.out.println(prizeNearby());
            endGame();
            return posPlayer;

        }
    }

    public ArrayList<Integer> goEast(ArrayList<Integer> posPlayer){
        if (posPlayer.get(0) == 5){
            System.out.println("You should not travel further east!");
            return posPlayer;
        } else {
            posPlayer.set(0, posPlayer.get(0) + 1);
            System.out.println(prizeNearby());
            endGame();
            return posPlayer;

        }
    }

    public ArrayList<Integer> goWest(ArrayList<Integer> posPlayer){
        if (posPlayer.get(0) == 0){
            System.out.println("You should not travel further west!");
            return posPlayer;
        } else {
            posPlayer.set(0, posPlayer.get(0) - 1);
            System.out.println(prizeNearby());
            endGame();
            return posPlayer;

        }
    }

    public String prizeNearby(){
        String statement;
        if (posPlayer.get(0) == posTreasure.get(0) && posPlayer.get(1) == posTreasure.get(1)) {
            statement = "";
        }else if ((posPlayer.get(0) == posTreasure.get(0) && (posPlayer.get(1) == (posTreasure.get(1) - 1) || (posPlayer.get(1) == (posTreasure.get(1) + 1))) || posPlayer.get(1) == posTreasure.get(1) &&((posPlayer.get(0) == (posTreasure.get(0) - 1) || (posPlayer.get(0) == (posTreasure.get(0) + 1)))))) {
            statement = "You see something really close to you!";
        }else if (posPlayer.get(0) == posTreasure.get(0) || posPlayer.get(1) == posTreasure.get(1)) {
            statement = "You see something in line with you but in a different direction";
        }else if ((posPlayer.get(1) == (posTreasure.get(1) - 1) || (posPlayer.get(1) == (posTreasure.get(1) + 1))) || (posPlayer.get(0) == (posTreasure.get(0) - 1) || (posPlayer.get(0) == (posTreasure.get(0) + 1)))){
            statement = "You see something nearby!";
        }else {
            statement = "You don't see anything of interest around you";
        }
        return statement;
    }

    public  ArrayList<Integer> getPosPlayer(){
        return posPlayer;
    }

    public boolean endGame() {
        if (getPosPlayer().equals(posTreasure)){
            gameOver = true;
            return gameOver;
        } else return gameOver;
    }

    public String endStatement(){
        return "Woah! You found a box that is full of treasure! You're rich! WELL DONE! The end. \nThe treasure was found at the position " + posTreasure + ". " + " You found the treasure in " + count + " moves.";
    }

}
