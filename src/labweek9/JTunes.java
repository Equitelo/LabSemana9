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
                    JOptionPane.showMessageDialog(null, "Cancion agregada"+sng.getName());
                    return true;
                } 
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error! Cancion ya existe.");
        }
        return false;
    }
    
    public void rateSong(int stars, int code){
        Song song = searchSong(code);
        if (song!=null) {
            song.addStars(stars);
            JOptionPane.showMessageDialog(null, "La cancion fue actualizada. ");
            song.print();
        } else {
            JOptionPane.showMessageDialog(null, "No existe dicha cancion");
        }
    }
    
    public void printSongs() {
        System.out.println("Lista de canciones:");
        for (Song sng : songs) {
            if (sng != null) {
                sng.print(); 
            }
        }
    }
}
