package fr.cnam.nfp121.tp10;

import org.junit.Before;

public class concertListingTest extends ListingTest {

    @Override
    @Before
    public void setUp() {

        this.listing = new ListingImpl();
        super.setUp();
    }
}
