class Game {
    Player[] players;
    private int playerTurn;

    enum WinTypes {
        maxPointsAndAPair,
        doublePairOfSixes
    }

    public void initializeGame() {
        // runTest();
        addPlayers();
        startGame();
    }

    /*private void runTest() {
        var test = new Test();
        print(test.testThrow(1000));
        print(test.alike(1000));
    }*/

    private void addPlayers() {
        players = new Player[Dicegame.noOfPlayers];
        for (int i = 0; i < Dicegame.noOfPlayers; i++) {
            print("Please enter the name for Player " + (i + 1) + ".");
            players[i] = new Player(Dicegame.scanner.nextLine());
        }
    }

    private void startGame() {
        takePlayerTurn(); // Første spiller tager sin tur
    }

    private void takePlayerTurn() {
        print(players[playerTurn].getPlayerName() + "'s turn. Type 'roll' to throw the dice.");
        waitForRollInput();
        // Her venter koden til spilleren har givet inputet 'roll'.
        showPlayerRoll();
        addDiceRollsToPlayerScore();
        checkRollConditions();
    }

    private void waitForRollInput() {
        String input = Dicegame.scanner.nextLine();
        if (input.toLowerCase().equals("roll"))
            players[playerTurn].rollDice();
        else {
            print("Could not find a command for input: '" + input + "'. Type 'roll' to throw the dice.");
            waitForRollInput();
        }
    }

    private void showPlayerRoll() {
        String diceValuesString = new String();
        for (int i = 0; i < Dicegame.noOfDice; i++) {
            if (i > 0)
                diceValuesString += "\n";
            diceValuesString += "Dice " + (i + 1) + ": " + players[playerTurn].getDieValue(i);
        }
        diceValuesString += "\n";
        print(diceValuesString);
    }

    private void checkRollConditions() {
        if (players[playerTurn].checkForPair()) {
            if (players[playerTurn].checkForMaxPoints()) {
                playerWon(WinTypes.maxPointsAndAPair);
                return; // Når en spiller vinder, vil vi ikke fortsætte med at checke conditions. Vi vil
                        // bare vise resultaterne, så vi returnerer ud af funktionen.
            } else
                print("You hit a pair so you got an extra turn!");
        }
        if (players[playerTurn].checkForPairOfOnes()) {
            players[playerTurn].resetScore();
            print("...but you hit a pair of 1's so you lose all your points. =(");
        }
        if (players[playerTurn].checkForPairOfSixes()) {
            players[playerTurn].gotAPairOfSixes();
            if (players[playerTurn].getScore() < 40) { // Så længe spillerens point er lavere end 40, da vi ikke behøver
                                                       // at sige, at spilleren skal slå to 6'ere igen for at vinde, da
                                                       // de bare behøver et hvilket som helst par.
                if (players[playerTurn].getPairsOfSixes() == 1) {
                    print("...and it was a pair of sixes! If you hit 2 sixes again you win!");
                } else if (players[playerTurn].getPairsOfSixes() == 2) {
                    playerWon(WinTypes.doublePairOfSixes);
                    return; // Når en spiller vinder, vil vi ikke fortsætte med at checke conditions. Vi vil
                            // bare vise resultaterne, så vi returnerer ud af funktionen.
                }
            }
        } else {
            players[playerTurn].resetPairsOfSixesInARow();
        }
        if (players[playerTurn].checkForMaxPoints()) {
            print("You hit the " + Dicegame.maxPointsToWin + " marker. You need to hit a pair to win.");
        }

        showPlayerScore();
        nextPlayerTurn();
    }

    private void addDiceRollsToPlayerScore() {
        players[playerTurn].addDiceRollsToScore();
    }

    private void showPlayerScore() {
        print("Sum of dice: " + players[playerTurn].getSumOfDice() + "\nTotal score: " + players[playerTurn].getScore() + "\n");
    }

    private void nextPlayerTurn() {
        if (!players[playerTurn].checkForPair())
            playerTurn++;
        if (playerTurn >= Dicegame.noOfPlayers)
            playerTurn = 0;
        takePlayerTurn();
    }

    private void playerWon(WinTypes winType) {
        switch (winType) {
            case maxPointsAndAPair:
                print(players[playerTurn].getPlayerName() + " had max points, then got a pair. Therefore you win!");
                break;
            case doublePairOfSixes:
                print(players[playerTurn].getPlayerName() + " got two pairs of sixes in a row. Therefore you win!");
                break;
        }

        print("Game Stats" + "\n"
                + players[0].getPlayerName() + "'s score:" + players[0].getScore() + "\n"
                + players[1].getPlayerName() + "'s score:" + players[1].getScore());

        EndMessage();
    }

    private void EndMessage() {
        print("\nType 'play' to play again. Type 'quit' to quit the game.");

        String input = Dicegame.scanner.nextLine();
        if (input.toLowerCase().equals("play"))
            initializeGame();
        else if (input.toLowerCase().equals("quit"))
            Dicegame.scanner.close();
        else {
            print("Could not find a command for input: '" + input + "'.");
            EndMessage();
        }
    }

    public static void print(String string) {
        System.out.println(string);
    }
}
