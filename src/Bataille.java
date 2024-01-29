import org.w3c.dom.Text;

import javax.swing.*;
import java.util.Scanner;

public class Bataille {
    private final FileDeCartes[] tas;
    private final Jeu jeu;
    private Boolean isplaying;
    private final PileDeCartes centre;
    private final FilePlaceCarte place;

    public int joueursEnLisse() {
        int i = 0;
        for(FileDeCartes ta : tas)
            if(ta.length() > 0) i++;
        return i;
    }

    public Bataille() {
        this(2);
    }

    public int getNbJoueurs() {
        return this.tas.length;
    }

    public Bataille(int nbJoueurs) {
        this.tas = new FileDeCartes[nbJoueurs];
        this.jeu = new Jeu();
        this.centre = new PileDeCartes();
        this.place = new FilePlaceCarte();
        this.isplaying = false;
        for(int i = 0; i < nbJoueurs; i++)
            this.tas[i] = new FileDeCartes();
    }

    public void play() throws Exception {
        if(isplaying)
            throw new IllegalAccessException("Un jeu est déjà en cours.");
        System.out.println("La partie commence.");

        isplaying = true;
        int current = 0;
        this.place.vide();
        this.centre.vide();
        for (FileDeCartes ta : this.tas) ta.vide();
        for(int i = 0; i < this.jeu.length(); i++)
            try {
                this.tas[i % this.getNbJoueurs()].ajouteCarte(this.jeu.getCarte(i));
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }

        while(isplaying) {
            if(joueursEnLisse() == 1) {
                // have a winner
                isplaying = false;
                continue;
            } else if (this.tas[current].length() > 0) {
                // tell a player to select a card
                System.out.printf("C'est au tour du Joueur %d%n", current + 1);
//                tas[current].afficheCartes();
//                Scanner scanner = new Scanner(System.in);
//                int nc = -1;
                Carte carte = this.tas[current].retireCarte();
//                while (nc < 0) {
//                    System.out.print("Choisissez un carte ? ");
//                    String name = scanner.nextLine();
//                    try {
//                        nc = Integer.parseInt(name) - 1;
//                        if (nc >= tas[current].length() || nc < 0)
//                            throw new IllegalAccessException("Pas assez de carte pour cet indice.");
//
//                    } catch (Exception e) {
//                        System.out.println("Veuillez choisir une carte valide");
//                    }
//                }
                System.out.printf("Le joueur %d a joué la carte %s.%n", current + 1, carte);
                this.place.ajouteCarte(new CartePlace(carte, current));
            }
            current += 1;
            if(current >= this.tas.length) {
                current = 0;
                System.out.println("Les joueurs ont joué leurs cartes.");
                int max = 0;
                int nbmax = 0;
                int index = 0;
                for(int i = 0; i < this.place.length(); i++) {
                    CartePlace pl = this.place.retireCarte();
                    if(pl.carte.hauteur.getRang() > max) {
                        nbmax = 1;
                        max = pl.carte.hauteur.getRang();
                        index = i;
                    }else if (pl.carte.hauteur.getRang() == max)
                        nbmax++;
                    this.place.ajouteCarte(pl);
                }
                if(nbmax > 1) {
                    System.out.println("Egalités des cartes");
                    while(this.place.length() > 0)
                        this.centre.ajouteCarte(this.place.retireCarte().carte);
                }else{
                    CartePlace win = this.place.getCarte(index);
                    System.out.println("Le joueur " + (win.tas + 1) + " remporte le pli.");
                    System.out.printf("Avec %s.%n", win.carte.toString());
                    while(this.place.length() > 0) {
                        CartePlace pl = this.place.retireCarte();
                        this.tas[win.tas].ajouteCarte(pl.carte);
                        if(this.tas[pl.tas].length() == 0)
                            System.out.println("Le joueur " + (pl.tas + 1) + " est éliminé.");
                    }
                    while(this.centre.length() > 0)
                        this.tas[win.tas].ajouteCarte(this.centre.retireCarte());
                }
            }
        }
        System.out.println("\nPartie terminée.");


    }
}
