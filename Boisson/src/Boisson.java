public interface Boisson {

    double SOMME_INITIAL = 0.0;
    double cafe = 1.5;
    double the = 1.0;
    
    public enum Breuvage{
    	CAFE, THE, ERROR
    }
    
    // int CAFE = 1;
    // int THE  = 2;

    // 0 si le payement est ok -1 si cela a échoué
    int checkPayement(Breuvage boisson);
    // Renvoie le int de la boisson (1 pour le THE et 2 pour le CAFE)
    Breuvage choisirBoisson();
    // Ajoute une piece a la somme total
    void introductionPiece();
    // Choisir entre ajouter une piece et choisir une boisson
    int choisirAction();
    // Rend la monnaie ou rend 0
    double rendreMonnaie();
}
