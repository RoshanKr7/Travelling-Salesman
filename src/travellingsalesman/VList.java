
package travellingsalesman;


public class VList {

    City head;

    public VList() {
        this.head = null;
    }

    public City getHead() {
        return head;
    }

    public void setHead(City head) {
        this.head = head;
    }

   
    public boolean isEmpty() {
        return head == null;
    }

    public City insertVertex(City v) {
        if (head == null || head.getHeuristic() > v.getHeuristic()) {

            v.setNext(head);
            head = v;
            return v;

        } else {

            City helpPtr = head;

            while (helpPtr.getNext() != null) {

                if (helpPtr.getNext().getHeuristic() > v.getHeuristic()) {
                    break;
                }
                helpPtr = helpPtr.getNext();

            }
            City newNode = v;
            v.setNext(helpPtr.getNext());

            helpPtr.setNext(newNode);
        }

        return head;
    }

    City FirstVertex() {
        City v = head;
        if (head != null) {
            City temp = head;
            head = head.getNext();
        }
        return (v);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    String tr() {
        String s = "";
        City current = head;
        while (current != null) {
            s = s + current.getLebal() + "-";
            current = current.next;

        }
        return s;
    }

    boolean found(City v) {

        City helpPtr = head;

        while (helpPtr != null) {

            if (helpPtr.getLebal().equalsIgnoreCase(v.getLebal())) {
                return true; // If found return node found it .
            }
            helpPtr = helpPtr.getNext();
        }
        return false;
    }

    public City insertVertexAstar(City v, int TotalDistance) {
        if (head == null || head.getHeuristic() + head.getWeight(head) > v.getHeuristic() + TotalDistance) {

            v.setNext(head);
            head = v;
            return v;

        } else {

            City helpPtr = head;

            while (helpPtr.getNext() != null) {

                if (helpPtr.getNext().getHeuristic() > v.getHeuristic()) {
                    break;
                }
                helpPtr = helpPtr.getNext();

            }
            City newNode = v;
            v.setNext(helpPtr.getNext());

            helpPtr.setNext(newNode);
        }
        return head;
    }
}
