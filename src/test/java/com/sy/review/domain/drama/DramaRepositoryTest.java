package com.sy.review.domain.drama;

import com.sy.review.domain.Channel;
import com.sy.review.domain.OTT;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Set;

@EnableJpaAuditing
@ActiveProfiles("local")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class DramaRepositoryTest {
    @Autowired
    DramaRepository dramaRepository;

    @BeforeEach
    public void setup() {
        Drama drama = new Drama();
        drama.setDirector("abd");
        drama.setOttPlatforms(Set.of(OTT.NETFLIX, OTT.TVING));
        drama.setChannelPlatforms(Sets.of(Channel.KBS, Channel.MBC));
        dramaRepository.saveAndFlush(drama);
    }

    @Commit
    @Test
    public void 생성() {
        List<Drama> d = dramaRepository.findAll();
        Drama drama = d.get(0);
        System.out.println(drama.getChannelPlatforms());
        System.out.println(drama.getChannelPlatforms().size());
    }
}