package a2.exo5;

public class IntervOuvert {

    protected int bInf, bSup, card;

    public IntervOuvert(int bInf, int bSup) {
        if (bInf >= bSup) {
            throw new IllegalArgumentException("bInf doit être strictement inférieur à bSup");
        }
        this.bInf = bInf;
        this.bSup = bSup;
        this.card = Math.max(0, bSup - bInf - 1);
    }

    public boolean estVide() {
        return card == 0;
    }

    public boolean estDans(int n) {
        return n > bInf && n < bSup;
    }

    public boolean contient(IntervOuvert i) {
        return i.bInf > bInf && i.bSup < bSup;
    }

    public static IntervOuvert intersection(IntervOuvert i1, IntervOuvert i2) {
        int newBInf = Math.max(i1.bInf, i2.bInf);
        int newBSup = Math.min(i1.bSup, i2.bSup);
        return newBInf >= newBSup ? new IntervOuvert(0, 0) : new IntervOuvert(newBInf, newBSup);
    }

}