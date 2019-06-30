package com.example.cdhan.onlinevotingsystem;

public class votes {
    private String vote;
    protected static int count;
    /*protected static int janasena;
    protected static int ycp;
    protected static int trs;
    protected static int congress;
    protected static int tdp;*/
    public void setVote(String vote)
    {
        this.vote=vote;
    }
    public  void setCount()
    {
        count++;
    }
    /*public void setJanasena()
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
    }*/
    public String getVote()
    {
        return vote;
    }
    public int getCount()
    {
        return count;
    }
    /*public int getJanasena(){return janasena;}
    public int getYcp(){return ycp;}
    public int getTrs(){return trs;}
    public int getCongress(){return congress;}
    public int getTdp(){return tdp;}*/
}
