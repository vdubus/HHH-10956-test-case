package com.github.vdubus.hibernate;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * Base class for test which configure the runner and make sure to run them in {@link fr.univvalenciennes.dematom.util.Profiles#TEST} profile.
 *
 * @author vdubus
 */
@SpringBootTest
@SpringJUnitConfig
@ActiveProfiles("test")
public abstract class AbstractTest {

}
