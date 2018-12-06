package com.github.vdubus.hibernate.domain.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.github.vdubus.hibernate.AbstractTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

@Rollback
@Transactional
public class MissionRepositoryTest extends AbstractTest {

	private final EntityManager entityManager;

	private final MissionRepository repository;

	private Agent jdoe;

	@Autowired
	public MissionRepositoryTest(final EntityManager entityManager, final MissionRepository repository) {
		this.entityManager = entityManager;
		this.repository = repository;
	}

	@BeforeEach
	public void prepare() {
		final Agent agent = new Agent();
		agent.setLogin("jdoe");
		agent.setFirstName("John");
		agent.setLastName("Doe");

		this.entityManager.persist(agent);
		this.entityManager.flush();
		this.entityManager.refresh(agent);
		this.jdoe = agent;
	}

	@Test
	@DisplayName("save – Nominal test case")
	public void save() {
		final Mission mission = new Mission();
		mission.setCity("New York");
		mission.setDateStart(LocalDateTime.of(2018, 12, 5, 7, 30));
		mission.setDateEnd(LocalDateTime.of(2018, 12, 6, 18, 30));
		mission.setAgent(this.jdoe);

		final Mission result = this.repository.save(mission);
		assertNotNull(result.getId());
		assertNotNull(result.getAgent());
		assertEquals("New York", result.getCity());
		assertEquals(LocalDateTime.of(2018, 12, 5, 7, 30), result.getDateStart());
		assertEquals(LocalDateTime.of(2018, 12, 6, 18, 30), result.getDateEnd());

		final Agent agent = mission.getAgent();
		assertEquals("jdoe", agent.getLogin());
		assertEquals("John", agent.getFirstName());
		assertEquals("Doe", agent.getLastName());
	}
}
