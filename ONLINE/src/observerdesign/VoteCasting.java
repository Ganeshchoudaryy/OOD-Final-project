package observerdesign;
//VoteCasting is an object having methods to attach and detach observers to a client object
import java.util.ArrayList;
import java.util.List;

public class VoteCasting {
    private List<VoteCastingObserver> votecastingsobservers = new ArrayList<VoteCastingObserver>();
    private int state;
    
    public int getState() {
        return state;
    }
    
    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(VoteCastingObserver votecastingsobserver){
        votecastingsobservers.add(votecastingsobserver);
    }

    public void notifyAllObservers(){
        for (VoteCastingObserver votecastingsobserver : votecastingsobservers) {
        votecastingsobserver.update();
        }
    } 	
    
}
