class Game{



    public String startGame(){
        // to be continued...
        return "NULL";
    }


    public boolean checkRoll(){
        var scanner = new java.util.Scanner(System.in);
        return scanner.nextLine().equals("roll");
    }
    
    public boolean checkWin(int score1, int score2, int roll1, int roll2){
        return score1 > 39 && roll1 == roll2 && roll1 != 1 && roll2 != 1|| score2 > 39 && roll1 == roll2 && roll1 != 1 && roll2 != 1;
    }


    public String play(){
        // to be continued...
        return "NULL";
    } 
}