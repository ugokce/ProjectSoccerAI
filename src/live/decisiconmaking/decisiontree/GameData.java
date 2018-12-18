package live.decisiconmaking.decisiontree;

public interface GameData {
    //burada decisionlarda kullanacağımız sorguları ekleyeceğiz
    public boolean AmIAtTheBall();
    public boolean AmIClosestToBallinMyTeam();
    public boolean AmICloseToGoal();
    public boolean IsGoalFreeToGo();
}
