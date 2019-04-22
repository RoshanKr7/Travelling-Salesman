
package travellingsalesman;

public class Path {
    String SeqPath ;
    int TotalDistance ;

    public Path(String SeqPath, int TotalDistance) {
        this.SeqPath = SeqPath;
        this.TotalDistance = TotalDistance;
    }

    public Path() {
    }

    public String getSeqPath() {
        return SeqPath;
    }

    public void setSeqPath(String SeqPath) {
        this.SeqPath = SeqPath;
    }

     public int getTotalDistance() {
         
        return TotalDistance;
    }

    public void setTotalDistance(int TotalDistance) {
        this.TotalDistance = TotalDistance;
    }
    
    public void insert (City c , int Distance ){
        
    
    }

    public String LastCity (){
    String[] s =SeqPath.split("-");
       return s[s.length-1];
            }
    
        public String FirstCity (){
    String[] s =SeqPath.split("-");
       return s[0];
            }
}
