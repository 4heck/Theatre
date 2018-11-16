package ShowCatalog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javafx.collections.ObservableList;
public class Performance {
    private String PerformanceName,PerformanceGenre,PerformanceAge,PerformanceActors, PerformanceHall;
    private Integer PerformanceCount;
    private ArrayList<Performance> Performance;
    public Performance(String PerformanceGenre, String PerformanceName, String PerformanceActors,
                       String PerformanceAge, String PerformanceHall,Integer PerformanceCount){
        
        this.PerformanceGenre=PerformanceGenre;
        this.PerformanceName=PerformanceName;
        this.PerformanceActors=PerformanceActors;
        this.PerformanceAge=PerformanceAge;
        this.PerformanceHall=PerformanceHall;
        this.PerformanceCount=PerformanceCount;
        this.Performance=new ArrayList<Performance>();
    }
    public Performance(){
        this.PerformanceGenre="";
        this.PerformanceName="";
        this.PerformanceActors="";
        this.PerformanceAge="";
        this.PerformanceHall="";
        this.PerformanceCount=0;
    }

    public Performance(String PerformanceName, int PerformanceCount) {
        this.PerformanceName=PerformanceName;
        this.PerformanceCount=PerformanceCount;
    }

    
    public String getPerformanceName(){
        return this.PerformanceName;
    }
    public String getPerformanceGenre(){
        return this.PerformanceGenre;
    }
    public String getPerformanceAge(){
        return this.PerformanceAge;
    }
    public String getPerformanceActors(){
        return this.PerformanceActors;
    }
    public String getPerformanceHall(){
        return this.PerformanceHall;
    }
    public Integer getPerformanceCount(){
        return this.PerformanceCount;
    }
            
    //
        public ArrayList<Performance> getPerformance(){
        return this.Performance;
        }
        
        public void setPerformance(ArrayList<Performance>Performance){
        this.Performance=Performance;
    }
    //
            public void setPerformanceName(String PerformanceName){
                this.PerformanceName=PerformanceName;
            }
            public void setPerformanceGenre(String PerformanceGenre){
                this.PerformanceGenre=PerformanceGenre;
            }
            public void setPerformanceAge (String PerformanceAge){
                this.PerformanceAge=PerformanceAge;
            }
            public void setPerformanceActors (String PerformanceActors){
                this.PerformanceActors=PerformanceActors;
            }
            public void setPerformanceHall (String PerformanceHall){
                this.PerformanceHall=PerformanceHall;
            }
            public void setPerformanceCount( Integer PerformanceCount){
                this.PerformanceCount=PerformanceCount;
            }
            
    static void RebuildShowfile(ObservableList<Performance> list){
        Performance show;
        BufferedWriter br = null;
        File performances=new File("performances.txt");
        try{
            try{
                br=new BufferedWriter(new FileWriter(performances.getAbsoluteFile(),false));
                for(int i=0;i<list.size();i++){
                    show=list.get(i);
                    br.write(show.getPerformanceName()+":"
                            +show.getPerformanceGenre()+":"
                            +show.getPerformanceActors()+":"
                            +show.getPerformanceAge()+":"
                            +show.getPerformanceHall()+":"
                            +show.getPerformanceCount());
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
    static void addProduct(Performance show){
        BufferedWriter br = null;
        File performances=new File("performances.txt");
        try{
            try{
                br=new BufferedWriter(new FileWriter(performances.getAbsoluteFile(),true));
                br.newLine();
                br.write(show.getPerformanceName()+":"
                            +show.getPerformanceGenre()+":"
                            +show.getPerformanceActors()+":"
                            +show.getPerformanceAge()+":"
                            +show.getPerformanceHall()+":"
                            +show.getPerformanceCount());
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
