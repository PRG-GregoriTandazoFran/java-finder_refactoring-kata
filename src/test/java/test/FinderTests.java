package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import algorithm.F;
import algorithm.OPTION;
import algorithm.Finder;
import algorithm.Persona;

public class FinderTests {

    Persona sue   = new Persona();
    Persona greg  = new Persona();
    Persona sarah = new Persona();
    Persona mike  = new Persona();

    @Before
    public void setup() {
        sue.setName( "Sue" );
        sue.setBirthDate( new Date( 50, 0, 1 ) );
        greg.setName( "Greg" );
        greg.setBirthDate( new Date( 52, 5, 1 ) );
        sarah.setName( "Sarah" );
        sarah.setBirthDate( new Date( 82, 0, 1 ) );
        mike.setName( "Mike" );
        mike.setBirthDate( new Date( 79, 0, 1 ) );
    }

    @Test
    public void Returns_Empty_Results_When_Given_Empty_List() {
        List<Persona> list   = new ArrayList<Persona>();
        Finder        finder = new Finder( list );

        F result = finder.Find( OPTION.One );
        assertEquals( null, result.P1 );

        assertEquals( null, result.P2 );
    }

    @Test
    public void Returns_Empty_Results_When_Given_One_Person() {
        List<Persona> list = new ArrayList<Persona>();
        list.add( sue );

        Finder finder = new Finder( list );

        F result = finder.Find( OPTION.One );

        assertEquals( null, result.P1 );
        assertEquals( null, result.P2 );
    }

    @Test
    public void Returns_Closest_Two_For_Two_People() {
        List<Persona> list = new ArrayList<Persona>();
        list.add( sue );
        list.add( greg );
        Finder finder = new Finder( list );

        F result = finder.Find( OPTION.One );

        assertEquals( sue, result.P1 );
        assertEquals( greg, result.P2 );
    }

    @Test
    public void Returns_Furthest_Two_For_Two_People() {
        List<Persona> list = new ArrayList<Persona>();
        list.add( mike );
        list.add( greg );

        Finder finder = new Finder( list );

        F result = finder.Find( OPTION.Two );

        assertEquals( greg, result.P1 );
        assertEquals( mike, result.P2 );
    }

    @Test
    public void Returns_Furthest_Two_For_Four_People() {
        List<Persona> list = new ArrayList<Persona>();
        list.add( sue );
        list.add( sarah );
        list.add( mike );
        list.add( greg );
        Finder finder = new Finder( list );

        F result = finder.Find( OPTION.Two );

        assertEquals( sue, result.P1 );
        assertEquals( sarah, result.P2 );
    }

    @Test
    public void Returns_Closest_Two_For_Four_People() {
        List<Persona> list = new ArrayList<Persona>();
        list.add( sue );
        list.add( sarah );
        list.add( mike );
        list.add( greg );

        Finder finder = new Finder( list );

        F result = finder.Find( OPTION.One );

        assertEquals( sue, result.P1 );
        assertEquals( greg, result.P2 );
    }

}
