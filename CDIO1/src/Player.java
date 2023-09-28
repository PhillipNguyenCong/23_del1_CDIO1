class Player{
    private String name;
    private int score;
    private Dice[] dice;
    private int pairsOfSixesInARow;

    public Player(String name){
        this.name = name;

        initializePlayerDice();
        pairsOfSixesInARow = 0;
    }

    private void initializePlayerDice() {
        dice = new Dice[Dicegame.noOfDice];
        for (int i = 0; i < Dicegame.noOfDice; i++) {
            dice[i] = new Dice();
        }
    }

    public void rollDice() {
        for (int i = 0; i < Dicegame.noOfDice; i++) {
            dice[i].rollDie();
        }
    }

    public boolean checkForPair() {
        for (int i = 0; i < Dicegame.noOfDice - 1; i++) {
            if (dice[i].getValue() != dice[i + 1].getValue())
                return false;
        }
        return true;
    }

    public boolean checkForPairOfOnes() {
        for (int i = 0; i < Dicegame.noOfDice; i++) {
            if (dice[i].getValue() != 1)
                return false;
        }
        return true;
    }

    public boolean checkForPairOfSixes(){
        for (int i = 0; i < Dicegame.noOfDice; i++) {
            if (dice[i].getValue() != 6)
                return false;
        }
        return true;
    }
    
    public boolean checkForMaxPoints() {
        return score >= Dicegame.maxPointsToWin;
    }

    public void addDiceRollsToScore() {
        for (int i = 0; i < Dicegame.noOfDice; i++) {
            addToScore(dice[i].getValue());
        }
    }

    private void addToScore(int points) {
        this.score += points;
        if (this.score > 40)
            this.score = 40;
    }

    public void resetScore() {
        this.score = 0;
    }

    public void gotAPairOfSixes() {
        pairsOfSixesInARow++;
    }

    public int getPairsOfSixes() {
        return pairsOfSixesInARow;
    }

    public void resetPairsOfSixesInARow() {
        pairsOfSixesInARow = 0;
    }


    public int getDieValue(int die) {
        return dice[die].getValue();
    }
    
    public int getSumOfDice() {
        int sum = 0;
        for (int i = 0; i < Dicegame.noOfDice; i++) {
            sum += dice[i].getValue();
        }
        return sum;
    }

    public String getPlayerName() {
        return name;
    }

    public int getScore() {
        return this.score;
    }
}
