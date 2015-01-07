package Game;

public class Game implements Comparable<Game> {

    private String title;
    private String developer;
    private String platform;
    private int age;

    public Game(String title, String developer, String platform, int age) {
        super();
        this.title = title;
        this.developer = developer;
        this.platform = platform;
        this.age = age;
    }

    public String getTitle() {
        return title;
    }

    public String getDeveloper() {
        return developer;
    }

    public String getPlatform() {
        return platform;
    }

    public int getAge() {
        return age;
    }
    
    public int esIgual(Game g){ //Es igual para insertar
    if (g.getTitle().equals(title) && g.getPlatform().equals(platform)) {
            return 0;
    }
    return -1;
    }

    public int compareTo(Game g) {//Modifique adecuadamente este método
        if(g.getTitle().compareTo(title) != 0){
            return g.getTitle().compareTo(title);
        }else{
            return g.getPlatform().compareTo(platform);
        }
    }
}
