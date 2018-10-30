import java.util.ArrayList;
import java.util.Iterator;


public class Seats extends ArrayList<Seat>{

    //Methoden

    public boolean isSeatReserved(String seatplace) {
        for (Seat seat : this) {
            if (seat.place.equals(seatplace)) {
                return true;
            }
        }
        return false;
    }



    public boolean isSeatBought(String seatplace) {
        for (Seat seat : this) {
            if (seat.place.equals(seatplace)) {
                return true;
            }
        }
        return false;
    }



    public void saveToJson(Seats toSave, Movie movie, String playTime){
        Presentations presList = new Presentations();
        presList = presList.loadFromJson();
        for (Presentation pres : presList){
            if (pres.movieId == movie.id && pres.playTime.equals(playTime)){
                for (Seat seat : toSave){
                    pres.reservedSeats.add(seat);
                }
            }
        }
        presList.saveToJson();
    }



    public Seats loadFromJson(Movie movie, String playTime){
        Presentations presList = new Presentations();
        presList = presList.loadFromJson();
        for (Presentation pres : presList){
            if (pres.movieId == movie.id && pres.playTime.equals(playTime)){
                return pres.reservedSeats;
            }
        }
        return null;
    }



    public void saveBoughtToJson(Seats toSave, Movie movie, String playTime){
        Presentations presList = new Presentations();
        presList = presList.loadFromJson();
        for (Presentation pres : presList){
            if (pres.movieId == movie.id && pres.playTime.equals(playTime)){
                for (Seat seat : toSave){
                    pres.boughtSeats.add(seat);
                }
            }
        }

        presList.saveToJson();
    }



    public Seats loadBoughtFromJson(Movie movie, String playTime){
        Presentations presList = new Presentations();
        presList = presList.loadFromJson();
        for (Presentation pres : presList){
            if (pres.movieId == movie.id && pres.playTime.equals(playTime)){
                return pres.boughtSeats;
            }
        }
        return null;
    }




    //Iterator

    public void delFromJson(Movie movie, String playTime){
        if (!this.isEmpty()){
            Seats seatsLoaded = new Seats();
            seatsLoaded = seatsLoaded.loadFromJson(movie, playTime);
            for (Iterator<Seat> iter = seatsLoaded.iterator(); iter.hasNext();) {
                Seat seat = iter.next();
                for (Seat seatToDel: this){
                    if(seat.place.equals(seatToDel.place)){
                        iter.remove();
                    }
                }
            }
            Presentations presentations = Presentations.loadFromJson();
            for(Presentation pres: presentations ){
                if(pres.movieId == movie.id && pres.playTime.equals(playTime)){
                    pres.reservedSeats.clear();
                    pres.reservedSeats = seatsLoaded;
                }
            }
            presentations.saveToJson();
        }
    }


}
