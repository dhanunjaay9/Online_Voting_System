package com.example.cdhan.onlinevotingsystem;

public class user {
    private String aadhar;
    private String vote;
    private String macaddr;
    public void setAadhar(String number)
    {
        this.aadhar=number;
    }
    public void setVote(String vote)
    {
        this.vote=vote;
    }
    public void setMacaddr(String mac)
    {
        this.macaddr=mac;
    }
    public String getAadhar()
    {
        return aadhar;
    }
    public String getVote()
    {
        return vote;
    }
    public String getMacaddr()
    {
        return macaddr;
    }
}
