public class FileDeCartes {
    private Carte[] file = new Carte[52];
    private int nbCartes = 0;

    public Carte ajouteCarte(Carte carte) throws Exception {
        if(this.nbCartes == file.length)
            throw new Exception("File pleine");
        this.file[this.nbCartes] = carte;
        this.nbCartes++;
        return carte;
    }

    public Carte retireCarte() throws Exception {
        if(this.nbCartes == 0)
            throw new Exception("File vide");
        Carte carte = this.file[0];
        for(int i = 0; i < this.nbCartes - 1; i++)
            this.file[i] = this.file[i + 1];
        this.nbCartes--;
        return carte;
    }

    public int length() {
        return this.nbCartes;
    }

    public String toString() {
        String str = "";
        for(int i = 0; i < this.nbCartes; i++)
            str += (i > 0?  " ": "")+this.file[i];
        return str;
    }
    public void afficheCartes() {
        for(int i = 0; i < this.nbCartes; i++)
            System.out.printf("%d - %s%n", i + 1, this.file[i].toString());
    }

    public Carte getCarte(int i) throws Exception {
        if(i < 0 || i >= this.nbCartes)
            throw new IndexOutOfBoundsException("Index " + i + " hors des limites de la file");
        return this.file[i];
    }

    public void vide() {
        while(this.length() != 0)
            try { this.retireCarte(); } catch (Exception e) { break; }
    }
}
