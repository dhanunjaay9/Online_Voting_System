public class votes {
    private String Party;
    protected static int Votes;
    protected static int janasena;
    protected static int ycp;
    protected static int trs;
    protected static int congress;
    protected static int tdp;
    public void setVote(String vote)
    {
        this.Party=vote;
    }
    public  void setCount()
    {
        Votes++;
    }
    public void setJanasena()
    {
        janasena++;
    }
    public void setYcp(){
        ycp++;
    }
    public void setCongress()
    {
        congress++;
    }
    public void setTrs()
    {
        trs++;
    }
    public void setTdp()
    {
        tdp++;
    }
    public String getVote()
    {
        return Party;
    }
    public int getCount()
    {
        return Votes;
    }
    public int getJanasena(){return janasena;}
    public int getYcp(){return ycp;}
    public int getTrs(){return trs;}
    public int getCongress(){return congress;}
    public int getTdp(){return tdp;}
}
