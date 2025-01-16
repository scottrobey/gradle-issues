package org.example.gradle6;


import java.util.Collection;

import org.junit.Test;

import static java.util.Optional.empty;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProductionTest {
    Production production = new Production();

    @Test
    public void testProductionClazz() {
        Collection<String> result = production.doSomething();
        assertThat( result, is( not( empty() ) ) );
    }
}
