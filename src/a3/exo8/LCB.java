package a3.exo8;

public class LCB {
    private Maillon tete;
    private Maillon queue;
    
    public LCB() {
        this.tete = null;
        this.queue = null;
    }
    
    public Maillon getTete() {
        return tete;
    }
    
    public Maillon getQueue() {
        return queue;
    }
    
    // Question 2: Fonction LCB_ajout_numero
    public LCB ajout_numero(int num) {
        // Création d'un nouveau maillon
        Maillon nouveauMaillon = new Maillon(num);
        
        // Si la liste est vide
        if (tete == null) {
            tete = nouveauMaillon;
            queue = nouveauMaillon;
            return this;
        }
        
        // Si le numéro est inférieur à celui de la tête
        if (num < tete.getNumero()) {
            nouveauMaillon.setSuiv(tete);
            tete.setPrec(nouveauMaillon);
            tete = nouveauMaillon;
            return this;
        }
        
        // Si le numéro est supérieur à celui de la queue
        if (num > queue.getNumero()) {
            queue.setSuiv(nouveauMaillon);
            nouveauMaillon.setPrec(queue);
            queue = nouveauMaillon;
            return this;
        }
        
        // Insertion au milieu
        Maillon courant = tete;
        while (courant != null && courant.getNumero() < num) {
            courant = courant.getSuiv();
        }
        
        // Si le numéro existe déjà, ne pas l'ajouter (éviter les doublons)
        if (courant != null && courant.getNumero() == num) {
            return this;
        }
        
        // Insertion avant le maillon courant
        nouveauMaillon.setSuiv(courant);
        nouveauMaillon.setPrec(courant.getPrec());
        courant.getPrec().setSuiv(nouveauMaillon);
        courant.setPrec(nouveauMaillon);
        
        return this;
    }
    
    // Question 4: Fonction pour supprimer un numéro
    public boolean supprimer_numero(int num) {
        if (tete == null) {
            return false; // Liste vide
        }
        
        // Si c'est la tête
        if (tete.getNumero() == num) {
            tete = tete.getSuiv();
            if (tete == null) {
                queue = null; // La liste est maintenant vide
            } else {
                tete.setPrec(null);
            }
            return true;
        }
        
        // Si c'est la queue
        if (queue.getNumero() == num) {
            queue = queue.getPrec();
            queue.setSuiv(null);
            return true;
        }
        
        // Recherche dans le reste de la liste
        Maillon courant = tete.getSuiv();
        while (courant != null && courant.getNumero() != num) {
            courant = courant.getSuiv();
        }
        
        // Si le numéro n'a pas été trouvé
        if (courant == null) {
            return false;
        }
        
        // Suppression du maillon
        courant.getPrec().setSuiv(courant.getSuiv());
        courant.getSuiv().setPrec(courant.getPrec());
        
        return true;
    }
    
    // Méthode pour afficher le contenu de la LCB
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Maillon courant = tete;
        
        while (courant != null) {
            sb.append(courant.getNumero());
            if (courant.getSuiv() != null) {
                sb.append(", ");
            }
            courant = courant.getSuiv();
        }
        
        return sb.toString();
    }
}