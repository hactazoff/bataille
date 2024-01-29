public class Jeu {
    private Carte[] cartes;

    public Jeu() {
        this.cartes = new Carte[52];
        int i = 0;
        for (Couleurs col : Couleurs.values()) {
            for (Hauteurs hauteur : Hauteurs.values()) {
                this.cartes[i] = new Carte(col, hauteur);
                i++;
            }
        }
    }

    public void afficheJeu() {
        for (Carte carte : this.cartes) {
            System.out.println(carte);
        }
    }

    public int length() {
        return this.cartes.length;
    }

    public Carte getCarte(int i) {
        if(i < 0 || i >= this.cartes.length)
            throw new IndexOutOfBoundsException("Index " + i + " hors des limites du jeu");
        return this.cartes[i];
    }
}
