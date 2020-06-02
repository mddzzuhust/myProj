public class ScoreStateTest {
    public static void main(String[] args){
        ScoreContext account=new ScoreContext();
        System.out.println("ceshi");
        account.add(30);
        account.add(40);
        account.add(25);
        account.add(-15);
        account.add(-25);
    }
}
class ScoreContext{
    private AbstractState state;
    ScoreContext(){
        state=new LowState(this);
    }
    public void setState(AbstractState state){
        this.state=state;
    }
    public AbstractState getState(){
        return state;
    }
    public void add(int score){
        state.addScore(score);
    }
}
abstract class AbstractState{
    protected ScoreContext hj;
    protected String stateName;
    protected int score;
    public abstract void checkState();
    public void addScore(int x){
        score+=x;
        System.out.print("x:"+x+"fenshu:"+score);
        checkState();
        System.out.println("dangqianzhuangtai: "+hj.getState().stateName);
    }
}
class LowState extends AbstractState{
    public LowState(ScoreContext h){
        hj=h;
        stateName="bujige";
        score=0;
    }
    public LowState(AbstractState state){
        hj=state.hj;
        stateName="bujige";
        score=state.score;
    }
    public void checkState(){
        if (score>=90){
            hj.setState(new HighState(this));
        }else if(score>=60){
            hj.setState(new MiddleState(this));
        }
    }
}
class MiddleState extends AbstractState{
    public MiddleState(AbstractState state){
        hj=state.hj;
        stateName="zhongdeng";
        score=state.score;
    }
    public void checkState(){
        if(score<60){
            hj.setState(new LowState(this));
        }else if(score>=90){
            hj.setState(new HighState(this));
        }
    }
}
class HighState extends AbstractState{
    public HighState(AbstractState state){
        hj=state.hj;
        stateName="youxiu";
        score=state.score;
    }
    public void checkState(){
        if(score<60){
            hj.setState(new LowState(this));
        }else if(score<90){
            hj.setState(new MiddleState(this));
        }
    }
}