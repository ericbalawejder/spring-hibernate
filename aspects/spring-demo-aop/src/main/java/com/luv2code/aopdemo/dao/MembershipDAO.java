package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void addAccount() {
        System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
    }

    public String addSillyMember() {
        System.out.println(getClass() + ": OH SILLY");
        return "Silly";
    }

    public void goToSleep() {
        System.out.println(getClass() + ": I'M GOING TO SLEEP NOW.");
    }
}
