package onlinevotingsystem;
//Creating a concrete class which implements the Container interface. 
//This class has inner class SeatingIterator that implements the Iterator interface.

import iteratordesign.Iterator;
import iteratordesign.Container;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

class VoteCountingRepository implements Container {

    public String seating[] = {"Joe Bidens's Votes are ", "Donald Trump's Votes are "};

    public VoteCountingRepository() {
        try {
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get("JoeBiden.txt")));
            ArrayList<String> lines1 = new ArrayList<>(Files.readAllLines(Paths.get("DonaldTrump.txt")));
            seating[0] += String.valueOf(lines.size());
            seating[1] += String.valueOf(lines1.size());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Iterator getIterator() {
        return new SeatingIterator();
    }

    private class SeatingIterator implements Iterator {

        int index;

        public boolean hasNext() {

            if (index < seating.length) {
                return true;
            }
            return false;
        }

        public Object next() {

            if (this.hasNext()) {
                return seating[index++];
            }
            return null;
        }
    }
}
