import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;


public class SeatsTest {
    Presentations presentationList;
    @Before
    public void loaddata(){
        presentationList = new Presentations();
        presentationList = presentationList.loadFromJson();
        Main.personpath="testfiles/persons.json";
        Main.moviepath="testfiles/movies.json";
        Main.presentationpath="testfiles/presentations.json";
    }

    @Test
    public void IsSeatReservedTrue(){
        Seats seaties = new Seats();
        Seat seaty = new Seat();
        seaty.place = "A3";
        seaties.add(seaty);
        boolean truefalse = seaties.isSeatReserved("A3");
        Assert.assertEquals(truefalse,true);
    }
    @Test
    public void IsSeatReservedFalse(){
        Seats seaties = new Seats();
        Seat seaty = new Seat();
        seaty.place = "A3";
        seaties.add(seaty);
        boolean truefalse = seaties.isSeatReserved("test");
        Assert.assertEquals(truefalse,false);
    }

    @Test
    public void IsSeatBoughtTrue(){
        Seats seaties = new Seats();
        Seat seaty = new Seat();
        seaty.place = "A3";
        seaties.add(seaty);
        boolean truefalse = seaties.isSeatBought("A3");
        Assert.assertEquals(truefalse, true);

    }

    @Test
    public void IsSeatBoughtFalse(){
        Seats seaties = new Seats();
        Seat seaty = new Seat();
        seaty.place = "A3";
        seaties.add(seaty);
        boolean truefalse = seaties.isSeatBought("test");
        Assert.assertEquals(truefalse, false);
    }

    @Test
    public void SaveToJsonPossible(){
        Movie mov = new Movie();
        mov.id = 1;
        mov.title ="title";
        mov.duration = 185;
        mov.description ="Description";
        mov.imagePath ="imgpath";
        Presentations presList = new Presentations();
        Presentation pres = new Presentation(1,"20:15", LocalDate.now(),1);
        presList.add(pres);
        Seats seaties = new Seats();
        Seat seaty = new Seat("A5","Testing");
        seaties.add(seaty);
        seaties.saveToJson(seaties,mov,"20:15");
        Assert.assertNotNull(seaties.loadFromJson(mov,"20:15"));

        presentationList.saveToJson();

    }

    @Test
    public void LoadJsonPossible(){
        Movie mov = new Movie();
        mov.id = 1;
        mov.title ="title";
        mov.duration = 185;
        mov.description ="Description";
        mov.imagePath ="imgpath";
        Seats seaties = new Seats();
        seaties.loadFromJson(mov,"20:15");
        System.out.println(seaties.loadFromJson(mov,"20:15"));
        Assert.assertNotNull(seaties.loadFromJson(mov,"20:15"));
    }

    @Test
    public void LoadJsonNotPossible(){
        Movie mov = new Movie();
        mov.id = 1;
        mov.title ="title";
        mov.duration = 185;
        mov.description ="Description";
        mov.imagePath ="imgpath";
        Seats seaties = new Seats();
        Assert.assertNull(seaties.loadFromJson(mov,"20:30"));
    }

    @Test
    public void SaveBoughtToJsonPossible(){
        Movie mov = new Movie();
        mov.id = 1;
        mov.title ="title";
        mov.duration = 185;
        mov.description ="Description";
        mov.imagePath ="imgpath";
        Presentations presList = new Presentations();
        Presentation pres = new Presentation(2,"20:15", LocalDate.now(),2);
        presList.add(pres);
        Seats seaties = new Seats();
        Seat seaty = new Seat("A5","Testing");
        seaties.add(seaty);
        seaties.saveBoughtToJson(seaties,mov,"20:15");
        Assert.assertNotNull(seaties.loadBoughtFromJson(mov,"20:15"));

        presentationList.saveToJson();

    }

    @Test
    public void LoadBoughtFromJsonPossible(){
        Movie mov = new Movie();
        mov.id = 1;
        mov.title ="title";
        mov.duration = 185;
        mov.description ="Description";
        mov.imagePath ="imgpath";
        Seats seaties = new Seats();
        seaties.loadBoughtFromJson(mov,"20:15");
        Assert.assertNotNull(seaties.loadBoughtFromJson(mov,"20:15"));
    }

    @Test
    public void LoadBoughtJsonNotPossible(){
        Movie mov = new Movie();
        mov.id = 1;
        mov.title ="title";
        mov.duration = 185;
        mov.description ="Description";
        mov.imagePath ="imgpath";
        Seats seaties = new Seats();
        seaties.loadBoughtFromJson(mov,"20:30");
        Assert.assertNotNull(seaties.loadBoughtFromJson(mov,"20:15"));
    }

    @Test
    public void delFromJsonPossible(){
        Seats seaties = new Seats();
        Movie mov = new Movie();
        mov.id = 2;
        mov.title ="title";
        mov.duration = 185;
        mov.description ="Description";
        mov.imagePath ="imgpath";
        Seat seaty = new Seat("A8","Testperson");
        seaties.add(seaty);
        seaties.saveToJson(seaties ,mov,"20:15");
        seaties.delFromJson(mov, "20:15");
    }
}