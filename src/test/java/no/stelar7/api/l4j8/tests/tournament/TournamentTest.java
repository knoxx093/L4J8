package no.stelar7.api.l4j8.tests.tournament;

import no.stelar7.api.l4j8.basic.constants.api.*;
import no.stelar7.api.l4j8.basic.constants.types.*;
import no.stelar7.api.l4j8.impl.*;
import no.stelar7.api.l4j8.pojo.match.Match;
import no.stelar7.api.l4j8.pojo.tournament.*;
import no.stelar7.api.l4j8.tests.SecretFile;
import org.junit.*;

import java.util.*;

@Ignore
public class TournamentTest
{
    
    final TournamentAPI api = new L4J8(SecretFile.CREDS).getTournamentAPI(false);
    
    
    @Test
    public void testAllRegistrations()
    {
        final ProviderRegistrationParameters params     = new ProviderRegistrationParameters(Platform.EUW1, "http://stelar7.no/loltest/provider.php");
        final long                           providerId = this.api.registerAsProvider(params);
        
        final TournamentRegistrationParameters trparams     = new TournamentRegistrationParameters("THE BEST TOURNAMENT EVER", providerId);
        final long                             tournamentId = this.api.registerTournament(trparams);
        
        final int teamSize = 5;
        
        final TournamentCodeUpdateParameters tcinner  = new TournamentCodeUpdateParameters(Arrays.asList(0L, 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L), TournamentMapType.SUMMONERS_RIFT, TournamentPickType.TOURNAMENT_DRAFT, TournamentSpectatorType.ALL);
        final TournamentCodeParameters       tcparams = new TournamentCodeParameters(tcinner, "THIS IS METADATA YOOO", teamSize);
        
        final List<String> codes = this.api.generateTournamentCodes(tcparams, tournamentId, 1);
        
        
        final TournamentCodeUpdateParameters tcuparams = new TournamentCodeUpdateParameters(Arrays.asList(10L, 20L, 30L, 40L, 50L, 60L, 70L, 80L, 90L, 100L), TournamentMapType.TWISTED_TREELINE, TournamentPickType.TOURNAMENT_DRAFT, TournamentSpectatorType.ALL);
        this.api.updateTournament(codes.get(0), tcuparams);
        
        
        final TournamentCode id = this.api.getTournamentInfo(codes.get(0));
        
        final List<LobbyEvent> events = this.api.getTournamentLobbyInfo(codes.get(0));
        
    }
    
    @Test
    public void testPostGameData()
    {
        final List<Long> tournamentCodeMatchIds = this.api.getMatchIds(Constants.TEST_TOURNAMENT_CODES[0]);
        
        final Match matchDetail = this.api.getMatchInfo(Platform.EUW1, Constants.TEST_TOURNAMENT_CODES[0], tournamentCodeMatchIds.get(0));
    }
    
    @Test
    public void testTournamentCodeGeneration()
    {
        final int                            tournamentId = 3107;
        final int                            teamSize     = 1;
        final TournamentCodeUpdateParameters inner        = new TournamentCodeUpdateParameters(Arrays.asList(19613950L, 22291359L), TournamentMapType.SUMMONERS_RIFT, TournamentPickType.TOURNAMENT_DRAFT, TournamentSpectatorType.ALL);
        final TournamentCodeParameters       params       = new TournamentCodeParameters(inner, "THIS IS METADATA YOOO", teamSize);
        final List<String>                   codes        = this.api.generateTournamentCodes(params, tournamentId, 2);
        
    }
    
    @Test
    public void testTournamentCodeGet()
    {
        final TournamentCode id = this.api.getTournamentInfo(Constants.TEST_TOURNAMENT_CODES[0]);
    }
    
    @Test
    public void testTournamentCodeUpdate()
    {
        final TournamentCodeUpdateParameters params = new TournamentCodeUpdateParameters(Arrays.asList(19613950L, 22291359L), TournamentMapType.SUMMONERS_RIFT, TournamentPickType.TOURNAMENT_DRAFT, TournamentSpectatorType.ALL);
        this.api.updateTournament(Constants.TEST_TOURNAMENT_CODES[0], params);
    }
    
    @Test
    public void testTournamentLobbyEvents()
    {
        final List<LobbyEvent> events = this.api.getTournamentLobbyInfo(Constants.TEST_TOURNAMENT_CODES[0]);
    }
    
    @Test
    public void testTournamentMatchDetails()
    {
        final Match eventWrapper = this.api.getMatchInfo(Platform.EUW1, Constants.TEST_TOURNAMENT_CODES[0], this.api.getMatchIds(Constants.TEST_TOURNAMENT_CODES[0]).get(0));
    }
    
    @Test
    public void testTournamentMatchIds()
    {
        final List<Long> eventWrapper = this.api.getMatchIds(Constants.TEST_TOURNAMENT_CODES[0]);
    }
    
    @Test
    public void testTournamentProviderRegistration()
    {
        final ProviderRegistrationParameters params = new ProviderRegistrationParameters(Platform.EUW1, "http://stelar7.no/loltest/provider.php");
        final Long                           id     = this.api.registerAsProvider(params);
    }
    
    @Test
    public void testTournamentRegistration()
    {
        final int                              providerId = 199;
        final TournamentRegistrationParameters params     = new TournamentRegistrationParameters("THE BEST TOURNAMENT EVER", providerId);
        final Long                             id         = this.api.registerTournament(params);
    }
    
    
}
