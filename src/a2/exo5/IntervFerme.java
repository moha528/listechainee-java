package a2.exo5;

class IntervFerme extends IntervOuvert {

    public IntervFerme(int bInf, int bSup) {
        super(bInf, bSup);
        this.card = bSup - bInf + 1;
    }

    @Override
    public boolean estDans(int n) {
        return n >= bInf && n <= bSup;
    }

    @Override
    public boolean contient(IntervOuvert i) {
        if (i instanceof IntervFerme) {
            return i.bInf >= bInf && i.bSup <= bSup;
        }
        return i.bInf > bInf && i.bSup < bSup;
    }

    @Override
    public String toString() {
        return "[" + bInf + ", " + bSup + "]";
    }

}

//        +---------------------+
//        |   IntervOuvert      |
//        +---------------------+
//        | - bInf : int        |
//        | - bSup : int        |
//        | - card : int        |
//        +---------------------+
//        | + IntervOuvert()    |
//        | + estVide() : bool  |
//        | + estDans(n) : bool |
//        | + contient(I) : bool|
//        | + intersection()    |
//        +---------------------+
//                  ▲
//                  │
//        +---------------------+
//        |   IntervFerme       |
//        +---------------------+
//        | + IntervFerme()     |
//        | + estDans(n) : bool |
//        | + contient(I) : bool|
//        +---------------------+
