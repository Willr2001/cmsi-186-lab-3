import java.util.*;


public class DiceSet {


    private Die[] dice;
    private final int SidesOnEachDieTemp;
    private int numberOfDiceG;


    public DiceSet(int sidesOnEachDie, int numberOfDice) {
        // TODO
        if(numberOfDice < 2){
          throw new IllegalArgumentException("At least two dice required");
        }
        if(sidesOnEachDie < 4){
          throw new IllegalArgumentException("Dice must have at least four sides");
        }

        SidesOnEachDieTemp = sidesOnEachDie;
        numberOfDiceG = numberOfDice;
        this.dice = new Die[numberOfDice];
        for(var i = 0; i < dice.length; i++){
          this.dice[i] = new Die(sidesOnEachDie, 1);
        }
    }


    public DiceSet(int sidesOnEachDie, int... values) {

        if(values.length < 2){
          throw new IllegalArgumentException("At least two dice required");
        }
        if(sidesOnEachDie < 4){
          throw new IllegalArgumentException("Dice must have at least four sides");
        }
        SidesOnEachDieTemp = sidesOnEachDie;
        numberOfDiceG = values.length;
        this.dice = new Die[values.length];
        for(int i = 0; i < values.length; i++){
          if(values[i] > sidesOnEachDie){
            throw new IllegalArgumentException("Die value not legal for die shape");
          }
          dice[i] = new Die(sidesOnEachDie, values[i]);
        }
    }


    public String descriptor() {
        // TODO
        String val = dice.length + "d" + dice[0].getSides();
        return val;
    }


    public int sum() {

        int sum = 0;
        for(int i = 0; i < dice.length; i++){
          sum += dice[i].getValue();
        }
        return sum;
    }


    public void rollAll() {

        for(int i = 0; i < dice.length; i++){
          dice[i].roll();
        }
    }


    public void rollIndividual(int i) {

        dice[i].roll();
    }


    public int getIndividual(int i) {

        return dice[i].getValue();
    }


    public ArrayList<Integer> values() {

        if(numberOfDiceG < 2){
          throw new IllegalArgumentException("At least two dice required");
        }
        if(SidesOnEachDieTemp < 4){
          throw new IllegalArgumentException("Dice must have at least four sides");
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        for(var i = 0; i < dice.length; i++){
          Integer temp = new Integer(1);
          list.add(temp);
        }
        return list;
    }

    public int getLength(){
      return dice.length;
    }

    public int getDieSides(){
      return dice[0].getSides();
    }


    public boolean isIdenticalTo(DiceSet diceSet) {
        // TODO
        int[] listOfIndex = new int[diceSet.getLength()];
        int sides = diceSet.getDieSides();
        int sum = 0;
        if(dice.length != diceSet.getLength()){
          return false;
        }

        if(sides != dice[0].getSides()){
          return false;
        }

        for(int i = 0; i < dice.length; i++){
          int value = dice[i].getValue();

          for(int j = 0; j < dice.length; j++){
            if(value == diceSet.getIndividual(j) && listOfIndex[j] == 0){
              listOfIndex[j] += 1;
            }
          }
        }
        for(int k = 0; k < dice.length; k++){
          sum += listOfIndex[k];
        }
        if(sum == dice.length){
          return true;
        }
        return false;
    }


    @Override public String toString() {

        String val = "";
        for(var i = 0; i < dice.length; i++){
          val += "[" + dice[i].getValue() + "]";
        }
        return val;
    }
}
