class Dicegame {
    static java.util.Scanner scanner;
    static Game game;
    static int noOfPlayers = 2;
    static int noOfDice = 2;
    static int maxPointsToWin = 40;
    public static void main(String[] args) {
        Dicegame.scanner = new java.util.Scanner(System.in);
        game = new Game();
        game.initializeGame();
    }
}
