package a2.exo1;

public class Liste {
    private String value;
    private Liste next;

    public Liste(String value) {
        this.value = value;
        this.next = null;
    }

    public Liste(String value, Liste next) {
        this.value = value;
        this.next = next;
    }

    public void append(Liste l) {
        if (this.next == null) {
            this.next = l;
        } else {
            Liste current = this;
            while (current.next != null) {
                current = current.next;
            }
            current.next = l;
        }
    }

    public Liste supprimerInferieur() {
        String pivot = this.value;
        Liste current = this;
        Liste prev = null;
        Liste removed = null;

        while (current.next != null) {
            if (current.next.value.compareTo(pivot) < 0) {

                Liste temp = current.next;
                current.next = temp.next;

                temp.next = removed;
                removed = temp;
            } else {
                prev = current;
                current = current.next;
            }
        }

        return removed;
    }

    public Liste quicksort() {
        if (this == null || this.next == null) {
            return this;
        }

        String pivot = this.value;
        Liste gauche = supprimerInferieur();
        Liste droite = this.next;

        Liste gaucheTrie = (gauche != null) ? gauche.quicksort() : null;
        Liste droiteTrie = (droite != null) ? droite.quicksort() : null;

        Liste sortedList = new Liste(pivot, droiteTrie);
        if (gaucheTrie != null) {
            Liste tail = gaucheTrie;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = sortedList;
            return gaucheTrie;
        } else {
            return sortedList;
        }
    }

}
