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

    public void setTete(Maillon tete) {
        this.tete = tete;
    }

    public Maillon getQueue() {
        return queue;
    }

    public void setQueue(Maillon queue) {
        this.queue = queue;
    }

    public LCB ajoutNumero(int num) {
        Maillon nouveau = new Maillon(num);
        
        if (tete == null) {
            tete = nouveau;
            queue = nouveau;
            return this;
        }

        // Si le numéro est plus petit que la tête, on l'ajoute au début
        if (num < tete.getNumero()) {
            nouveau.setSuivant(tete);
            tete.setPrecedent(nouveau);
            tete = nouveau;
            return this;
        }

        // Si le numéro est plus grand que la queue, on l'ajoute à la fin
        if (num > queue.getNumero()) {
            nouveau.setPrecedent(queue);
            queue.setSuivant(nouveau);
            queue = nouveau;
            return this;
        }

        // On cherche la position d'insertion
        Maillon courant = tete;
        while (courant != null && courant.getNumero() < num) {
            courant = courant.getSuivant();
        }

        // Si le numéro existe déjà, on ne fait rien
        if (courant != null && courant.getNumero() == num) {
            return this;
        }

        // Insertion du nouveau maillon
        nouveau.setPrecedent(courant.getPrecedent());
        nouveau.setSuivant(courant);
        courant.getPrecedent().setSuivant(nouveau);
        courant.setPrecedent(nouveau);

        return this;
    }

    public LCB supprimerNumero(int num) {
        if (tete == null) {
            return this;
        }

        // Si le numéro est en tête
        if (tete.getNumero() == num) {
            tete = tete.getSuivant();
            if (tete != null) {
                tete.setPrecedent(null);
            } else {
                queue = null;
            }
            return this;
        }

        // Si le numéro est en queue
        if (queue.getNumero() == num) {
            queue = queue.getPrecedent();
            if (queue != null) {
                queue.setSuivant(null);
            } else {
                tete = null;
            }
            return this;
        }

        // Recherche du numéro dans la liste
        Maillon courant = tete;
        while (courant != null && courant.getNumero() != num) {
            courant = courant.getSuivant();
        }

        // Si le numéro est trouvé, on le supprime
        if (courant != null) {
            courant.getPrecedent().setSuivant(courant.getSuivant());
            courant.getSuivant().setPrecedent(courant.getPrecedent());
        }

        return this;
    }

    public void afficher() {
        Maillon courant = tete;
        while (courant != null) {
            System.out.print(courant.getNumero());
            if (courant.getSuivant() != null) {
                System.out.print(", ");
            }
            courant = courant.getSuivant();
        }
        System.out.println();
    }
} 