public class bot  {
    public static final String BOT_NAME = "BammerBOT!";

    private static Range goodRange = new Range("22+, A2s+, K2s+, Q4s+, J6s+, T6s+, 95s+, 85s+, 74s+, 63s+, 53s+, 43s, 32s, A2o+, K7o+, Q9o+, J9o+, T9o, 98o");
    private static Range greatRange = new Range("77+, ATs+, A5s, KTs+, QTs+, J9s+, T9s, 98s, AQo+");
    private static Range megaRange = new Range("88+, AJs+, AKo");
    private static HandType currentBotHand;
    private static HandType currentBoardHand;

    public static int act(Observable obs) throws Exception {
        currentBotHand = obs.getMyHandType();
        currentBoardHand = obs.getBoardHandType();

        // fold if bad
        if (obs.getCurrentRound() == 0) {

        if (megaRange.isHandInRange(obs.getMyHand())){
            return obs.getMaxRaise();
        } else if (goodRange.isHandInRange(obs.getMyHand())){
            return obs.getMinRaise(); // raise
        } 
        } else {
            return 0; // call
        }    

        

        switch (obs.getCurrentRound()) {                
            case 1:
                return bet(7,5,3,1,obs);
            case 2:
                return bet(7,5,3,1,obs);
            case 3:
                return bet(7,5,3,1,obs);
            case 4:
                return bet(7,5,3,1,obs);
        }
        


        return getRandom(obs); // random
    }


    public static int getRandom(Observable obs) {
        if (Math.random() <= 0.5){
            return obs.getMinRaise();
        } else {
            return 1;
        }
    }

    public static int bet(int great, int good, int ok, int bad, Observable obs) {
        if (currentBotHand.getValue() >= great) {
            return obs.getMaxRaise(); // great hand
        }
        if (currentBotHand.getValue() >= good) {
            return obs.getMinRaise(); // good hand
        }
        if (currentBotHand.getValue() >= ok) {
            return 1; // ok hand
        }
        if (currentBotHand.getValue() <= bad) return 0;

        return getRandom(obs);
    }

    public static int goodshit(Observable obs) {

        return 1;
    }
 }