public class FilePlaceCarte {
    private CartePlace[] file = new CartePlace[52];
    private int nbCartes = 0;

    public CartePlace ajouteCarte(CartePlace carte) throws Exception {
        if(this.nbCartes == file.length)
            throw new Exception("File pleine");
        this.file[this.nbCartes] = carte;
        this.nbCartes++;
        return carte;
    }

    public CartePlace retireCarte() throws Exception {
        if(this.nbCartes == 0)
            throw new Exception("File vide");
        CartePlace carte = this.file[0];
        for(int i = 0; i < this.nbCartes - 1; i++)
            this.file[i] = this.file[i + 1];
        this.nbCartes--;
        return carte;
    }

    public void vide() {
        while(this.length() != 0)
            try { this.retireCarte(); } catch (Exception e) { break; }
    }
    public int length() {
        return this.nbCartes;
    }

    public CartePlace getCarte(int i) throws ArrayIndexOutOfBoundsException {
        if(i < 0 || i >= this.nbCartes)
            throw new ArrayIndexOutOfBoundsException();
        return this.file[i];
    }
}
