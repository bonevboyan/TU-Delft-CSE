package practice_exams.deezer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    private static String menu = """
            Please make your choice:
            1 – Print all albums & songs
            2 – Add a new advertisement
            3 – Enable shuffling of songs
            4 – Add song to front of playlist
            5 – Write to file
            6 – Calculate commercial value
            7 – Stop the program""";

    /**
     * Runs the program
     * @param args of the main method
     */
    public static void main(String[] args) {
        Scanner consoleScanner = new Scanner(System.in);
        System.out.print("Please enter a filename: ");
        String filename = consoleScanner.nextLine();

        Catalogue catalogue = null;
        Playlist playlist = new Playlist(new ArrayList<>());

        try {
            Scanner fileScanner = new Scanner(new File(filename));
            fileScanner.nextLine();

            List<Album> albums = Reader.readAlbum(fileScanner);
            List<Ad> ads = Reader.readAds(fileScanner);
            catalogue = new Catalogue(albums, ads);
        } catch(FileNotFoundException ex) {
            System.out.println("Error!");
            return;
        }

        int option = 0;
        do {
            System.out.println(menu);
            option = consoleScanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println(String.join("\n",
                            catalogue.getAlbums().stream().map(Album::toString).toList()));
                    break;
                case 2:
                    Ad ad = getAd(consoleScanner);
                    catalogue.addAd(ad);
                    break;
                case 3:
                    playlist = catalogue.generatePlaylist();
                    System.out.println(playlist);
                    break;
                case 4:
                    handleAddSong(consoleScanner, catalogue, playlist);
                    break;
                case 5:
                    writeToFile(filename, catalogue);
                    break;
                case 6:
                    System.out.printf("Total value: %.2f\n", playlist.commercialValue());
                    break;
            }
        } while(option != 7);
    }

    private static void writeToFile(String filename, Catalogue catalogue) {
        try (PrintWriter printWriter = new PrintWriter(filename)) {
            printWriter.write(catalogue.toString());
        } catch (FileNotFoundException ex) {
            System.out.println("Invalid file!");
        }
    }

    /**
     * Adds song from catalogue to playlist if found
     * @param consoleScanner to read input
     * @param catalogue to search in
     * @param playlist to add in
     */
    public static void handleAddSong(Scanner consoleScanner,
                                      Catalogue catalogue, Playlist playlist) {
        System.out.print("Enter song name: ");
        String name = consoleScanner.nextLine();
        Track track = catalogue.getTrack(name);

        if (track == null) {
            System.out.println("Invalid track name!");
        } else {
            playlist.addSongInFront(track);
            System.out.println(playlist);
        }
    }

    /**
     * Get ad from console
     * @param consoleScanner to read
     * @return new ad
     */
    public static Ad getAd(Scanner consoleScanner) {
        System.out.println("Please enter company, duration & price of new ad: ");
        String name = consoleScanner.next();
        String duration = consoleScanner.next();
        double price = consoleScanner.nextDouble();
        Ad ad = new Ad(name, duration, price);
        return ad;
    }
}
