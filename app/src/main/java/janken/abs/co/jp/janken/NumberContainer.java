package janken.abs.co.jp.janken;

public class NumberContainer {
    private static int battleNumber_;
    private static int winNumber_;
    private static int loseNumber_;
    private static int drawNumber_;
    private static int countBattle_;
    public  static boolean battleType_;
    //初期化
    public  void Initialize(){
        battleNumber_ = 0;
        winNumber_    = 0;
        loseNumber_   = 0;
        drawNumber_   = 0;
        countBattle_  = 0;
    }
    //対戦した数をセット
    public  void  setCountBattle_(int num){
        countBattle_ +=num;
    }
    //対戦数をセット
    public void setBattleNumber_(int num) {
        battleNumber_ += num;
    }
    //勝った数をセット
    public void setWinNumber_(int num) {
        winNumber_ += num;
    }
    //負けた数をセット
    public void setLoseNumber_(int num) {
        loseNumber_+= num;
    }
    //引き分け数をセット
    public void setDrawNumber_(int num) {
        drawNumber_ += num;
    }
    //対戦した数を取得
    public  int getCountBattle_(){
        return  countBattle_;
    }
     //勝った数を取得
    public int getWinNumber_() {
        return winNumber_;
    }
    //負けた数を取得
    public int getLoseNumber_() {
        return loseNumber_;
    }
    //引き分け数を取得
    public int getDrawNumber_() { return drawNumber_; }
    //対戦終わった？
    public  boolean battleOver(){
        int overNum = drawNumber_+loseNumber_+winNumber_;
        if(overNum==battleNumber_)
            return  true;
        return  false;
    }
    //星取り戦専用(半分以上に達した？)
    public  boolean CountedOver(){
        int halfbattleNum =battleNumber_/2;
        if(winNumber_>=halfbattleNum ||drawNumber_>=halfbattleNum||loseNumber_>=halfbattleNum)
            return  true;
        return  false;
    }
}
