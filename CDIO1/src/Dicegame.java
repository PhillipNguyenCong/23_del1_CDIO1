class Dicegame{
    public static void main(String[] args) {
        
        var game = new Game();
        var dice = new Dice();
        int sum = 0;
        int roll1 = 0;
        int roll2 = 0;

        var scanner = new java.util.Scanner(System.in);
        System.out.println("Please enter the name of Player 1");
        //System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n");
        var player1 = new Player(scanner.nextLine());

        System.out.println("Please enter the name of Player 2");
        var player2 = new Player(scanner.nextLine());

        
        player1.isTurn = true;      //Player1 starts
        //System.out.println(player1.name + "'s turn. Write 'roll' to throw the dice");

        
            
            while(!game.checkWin(player1.score, player2.score, roll1, roll2)){
                roll1 = dice.getValue();
                roll2 = dice.getValue();
                sum += roll1 + roll2;

            
                if(player1.isTurn){
                    System.out.println("\n" + player1.name + "'s turn. Write 'roll' to throw the dice");
                    if(game.checkRoll()){
                        System.out.println("Dice 1: " + roll1 + "\nDice 2: " + roll2);
                        if(roll1 == 1 && roll2 == 1){
                            player1.score = 0;
                            System.out.println("You hit TWO 1'ns");
                            System.out.println("You lose all your point =(");
                            System.out.println("Total score: " + player1.score + "\n");
                            System.out.println("You got an extra turn");
                            player1.isTurn = true;
                            player2.isTurn = false;
                        }
                        else if (roll1 == roll2 && roll1 != 1){
                            player2.score += sum;
                            System.out.println("Score: " + sum + "\nTotal score: " + player2.score + "\n");
                            player1.isTurn = true;
                            player2.isTurn = false;
                            System.out.println("You hit 2 alike \nYou got an extra turn");
                        }
                        else{
                            player1.score += sum;
                            System.out.println("Score: " + sum + "\nTotal score: " + player1.score + "\n");
                            player1.isTurn = false;
                            player2.isTurn = true;
                        }
                        
                    }
                    else{
                        System.out.println("Error. Try again");
                    }
                    
                }
                else if(player2.isTurn){
                    System.out.println("\n" +player2.name + "'s turn. Write 'roll' to throw the dice");
                    if(game.checkRoll()){
                        System.out.println("Dice 1: " + roll1 + "\nDice 2: " + roll2);
                        if(roll1 == 1 && roll2 == 1){
                            player2.score = 0;
                            System.out.println("You hit TWO 1'ns");
                            System.out.println("You lose all your point =(");
                            System.out.println("Total score: " + player2.score + "\n");
                            System.out.println("You got an extra turn");
                            player1.isTurn = false;
                            player2.isTurn = true;
                        }
                        else if (roll1 == roll2 && roll1 != 1){
                            player2.score += sum;
                            System.out.println("Score: " + sum + "\nTotal score: " + player2.score + "\n");
                            player1.isTurn = false;
                            player2.isTurn = true;
                            System.out.println("You hit 2 alike \nYou got an extra turn");

                        }
                        else{
                        player2.score += sum;
                        System.out.println("Score: " + sum + "\nTotal score: " + player2.score + "\n");
                        player1.isTurn = true;
                        player2.isTurn = false;
                        }
                    }
                    else{
                        System.out.println("Error. Try again");
                    }
                    
                }
                sum = 0;
            }

        
            if(player1.score > 39 && roll1 !=1 && roll2 !=1){
                System.out.println(player1.name + "You WON!!");
            }
            else if (player2.score > 39 && roll1 !=1 && roll2 !=1){
                System.out.println(player2.name + "You WON!!");
            }
            System.out.println("Game Stats" + "\n" + player1.name + "'s score:" + player1.score + "\n" + player2.name + "'s score:" + player2.score);
    }


   
}

 