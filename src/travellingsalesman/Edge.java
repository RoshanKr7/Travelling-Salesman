
package travellingsalesman;

public class Edge {
    int SCity_id ;
    int TCity_id ;
    int Distance ;
    Edge next;

    public Edge(int TCity_id, int Distance) {
        this.TCity_id = TCity_id;
        this.Distance = Distance;
        this.next= null ;
    }
 
    public Edge(int TCity_id, int Distance, Edge next) {
        this.TCity_id = TCity_id;
        this.Distance = Distance;
        this.next = next;
    }


    public int getSCity_id() {
        return SCity_id;
    }

    public void setSCity_id(int SCity_id) {
        this.SCity_id = SCity_id;
    }

    public int getTCity_id() {
        return TCity_id;
    }

    public void setTCity_id(int TCity_id) {
        this.TCity_id = TCity_id;
    }

    public int getDistance() {
        return Distance;
    }

    public void setDistance(int Distance) {
        this.Distance = Distance;
    }

    public Edge getNext() {
        return next;
    }

    public void setNext(Edge next) {
        this.next = next;
    }
    
}
