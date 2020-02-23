package fr.cnam.nfp121.partiel;

import org.junit.Assert;
import org.junit.Test;

public abstract class CatalogTest {
    private static final double epsilon = Double.MIN_VALUE;
    protected Catalog emptyCatalog;
    private Catalog defaultCatalog = Catalog.buildDefaultCatalog();

    @Test(expected = IllegalArgumentException.class)
    public void testGetSeriesByNullName1() {
        this.emptyCatalog.getSeriesForName(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetSeriesByNullName2() {
        this.defaultCatalog.getSeriesForName(null);
    }

    @Test
    public void testGetSeriesWithEmptyCatalog() {
        Assert.assertNull("Empty catalog should always null",
                this.emptyCatalog.getSeriesForName("The Running Dead - S3"));
    }

    @Test
    public void testGetSeriesWithDefaultCatalog() {
        String seriesName = (String) Catalog.catalogExampleData[0][0];
        Assert.assertNotNull("“" + seriesName + "” should be present in the default catalog",
                this.defaultCatalog.getSeriesForName(seriesName));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewSeriesWithNullName() {
        this.emptyCatalog.newSeries(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewSeriesWithNoEpisode() {
        this.emptyCatalog.newSeries("Tutturu", 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewSeriesWithNegativeNumberOfEpisode() {
        this.emptyCatalog.newSeries("Tutturu", -3);
    }

    @Test
    public void testBrandNewSeries() {
        String seriesName = (String) Catalog.catalogExampleData[0][0];
        this.emptyCatalog.newSeries(seriesName, 3);
        Assert.assertNotNull("“" + seriesName + "” should be present in the catalog after having been added",
                this.emptyCatalog.getSeriesForName(seriesName));
    }

    @Test(expected = IllegalStateException.class)
    public void testNotNewSeries1() {
        String seriesName = (String) Catalog.catalogExampleData[0][0];
        this.defaultCatalog.newSeries(seriesName, 3);
    }

    @Test(expected = IllegalStateException.class)
    public void testNotNewSeries2() {
        String seriesName = (String) Catalog.catalogExampleData[0][0];
        this.emptyCatalog.newSeries(seriesName, 3);
        this.emptyCatalog.newSeries(seriesName, 10);
    }

    @Test
    public void testPermissiveCatalog() {
        String seriesName = (String) Catalog.catalogExampleData[0][0];
        Series series = this.emptyCatalog.newSeries(seriesName, 3);
        Series series2 = this.emptyCatalog.getSeriesForName(seriesName);
        Assert.assertEquals("The catalog should not create copies of series",
                series, series2);
        series.watch(10);
        Series series3 = this.emptyCatalog.getSeriesForName(seriesName);
        Assert.assertEquals("The catalog should not create copies of series",
                1, series3.getProgression());
        Assert.assertEquals("The catalog should not create copies of series",
                10, series3.getScore(), epsilon);
    }
}
