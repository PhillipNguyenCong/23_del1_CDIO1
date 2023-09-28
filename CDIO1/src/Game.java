class Game{



    public boolean checkRoll(){
        var scanner = new java.util.Scanner(System.in);
        return scanner.nextLine().equals("roll");
    }
    
    public boolean checkWin(int score1, int score2, int roll1, int roll2){
        return score1 == 40 && roll1 == roll2 && roll1 != 1 && roll2 != 1 || score2 == 40 && roll1 == roll2 && roll1 != 1 && roll2 != 1;
    }

    public boolean checkTwoSixes(int roll1, int roll2){
        return roll1 == roll2;
    }

    public boolean checkTwo1s(int roll1, int roll2){
        return roll1 == 1 && roll2 == 1;
    }

    public boolean checkEkstraturn(int roll1, int roll2, int playerscore){
        return roll1 == roll2 && roll1 != 1 && playerscore < 40 && roll1 != 6;
    }

    public boolean checkForty (int score){
        return score > 39;
    }


}