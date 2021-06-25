import br.com.codenation.model.FootballTeam;
import model.FootballTeam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Teste {
    public static void main(String[] args) {
        List<FootballTeam> arrayTeams = new ArrayList<>();
        FootballTeam team = new FootballTeam(10L,"ooo", LocalDate.now(),"blue","red");
        arrayTeams.add(team);

        if (arrayTeams.size() > 0) {
            FootballTeam team1 = new FootballTeam(12L,"ooo", LocalDate.now(),"blue","red");
            for (int i = 0; i < arrayTeams.size(); i++ ) {
                if (arrayTeams.get(i).getId() == team1.getId()) {
                    System.out.println("ja adicionado");
                    break;
                } else {
                    arrayTeams.add(team1);

                    System.out.println(arrayTeams);
                }
            }
        }



        }
    }
