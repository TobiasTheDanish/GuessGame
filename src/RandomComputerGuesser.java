import java.util.Random;

public class RandomComputerGuesser implements IGuesser
{
    private int min;
    private int max;
    private int prevGuess = 0;

    public void yourTurn() {}

    public String getName()
    {
        return "Computer guesser";
    }

    public void newGame(int min, int max, String opponent, String type)
    {
        this.min = min;
        this.max = max;
    }

    public int makeGuess()
    {
        Random rng = new Random();

        prevGuess = rng.nextInt((max-min) + 1) + min;
        return prevGuess;
    }

    public void guessFeedback(Answer answer)
    {
        switch(answer)
        {
            case TOO_LOW:
                min = prevGuess + 1;
                break;
            case TOO_HIGH:
                max = prevGuess -1;
                break;
            case CORRECT:
                break;
            default:
                throw new RuntimeException("This should never happen!");
        }
    }

    public boolean endOfGame(int numberOfGuesses, String opponent)
    {
        return true;
    }

}
