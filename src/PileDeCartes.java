public class PileDeCartes {
    private Carte[] pile = new Carte[52];
    private int nbCartes = 0;

    public Carte ajouteCarte(Carte carte) throws Exception {
        if(this.nbCartes == pile.length)
            throw new Exception("Pile pleine");
        this.pile[this.nbCartes] = carte;
        this.nbCartes++;
        return carte;
    }

    public Carte retireCarte() throws Exception {
        if(this.nbCartes == 0)
            throw new Exception("Pile vide");
        Carte carte = this.pile[this.nbCartes - 1];
        this.nbCartes--;
        return carte;
    }

    public int length() {
        return this.nbCartes;
    }

    public String toString() {
        String str = "";
        for(int i = 0; i < this.nbCartes; i++)
            str += (i > 0?  " ": "")+this.pile[i];
        return str;
    }

    public void afficheCartes() {
        for(int i = 0; i < this.nbCartes; i++)
            System.out.printf("%d - %s%n", i + 1, this.pile[i].toString());
    }

    public Carte getCarte(int i) throws Exception {
        if(i < 0 || i >= this.nbCartes)
            throw new IndexOutOfBoundsException("Index " + i + " hors des limites de la file");
        return this.pile[i];
    }

    public void vide() {
        while(this.length() != 0)
            try { this.retireCarte(); } catch (Exception e) { break; }
    }
}
