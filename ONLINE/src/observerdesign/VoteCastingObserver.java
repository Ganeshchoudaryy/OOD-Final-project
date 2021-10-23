package observerdesign;
//Creating Observer class named VoteCastingObserver.

import observerdesign.VoteCasting;


public abstract class VoteCastingObserver {
    protected VoteCasting votecasting;
    public abstract void update();
}
