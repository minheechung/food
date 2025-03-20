package food.domain;

import food.domain.Cookfinished;
import food.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;
import java.time.LocalDate;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;


@Entity
@Table(name="Cook_table")
@Data

//<<< DDD / Aggregate Root
public class Cook  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    private Long id;
    
    
    
    
    private String orderid;
    
    
    
    
    private String foodid;
    
    
    
    
    private String option;
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){


        Cookfinished cookfinished = new Cookfinished(this);
        cookfinished.publishAfterCommit();

    
    }

    public static CookRepository repository(){
        CookRepository cookRepository = StoreApplication.applicationContext.getBean(CookRepository.class);
        return cookRepository;
    }



//<<< Clean Arch / Port Method
    public void isaccept(IsacceptCommand isacceptCommand){
        
        //implement business logic here:
        

        food.external.CookQuery cookQuery = new food.external.CookQuery();
        // cookQuery.set??()        
          = CookApplication.applicationContext
            .getBean(food.external.Service.class)
            .cook(cookQuery);

        Orderaccepted orderaccepted = new Orderaccepted(this);
        orderaccepted.publishAfterCommit();
        Orderrejected orderrejected = new Orderrejected(this);
        orderrejected.publishAfterCommit();
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public void cookstart(){
        
        //implement business logic here:
        


        Cookstarted cookstarted = new Cookstarted(this);
        cookstarted.publishAfterCommit();
    }
//>>> Clean Arch / Port Method

//<<< Clean Arch / Port Method
    public static void orderNoticed(Ordered ordered){
        
        //implement business logic here:
        
        /** Example 1:  new item 
        Cook cook = new Cook();
        repository().save(cook);

        */

        /** Example 2:  finding and process
        

        repository().findById(ordered.get???()).ifPresent(cook->{
            
            cook // do something
            repository().save(cook);


         });
        */

        
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public static void orderNoticed(Ordercanceled ordercanceled){
        
        //implement business logic here:
        
        /** Example 1:  new item 
        Cook cook = new Cook();
        repository().save(cook);

        */

        /** Example 2:  finding and process
        

        repository().findById(ordercanceled.get???()).ifPresent(cook->{
            
            cook // do something
            repository().save(cook);


         });
        */

        
    }
//>>> Clean Arch / Port Method


}
//>>> DDD / Aggregate Root
