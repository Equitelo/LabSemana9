package labweek9;

import javax.swing.JOptionPane;

public class JTunes {
    
    Song songs[];
    
    public JTunes(){
        this.songs=new Song[20];
    }
    
    public Song searchSong(int code){
        for (Song sng: songs) {
            if(sng != null && sng.getCode()==code){
                return sng;
            }
        }
        return null;
    }
    
    public boolean addSong(int code, String name, double price){
        if (searchSong(code) == null) {
            for (Song sng: songs) {
                if (sng == null) {
                    sng = new Song(code, name, price);
                    return true;
                } 
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error! Cancion ya existe.");
        }
        return false;
    }
    
    public void rateSong(int stars, int code){
        if (stars < 1 || stars > 5) {
            JOptionPane.showMessageDialog(null, "Ingrese una calificación entre 1 y 5 estrellas.");
            return;
        }
        Song song = searchSong(code);

        if (song != null) {
            song.addStars(stars);
            JOptionPane.showMessageDialog(null, "La canción fue actualizada. Rating actual: " + song.songRating());
        } 
    }
    
    public void imprimirCanciones(){
        for (int i = 0; i < songs.length; i++) {
            songs[i].print();
            if(songs[i]==null){
                break;
            }
        }
    }
    
    public String [] busquedaLista(String busqueda){
        int cantidad = 0;
        for (int i = 0; i < songs.length; i++) {
            if(songs[i]!=null && songs[i].getName().toLowerCase().contains(busqueda.toLowerCase())){
                cantidad++;
            }
        }
        if (cantidad==0) {
            return null;
        }
        String[] nombres = new String[cantidad];
        cantidad = 0;
        for (int i = 0; i < songs.length; i++) {
            if(songs[i]!=null && songs[i].getName().toLowerCase().contains(busqueda.toLowerCase())){
                nombres[cantidad] = songs[i].getName();
                cantidad++;
            }
        }
        return nombres;
    }
}
