
package travellingsalesman;

import java.util.ArrayList;

public class EList {

    Edge head;

    public EList() {
        this.head = null;
    }

    public Edge getHead() {
        return head;
    }

    public void setHead(Edge head) {
        this.head = head;
    }


    public boolean isEmpty() {
        return head == null;
    }

    public Edge insertEdge(int Tvert_id, int weight) {

        if (head == null) {
            head = new Edge(Tvert_id, weight, head);

            return head;
        } else {

            Edge helpPtr = head;

            while (helpPtr.getNext() != null) {
                helpPtr = helpPtr.getNext();
            }

            Edge newNode = new Edge(Tvert_id, weight, helpPtr.getNext());
            helpPtr.setNext(newNode);
        }

        
        return head;

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

   
       ArrayList<Integer> tr() {
        Edge current = head;
        int i=0;
        ArrayList <Integer>edge=new ArrayList();
        while (current != null) {
           
            edge.add(current.TCity_id);
            current = current.next;
        }
        return edge;
    }
    

    String AdjacentList() {
        String s = "";
        Edge current = head;
        while (current != null) {
            s = s + (current.TCity_id + "-");
            
            current = current.next;
        }
        return s;
    }

   
    public int getDistance(int TCity_id) {
        Edge helpPtr = head;
        
        while (helpPtr != null) {
          
            if (
                helpPtr.TCity_id == TCity_id) {
                return helpPtr.getDistance(); // If found return node found it .
            }
            helpPtr = helpPtr.getNext();
        }
       
        return -1;
    }

}
