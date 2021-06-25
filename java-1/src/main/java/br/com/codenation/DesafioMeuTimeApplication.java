package br.com.codenation;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;
import br.com.codenation.model.FootballPlayer;
import br.com.codenation.model.FootballTeam;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class DesafioMeuTimeApplication implements MeuTimeInterface {
	ArrayList<FootballTeam> arrayTeams = new ArrayList<>();
	ArrayList<FootballPlayer> arrayPlayers= new ArrayList<>();

	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		FootballTeam footTeam = new FootballTeam(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);

			for (int i = 0; i < arrayTeams.size(); i++) {
				if (arrayTeams.get(i).getId().equals(footTeam.getId())) {
					System.out.println(arrayTeams);
					throw new IdentificadorUtilizadoException();
				}

		}
		arrayTeams.add(footTeam);
		System.out.println(arrayTeams);
	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		FootballPlayer footPlayer = new FootballPlayer(id, idTime, nome, dataNascimento, nivelHabilidade, salario);

			for (int i = 0; i < arrayPlayers.size(); i++) {
				if (arrayPlayers.get(i).getId().equals(footPlayer.getId())) {
					throw new IdentificadorUtilizadoException();
				} else if (arrayPlayers.get(i).getIdTime() == null) {
					throw new TimeNaoEncontradoException();
				}
			}
			arrayPlayers.add(footPlayer);
		System.out.println(arrayPlayers);
	}

	public void definirCapitao(Long idJogador) {
		for (FootballPlayer player : arrayPlayers) {
			player.setCap(false);
			if (player.getId().equals(idJogador)) {
				player.setCap(true);
			} else {
				throw new JogadorNaoEncontradoException();
			}
		}
	}

	public Long buscarCapitaoDoTime(Long idTime) {
		Long idCapitao = 0L;
		for (FootballPlayer player : arrayPlayers) {
			if (player.getIdTime().equals(idTime)) {
				for (FootballPlayer footballPlayer : arrayPlayers) {
					if (footballPlayer.getCap()) {
						idCapitao = footballPlayer.getId();
					} else {
						throw new CapitaoNaoInformadoException();
					}
				}
			} else {
				throw new TimeNaoEncontradoException();
			}
		}
		return idCapitao;

	}

	public String buscarNomeJogador(Long idJogador) {
		String nome = "";
		for ( FootballPlayer player : arrayPlayers) {
			if (player.getId().equals(idJogador)) {
				nome = player.getNome();
			} else {
				throw new JogadorNaoEncontradoException();
			}
		}
		return nome;
	}

	public String buscarNomeTime(Long idTime) {
		String nomeTime = "";
		for (FootballTeam team : arrayTeams) {
			if (team.getId().equals(idTime)) {
				nomeTime = team.getNome();
			} else {
				throw new TimeNaoEncontradoException();
			}
		}
		return nomeTime;
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		List<Long> players = new ArrayList<>();
		for (FootballPlayer player : arrayPlayers) {
			if (player.getIdTime().equals(idTime)) {
				players.add(player.getId());
			} else {
				throw new TimeNaoEncontradoException();
			}
		}
		return players;
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		List<FootballPlayer> sameTeamPlayers = new ArrayList<>();

		for ( FootballPlayer player : arrayPlayers) {
			if ( player.getIdTime().equals(idTime)) {
				sameTeamPlayers.add(player);
			}
		}
		Long bestPlayer = sameTeamPlayers.get(0).getId();

		for (int i = 0; i< sameTeamPlayers.size(); i++) {
			Integer level = sameTeamPlayers.get(0).getNivelHabilidade();
			if (sameTeamPlayers.get(i).getNivelHabilidade() > level) {
				bestPlayer = sameTeamPlayers.get(i).getId();
			}
		}
		return bestPlayer;
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		List<FootballPlayer> sameTeamPlayers = new ArrayList<>();

		for ( FootballPlayer player : arrayPlayers) {
			if ( player.getIdTime().equals(idTime)) {
				sameTeamPlayers.add(player);
			}
		}

		Long oldestPlayer = sameTeamPlayers.get(0).getId();
		LocalDate today = LocalDate.now();

		for (int i = 0; i< sameTeamPlayers.size(); i++) {
			Period currOldest = Period.between(sameTeamPlayers.get(0).getDataNascimento(), today);
			Period eachOldest = Period.between(sameTeamPlayers.get(i).getDataNascimento(), today);
			if ( eachOldest.getYears() > currOldest.getYears()) {
				oldestPlayer = sameTeamPlayers.get(i).getId();
			}
		}
		System.out.println(oldestPlayer);
		return oldestPlayer;
	}

	public List<Long> buscarTimes() {
		List<Long> newTeams = new ArrayList<>();
		for ( FootballTeam team : arrayTeams) {
			newTeams.add(team.getId());
		}
		return newTeams;
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		List<FootballPlayer> sameTeamPlayers = new ArrayList<>();

		for ( FootballPlayer player : arrayPlayers) {
			if ( player.getIdTime().equals(idTime)) {
				sameTeamPlayers.add(player);
			}
		}

		Long wealthierPlayer = sameTeamPlayers.get(0).getId();

		for (int i = 0; i< sameTeamPlayers.size(); i++) {
			BigDecimal salary = sameTeamPlayers.get(0).getSalario();
			if (sameTeamPlayers.get(i).getSalario().compareTo(salary) > 0) {
				wealthierPlayer = sameTeamPlayers.get(i).getId();
			}
		}

		return wealthierPlayer;
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		BigDecimal salary = BigDecimal.ZERO;
		for (int i = 0; i< arrayPlayers.size(); i++) {
			if (arrayPlayers.get(i).getId().equals(idJogador)) {
				salary = arrayPlayers.get(i).getSalario();
			}
		}
		return salary;
	}

	public List<Long> buscarTopJogadores(Integer top) {
		List<Long> topPlayers = new ArrayList<>();

			for (int i = 0; i< top; i++) {
				Long playerId = arrayPlayers.get(0).getId();
				for (int j = 0; j < arrayPlayers.size(); j++) {
					Integer level = arrayPlayers.get(0).getNivelHabilidade();
					if (arrayPlayers.get(j).getNivelHabilidade() > level) {
						playerId = arrayPlayers.get(j).getId();
						FootballPlayer player = arrayPlayers.get(j);
						arrayPlayers.remove(player);
					}
				}
				topPlayers.add(playerId);
			}
		System.out.println(topPlayers);
		return topPlayers;
	}
}
