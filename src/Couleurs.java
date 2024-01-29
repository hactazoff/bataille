//
public enum Couleurs {
    PIQUE("♠"),
    COEUR("♥"),
    CARREAU("♦"),
    TREFLE("♣");

    private String symbole;
    Couleurs(String symbol) {
        this.symbole = symbol;
    }

    public String toString() {
        return this.symbole;
    }
}
