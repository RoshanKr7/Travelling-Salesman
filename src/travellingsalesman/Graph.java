
package travellingsalesman;


public class Graph {

    City Cities[];
    int nv ;

    public Graph() {
    }

    public Graph(int lengh) {
       this.Cities = new City [lengh];
       this.nv = lengh ;
    }

    void AddEdge(int u_id, int v_id, int weight) {

        City u = this.Cities[u_id];
        City v = this.Cities[v_id];

        u.adjacent.insertEdge(v_id, weight);
        v.adjacent.insertEdge(u_id, weight) ;
    }

    void AddCity (String lebal , int Heuristic ,int index){   
    this.Cities[index] = new City (lebal , Heuristic) ; 
    }

    void printCities (){
        for (int i = 0; i < this.Cities.length; i++) {
            System.out.println(this.Cities[i].lebal);
            
        }
    }
        void printGraph (){
        for (int i = 0; i < this.Cities.length; i++) {
           System.out.println(this.Cities[i].lebal+" ");
           this.Cities[i].adjacent.tr();
           
        }
    }

    public City[] getCities() {
        return Cities;
    }

    public City getCity(int index) {
        return Cities[index];
    }
    public City getCity(String Lebal) {
        for (int i = 0; i < Cities.length; i++) {
            if (Cities[i].lebal.equals(Lebal))
            {return Cities[i];}
            
        }
        return null ;
    }
    public void setVert(City[] vert) {
        this.Cities = vert;
    }

    public int getNv() {
        return nv;
    }

    public void setNv(int nv) {
        this.nv = nv;
        this.Cities = new City [nv];
    }
    
    boolean AllGraphVisit (){
        for (int i = 0; i < Cities.length; i++) {
            if (Cities[i].visit == false){
            return false ;}    
        }
    return true ;
    }
    int findCity(String city)
    {
       int index=-1;
        for (int i = 0; i < Cities.length; i++) {
          if (city.equalsIgnoreCase(Cities[i].getLebal()))   
          {
              index=i;
              break;
          }
        }
       return index;
    }
   void makeunvisited()
   {
       for (int i = 0; i < Cities.length; i++) {
      Cities[i].visit=false;
           
       }
   }
    
}
