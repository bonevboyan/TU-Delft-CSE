package practice_exams.deezer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Reader {
    /**
     * Parses Albums from scanner
     * @param scanner to read from
     * @return the parsed albums
     */
    public static List<Album> readAlbum(Scanner scanner) {
        List<Album> albums = new ArrayList<>();

        String line = scanner.nextLine();

        while (true) {
            if (line.startsWith("ALBUM")) {
                String[] tokens = line.split("; ");
                String artist = tokens[0].replaceFirst("ALBUM ", "");
                String name = tokens[1];
                int year = Integer.parseInt(tokens[2]);

                List<String> artists = Arrays.stream(scanner.nextLine()
                        .replaceFirst("ARTISTS ", "").split("; ")).toList();

                List<Track> tracks = new ArrayList<>();

                while (true) {
                    line = scanner.nextLine();

                    if (!line.startsWith("TRACK")) {
                        break;
                    }

                    String[] trackTokens = line.split("; ");
                    Track track = new Track(trackTokens[1], trackTokens[2]);

                    tracks.add(track);
                }

                Album newAlbum = new Album(name, artist, year, artists, tracks);
                albums.add(newAlbum);
            } else if (line.startsWith("ADS")) {
                break;
            }
        }

        return albums;
    }

    /**
     * Parses Ads from scanner
     * @param scanner to read from
     * @return the parsed ads
     */
    public static List<Ad> readAds(Scanner scanner) {
        List<Ad> ads = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String[] tokens = scanner.nextLine().split("; ");
            String name = tokens[0].split(" ")[1];
            String length = tokens[1];
            double price = Double.parseDouble(tokens[2].split(" ")[0]);

            Ad newAdd = new Ad(name, length, price);
            ads.add(newAdd);
        }

        return ads;
    }
}
