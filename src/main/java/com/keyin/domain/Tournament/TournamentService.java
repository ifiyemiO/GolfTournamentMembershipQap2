package com.keyin.domain.Tournament;

import com.keyin.domain.Member.Member;
import com.keyin.domain.Tournament.Tournament;
import com.keyin.domain.Tournament.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    /**
     * Add a new tournament.
     * @param tournament The tournament to be added.
     * @return The saved tournament.
     */
    public Tournament addTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    /**
     * Retrieve all tournaments.
     * @return A list of all tournaments.
     */
    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    /**
     * Retrieve a tournament by ID.
     * @param id The ID of the tournament.
     * @return An Optional containing the tournament if found, or empty if not.
     */
    public Optional<Tournament> getTournamentById(Long id) {
        return tournamentRepository.findById(id);
    }

    /**
     * Search tournaments by start date.
     * @param startDate The start date to search for.
     * @return A list of tournaments with the matching start date.
     */
    public List<Tournament> searchTournamentsByStartDate(LocalDate startDate) {
        return tournamentRepository.findByStartDate(startDate);
    }

    /**
     * Search tournaments by location.
     * @param location The location to search for.
     * @return A list of tournaments at the matching location.
     */
    public List<Tournament> searchTournamentsByLocation(String location) {
        return tournamentRepository.findByLocation(location);
    }

    /**
     * Add members to a tournament.
     * @param tournamentId The ID of the tournament.
     * @param members A list of members to add to the tournament.
     * @return The updated tournament.
     */
    public Tournament addMembersToTournament(Long tournamentId, List<Member> members) {
        Tournament tournament = tournamentRepository.findById(tournamentId)
                .orElseThrow(() -> new RuntimeException("Tournament not found with ID: " + tournamentId));

        tournament.getParticipatingMembers().addAll(members);
        return tournamentRepository.save(tournament);
    }

    /**
     * Get all members participating in a specific tournament.
     * @param tournamentId The ID of the tournament.
     * @return A list of members participating in the tournament.
     */
    public List<Member> getMembersInTournament(Long tournamentId) {
        Tournament tournament = tournamentRepository.findById(tournamentId)
                .orElseThrow(() -> new RuntimeException("Tournament not found with ID: " + tournamentId));

        return tournament.getParticipatingMembers();
    }

    /**
     * Delete a tournament by ID.
     * @param id The ID of the tournament to delete.
     */
    public void deleteTournamentById(Long id) {
        if (tournamentRepository.existsById(id)) {
            tournamentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Tournament not found with ID: " + id);
        }
    }
}
