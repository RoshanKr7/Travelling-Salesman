
package travellingsalesman;


public class City {
    String lebal ;
    int Heuristic ;
    boolean visit ;
    EList adjacent ;
    int Size ;
    City next ;
   int id;
   
    public City() {
    }

        public City(String lebal , int Heuristic) {
        this.lebal = lebal ;
        this.Heuristic = Heuristic ;
        this.visit = false ;
        this.adjacent = new EList();
        
    }

    public City(String lebal, int Heuristic, City next) {
        this.lebal = lebal;
        this.Heuristic = Heuristic;
        this.next = next;
    }

    
    public City(String lebal, boolean visit ) {
        this.lebal = lebal;
        this.visit = visit;

    }

    public City(String lebal, boolean visit, EList adjacent) {
        this.lebal = lebal;
        this.visit = visit;
        this.adjacent = adjacent;
    }

    public String getLebal() {
        return lebal;
    }

    public void setLebal(String lebal) {
        this.lebal = lebal;
    }

    public boolean isVisit() {
        return visit;
    }

    public void setVisit(boolean visit) {
        this.visit = visit;
    }

    public EList getAdjacent() {
        return adjacent;
    }

    public void setAdjacent(EList adjacent) {
        this.adjacent = adjacent;
    }

    public int getHeuristic() {
        return Heuristic;
    }

    public void setHeuristic(int Heuristic) {
        this.Heuristic = Heuristic;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int Size) {
        this.Size = Size;
    }

    public City getNext() {
        return next;
    }

    public void setNext(City next) {
        this.next = next;
    }
    

    
    void insertAdjacent(int v_id, int weight){
        this.adjacent.insertEdge(v_id, weight) ;  
        this.Size ++; 
    }
    EList PrintEdge (){
        return this.adjacent;
               
    }
    
    int getWeight (City c){
    return this.adjacent.getHead().Distance;
    }
 
      public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }
    
   
     

}
