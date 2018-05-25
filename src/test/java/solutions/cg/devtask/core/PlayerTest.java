package solutions.cg.devtask.core;

import static io.dropwizard.testing.FixtureHelpers.*;
import static org.assertj.core.api.Assertions.assertThat;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PlayerTest {
    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws Exception {
        final Player player = new Player(1, "Rotem Wald");

        final String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/player.json"), Player.class));

        assertThat(MAPPER.writeValueAsString(player)).isEqualTo(expected);
    }

    @Test
    public void deserializesFromJSON() throws Exception {
        final Player player = new Player(1, "Rotem Wald");
        assertThat(MAPPER.readValue(fixture("fixtures/player.json"), Player.class))
                .isEqualTo(player);
    }
}
