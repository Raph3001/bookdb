package at.kaindorf.bookshop.bookdb_2;

import at.kaindorf.bookshop.bookdb_2.pojos.AudioBook;
import at.kaindorf.bookshop.bookdb_2.pojos.Book;
import at.kaindorf.bookshop.bookdb_2.pojos.EBook;

import java.util.Comparator;
import java.util.List;

/**
 * Project: bookdb_2
 * Created by: raph
 * Date: 2024-09-30
 * Time: 09:20:31
 */
public class Tools {
        public static int convertDurationToMinutes(String duration) {
            String[] parts = duration.split(" ");
            int hours = 0;
            int minutes = 0;

            for (String part : parts) {
                if (part.endsWith("h")) {
                    hours = Integer.parseInt(part.substring(0, part.length() - 1));
                } else if (part.endsWith("m")) {
                    minutes = Integer.parseInt(part.substring(0, part.length() - 1));
                }
            }

            return hours * 60 + minutes;
        }

    public static AudioBook getLongestAudioBook(List<AudioBook> audioBooks) {
        return audioBooks.stream()
                .max(Comparator.comparingInt(a -> convertDurationToMinutes(a.getLength())))
                .orElse(null);
    }

    }