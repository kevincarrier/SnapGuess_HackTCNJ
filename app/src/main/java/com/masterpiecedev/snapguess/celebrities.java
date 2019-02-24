package com.masterpiecedev.snapguess;

public class celebrities {
    public static final String[] celebrity = {"Will Smith", "Barack Obama", "Lebron James", "Kevin Durant", "Taylor Swift", "Bill Cosby",
            "Dave Chappelle", "Donald Trump", "Serena Williams", "Rafael Nadal", "Roger Federer", "Kim Jong Un"};
    public static final int[] celebrityImg = {R.drawable.willsmith, R.drawable.obama, R.drawable.lebron, R.drawable.durant, R.drawable.swift,
            R.drawable.cosby, R.drawable.chappelle, R.drawable.trump, R.drawable.williams, R.drawable.nadal, R.drawable.federer, R.drawable.un};
    private static int numsUsed[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    public static int points;
    int generatedNum;
    celebrities()
    {

    }
    public String[] getCelebrity()
    {
        return celebrity;
    }
    public int[] getCelebrityImg()
    {
        return celebrityImg;
    }
    public int getPoints()
    {
        return points;
    }
    public void resetNumsUsed()
    {
        for (int i = 0; i<12; i++) {
            numsUsed[i] = -1;
        }
    }
    public int genNum() {
        while (true) {
            boolean state = true;
            generatedNum = (int) (Math.random() * 12);
            for (int i = 0; i < 12; i++) {
                if (numsUsed[i] == generatedNum) {
                    state = false;
                    if (checkNull())
                        return -1;
                }
            }
                if (state) {
                    numsUsed[generatedNum] = generatedNum;
                    return generatedNum;
                }


        }
    }
    protected boolean checkNull()
    {
        boolean nulls = true;
        for (int i = 0; i < 12; i++)
        {
            if(numsUsed[i]==-1)
                nulls = false;
        }
        return nulls;
    }

}
