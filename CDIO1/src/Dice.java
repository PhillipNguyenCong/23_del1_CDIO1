import java.util.Random;
class Dice{

    public int faceValue;
    
    //initialize random number generator
	Random random = new Random();

    public int getValue(){
        faceValue = random.nextInt(6) + 1;
            return faceValue;
        }
}
