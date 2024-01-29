public class Carte {
    public final Couleurs couleur;
    public final Hauteurs hauteur;
    
    public Carte(Couleurs couleur, Hauteurs hauteur) {
        this.couleur = couleur;
        this.hauteur = hauteur;
    }

    public String toString() {
        return this.hauteur.toString() + this.couleur.toString();
    }
}
