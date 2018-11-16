package Actors2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.collections.ObservableList;
public class Actors {
    private String ActorsOne,ActorsTwo,ActorsAge,ActorsThree;
    /*    private Integer ActorsTwo, ActorsAge;
    // private Double actorSum;
    private Double ActorsThree;*/
    public Actors(String ActorsTwo, String ActorsOne, String ActorsThree, String ActorsAge){
        this.ActorsTwo=ActorsTwo;
        this.ActorsOne=ActorsOne;
        this.ActorsThree=ActorsThree;
        this.ActorsAge=ActorsAge;
    }
    public Actors(){
        this.ActorsOne="";
        this.ActorsTwo="";
        this.ActorsThree="";
        this.ActorsAge="";
    }
    public String getActorsOne(){
        return this.ActorsOne;
    }
    public String getActorsTwo(){
        return this.ActorsTwo;
    }
    //public Double getactorSum(){
      //  return this.actorSum;
    //}
    public String getActorsAge(){
        return this.ActorsAge;
    }
    public String getActorsThree(){
        return this.ActorsThree;
    }
    public void setActorsOne(String ActorsOne){
        this.ActorsOne=ActorsOne;
    }
    public void setActorsTwo(String ActorsTwo){
        this.ActorsTwo=ActorsTwo;
    }
   // public void setactorSum (Double actorSum){
     //   this.actorSum=actorSum;
    //}
    public void setActorsAge (String ActorsAge){
        this.ActorsAge=ActorsAge;
    }
    public void setActorsThree (String ActorsThree){
        this.ActorsThree=ActorsThree;
    }
    static void Rebuildfile(ObservableList<Actors> list){
        Actors actor;
        BufferedWriter br = null;
        File shopitems=new File("actors2.txt");
        try{
            try{
                br=new BufferedWriter(new FileWriter(shopitems.getAbsoluteFile(),false));
                for(int i=0;i<list.size();i++){
                    actor=list.get(i);
                    br.write(actor.getActorsOne()+":"
                            +actor.getActorsTwo()+":"
                            +actor.getActorsThree()+":"
                            +actor.getActorsAge());
                    if (i!=(list.size()-1))
                        br.newLine();
                }
            }
            finally{
                br.close();
            }
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
    static void addactor(Actors actor){
        BufferedWriter br = null;
        File shopitems=new File("actors2.txt");
        try{
            try{
                br=new BufferedWriter(new FileWriter(shopitems.getAbsoluteFile(),true));
                br.newLine();
                br.write(actor.getActorsOne()+":"
                            +actor.getActorsTwo()+":"
                            +actor.getActorsThree()+":"
                            +actor.getActorsAge());
            }
            finally{
                br.close();
            }
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
	     public static void writeFile(ObservableList list) throws IOException {
    }
}