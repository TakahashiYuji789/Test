package janken.abs.co.jp.janken;

public class NumberContainer {
    private static int battleNumber_;
    private static int winNumber_;
    private static int loseNumber_;
    private static int drawNumber_;
    private static int countBattle_;
    public  static int playerNum[];
    public  static int enemyNum[];
    public  static boolean battleType_;
    public  void Initialize(){

        battleNumber_ = 0;
        winNumber_    = 0;
        loseNumber_   = 0;
        drawNumber_   = 0;
        countBattle_  = 0;
    }
    public  void  setCountBattle_(int num){
        countBattle_ +=num;
    }

    public void setBattleNumber_(int num) {
        battleNumber_ += num;
    }

    public void setWinNumber_(int num) {
        winNumber_ += num;
    }

    public void setLoseNumber_(int num) {
        loseNumber_+= num;
    }

    public void setDrawNumber_(int num) {
        drawNumber_ += num;
    }

    public  int getCountBattle_(){
        return  countBattle_;
    }

    public int getBattleNumber_() {
        return battleNumber_;
    }

    public int getWinNumber_() {
        return winNumber_;
    }

    public int getLoseNumber_() {
        return loseNumber_;
    }

    public int getDrawNumber_() {
        return drawNumber_;
    }
    public  boolean battleOver(){
        int overNum = drawNumber_+loseNumber_+winNumber_;
        if(overNum==battleNumber_)
            return  true;
        return  false;
    }
    public  boolean CountedOver(){
        int halfbattleNum =battleNumber_/2;
        if(winNumber_>=halfbattleNum ||drawNumber_>=halfbattleNum||loseNumber_>=halfbattleNum)
            return  true;
        return  false;
    }

}
