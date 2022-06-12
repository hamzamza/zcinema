package compgc01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    static Parent root;
    static Stage primaryStage;
    static Main m = null;
    static User currentUser;

    static String currnetfilmtiltle = "", selectedDate = "", selectedTime = "";

    
    static String stars = "";
    static String comment = "";
    static String experience = "";
    static String feedbackFilmTitle = "";

    // arrayLists to be populated with the information from the text files
    static ArrayList<Film> films = new ArrayList<>();


    /**
     * The main method. It checks whether the designed files exist. If not, it generates them.
     * Then, the first scene is launched.
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println(getPath());
        m = new Main();
        // if files do not exist, create them using default values
        try {

            if (!(new File(URLDecoder.decode(getPath() + "res/filmsJSON.txt", "UTF-8")).exists()))
                createJSONFile("films");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        launch(args);
    }


    static ArrayList<Film> getFilmList() {
        return films;
    }





    static void resetFilmList() {

        films.clear();
    }



    static Main getMainApplication() {

        return m;
    }

    static JSONObject readJSONFile(String file) {

        JSONObject items = null;

        try {
            String path = getPath();

            path = URLDecoder.decode(path + "res/" + file, "UTF-8");

            JSONParser parser = new JSONParser();
            items =  (JSONObject) parser.parse(new FileReader(path));
            for (Object s : items.keySet()) {
                //System.out.println((String) s);
                JSONObject item = (JSONObject) items.get(s);

                    String[] times = {(String) item.get("time1"), (String) item.get("time2"), (String) item.get("time3")};
                    films.add( new Film ((String) s, (String) item.get("description"), (String) item.get("trailer"), (String) item.get("startDate"), (String) item.get("endDate"), times));


            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return items;
    }


    static void modifyJSONFile(String file, String identifier, String attribute, String newValue) {

        try {
            JSONObject items = readJSONFile(file);

            if (newValue.equals("delete")) {
                items.remove(identifier);
                // System.out.println(items.toJSONString());
            }
            else {
                JSONObject itemToEdit = null;

                if (items.get(identifier) == null) {
                    itemToEdit = new JSONObject();
                    items.put(identifier, itemToEdit);
                }
                else
                    itemToEdit = (JSONObject) items.get(identifier);

                itemToEdit.put(attribute, newValue);
            }

            String path = URLDecoder.decode(getPath() + "res/" + file, "UTF-8");
            // System.out.println(path);

            File jsonFile = new File(path);
            PrintWriter writer = new PrintWriter(jsonFile);
            writer.print(items.toJSONString());
            writer.close();

            // System.out.println("-- updated file successfully --");

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    static void createJSONFile(String films) {

        try {
            // creating JSON files
            String path = getPath();
            JSONObject items = new JSONObject();


                path = URLDecoder.decode(path + "res/filmsJSON.txt", "UTF-8");
                JSONObject titanic = new JSONObject();
                titanic.put("title", "Titanic");
                titanic.put("description", "A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic.");
                titanic.put("trailer", "https://www.youtube.com/watch?v=2e-eXJ6HgkQ");
                titanic.put("startDate", "2018-01-05");
                titanic.put("endDate", "2018-01-18");
                titanic.put("time1", "20:00");
                titanic.put("time2", "19:00");
                titanic.put("time3", "hh:mm");
                items.put("Titanic", titanic);




           // System.out.println(items.toJSONString());

            File file = new File(path);
            PrintWriter writer = new PrintWriter(file);
            writer.print(items.toJSONString());
            writer.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    static String getPath() {

        String path = ClassLoader.getSystemClassLoader().getResource(".").getPath();


        if (path.contains("zcinema/bin"))
            path = path.split("zcinema")[0];

        return path;
    }

    static User getCurrentUser() {

        return currentUser;
    }

    static void setCurrentUser(User currentUser) {

        Main.currentUser = currentUser;
    }







    static Film getFilmByTitle(String title) {

        for (Film film : Main.getFilmList()) {
            if (film.getTitle().equals(title))
                return film;
        }

        return null;
    }

    static void setSelectedFilmTitle(String selectedFilmTitle) {

        Main.currnetfilmtiltle = selectedFilmTitle;
    }

    static String getSelectedFilmTitle() {

        return currnetfilmtiltle;
    }

    static void setSelectedDate(String selectedDate) {

        Main.selectedDate = selectedDate;
    }

    static String getSelectedDate() {

        return selectedDate;
    }

    static void setSelectedTime(String selectedTime) {

        Main.selectedTime = selectedTime;
    }

    static String getSelectedTime() {

        return selectedTime;
    }




    static Parent getRoot() {

        return root;
    }

    static void setRoot(Parent root) {

        Main.root = root;
    }

    static Stage getStage() {

        return primaryStage;
    }

    static void setStage(Stage stage) {

        Main.primaryStage = stage;
    }

    @Override
    public void start(Stage primaryStage) {

        try {
            // setting up the login scene
            root = FXMLLoader.load(getClass().getResource("/scenes/LoginScene.fxml"));
            Main.primaryStage = primaryStage;
            primaryStage.setTitle("Cinema for life");
            primaryStage.initStyle(StageStyle.UNDECORATED);
            Scene scene = new Scene(root, 700, 400);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}