package Game;

import java.util.*;

public class RegisteredGames {

    private ArrayList<Game> listGames;

    public RegisteredGames() { //Añada lo que crea oportuno
        listGames = new ArrayList<Game>();
    }

    public boolean add(Game g) {//No se admiten valores iguales
        for (Game unJuego : listGames) {
            if (unJuego.esIgual(g) == 0) {
                return false;
            }
        }
        listGames.add(g);
        return true;
    }

    public void setOrder(int o) {//o=0 por título+plataforma, o=1 Por edad, título y plataforma
        if(o==0){
            Collections.sort((List<Game>) listGames);
        }
        if(o==1){
            Collections.sort(listGames, new Comparator<Game>() {

                @Override
                public int compare(Game o1, Game o2) {
                    if(o1.getAge()> o2.getAge() ){
                         return -1; 
                    }else if(o1.getAge()> o2.getAge() ){
                        return 1;
                    }else if(o1.getAge() == o2.getAge()){
                        if(o1.getTitle().compareTo(o2.getTitle()) != 0){
                            return o1.getTitle().compareTo(o2.getTitle());
                        }else{
                            return o2.getPlatform().compareTo(o1.getPlatform());
                        }
                    }else{
                        return 0;
                    }
                }
            });
        }
    }

    public List<Game> getList() {//Listado juegos en el orden establecido en setOrder
        return (List<Game>) listGames;
    }

    public Set<String> getListPlatforms() {//Listado de ristras de la forma "plataformas: número de juegos en ella"
        Set<String> result = new HashSet<>();
        Map<String, Integer> listMap = getMapPlataform();
        for (String key : listMap.keySet()) {
            result.add(key + " : " + listMap.get(key));
        }
        return result;
    }

//devuelve un map con las plataformas y la cantidad de elemntos que tiene
    private Map<String, Integer> getMapPlataform() {
        Map<String, Integer> listMap = new HashMap<>();
        for (Game aGame : listGames) {
            String plataform = aGame.getPlatform();
            if (!listMap.containsKey(plataform)) {
                listMap.put(plataform, 1);
            } else {
                listMap.put(plataform, (listMap.get(plataform)) + 1);
            }
        }
        return listMap;
    }

    public String toString() {//Listado de juegos en el orden establecido separados por "\n"
        String res = "";
        List<Game> lg = getList();
        if (lg != null) {
            for (Game g : getList()) {
                res += g + "\n";
            }
        }
        return res;
    }

    public void fill() {
        add(new Game("The Last of Us", "Naughty Dog", "PS3", 18));
        add(new Game("Journey", "Thatgamecompany", "PS3", 18));
        add(new Game("Call of Duty 4: Advanced Warfare", "Infinity Ward", "PS4", 18));
        add(new Game("The Elder Scrolls V: Skyrim", "Bethesda Game Studios", "PS3", 18));
        add(new Game("The Elder Scrolls V: Skyrim", "Bethesda Game Studios", "Xbox 360", 18));
        add(new Game("Mass Effect 2", "BioWare", "PS3", 18));
        add(new Game("Mass Effect 2", "BioWare", "Xbox 360", 18));
        add(new Game("Super Mario 3D World", "Nintendo", "Wii U", 3));
        add(new Game("Skylanders: Giants", "Toys for Bob", "Wii U", 7));
        add(new Game("Skylanders: Giants", "Toys for Bob", "PS3", 7));
        add(new Game("Skylanders: Giants", "Toys for Bob", "XBox 360", 7));
        add(new Game("Grand Theft Auto V", "Rockstar North", "PS3", 18));
        add(new Game("Grand Theft Auto V", "Rockstar North", "PS4", 18));
        add(new Game("Grand Theft Auto V", "Rockstar North", "Xbox 360", 18));
        add(new Game("Grand Theft Auto V", "Rockstar North", "Xbox One", 18));
    }

}
