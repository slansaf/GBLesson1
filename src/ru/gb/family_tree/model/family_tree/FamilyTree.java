package ru.gb.family_tree.model.family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeNode<E>> implements Serializable, Iterable<E> {
    private  long humansId;
    private List<E> humanList;

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public FamilyTree(List<E> humanList) {
        this.humanList = humanList;
    }

    public boolean addHuman(E human){
        if (human == null){
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(humansId++);

            addToParents(human);
            addToChildern(human);

            return true;
        }
        return false;
    }

    private void addToParents(E human){
        for (E parent: human.getParents()){
            parent.addChild(human);
        }
    }

    private void addToChildern(E human){
        for (E child: human.getChildren()){
            child.addParent(human);
        }
    }

    public List<E> getSiblings(int id){
        E human = getById(id);
        if (human == null){
            return  null;
        }
        List<E> res = new ArrayList<>();
        for (E parent: human.getParents()){
            for(E child: parent.getChildren()){
                if(!child.equals(human)){
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<E> findByName(String name){
        List<E> res = new ArrayList<>();
        for (E human: humanList){
            if (human.getName().equals(name)){
                res.add(human);
            }
        }
        return res;
    }

    public boolean setWedding(long humansId1, long humansId2){
        if(checkId(humansId1) && checkId(humansId2)){
            E human1 = getById(humansId1);
            E human2 = getById(humansId2);
            if (human1.getSpouse() == null && human2.getSpouse() == null){
                human1.setSpouse(human2);
                human2.setSpouse(human1);
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean setDivorse(long humansId1, long humansId2){
        if(checkId(humansId1) && checkId(humansId2)){
            E human1 = getById(humansId1);
            E human2 = getById(humansId2);
            if (human1.getSpouse() != null && human2.getSpouse() != null){
                human1.setSpouse(null);
                human2.setSpouse(null);
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean remuve(long humansId){
        if(checkId(humansId)){
            E human = getById(humansId);
            return  humanList.remove(human);
        }
        return false;
    }

    private boolean checkId(long id){
        return id < humansId && id >= 0;
    }

    public  E getById(long id){
        for (E human: humanList){
            if(human.getId() == id){
                return human;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return getInfo();
    }

    public String getInfo() {
       StringBuilder stringBuilder = new StringBuilder();
       stringBuilder.append("В дереве ");
       stringBuilder.append(humanList.size());
       stringBuilder.append("объектов: \n");
        for (E human : humanList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sotrByName(){
        humanList.sort(new HumanComparatorByName<>());
    }

    public void sortByBirthDate(){
        humanList.sort(new HumanComparatorByBirthDate<>());
    }

    @Override
    public Iterator<E> iterator(){
        return new FamiliTreeIterator<>(humanList);
    }
}
