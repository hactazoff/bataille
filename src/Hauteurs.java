public enum Hauteurs {
    DEUX(2, "2"),
    TROIS(3, "3"),
    QUATRE(4, "4"),
    CINQ(5, "5"),
    SIX(6, "6"),
    SEPT(7, "7"),
    HUIT(8, "8"),
    NEUF(9, "9"),
    DIX(10, "10"),
    VALET(11, "V"),
    DAME(12, "D"),
    ROI(13, "R"),
    AS(14, "A");

    private int rang;
    private String symbole;

    Hauteurs(int rang, String symbol) {
        this.rang = rang;
        this.symbole = symbol;
    }

    public int getRang() {
        return this.rang;
    }

    public String toString() {
        return this.symbole;
    }
}
