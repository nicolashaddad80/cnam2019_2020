package fr.cnam.nfp121.partiel;

import org.junit.Before;

public class CatalogImplTest extends CatalogTest {
    @Before
    public void setUp() {
        this.emptyCatalog = new CatalogImpl();
    }
}
