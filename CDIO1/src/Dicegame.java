class Dicegame{
    public static void main(String[] args) {
        
        var game = new Game();
        var dice = new Dice();
        int sum = 0;
        int roll1 = 0;
        int roll2 = 0;

        var scanner = new java.util.Scanner(System.in);


        System.out.println("Please enter the name of Player 1");
        var player1 = new Player(scanner.nextLine());

        System.out.println("Please enter the name of Player 2");
        var player2 = new Player(scanner.nextLine());

        
        player1.isTurn = true;      //Player1 starts
        System.out.println(player1.name + "'s turn. Write 'roll' to throw the dice");

        
            
            while(!game.checkWin(player1.score, player2.score)){
                roll1 = dice.getValue();
                roll2 = dice.getValue();
                sum += roll1 + roll2;

            
                if(player1.isTurn){
                    System.out.println("\n" + player1.name + "'s turn. Write 'roll' to throw the dice");
                    if(game.checkRoll()){
                        player1.score += sum;
                        System.out.println("Dice 1: " + roll1 + "\nDice 2: " + roll2 + "\nScore: " + sum + "\nTotal score: " + player1.score + "\n");
                        player1.isTurn = false;
                        player2.isTurn = true;
                    }
                    else{
                        System.out.println("Error. Try again");
                    }
                    
                }
                else if(player2.isTurn){
                    System.out.println("\n" +player2.name + "'s turn. Write 'roll' to throw the dice");
                    if(game.checkRoll()){
                        player2.score += sum;
                        System.out.println("Dice 1: " + roll1 + "\nDice 2: " + roll2 + "\nScore: " + sum + "\nTotal score: " + player2.score + "\n");
                        player1.isTurn = true;
                        player2.isTurn = false;
                    }
                    else{
                        System.out.println("Error. Try again");
                    }
                    
                }
                sum = 0;
            }

        
            
        
        System.out.println(player1.name + "'s score:" + player1.score + "\n" + player2.name + "'s score:" + player2.score);
    }


   
}

 