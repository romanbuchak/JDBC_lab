package ua.lviv.iot.db4.dblab4.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.lviv.iot.db4.dblab4.controller.*;
import ua.lviv.iot.db4.dblab4.domain.*;
import java.util.*;

@Component
public class MyView {
    @Autowired
    private AlbumOfSongController albumOfSongController;

    @Autowired
    private AuthorController authorController;

    @Autowired
    private DownloadController downloadController;

    @Autowired
    private GenreController genreController;

    @Autowired
    private MusicalLablesController musicalLablesController;

    @Autowired
    private ServiceUserController serviceUserController;

    @Autowired
    private SongController songController;

    final Map<String, String> menu;
    final Map<String, Printable> methodsMenu;
    final Scanner input = new Scanner(System.in);
    final AlbumOfSong nullAlbumOfSong = new AlbumOfSong(null, null, null, null);
    final Author nullAuthor = new Author(null, null, null, null, null, null);
    final Download nullDownload = new Download(null, null, null, null);
    final Genre nullGenre = new Genre(null, null);
    final MusicalLables nullMusicalLables = new MusicalLables(null, null, null, null);
    final ServiceUser nullServiceUser = new ServiceUser(null, null, null);
    final Song nullSong = new Song(null, null, null);

    public MyView() {
        menu = new LinkedHashMap<>();
        menu.put("A", "  A - Select all table");

        menu.put("1", "   1 - Table: AlbumOfSong");
        menu.put("11", "  11 - Create AlbumOfSong");
        menu.put("12", "  12 - Update AlbumOfSong");
        menu.put("13", "  13 - Delete from AlbumOfSong");
        menu.put("14", "  14 - Find all AlbumOfSongs");
        menu.put("15", "  15 - Find AlbumOfSong by ID");
        menu.put("16", "  16 - Find AlbumOfSong by name");

        menu.put("2", "   2 - Table: Author");
        menu.put("21", "  21 - Create Author");
        menu.put("22", "  22 - Update Author");
        menu.put("23", "  23 - Delete from Author");
        menu.put("24", "  24 - Find all Authors");
        menu.put("25", "  25 - Find Author by ID");
        menu.put("26", "  26 - Find Author by name");
        menu.put("27", "  27 - Find Author by email");

        menu.put("3", "   3 - Table: Download");
        menu.put("31", "  31 - Create Download");
        menu.put("32", "  32 - Update Download");
        menu.put("33", "  33 - Delete from Download");
        menu.put("34", "  34 - Find all Download");
        menu.put("35", "  35 - Find Download by ID");

        menu.put("4", "   4 - Table: Genre");
        menu.put("41", "  41 - Create Genre");
        menu.put("42", "  42 - Update Genre");
        menu.put("43", "  43 - Delete from Genre");
        menu.put("44", "  44 - Find all Genre");
        menu.put("45", "  45 - Find Genre by ID");
        menu.put("46", "  46 - Find Genre by type");

        menu.put("5", "   5 - Table: MusicalLables");
        menu.put("51", "  51 - Create MusicalLables");
        menu.put("52", "  52 - Update MusicalLables");
        menu.put("53", "  53 - Delete from MusicalLables");
        menu.put("54", "  54 - Find all MusicalLables");
        menu.put("55", "  55 - Find MusicalLables by ID");
        menu.put("56", "  56 - Find MusicalLables by name");

        menu.put("6", "   6 - Table: ServiceUser");
        menu.put("61", "  61 - Create ServiceUser");
        menu.put("62", "  62 - Update ServiceUser");
        menu.put("63", "  63 - Delete from ServiceUser");
        menu.put("64", "  64 - Find all ServiceUser");
        menu.put("65", "  65 - Find ServiceUser by ID");
        menu.put("66", "  66 - Find ServiceUser by nameOfProfile");

        menu.put("7", "   7 - Table: Song");
        menu.put("71", "  71 - Create Song");
        menu.put("72", "  72 - Update Song");
        menu.put("73", "  73 - Delete from Song");
        menu.put("74", "  74 - Find all Songs");
        menu.put("75", "  75 - Find Song by ID");
        menu.put("76", "  76 - Find Song by name");

        menu.put("Q", "  Q - exit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("A", this::selectAllTable);

        methodsMenu.put("11", this::createAlbumOfSong);
        methodsMenu.put("12", this::updateAlbumOfSong);
        methodsMenu.put("13", this::deleteFromAlbumOfSong);
        methodsMenu.put("14", this::findAllAlbumOfSong);
        methodsMenu.put("15", this::findAlbumOfSongById);
        methodsMenu.put("16", this::findAlbumOfSongByAlbumOfSongName);

        methodsMenu.put("21", this::createAuthor);
        methodsMenu.put("22", this::updateAuthor);
        methodsMenu.put("23", this::deleteFromAuthor);
        methodsMenu.put("24", this::findAllAuthors);
        methodsMenu.put("25", this::findAuthorById);
        methodsMenu.put("26", this::findAuthorByName);
        methodsMenu.put("27", this::findAuthorByEmail);

        methodsMenu.put("31", this::createDownload);
        methodsMenu.put("32", this::updateDownload);
        methodsMenu.put("33", this::deleteFromDownload);
        methodsMenu.put("34", this::findAllDownload);
        methodsMenu.put("35", this::findDownloadById);

        methodsMenu.put("41", this::createGenre);
        methodsMenu.put("42", this::updateGenre);
        methodsMenu.put("43", this::deleteFromGenre);
        methodsMenu.put("44", this::findAllGenre);
        methodsMenu.put("45", this::findGenreById);
        methodsMenu.put("46", this::findByGenreType);

        methodsMenu.put("51", this::createMusicalLables);
        methodsMenu.put("52", this::updateMusicalLables);
        methodsMenu.put("53", this::deleteFromMusicalLables);
        methodsMenu.put("54", this::findAllMusicalLables);
        methodsMenu.put("55", this::findMusicalLablesById);
        methodsMenu.put("56", this::findMusicalLablesByMusicalLablesName);

        methodsMenu.put("61", this::createServiceUser);
        methodsMenu.put("62", this::updateServiceUser);
        methodsMenu.put("63", this::deleteFromServiceUser);
        methodsMenu.put("64", this::findAllServiceUser);
        methodsMenu.put("65", this::findServiceUserById);
        methodsMenu.put("66", this::findServiceUserByServiceUserNameOfProfile);

        methodsMenu.put("71", this::createSong);
        methodsMenu.put("72", this::updateSong);
        methodsMenu.put("73", this::deleteFromSong);
        methodsMenu.put("74", this::findAllSongs);
        methodsMenu.put("75", this::findSongById);
        methodsMenu.put("76", this::findSongBySongName);

    }

    private void selectAllTable() {
        findAllAlbumOfSong();
        findAllAuthors();
        findAllDownload();
        findAllGenre();
        findAllMusicalLables();
        findAllServiceUser();
        findAllSongs();
    }

    // region ALBUMOFSONG ---------------------------------------------------
    private void createAlbumOfSong() {
        System.out.println("Input 'albumOfSong quantity': ");
        Integer quantity = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'albumOfSong name': ");
        String name = input.nextLine();
        System.out.println("Input 'albumOfSong songId': ");
        Integer songId = Integer.valueOf((input.nextLine()));
        AlbumOfSong albumOfSong = new AlbumOfSong(null, quantity, name, songId );

        int count = albumOfSongController.create(albumOfSong);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateAlbumOfSong() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'id': ");
        Integer quantity = Integer.valueOf((input.nextLine()));
        System.out.println("Input new 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'songId': ");
        Integer songId = Integer.valueOf((input.nextLine()));
        AlbumOfSong albumOfSong = new AlbumOfSong(null, quantity, name, songId );

        int count = albumOfSongController.update(id, albumOfSong);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromAlbumOfSong() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = albumOfSongController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllAlbumOfSong() {
        System.out.println("\nTable: ALBUMOFSONG");
        List<AlbumOfSong> albumOfSongs = albumOfSongController.findAll();
        for (AlbumOfSong albumOfSong : albumOfSongs) {
            System.out.println(albumOfSong);
        }
    }

    private void findAlbumOfSongById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<AlbumOfSong> albumOfSong = albumOfSongController.findById(id);
        System.out.println(albumOfSong.orElse(nullAlbumOfSong));
    }

    private void findAlbumOfSongByAlbumOfSongName() {
        System.out.println("Input 'albumOfSong name': ");
        String name = input.nextLine();

        Optional<AlbumOfSong> albumOfSong = albumOfSongController.findByAlbumName(name);
        System.out.println(albumOfSong.orElse(nullAlbumOfSong));
    }
   // ---------------------------------------------------------------------------------------

    private void createAuthor() {
        System.out.println("Input 'author name': ");
        String name = input.nextLine();
        System.out.println("Input 'author surname': ");
        String surname = input.nextLine();
        System.out.println("Input 'author gender': ");
        String gender = input.nextLine();
        System.out.println("Input 'author email': ");
        String email = input.nextLine();
        System.out.println("Input 'albumOfSong songId': ");
        Integer songId = Integer.valueOf((input.nextLine()));
        Author author = new Author(null, name, surname, gender, email, songId );

        int count = authorController.create(author);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateAuthor() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        System.out.println("Input new 'name': ");
        String name = input.nextLine();
        System.out.println("Input new 'surname': ");
        String surname = input.nextLine();
        System.out.println("Input 'gender': ");
        String gender = input.nextLine();
        System.out.println("Input 'email': ");
        String email = input.nextLine();
        System.out.println("Input 'songId': ");
        Integer songId = Integer.valueOf((input.nextLine()));
        Author author = new Author(null, name, surname, gender, email, songId);

        int count = authorController.update(id, author);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromAuthor() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = authorController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllAuthors() {
        System.out.println("\nTable: AUTHOR");
        List<Author> authors = authorController.findAll();
        for (Author author : authors) {
            System.out.println(author);
        }
    }

    private void findAuthorById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Author> author = authorController.findById(id);
        System.out.println(author.orElse(nullAuthor));
    }

    private void findAuthorByName() {
        System.out.println("Input 'author name': ");
        String name = input.nextLine();

        Optional<Author> author = authorController.findByAuthorName(name);
        System.out.println(author.orElse(nullAuthor));
    }

    private void findAuthorByEmail() {
        System.out.println("Input 'author email': ");
        String email = input.nextLine();

        Optional<Author> author = authorController.findByAuthorEmail(email);
        System.out.println(author.orElse(nullAuthor));
    }
    //---------------------------------------------------------------------------

    // region DOWNLOAD -------------------------------------------------
    private void createDownload() {
        System.out.println("Input 'downloadId': ");
        //Integer songId = Integer.valueOf((input.nextLine()));
        String songId = input.nextLine();
        System.out.println("Input 'price': ");
        Float price = Float.valueOf((input.nextLine()));
        System.out.println("Input 'quantity': ");
        Integer quantity = Integer.valueOf((input.nextLine()));

        Download download = new Download(null, songId, price, quantity);

        int count = downloadController.create(download);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateDownload() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'songId': ");
        //Integer songId = Integer.valueOf((input.nextLine()));
        String songId = input.nextLine();
        System.out.println("Input new 'price': ");
        Float price = Float.valueOf((input.nextLine()));
        System.out.println("Input 'quantity': ");
        Integer quantity = Integer.valueOf((input.nextLine()));

        Download download = new Download(null, songId, price, quantity);

        int count = downloadController.update(id, download);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromDownload() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = downloadController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllDownload() {
        System.out.println("\nTable: DOWNLOAD");
        List<Download> downloads = downloadController.findAll();
        for (Download download : downloads) {
            System.out.println(download);
        }
    }

    private void findDownloadById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Download> download = downloadController.findById(id);
        System.out.println(download.orElse(nullDownload));
    }
    //-----------------------------------------------------------------

    // region GENRE ---------------------------------------------------
    private void createGenre() {
        System.out.println("Input 'genre type': ");
        String type = input.nextLine();
        Genre genre = new Genre(null, type);

        int count = genreController.create(genre);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateGenre() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'genre type': ");
        String type = input.nextLine();
        Genre genre = new Genre(null, type);

        int count = genreController.update(id, genre);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromGenre() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = genreController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllGenre() {
        System.out.println("\nTable: GENRE");
        List<Genre> genres = genreController.findAll();
        for (Genre genre : genres) {
            System.out.println(genre);
        }
    }

    private void findGenreById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Genre> genre = genreController.findById(id);
        System.out.println(genre.orElse(nullGenre));
    }

    private void findByGenreType() {
        System.out.println("Input 'genre type': ");
        String type = input.nextLine();

        Optional<Genre> genre = genreController.findByGenreType(type);
        System.out.println(genre.orElse(nullGenre));
    }
    // ---------------------------------------------------------------------------------------

    // region MUSICALLABLES ---------------------------------------------------
    private void createMusicalLables() {
        System.out.println("Input 'musicalLables name': ");
        String name = input.nextLine();
        System.out.println("Input 'isAvard': ");
        String isAvard = input.nextLine();
        System.out.println("Input 'musicalLables songId': ");
        Integer songId = Integer.valueOf((input.nextLine()));
        MusicalLables musicalLables = new MusicalLables(null, name, isAvard, songId );

        int count = musicalLablesController.create(musicalLables);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateMusicalLables() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        System.out.println("Input new 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'isAvard': ");
        String isAvard = input.nextLine();
        System.out.println("Input 'songId': ");
        Integer songId = Integer.valueOf((input.nextLine()));
        MusicalLables musicalLables = new MusicalLables(null, name, isAvard, songId );

        int count = musicalLablesController.create(musicalLables);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromMusicalLables() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = musicalLablesController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllMusicalLables() {
        System.out.println("\nTable: MUSICALLABLES");
        List<MusicalLables> musicalLabless = musicalLablesController.findAll();
        for (MusicalLables musicalLables : musicalLabless) {
            System.out.println(musicalLables);
        }
    }

    private void findMusicalLablesById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<MusicalLables> musicalLables = musicalLablesController.findById(id);
        System.out.println(musicalLables.orElse(nullMusicalLables));
    }

    private void findMusicalLablesByMusicalLablesName() {
        System.out.println("Input 'musicalLables name': ");
        String name = input.nextLine();

        Optional<MusicalLables> musicalLables = musicalLablesController.findByMusicalLablesName(name);
        System.out.println(musicalLables.orElse(nullMusicalLables));
    }
    // --------------------------------------------------------------------------------------------------

    // region SERVICEUSER ---------------------------------------------------
    private void createServiceUser() {
        System.out.println("Input 'serviceUser nameOfProfile': ");
        String nameOfProfile = input.nextLine();
        System.out.println("Input 'serviceUser downloadId': ");
        Integer downloadId = Integer.valueOf((input.nextLine()));
        ServiceUser serviceUser = new ServiceUser(null, nameOfProfile, downloadId );

        int count = serviceUserController.create(serviceUser);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateServiceUser() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        System.out.println("Input new 'nameOfProfile': ");
        String nameOfProfile = input.nextLine();
        System.out.println("Input 'downloadId': ");
        Integer downloadId = Integer.valueOf((input.nextLine()));

        ServiceUser serviceUser = new ServiceUser(null, nameOfProfile, downloadId );

        int count = serviceUserController.create(serviceUser);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromServiceUser() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = serviceUserController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllServiceUser() {
        System.out.println("\nTable: SERVICEUSER");
        List<ServiceUser> serviceUsers = serviceUserController.findAll();
        for (ServiceUser serviceUser : serviceUsers) {
            System.out.println(serviceUser);
        }
    }

    private void findServiceUserById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<ServiceUser> serviceUser = serviceUserController.findById(id);
        System.out.println(serviceUser.orElse(nullServiceUser));
    }

    private void findServiceUserByServiceUserNameOfProfile() {
        System.out.println("Input 'nameOfProfile': ");
        String nameOfProfile = input.nextLine();

        Optional<ServiceUser> serviceUser = serviceUserController.findByServiceUserName(nameOfProfile);
        System.out.println(serviceUser.orElse(nullServiceUser));
    }
    // -------------------------------------------------------------------------------------------------

    // region SONG ---------------------------------------------------
    private void createSong() {
        System.out.println("Input 'Song name': ");
        String name = input.nextLine();
        System.out.println("Input 'song genreId': ");
        Integer genreId = Integer.valueOf((input.nextLine()));
        Song song = new Song(null, name, genreId );

        int count = songController.create(song);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateSong() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        System.out.println("Input new 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'genreId': ");
        Integer genreId = Integer.valueOf((input.nextLine()));
        Song song = new Song(null, name, genreId );

        int count = songController.create(song);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromSong() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = songController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllSongs() {
        System.out.println("\nTable: SONG");
        List<Song> songs = songController.findAll();
        for (Song song : songs) {
            System.out.println(song);
        }
    }

    private void findSongById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Song> song = songController.findById(id);
        System.out.println(song.orElse(nullSong));
    }

    private void findSongBySongName() {
        System.out.println("Input 'Song name': ");
        String name = input.nextLine();

        Optional<Song> song = songController.findBySongName(name);
        System.out.println(song.orElse(nullSong));
    }
    // ---------------------------------------------------------------------------------------

    //region OUTPUT
    private void outputMenu () {
        System.out.println("\nMENU:");
        for (String key : menu.keySet())
            if (key.length() == 1) System.out.println(menu.get(key));
    }

    private void outputSubMenu (String fig){
        System.out.println("\nSubMENU:");
        for (String key : menu.keySet())
            if (key.length() != 1 && key.substring(0, 1).equals(fig)) System.out.println(menu.get(key));
    }

    public void show () {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point:");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")) {
                outputSubMenu(keyMenu);
                System.out.println("Please, select menu point:");
                keyMenu = input.nextLine().toUpperCase();
            }

            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (!keyMenu.equals("Q"));
    }
}
