package com.example.demo.SERVICES;


import com.example.demo.ENTITIES.SPID;
import com.example.demo.ENTITIES.USER;
import com.example.demo.ENTITIES.status;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;


public class Manager{
    private ArrayList<SPID> spid_list;

    public Manager() {
        this.spid_list = new ArrayList<SPID>();
    }

    public USER createUser(long id, String name, String surname, String username) {
        USER user = null;
        try {
            user = new USER(id, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), name, surname, username);
        } catch (Exception e) {
            System.out.println("Something went wrong " + e);
        } finally {
            System.out.println("Created user " + name + ".");
        }
        return user;
    }

    public SPID createSpid(USER user, String description) {
        SPID spid = null;
        try {
            spid = new SPID(user.getId(), new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), user.getId(), user, description);
        } catch (Exception e) {
            System.out.println("Something went wrong " + e);
        } finally {
            System.out.println("Created spid of user " + user.getName() + ".");
        }
        return spid;
    }

    public void editUserName(USER user,String name){
        String oldUserName = user.getName();
        user.setName(name);
        System.out.println("Changed the name of a user from " + oldUserName + " to " + name + ".");
    }
    public void editUserSurname(USER user,String surname) {
        String oldUserSurname = user.getSurname();
        user.setSurname(surname);
        System.out.println("Changed the surname of " + user.getName() +  " from " + oldUserSurname + " to " + surname + ".");

    }
    public void editUserUsername(USER user,String username){
        String oldUserUsername = user.getUsername();
        user.setUsername(username);
        System.out.println("Changed the username of " + user.getName() + " from " + oldUserUsername + " to " + username + ".");

    }
    public void editSpidDescription(SPID spid,String description){
        String oldSpidDescription = spid.description;
        spid.setDescription(description);
        System.out.println("The description of the SPID of user " + spid.user.getName() + " was changed from " + oldSpidDescription + " to " + description);
    }
    public void aproveSpid(SPID spid){
        spid.setStatus(status.APROVED);
        System.out.println("The status of the spid " + spid.getId() + " was changed to " + spid.getStatus() + ".");
    }

    public void addSpid(SPID spid){

        this.spid_list.add(spid);
        System.out.println("Added spid nr " + spid.getId() + ".");
    }

    public void showAllSpids(){
        spid_list
                .stream()
                .forEach((v) -> System.out.println(v));
    }
    public List<USER> searchUserByName(String name){
        return spid_list
                .stream()
                .filter((c) -> c.getUser().getName() == name)
                .map((v) -> v.getUser())
                .collect(Collectors.toList());
    }

    public List<USER> searchUserBySurname(String surname){
        return spid_list
                .stream()
                .filter((c) -> c.getUser().getSurname() == surname)
                .map((v) -> v.getUser())
                .collect(Collectors.toList());
    }
    public List<USER> searchUserByUsername(String username){
        return spid_list
                .stream()
                .filter((c) -> c.getUser().getName() == username)
                .map((v) -> v.getUser())
                .collect(Collectors.toList());
    }

    public List<SPID> searchUserSpid(USER user){
        return spid_list
                .stream()
                .filter((v) -> v.getId() == user.getId())
                .collect(Collectors.toList());
    }


}








